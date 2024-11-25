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
        <span>Chatbot</span>
      </div>
      <div class="messages-container">
        <div class="split-container">
          <!-- 왼쪽 소개 패널 -->
          <div class="intro-panel">
            <h3 class="assistant-title">AI 챗봇 상담가</h3>
            <div class="assistant-name">TONGKEY</div>
            <p class="assistant-intro">
              푸히히히힝~ <br>
              안녕하세요! 저는 여러분의 AI 상담가 통키입니다. <br>
              개인정보 유출 걱정없이 솔직한 대화를 할 수 있어요!
            </p>
          </div>
          <!-- 오른쪽 마스코트 영역 -->
          <div class="mascot-area">
            <div class="emoji-container">
              <Mascot />
            </div>
          </div>
        </div>
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
import EyeFollowingEmoji from './EyeFollowingEmoji.vue';
import Mascot from '@/components/mascot.vue';

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
    console.log('카카오 토큰:', userStore.kakaoToken);

    // 인증 확인
    if (!userStore.isAuthenticated) {
      router.push('/signIn');
      return;
    }

    // 유저 정보 가져오기
    await userStore.fetchUserInfo();    
    
    // 디버깅용 로그 추가
    console.log('유저 스토어 전체 상태:', userStore);
    console.log('유저 정보:', {
      birthday: userStore.getBirthday,
      name: userStore.getUserName,
      kakaoToken: userStore.kakaoToken
    });
    
    if (!userStore.getUserId) {
      console.log('MainDefault.vue에서 유저 ID가 없어서 회원가입으로 이동');
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
  height: calc(100vh - 120px);
  width: 100%;
  padding: 40px;
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

.messages-container {
  padding: 20px;
  height: calc(100% - 60px);
}

.split-container {
  display: flex;
  height: 100%;
  gap: 20px;
}

.intro-panel {
  flex: 1;
  padding: 24px;
  background: linear-gradient(135deg, #f8f9fa 0%, #e9ecef 100%);
  border-radius: 12px;
  border-right: 1px solid #eee;
}

.assistant-title {
  font-size: 1.1rem;
  color: #666;
  margin-bottom: 12px;
  font-weight: 500;
}

.assistant-name {
  font-size: 2rem;
  font-weight: 700;
  color: #E2495B;
  margin-bottom: 16px;
}

.assistant-intro {
  color: #5c6b7a;
  line-height: 1.6;
  font-size: 1.2rem;
}

.mascot-area {
  flex: 1;
  position: relative;
  display: flex;
  align-items: center;
  justify-content: center;
}

.emoji-container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

@media screen and (max-width: 768px) {
  .split-container {
    flex-direction: column;
  }
  
  .intro-panel {
    border-right: none;
    border-bottom: 1px solid #eee;
  }
}
</style>