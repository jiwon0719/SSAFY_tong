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
      <div class="section-title">
        <span>HOT 게시판 목록</span>
      </div>
      <div class="board-section" v-for="category in topCategories" :key="category.categoryId" >
        <router-link :to="`/community/${category.categoryId}`">
          <div class="hot-info-board" @click="fetchCategoryPosts(category.categoryId, category.category)">
            <p class="category-title">🔥 {{ category.category }}</p>
            <p class="board-desc">{{ category.description }}</p>
          </div>
        </router-link>
      </div>

      <hr>
      <br>

      <!-- 일반 게시판 -->
      <div class="board-section" v-for="category in store.categoryList" :key="category.categoryId">
        <router-link :to="`/community/${category.categoryId}`">
          <div class="info-board" @click="fetchCategoryPosts(category.categoryId, category.category)">
            <p class="category-title">📌 {{ category.category }}</p>
            <p class="board-desc">{{ category.description }}</p>
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
import axios from 'axios';

const store = useCommunityStore();
const route = useRoute();
const router = useRouter();
const topCategories = ref([]);

// 핫게시판 조회(TOP3)
const fetchTopCategories = async () => {
  try {
    const response = await axios.get(`http://localhost:8080/api/boardCategory/top-viewed`);
    topCategories.value = response.data;
  } catch (error) {
    console.error('HOT 게시판을 불러오는데 실패했습니다:', error);
  }
};

onMounted(async() => {
    await Promise.all([
      store.getcategoryList(),  
      fetchTopCategories()
    ])
    
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
a{
  text-decoration: none;
  color: black;
}

.community-layout {
  display: flex;
  min-height: 100vh;
  background-color: #f8f9fa;
  position: relative;
  overflow-x: hidden;
}

.sidebar {
  width: 300px;
  background: white;
  box-shadow: 2px 0 10px rgba(0, 0, 0, 0.05);
  padding: 25px;
  position: fixed;
  left: 0;
  top: 10vh;
  height: calc(100vh - 10vh);
  overflow-y: auto;
  z-index: 10;
}

.sidebar-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 30px;
}

.board-title {
  font-size: 1.5rem;
  font-weight: 600;
  color: #2c3e50;
}

.post-register-btn {
  padding: 10px 16px;
  background-color: #ff4757;
  color: white;
  border-radius: 8px;
  font-size: 0.95rem;
  border: none;
  transition: all 0.3s ease;
  box-shadow: 0 2px 4px rgba(255, 71, 87, 0.2);
}

.post-register-btn:hover {
  background-color: #ff6b81;
  transform: translateY(-2px);
  box-shadow: 0 4px 8px rgba(255, 71, 87, 0.3);
}

.board-section {
  margin-bottom: 10px;
  transition: all 0.3s ease;
}

.hot-board {
  display: flex;
  align-items: center;
  gap: 12px;
  margin-bottom: 15px;
  padding: 10px;
  background: linear-gradient(45deg, #ff9a9e 0%, #fad0c4 99%);
  border-radius: 10px;
  color: white;
  font-weight: 500;
}

.info-board {
  padding: 15px;
  background-color: white;
  border: 1px solid #edf2f7;
  border-radius: 12px;
  margin-bottom: 10px;
  transition: all 0.3s ease;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.02);
}

/* 카테고리 제목 */
.info-board .category-title {
  font-weight: 600;
  font-size: 1.1rem;
  color: #2c3e50;
  margin-bottom: 5px;
}
/* 카테고리 설명 */
.info-board .board-desc {
  color: #718096;
  font-size: 0.9rem;
  line-height: 1.4;
}


.board-item {
  padding: 12px;
  background-color: #f8f9fa;
  border-radius: 8px;
  transition: all 0.3s ease;
}

.board-desc {
  color: #718096;
  font-size: 0.9rem;
  line-height: 1.5;
}

.board-section:hover .info-board {
  background-color: #f8f9fa;
  transform: translateY(-3px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
}

.main-content {
  flex: 1;
  margin-left: 300px;
  padding: 30px;
  background-color: #f8f9fa;
}

.search-bar {
  background: white;
  padding: 20px;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
  margin-bottom: 25px;
}

.search-input {
  border: 2px solid #edf2f7;
  transition: all 0.3s ease;
}

.search-input:focus {
  border-color: #ff4757;
  box-shadow: 0 0 0 3px rgba(255, 71, 87, 0.1);
}

.post-item {
  background: white;
  border-radius: 12px;
  padding: 25px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
  transition: all 0.3s ease;
}

.post-item:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.user-avatar {
  width: 48px;
  height: 48px;
  border-radius: 50%;
  background: linear-gradient(45deg, #ff9a9e 0%, #fad0c4 99%);
}

.pagination {
  background: white;
  padding: 15px;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
}

.page-number {
  min-width: 35px;
  height: 35px;
  border-radius: 8px;
  font-weight: 500;
  transition: all 0.3s ease;
}

.page-number.active {
  background-color: #ff4757;
  color: white;
}

.page-number:hover:not(.active) {
  background-color: #f1f5f9;
}

/* 핫게시판 관련 스타일 */
.section-title {
  display: flex;
  align-items: center;
  margin-bottom: 8px;
  padding: 5px 0;
  color: #666;
  font-size: 0.95rem;
}

.hot-board-item {
  margin-bottom: 8px;
}

.hot-info-board {
  padding: 10px;
  background-color: white;
  border: 1px solid #ffe0e0;
  border-radius: 12px;
  transition: all 0.3s ease;
  box-shadow: 0 2px 8px rgba(255, 107, 107, 0.1);
}

.hot-info-board:hover {
  background-color: #fff5f5;
  transform: translateY(-3px) scale(1.02);
  box-shadow: 0 4px 15px rgba(255, 107, 107, 0.2);
}

.hot-info-board .category-title {
  font-weight: 600;
  font-size: 1.1rem;
  color: #e03131;
  margin-bottom: 5px;
}

.hot-info-board .board-desc {
  color: #495057;
}

/* 폰트 */
/* 폰트 적용 */
.community-layout * {
  font-family: 'Noto Sans KR', sans-serif;
}

.board-title {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 700;
}

.category-title {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 600;
}

.post-register-btn,
.board-desc,
.section-title span {
  font-family: 'Noto Sans KR', sans-serif;
  font-weight: 400;
}

</style>