<template>
  <div class="categories-container">
    <div v-if="loading" class="loading">
      <v-progress-circular indeterminate color="primary" />
    </div>
    <div v-else-if="error" class="error-message">
      {{ error }}
    </div>
    <div v-else>
      <div class="timestamp">{{ currentTime }} 기준</div>
      <div class="categories-list">
        <div v-for="(category, index) in categories" 
            :key="category.categoryId" 
            :class="['category-card', `rank-${index + 1}`]">
          <router-link :to="`/community/${category.categoryId}`" class="category-link" @click="() => store.fetchPostsByCategory(category.categoryId, category.category)">
            <div class="rank-icon">
              <v-icon :color="getRankColor(index)" size="large">
                {{ getRankIcon(index) }}
              </v-icon>
            </div>
            <div class="category-content">
              <div class="category-title">{{ category.category }}</div>
              <div class="category-desc">{{ category.description }}</div>
              <div class="view-count">
                <v-icon color="#E2495B">mdi-trending-up</v-icon>
                <span>{{ category.totalViews.toLocaleString() }} views</span>
              </div>
            </div>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useCommunityStore } from '@/stores/community'

const store = useCommunityStore()
const categories = ref([])
const loading = ref(true)
const error = ref(null)
const currentTime = ref('')

const getRankIcon = (index) => {
  const icons = ['mdi-trophy', 'mdi-medal', 'mdi-medal-outline']
  return icons[index]
}

const getRankColor = (index) => {
  const colors = ['#FFD700', '#C0C0C0', '#CD7F32']
  return colors[index]
}

const formatDateTime = () => {
  const now = new Date()
  return now.toLocaleString('ko-KR', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    hour: '2-digit',
    minute: '2-digit',
    hour12: false
  }).replace(',', '')
}

const fetchTopCategories = async () => {
  try {
    const response = await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/boardCategory/top-viewed`)
    categories.value = response.data
    currentTime.value = formatDateTime()
  } catch (err) {
    error.value = '카테고리 정보를 불러오는데 실패했습니다.'
  } finally {
    loading.value = false
  }
}

onMounted(() => {
  fetchTopCategories()
})
</script>

<style scoped>
.category-link {
  display: flex;
  width: 100%;
  text-decoration: none;
  color: inherit;
}

.categories-container {
  padding: 20px;
  height: calc(100% - 40px);
}

.timestamp {
  text-align: right;
  color: #666;
  font-size: 0.9rem;
  margin-bottom: 10px;
}

.categories-list {
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.category-card {
  display: flex;
  align-items: center;
  padding: 10px; /* 카드 간 간격 */
  border-radius: 12px;
  /* 그라데이션 배경 설정 */
  background: linear-gradient(145deg, #ffffff, #f0f0f0);
  box-shadow: 0 4px 15px rgba(0,0,0,0.1);
  transition: all 0.3s ease;
}

.rank-1 {
  transform: scale(1.0); /* 1.05에서 1.03으로 축소 */
  background: linear-gradient(145deg, #ffffff, #fff9e6); /* 1위: 연한 금색 그라데이션 */
}

.rank-2 {
  transform: scale(0.98);
  background: linear-gradient(145deg, #ffffff, #f5f5f5); /* 2위: 연한 은색 그라데이션 */
}

.rank-3 {
  transform: scale(0.96); /* 0.95에서 0.97로 조정 */
  background: linear-gradient(145deg, #ffffff, #f0f0f0); /* 3위: 연한 동색 그라데이션 */
}

.rank-1:hover {
  transform: scale(calc(1.0 + 0.02)) !important; 
}

.rank-2:hover {
  transform: scale(calc(0.98 + 0.02)) !important;
}

.rank-3:hover {
  transform: scale(calc(0.96 + 0.02)) !important;
}

.rank-icon {
  margin-right: 20px;
  display: flex;
  align-items: center;
}

.category-content {
  flex: 1;
}

.category-title {
  font-size: 1.2rem;
  font-weight: 700;
  margin-bottom: 8px;
}

.category-desc {
  font-size: 0.95rem;
  color: #666;
  margin-bottom: 12px;
}

.view-count {
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 1.1rem;
  color: #E2495B;
  font-weight: 600;
}

.loading, .error-message {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>