import { defineStore } from 'pinia';
import axios from 'axios';
import { useRouter } from 'vue-router';

export const useUserStore = defineStore('user', {
  state: () => ({
    token: null,
    kakaoToken: null,
    userId: null,
    kakaoUserInfo: null,
    profileImage: null, // 프로필 이미지 상태 추가
  }),

  actions: {
    setToken(token) {
      this.token = token;
    },
    setKakaoToken(token) {
      this.kakaoToken = token;
    },
    setUserId(userId) {
      this.userId = userId;
    },
    saveTokenToStorage(token) {
      this.setToken(token);
      sessionStorage.setItem('access-token', token);
    },
    saveKakaoTokenToStorage(token) {
      this.setKakaoToken(token);
      sessionStorage.setItem('kakao-access-token', token);
    },
    loadTokenFromStorage() {
      console.log('세션 스토리지에 토큰 있는거 확인!');
      this.token = sessionStorage.getItem('access-token');
      this.kakaoToken = sessionStorage.getItem('kakao-access-token');
    },
    clearToken() {
      this.token = null;
      this.kakaoToken = null;
      this.userId = null;
      this.profileImage = null; // 로그아웃 시 프로필 이미지 초기화
      sessionStorage.removeItem('access-token');
      sessionStorage.removeItem('kakao-access-token');
    },
    setKakaoUserInfo(userInfo) {
      this.kakaoUserInfo = userInfo;
    },
    setProfileImage(imageUrl) {
      this.profileImage = imageUrl;
    },

    async fetchUserInfo() {
      const router = useRouter();

      try {
        let userId = null; // const를 let으로 변경

        if (this.kakaoToken != null) {
          const kakaoResponse = await axios.get('http://localhost:8080/oauth2/kakao/user-info', {
            headers: { Authorization: `Bearer ${this.kakaoToken}` },
          });

          console.log('kakaoResponse.data:', kakaoResponse.data);

          if (kakaoResponse.status === 200) {
            userId = kakaoResponse.data.kakaoId + 'a!';
            console.log('kakaoResponse.data.userId +a! :', userId);

            // 카카오 사용자 정보 저장
            this.setKakaoUserInfo({
              kakaoId: kakaoResponse.data.kakaoId + 'a!',
              nickname: kakaoResponse.data.nickname,
              email: kakaoResponse.data.email,
              profileImage: kakaoResponse.data.profileImage,
            });

            // userId 설정
            this.setUserId(userId);

            // 프로필 이미지 설정
            this.setProfileImage(kakaoResponse.data.profileImage);
          } else if (kakaoResponse.status === 250) {
            this.setKakaoUserInfo({
              kakaoId: kakaoResponse.data.kakaoId + 'a!',
              nickname: kakaoResponse.data.nickname,
              email: kakaoResponse.data.email,
              profileImage: kakaoResponse.data.profileImage,
            });

            router.push({ name: 'signUp', params: { kakaoUserInfo: kakaoResponse.data } });
          }
        } else if (this.token != null) {
          const jwtResponse = await axios.get('http://localhost:8080/api/user/user-info', {
            headers: { Authorization: `Bearer ${this.token}` },
          });

          console.log('jwtResponse.data :', jwtResponse.data);

          if (jwtResponse.status === 200) {
            userId = jwtResponse.data.userId;
            this.setUserId(userId);

            // 프로필 이미지 설정
            this.setProfileImage(jwtResponse.data.profileImage);
          }
        }

        console.log('Final userId : ', this.userId);
      } catch (error) {
        console.error('Error fetching user info:', error);
      }
    },

    async fetchProfileImage() {
      try {
        if (!this.userId) {
          console.warn('UserId not found. Cannot fetch profile image.');
          return;
        }
    
        // userId를 이용해 서버에서 프로필 이미지를 요청
        const response = await axios.get(`/api/user/profileImg/${this.userId}`);
    
        if (response.status === 200) {
          this.setProfileImage(response.data.profileImage);
        } else {
          console.warn('Failed to fetch profile image: ', response.status);
        }
      } catch (error) {
        console.error('Error fetching profile image:', error);
      }
    },
    
  },

  getters: {
    isAuthenticated(state) {
      console.log('isAuthenticated 통해서 있는지 확인 >>>>' + state.token + ' ' + state.kakaoToken);
      return !!(state.token || state.kakaoToken);
    },
    getUserId(state) {
      console.log('userId 확인 ' + state.userId);
      return state.userId;
    },
    getKakaoUserInfo(state) {
      return state.kakaoUserInfo;
    },
    getProfileImage(state) {
      return state.profileImage || '/default-profile.png'; // 프로필 이미지 없을 경우 기본값 설정
    },
  },
});
