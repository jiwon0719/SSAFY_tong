<template>
  <div class="main-container">
    <div class="quadrant quadrant-1">
      <div class="quadrant-header">
        <v-icon color="#333" class="mr-2">mdi-weather-partly-cloudy</v-icon>
        <span>Today's Weather</span>
      </div>
      <WeatherForecastMain />
    </div>
    <div class="quadrant quadrant-2">
      <div class="quadrant-header">
        <v-icon color="#333" class="mr-2">mdi-calendar-check</v-icon>
        <span>Schedule</span>
      </div>
      <ReservationMain />
    </div>
    <div class="quadrant quadrant-3">
      <div class="quadrant-header">
        <v-icon color="#333" class="mr-2">mdi-forum</v-icon>
        <span>Community</span>
      </div>
      <TopBaordCategoriesMain />
    </div>
    <div class="quadrant quadrant-4">
      <div class="quadrant-header">
        <v-icon color="#333" class="mr-2">mdi-message-text</v-icon>
        <span>Messages</span>
      </div>
    </div>
  </div>
</template>

<script setup>
import WeatherForecastMain from '@/components/WeatherForcastMain.vue';
import ReservationMain from './ReservationMain.vue'
import TopBaordCategoriesMain from './TopBaordCategoriesMain.vue';
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');

.main-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  gap: 20px;
  height: calc(100vh - 120px);
  width: 100%;
  padding: 30px;
  box-sizing: border-box;
  font-family: 'Noto Sans KR', sans-serif;
}

.quadrant {
  position: relative;
  width: 100%;
  height: 100%;
  border: 1px solid #eee;
  border-radius: 16px;
  padding: 0;
  overflow: hidden;
  background-color: white;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05);
  transition: all 0.3s ease;
}

.quadrant:hover {
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.08);
  transform: translateY(-2px);
}

.quadrant-header {
  padding: 16px 24px;
  font-size: 18px;
  font-weight: 600;
  color: #333;
  border-bottom: 1px solid #eee;
  background-color: #fafafa;
  display: flex;
  align-items: center;
}

@media screen and (max-width: 768px) {
  .main-container {
    grid-template-columns: 1fr;
    grid-template-rows: repeat(4, 1fr);
  }
}
</style>