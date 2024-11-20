<template>
    <div v-if="!joined">
      <h2>채팅방 참여</h2>
      <div>
        <input v-model="username" placeholder="사용자 이름">
        <select v-model="selectedRoomId">
          <option value="">채팅방을 선택하세요</option>
          <option v-for="room in rooms" :key="room.roomId" :value="room.roomId">
            {{ room.name }}
          </option>
        </select>
        <button @click="createRoom">새 채팅방 만들기</button>
        <button @click="joinRoom" :disabled="!canJoin">참여하기</button>
      </div>
    </div>
    <ChatRoom
      v-else
      :roomId="selectedRoomId"
      :roomName="selectedRoomName"
      :username="username"
    />
  </template>


<script>
import { ref, computed, onMounted } from 'vue';
import ChatRoom from './Chat.vue';

export default {
  name: 'App',
  components: {
    ChatRoom
  },
  setup() {
    const joined = ref(false);
    const username = ref('');
    const selectedRoomId = ref('');
    const selectedRoomName = ref('');
    const rooms = ref([]);

    const canJoin = computed(() => 
      username.value.trim() && selectedRoomId.value
    );

    const fetchRooms = async () => {
      try {
        const response = await fetch('http://localhost:8080/chat/rooms');
        rooms.value = await response.json();
      } catch (error) {
        console.error('Error fetching rooms:', error);
      }
    };

    const createRoom = async () => {
      const roomName = prompt('채팅방 이름을 입력하세요:');
      if (roomName) {
        try {
          const response = await fetch('http://localhost:8080/chat/rooms', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: `name=${encodeURIComponent(roomName)}`
          });
          const newRoom = await response.json();
          await fetchRooms();
          selectedRoomId.value = newRoom.roomId;
          selectedRoomName.value = newRoom.name;
        } catch (error) {
          console.error('Error creating room:', error);
        }
      }
    };

    const joinRoom = async () => {
      if (canJoin.value) {
        try {
          const response = await fetch(`http://localhost:8080/chat/rooms/${selectedRoomId.value}`);
          const room = await response.json();
          selectedRoomName.value = room.name;
          joined.value = true;
        } catch (error) {
          console.error('Error joining room:', error);
          alert('채팅방 참여에 실패했습니다.');
        }
      }
    };

    // 컴포넌트 마운트 시 채팅방 목록 가져오기
    onMounted(() => {
      fetchRooms();
    });

    return {
      joined,
      username,
      selectedRoomId,
      selectedRoomName,
      rooms,
      canJoin,
      createRoom,
      joinRoom
    };
  }
}
</script>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

h2 {
  color: #333;
  margin-bottom: 20px;
}

input, select {
  padding: 8px;
  margin-right: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  padding: 8px 16px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-right: 10px;
}

button:disabled {
  background-color: #cccccc;
  cursor: not-allowed;
}

button:hover:not(:disabled) {
  background-color: #45a049;
}
</style>