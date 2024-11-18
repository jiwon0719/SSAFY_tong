<template>
    <div class="main-container">
      <div class="quadrant quadrant-1">날씨</div>
      <div class="quadrant quadrant-2">예약내역</div>
      <div class="quadrant quadrant-3">게시판</div>
      <div class="quadrant quadrant-4">..</div>
    </div>
  </template>
  

  <script setup>
  import { onMounted } from 'vue';
  import { useRouter } from 'vue-router';
  import axios from 'axios'; 
  
  const router = useRouter();
  
  // 사용자 정보 가져오는 함수
  function fetchUserInfo() {
      const kakaoToken = sessionStorage.getItem('kakao-access-token');
      const jwtToken = sessionStorage.getItem('access-token');
  
      console.log("kakaoToken 입니다", kakaoToken);
      console.log("jwtToken 입니다", jwtToken);

      //  JWT Token이 있는 경우
      if (jwtToken ) {
        axios.get('/api/user/user-info', {
          headers: {
            'Authorization': `Bearer ${jwtToken}`,
            // 'Content-Type': 'application/json',
          }
        })
        .then((response) => {
          if (response.status === 200) {

            console.log("Response Headers: ", response.headers);  // Content-Type 확인
            console.log("data: ", response.data);



            const data = response.data;
            console.log("data: ", data);
            console.log("userId: ", data.userId); 
          } else {
            console.error("Error: ", response.status); // 상태 코드 확인
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
                // 성공적으로 사용자 정보 조회
                const data = response.data;
                const userId = data.id;
                console.log("카카오로 얻어온 User ID:", userId);
                // Kakao userId를 활용하거나 상태에 저장 가능
            })
            .catch((error) => {
                console.error("카카오 사용자 정보 조회 실패:", error);
            });
        }
    
      // 토큰이 둘 다 없는 경우
      else {
          console.error("Access token not found. Redirecting to login page...");
          // router.replace({ path: '/signIn' });
      }
  }
  
  // onMounted 시 사용자 정보 호출
  onMounted(() => {
      // URL에서 accessToken 파라미터 추출
      const urlParams = new URLSearchParams(window.location.search);
      const accessToken = urlParams.get('accessToken');
  
      // URL에 카카오 accessToken이 존재하면 sessionStorage에 저장
      if (accessToken) {
          sessionStorage.setItem('kakao-access-token', accessToken);
          router.replace({ path: '/main' });
      }
  
      // 사용자 정보 호출
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