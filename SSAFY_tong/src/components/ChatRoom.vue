<template>
  <div class="chat-container">
    <Mascot :is-loading="isLoading" />
    <div class="chat-messages" ref="messageContainer">
      <div v-for="(message, index) in messages" :key="index" 
           :class="['message', message.role === 'user' ? 'user-message' : 'ai-message']">
        <div class="message-content">{{ message.content }}</div>
      </div>
    </div>
    
    <div class="chat-input">
      <input v-model="userInput" 
             @keydown="handleKeyPress"
             placeholder="메시지를 입력하세요..."
             :disabled="isLoading">
      <button @click="sendMessage" 
              :disabled="isLoading || !userInput.trim()">
        {{ isLoading ? '전송중...' : '전송' }}
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, nextTick } from 'vue'
import axios from 'axios'
import Mascot from './mascot.vue'

const messages = ref([])
const userInput = ref('')
const isLoading = ref(false)
const messageContainer = ref(null)

const sendMessage = async () => {
  if (!userInput.value.trim() || isLoading.value) return
  
  const userMessage = userInput.value.trim()
  messages.value.push({ role: 'user', content: userMessage })
  userInput.value = ''
  isLoading.value = true

  try {
    const loadingMessageIndex = messages.value.length
    messages.value.push({ role: 'assistant', content: '답변을 생성중입니다...' })

    const response = await axios.post('http://localhost:8080/api/ai-chat/message', {
      message: userMessage
    })
    
    messages.value[loadingMessageIndex] = { 
      role: 'assistant', 
      content: response.data.response
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

const handleKeyPress = (event) => {
  if (event.key === 'Enter' && !event.shiftKey) {
    event.preventDefault()
    sendMessage()
  }
}

onMounted(() => {
  scrollToBottom()
})

const scrollToBottom = () => {
  if (messageContainer.value) {
    messageContainer.value.scrollTop = messageContainer.value.scrollHeight
  }
}
</script>

<style scoped>
.chat-container {
  height: 80vh;
  display: flex;
  flex-direction: column;
  border: 1px solid #ccc;
  border-radius: 8px;
  padding: 20px;
}

.chat-messages {
  flex-grow: 1;
  overflow-y: auto;
  margin-bottom: 20px;
}

.message {
  margin: 10px 0;
  padding: 10px;
  border-radius: 8px;
  max-width: 70%;
}

.user-message {
  background-color: #007bff;
  color: white;
  margin-left: auto;
}

.ai-message {
  background-color: #f0f0f0;
  margin-right: auto;
}

.chat-input {
  display: flex;
  gap: 10px;
}

input {
  flex-grow: 1;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button {
  padding: 8px 16px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:disabled {
  background-color: #cccccc;
}
</style> 