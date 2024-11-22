<template>
  <div class="chat-container">
    <div class="chat-messages" ref="messageContainer">
      <div v-for="(message, index) in messages" :key="index" 
           :class="['message', message.role === 'user' ? 'user-message' : 'ai-message']">
        <div class="message-content">{{ message.content }}</div>
      </div>
    </div>
    
    <div class="chat-input">
      <input v-model="userInput" 
             @keyup.enter="sendMessage" 
             placeholder="메시지를 입력하세요..."
             :disabled="isLoading">
      <button @click="sendMessage" :disabled="isLoading">전송</button>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, nextTick } from 'vue'
import axios from 'axios'

const messages = ref([])
const userInput = ref('')
const isLoading = ref(false)
const messageContainer = ref(null)

const sendMessage = async () => {
  if (!userInput.value.trim() || isLoading.value) return
  
  const userMessage = userInput.value
  messages.value.push({ role: 'user', content: userMessage })
  userInput.value = ''
  isLoading.value = true

  try {
    const response = await axios.post(`${import.meta.env.VITE_API_BASE_URL}/api/ai-chat/message`, {
      message: userMessage
    })
    
    messages.value.push({ role: 'assistant', content: response.data })
  } catch (error) {
    console.error('Error:', error)
    messages.value.push({ role: 'assistant', content: '죄송합니다. 오류가 발생했습니다.' })
  }

  isLoading.value = false
  await nextTick()
  scrollToBottom()
}

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