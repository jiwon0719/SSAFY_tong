<template>
    <div class="matching-expert-container">
      <!-- 캐러셀 섹션 -->
      <div class="carousel-section">
        <div class="carousel-wrapper">
          <button class="carousel-btn prev-btn" @click="prevSlide">&#10094;</button>
          <div class="carousel" :style="{ transform: `translateX(-${currentIndex * 100}%)` }">
            <div v-for="(image, index) in images" :key="index" class="carousel-item">
              <img :src="image" alt="전문가 이미지" />
            </div>
          </div>
          <button class="carousel-btn next-btn" @click="nextSlide">&#10095;</button>
        </div>
      </div>

      <!-- 프로필 정보 섹션 -->
      <div class="profile-content">
        <!-- 프로필 이미지와 이름 -->
        <div class="profile-header">
          <div class="profile-image">
            <img src="../assets/images/trainer.jpg" alt="트레이너 프로필" />
          </div>
          <div class="profile-name">
            <h2>김XX <span class="sub-text">/ PT 쌤</span></h2>
          </div>
        </div>

        <!-- Information 섹션 -->
        <div class="info-section">
          <h3 class="section-title">Information</h3>
          <div class="info-content">
            <p>🏠 서울특별시</p>
            <p class="address-detail">서초/사당/방배/반포/강남권/강북권</p>
            <p class="description">안녕하세요 새벽운동팀입니다.</p>
            <p class="description">저희 새벽운동팀과 함께라면 건강한 몸관리와 더불어 자극이 확실히 오는 운동을 보장하고 있습니다.</p>
          </div>
        </div>

        <!-- Price 섹션 -->
        <div class="info-section">
          <h3 class="section-title">Price</h3>
          <div class="info-content">
            <p class="price">회당 44,000원</p>
            <p class="price-detail">시설 이용권은 따로이며 / 상담 환영</p>
          </div>
        </div>

        <!-- Career 섹션 -->
        <div class="info-section">
          <h3 class="section-title">Career</h3>
          <div class="info-content career-list">
            <div class="career-item">
              <span class="date">2020.03-2022.03</span>
              <span class="career-desc">싸피 수석PT</span>
            </div>
            <div class="career-item">
              <span class="date">2020.03-2022.03</span>
              <span class="career-desc">싸피 수석PT</span>
            </div>
            <div class="career-item">
              <span class="date">2020.03-2022.03</span>
              <span class="career-desc">싸피 수석PT</span>
            </div>
            <div class="career-item">
              <span class="date">2020.03-2022.03</span>
              <span class="career-desc">싸피 수석PT</span>
            </div>
          </div>
        </div>

        <!-- Join 버튼 -->
        <div class="join-button">
                <router-link to="/matching" >
                <button>Join</button>
                </router-link>
                <p>신청 후, 전문가 승인 시 채팅이 갈꺼에요. 조금만 기다려주세요.</p>
            </div>
        
      </div>
    </div>

</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue';

const images = ref([
  new URL('../assets/images/trainer_1.jpg', import.meta.url).href,
  new URL('../assets/images/trainer_2.jpg', import.meta.url).href,
  new URL('../assets/images/trainer_3.jpg', import.meta.url).href,
]);

const currentIndex = ref(0);
const slideInterval = ref(null);
const slideDuration = 5000;

const nextSlide = () => {
  currentIndex.value = (currentIndex.value + 1) % images.value.length;
  resetAutoSlide();
};

const prevSlide = () => {
  currentIndex.value = (currentIndex.value - 1 + images.value.length) % images.value.length;
  resetAutoSlide();
};

// 자동 슬라이드 타이머 초기화
const resetAutoSlide = () => {
  stopAutoSlide(); // 현재 타이머 멈추기
  startAutoSlide(); // 타이머 다시 시작
};


const startAutoSlide = () => {
  slideInterval.value = setInterval(() => {
    nextSlide();
  }, slideDuration);
};

const stopAutoSlide = () => {
  clearInterval(slideInterval.value);
};

onMounted(() => {
  startAutoSlide();
});

onBeforeUnmount(() => {
  stopAutoSlide();
});
</script>

<style scoped>
.matching-expert-container {
  width: 100%;
  max-width: 1200px;
  margin: 0 auto;
  background: #ffffff;
}

/* 캐러셀 섹션 스타일 유지 */
.carousel-section {
  width: 100%;
  height: 50vh;
  overflow: hidden;
  position: relative;
}

.carousel-wrapper {
  position: relative;
  width: 100%;
  height: 100%;
}

.carousel {
  display: flex;
  width: 100%;
  height: 100%;
  transition: transform 0.5s ease-in-out;
}

.carousel-item {
  flex: 0 0 100%;
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}

.carousel-item img {
  max-height: 100%;
  width: 100%;
  object-fit: cover;
}

.carousel-btn {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  background-color: rgba(0, 0, 0, 0.5);
  color: white;
  border: none;
  padding: 10px;
  cursor: pointer;
  font-size: 24px;
  z-index: 2;
}

.prev-btn {
  left: 10px;
}

.next-btn {
  right: 10px;
}

/* 프로필 컨텐츠 스타일 */
.profile-content {
  padding: 20px;
  max-width: 800px;
  margin: 0 auto;
}

.profile-header {
  display: flex;
  align-items: center;
  gap: 20px;
  margin-bottom: 30px;
}

.profile-image {
  width: 200px;
  height: 200px;
  border-radius: 50%;
  overflow: hidden;
}

.profile-image img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.profile-name h2 {
  font-size: 24px;
  margin: 0;
}

.sub-text {
  font-size: 16px;
  color: #666;
}

/* Information, Price, Career 섹션 공통 스타일 */
.info-section {
  margin-bottom: 30px;
}

.section-title {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 15px;
}

.info-content {
  background: #f8f8f8;
  padding: 20px;
  border-radius: 8px;
}

.description {
  margin: 8px 0;
  line-height: 1.5;
}

/* Career 섹션 특별 스타일 */
.career-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.career-item {
  display: flex;
  gap: 15px;
}

.date {
  color: #666;
  min-width: 120px;
}

/* Join 버튼 스타일 */
.join-button {
  text-align: center;
  margin-top: 40px;
}

.join-button button {
  background: #E2495B;
  color: white;
  border: none;
  padding: 12px 40px;
  border-radius: 25px;
  font-size: 18px;
  cursor: pointer;
  transition: background-color 0.3s;
}


.join-button button:hover {
    background: #c01c52;
}


/* p 태그 가운데 정렬 */
.join-button p {
  text-align: center; /* 텍스트 가운데 정렬 */
  margin-top: 20px; /* 위 여백을 추가 */
  font-size: 16px; /* 폰트 크기 조정 */
  color: #666; /* 텍스트 색상 설정 */
}
</style>