<template>
  <div class="chat-container">
    <div class="chat-header">
      <h2>{{ partnerName }}</h2>
    </div>
    
    <div class="chat-messages" ref="messageContainer">
      <div v-for="(message, index) in messages" 
           :key="index" 
           :class="['message', message.senderId === userId ? 'sent' : 'received']">
        <div class="message-content">
          <div class="sender">{{ message.senderId === userId ? '나' : partnerName }}</div>
          <div class="text">{{ message.content }}</div>
          <div class="time">{{ formatTime(message.sentAt) }}</div>
        </div>
      </div>
    </div>

    <div class="chat-input">
      <input 
        v-model="newMessage" 
        @keyup.enter="sendMessage"
        placeholder="메시지를 입력하세요..."
      />
      <button @click="sendMessage">전송</button>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, onUnmounted, watch } from 'vue';
import { useUserStore } from '../stores/user';
import { useRoute } from 'vue-router';
import StompService from '../services/StompService';
import axios from 'axios';

export default {
  name: 'Chat',
  setup() {
    const route = useRoute();
    const userStore = useUserStore();
    const messages = ref([]);
    const newMessage = ref('');
    const matchingId = route.params.matchingId;
    const partnerName = route.query.partnerName;
    const userId = userStore.getUserId;

    // 이전 채팅 내역 불러오기
    const loadChatHistory = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/chat/history/${matchingId}`);
        messages.value = response.data;
      } catch (error) {
        console.error('채팅 내역 로드 실패:', error);
      }
    };

    // 메시지 전송
    const sendMessage = async () => {
      if (newMessage.value.trim()) {
        const message = {
          matchingId: matchingId,
          senderId: userId,
          content: newMessage.value,
          sentAt: new Date()
        };

        try {
          await StompService.sendMessage(`/chat/${matchingId}`, message);
          newMessage.value = '';
        } catch (error) {
          console.error('메시지 전송 실패:', error);
        }
      }
    };

    // WebSocket 연결 설정
    onMounted(async () => {
      await loadChatHistory();
      await StompService.connect();
      await StompService.subscribe(`/topic/chat/${matchingId}`, (message) => {
        messages.value.push(JSON.parse(message.body));
      });
    });

    onUnmounted(() => {
      StompService.disconnect();
    });

    return {
      messages,
      newMessage,
      sendMessage,
      userId,
      partnerName,
      formatTime: (date) => {
        return new Date(date).toLocaleTimeString('ko-KR', {
          hour: '2-digit',
          minute: '2-digit'
        });
      }
    };
  }
}
</script>

<style scoped>
.chat-container {
  height: 100vh;
  display: flex;
  flex-direction: column;
  padding: 20px;
}

.chat-header {
  padding: 10px;
  background: #f5f5f5;
  border-radius: 8px;
  margin-bottom: 20px;
}

.chat-messages {
  flex: 1;
  overflow-y: auto;
  padding: 20px;
  background: #fff;
  border-radius: 8px;
  margin-bottom: 20px;
}

.message {
  margin: 10px 0;
  max-width: 70%;
}

.message.sent {
  margin-left: auto;
}

.message.received {
  margin-right: auto;
}

.message-content {
  padding: 10px;
  border-radius: 8px;
  background: #e9ecef;
}

.message.sent .message-content {
  background: #007bff;
  color: white;
}

.sender {
  font-size: 0.8em;
  margin-bottom: 5px;
}

.time {
  font-size: 0.7em;
  text-align: right;
  margin-top: 5px;
}

.chat-input {
  display: flex;
  gap: 10px;
}

.chat-input input {
  flex: 1;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.chat-input button {
  padding: 10px 20px;
  background: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.chat-input button:hover {
  background: #0056b3;
}
</style>