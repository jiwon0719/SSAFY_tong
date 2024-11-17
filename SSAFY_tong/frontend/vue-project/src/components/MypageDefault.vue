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
              :src="expert.userProfileImgPath || '/src/assets/images/기본프로필.jpg'" 
              class="expert-image" 
              alt="전문가 프로필"
            />
            <div class="expert-info">
              <div class="expert-header">
                <span class="expert-name">{{ expert.name }} 선생님</span>
                <span class="expert-department">{{ expert.grade }}</span>
              </div>
              <div class="matching-info">
                <div class="status">{{ expert.status === 'O' ? '매칭됨' : '매칭 대기중' }}</div>
                <div class="date">[ 요청 시점 : {{ formatDate(expert.createAt) }} ]</div>
              </div>
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
  import { ref, onMounted, watchEffect } from 'vue';
  import { useMatchingStore } from '@/stores/matching';
  import { storeToRefs } from 'pinia';
  
  // store 초기화
  const matchingStore = useMatchingStore();
  
  // store의 state를 반응형으로 가져오기
  const { matchingList, loading, error } = storeToRefs(matchingStore);
  
  // 컴포넌트 로컬 상태
  const showScoreModal = ref(false);
  const selectedExpert = ref(null);
  const tempScore = ref(0);
  const isSubmitting = ref(false);
  
  // 컴포넌트 마운트 시 데이터 로드
  onMounted(async () => {
    try {
    await matchingStore.getUserMatchings('user');
    // 각 expert 객체의 모든 속성 출력
    console.log('매칭 리스트 상세 정보:');
    matchingList.value.forEach((expert, index) => {
      console.log(`전문가 ${index + 1}:`, {
        expertId: expert.expertId,
        userId: expert.userId,
        name: expert.name,
        department: expert.department,
        location: expert.location,
        grade: expert.grade,
        userProfileImgPath: expert.userProfileImgPath,
        status: expert.status,
        createAt: expert.createAt,
        score: expert.score
      });
    });
  } catch (err) {
    console.error('매칭 목록 로드 실패:', err);
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
      userId: 'user',
      score: tempScore.value
    });

    await matchingStore.updateExpertScore(
      selectedExpert.value.expertId,
      'user',
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
  
  .expert-card {
    background: rgba(217, 217, 217, 0.32);
    border-radius: 5px;
    padding: 15px;
    margin-bottom: 20px;
  
    .expert-content {
      display: flex;
      gap: 20px;
    }
  
    .expert-image {
      width: 106px;
      height: 98px;
      border-radius: 5px;
      object-fit: cover;
    }
  
    .expert-info {
      flex: 1;
  
      .expert-header {
        display: flex;
        gap: 10px;
        align-items: center;
        margin-bottom: 10px;
  
        .expert-name {
          font-size: 16px;
          font-weight: 500;
        }
  
        .expert-department {
          color: #B0B0B0;
          font-size: 14px;
        }
      }
  
      .matching-info {
        color: #8A8A8A;
        font-size: 12px;
        margin-bottom: 15px;
      }
  
      .score-button {
        background: #E2495B;
        color: white;
        border: none;
        border-radius: 7px;
        padding: 6px 12px;
        font-size: 12px;
        cursor: pointer;
  
        &:disabled {
          background: #cccccc;
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
            
            &.active {
              color: #FFD700;
            }
          }
        }
      }
  
      .modal-actions {
        display: flex;
        justify-content: center;
        gap: 10px;
  
        button {
          padding: 8px 20px;
          border-radius: 5px;
          border: none;
          cursor: pointer;
  
          &.submit-button {
            background: #E2495B;
            color: white;
            
            &:disabled {
              background: #cccccc;
            }
          }
  
          &.cancel-button {
            background: #eee;
          }
        }
      }
    }
  }
  </style>