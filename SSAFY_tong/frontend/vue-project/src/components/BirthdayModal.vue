<template>
  <Transition name="modal">
    <div v-if="isOpen" class="modal-overlay">
      <div class="modal-content">
        <h2>🎉 생일 축하합니다! 🎉</h2>
        <p>{{ user?.name }}님의 특별한 날을 축하드립니다!</p>
        <button @click="closeModal">닫기</button>
      </div>
    </div>
  </Transition>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const props = defineProps({
  user: {
    type: Object,
    required: true
  }
})

const isOpen = ref(false)

const closeModal = () => {
  isOpen.value = false
}

const checkBirthday = () => {
  if (!props.user?.birthday) {
    console.log('생일 정보가 없습니다');
    return;
  }

  const today = new Date()
  const birthStr = props.user.birthday
  const birthMonth = parseInt(birthStr.substring(4, 6)) - 1 // 월은 0-based
  const birthDate = parseInt(birthStr.substring(6, 8))
  
  console.log('오늘:', today.getMonth(), today.getDate())
  console.log('생일:', birthMonth, birthDate)
  
  if (today.getMonth() === birthMonth && today.getDate() === birthDate) {
    console.log('생일 매치!')
    isOpen.value = true
  }
}

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
}

.modal-content {
  background: white;
  padding: 2rem;
  border-radius: 8px;
  text-align: center;
}

.modal-enter-active,
.modal-leave-active {
  transition: opacity 0.3s;
}

.modal-enter-from,
.modal-leave-to {
  opacity: 0;
}
</style>