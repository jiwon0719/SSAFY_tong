<template>
  <div class="weather-container">
    <div class="weather-content">
      <!-- 왼쪽 영역: 현재 날씨와 시간별 날씨 -->
      <div class="left-section">
        <!-- 현재 날씨 -->
        <div class="current-weather">
          <div class="location">
            <MapPinIcon class="w-4 h-4" />
            <span>대전광역시</span>
          </div>
          <div class="weather-main">
            <component 
              :is="getWeatherIcon(currentWeather.icon, new Date().getHours())"
              class="current-weather-icon"
            />
            <div class="temp-info">
              <div class="current-temp">{{ Math.round(currentWeather.temp) }}°</div>
              <div class="temp-range">
                최고:{{ Math.round(currentWeather.tempMax) }}° 최저:{{ Math.round(currentWeather.tempMin) }}°
              </div>
            </div>
          </div>
        </div>

        <!-- 3시간별 날씨 -->
        <div class="hourly-forecast">
          <div v-for="hour in hourlyForecast" :key="hour.dt" class="hourly-item">
            <div class="time">
              {{ formatTime(hour.dt) }}
            </div>
            <component 
              :is="getWeatherIcon(hour.icon, new Date(hour.dt * 1000).getHours())"
              class="weather-icon"
            />
            <div class="temp">{{ Math.round(hour.temp) }}°</div>
          </div>
        </div>
      </div>

      <!-- 오른쪽 영역: 5일 예보 -->
      <div class="right-section">
        <div class="daily-forecast">
          <div v-for="day in forecast" :key="day.dt" class="daily-item">
            <div class="day">{{ getDayName(day.dt) }}</div>
            <component 
              :is="getWeatherIcon(day.icon, 12)"
              class="forecast-icon"
            />
            <div class="temp-bar">
              <div class="temp-progress" 
                :style="{
                  left: `${(day.tempMin + 20) * 2.5}%`,
                  width: `${(day.tempMax - day.tempMin) * 2.5}%`
                }"
              ></div>
            </div>
            <div class="temp-range-daily">
              <span class="min-temp">{{ Math.round(day.tempMin) }}°</span>
              <span class="max-temp">{{ Math.round(day.tempMax) }}°</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>


<script setup>
import { ref, onMounted } from 'vue';
import {
  MapPinIcon,
  SunIcon,
  CloudIcon,
  CloudSunIcon,
  MoonIcon
} from 'lucide-vue-next';

const currentWeather = ref({
  temp: 0,
  tempMax: 0,
  tempMin: 0,
  dt: null,
  icon: ''
});

const hourlyForecast = ref([]);
const forecast = ref([]);
const error = ref(null);

// 시간 포맷팅
const formatTime = (timestamp) => {
  const date = new Date(timestamp * 1000);
  const now = new Date();
  if (
    date.getDate() === now.getDate() &&
    date.getMonth() === now.getMonth() &&
    date.getHours() === now.getHours()
  ) {
    return '지금';
  }
  return `${date.getHours()}시`;
};

// 3시간별 날씨 데이터 가공 - 5개 항목으로 제한
const processHourlyData = (list) => {
  return list.slice(0, 5).map(item => ({
    dt: item.dt,
    temp: item.main.temp,
    icon: item.weather[0].main
  }));
};

// 일별 날씨 데이터 가공 - 5일로 제한
const processDailyData = (list) => {
  const dailyData = {};
  
  list.forEach(item => {
    const date = new Date(item.dt * 1000).toISOString().split('T')[0];
    
    if (!dailyData[date]) {
      dailyData[date] = {
        dt: item.dt,
        tempMax: item.main.temp,
        tempMin: item.main.temp,
        icon: item.weather[0].main
      };
    } else {
      dailyData[date].tempMax = Math.max(dailyData[date].tempMax, item.main.temp);
      dailyData[date].tempMin = Math.min(dailyData[date].tempMin, item.main.temp);
    }
  });
  
  return Object.values(dailyData).slice(0, 5);
};

const getWeatherIcon = (condition, hour) => {
  const isDay = hour >= 6 && hour < 18;
  
  switch (condition) {
    case 'Clear':
      return isDay ? SunIcon : MoonIcon;
    case 'Clouds':
      return isDay ? CloudSunIcon : CloudIcon;
    default:
      return CloudIcon;
  }
};

const getDayName = (timestamp) => {
  const days = ['일', '월', '화', '수', '목', '금', '토'];
  return days[new Date(timestamp * 1000).getDay()];
};

const API_KEY = import.meta.env.VITE_OPENWEATHER_API_KEY;
const CITY = 'Daejeon,KR';

const fetchWeatherData = async () => {
 try {
   error.value = null;
   // 현재 날씨를 위한 API 호출
   const currentResponse = await fetch(
     `https://api.openweathermap.org/data/2.5/weather?q=${CITY}&appid=${API_KEY}&units=metric&lang=kr`
   );
   const currentData = await currentResponse.json();

   // 5일 예보를 위한 API 호출 
   const forecastResponse = await fetch(
     `https://api.openweathermap.org/data/2.5/forecast?q=${CITY}&appid=${API_KEY}&units=metric&lang=kr`
   );
   const forecastData = await forecastResponse.json();

   if (!currentResponse.ok || !forecastResponse.ok) {
     throw new Error('API 요청 실패');
   }

   // 오늘 날짜의 최고/최저 기온 계산
   const today = new Date().toISOString().split('T')[0];
   const todayForecasts = forecastData.list.filter(item => 
     new Date(item.dt * 1000).toISOString().split('T')[0] === today
   );
   
   const todayMax = Math.max(...todayForecasts.map(item => item.main.temp));
   const todayMin = Math.min(...todayForecasts.map(item => item.main.temp));

   // 현재 날씨 정보 설정
   currentWeather.value = {
     temp: currentData.main.temp,
     tempMax: todayMax, // 오늘의 최고기온
     tempMin: todayMin, // 오늘의 최저기온
     dt: currentData.dt,
     icon: currentData.weather[0].main
   };

   // 시간별 예보 처리
   hourlyForecast.value = processHourlyData(forecastData.list);

  // 일별 예보 처리 (오늘부터 4일)
  const dailyForecasts = forecastData.list.reduce((acc, item) => {
  const date = new Date(item.dt * 1000);
  const dateStr = date.toISOString().split('T')[0];
  
  if (!acc[dateStr]) {
    acc[dateStr] = {
      dt: item.dt,
      tempMax: item.main.temp,
      tempMin: item.main.temp,
      icon: item.weather[0].main
    };
  } else {
    acc[dateStr].tempMax = Math.max(acc[dateStr].tempMax, item.main.temp);
    acc[dateStr].tempMin = Math.min(acc[dateStr].tempMin, item.main.temp);
  }
  return acc;
  }, {});

  forecast.value = Object.values(dailyForecasts).slice(0, 4);

 } catch (err) {
   console.error('날씨 데이터를 가져오는데 실패했습니다:', err);
   error.value = '날씨 정보를 가져오는 중 문제가 발생했습니다.';
 }
};


onMounted(() => {
  fetchWeatherData();
  // 30분마다 날씨 정보 업데이트
  setInterval(fetchWeatherData, 30 * 60 * 1000);
});
</script>



<style scoped>
.weather-container {
  width: 100%;
  height: calc(100% - 60px); /* 헤더 높이만큼 뺌 */
  background-color: white;
  color: #333;
  display: flex;
  align-items: center; /* 중앙 정렬 */
  padding: 20px;
  box-sizing: border-box;
}

.weather-content {
  width: 100%;
  height: 100%;
  display: flex;
  gap: 1.5rem;
  align-items: center;
}

.left-section {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 2rem; /* 간격 증가 */
  padding-right: 1.5rem;
  border-right: 1px solid #e5e7eb;
}

.current-weather {
  display: flex;
  flex-direction: column;
  gap: 1rem;
}

.location {
  display: flex;
  align-items: center;
  gap: 0.25rem;
  font-size: 1rem;
  color: #4b5563;
}

.weather-main {
  display: flex;
  align-items: center;
  gap: 1.5rem;
}

.current-weather-icon {
  width: 4rem;  /* 아이콘 크기 증가 */
  height: 4rem;
  color: #4b5563;
}

.temp-info {
  text-align: right;
}

.current-temp {
  font-size: 3rem; /* 온도 크기 증가 */
  font-weight: bold;
  line-height: 1;
  margin-bottom: 0.5rem;
  color: #1f2937;
}

.temp-range {
  font-size: 0.875rem;
  color: #6b7280;
}

.hourly-forecast {
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  gap: 0.75rem;
}

.hourly-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 0.875rem;
}

.time {
  color: #6b7280;
  margin-bottom: 0.5rem;
}

.weather-icon {
  width: 1.5rem;
  height: 1.5rem;
  margin: 0.5rem 0;
  color: #4b5563;
}

.right-section {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.daily-forecast {
  display: flex;
  flex-direction: column;
  gap: 1.25rem; /* 간격 증가 */
}

.daily-item {
  display: flex;
  align-items: center;
  gap: 1rem;
  font-size: 1rem; /* 폰트 크기 증가 */
}

.day {
  width: 2rem;
  color: #4b5563;
  font-weight: 500;
}

.forecast-icon {
  width: 1.5rem;
  height: 1.5rem;
  color: #4b5563;
}

.temp-bar {
  flex: 1;
  height: 0.5rem; /* 그래프 높이 증가 */
  background-color: #f3f4f6;
  border-radius: 9999px;
  position: relative;
  margin: 0 0.75rem;
}

.temp-progress {
  position: absolute;
  height: 100%;
  background-color: #3b82f6;
  border-radius: 9999px;
}

.temp-range-daily {
  display: flex;
  gap: 0.75rem;
  min-width: 4.5rem;
  font-size: 1rem; /* 폰트 크기 증가 */
}

.min-temp {
  color: #6b7280;
}

.max-temp {
  font-weight: 500;
  color: #1f2937;
}
</style>