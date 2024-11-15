<template>
    <div :class="darkModeClass" class="chatting-room">
      <div class="chat-header">
        <router-link to="/chatList" class="back-button"
        style="">⇦</router-link>
        <span class="chat-title">채팅방 이름</span>
        
        <!-- 다크 모드 토글 버튼 추가 -->
        <button @click="toggleDarkMode" class="toggle-btn">
          {{ darkMode ? "Light Mode" : "Dark Mode" }}
        </button>
      </div>
  
      <!-- 채팅 메시지 리스트 -->
      <div class="chat-messages">
        <div
          v-for="(message, index) in messages"
          :key="index"
          :class="['message', message.isMine ? 'mine' : 'other']"
        >
          <div v-if="!message.isMine" class="avatar">
            <img :src="chatAvatar || defaultAvatar" alt="avatar" />
          </div>
          <div class="message-content">{{ message.text }}</div>
        </div>
      </div>
  
      <!-- 채팅 입력 필드 -->
      <div class="chat-input">
        <input
          v-model="newMessage"
          @keyup.enter="sendMessage"
          type="text"
          placeholder="메시지를 입력하세요"
        />
        <button @click="sendMessage">전송</button>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref, onMounted, computed } from 'vue';
  import { useRoute } from 'vue-router';
  
  // 기본 아바타
  const defaultAvatar = "http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg";
  const chatAvatar = ref("http://img1.kakaocdn.net/thumb/R640x640.q70/?fname=http://t1.kakaocdn.net/account_images/default_profile.jpeg"); // 상대방 아바타
  
  // 라우터에서 채팅방 ID 받기
  const route = useRoute();
  const chatId = route.params.id;
  const chatTitle = ref(`채팅방 ${chatId}`);
  
  // 채팅 메시지 초기 데이터
  const messages = ref([
    { text: "안녕하세요! 이 채팅방에 오신 것을 환영합니다.", isMine: false },
    { text: "안녕하세요!", isMine: true },
    { text: "무엇을 도와드릴까요?", isMine: false },
  ]);
  
  // 새 메시지 입력
  const newMessage = ref("");
  
  // 메시지 전송 함수
  const sendMessage = () => {
    if (newMessage.value.trim() === "") return;
  
    // 메시지를 추가하고 입력 필드 초기화
    messages.value.push({ text: newMessage.value, isMine: true });
    newMessage.value = "";
  
    // 스크롤을 아래로 내리기
    scrollToBottom();
  };
  
  // 메시지 창 스크롤 함수
  const scrollToBottom = () => {
    const chatMessages = document.querySelector(".chat-messages");
    chatMessages.scrollTop = chatMessages.scrollHeight;
  };
  
  // 다크 모드 설정
  const darkMode = ref(false);
  const toggleDarkMode = () => {
    darkMode.value = !darkMode.value;
  };
  
  // 다크 모드 클래스를 반환하는 computed 속성
  const darkModeClass = computed(() => (darkMode.value ? "dark-mode" : ""));
  onMounted(scrollToBottom);
  </script>
  







  
  <style scoped>
  .chatting-room {
    display: flex;
    flex-direction: column;
    width: 100%;
    max-width: 800px;
    height: 70vh;
    margin: 0 auto;
    border: 1px solid #ddd;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    background-color: #fff;
    transition: background-color 0.3s ease, color 0.3s ease; /* 색상 변경 애니메이션 추가 */
  }
  
  
  /* 헤더 스타일 */
  .chat-header {
      display: flex;
      align-items: center;
      justify-content: space-between;
      padding: 10px 15px;
      border-bottom: 1px solid #eee;
      background-color: #f5f5f5;
    }

    /* 다크 모드에서 헤더 배경색 */
.chatting-room.dark-mode .chat-header {
  background-color: #333; /* 다크 모드 배경색 */
}
    
    .back-button {
        text-decoration: none;
        color: #333;
        font-size: 1.2rem;
    }
    /* 다크 모드에서 백 버튼의 글자 색을 밝게 변경 */
.chatting-room.dark-mode .back-button {
    color: #fff; /* 다크 모드에서 글자 색을 흰색으로 */
}
    
    .chat-title {
        font-size: 1.1rem;
        font-weight: bold;
    }
    

    /* 다크 모드 스타일 */
    .chatting-room.dark-mode {
      background-color: #333;
      color: #fff;
    }
    /* 다크 모드 토글 버튼 스타일 */
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

  /* 다크 모드 */

/* 다크 모드에서 채팅 메시지 배경 */
.chatting-room.dark-mode .chat-messages {
  background-color: #444; /* 다크 모드 배경색 */
}
/* 다크 모드에서 입력 필드 배경 */
.chatting-room.dark-mode .chat-input {
  background-color: #555; /* 다크 모드 배경색 */
}
/* 다크 모드에서 메시지 배경 */
.chatting-room.dark-mode .message-content {
  background-color: #666; /* 다크 모드 메시지 배경 */
}
/* 다크 모드에서 자신이 보낸 메시지 */
.chatting-room.dark-mode .message.mine .message-content {
  background-color: #6c91e0;
}
/* 다크 모드에서 상대방이 보낸 메시지 */
.chatting-room.dark-mode .message.other .message-content {
  background-color: #777;
}
/* 다크 모드에서 버튼과 입력 필드 텍스트 색 */
.chatting-room.dark-mode .chat-input input,
.chatting-room.dark-mode .chat-input button {
  color: #fff; /* 다크 모드 텍스트 색 */
}



  /* 메시지 스타일 */
  .message {
    display: flex;
    align-items: flex-end;
    margin-bottom: 10px;
    max-width: 100%;
  }
  
  .message.mine {
    justify-content: flex-end;
  }
  
  .message.other {
    justify-content: flex-start;
  }
  
  .message .avatar {
    width: 3vw;
    height: 3vw;
    max-width: 40px;
    max-height: 40px;
    margin-right: 10px;
    border-radius: 50%;
    overflow: hidden;
  }
  
  .message .avatar img {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  
  .message-content {
    padding: 10px 15px;
    border-radius: 15px;
    font-size: 0.9rem;
    line-height: 1.4;
    background-color: #e0e0e0;
  }
  
  .message.mine .message-content {
    background-color: #90caf9;
    color: #fff;
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
  </style>
  