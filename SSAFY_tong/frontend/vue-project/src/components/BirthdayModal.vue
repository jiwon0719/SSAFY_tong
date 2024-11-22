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

// 저장 키 생성 함수
const getStorageKey = () => {
  const today = new Date()
  const year = today.getFullYear()
  return `birthday_check_${year}`
}

const closeModal = () => {
  isOpen.value = false
}

const checkBirthday = () => {
  if (!props.user?.birthday) {
    return
  }

  const storageKey = getStorageKey()
  const alreadyShown = localStorage.getItem(storageKey)

  // 오늘 날짜와 생일 비교
  const today = new Date()
  const todayString = getDateString(today)
  
  // 생일 문자열 추출 (MMDD 형식)
  const birthDate = props.user.birthday.replace(/-/g, '').slice(4, 8)
  
  if (todayString === birthDate && !alreadyShown) {
    modalTimer.value = setTimeout(() => {
      isOpen.value = true
      localStorage.setItem(storageKey, 'shown')
    }, 700)
  }
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
  checkBirthday()
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