<template>
  <div class="chat-room-list">
    <h1>채팅방 목록</h1>
    
    <!-- 채팅방 생성 폼 -->
    <div class="create-room-form">
      <input 
        v-model="newRoomName" 
        placeholder="새로운 채팅방 이름"
        @keyup.enter="createRoom"
      >
      <button @click="createRoom">방 만들기</button>
    </div>

    <!-- 채팅방 목록 -->
    <div class="room-list">
      <div 
        v-for="room in chatRooms" 
        :key="room.id" 
        class="room-item"
        @click="enterRoom(room)"
      >
        <h3>{{ room.name }}</h3>
        <p>참여자 수: {{ room.participantCount || 0 }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

export default {
  name: 'ChatRoomList',
  setup() {
    const router = useRouter();
    const newRoomName = ref('');
    const chatRooms = ref([
      // 테스트용 더미 데이터
      { id: '1', name: '테스트 채팅방 1', participantCount: 3 },
      { id: '2', name: '테스트 채팅방 2', participantCount: 5 },
    ]);

    const createRoom = () => {
      if (newRoomName.value.trim()) {
        const newRoom = {
          id: Date.now().toString(), // 임시 ID
          name: newRoomName.value,
          participantCount: 0
        };
        chatRooms.value.push(newRoom);
        newRoomName.value = '';
      }
    };

    const enterRoom = (room) => {
      router.push({
        name: 'chatRoom',
        params: {
          roomId: room.id
        },
        query: {
          roomName: room.name
        }
      });
    };

    return {
      newRoomName,
      chatRooms,
      createRoom,
      enterRoom
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
</style>