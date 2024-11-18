import { defineStore } from 'pinia';

export const useUserStore = defineStore('user', {
  state: () => ({
    token: null,        // JWT access-token을 저장할 변수
    kakaoToken: null,   // 카카오 액세스 토큰을 저장할 변수
    userId: null,       // 사용자 ID를 저장할 변수
  }),
  actions: {
    // JWT 토큰 설정 함수
    setToken(token) {
      this.token = token;
    },
    // 카카오 토큰 설정 함수
    setKakaoToken(token) {
      this.kakaoToken = token;
    },
    // 사용자 ID 설정 함수
    setUserId(userId) {
      this.userId = userId;
    },
    // JWT 토큰을 sessionStorage에 저장하고 Pinia 상태를 업데이트
    saveTokenToStorage(token) {
      this.setToken(token);
      sessionStorage.setItem('access-token', token);
    },
    // 카카오 토큰을 sessionStorage에 저장하고 Pinia 상태를 업데이트
    saveKakaoTokenToStorage(token) {
      this.setKakaoToken(token);
      sessionStorage.setItem('kakao-access-token', token);
    },
    // sessionStorage에서 모든 토큰을 로드
    loadTokenFromStorage() {
      const token = sessionStorage.getItem('access-token');
      const kakaoToken = sessionStorage.getItem('kakao-access-token');
      
      if (token) {
        this.setToken(token);
      }
      if (kakaoToken) {
        this.setKakaoToken(kakaoToken);
      }
    },
    // 모든 토큰 제거
    clearToken() {
      this.token = null;
      this.kakaoToken = null;
      this.userId = null;
      sessionStorage.removeItem('access-token');
      sessionStorage.removeItem('kakao-access-token');
    },
    // 카카오 로그인 처리
    handleKakaoLogin(kakaoToken, jwtToken) {
      if (kakaoToken) {
        this.saveKakaoTokenToStorage(kakaoToken);
      }
      if (jwtToken) {
        this.saveTokenToStorage(jwtToken);
      }
    },




    // 사용자 정보 조회 함수 (카카오 및 JWT 토큰 사용)
    async fetchUserInfo() {
      try {
        // 1. 카카오 토큰이 있는 경우
        if (this.kakaoToken) {
          const response = await fetch('https://kapi.kakao.com/v2/user/me', {
            method: 'GET',
            headers: {
              'Authorization': `Bearer ${this.kakaoToken}`,
              'Content-Type': 'application/json',
            }
          });
          const data = await response.json();

          if (response.ok) {
            const userId = data.id;
            console.log("카카오로 얻어온 User ID:", userId);
            this.setUserId(userId);
          } else {
            console.error("카카오 사용자 정보 조회 실패:", data);
          }
        } 
        // 2. JWT 토큰이 있는 경우
        else if (this.token) {
          console.log("JWT Token:", this.token); // This should show the JWT token

          const response = await fetch('/api/user/user-info', {
            method: 'GET',
            headers: {
              'Authorization': `Bearer ${this.token}`,
              'Content-Type': 'application/json',
            }
          });
          const data = await response.json();

          if (response.ok) {
            const userId = data.userId; // 서버의 응답 형식에 따라 수정 필요
            console.log("JWT로 얻어온 User ID:", userId);
            this.setUserId(userId);
          } else {
            console.error("JWT 사용자 정보 조회 실패:", data);
          }
        } 
      } catch (error) {
        console.error("사용자 정보 조회 요청 실패:", error);
      }
    },
  },
  getters: {
    // 토큰 확인 (JWT 또는 카카오 토큰 중 하나라도 있으면 인증됨)
    isAuthenticated(state) {
      return !!(state.token || state.kakaoToken);
    },
    // 각각의 토큰 getter
    getJwtToken(state) {
      return state.token;
    },
    getKakaoToken(state) {
      return state.kakaoToken;
    },
    // 사용자 ID getter
    getUserId(state) {
      return state.userId;
    },
  },
});
