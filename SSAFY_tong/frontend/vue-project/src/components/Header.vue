<template>
    <div class="header">
        <router-link to="/main">
        <div class="tong">TONG</div>
        </router-link>


        <!-- 프로필 섹션 -->
      <div class="profile-section" v-if="isLoggedIn">
        <div @click="togglePanel" class="profile-wrapper">
          <img 
            :src="profileImage" 
            alt="Profile" 
            class="profile-img"
          />
        </div>
  
        <!-- 프로필 패널 -->
        <div 
          v-if="isPanelOpen"
          class="profile-panel"
        >
          <p>안녕하세요!</p>
          <p>{{ userName }}님</p>
          <p>{{ userId }}</p>
          <p>{{ userType }}</p>
          <button 
            @click="goToMyPage"
            class="panel-button mypage-btn"
          >
            마이페이지
          </button>
          <button 
            @click="handleLogout"
            class="panel-button logout-btn"
          >
            로그아웃
          </button>
        </div>
      </div>

    

        <router-link v-else to="/signIn" class="login">
          <div class="login_container">
            <svg id="12:2570" class="mdiuser-outline"></svg>
            <div class="login-1">LOGIN</div>
          </div>
        </router-link>

        <div class="menu">
            <div class="rectangle-38">
            </div>
            <div class="frame-20">

                <div class="community">
                    <div class="rectangle-37">
                    </div>
                    <div class="rectangle-39">
                    </div>
                    <div class="rectangle-40">
                    </div>
                    <router-link to="/community/1" class="community">
                        <div class="community-1">
                            Community
                        </div>
                    </router-link>
                        <svg id="12:2587" class="fluentpeople-community-32-light"></svg>
                    </div>
                    <div class="chat">
                    <div class="rectangle-41">
                    </div>
                    <div class="rectangle-42">
                    </div>
                    <div class="rectangle-43">
                    </div>
                    <router-link to="/chat" class="chagList">
                        <div class="chat-1">
                            Chat
                        </div>
                    </router-link>
                    <svg id="12:2614" class="fluentchat-32-light"></svg>
                </div>
                <div class="calender">
                    <div class="rectangle-44">
                    </div>
                    <div class="rectangle-45">
                    </div>
                    <div class="rectangle-46">
                    </div>
                      <div @click="navigateToCalendar" class="calendar">
                        Calendar
                      </div>
                    <svg id="12:2573" class="uitcalender"></svg>
                </div>
                <div class="match">
                    <div class="rectangle-47">
                    </div>
                    <div class="rectangle-48">
                    </div>
                    <div class="rectangle-49">
                    </div>
                    <router-link to="/matching" >
                        <div class="matching">
                            Matching
                        </div>
                    </router-link>
                    <svg id="12:2617" class="arcticonslitmatch"></svg>
                </div>
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
  height: 10vh;
  background: #fff;
  z-index: 1000;

  .tong {
    position: absolute;
    top: 4px;
    left: 83px;
    width: 118px;
    height: 84px;
    white-space: nowrap;
    color: #E2495B;
    font-family: "Jockey One";
    font-size: 60px;
    line-height: 84px;
    font-weight: 400;
    display: flex;
    align-items: center;
    justify-content: center;
    text-align: center;
    cursor: pointer;
    transition: transform 0.3s ease;

    &:hover {
      transform: scale(1.05);
    }
  }

  .profile-section {
    position: absolute;
    top: 20px;
    right: 40px;
    
    .profile-wrapper {
      cursor: pointer;
      transition: transform 0.3s ease;

      &:hover {
        transform: scale(1.05);
      }
    }

    .profile-img {
      width: 100px;
      height: 100px;
      border-radius: 50%;
      object-fit: cover;
    //   border: 2px solid #DC606F;
    }

    .profile-panel {
      position: absolute;
      top: 130px;
      right: 0;
      width: 200px;
      background: white;
      border-radius: 10px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
      padding: 16px;
      display: flex;
      flex-direction: column;
      gap: 8px;
      border: 1px solid rgba(220, 96, 111, 0.2);
      animation: slideDown 0.2s ease-out;

      // 인사말 스타일
      p:first-child {
        text-align: center;
        color: #DC606F;
        font-family: "Jockey One";
        font-size: 18px;
        margin: 0;
        padding: 4px 0;
      }

      // 사용자 이름 스타일
      p:nth-child(2) {
        text-align: center;
        color: #333;
        font-family: "Jockey One";
        font-size: 20px;
        font-weight: bold;
        margin: 0;
        padding: 0 0 12px 0;
        border-bottom: 1px solid rgba(220, 96, 111, 0.2);
      }

      .panel-button {
        width: 100%;
        padding: 8px;
        border: none;
        border-radius: 6px;
        font-family: "Jockey One";
        font-size: 14px;
        cursor: pointer;
        transition: all 0.2s ease;
        text-align: center;
        
        &.mypage-btn {
          background: #DC606F;
          color: white;

          &:hover {
            background: #E2495B;
            transform: translateY(-1px);
          }
        }

        &.logout-btn {
          background: #f8f8f8;
          color: #DC606F;
          border: 1px solid #DC606F;

          &:hover {
            background: #fff1f1;
            transform: translateY(-1px);
          }
        }
      }
    }
  }


  .login {
    position: absolute;
    top: 31px;
    right: 40px;
    width: 155px;
    height: 42px;
    border-radius: 10px;
    overflow: hidden;
    background: #DC606F;
    transition: all 0.3s ease;

    

    &:hover {
      background-position: right center; 
      background-image: linear-gradient(to right, #fbc2eb 0%, #a6c1ee 51%, #fbc2eb 100%);
      // background: #E2495B;
      transform: translateY(-2px);
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    .mdiuser-outline {
      position: absolute;
      top: 9px;
      left: 7px;
      width: 24px;
      height: 24px;
    }
    
    .login-1 {
      position: absolute;
      top: 11px;
      left: 48px;
      width: 60px;
      height: 20px;
      color: #FFFFFF;
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

  .menu {
    position: absolute;
    right: 840px;
    top: 0;
    width: 739px;
    height: 108px;
    overflow: hidden;
    // ... [기존 메뉴 스타일 유지]
  }

  .calender {
  .calendar {
    cursor: pointer;
    transition: color 0.3s ease, transform 0.3s ease;
    
    &:hover {
      color: #E2495B;
      transform: scale(1.05);
    }
  }
}

.frame-20 {
  .community, .chat, .calender, .match {
    .community-1, .chat-1, .calendar, .matching {
      cursor: pointer;
      transition: color 0.3s ease, transform 0.3s ease;
      
      &:hover {
        color: #E2495B;
        transform: scale(1.05);
      }
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


    /* menu 부분의 position 설정 수정 */
    .menu {
        position: absolute; /* relative에서 absolute로 변경 */
        right: 840px; /* left 값 대신 right 값으로 변경 */
        top: 0;
        width: 739px;
        height: 108px;
        overflow: hidden;
        .rectangle-38 {
            position: absolute;
            top: 39px;
            left: 27px;
            width: 97px;
            height: 25px;
            border-radius: 140px;
            background: rgba(255, 255, 255, 0.8);
        }
        .frame-20 {
            position: absolute;
            top: 30px;
            left: 13px;
            width: 585px;
            height: 43px;
            overflow: hidden;
            .community {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 165px;
                height: 43px;
                overflow: hidden;
                .rectangle-37 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 165px;
                    height: 43px;
                    border-radius: 140px;
                    background: rgba(226, 73, 91, 0.8);
                }
                .rectangle-39 {
                    position: absolute;
                    top: calc(100% - 43px + 5px);
                    left: calc(100% - 165px + 5px);
                    width: 154px;
                    height: 33px;
                    border-radius: 140px;
                    background: rgba(255, 255, 255, 0.8);
                }
                .rectangle-40 {
                    position: absolute;
                    top: calc(100% - 43px + 5px);
                    left: calc(100% - 165px + 91px);
                    width: 68px;
                    height: 33px;
                    border-radius: 140px;
                    background: rgba(255, 255, 255, 0.8);
                }
                .community-1 {
                    position: absolute;
                    top: 10px;
                    left: 48px;
                    width: 63px;
                    height: 22px;
                    white-space: nowrap;
                    color: #000000;
                    font-family: "Jockey One";
                    font-size: 16px;
                    line-height: 22px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    text-align: center;
                }
                .fluentpeople-community-32-light {
                    position: absolute;
                    top: 5px;
                    left: 16px;
                    width: 28px;
                    height: 28px;
                }
            }
            .chat {
                position: absolute;
                top: 0px;
                left: 143px;
                width: 165px;
                height: 43px;
                overflow: hidden;
                .rectangle-41 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 165px;
                    height: 43px;
                    border-radius: 140px;
                    background: rgba(226, 73, 91, 0.8);
                }
                .rectangle-42 {
                    position: absolute;
                    top: calc(100% - 43px + 5px);
                    left: calc(100% - 165px + 5px);
                    width: 154px;
                    height: 33px;
                    border-radius: 140px;
                    background: rgba(255, 255, 255, 0.8);
                }
                .rectangle-43 {
                    position: absolute;
                    top: calc(100% - 43px + 5px);
                    left: calc(100% - 165px + 91px);
                    width: 68px;
                    height: 33px;
                    border-radius: 140px;
                    background: rgba(255, 255, 255, 0.8);
                }
                .chat-1 {
                    position: absolute;
                    top: 9px;
                    left: 42px;
                    width: 26px;
                    height: 22px;
                    white-space: nowrap;
                    color: #000000;
                    font-family: "Jockey One";
                    font-size: 16px;
                    line-height: 22px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    text-align: center;
                }
                .fluentchat-32-light {
                    position: absolute;
                    top: 9px;
                    left: 14px;
                    width: 23px;
                    height: 23px;
                }
            }
            .calender {
                position: absolute;
                top: 0px;
                left: 277px;
                width: 165px;
                height: 43px;
                overflow: hidden;
                .rectangle-44 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 165px;
                    height: 43px;
                    border-radius: 140px;
                    background: rgba(226, 73, 91, 0.8);
                }
                .rectangle-45 {
                    position: absolute;
                    top: calc(100% - 43px + 5px);
                    left: calc(100% - 165px + 5px);
                    width: 154px;
                    height: 33px;
                    border-radius: 140px;
                    background: rgba(255, 255, 255, 0.8);
                }
                .rectangle-46 {
                    position: absolute;
                    top: calc(100% - 43px + 5px);
                    left: calc(100% - 165px + 91px);
                    width: 68px;
                    height: 33px;
                    border-radius: 140px;
                    background: rgba(255, 255, 255, 0.8);
                }
                .calendar {
                    position: absolute;
                    top: 10px;
                    left: 39px;
                    width: 49px;
                    height: 22px;
                    white-space: nowrap;
                    color: #000000;
                    font-family: "Jockey One";
                    font-size: 16px;
                    line-height: 22px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    text-align: center;
                }
                .uitcalender {
                    position: absolute;
                    top: 9px;
                    left: 13px;
                    width: 24px;
                    height: 24px;
                }
            }
            .match {
                position: absolute;
                top: 0px;
                left: 420px;
                width: 165px;
                height: 43px;
                overflow: hidden;
                .rectangle-47 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 165px;
                    height: 43px;
                    border-radius: 140px;
                    background: rgba(226, 73, 91, 0.8);
                }
                .rectangle-48 {
                    position: absolute;
                    top: calc(100% - 43px + 5px);
                    left: calc(100% - 165px + 5px);
                    width: 154px;
                    height: 33px;
                    border-radius: 140px;
                    background: rgba(255, 255, 255, 0.8);
                }
                .rectangle-49 {
                    position: absolute;
                    top: calc(100% - 43px + 5px);
                    left: calc(100% - 165px + 91px);
                    width: 68px;
                    height: 33px;
                    border-radius: 140px;
                    background: rgba(255, 255, 255, 0.8);
                }
                .matching {
                    position: absolute;
                    top: 9px;
                    left: 40.5px;
                    width: 51px;
                    height: 22px;
                    white-space: nowrap;
                    color: #000000;
                    font-family: "Jockey One";
                    font-size: 16px;
                    line-height: 22px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    text-align: center;
                }
                .arcticonslitmatch {
                    position: absolute;
                    top: 9px;
                    left: 14px;
                    width: 24px;
                    height: 24px;
                }
            }
        }
    }

</style>

<script setup>
import { computed, onMounted, ref } from 'vue';
import { useUserStore } from '@/stores/user';
import { useRouter } from 'vue-router';
import { storeToRefs } from 'pinia';
import axios from 'axios';


const userStore = useUserStore();
const router = useRouter();
const isPanelOpen = ref(false);

// store의 state를 반응형으로 가져오기
const { userId, userName, userType } = storeToRefs(userStore);

const defaultImage = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMwAAADACAMAAAB/Pny7AAAAIVBMVEXl77rY5aDl8Lnd6Kja5qXg67He6azZ5aLj7bbj7rXa5qhY6pxuAAACr0lEQVR4nO3b25LqIBCFYUM4+v4PvHPQUcdoYMTd3an/u7C8zCpoaAOeTgAAAAAAAAAAAAAAAAAAAIAoJ/0AvUxBSghxEUKWfpzPlDj6YUjDMH8kP0a7eXJcYtxJyWYcN0X5nWXJE6Wf7A9CusyvpzTnIv1sjVzcynGNE6Qfr827LMam2ttxsTY2YbNYHtNY2EvLbpYpjZFVwJ33swzDKP2YdfYK5sJE2eSKSbYMjYWqqZpkRoYmj7Vh9FeN21+Wf+jvOSvLf6a+D8i+Poz6eVazYV557fOsoWQGr7wLaKl//e1mQ/0T5r8KhwpzpJppGRmvPsyR9pnS0gFo32dcddNsoDdrWZu1l0xLp6m+ZE4NQ6N/YOrfAVgYmGO9nTm5qqHx2cLbmcqNU/kec7M/0dS3ZXd2d079++VNHt/OtBRt1MvqfVdjK8tpPml+2Qmo7/w3lK2plqZhMbOO3XE5jE8HzimaOTL7LYfo1+sZ66ePwfRVmlJCjOf5pkkMxUQ3tmseDmd5TADgUJYV2a3fTC/O0+PnksNq+naJYy2Uc2Xa+L2fO8u5mUlpvRjovbFOwP20ZK9+z6RxSiT9mBVyeR/k9qtmDEX3dMvhvHll9tUA6R2feXbVBrnm8Sp/qrnpl2VrlIXGOC78KcoSJyhbq1uuzDzTdae+5fBvQ9J0IvD0B4b2OGpeP32eRU+alhsmr+l4Ndgni4qTNJc7ZZnSiC/Q7rN17IH4OUfLXZldwmXz2Wb5m/AN1F7VfyE60WrP/GuNkita54ERrZoPW7INggeELTfl6ghede7RlD2Sa9Hq/11ST2w967vJrKS2Gte//uXaTde1lbkQK5ruu8zsUGGkVoAvLGZiYb6xMsuF+cJiJtZr5jh+gVgL4PqTigIAAAAAAAAAAAAAAAAAAMT9Ay89GMi5B4sKAAAAAElFTkSuQmCC';

const profileImage = computed(() => userStore.kakaoUserInfo?.profileImage || defaultImage);
const isLoggedIn = computed(() => userStore.isAuthenticated);

// 마이페이지 이동
// 일반회원, 전문가회원 다르게 라우터
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
  // 사용자 정보가 없으면 먼저 가져옵니다.
  if (!userStore.userType) {
    await userStore.fetchUserInfo();
  }

  // 사용자 타입에 따라 적절한 마이페이지로 라우팅합니다.
  if (userStore.userType === 'E') {
    console.log("전문가회원 마이페이지로 이동");
    router.push({ name: 'mypageDefaultExpert' });
  } else {
    console.log("일반회원 마이페이지로 이동");
    router.push({ name: 'mypageDefault' });
  }

  isPanelOpen.value = false;
};

const handleLogout = async () => {
  const kakaoAccessToken = sessionStorage.getItem('kakao-access-token');

  // Step 1: 모든 토큰 제거
  userStore.clearToken();
  
  // Step 2: 카카오 로그아웃 처리
  if (kakaoAccessToken) {
    try {
      await axios.get(`${import.meta.env.VITE_API_BASE_URL}/oauth2/kakao/unlink`, {
        headers: {
          Authorization: `Bearer ${kakaoAccessToken}`,
        },
      });
      console.log('카카오 로그아웃 성공');
    } catch (error) {
      console.error('카카오 로그아웃 실패:', error);
    }
  }

  // Step 3: 리다이렉트
  isPanelOpen.value = false;
  router.push('/main');
};

onMounted(() => {
  checkLoginStatus();
});
</script>
