<template>
  <div class="expert-detail">
    <!-- 로딩 상태 표시 -->
    <div v-if="loading" class="loading-spinner">Loading...</div>
    
    <!-- 에러 메시지 표시 -->
    <div v-else-if="error" class="error-message">{{ error }}</div>
    
    <!-- 메인 컨텐츠 -->
    <template v-else>
      <!-- 이미지 캐러셀 -->
      <section class="carousel">
        <div class="carousel-container">
          <button class="carousel-btn prev" @click="prevSlide">&#10094;</button>
          <div class="carousel-wrapper" :style="{ transform: `translateX(-${currentIndex * 100}%)` }">
            <div v-for="image in expertImages" :key="image.fileId" class="carousel-slide">
              <img :src="image.imageUrl" :alt="image.oriName" />
            </div>
          </div>
          <button class="carousel-btn next" @click="nextSlide">&#10095;</button>
        </div>
      </section>

      <!-- 프로필 정보 -->
      <section class="profile">
        <div class="profile-header">
          <div class="profile-image">
            <img :src="expertImages[0]?.imageUrl" alt="프로필 이미지" />
          </div>
          <div class="profile-info">
            <h2>{{ expertDetail?.companyName }} <span class="grade">/ {{ expertDetail?.grade }}</span></h2>
            <div class="rating">평점: {{ averageScore }}점</div>
          </div>
        </div>

        <!-- 위치 정보 -->
        <div class="info-section">
          <h3>Information</h3>
          <div class="content">
            <p>🏠 {{ expertDetail?.location }}</p>
            <p>{{ expertDetail?.introduction }}</p>
          </div>
        </div>

        <!-- 가격 정보 -->
        <div class="info-section">
          <h3>Price</h3>
          <div class="content">
            <p class="price">회당 {{ expertDetail?.price?.toLocaleString() }}원</p>
            <p>{{ expertDetail?.priceDetail }}</p>
          </div>
        </div>

        <!-- 경력 정보 -->
        <div class="info-section">
          <h3>Career</h3>
          <div class="content">
            <div v-for="career in expertCareers" :key="career.expertCareerId" class="career-item">
              <span class="date">{{ career.startDate }} - {{ career.endDate }}</span>
              <span class="description">{{ career.careerDetail }}</span>
            </div>
          </div>
        </div>

        <!-- 매칭 신청 버튼 -->
        <div class="actions">
          <button @click="handleJoinRequest" class="join-btn">매칭 신청</button>
          <p class="join-notice">신청 후, 전문가 승인 시 채팅이 갈꺼에요. 조금만 기다려주세요.</p>
        </div>
      </section>
    </template>
  </div>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue';
import { useRoute } from 'vue-router';
import { useExpertStore } from '@/stores/expert';
import { storeToRefs } from 'pinia';

const route = useRoute();
const expertStore = useExpertStore();
const { expertDetail, expertCareers, expertImages, loading, error, averageScore } = storeToRefs(expertStore);

// 캐러셀 관련 상태 및 로직
const currentIndex = ref(0);
const slideInterval = ref(null);
const SLIDE_DURATION = 5000;

const nextSlide = () => {
  if (!expertImages.value.length) return;
  currentIndex.value = (currentIndex.value + 1) % expertImages.value.length;
  resetAutoSlide();
};

const prevSlide = () => {
  if (!expertImages.value.length) return;
  currentIndex.value = (currentIndex.value - 1 + expertImages.value.length) % expertImages.value.length;
  resetAutoSlide();
};

const startAutoSlide = () => {
  if (expertImages.value.length <= 1) return;
  slideInterval.value = setInterval(nextSlide, SLIDE_DURATION);
};

const stopAutoSlide = () => {
  clearInterval(slideInterval.value);
};

const resetAutoSlide = () => {
  stopAutoSlide();
  startAutoSlide();
};

// 매칭 신청 핸들러
const handleJoinRequest = () => {
  // TODO: 매칭 신청 로직 구현
  console.log('매칭 신청', expertDetail.value?.expert_id);
};

onMounted(async () => {
  const expertId = route.params.expertId;
  if(!expertId) {
    console.error('Expert ID is missing')
    return;
  }

  await expertStore.fetchExpertDetail(expertId);
  startAutoSlide();
});

onBeforeUnmount(() => {
  stopAutoSlide();
});
</script>

<style scoped>
.expert-detail {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.loading-spinner,
.error-message {
  text-align: center;
  padding: 2rem;
}

/* 캐러셀 스타일 */
.carousel {
  position: relative;
  width: 100%;
  height: 50vh;
  overflow: hidden;
  margin-bottom: 2rem;
}

.carousel-container {
  position: relative;
  width: 100%;
  height: 100%;
}

.carousel-wrapper {
  display: flex;
  height: 100%;
  transition: transform 0.5s ease;
}

.carousel-slide {
  flex: 0 0 100%;
  height: 100%;
}

.carousel-slide img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.carousel-btn {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background: rgba(0, 0, 0, 0.5);
  color: white;
  border: none;
  padding: 1rem;
  cursor: pointer;
  z-index: 2;
}

.carousel-btn.prev { left: 1rem; }
.carousel-btn.next { right: 1rem; }

/* 프로필 섹션 스타일 */
.profile {
  background: white;
  border-radius: 8px;
  padding: 2rem;
}

.profile-header {
  display: flex;
  align-items: center;
  gap: 2rem;
  margin-bottom: 2rem;
}

.profile-image {
  width: 150px;
  height: 150px;
  border-radius: 50%;
  overflow: hidden;
}

.profile-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.info-section {
  margin-bottom: 2rem;
}

.info-section h3 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}

.content {
  background: #f8f8f8;
  padding: 1.5rem;
  border-radius: 8px;
}

.career-item {
  display: flex;
  gap: 1rem;
  margin-bottom: 0.5rem;
}

.date {
  color: #666;
  min-width: 200px;
}

.actions {
  text-align: center;
  margin-top: 2rem;
}

.join-btn {
  background: #E2495B;
  color: white;
  border: none;
  padding: 1rem 3rem;
  border-radius: 25px;
  font-size: 1.1rem;
  cursor: pointer;
  transition: background 0.3s;
}

.join-btn:hover {
  background: #c01c52;
}

.join-notice {
  margin-top: 1rem;
  color: #666;
}
</style>