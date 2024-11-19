<template>
  <div class="main-container">
    <div class="quadrant quadrant-1">
      <WeatherForecast />
    </div>
    <div class="quadrant quadrant-2">예약내역</div>
    <div class="quadrant quadrant-3">게시판</div>
    <div class="quadrant quadrant-4">채팅</div>
  </div>
</template>

<script setup>
import { onMounted } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';
import WeatherForecast from '@/components/WeatherForcast.vue';

const router = useRouter();

// 사용자 정보 가져오는 함수
function fetchUserInfo() {
    const kakaoToken = sessionStorage.getItem('kakao-access-token');
    const jwtToken = sessionStorage.getItem('access-token');

    console.log("kakaoToken 입니다", kakaoToken);
    console.log("jwtToken 입니다", jwtToken);

    //  JWT Token이 있는 경우
    if (jwtToken) {
      axios.get('/api/user/user-info', {
        headers: {
          'Authorization': `Bearer ${jwtToken}`,
        }
      })
      .then((response) => {
        if (response.status === 200) {
          console.log("Response Headers: ", response.headers);
          console.log("data: ", response.data);

          const data = response.data;
          console.log("data: ", data);
          console.log("userId: ", data.userId);
        } else {
          console.error("Error: ", response.status);
        }
      })
      .catch((error) => {
        console.error("Error fetching user info:", error);
      });
    }

    //Kakao Token이 있는 경우
    else if (kakaoToken) {
        axios.get('https://kapi.kakao.com/v2/user/me', {
            headers: {
                'Authorization': `Bearer ${kakaoToken}`,
                'Content-Type': 'application/json',
            }
        })
        .then((response) => {
            const data = response.data;
            const userId = data.id;
            console.log("카카오로 얻어온 User ID:", userId);
        })
        .catch((error) => {
            console.error("카카오 사용자 정보 조회 실패:", error);
        });
    }

    // 토큰이 둘 다 없는 경우
    else {
        console.error("Access token not found. Redirecting to login page...");
    }
}

// onMounted 시 사용자 정보 호출
onMounted(() => {
    const urlParams = new URLSearchParams(window.location.search);
    const accessToken = urlParams.get('accessToken');

    if (accessToken) {
        sessionStorage.setItem('kakao-access-token', accessToken);
        router.replace({ path: '/main' });
    }

    fetchUserInfo();
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
  height: calc(100vh - 120px);
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
    padding: 20px;
    overflow: auto;
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