<template>
  <div class="community-layout">
    <!-- 왼쪽 사이드바 영역 -->
    <aside class="sidebar">
      <div class="sidebar-header">
        <h2 class="board-title">게시판</h2>
        <button class="post-register-btn">게시판 등록</button>
      </div>
      
      <!-- HOT 게시판 -->
      <div class="board-section">
        <div class="hot-board">
          <span class="hot-icon">🔥</span>
          <span>HOT 게시판</span>
        </div>
        <div class="board-item">
          <span class="board-icon">📝</span>
          <span>웹스방</span>
          <span class="board-desc">본다이닝&웨이팅등등운영자신&사는얘기등...</span>
        </div>
      </div>

      <!-- 정보게시판 -->
      <div class="board-section">
        <div class="info-board">
          <span>정보게시판</span>
        </div>
        <div class="board-item">
          <span class="board-desc">운영 활성 대회조</span>
        </div>
      </div>
    </aside>

    <!-- 오른쪽 메인 컨텐츠 영역 -->
    <main class="main-content">
      <div class="content-container">
        <!-- 상단 검색 영역 -->
        <div class="search-bar">
          <div class="search-input-wrapper">
            <input 
              type="text" 
              placeholder="제목, 내용으로 검색" 
              class="search-input"
            >
            <button class="search-btn">
              <span>🔍</span>
            </button>
          </div>
          <div class="action-buttons">
            <select class="post-count-select">
              <option>10개씩 보기 ▼</option>
            </select>
            <button class="write-post-btn">게시물 작성</button>
          </div>
        </div>

        <!-- 게시물 목록 -->
        <div class="posts-container">
          <div class="post-item" v-for="i in 2" :key="i">
            <div class="post-content">
              <div class="user-info">
                <div class="user-avatar"></div>
                <div class="post-details">
                  <p class="username">hjw9265</p>
                  <p class="post-text">너무 힘들다..</p>
                  <p class="post-text">주말에 열심히 해결해...</p>
                </div>
              </div>
              <div class="post-stats">
                <span class="view-count">👁️ 21</span>
                <span class="comment-count">💬 3</span>
              </div>
            </div>
          </div>
        </div>

        <!-- 페이지네이션 -->
        <div class="pagination-wrapper">
          <div class="pagination">
            <button class="page-nav">◀</button>
            <div class="page-numbers">
              <button v-for="n in 7" :key="n" class="page-number">{{ n }}</button>
            </div>
            <button class="page-nav">▶</button>
          </div>
        </div>
      </div>
    </main>
  </div>
</template>

<script setup>
// 컴포넌트 로직
</script>

<style scoped>
.community-layout {
  display: flex;
  min-height: 100vh;
  background-color: #f5f5f5;
  position: relative;
}

.sidebar {
  width: 280px;
  background: white;
  border-right: 1px solid #e0e0e0;
  padding: 20px;
  height: 100vh;
  position: fixed;
  left: 0;
  top: 0;
  overflow-y: auto;
  z-index: 10;
}

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
}

.board-item {
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 8px;
  margin-bottom: 8px;
}

.board-desc {
  color: #666;
  font-size: 0.9rem;
}

.main-content {
  flex: 1;
  margin-left: 280px;
  padding: 20px;
  min-height: 100vh;
  position: relative;
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
</style>