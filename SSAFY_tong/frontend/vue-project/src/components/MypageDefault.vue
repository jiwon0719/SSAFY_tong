<template>
    <div class="mypagedefault">
      <div class="page-title">나의 매칭 전문가</div>
      
      <!-- 로딩 상태 표시 -->
      <div v-if="loading" class="loading">데이터를 불러오는 중...</div>
      
      <!-- 에러 메시지 표시 -->
      <div v-if="error" class="error-message">{{ error }}</div>
      

      <!-- 전체 리스트 정보 표시 -->
      <div class="debug-info" style="margin-bottom: 20px;">
          총 매칭 수: {{ matchingList.length }}
      </div>

      <!-- 전문가 리스트 영역 -->
      <template v-if="matchingList.length > 0">
        <div v-for="expert in matchingList" :key="expert.expertId" class="expert-card">
          <div class="expert-content">
            <img 
              :src="expert.userProfileImgUrl || '/src/assets/images/기본프로필.jpg'" 
              class="expert-image" 
              alt="전문가 프로필"
            />
            <div class="expert-info">
              <div class="expert-header">
                <span class="expert-name">{{ expert.name }} 선생님</span>
                <span class="expert-department">{{ expert.grade }}</span>
              </div>
              <div class="matching-info">
                <div :class="['status', expert.status === 'O' ? 'status-matched' : 'status-waiting']">
                  {{ expert.status === 'O' ? '매칭 완료' : '매칭 대기중' }}</div>
                <div class="date"> [요청일: {{ formatDate(expert.createAt) }}]</div>
              </div>
              <div class="button-container">
                <button 
                  v-if="expert.status === 'O'"
                  class="score-button" 
                  @click="openScoreModal(expert)"
                  :disabled="expert.score"
                >
                  {{ expert.score ? '평가완료' : '점수주기' }}
                </button>
              </div>
            </div>
          </div>
        </div>
      </template>
      <div v-else-if="!loading" class="no-data">
        매칭된 전문가가 없습니다.
      </div>
  
      <!-- 점수 입력 모달 -->
      <Teleport to="body">
        <div v-if="showScoreModal" class="score-modal">
          <div class="modal-content">
            <h3>{{ selectedExpert?.name }} 선생님</h3>
            <div class="rating">
              <div class="stars">
                <span 
                  v-for="n in 5" 
                  :key="n"
                  @click="selectScore(n)"
                  :class="{ 'active': tempScore >= n }"
                  class="star"
                >★</span>
              </div>
              <span class="score-text">{{ tempScore }} / 5</span>
            </div>
            <div class="modal-actions">
              <button 
                @click="submitScore" 
                :disabled="isSubmitting"
                class="submit-button"
              >
                {{ isSubmitting ? '처리중...' : '평가하기' }}
              </button>
              <button @click="closeScoreModal" class="cancel-button">취소</button>
            </div>
          </div>
        </div>
      </Teleport>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted, watchEffect, computed } from 'vue';
  import { useMatchingStore } from '@/stores/matching';
  import { useUserStore } from '@/stores/user';
  import { storeToRefs } from 'pinia';
  
  // store 초기화
  const matchingStore = useMatchingStore();
  const userStore = useUserStore();
  
  // store의 state를 반응형으로 가져오기
  const { matchingList, loading, error } = storeToRefs(matchingStore);

  const userId = computed(() => userStore.userId);

  // 컴포넌트 로컬 상태
  const showScoreModal = ref(false);
  const selectedExpert = ref(null);
  const tempScore = ref(0);
  const isSubmitting = ref(false);
  
  // 컴포넌트 마운트 시 데이터 로드
  onMounted(async () => {
    try {
      await userStore.fetchUserInfo()
  
      // 로그 확인
      // userId가 여전히 없다면 에러 처리
      if (!userId.value) {
        throw new Error('사용자 ID를 가져올 수 없습니다.');
      }

      // console.log('Fetching matchings for user:', userId.value);
      await matchingStore.getUserMatchings(userId.value);
    
      // 각 expert 객체의 모든 속성 출력
      // console.log('매칭 리스트 상세 정보:');
      matchingList.value.forEach((expert, index) => {
        // console.log(`전문가 ${index + 1}:`, expert);
      });

    } catch (err) {
      // console.error('매칭 목록 로드 실패:', err);
      error.value = '매칭 목록을 불러오는 데 실패했습니다. 다시 시도해 주세요.';
    }
});
  
// 날짜 포맷팅 함수
const formatDate = (date) => {
  const d = new Date(date);
  return `${d.getFullYear()}. ${String(d.getMonth() + 1).padStart(2, '0')}. ${String(d.getDate()).padStart(2, '0')} ${String(d.getHours()).padStart(2, '0')}:${String(d.getMinutes()).padStart(2, '0')}:${String(d.getSeconds()).padStart(2, '0')}`;
};
  
  // 점수 모달 관련 함수들
  const openScoreModal = (expert) => {
    selectedExpert.value = expert;
    tempScore.value = expert.score || 0;
    showScoreModal.value = true;
  };
  
  const closeScoreModal = () => {
    showScoreModal.value = false;
    selectedExpert.value = null;
    tempScore.value = 0;
  };
  
  const selectScore = (score) => {
    tempScore.value = score;
  };
  
  const submitScore = async () => {
  if (!selectedExpert.value || !tempScore.value) {
    alert('점수를 선택해주세요.');
    return;
  }
  
  isSubmitting.value = true;
  try {
    console.log('Submitting score:', {
      expertId: selectedExpert.value.expertId,
      userId: userId.value,
      score: tempScore.value
    });

    await matchingStore.updateExpertScore(
      selectedExpert.value.expertId,
      userId.value,
      tempScore.value
    );
    alert('평가가 완료되었습니다.');
    closeScoreModal();
  } catch (err) {
    console.error('점수 업데이트 실패:', err);
    alert('평가 중 오류가 발생했습니다. 다시 시도해주세요.');
  } finally {
    isSubmitting.value = false;
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
  
  .expert-card {
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
  
    .expert-content {
      display: flex;
      gap: 17px;
      height: 100%;
    }
  
    .expert-image {
      margin-top: 4px;
      width: 106px;
      height: 98px;
      border-radius: 5px;
      object-fit: cover;
      transition: transform 0.4s ease;
    }
  
    .expert-info {
      flex: 1;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
  
      .expert-header {
        display: flex;
        align-items: center;
        gap: 8px;
  
        .expert-name {
          margin-top: 2px;
          font-size: 20px;
          font-weight: 500;
          color: #000;
          transition: color 0.4s ease;
        }
  
        .expert-department {
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
  
      .button-container {
        margin-top: 10px;
        min-height: 36px;
        display: flex;
        align-items: flex-end;
      }
  
      .score-button {
        background: #E2495B;
        color: white;
        border: none;
        border-radius: 8px;
        padding: 8px 16px;
        font-size: 14px;
        cursor: pointer;
        transition: all 0.3s ease;
        box-shadow: 0 2px 4px rgba(226, 73, 91, 0.2);
  
        &:hover:not(:disabled) {
          background-color: #ff6b81;
          transform: translateY(-1px);
          box-shadow: 0 4px 8px rgba(226, 73, 91, 0.3);
        }
  
        &:disabled {
          background: #cccccc;
          cursor: not-allowed;
          box-shadow: none;
        }
      }
    }
  
    &:hover {
      background: rgba(217, 217, 217, 0.5);
      border-color: #E2495B;
      transform: translateY(-2px);
      box-shadow: 0 4px 12px rgba(226, 73, 91, 0.1);
  
      .expert-info {
        .matching-info {
          .status {
            font-weight: bold;
          }
        }
      }
    }
  }
  
  .score-modal {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    align-items: center;
    justify-content: center;
    z-index: 1000;
  
    .modal-content {
      background: white;
      padding: 30px;
      border-radius: 10px;
      width: 400px;
      box-shadow: 0 4px 20px rgba(0, 0, 0, 0.15);
  
      h3 {
        text-align: center;
        font-size: 20px;
        color: #333;
        margin-bottom: 20px;
      }
  
      .rating {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin: 20px 0;
  
        .stars {
          font-size: 40px;
          color: #ddd;
  
          .star {
            cursor: pointer;
            transition: color 0.3s ease;
            
            &.active {
              color: #FFD700;
            }
  
            &:hover {
              color: #FFD700;
            }
          }
        }
  
        .score-text {
          margin-top: 10px;
          font-size: 16px;
          color: #666;
        }
      }
  
      .modal-actions {
        display: flex;
        justify-content: center;
        gap: 12px;
  
        button {
          padding: 10px 24px;
          border-radius: 8px;
          border: none;
          cursor: pointer;
          font-size: 14px;
          transition: all 0.3s ease;
  
          &.submit-button {
            background: #E2495B;
            color: white;
            box-shadow: 0 2px 4px rgba(226, 73, 91, 0.2);
            
            &:hover:not(:disabled) {
              background: #ff6b81;
              transform: translateY(-1px);
            }
  
            &:disabled {
              background: #cccccc;
              cursor: not-allowed;
              box-shadow: none;
            }
          }
  
          &.cancel-button {
            background: #eee;
            color: #666;
  
            &:hover {
              background: #e0e0e0;
              transform: translateY(-1px);
            }
          }
        }
      }
    }
  }
  </style>