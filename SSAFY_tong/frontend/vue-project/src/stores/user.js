import { defineStore } from 'pinia';
import axios from 'axios';
import { useRouter } from 'vue-router';

export const useUserStore = defineStore('user', {
  state: () => ({
    token: null,
    kakaoToken: null,
    userId: null,
    userType: null,
    userName: null, 
    kakaoUserInfo: null,
    profileImage: null, // 프로필 이미지 상태 추가
    birthday: null, 
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
    setUserType(userType) {
      this.userType = userType;
    },
    setUserName(userName) {
      this.userName = userName;
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
      // console.log('세션 스토리지에 토큰 있는거 확인!');
      this.token = sessionStorage.getItem('access-token');
      this.kakaoToken = sessionStorage.getItem('kakao-access-token');
    },
    clearToken() {
      this.token = null;
      this.kakaoToken = null;
      this.userId = null;
      this.profileImage = null; // 로그아웃 시 프로필 이미지 초기화
      this.kakaoUserInfo = null;
      sessionStorage.removeItem('access-token');
      sessionStorage.removeItem('kakao-access-token');
    },
    setKakaoUserInfo(userInfo) {
      this.kakaoUserInfo = userInfo;
    },
    setProfileImage(imageUrl) {
      this.profileImage = imageUrl;
    },
    setBirthday(biethday) {
      this.birthday = biethday;
    },

    async fetchUserInfo() {
      const router = useRouter();

      try {
        let userId = null; // const를 let으로 변경
        let userType = null; // const를 let으로 변경
        let userName = null; // const를 let으로 변경

        if (this.kakaoToken != null) {
          const kakaoResponse = await axios.get(`${import.meta.env.VITE_API_BASE_URL}/oauth2/kakao/user-info`, {
            headers: { Authorization: `Bearer ${this.kakaoToken}` },
          });

          console.log('kakaoResponse.data 응답 데이터 전체:', kakaoResponse.data);

          if (kakaoResponse.status === 200) {
            userId = kakaoResponse.data.kakaoId;
            userType = kakaoResponse.data.userType; // 구현  필요
            userName = kakaoResponse.data.nickname;
            console.log('kakaoResponse.data.userId :', userId);

            if (kakaoResponse.data.birthdate) {
              this.setBirthday(kakaoResponse.data.birthdate);
            }

            // 카카오 사용자 정보 저장
            this.setKakaoUserInfo({
              kakaoId: kakaoResponse.data.kakaoId ,
              nickname: kakaoResponse.data.nickname,
              email: kakaoResponse.data.email,
              profileImage: kakaoResponse.data.profileImage,
            });

            // store.js에 기본정보 저장
           this.setUserId(userId);
           this.setUserType(userType);
           this.setUserName(userName);


            // 프로필 이미지 설정
            this.setProfileImage(kakaoResponse.data.profileImage);
          } else if (kakaoResponse.status === 201) {
            this.setKakaoUserInfo({
              kakaoId: kakaoResponse.data.kakaoId,
              nickname: kakaoResponse.data.nickname,
              email: kakaoResponse.data.email,
              profileImage: kakaoResponse.data.profileImage,
            });

            router.push({ name: 'signUp', params: { kakaoUserInfo: kakaoResponse.data } });
          }
        } else if (this.token != null) {
          const jwtResponse = await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/user/user-info`, {
            headers: { Authorization: `Bearer ${this.token}` },
          });

          // console.log('jwtResponse.data 응답 데이터 전체:', jwtResponse.data);

          if (jwtResponse.status === 200) {
            userId = jwtResponse.data.userId;
            userType = jwtResponse.data.userDetails.userType;
            userName = jwtResponse.data.name;
            
            if (jwtResponse.data.userDetails.birthdate) {
              this.setBirthday(jwtResponse.data.userDetails.birthdate);
            }

            // store.js에 기본정보 저장
            this.setUserId(userId);
            this.setUserType(userType);
            this.setUserName(userName);

            
            // 프로필 이미지 설정
            this.setProfileImage(jwtResponse.data.profileImage);
          }
        }

        // console.log('Final userId : ', this.userId);
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
        const response = await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/user/profileImg/${this.userId}`);
    
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
      // console.log('isAuthenticated 통해서 있는지 확인 >>>>' + state.token + ' ' + state.kakaoToken);
      return !!(state.token || state.kakaoToken);
    },
    getUserId(state) {
      // console.log('userId 확인 ' + state.userId);
      return state.userId;
    },
    getKakaoUserInfo(state) {
      return state.kakaoUserInfo;
    },
    getProfileImage(state) {
      return state.profileImage || '/default-profile.png'; // 프로필 이미지 없을 경우 기본값 설정
    },
    getBirthday(state) {
      return state.birthday;
    }, 
    getUserName(state) {
      return state.userName;
    }
  },
});
