<template>
  <div class="chat-container">
    <div class="chat-header">
      <h2>채팅방: {{ roomName }}</h2>
    </div>
    
    <div class="messages" ref="messageContainer">
      <div v-for="(msg, index) in messages" :key="index" class="message">
        <template v-if="msg.type === 'JOIN'">
          <div class="system-message">
            {{ msg.sender }}님이 입장하셨습니다.
          </div>
        </template>
        <template v-else>
          <div :class="['message-content', msg.sender === username ? 'my-message' : '']">
            <div class="sender">{{ msg.sender }}</div>
            <div class="text">{{ msg.content }}</div>
          </div>
        </template>
      </div>
    </div>

    <div class="input-container">
      <input 
        v-model="newMessage" 
        @keyup.enter="sendMessage"
        placeholder="메시지를 입력하세요..."
      >
      <button @click="sendMessage">전송</button>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, onUnmounted, nextTick } from 'vue';
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
    const messageContainer = ref(null);

    const scrollToBottom = async () => {
      await nextTick();
      if (messageContainer.value) {
        messageContainer.value.scrollTop = messageContainer.value.scrollHeight;
      }
    };

    const onMessageReceived = (message) => {
      console.log("onMessageReceived  에서 message 값 확인", message);
      messages.value.push(message);
      scrollToBottom();
    };

    const sendMessage = () => {
      console.log("onMessageReceived  에서 newMessage.value 값 확인", newMessage.value);
      if (newMessage.value.trim()) {
        StompService.sendMessage(props.roomId, props.username, newMessage.value);
        newMessage.value = '';
      }
    };

    onMounted(() => {
      StompService.connect(props.roomId, props.username, onMessageReceived);

      console.log("props.roomId", props.roomId);
      console.log("props.username", props.username);
      console.log("onMessageReceived", onMessageReceived);


    });

    onUnmounted(() => {
      console.log("onUnmounted 실행");
      StompService.disconnect();
    });

    return {
      messages,
      newMessage,
      sendMessage,
      messageContainer
    };
  }
}
</script>

<style scoped>
.chat-container {
  display: flex;
  flex-direction: column;
  height: 100vh;
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.chat-header {
  padding: 10px;
  background-color: #f5f5f5;
  border-radius: 8px 8px 0 0;
}

.messages {
  flex: 1;
  overflow-y: auto;
  padding: 20px;
  background-color: white;
  border: 1px solid #ddd;
}

.message {
  margin-bottom: 10px;
}

.message-content {
  max-width: 70%;
  padding: 10px;
  border-radius: 8px;
  background-color: #f0f0f0;
}

.my-message {
  margin-left: auto;
  background-color: #dcf8c6;
}

.system-message {
  text-align: center;
  color: #666;
  font-size: 0.9em;
}

.sender {
  font-size: 0.8em;
  color: #666;
  margin-bottom: 5px;
}

.input-container {
  display: flex;
  gap: 10px;
  padding: 20px;
  background-color: #f5f5f5;
  border-radius: 0 0 8px 8px;
}

input {
  flex: 1;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  padding: 10px 20px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>
