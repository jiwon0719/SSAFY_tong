<template>
  <div class="main-container">
    <BirthdayModal :user="{
      name: userStore.getUserName,
      birthday: userStore.getBirthday
    }" /> <!-- 생일 축하 모달 -->
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
  <v-snackbar
    v-model="snackbar"
    :color="snackbarColor"
    timeout="3000"
  >
    {{ snackbarText }}
  </v-snackbar>
</template>


<script setup>
import BirthdayModal from './BirthdayModal.vue';
import WeatherForecastMain from '@/components/WeatherForcastMain.vue';
import ReservationMain from './ReservationMain.vue'
import TopBaordCategoriesMain from './TopBaordCategoriesMain.vue';

import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/stores/user';
import { useCalendarStore } from '@/stores/calendar';

// store와 router 인스턴스를 가져옵니다
const userStore = useUserStore();
const calendarStore = useCalendarStore();
const router = useRouter();

// 오늘 날짜를 가져오는 함수
const getTodayDate = () => {
  return new Date().toISOString().split('T')[0];
};

// accessToken을 URL에서 가져와서 저장하는 함수
const storeAccessTokenFromUrl = () => {
const urlParams = new URLSearchParams(window.location.search);
const accessToken = urlParams.get('accessToken');

if (accessToken) {
  // localStorage에 accessToken 저장
  localStorage.setItem('kakao-access-token', accessToken);
  // userStore에 토큰 저장 (로그인 상태로 처리)
  userStore.saveKakaoTokenToStorage(accessToken);
  console.log("accessToken이 저장되었습니다:", accessToken);
}
};

// Snackbar 관련 상태 추가
const snackbar = ref(false)
const snackbarText = ref('')
const snackbarColor = ref('#E2495B')

// Snackbar 표시 함수
const showSnackbar = (text, color = '#E2495B') => {
 snackbarText.value = text
 snackbarColor.value = color
 snackbar.value = true
}

// 메인 페이지 초기화 함수
const initializeMainPage = async () => {
  try {
      // URL에서 카카오 토큰을 받아서 저장
    storeAccessTokenFromUrl();

    // 토큰 로드 및 유저 정보 확인
    userStore.loadTokenFromStorage();

    // 유저가 인증되지 않은 경우, 로그인 페이지로 이동
    if (!userStore.isAuthenticated) {
      router.push('/signIn');
      return;
    }

    // 먼저 유저 정보를 가져옴
    await userStore.fetchUserInfo();
    
    // 유저 ID가 없으면 회원가입 페이지로 이동
    if (!userStore.getUserId) {
      router.push('/signUp');
      return;
    }
    
    // 캘린더 데이터 로드
    const data = await calendarStore.loadInitialData(userStore.getUserId)
    // ReservationMain 컴포넌트에 데이터 전달을 위한 처리가 필요하다면 추가
    console.log('Loaded initial data:', data)
  } catch (error) {
    console.error('메인 페이지 초기화 중 에러 발생:', error)
    showSnackbar('데이터 로드에 실패했습니다.')
  }
};

// 컴포넌트가 마운트될 때 초기화 함수 실행

onMounted(async () => {
  try {
    // URL에서 카카오 토큰을 받아서 저장
    storeAccessTokenFromUrl();
    
    // 토큰 로드
    userStore.loadTokenFromStorage();

    // 인증 확인
    if (!userStore.isAuthenticated) {
      router.push('/signIn');
      return;
    }

    // 유저 정보 가져오기
    await userStore.fetchUserInfo();

    console.log('유저 생일:', userStore.getBirthday);
    console.log('유저 이름:', userStore.getUserName);

    if (!userStore.getUserId) {
      router.push('/signUp');
      return;
    }

    // 캘린더 데이터 로드
    const data = await calendarStore.loadInitialData(userStore.getUserId)
    console.log('Main page loaded initial data:', data)
  } catch (error) {
    console.error('메인 페이지 데이터 로드 실패:', error)
    showSnackbar('데이터 로드에 실패했습니다.')
  }
});

</script>



<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');

.main-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  gap: 20px;
  height: calc(100vh - 120px); /* Header(60px) + Footer(60px) 고려 */
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