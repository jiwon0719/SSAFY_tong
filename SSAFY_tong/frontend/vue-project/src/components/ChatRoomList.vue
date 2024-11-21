<template>
  <div class="chat-room-list">
    <h1>채팅방 목록</h1>
    
    <!-- 에러 메시지 표시 -->
    <div v-if="error" class="error-message">
      {{ error }}
    </div>
    
    <!-- 채팅방 목록 -->
    <div v-else class="room-list">
      <div v-if="matchedRooms.length === 0" class="no-rooms">
        현재 진행 중인 채팅이 없습니다.
      </div>
      <div 
        v-else
        v-for="room in matchedRooms" 
        :key="room.matchingId" 
        class="room-item"
        @click="enterRoom(room)"
      >
        <h3>{{ room.partnerName }}</h3>
        <p>{{ room.lastMessage || '새로운 대화를 시작하세요' }}</p>
        <small>{{ room.lastMessageTime || '' }}</small>
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '../stores/user';
import axios from 'axios';

export default {
  name: 'ChatRoomList',
  setup() {
    const router = useRouter();
    const userStore = useUserStore();
    const matchedRooms = ref([]);
    const error = ref(null);

    const fetchMatchedRooms = async () => {
      try {
        // 먼저 스토리지에서 토큰을 로드
        userStore.loadTokenFromStorage();
        
        // 사용자 정보 가져오기
        await userStore.fetchUserInfo();
        
        // 토큰 확인
        if (!userStore.token && !userStore.kakaoToken) {
          error.value = '로그인이 필요합니다.';
          router.push('/login');
          return;
        }

        const userId = userStore.getUserId;
        console.log('Fetching rooms for userId:', userId);

        if (!userId) {
          console.error('UserId is not available');
          error.value = '사용자 정보를 찾을 수 없습니다.';
          return;
        }

        const response = await axios.get(`http://localhost:8080/api/chat/rooms/${userId}`, {
          headers: {
            'Authorization': `Bearer ${userStore.token || userStore.kakaoToken}`
          }
        });
        
        console.log('Response:', response.data);
        matchedRooms.value = response.data;
      } catch (error) {
        console.error('채팅방 목록 조회 실패:', error);
        error.value = '채팅방 목록을 불러오는데 실패했습니다.';
      }
    };

    onMounted(async () => {
      await fetchMatchedRooms();
    });

    return {
      matchedRooms,
      error,
      enterRoom: (room) => {
        router.push({
          name: 'chatRoom',
          params: { matchingId: room.matchingId },
          query: { partnerName: room.partnerName }
        });
      }
    };
  }
}
</script>

<style scoped>
.chat-room-list {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.create-room-form {
  margin: 20px 0;
  display: flex;
  gap: 10px;
}

.create-room-form input {
  flex: 1;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.create-room-form button {
  padding: 8px 16px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.room-item {
  padding: 15px;
  margin: 10px 0;
  border: 1px solid #ddd;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.2s;
}

.room-item:hover {
  background-color: #f5f5f5;
}

.error-message {
  color: red;
  margin-bottom: 10px;
}

.no-rooms {
  text-align: center;
  color: #999;
}
</style>