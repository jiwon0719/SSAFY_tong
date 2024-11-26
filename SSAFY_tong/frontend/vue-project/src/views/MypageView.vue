<template>
  <div class="community-layout">
    <!-- 왼쪽 사이드바 영역 -->
    <aside class="sidebar">
      <div class="sidebar-header">
        <h2 class="board-title">마이 페이지</h2>
      </div>
      <hr>
      <br>

      <router-link to="/main/mypage" class="text-none">
        <div class="board-section" >
          <div class="info-board">
            <span>🧐 나의 매칭 현황</span>
          </div>
          <div class="board-item">
            <span class="board-desc">내 전문가/유저 확인</span>
          </div>
        </div>
      </router-link>

      <router-link to="/main/mypage/aichat" class="text-none">
        <div class="board-section">
          <div class="info-board">
            <span>🤖 AI 챗봇</span>
          </div>
          <div class="board-item">
            <span class="board-desc">AI 어시스턴트와 대화하기</span>
          </div>
        </div>
      </router-link>

      <router-link to="/chat" class="text-none">
        <div class="board-section">
          <div class="info-board">
            <span>💬 채팅</span>
          </div>
          <div class="board-item">
            <span class="board-desc">채팅 및 알림</span>
          </div>
        </div>
      </router-link>

      

    </aside>

    <!-- 오른쪽 메인 컨텐츠 영역 -->
    <main class="main-content">
      <!-- ChatRoom이 활성화될 때 마스코트와 채팅방을 감싸는 컨테이너 추가 -->
      <div v-if="isChatRoute" class="chat-layout">
        <div class="mascot-wrapper">
          <Mascot />
        </div>
        <div class="chat-wrapper">
          <router-view></router-view>
        </div>
      </div>
      <router-view v-else></router-view>
    </main>

  </div>
</template>

<script setup>
import { computed } from 'vue';
import { useRoute } from 'vue-router';
import Mascot from '@/components/mascot.vue';

const route = useRoute();
const isChatRoute = computed(() => route.path.includes('/mypage/aichat'));
</script>

<style scoped>
a {
  text-decoration: none;
  color: black;
}

/* community-layout의 스타일을 수정 */
.community-layout {
  display: flex;
  min-height: 100vh;
  background-color: #f5f5f5;
  position: relative;
  overflow-x: hidden; /* 가로 스크롤 방지 */
}

/* sidebar의 스타일을 수정 */
.sidebar {
  width: 280px;
  background: white;
  border-right: 1px solid #e0e0e0;
  padding: 20px;
  left: 0;
  top: 10vh; /* 헤더 바로 아래 10vh로 설정 */
  height: calc(100vh + 10vh); 
  overflow-y: auto; /* 스크롤이 필요한 경우에만 */
  z-index: 10;
}

/* 사이드바 헤더 스타일 */
.sidebar-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}



.board-title {
  font-size: 1.2rem;
  font-weight: bold;
}

.post-register-btn {
  padding: 8px 12px;
  background-color: #e75757;
  color: white;
  border-radius: 6px;
  font-size: 0.9rem;
}

.board-section {
  margin-bottom: 30px;
}

.hot-board {
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 10px;
  color: #ab4545;
}

.board-item {
  
  /* display: flex; */
  display : inline-block;
  align-items: center;
  gap: 8px;
  padding: 8px;
  margin-bottom: 8px;

}

.board-desc {
  color: #666;
  font-size: 0.9rem;
}

/* main-content의 스타일을 수정 */
.main-content {
  flex: 1;
  margin-top: 20px;
  margin-left: 100px; 
  padding: 20px;
  min-height: 100vh;
  position: relative;
  box-sizing: border-box;
  overflow-x: hidden; /* 가로 스크롤 방지 */
}

.content-container {
  max-width: 1200px;
  margin: 0 auto;
  position: relative;
  min-height: calc(100vh - 40px);
  padding-bottom: 100px;
}

.search-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
  gap: 20px;
}

.search-input-wrapper {
  position: relative;
  flex: 1;
  max-width: 500px;
}

.search-input {
  width: 100%;
  padding: 10px 40px 10px 15px;
  border: 1px solid #ddd;
  border-radius: 8px;
  font-size: 0.95rem;
}

.search-btn {
  position: absolute;
  right: 10px;
  top: 50%;
  transform: translateY(-50%);
  background: none;
  border: none;
  cursor: pointer;
}

.action-buttons {
  display: flex;
  gap: 10px;
}

.post-count-select {
  padding: 8px 12px;
  border: 1px solid #ddd;
  border-radius: 8px;
  background: white;
}

.write-post-btn {
  padding: 8px 16px;
  background-color: #e75757;
  color: white;
  border-radius: 8px;
}

.posts-container {
  display: flex;
  flex-direction: column;
  gap: 15px;
  margin-bottom: 60px;
}

.post-item {
  background: white;
  border-radius: 8px;
  padding: 20px;
}

.post-content {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.user-info {
  display: flex;
  gap: 12px;
}

.user-avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #eee;
}

.post-details {
  display: flex;
  flex-direction: column;
  gap: 4px;
}

.username {
  font-weight: 500;
}

.post-text {
  color: #666;
  font-size: 0.9rem;
}

.post-stats {
  display: flex;
  gap: 15px;
  color: #666;
  font-size: 0.9rem;
}

.pagination-wrapper {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 20px 0;
  background-color: #f5f5f5;
}

.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 5px;
}

.page-numbers {
  display: flex;
  gap: 5px;
}

.page-number {
  width: 30px;
  height: 30px;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 4px;
  cursor: pointer;
}

.page-number:hover {
  background-color: #f0f0f0;
}

.page-nav {
  padding: 0 10px;
  height: 30px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}

.text-none {
  text-decoration: none;
}

.chat-layout {
  display: flex;
  gap: 20px;
  width: 100%;
  height: calc(100vh - 100px);
}

.mascot-wrapper {
  width: 800px;
  height: 1000px;
  margin-top: 20px;
  display: flex;
  align-items: flex-start;
  justify-content: center;
  flex-shrink: 0;
}

.chat-wrapper {
  flex: 1;
  display: flex;
  justify-content: flex-start;
  margin-right: 20px;
  overflow-y: auto;
}
</style>