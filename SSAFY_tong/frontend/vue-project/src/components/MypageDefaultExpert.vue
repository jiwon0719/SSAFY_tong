<template>
  <div class="mypagedefault" v-if="userMatchingList">
    <div class="page-title">나의 매칭 회원</div>
    
    <!-- 로딩 상태 표시 -->
    <div v-if="loading" class="loading">데이터를 불러오는 중...</div>
    
    <!-- 에러 메시지 표시 -->
    <div v-if="error" class="error-message">{{ error }}</div>
    
    <!-- 전체 리스트 정보 표시 -->
    <div class="debug-info" style="margin-bottom: 20px;">
        총 매칭 수: {{ userMatchingList.length }}
    </div>

    <!-- 유저 리스트 영역 -->
    <template v-if="userMatchingList.length > 0">
      <div v-for="user in userMatchingList" :key="user.userId" class="user-card">
        <div class="user-content">
          <img 
            :src="user.userProfileImgPath || '/src/assets/images/기본프로필.jpg'" 
            class="user-image" 
            alt="유저 프로필"
          />
          <div class="user-info">
            <div class="user-header">
              <span class="user-name">{{ user.name }} 님</span>
              <span class="request-type">{{ user.requestType }}</span>
            </div>
            <div class="matching-info">
              <div :class="['status', user.status === 'O' ? 'status-matched' : 'status-waiting']">
                {{ user.status === 'O' ? '매칭 완료' : '매칭 대기중' }}</div>
              <div class="date">[신청일: {{ formatDate(user.createAt) }}]</div>
            </div>
            <div class="action-buttons">
              <button 
                v-if="user.status === 'X'"
                class="accept-button" 
                @click="handleMatchingResponse(user, 'accept')"
              >
                수락하기
              </button>
              <button 
                v-if="user.status === 'X'"
                class="reject-button" 
                @click="handleMatchingResponse(user, 'reject')"
              >
                거절하기
              </button>
            </div>
          </div>
        </div>
      </div>
    </template>
    <div v-else-if="!loading" class="no-data">
      매칭 신청한 유저가 없습니다.
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, computed } from 'vue';
import { useMatchingStore } from '@/stores/matching';
import { useUserStore } from '@/stores/user';
import { storeToRefs } from 'pinia';
import axios from 'axios';

// store 초기화
const matchingStore = useMatchingStore();
const userStore = useUserStore();

// store의 state를 반응형으로 가져오기
const { userMatchingList, loading, error } = storeToRefs(matchingStore);
const { userId } = storeToRefs(userStore);
// const userId = computed(() => userStore.userId);

// userMatchingList가 undefined일 경우를 대비해 기본값 설정
if (!userMatchingList.value) {
  userMatchingList.value = [];
}

// 날짜 포맷팅 함수
const formatDate = (date) => {
  const d = new Date(date);
  return `${d.getFullYear()}. ${String(d.getMonth() + 1).padStart(2, '0')}. ${String(d.getDate()).padStart(2, '0')} ${String(d.getHours()).padStart(2, '0')}:${String(d.getMinutes()).padStart(2, '0')}:${String(d.getSeconds()).padStart(2, '0')}`;
};

// 컴포넌트 마운트 시 데이터 로드
onMounted(async () => {
  if(!userId.value) {
    await userStore.fetchUserInfo();
  }

  try {
    await matchingStore.getExpertMatchings(userId.value);
    console.log('매칭 리스트 상세 정보:', userMatchingList.value);
  } catch (err) {
    console.error('매칭 목록 로드 실패:', err);
  }
});

// 매칭 응답 처리 함수
const handleMatchingResponse = async (user, response) => {
  try {
    const status = response === 'accept' ? 'O' : 'X';
    console.log('매칭 응답 처리 시작:', { user, status });

    // store의 updateMatchingStatus 메서드 호출
    await matchingStore.updateMatchingStatus(user.userId, userId.value, status);
    
    // 나머지 로직은 store에서 처리되므로 제거
  } catch (err) {
    console.error('매칭 응답 처리 실패:', err);
    alert('처리 중 오류가 발생했습니다. 다시 시도해주세요.');
  }
};
</script>

<style lang="scss" scoped>
.mypagedefault {
  padding: 20px;
  max-width: 1200px;
  margin: 0 auto;
  font-family: 'Noto Sans KR', sans-serif;
}

.page-title {
  font-size: 24px;
  font-weight: 500;
  margin-bottom: 20px;
  color: #333;
}

.loading, .error-message, .no-data {
  text-align: center;
  padding: 20px;
  font-family: 'Noto Sans KR', sans-serif;
}

.error-message {
  color: #E2495B;
}

.user-card {
  display: block;
  padding: 14px;
  background: rgba(217, 217, 217, 0.32);
  border-radius: 5px;
  text-decoration: none;
  color: inherit;
  border: 1px solid transparent;
  cursor: pointer;
  transition: all 0.4s ease-in-out;
  margin-bottom: 20px;
  min-height: 140px;

  .user-content {
    display: flex;
    gap: 17px;
    height: 100%;
  }

  .user-image {
    margin-top: 4px;
    width: 106px;
    height: 98px;
    border-radius: 5px;
    object-fit: cover;
    transition: transform 0.4s ease;
  }

  .user-info {
    flex: 1;
    display: flex;
    flex-direction: column;
    justify-content: space-between;

    .user-header {
      display: flex;
      align-items: center;
      gap: 8px;

      .user-name {
        margin-top: 2px;
        font-size: 20px;
        font-weight: 500;
        color: #000;
        transition: color 0.4s ease;
      }

      .request-type {
        margin-top: 4px;
        margin-left: -2px;
        font-weight: 500;
        font-size: 16.5px;
        color: #777777;
      }
    }

    .matching-info {
      display: flex;
      align-items: center;
      gap: 10px;
      
      .status {
        font-size: 18.5px;
        font-weight: 500;
        color: #777777;
        transition: color 0.3s ease-in-out;
       
        &.status-matched {
          color: #4CAF50;  // 매칭 완료 시 초록색
        }

        &.status-waiting {
          color: #E2495B;  // 매칭 대기/거절 시 붉은색
        }
      }

      .date {
        margin-bottom: -2px;
        font-size: 15px;
        color: #777;
      }
    }

    .action-buttons {
      margin-top: 10px;
      min-height: 36px;
      display: flex;
      align-items: flex-end;
      gap: 12px;

      button {
        background: #E2495B;
        color: white;
        border: none;
        border-radius: 8px;
        padding: 8px 16px;
        font-size: 14px;
        cursor: pointer;
        transition: all 0.3s ease;
        box-shadow: 0 2px 4px rgba(226, 73, 91, 0.2);

        &:hover {
          background-color: #ff6b81;
          transform: translateY(-1px);
          box-shadow: 0 4px 8px rgba(226, 73, 91, 0.3);
        }

        &.reject-button {
          background: #8A8A8A;
          box-shadow: 0 2px 4px rgba(138, 138, 138, 0.2);

          &:hover {
            background-color: #999999;
            box-shadow: 0 4px 8px rgba(138, 138, 138, 0.3);
          }
        }
      }

      .matched-status {
        font-size: 16px;
        font-weight: 500;
        color: #4CAF50;
        padding: 8px 16px;
      }
    }
  }

  &:hover {
    background: rgba(217, 217, 217, 0.5);
    border-color: #E2495B;
    transform: translateY(-2px);
    box-shadow: 0 4px 12px rgba(226, 73, 91, 0.1);

    .user-info {
      .matching-info {
        .status {
          font-weight: bold;
        }
      }
    }
  }
}
</style>