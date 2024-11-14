<template>
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
            <router-link to="/communityBoardRegist">
                <button class="write-post-btn">게시물 작성</button>
            </router-link>
          </div>
        </div>

        <!-- 게시물 목록 -->
        
        <router-link to="/communityDetail">
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
        </router-link>

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

</template>

<style scoped>
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
  margin-left: 280px; /* sidebar 너비만큼 마진 */
  padding: 20px;
  min-height: 100vh;
  position: relative;
  box-sizing: border-box;
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

<script></script>