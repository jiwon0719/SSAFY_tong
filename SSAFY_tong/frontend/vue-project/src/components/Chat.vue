<template>
  <div :class="darkModeClass" class="chatting-room">
    <div class="chat-header">
      <router-link to="/chat" class="back-button">⇦</router-link>
      <span class="chat-title">{{ route.query.partnerName }}</span>
      <button @click="toggleDarkMode" class="toggle-btn">
        {{ darkMode ? "Light Mode" : "Dark Mode" }}
      </button>
    </div>
    
    <div class="chat-messages" ref="messageContainer">
      <div v-for="(message, index) in messages" 
           :key="index" 
           :class="['message', message.senderId === userId ? 'mine' : 'other']">
        <div v-if="message.senderId !== userId" class="avatar">
          <img :src="defaultAvatar" alt="avatar" />
        </div>
        <div v-if="message.senderId === userId" class="message-meta">
          <div class="meta-container">
            <div class="status-container">
              <span v-if="message.isRead === 'X'" class="unread-indicator">
                <font-awesome-icon :icon="['fas', 'check']" />
              </span>
            </div>
            <span class="time">{{ formatTime(message.sentAt) }}</span>
          </div>
        </div>
        <div class="message-content">
          <div class="text">{{ message.content }}</div>
        </div>
        <div v-if="message.senderId !== userId" class="message-meta">
          <span class="time">{{ formatTime(message.sentAt) }}</span>
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
import { ref, onMounted, onUnmounted, computed } from 'vue';
import { useUserStore } from '../stores/user';
import { useRoute } from 'vue-router';
import SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';
import axios from 'axios';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { faCheck } from '@fortawesome/free-solid-svg-icons';

export default {
  name: 'Chat',
  components: {
    FontAwesomeIcon
  },
  setup() {
    const route = useRoute();
    const userStore = useUserStore();
    const messages = ref([]);
    const newMessage = ref('');
    const stompClient = ref(null);
    const messageContainer = ref(null);
    const userId = userStore.getUserId;
    const darkMode = ref(false);
    const defaultAvatar = "http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg";
    const isInRoom = ref(false);  // 상대방의 채팅방 입장 상태

    const toggleDarkMode = () => {
      darkMode.value = !darkMode.value;
    };

    const darkModeClass = computed(() => (darkMode.value ? "dark-mode" : ""));

    // 채팅 내역 불러오기
    const loadChatHistory = async () => {
      try {
        const response = await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/chat/history/${route.query.matchingId}`, {
          headers: {
            'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
          }
        });
        messages.value = response.data;
        scrollToBottom();
      } catch (error) {
        console.error('채팅 내역 로드 실패:', error);
      }
    };

    // WebSocket 연결
    const connectWebSocket = () => {
      const socket = new SockJS(`${import.meta.env.VITE_API_BASE_URL}/tongChat`);
      stompClient.value = Stomp.over(socket);

      stompClient.value.connect({}, () => {
        console.log('WebSocket Connected');
        
        // 채팅방 입장 시 모든 메시지 읽음 처리
        updateAllMessagesAsRead();
        
        stompClient.value.subscribe(`/topic/chat/${route.query.matchingId}`, (message) => {
          const receivedMessage = JSON.parse(message.body);
          console.log('Received message:', receivedMessage);
          
          if (receivedMessage.type === 'READ') {
            // 읽음 상태 업데이 메시지 처리
            messages.value = messages.value.map(msg => ({
              ...msg,
              isRead: 'O'
            }));
          } else {
            // 일반 채팅 메시지 처리
            const isDuplicate = messages.value.some(
              m => m.sentAt === receivedMessage.sentAt && m.senderId === receivedMessage.senderId
            );
            
            if (!isDuplicate) {
              messages.value.push(receivedMessage);
              scrollToBottom();
              
              // 새 메시지를 받았을 때 자동으로 읽음 처리
              if (receivedMessage.senderId !== userId) {
                updateAllMessagesAsRead();
              }
            }
          }
        });
      });
    };

    // 모든 메시지 읽음 처리
    const updateAllMessagesAsRead = async () => {
      try {
        await axios.put(`${import.meta.env.VITE_API_BASE_URL}/api/chat/read-all/${route.query.matchingId}`, null, {
          headers: {
            'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
          }
        });
      } catch (error) {
        console.error('메시지 읽음 처리 실패:', error);
      }
    };

    // 메시지 전송
    const sendMessage = async () => {
      if (!newMessage.value.trim()) return;

      try {
        const message = {
          matchingId: parseInt(route.query.matchingId),
          senderId: userId,
          content: newMessage.value.trim(),
          sentAt: new Date().toISOString(),
          isRead: 'X',
          type: 'CHAT'
        };

        // WebSocket이 연결된 경우 WebSocket으로만 전송
        if (stompClient.value?.connected) {
          stompClient.value.send(
            `/app/chat/${route.query.matchingId}`, 
            {}, 
            JSON.stringify(message)
          );
        } else {
          // WebSocket이 연결되지 않은 경우에만 REST API 사용
          await axios.post(`${import.meta.env.VITE_API_BASE_URL}/api/chat/message`, message, {
            headers: {
              'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
            }
          });
          // REST API로 저장한 경우 로컬 메시지 배열에 직접 추가
          messages.value.push(message);
        }

        newMessage.value = '';
        scrollToBottom();
      } catch (error) {
        console.error('메시지 전송 실패:', error);
      }
    };

    // 스크롤을 항상 최신 메시지로
    const scrollToBottom = () => {
      setTimeout(() => {
        if (messageContainer.value) {
          messageContainer.value.scrollTop = messageContainer.value.scrollHeight;
        }
      }, 100);
    };

    // 시간 포맷
    const formatTime = (date) => {
      if (!date) return '';
      return new Date(date).toLocaleTimeString('ko-KR', {
        hour: '2-digit',
        minute: '2-digit'
      });
    };

    // 컴포넌트 마운트/언마운트 처리
    onMounted(async () => {
      await loadChatHistory();
      connectWebSocket();
    });

    onUnmounted(() => {
      if (stompClient.value) {
        stompClient.value.disconnect();
      }
    });

    return {
      messages,
      newMessage,
      messageContainer,
      userId,
      darkMode,
      darkModeClass,
      defaultAvatar,
      sendMessage,
      formatTime,
      toggleDarkMode,
      route,
      isInRoom,
      updateAllMessagesAsRead
    };
  }
};
</script>

<style scoped>
.chatting-room {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 800px;
  height: 70vh;
  margin: 0 auto;
  background-color: #fff;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
}

.chat-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 15px;
  border-bottom: 1px solid #eee;
  background-color: #f5f5f5;
}

.back-button {
  text-decoration: none;
  color: #333;
  font-size: 1.2rem;
}

.chat-title {
  font-size: 1.1rem;
  font-weight: bold;
}

.toggle-btn {
  padding: 8px 16px;
  background-color: #2196f3;
  border: none;
  border-radius: 20px;
  color: white;
  cursor: pointer;
}

.toggle-btn:hover {
  background-color: #1976d2;
}

.chat-messages {
  flex: 1;
  padding: 10px;
  overflow-y: auto;
  background-color: #fafafa;
  scrollbar-width: thin;
  scrollbar-color: #1976d2 #fafafa;
}

.message {
  display: flex;
  align-items: flex-end;
  margin-bottom: 10px;
  max-width: 100%;
  position: relative;
  gap: 2px;
}

.message.mine {
  justify-content: flex-end;
}

.message.other {
  justify-content: flex-start;
}

.avatar {
  width: 3vw;
  height: 3vw;
  max-width: 40px;
  max-height: 40px;
  margin-right: 10px;
  border-radius: 50%;
  overflow: hidden;
}

.avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.message-content {
  padding: 10px 15px;
  border-radius: 15px;
  background-color: #e0e0e0;
  max-width: 60%;
}

.message.mine .message-content {
  background-color: #90caf9;
  color: #fff;
}

.message-meta {
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  font-size: 0.7em;
  color: #666;
  min-width: 45px;
}

.meta-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.status-container {
  display: flex;
  width: 100%;
  justify-content: flex-end;
  margin-right: -2px; /* 말풍선 쪽으로 더 가깝게 */
}

.message.mine .meta-container {
  align-items: flex-start;
}

.message.mine .status-container {
  justify-content: flex-start;
  margin-right: 0;
  margin-left: -2px; /* 말풍선 쪽으로 더 가깝게 */
}

.unread-indicator {
  font-size: 1.2em;
  color: #2196f3;
  line-height: 1;
  margin-bottom: 2px;
}

.time {
  font-size: 0.9em;
  opacity: 0.8;
  white-space: nowrap;
  margin-top: 2px;
}

.chat-input {
  display: flex;
  padding: 10px;
  border-top: 1px solid #eee;
  background-color: #f5f5f5;
}

.chat-input input {
  flex: 1;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 20px;
  outline: none;
}

.chat-input button {
  margin-left: 10px;
  padding: 0 15px;
  background-color: #2196f3;
  border: none;
  border-radius: 20px;
  color: #fff;
  cursor: pointer;
}

.chat-input button:hover {
  background-color: #1976d2;
}

/* 다크 모드 스타일 */
.chatting-room.dark-mode {
  background-color: #333;
  color: #fff;
}

.chatting-room.dark-mode .chat-header {
  background-color: #333;
}

.chatting-room.dark-mode .back-button {
  color: #fff;
}

.chatting-room.dark-mode .chat-messages {
  background-color: #444;
}

.chatting-room.dark-mode .chat-input {
  background-color: #555;
}

.chatting-room.dark-mode .message-content {
  background-color: #666;
}

.chatting-room.dark-mode .message.mine .message-content {
  background-color: #6c91e0;
}

.chatting-room.dark-mode .message.other .message-content {
  background-color: #777;
}

.chatting-room.dark-mode .chat-input input {
  background-color: #444;
  color: #fff;
  border-color: #666;
}

.chatting-room.dark-mode .chat-input input::placeholder {
  color: #bbb;
}

.chatting-room.dark-mode .chat-input button {
  color: #fff;
}

.chatting-room.dark-mode .unread-indicator {
  color: #90caf9;
}

.chatting-room.dark-mode .message-meta {
  color: #aaa;
}

.message-content .text {
  white-space: pre-wrap;  /* 추가: 줄바꿈 보존 */
  word-break: break-word; /* 추가: 긴 텍스트 줄바꿈 */
}
</style>