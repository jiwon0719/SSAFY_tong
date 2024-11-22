<template>
  <div class="header">
    <div class="header-container">
      <!-- Logo Section -->
      <router-link to="/main" class="logo-section">
        <div class="logo">TONG</div>
      </router-link>

      <!-- Navigation Menu -->
      <nav class="nav-menu">
        <router-link to="/community/1" class="nav-item">
          <v-icon>mdi-account-multiple</v-icon>
          <span>Community</span>
          <div class="chain-effect"></div>
        </router-link>
        <router-link to="/chat" class="nav-item">
          <v-icon>mdi-message-text</v-icon>
          <span>Chat</span>
          <div class="chain-effect"></div>
        </router-link>
        <router-link 
          :to="userStore.userType === 'E' ? '/calendar/expert' : '/calendar'" 
          class="nav-item"
        >
          <v-icon>mdi-calendar-check</v-icon>
          <span>Calendar</span>
          <div class="chain-effect"></div>
        </router-link>
        <router-link to="/matching" class="nav-item">
          <v-icon>mdi-handshake</v-icon>
          <span>Matching</span>
          <div class="chain-effect"></div>
        </router-link>
      </nav>

      <!-- User Section -->
      <div class="user-section">
        <!-- Profile Section for Logged In Users -->
        <div v-if="isLoggedIn" class="profile-section">
          <div @click="togglePanel" class="profile-wrapper">
            <img :src="profileImage" alt="Profile" class="profile-img" />
          </div>
          
          <!-- Profile Panel -->
          <div v-if="isPanelOpen" class="profile-panel">
            <div class="panel-header">
              <p class="greeting">안녕하세요!</p>
              <p class="username">{{ userName }}님</p>
              <p class="user-info">{{ userId }}</p>
              <p class="user-type">{{ userType }}</p>
            </div>
            <div class="panel-buttons">
              <button @click="goToMyPage" class="panel-button mypage-btn">
                마이페이지
              </button>
              <button @click="handleLogout" class="panel-button logout-btn">
                로그아웃
              </button>
            </div>
          </div>
        </div>

        <!-- Login Button for Non-Logged In Users -->
        <router-link v-else to="/signIn" class="login-button">
          <i class="login-icon"></i>
          <span>LOGIN</span>
        </router-link>
      </div>
    </div>
  </div>
</template>

<style lang="scss">
.header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100px;
  background: #fff;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  z-index: 1000;

  .header-container {
    max-width: 1400px;
    height: 100%;
    margin: 0 auto;
    padding: 0 2rem;
    display: flex;
    align-items: center;
    justify-content: space-between;
  }

  .logo-section {
    text-decoration: none;
    
    .logo {
      color: #E2495B;
      font-family: "Jockey One", sans-serif;
      font-size: 4.0rem;
      font-weight: 400;
      transition: transform 0.3s ease;

      &:hover {
        transform: scale(1.05);
      }
    }
  }

  .nav-menu {
    display: flex;
    gap: 2.5rem;
    align-items: center;
    position: relative;

    &::before {
      content: '';
      position: absolute;
      top: 50%;
      left: 0;
      width: 100%;
      height: 2px;
      background: #eee;
      z-index: 0;
    }

    .nav-item {
      position: relative;
      display: flex;
      align-items: center;
      gap: 0.5rem;
      padding: 0.7rem 1.2rem;
      color: #333;
      text-decoration: none;
      font-family: "Jockey One", sans-serif;
      font-size: 1.4rem;
      font-weight: 500;
      transition: all 0.3s ease;
      cursor: pointer;
      background: #fff;
      
      &::before {
        content: '';
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background: #fff;
        border: 2px solid #E2495B;
        border-radius: 140px;
        z-index: -1;
        opacity: 0;
        transition: all 0.3s ease;
      }

      &::after {
        content: '';
        position: absolute;
        top: 50%;
        right: -2.5rem;
        width: 2.5rem;
        height: 2px;
        background: #E2495B;
        transform: scaleX(0);
        transform-origin: left;
        transition: transform 0.3s ease;
      }

      &:hover {
        color: #E2495B;
        transform: translateY(-1px);

        &::before {
          opacity: 1;
          box-shadow: 0 2px 8px rgba(226, 73, 91, 0.15);
        }

        & + .nav-item {
          transform: translateY(-1px);
          transition: transform 0.3s ease;
        }

        &::after {
          transform: scaleX(1);
        }
      }

      &:last-child::after {
        display: none;
      }

      .menu-icon {
        width: 24px;
        height: 24px;
        z-index: 2;
      }

      span {
        letter-spacing: 0.5px;
        z-index: 2;
      }
    }

    .router-link-active {
      color: #E2495B;
      
      &::before {
        opacity: 1;
        box-shadow: 0 2px 8px rgba(226, 73, 91, 0.15);
      }
    }
  }




.user-section {
  .profile-section {
    position: relative;

    .profile-wrapper {
      cursor: pointer;
      
      .profile-img {
        width: 65px;
        height: 65px;
        border-radius: 50%;
        object-fit: cover;
        transition: transform 0.3s ease;

        &:hover {
          transform: scale(1.05);
        }
      }
    }

    .profile-panel {
      position: absolute;
      top: 75px; // 프로필 이미지 아래에 위치하도록 수정
      right: 0;
      width: 220px;
      background: white;
      border-radius: 12px;
      box-shadow: 0 4px 20px rgba(0, 0, 0, 0.15);
      overflow: hidden;
      animation: slideDown 0.2s ease-out;
      font-family: 'Noto Sans KR', sans-serif; // 글꼴 변경

      &::before { // 패널 상단에 화살표 추가
        content: '';
        position: absolute;
        top: -8px;
        right: 28px;
        width: 16px;
        height: 16px;
        background: white;
        transform: rotate(45deg);
        box-shadow: -2px -2px 5px rgba(0, 0, 0, 0.04);
      }

      .panel-header {
        padding: 1rem;
        background: #f8f9fa;
        border-bottom: 1px solid #eee;

        .greeting {
          color: #E2495B;
          font-size: 1rem;
          margin: 0;
          font-weight: 500;
        }

        .username {
          font-size: 1.3rem;
          font-weight: 700;
          margin: 0.5rem 0;
          color: #333;
        }

        .user-info, .user-type {
          font-size: 0.9rem;
          color: #666;
          margin: 0.2rem 0;
          font-weight: 400;
        }
      }

      .panel-buttons {
        padding: 1rem;
        display: flex;
        flex-direction: column;
        gap: 0.5rem;

        .panel-button {
          padding: 0.8rem;
          border: none;
          border-radius: 8px;
          font-size: 1.1rem;
          font-weight: 500;
          cursor: pointer;
          transition: all 0.3s ease;

          &.mypage-btn {
            background: #E2495B;
            color: white;

            &:hover {
              background: #dc3545;
              transform: translateY(-1px);
            }
          }

          &.logout-btn {
            background: #f8f9fa;
            color: #E2495B;
            border: 1px solid #E2495B;

            &:hover {
              background: #fff1f1;
              transform: translateY(-1px);
            }
          }
        }
      }
    }
  }



    .login-button {
      display: flex;
      align-items: center;
      justify-content: center;
      padding: 0.8rem 1.5rem;
      background: #E2495B;
      color: white;
      text-decoration: none;
      border-radius: 8px;
      font-family: "Jockey One", sans-serif;
      font-size: 1.2rem;
      transition: all 0.3s ease;
      width: 90px; // 고정된 너비 설정
      height: 45px;  // 고정된 높이 설정

      span {
        display: flex;          // flex로 변경
        align-items: center;    // 수직 중앙 정렬
        justify-content: center; // 수평 중앙 정렬
        width: 100%;
        height: 100%;
        line-height: 1;        // 줄 높이 조정
      }

      &:hover {
        background: #dc3545;
        transform: translateY(-2px);
        box-shadow: 0 4px 12px rgba(226, 73, 91, 0.2);
      }

      .login-icon {
        width: 20px;
        height: 20px;
      }
    }
  }
}

@keyframes slideDown {
  from {
    transform: translateY(-10px);
    opacity: 0;
  }
  to {
    transform: translateY(0);
    opacity: 1;
  }
}
</style>

<script setup>
// 기존 script 코드는 그대로 유지
import { computed, onMounted, ref } from 'vue';
import { useUserStore } from '@/stores/user';
import { useRouter } from 'vue-router';
import { storeToRefs } from 'pinia';
import axios from 'axios';

const userStore = useUserStore();
const router = useRouter();
const isPanelOpen = ref(false);

const { userId, userName, userType } = storeToRefs(userStore);

const defaultImage = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMwAAADACAMAAAB/Pny7AAAAIVBMVEXl77rY5aDl8Lnd6Kja5qXg67He6azZ5aLj7bbj7rXa5qhY6pxuAAACr0lEQVR4nO3b25LqIBCFYUM4+v4PvHPQUcdoYMTd3an/u7C8zCpoaAOeTgAAAAAAAAAAAAAAAAAAAIAoJ/0AvUxBSghxEUKWfpzPlDj6YUjDMH8kP0a7eXJcYtxJyWYcN0X5nWXJE6Wf7A9CusyvpzTnIv1sjVzcynGNE6Qfr827LMam2ttxsTY2YbNYHtNY2EvLbpYpjZFVwJ33swzDKP2YdfYK5sJE2eSKSbYMjYWqqZpkRoYmj7Vh9FeN21+Wf+jvOSvLf6a+D8i+Poz6eVazYV557fOsoWQGr7wLaKl//e1mQ/0T5r8KhwpzpJppGRmvPsyR9pnS0gFo32dcddNsoDdrWZu1l0xLp6m+ZE4NQ6N/YOrfAVgYmGO9nTm5qqHx2cLbmcqNU/kec7M/0dS3ZXd2d079++VNHt/OtBRt1MvqfVdjK8tpPml+2Qmo7/w3lK2plqZhMbOO3XE5jE8HzimaOTL7LYfo1+sZ66ePwfRVmlJCjOf5pkkMxUQ3tmseDmd5TADgUJYV2a3fTC/O0+PnksNq+naJYy2Uc2Xa+L2fO8u5mUlpvRjovbFOwP20ZK9+z6RxSiT9mBVyeR/k9qtmDEX3dMvhvHll9tUA6R2feXbVBrnm8Sp/qrnpl2VrlIXGOC78KcoSJyhbq1uuzDzTdae+5fBvQ9J0IvD0B4b2OGpeP32eRU+alhsmr+l4Ndgni4qTNJc7ZZnSiC/Q7rN17IH4OUfLXZldwmXz2Wb5m/AN1F7VfyE60WrP/GuNkita54ERrZoPW7INggeELTfl6ghede7RlD2Sa9Hq/11ST2w967vJrKS2Gte//uXaTde1lbkQK5ruu8zsUGGkVoAvLGZiYb6xMsuF+cJiJtZr5jh+gVgL4PqTigIAAAAAAAAAAAAAAAAAAMT9Ay89GMi5B4sKAAAAAElFTkSuQmCC';

const profileImage = computed(() => userStore.kakaoUserInfo?.profileImage || defaultImage);
const isLoggedIn = computed(() => userStore.isAuthenticated);

// 기존 메소드들 유지
const navigateToCalendar = () => {
  const route = userStore.userType === 'E' ? '/calendar/expert' : '/calendar'
  router.push(route);
}

const checkLoginStatus = async () => {
  userStore.loadTokenFromStorage();
  if (isLoggedIn.value) {
    await userStore.fetchUserInfo();
  }
};

const togglePanel = () => {
  isPanelOpen.value = !isPanelOpen.value;
};

const goToMyPage = async () => {
  if (!userStore.userType) {
    await userStore.fetchUserInfo();
  }

  if (userStore.userType === 'E') {
    router.push({ name: 'mypageDefaultExpert' });
  } else {
    router.push({ name: 'mypageDefault' });
  }

  isPanelOpen.value = false;
};

const handleLogout = async () => {
  const kakaoAccessToken = sessionStorage.getItem('kakao-access-token');

  userStore.clearToken();
  
  if (kakaoAccessToken) {
    try {
      await axios.get(`${import.meta.env.VITE_API_BASE_URL}/oauth2/kakao/unlink`, {
        headers: {
          Authorization: `Bearer ${kakaoAccessToken}`,
        },
      });
    } catch (error) {
      console.error('카카오 로그아웃 실패:', error);
    }
  }

  isPanelOpen.value = false;
  router.push('/main');
};

onMounted(() => {
  checkLoginStatus();
});
</script>