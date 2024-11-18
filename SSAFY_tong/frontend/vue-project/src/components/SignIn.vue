<template>
    <div class="signup">
    <div class="rectangle-21"></div>
    <div class="frame-2">
      <div class="rectangle-22"></div>
      <router-link to="/main">
        <div class="tong">TONG</div>
      </router-link>
      <div class="frame-3">
  <div class="id">
    <!-- id와 name 속성 추가 -->
    <input 
      type="text" 
      v-model="userId" 
      placeholder="아이디를 입력하세요" 
      class="input-field" 
      id="userId" 
      name="userId" 
    />
  </div>
  <div class="password">
    <!-- id와 name 속성 추가 -->
    <input
      :type="passwordType"
      v-model="userPassword"
      placeholder="비밀번호를 입력하세요"
      class="input-field"
      id="userPassword"
      name="userPassword"
    />
    <span class="toggle-password" @click="togglePasswordVisibility" style="font-size: 28px;">
      {{ isPasswordVisible ? "🔑" : "🔒" }}
    </span>    
  </div>
  <div class="login-btn">
    <button type="button" @click="login" class="login-button">로그인</button>
  </div>
  <img
      src="https://image-resource.creatie.ai/142625939968981/142625939968983/c131a7373ebf8184425abc238dab0d0b.png"
      class="kakao-login-large-narrow-1"
      @click="redirectToKakaoLogin"
    />
</div>



            <div class="frame-5">
                <div class="group-104">
                    <router-link to="/signUp">
                            <div class="text--3">
                                회원가입
                            </div>
                    </router-link>
                    <div class="text--with-kakao">
                        회원가입 with KAKAO
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>


<style lang="scss">
    .signup {
        background-image: url('../assets/images/background.png'); /* 실제 이미지 경로를 넣어주세요 */
  background-size: cover;   /* 배경 이미지를 컨테이너 크기에 맞게 조정 */
  background-position: center; /* 배경 이미지가 중앙에 위치하도록 설정 */
  background-repeat: no-repeat; /* 배경 이미지 반복 방지 */


    position: relative;
    top: 0px;
    left: 0px;
    width: 100%;
    height: 100vh;
    box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
    overflow: hidden;
    .rectangle-21 {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 100%;
        height: 100vh;
        background: linear-gradient(180deg, rgba(47, 47, 47, 0.8) 0%, rgba(78, 78, 78, 0.8) 50%, rgba(149, 149, 149, 0.8) 100%);
    }
    .group {
        position: absolute;
        top: 1.37%;
        left: 0.69%;
        right: -0.14%;
        bottom: 5.47%;
    }
    .group-52 {
        position: absolute;
        top: 1.37%;
        left: 0.69%;
        right: -0.14%;
        bottom: 5.47%;
    }
    .frame-2 {
        position: absolute;
        top: 50%;
        left: 50%;
        width: 807px;
        height: 871px;
        border-radius: 20px;
        overflow: hidden;
        transform: translate(-50%, -50%);  /* 화면 중앙으로 이동 */
        .rectangle-22 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 100%;
            height: 100vh;
            background: linear-gradient(180deg, rgba(197, 197, 197, 0.21) 0%, rgba(197, 197, 197, 0.21) 6%, rgba(113, 113, 113, 0.21) 46%, rgba(95, 95, 95, 0.21) 100%);
        }
        .tong {
            z-index: 2;
            position: absolute;
            top: 12px;
            left: 309.5px;
            width: 190px;
            height: 134px;
            color: #E2495B;
            white-space: nowrap;
            font-family: "Jockey One";
            font-size: 96px;
            line-height: 134px;
            font-weight: 400;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;

            transition: transform 0.3s ease;

            &:hover {
            transform: scale(1.05);
        }
        }
        
        .frame-3 {
    z-index: 1;
    position: absolute;
    top: 121px;
    left: 71px;
    width: 676px;
    height: 558px;
    border-radius: 10px;
    overflow: hidden;
}

.id {
    position: absolute;
    top: 85px;
    left: calc(100% - 676px + 106px);
    width: 463px;
    height: 79px;
    border-radius: 10px;
    border: 3px solid #FFFFFF;
    display: flex;
    align-items: center;
    background-color: rgba(255, 255, 255, 0.2);
}

.password {
    position: absolute;
    top: 221px;
    left: 106px;
    width: 463px;
    height: 79px;
    border-radius: 10px;
    border: 3px solid #FFFFFF;
    display: flex;
    align-items: center;
    background-color: rgba(255, 255, 255, 0.2);
}

.input-field {
    width: 100%;
    height: 100%;
    padding: 0 20px;
    background: transparent;
    border: none;
    outline: none;
    color: #FFFFFF;
    font-size: 28px;
    font-family: "Jockey One";
    line-height: 22px;
    font-weight: 400;
    border-radius: 10px;
    color: black;
}

/* 로그인 버튼 */
.login-btn {
    position: absolute;
    top: 325px;
    left: calc(100% - 676px + 107px);
    width: 463px;
    height: 79px;
    border-radius: 10px;
    background: rgba(226, 73, 91, 0.9);
    border: 1px solid rgba(226, 73, 91, 0);
    display: flex;
    align-items: center;
    justify-content: center;
}

.login-button {
    width: 100%;
    height: 100%;
    background: transparent;
    color: #FFFFFF;
    font-size: 36px;
    font-family: "Jockey One";
    border: none;
    cursor: pointer;
    border-radius: 10px;
    text-align: center;
}

.text--2 {
    position: absolute;
    top: 340px;
    left: calc(100% - 676px + 289px);
    width: 99px;
    height: 50px;
    color: #FFFFFF;
    white-space: nowrap;
    font-family: "Jockey One";
    font-size: 36px;
    line-height: 50px;
    font-weight: 400;
    display: flex;
    align-items: center;
    justify-content: center;
    text-align: center;
}

.kakao-login-large-narrow-1 {
    position: absolute;
    top: 418px;
    left: 107px;
    width: 463px;
    height: 76px;
    border-radius: 10px;
    object-fit: cover;
}


        .frame-5 {
            position: absolute;
            left: calc(100% - 807px + 101px);
            bottom: 85px;
            width: 606px;
            height: 82px;
            overflow: hidden;
            .group-104 {
                position: absolute;
                top: 30px;
                left: 195px;
                width: 264px;
                height: 22px;
                .text--3 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 57px;
                    height: 22px;
                    color: #FFFFFF;
                    white-space: nowrap;
                    font-family: "Jockey One";
                    font-size: 16px;
                    line-height: 22px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    text-align: center;
                }
                .text--4 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 57px;
                    height: 22px;
                    color: #FFFFFF;
                    white-space: nowrap;
                    font-family: "Jockey One";
                    font-size: 16px;
                    line-height: 22px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    text-align: center;
                }
                .text--with-kakao {
                    position: absolute;
                    top: 0px;
                    left: 142px;
                    width: 122px;
                    height: 22px;
                    color: #FFFFFF;
                    white-space: nowrap;
                    font-family: "Jockey One";
                    font-size: 16px;
                    line-height: 22px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    text-align: center;
                }
            }
        }
    }
}
</style>



<script setup>
import { ref, computed, onMounted } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
import { useUserStore } from '../stores/user';

// 상태 변수들
const userId = ref("");
const userPassword = ref("");
const isPasswordVisible = ref(false);
const router = useRouter();
const userStore = useUserStore();

// 비밀번호 타입 computed 속성
const passwordType = computed(() => (isPasswordVisible.value ? "text" : "password"));

// 비밀번호 토글 함수
const togglePasswordVisibility = () => {
  isPasswordVisible.value = !isPasswordVisible.value;
};

// 일반 로그인 함수
const login = async () => {
  // 아이디와 비밀번호 유효성 검사
  if (!userId.value || !userPassword.value) {
    alert("아이디와 비밀번호를 입력해주세요.");
    return;
  }

  try {
    // 로그인 요청
    const response = await axios.post("http://localhost:8080/api/user/signIn", {
      userId: userId.value,
      password: userPassword.value,
    });


    // 서버 응답 확인
    if (response.data && response.data["access-token"]) {
      // 로그인 성공
      alert("로그인 성공!");
      // JWT 토큰 저장
      userStore.saveTokenToStorage(response.data["access-token"]);
      // 메인 페이지로 이동
      router.push({ name: "main" })
        .then(() => {
          console.log("라우팅 완료:", router.currentRoute.value.name);
        })
        .catch((error) => {
          console.error("라우팅 오류:", error);
        });
    } else {
      alert(response.data.message || "로그인 실패. 아이디와 비밀번호를 확인하세요.");
    }
  } catch (error) {
    console.error("로그인 오류:", error);
    alert("로그인 실패. 아이디와 비밀번호를 확인하세요.");
  }
};


// 카카오 로그인 리다이렉트
const redirectToKakaoLogin = () => {
  const KAKAO_CLIENT_ID = '0fd06d3411cbcfb4f97b0eb93baedd48';
  const REDIRECT_URI = 'http://localhost:8080/oauth2/kakao';
  
  // 카카오 인가 코드 요청 URL 생성
  const kakaoAuthUrl = 'https://kauth.kakao.com/oauth/authorize';
  const params = {
    client_id: KAKAO_CLIENT_ID,
    redirect_uri: REDIRECT_URI,
    response_type: 'code',
  };
  const query = new URLSearchParams(params).toString();
  const finalUrl = `${kakaoAuthUrl}?${query}`;
  
  // 카카오 로그인 페이지로 리다이렉트
  window.location.href = finalUrl;
};

// 카카오 로그인 콜백 처리 함수
const handleKakaoCallback = async (code) => {
  try {
    // 백엔드에 카카오 인가 코드 전송
    const response = await axios.get(`http://localhost:8080/oauth2/kakao?code=${code}`);
    
    if (response.data) {
      try {
        // JSON 문자열을 파싱
        const responseData = typeof response.data === 'string' 
          ? JSON.parse(response.data) 
          : response.data;

        // 카카오 액세스 토큰 저장
        if (responseData.access_token) {
          // sessionStorage에 카카오 액세스 토큰 저장
          sessionStorage.setItem('kakao-access-token', responseData.access_token);
          // userStore를 통한 저장도 함께 수행
          userStore.saveKakaoTokenToStorage(responseData.access_token);
          console.log('카카오 액세스 토큰이 저장되었습니다.');
        }


        // 메인 페이지로 리다이렉트
        router.push({ name: "main" });
      } catch (parseError) {
        console.error("응답 데이터 파싱 오류:", parseError);
        alert("로그인 처리 중 오류가 발생했습니다.");
      }
    }
  } catch (error) {
    console.error("카카오 로그인 처리 오류:", error);
    alert("카카오 로그인 처리 중 오류가 발생했습니다.");
    router.push({ name: "login" });
  }
};

// URL에서 카카오 인가 코드 확인 (컴포넌트 마운트 시)
onMounted(() => {
  const code = new URLSearchParams(window.location.search).get('code');
  if (code) {
    handleKakaoCallback(code);
  }
});
</script>