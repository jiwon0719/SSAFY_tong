<template>
  <Transition name="modal">
    <div v-if="isOpen" class="modal-overlay">
      <div class="modal-content">
        <div class="birthday-icon">🎂</div>
        <h2>생일 축하합니다!</h2>
        <p class="birthday-message">{{ user?.name }}님의 특별한 날을 진심으로 축하드립니다!</p>
        <div class="cake-animation">
          🎉 ✨ 🎈
        </div>
        <button @click="closeModal" class="close-button">감사합니다</button>
      </div>
    </div>
  </Transition>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount, watch } from 'vue'

const props = defineProps({
  user: {
    type: Object,
    default: () => ({})
  }
})

const isOpen = ref(false)
const modalTimer = ref(null)

// 날짜를 MMDD 형식으로 변환하는 함수
const getDateString = (date) => {
  const month = String(date.getMonth() + 1).padStart(2, '0')
  const day = String(date.getDate()).padStart(2, '0')
  return `${month}${day}`
}

// 저장 키 생성 함수를 더 구체적으로 수정
const getStorageKey = () => {
  const today = new Date()
  const year = today.getFullYear()
  const month = String(today.getMonth() + 1).padStart(2, '0')
  const day = String(today.getDate()).padStart(2, '0')
  return `birthday_check_${year}${month}${day}` // 매일 새로운 키 생성
}

const closeModal = () => {
  isOpen.value = false
}

const checkBirthday = () => {
  console.log('전달받은 유저 정보:', props.user);
  console.log('생일 확인 시작:', props.user?.birthday);

  if (!props.user?.birthday) {
    console.log('생일 데이터 없음');
    return;
  }

  const storageKey = getStorageKey();
  const alreadyShown = localStorage.getItem(storageKey);
  console.log('이미 표시 여부:', alreadyShown);

  // 오늘 날짜와 생일 비교
  const today = new Date();
  const todayString = getDateString(today);
  
  let birthString;
  try {
    const birthDate = new Date(props.user.birthday);
    birthString = getDateString(birthDate);
  } catch (error) {
    console.error('생일 날짜 변환 실패:', error);
    return;
  }
  
  console.log('날짜 비교:', {
    today: todayString,
    birthday: birthString
  });
  
  if (todayString === birthString && !alreadyShown) {
    console.log('생일 일치! 모달 표시 예정');
    modalTimer.value = setTimeout(() => {
      isOpen.value = true;
      localStorage.setItem(storageKey, 'shown');
    }, 700);
  }
}

// localStorage 초기화 함수 추가
const clearOldStorageKeys = () => {
  const today = new Date();
  const currentKey = getStorageKey();
  
  // localStorage에서 birthday_check로 시작하는 모든 키를 찾아서
  // 오늘 날짜의 키가 아닌 것들은 삭제
  Object.keys(localStorage).forEach(key => {
    if (key.startsWith('birthday_check_') && key !== currentKey) {
      localStorage.removeItem(key);
    }
  });
}

onBeforeUnmount(() => {
  if (modalTimer.value) {
    clearTimeout(modalTimer.value)
    modalTimer.value = null
  }
})

watch(
  () => props.user,
  (newUser) => {
    if (newUser) {
      checkBirthday()
    }
  },
  { immediate: true }
)

onMounted(() => {
  clearOldStorageKeys(); // 컴포넌트 마운트 시 이전 저장 데이터 정리
  checkBirthday();
})
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal-content {
  background: white;
  padding: 2.5rem;
  border-radius: 16px;
  text-align: center;
  min-width: 320px;
  max-width: 90%;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.15);
}

.birthday-icon {
  font-size: 3rem;
  margin-bottom: 1rem;
  animation: bounce 2s infinite;
}

.birthday-message {
  color: #666;
  margin: 1rem 0;
  font-size: 1.1rem;
}

.cake-animation {
  margin: 1.5rem 0;
  font-size: 1.5rem;
  animation: float 3s infinite;
}

.close-button {
  margin-top: 1rem;
  padding: 0.75rem 2rem;
  background-color: #FF4081;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: all 0.3s ease;
  font-size: 1rem;
  font-weight: 500;
}

.close-button:hover {
  background-color: #F50057;
  transform: translateY(-1px);
}

@keyframes bounce {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-10px); }
}

@keyframes float {
  0%, 100% { transform: translateY(0) rotate(0); }
  50% { transform: translateY(-5px) rotate(5deg); }
}

.modal-enter-active,
.modal-leave-active {
  transition: all 0.3s ease;
}

.modal-enter-from,
.modal-leave-to {
  opacity: 0;
  transform: scale(0.95);
}
</style>