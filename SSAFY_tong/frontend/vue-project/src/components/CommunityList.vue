<template>
  <main class="main-content">
        <div class="content-container">
          <!-- 게시판 카테고리 이름  -->
          <div class="category-title">
            {{ store.selectCategoryTitle }}
          </div>
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
                <option>10개씩 보기▼</option>
              </select>
              <router-link to="/communityBoardRegist">
                  <button class="write-post-btn" @click="onPostClick">게시물 작성</button>
              </router-link>
            </div>
          </div>
  
          <!-- 게시물 목록 -->
          <div v-if="store.boardList.length > 0">
            <div class="posts-container" v-for="board in store.boardList" :key="board.boardId" @click="viewBoardDetail(board.boardId)">
              <router-link to="/communityDetail" class= "detaillink">
                <div class="post-item">
                  <div class="post-content">
                    <div class="user-info">
                      <div class="user-avatar">  <!-- 😊 --></div>
                      <div class="post-details" >
                        <p class="username">{{ board.writer }}</p>
                        <p class="post-text">{{ board.title }}</p>
                        <p class="post-text">{{ board.content }}</p>
                      </div>
                      </div>
                      <div class="post-stats">
                      <span class="view-count">👁️ 21</span>
                      <span class="comment-count">💬 3</span>
                    </div>
                  </div>
                </div>
              </router-link>
            </div>
          </div>
          <div v-else>
            <p>게시글이 없습니다.</p>
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
  
  </template>
  
  <script setup>
  import { useCommunityStore } from '@/stores/community'
  import { useBoardStore } from '@/stores/board';
  import { ref, onMounted } from 'vue';
  import { storeToRefs } from 'pinia';
  
  const store = useCommunityStore(); 
  const boardStore = useBoardStore();
  const { selectCategoryId, selectCategoryTitle } = storeToRefs(store);
  
  // 게시글 작성 버튼 클릭 시 호출되는 함수
  const onPostClick = () => {
    console.log("선택된 카테고리 ID:", selectCategoryId.value);
    console.log("선택된 카테고리 제목:", selectCategoryTitle.value);
    // 여기서 추가로 게시글 작성 로직을 수행할 수 있습니다.
  };

  // 게시글 상세 이동
  const viewBoardDetail = async(boardId) => {
    await boardStore.getBoardDetail(boardId);
    console.log("게시글 상세 조회 완료 후 currentBoard:", boardStore.currentBoard);  // getBoardDetail 완료 후 값 출력
  }
  
  </script>
  
  <style scoped>

  .detaillink {
  text-decoration: none; /* 밑줄 제거 */
  color: inherit; /* 기본 색상 유지 */
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
  
  .category-title {
    font-size: 1.5rem;
    font-weight: bold;
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
    gap: 3px;
    margin-bottom: 30px;
  }
  
  .post-item {
    z-index: 2;
    background: white;
    border-radius: 8px;
    padding: 15px;
  }
  
  .post-content {
    display: flex;
    flex-direction: column;
    gap: 3px;
  }
  
  .user-info {
    display: flex;
    gap: 4px;
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
    gap: 10px;
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