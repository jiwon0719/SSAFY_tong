<template>
  <div class="community-layout">
    <!-- 왼쪽 사이드바 영역 -->
    <aside class="sidebar">
      <div class="sidebar-header">
        <h2 class="board-title">게시판</h2>
        <router-link to="/community/regist">
          <button class="post-register-btn">게시판 등록</button>
        </router-link>
      </div>
      
      <!-- HOT 게시판 -->
      <div class="board-section">
        <div class="hot-board">
          <span class="hot-icon">🔥</span>
          <span>HOT 게시판 목록</span>
        </div>
        <div class="board-item" >
          <span class="board-icon">💪</span>
          <span>헬스방</span>
          <br>
          <span class="board-desc">디비에있는 헬스방 소개글</span>
        </div>
      </div>

      <hr>
      <br>

      <!-- 일반 게시판 -->
      <div class="board-section" v-for="category in store.categoryList" :key="category.categoryId">
        <router-link :to="`/community/${category.categoryId}`">
          <div class="info-board" @click="fetchCategoryPosts(category.categoryId, category.category)">
            <span>📝 {{ category.category }}</span>
          </div>
          <div class="board-item">
            <span class="board-desc">{{ category.description }}</span>
          </div>
        </router-link>
      </div>
    </aside>  

    <!-- 오른쪽 메인 컨텐츠 영역 -->
    <main class="main-content">
      <router-view></router-view>
    </main>


  </div>
</template>

<script setup>
import { useCommunityStore } from '@/stores/community'
import { ref, onMounted, watch } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const store = useCommunityStore();
const route = useRoute();
const router = useRouter();

onMounted(() => {
    store.getcategoryList();
    
    // 현재 라우트의 categoryId가 있다면 해당 카테고리의 게시글을 가져옴
    if (route.params.categoryId) {
        const category = store.categoryList.find(
            cat => cat.categoryId === route.params.categoryId
        );
        if (category) {
            fetchCategoryPosts(category.categoryId, category.category);
        }
    } else {
      // URL에 카테고리ID 없으면 자유게시판(1)로 이동
      router.push('/community/1');
    }
});

// 라우트 파라미터 변경 감지
watch(
    () => route.params.categoryId,
    (newCategoryId) => {
        if (newCategoryId) {
            const category = store.categoryList.find(
                cat => cat.categoryId === newCategoryId
            );
            if (category) {
                fetchCategoryPosts(category.categoryId, category.category);
            }
        }
    },
    { immediate: true } // 즉시 실행 옵션 추가
);

const fetchCategoryPosts = (categoryId, categoryTitle) => {
    store.fetchPostsByCategory(categoryId, categoryTitle);
};
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

.info-board {
  padding: 10px;
  background-color: #fff;
  border: 1px solid #e0e0e0;
  border-radius: 8px;
  transition: background-color 0.3s, transform 0.3s;  /* 부드러운 전환 효과 */
}

.hot-board {
  display: flex;
  align-items: center;
  gap: 8px;
  margin-bottom: 10px;
}

.board-section:hover .info-board {
  background-color: #f0f0f0; /* info-board 배경 색 변화 */
  transform: scale(1.05); /* 크기 확대 */
}

.board-section:hover .board-item {
  background-color: #f9f9f9; /* board-item 배경 색 변화 */
  transform: scale(1.03); /* 크기 확대 */
}

.board-section:hover {
  cursor: pointer; /* 마우스를 손 모양으로 변경 */
}

.board-desc {
  color: #777;
  font-size: small;
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