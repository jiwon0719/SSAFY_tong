<template>
    <div class="chat-list">
      <div
        v-for="(chat, index) in chatList"
        :key="index"
        class="chat-item"
      >
        <!-- 채팅 아이템을 클릭할 때 채팅방 id 전달 -->
        <!-- <router-link
          :to="`/chattingRoom/${chat.id}`"
          class="chat-link"
        > -->
        <router-link
          to="/chattingRoom"
          class="chat-link"
        >
          <img :src="chat.avatar || defaultAvatar" alt="avatar" class="avatar" />
          <div class="chat-details">
            <div class="chat-name">{{ chat.name }}</div>
            <div class="chat-name">상대방 이름</div>
            <div class="chat-message">{{ chat.lastMessage }}</div>
            <div class="chat-message">상대방이 마지막으로 보낸 메세지</div>
          </div>
          <div class="chat-date">{{ chat.date }}</div>
          <div class="chat-date">채팅 날짜</div>
        </router-link>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  
  // 기본 아바타 이미지
  const defaultAvatar = "http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg";
  
  // 채팅 목록 데이터
  const chatList = ref([]);
  
  // 데이터베이스에서 데이터 가져오기
  const fetchChatList = async () => {
    try {
      // 예시: API 요청 (백엔드 서버에서 `/api/chatList` 엔드포인트로 가정)
      const response = await axios.get('/api/chatList');
      chatList.value = response.data;
    } catch (error) {
      console.error("채팅 목록 불러오기 실패:", error);
    }
  };
  
  // 컴포넌트 마운트 시 데이터 로드
  onMounted(fetchChatList);
  </script>
  
  <style scoped>
.chat-list {
  width: 100%;
  max-width: 800px;
  height: 80vh;
  overflow-y: auto;
  margin: 0 auto;
  padding: 0 10px;
  background-color: #ffffff;
  border: 1px solid #ddd;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

/* 스크롤바 스타일 */
.chat-list::-webkit-scrollbar {
  width: 8px;
}

/* 스크롤바 thumb 기본 스타일 */
.chat-list::-webkit-scrollbar-thumb {
  background-color: #E2495B; /* 기본 색상 */
  border-radius: 10px;
}

/* 스크롤바 thumb 호버 스타일 */
.chat-list::-webkit-scrollbar-thumb:hover {
  background-color: #FF6B81; /* 호버 시 색상 */
}



/* 채팅 링크 스타일 */
.chat-link {
  display: flex;
  align-items: center;
  padding: 15px;
  border-bottom: 1px solid #eee;
  text-decoration: none; /* 밑줄 제거 */
  color: inherit; /* 기본 색상 유지 */
  transition: background-color 0.2s;
}

.chat-link:hover {
  background-color: #f9f9f9;
}

.avatar {
  width: 3vw;
  height: 3vw;
  max-width: 50px;
  max-height: 50px;
  border-radius: 50%;
  margin-right: 15px;
}

.chat-details {
  flex: 1;
  min-width: 0;
}

.chat-name {
  font-size: 1.1rem;
  font-weight: bold;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.chat-message {
  font-size: 0.9rem;
  color: #666;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.chat-date {
  font-size: 0.8rem;
  color: #999;
  min-width: 70px;
  text-align: right;
}
</style>
  