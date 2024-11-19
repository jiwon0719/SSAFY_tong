<template>
  <div class="bg-white rounded-xl p-6 w-full h-full">
    <!-- 현재 날씨 -->
    <div class="flex items-center justify-between mb-8">
      <div class="flex items-center gap-3">
        <MapPinIcon class="w-6 h-6 text-gray-500" />
        <span class="text-xl font-medium text-gray-700">대전광역시</span>
      </div>
      <div>
        <div class="text-6xl font-bold text-gray-900">
          {{ Math.round(currentWeather.temp) }}°
        </div>
        <div class="text-base text-gray-500 text-right mt-1">
          최고:{{ Math.round(currentWeather.tempMax) }}° 최저:{{ Math.round(currentWeather.tempMin) }}°
        </div>
      </div>
    </div>

    <!-- 시간별 날씨 -->
    <div class="grid grid-cols-6 gap-4 mb-10 pb-8 border-b border-gray-100">
      <div v-for="hour in hourlyForecast" :key="hour.time" class="text-center">
        <div class="text-base text-gray-500 mb-3">
          {{ hour.time === new Date().getHours() ? '지금' : `${hour.time}시` }}
        </div>
        <component 
          :is="getWeatherIcon(hour.icon, hour.time)"
          class="w-8 h-8 mx-auto text-gray-600 mb-3"
        />
        <div class="text-base font-medium">{{ hour.temp }}°</div>
      </div>
    </div>

    <!-- 5일 예보 -->
    <div class="space-y-6">
      <div v-for="day in forecast" :key="day.date" class="flex items-center">
        <div class="w-16 text-gray-500 text-lg">{{ getDayName(day.date) }}</div>
        <component 
          :is="getWeatherIcon(day.icon, 12)"
          class="w-8 h-8 text-gray-600 mr-6"
        />
        <div class="flex-1 mx-4">
          <div class="relative h-2 bg-blue-100 rounded">
            <div
              class="absolute h-2 bg-blue-500 rounded"
              :style="{
                width: `${((day.tempMax - day.tempMin) / 20) * 100}%`
              }"
            />
          </div>
        </div>
        <div class="w-20 text-right">
          <span class="font-medium text-lg">{{ Math.round(day.tempMax) }}°</span>
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

// 시간별 날씨 데이터 가공
const processHourlyData = (list) => {
  return list.slice(0, 6).map(item => ({
    time: new Date(item.dt * 1000).getHours(),
    temp: Math.round(item.main.temp),
    icon: item.weather[0].main
  }));
};

// 일별 날씨 데이터 가공
const processDailyData = (list) => {
  const dailyData = {};
  
  list.forEach(item => {
    const date = item.dt_txt.split(' ')[0];
    if (!dailyData[date]) {
      dailyData[date] = {
        date: new Date(date).getDay(),
        tempMax: -Infinity,
        tempMin: Infinity,
        icon: item.weather[0].main
      };
    }
    
    dailyData[date].tempMax = Math.max(dailyData[date].tempMax, item.main.temp_max);
    dailyData[date].tempMin = Math.min(dailyData[date].tempMin, item.main.temp_min);
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

const getDayName = (dayIndex) => {
  const days = ['일', '월', '화', '수', '목'];
  return days[dayIndex];
};

const API_KEY = import.meta.env.VITE_OPENWEATHER_API_KEY;
const CITY = 'Daejeon,KR';

const fetchWeatherData = async () => {
  try {
    error.value = null;
    const response = await fetch(
      `https://api.openweathermap.org/data/2.5/forecast?q=${CITY}&appid=${API_KEY}&units=metric&lang=kr`
    );
    const data = await response.json();

    if (!response.ok) {
      throw new Error(data.message);
    }

    // 현재 날씨 설정
    const currentData = data.list[0];
    currentWeather.value = {
      temp: currentData.main.temp,
      tempMax: currentData.main.temp_max,
      tempMin: currentData.main.temp_min,
      dt: currentData.dt,
      icon: currentData.weather[0].main
    };

    hourlyForecast.value = processHourlyData(data.list);
    forecast.value = processDailyData(data.list);
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
.error-message {
  padding: 1rem;
  background-color: #fff5f5;
  color: #c53030;
  border-radius: 8px;
  text-align: center;
  margin-bottom: 1rem;
}
</style>