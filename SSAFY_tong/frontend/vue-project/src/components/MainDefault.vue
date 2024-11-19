<template>
  <div class="main-container">
    <div class="quadrant quadrant-1">  
      <WeatherForecast />
    </div>
    <div class="quadrant quadrant-2">예약내역</div>
    <div class="quadrant quadrant-3">게시판</div>
    <div class="quadrant quadrant-4">..</div>
  </div>
</template>




<script setup>
import { onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { useUserStore } from '@/stores/user';
import WeatherForecast from '@/components/WeatherForcast.vue';

// store와 router 인스턴스를 가져옵니다
const userStore = useUserStore();
const router = useRouter();

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

// 메인 페이지 초기화 함수
const initializeMainPage = async () => {
// URL에서 카카오 토큰을 받아서 저장
storeAccessTokenFromUrl();

// 토큰 로드 및 유저 정보 확인
userStore.loadTokenFromStorage();

// 유저가 인증되지 않은 경우, 로그인 페이지로 이동
if (!userStore.isAuthenticated) {
  router.push('/signIn');
  return;
}

// 유저 정보 확인
await userStore.fetchUserInfo();


console.log('!userStore.getUserId : ', !userStore.getUserId);

// 유저 ID가 없으면 회원가입 페이지로 이동
if (!userStore.getUserId) {
  router.push('/signUp');
}
};

// 컴포넌트가 마운트될 때 초기화 함수 실행
onMounted(() => {
initializeMainPage();
});
</script>





<style scoped lang="scss">
html, body {
height: 100%;
margin: 0;
}

.main-container {
display: grid;
grid-template-columns: 1fr 1fr;
grid-template-rows: 1fr 1fr;
gap: 20px;
height: calc(100vh - 120px); /* Header(60px) + Footer(60px) 고려 */
width: 100%;
padding: 30px;
box-sizing: border-box;

.quadrant {
  display: flex;
  justify-content: center;
  align-items: center;
  border: 1px solid #ccc;
  border-radius: 10px;
  background-color: #f4f4f4;
  font-size: 24px;
  font-weight: bold;
  color: #333;
}

.quadrant-1 {
  background-color: #ffcccb;
}
.quadrant-2 {
  background-color: #cce7ff;
}
.quadrant-3 {
  background-color: #d1ffcc;
}
.quadrant-4 {
  background-color: #fff5b0;
}
}

@media screen and (max-width: 768px) {
.main-container {
  grid-template-columns: 1fr;
  grid-template-rows: repeat(4, 1fr);
}
}
</style>