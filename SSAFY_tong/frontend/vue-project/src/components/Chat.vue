<template>
  <div class="chat-container">
    <div class="chat-header">
      <h2>{{ roomName }}</h2>
    </div>
    
    <div class="chat-messages" ref="messageContainer">
      <div v-for="(message, index) in messages" 
           :key="index" 
           :class="['message', message.sender === username ? 'sent' : 'received']">
        <div class="message-content">
          <div class="sender">{{ message.sender }}</div>
          <div class="text">{{ message.content }}</div>
          <div class="time">{{ formatTime(message.timestamp) }}</div>
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
import { ref, onMounted, onUnmounted } from 'vue';
import StompService from '../services/StompService';

export default {
  name: 'Chat',
  props: {
    roomId: {
      type: String,
      required: true
    },
    roomName: {
      type: String,
      required: true
    },
    username: {
      type: String,
      required: true
    }
  },
  setup(props) {
    const messages = ref([]);
    const newMessage = ref('');
    const connected = ref(false);

    const connectToChat = async () => {
      try {
        await StompService.connect(props.roomId, props.username, (message) => {
          messages.value.push(message);
        });
        console.log('채팅방 연결 성공:', props.roomId, props.username);
        connected.value = true;
      } catch (error) {
        console.error('채팅방 연결 실패:', error);
      }
    };

    const sendMessage = async () => {
      if (newMessage.value.trim()) {
        try {
          await StompService.sendMessage(props.roomId, props.username, newMessage.value);
          newMessage.value = '';
        } catch (error) {
          console.error('메시지 전송 실패:', error);
        }
      }
    };

    const formatTime = (timestamp) => {
      if (!timestamp) return '';
      const date = new Date(timestamp);
      return `${date.getHours()}:${String(date.getMinutes()).padStart(2, '0')}`;
    };

    onMounted(() => {
      console.log('Chat 컴포넌트 마운트됨:', props.roomId, props.roomName, props.username);
      connectToChat();
    });

    onUnmounted(() => {
      StompService.disconnect();
    });

    return {
      messages,
      newMessage,
      sendMessage,
      formatTime,
      connected
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