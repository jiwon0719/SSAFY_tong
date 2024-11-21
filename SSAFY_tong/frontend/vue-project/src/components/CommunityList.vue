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
              <!-- <select class="post-count-select">
                <option>10개씩 보기▼</option>
              </select> -->
              <router-link to="/community/board-regist">
                  <button class="write-post-btn" @click="onPostClick">게시물 작성</button>
              </router-link>
            </div>
          </div>
  
          <!-- 게시물 목록 -->
          <div v-if="store.boardList.length > 0">
            <div class="posts-container" v-for="board in store.boardList" :key="board.boardId">
              <router-link :to="`/community/${route.params.categoryId}/${board.boardId}`" class= "detaillink" @click="viewBoardDetail(board.boardId)">
                <div class="post-item">
                  <div class="post-content">
                    <div class="user-info">
                      <div class="user-avatar">  <!-- 😊 --></div>
                      <div class="post-details" >
                        <div class="user-header">
                          <p class="username">{{ board.writer }}</p>
                          <p class="reg-date">{{ board.regDate }}</p>
                        </div>
                        <p class="post-text">{{ board.title }}</p>
                        <p class="post-text">{{ board.content }}</p>
                      </div>
                      </div>
                      <div class="post-stats">
                      <span class="view-count"> 👀 {{ board.viewCnt }}</span>
                      <span class="comment-count">💬 {{ commentCounts[board.boardId] || 0}}</span>
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
  import { ref, onMounted, watch } from 'vue';
  import { storeToRefs } from 'pinia';
  import { useRoute } from 'vue-router';

  const store = useCommunityStore(); 
  const boardStore = useBoardStore();
  const route = useRoute();
  const { selectCategoryId, selectCategoryTitle } = storeToRefs(store);
  
  // 댓글 수 저장
  const commentCounts = ref({});

  // 댓글 수를 가져오는 함수
  const fetchCommentCounts = async () => {
    for (const board of store.boardList) {
      const count = await boardStore.getCommentCount(board.boardId);
      commentCounts.value[board.boardId] = count;
    }
  };

  // 데이터를 새로 로드하는 함수
  const loadData = async () => {
    if (selectCategoryId.value) {
      const data = await boardStore.getBoardList(selectCategoryId.value);
      store.boardList = data; // store의 boardList 업데이트
      await fetchCommentCounts();
    }
  };

  // 컴포넌트가 마운트될 때 댓글 수 가져오기
  onMounted(loadData);
  

  // 라우트 변경을 감지하여 데이터 다시 로드
  // 상세 -> 목록(조회수 최신화) & 카테고리 변경 시
  watch(
  [() => route.path, () => route.params.categoryId],
  async ([newPath, newCategoryId], [oldPath, oldCategoryId]) => {
    if ((newPath && newPath.includes('/community') && oldPath?.includes('/board/')) || 
    (newCategoryId && newCategoryId !== oldCategoryId)) {
      await loadData();
    }
  }
);

  // 게시글 작성 버튼 클릭 시 호출되는 함수
  const onPostClick = () => {
    console.log("선택된 카테고리 ID:", selectCategoryId.value);
    console.log("선택된 카테고리 제목:", selectCategoryTitle.value);
    // 여기서 추가로 게시글 작성 로직을 수행할 수 있습니다.
  };

  // 게시글 상세 이동
  const viewBoardDetail = async(boardId) => {
    // await boardStore.getBoardDetail(boardId); // 이거떄문에 조회수 2번 호출 ㅠ
    console.log("게시글 상세 조회 완료 후 currentBoard:", boardStore.currentBoard);  // getBoardDetail 완료 후 값 출력
  }
  </script>
  
  <style scoped>
a {
  text-decoration: none;
}

* {
  font-family: 'Noto Sans KR', sans-serif;
}

.category-title {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 700;
}

.user-header {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 500;
}

.post-text {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 400;
}





.main-content {
  margin-left: 280px;
  padding: 20px;
  min-height: 100vh;
}

.content-container {
  max-width: 1000px;
  margin: 0 auto;
  padding-bottom: 80px;
}

.category-title {
  font-size: 1.5rem;
  font-weight: 600;
  margin-bottom: 24px;
}

.search-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 24px;
  gap: 16px;
}

.search-input-wrapper {
  position: relative;
  flex: 1;
  max-width: 400px;
}

.search-input {
  width: 100%;
  padding: 12px 40px 12px 16px;
  border: 1px solid #e2e8f0;
  border-radius: 8px;
  font-size: 0.95rem;
  transition: border-color 0.2s;
}

.search-input:focus {
  border-color: #e75757;
  outline: none;
}

.search-btn {
  position: absolute;
  right: 12px;
  top: 50%;
  transform: translateY(-50%);
  background: none;
  border: none;
  cursor: pointer;
  opacity: 0.6;
  transition: opacity 0.2s;
}

.search-btn:hover {
  opacity: 1;
}

/* 게시글 작성 버튼 */
.write-post-btn {
 padding: 10px 16px;
 background-color: #ff4757;
 color: white;
 border-radius: 8px;
 font-size: 0.95rem;
 border: none;
 transition: all 0.3s ease;
 box-shadow: 0 2px 4px rgba(255, 71, 87, 0.2);
}
/* 게시글 작성 버튼 - 효과 */
.write-post-btn:hover {
 background-color: #ff6b81;
 transform: translateY(-2px);
 box-shadow: 0 4px 8px rgba(255, 71, 87, 0.3);
}

.post-item {
  background: white;
  border: 1px solid #e2e8f0;
  border-radius: 12px;
  padding: 20px;
  margin-bottom: 16px;
  transition: transform 0.2s, box-shadow 0.2s;
}

.post-item:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
}

.user-info {
  display: flex;
  gap: 12px;
  margin-bottom: 12px;
}

.user-avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: #f3f4f6;
}

.user-header {
  display: flex;
  align-items: center;
  gap: 12px;
  margin-bottom: 8px;
}

.username {
  font-weight: 600;
  color: #1f2937;
}

.reg-date {
  color: #6b7280;
  font-size: 0.875rem;
}

.post-content {
  display: flex;
  flex-direction: column;
}

.user-info {
  display: flex;
  gap: 12px;
  margin-bottom: 12px;
}

.post-text {
  color: #4b5563;
  font-size: 0.95rem;
  line-height: 1.5;
  margin-bottom: 6px; /* Add space before stats */
}

.post-stats {
  display: flex;
  gap: 16px;
  color: #6b7280;
  font-size: 0.875rem;
  padding-left: 52px; /* Aligns with content, accounting for avatar width + gap */
}

.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 4px;
  padding: 20px 0;
}

.page-number {
  min-width: 32px;
  height: 32px;
  border: 1px solid #e2e8f0;
  border-radius: 6px;
  background: white;
  color: #4b5563;
  transition: all 0.2s;
}

.page-number:hover {
  background-color: #f3f4f6;
  border-color: #d1d5db;
}

.page-nav {
  padding: 0 12px;
  height: 32px;
  border: 1px solid #e2e8f0;
  border-radius: 6px;
  background: white;
  color: #4b5563;
  transition: all 0.2s;
}

.page-nav:hover {
  background-color: #f3f4f6;
  border-color: #d1d5db;
}

.view-count, .comment-count {
  display: flex;
  align-items: center;
  gap: 4px;
}
  </style>