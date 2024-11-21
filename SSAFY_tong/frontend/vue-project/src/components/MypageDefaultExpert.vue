<template>
  <div class="mypagedefault" v-if="userMatchingList">
    <div class="page-title">매칭 신청 목록</div>
    
    <!-- 로딩 상태 표시 -->
    <div v-if="loading" class="loading">데이터를 불러오는 중...</div>
    
    <!-- 에러 메시지 표시 -->
    <div v-if="error" class="error-message">{{ error }}</div>
    
    <!-- 전체 리스트 정보 표시 -->
    <div class="debug-info" style="margin-bottom: 20px;">
        총 매칭 신청 수: {{ userMatchingList.length }}
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
              <div class="status">{{ user.status === 'O' ? '매칭됨' : '매칭 대기중' }}</div>
              <div class="date">[ 신청일시 : {{ formatDate(user.createAt) }} ]</div>
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
              <span v-else-if="user.status === 'O'" class="matched-status">
                매칭 완료
              </span>
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

    // 매칭 상태 업데이트
    await matchingStore.updateMatchingStatus(user.userId, userId.value, status);

    // 매칭이 수락된 경우에만 환영 메시지 전송
    if (response === 'accept') {
      try {
        // 매칭 ID 조회
        const matchingResponse = await axios.get(
          `http://localhost:8080/api/matching/find/${user.userId}/${userId.value}`,
          {
            headers: {
              'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
            }
          }
        );
        
        const matchingId = matchingResponse.data;
        
        // 전문가 정보 조회
        const expertResponse = await axios.get(
          `http://localhost:8080/api/matching/expert-info/${userId.value}`,
          {
            headers: {
              'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
            }
          }
        );
        
        const expertInfo = expertResponse.data;
        
        // 환영 메시지 전송
        await axios.post(
          'http://localhost:8080/api/chat/message',
          {
            matchingId: matchingId,
            senderId: userId.value,
            content: ` 🎉✨저희 둘이 TONG했어요✨🎉
🏃드디어 찾으셨네요! 믿을 수 있는 전문가와 함께하세요‍🏃‍ 

저를 만나시려면 ${expertInfo.companyName} 로 와주세요!

직급 : ${expertInfo.grade}
주소 : ${expertInfo.address} ${expertInfo.addressDetail}
1회 가격 : ${expertInfo.price}원

문의 사항은 편하게 채팅해주세요~`,
            type: "CHAT",
            isRead: "X"
          },
          {
            headers: {
              'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
            }
          }
        );
      } catch (error) {
        console.error('환영 메시지 전송 실패:', error);
      }
    }
    
    alert(response === 'accept' ? '매칭이 수락되었습니다.' : '매칭이 거절되었습니다.');
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
}

.page-title {
  font-size: 24px;
  font-weight: 500;
  margin-bottom: 20px;
}

.loading, .error-message, .no-data {
  text-align: center;
  padding: 20px;
}

.error-message {
  color: #E2495B;
}

.user-card {
  background: rgba(217, 217, 217, 0.32);
  border-radius: 5px;
  padding: 15px;
  margin-bottom: 20px;

  .user-content {
    display: flex;
    gap: 20px;
  }

  .user-image {
    width: 106px;
    height: 98px;
    border-radius: 5px;
    object-fit: cover;
  }

  .user-info {
    flex: 1;

    .user-header {
      display: flex;
      gap: 10px;
      align-items: center;
      margin-bottom: 10px;

      .user-name {
        font-size: 16px;
        font-weight: 500;
      }

      .request-type {
        color: #B0B0B0;
        font-size: 14px;
      }
    }

    .matching-info {
      color: #8A8A8A;
      font-size: 12px;
      margin-bottom: 15px;
    }

    .action-buttons {
      display: flex;
      gap: 10px;

      button {
        border: none;
        border-radius: 7px;
        padding: 6px 12px;
        font-size: 12px;
        cursor: pointer;
      }

      .accept-button {
        background: #E2495B;
        color: white;
      }

      .reject-button {
        background: #8A8A8A;
        color: white;
      }

      .matched-status {
        color: #4CAF50;
        font-size: 14px;
        font-weight: 500;
      }
    }
  }
}
</style>