// store/user.js
import { defineStore } from 'pinia';

export const useUserStore = defineStore('user', {
  state: () => ({
    token: null,  // 'access-token'을 저장할 변수
  }),
  actions: {
    // 토큰 설정 함수
    setToken(token) {
      this.token = token;
    },
    // 토큰을 sessionStorage에 저장하고 Pinia 상태를 업데이트
    saveTokenToStorage(token) {
      this.setToken(token);
      sessionStorage.setItem('access-token', token);  // sessionStorage에도 저장
    },
    // sessionStorage에서 토큰을 로드
    loadTokenFromStorage() {
      const token = sessionStorage.getItem('access-token');
      if (token) {
        this.setToken(token);
      }
    },
    // 토큰 제거
    clearToken() {
      this.token = null;
      sessionStorage.removeItem('access-token');
    },
  },
  getters: {
    // 토큰 확인
    isAuthenticated(state) {
      return !!state.token;  // 토큰이 있으면 인증됨
    },
  },
});
