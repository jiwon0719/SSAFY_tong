<template>
  <div :class="darkModeClass" class="chatting-room">
    <div class="chat-header">
      <div class="header-left">
        <div class="header-info">
          <span class="chat-title">통키</span>
          <span class="status-text">{{ isLoading ? '입력 중...' : '대기 중' }}</span>
        </div>
      </div>
      <button @click="toggleDarkMode" class="toggle-btn">
        <i class="fas" :class="darkMode ? 'fa-sun' : 'fa-moon'"></i>
        {{ darkMode ? "Light Mode" : "Dark Mode" }}
      </button>
    </div>

    <div class="chat-messages" ref="messageContainer">
      <div class="welcome-message" v-if="messages.length === 0">
        <div class="welcome-icon">👋</div>
        <h2>AI 챗봇 통키와 대화를 시작해보세요</h2>
        <p>개인정보 걱정 없이 무엇이든 물어보실 수 있습니다!</p>
      </div>

      <div v-for="(message, index) in messages" 
           :key="index" 
           :class="['message', message.role === 'user' ? 'mine' : 'other']">
        <div v-if="message.role !== 'user'" class="avatar">
          <img :src="defaultAvatar" alt="AI avatar" />
        </div>
        <div class="message-content" :class="{ 'typing': message.isTyping }">
          <div class="text" v-if="!message.isTyping">{{ message.content }}</div>
          <div class="typing-indicator" v-else>
            <span></span>
            <span></span>
            <span></span>
          </div>
        </div>
        <div class="message-time">{{ formatTime() }}</div>
      </div>
    </div>

    <div class="chat-input">
      <div class="input-wrapper">
        <input 
          v-model="userInput" 
          @keyup.enter="sendMessage"
          placeholder="메시지를 입력하세요..."
          :disabled="isLoading"
        />
        <button 
          @click="sendMessage" 
          :disabled="isLoading || !userInput.trim()"
          class="send-button"
        >
          <i class="fas fa-paper-plane"></i>
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, nextTick, computed, watch } from 'vue'
import axios from 'axios'

const messages = ref([])
const userInput = ref('')
const isLoading = ref(false)
const messageContainer = ref(null)
const darkMode = ref(false)
const defaultAvatar = "http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg"

const darkModeClass = computed(() => (darkMode.value ? "dark-mode" : ""))

const toggleDarkMode = () => {
  darkMode.value = !darkMode.value
}

// isLoading 상태 변화 감지
watch(() => isLoading.value, (newValue) => {
  console.log('ChatRoom - Loading state changed:', newValue)
})

const sendMessage = async () => {
  if (!userInput.value.trim() || isLoading.value) return
  
  const userMessage = userInput.value.trim()
  messages.value.push({ role: 'user', content: userMessage })
  userInput.value = ''
  isLoading.value = true

  try {
    const loadingMessageIndex = messages.value.length
    messages.value.push({ 
      role: 'assistant', 
      content: '답변을 생성중입니다...',
      isTyping: true 
    })

    const response = await axios.post('http://localhost:8080/api/ai-chat/message', {
      message: userMessage
    })
    
    console.log('Server response:', response.data) // 응답 데이터 확인

    // response.data 구조에 따라 올바른 값을 가져옴
    const aiResponse = response.data.response || response.data
    
    messages.value[loadingMessageIndex] = { 
      role: 'assistant', 
      content: aiResponse,
      isTyping: false
    }
  } catch (error) {
    console.error('Error details:', {
      message: error.message,
      status: error.response?.status,
      data: error.response?.data
    })
    
    messages.value.push({ 
      role: 'assistant', 
      content: '죄송합니다. 오류가 발생했습니다. 잠시 후 다시 시도해주세요.' 
    })
  } finally {
    isLoading.value = false
    await nextTick()
    scrollToBottom()
  }
}

const scrollToBottom = () => {
  if (messageContainer.value) {
    messageContainer.value.scrollTop = messageContainer.value.scrollHeight
  }
}

const formatTime = () => {
  return new Date().toLocaleTimeString('ko-KR', {
    hour: '2-digit',
    minute: '2-digit'
  });
}
</script>

<style scoped>
.chatting-room {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 800px;
  height: 80vh;
  margin: 0 auto;
  background-color: #fff;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  border-radius: 20px;
  overflow: hidden;
}

.chat-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 15px 20px;
  background-color: #fff;
  border-bottom: 1px solid #eef2f7;
}

.header-left {
  display: flex;
  align-items: center;
  gap: 12px;
}

.ai-header-avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  object-fit: cover;
  border: 2px solid #2196f3;
  padding: 2px;
}

.header-info {
  display: flex;
  flex-direction: column;
}

.chat-title {
  font-size: 1.1rem;
  font-weight: 600;
  color: #2c3e50;
}

.status-text {
  font-size: 0.8rem;
  color: #42b983;
}

.toggle-btn {
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 8px 16px;
  background-color: #f8f9fa;
  border: 1px solid #e9ecef;
  border-radius: 20px;
  color: #495057;
  font-size: 0.9rem;
  transition: all 0.3s ease;
}

.toggle-btn:hover {
  background-color: #e9ecef;
}

.chat-messages {
  flex: 1;
  padding: 20px;
  overflow-y: auto;
  background-color: #f8f9fa;
}

.welcome-message {
  text-align: center;
  padding: 40px 20px;
  color: #6c757d;
}

.welcome-icon {
  font-size: 3rem;
  margin-bottom: 20px;
  animation: wave 2s infinite;
}

@keyframes wave {
  0% { transform: rotate(0deg); }
  10% { transform: rotate(-10deg); }
  20% { transform: rotate(12deg); }
  30% { transform: rotate(-10deg); }
  40% { transform: rotate(9deg); }
  50% { transform: rotate(0deg); }
  100% { transform: rotate(0deg); }
}

.message {
  display: flex;
  align-items: flex-end;
  margin-bottom: 20px;
  gap: 8px;
  width: 100%;
  transition: all 0.3s ease;
  opacity: 1;
}

.message.mine {
  justify-content: flex-end;
  padding-left: 20%;
}

.message.other {
  justify-content: flex-start;
  padding-right: 20%;
}

.message.typing {
  opacity: 0.7;
}

.message-content {
  padding: 12px 16px;
  border-radius: 18px;
  max-width: 100%;
  position: relative;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
  word-break: break-word;
  min-height: 20px;
}

.mine .message-content {
  background-color: #2196f3;
  color: white;
  border-bottom-right-radius: 4px;
  margin-right: 8px;
}

.other .message-content {
  background-color: white;
  color: #333;
  border-bottom-left-radius: 4px;
  margin-left: 8px;
}

.message.mine .message-time {
  order: -1;
}

.message.other .message-time {
  order: 1;
}

.avatar {
  width: 35px;
  height: 35px;
  border-radius: 50%;
  overflow: hidden;
  flex-shrink: 0;
}

.avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.message-time {
  font-size: 0.75rem;
  color: #999;
  margin: 0 8px;
}

.typing-indicator {
  display: flex;
  gap: 4px;
  padding: 4px 8px;
}

.typing-indicator span {
  width: 8px;
  height: 8px;
  background-color: #90caf9;
  border-radius: 50%;
  animation: typing 1s infinite ease-in-out;
}

.typing-indicator span:nth-child(2) { animation-delay: 0.2s; }
.typing-indicator span:nth-child(3) { animation-delay: 0.4s; }

@keyframes typing {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-4px); }
}

.input-wrapper {
  display: flex;
  align-items: center;
  background-color: white;
  padding: 15px 20px;
  border-top: 1px solid #eef2f7;
  gap: 10px;
}

input {
  flex: 1;
  padding: 12px 16px;
  border: 1px solid #e0e0e0;
  border-radius: 24px;
  font-size: 0.95rem;
  transition: all 0.3s ease;
}

input:focus {
  outline: none;
  border-color: #2196f3;
  box-shadow: 0 0 0 2px rgba(33, 150, 243, 0.1);
}

.send-button {
  background-color: #2196f3;
  color: white;
  border: none;
  border-radius: 50%;
  width: 40px;
  height: 40px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.3s ease;
}

.send-button:hover {
  background-color: #1976d2;
  transform: scale(1.05);
}

.send-button:disabled {
  background-color: #e0e0e0;
  cursor: not-allowed;
  transform: none;
}

/* 다크 모드 스타일 */
.dark-mode {
  background-color: #1a1a1a;
}

.dark-mode .chat-header {
  background-color: #2d2d2d;
  border-bottom-color: #3d3d3d;
}

.dark-mode .chat-title {
  color: #fff;
}

.dark-mode .chat-messages {
  background-color: #1a1a1a;
}

.dark-mode .message.other .message-content {
  background-color: #2d2d2d;
  color: #fff;
}

.dark-mode .input-wrapper {
  background-color: #2d2d2d;
  border-top-color: #3d3d3d;
}

.dark-mode input {
  background-color: #3d3d3d;
  border-color: #4d4d4d;
  color: #fff;
}

.dark-mode input::placeholder {
  color: #888;
}

.dark-mode .toggle-btn {
  background-color: #3d3d3d;
  border-color: #4d4d4d;
  color: #fff;
}

.dark-mode .welcome-message {
  color: #bbb;
}

/* 스크롤바 스타일링 수정 */
.chat-messages::-webkit-scrollbar {
  width: 6px;
}

.chat-messages::-webkit-scrollbar-track {
  background: rgba(0, 0, 0, 0.05);
  border-radius: 4px;
}

.chat-messages::-webkit-scrollbar-thumb {
  background-color: #c0c0c0;
  border-radius: 4px;
}

.chat-messages::-webkit-scrollbar-thumb:hover {
  background-color: #a0a0a0;
}

/* 다크모드 스크롤바 */
.dark-mode .chat-messages::-webkit-scrollbar-track {
  background: rgba(255, 255, 255, 0.05);
}

.dark-mode .chat-messages::-webkit-scrollbar-thumb {
  background-color: #666;
}

.dark-mode .chat-messages::-webkit-scrollbar-thumb:hover {
  background-color: #777;
}

/* Firefox 스크롤바 스타일링 */
.chat-messages {
  scrollbar-width: thin;
  scrollbar-color: #c0c0c0 transparent;
}

.dark-mode .chat-messages {
  scrollbar-color: #666 transparent;
}

.dark-mode .message.mine .message-content {
  background-color: #2196f3;
}

.dark-mode .message.other .message-content {
  background-color: #2d2d2d;
  color: #fff;
}

.dark-mode .message.mine .avatar {
  display: none;
}

.dark-mode .message.other .avatar {
  margin-right: 8px;
}

/* 타이핑 효과 스타일 */
.typing {
  display: flex;
  align-items: center;
  gap: 5px;
}

.typing span {
  width: 8px;
  height: 8px;
  background: #666;
  border-radius: 50%;
  animation: typing 1s infinite ease-in-out;
}

.typing span:nth-child(2) {
  animation-delay: 0.2s;
}

.typing span:nth-child(3) {
  animation-delay: 0.4s;
}

@keyframes typing {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-5px); }
}

/* 메시지 전환 애니메이션 */
.message {
  transition: all 0.3s ease;
  opacity: 1;
}

.message.typing {
  opacity: 0.7;
}
</style>