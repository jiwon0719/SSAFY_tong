<template>
  <!-- 이전 template 코드는 동일하게 유지 -->
  <footer class="footer">
    <div class="footer-container">
      <div class="large-logo-section">
        <img
          src="https://image-resource.creatie.ai/142625939968981/142625939968983/e444649ac77c0d7952f2c62fdd0aaaf2.png"
          class="rectangle-3dicons"
          alt="TONG Logo"
        />
      </div>

      <div class="footer-content">
        <div class="footer-sections">
          <div class="footer-section">
            <h3 class="section-title">Discover TONG</h3>
            <p class="section-text">
              Welcome to TONG, where fitness meets expertise. Connect with certified trainers
              and like-minded fitness enthusiasts in a space designed for your wellness journey.
            </p>
          </div>

          <div class="footer-section">
            <h3 class="section-title">Make TONG yours</h3>
            <p class="section-text">
              Follow your favorite trainers and topics. We'll deliver personalized
              workout recommendations and expert advice straight to your dashboard.
            </p>
          </div>

          <div class="footer-section">
            <h3 class="section-title">Explore your membership</h3>
            <p class="section-text">
              Get unlimited access to expert trainers and premium fitness content.
              Join our community of passionate fitness professionals and enthusiasts.
            </p>
          </div>
        </div>

        <div class="company-info">
          <h2 class="company-name">(주)SSAFY_TONG</h2>

          <div class="info-details">
            <div class="address-section">
              <p>대전시 유성구 대전 유성구 동서대로 98-39 교육동 2층</p>
              <p>2nd Floor, Education Building, 98-39 Dongseo-daero, Yuseong-gu, Daejeon, South Korea.</p>
            </div>
            
            <div class="contact-section">
              <p>Email: hjw9265@naver.com | tmdgh0124@naver.com</p>
            </div>

            <div class="legal-section">
              <p>본 사이트의 컨텐츠는 저작권법의 보호를 받는 바 무단 전재, 복사, 배포 등을 금합니다.</p>
              <p>Copyright © 2024~ TONG. All Rights Reserved.</p>
            </div>
          </div>

          <div class="footer-links">
            <a class="link">About</a>
            <a class="link">Help</a>
            <a class="link">Legal</a>
          </div>

          <!-- 새로운 TONG 애니메이션 섹션 추가 -->
          <div class="tong-animation-wrapper">
            <div class="bouncing-text">
              <div class="letter-container chewy-regular">
                <span class="letter">T</span>
                <span class="letter">O</span>
                <span class="letter">N</span>
                <span class="letter">G</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>

<!-- template 부분은 이전과 동일하므로 style 부분만 수정하겠습니다 -->

<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Chewy&display=swap');

.footer {
  width: 100%;
  background: #272629;
  padding: 2.5rem 2rem;
  color: #fff;
  font-family: 'Noto Sans KR', sans-serif;
}

.footer-container {
  max-width: 1400px;
  margin: 0 auto;
  display: flex;
  gap: 3rem;
}

.large-logo-section {
  flex: 0 0 250px;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  
  .rectangle-3dicons {
    width: 100%;
    height: auto;
    transform: rotate(-49deg);
    object-fit: contain;
  }
}

.footer-content {
  flex: 1;
}

.footer-sections {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 2rem;
  margin-bottom: 2.5rem;
  padding-bottom: 1.5rem;
  border-bottom: 1px solid rgba(255, 255, 255, 0.1);
}

.footer-section {
  .section-title {
    font-size: 1.25rem; // 1.4rem에서 축소
    font-weight: 700;
    margin-bottom: 0.8rem;
    color: #fff;
  }

  .section-text {
    font-size: 0.95rem; // 1.05rem에서 축소
    line-height: 1.5;
    color: rgba(255, 255, 255, 0.7);
    font-weight: 400;
  }
}

.company-info {
  .company-name {
    font-size: 1.4rem; // 1.8rem에서 축소
    font-weight: 700;
    margin-bottom: 1.5rem;
  }

  .info-details {
    display: flex;
    flex-direction: column;
    gap: 0.8rem;
    font-size: 0.9rem; // 1rem에서 축소
    color: rgba(255, 255, 255, 0.7);
    
    p {
      margin: 0.2rem 0;
      line-height: 1.5;
      font-weight: 400;
    }
  }
}

.footer-links {
  margin-top: 1.5rem;
  display: flex;
  gap: 2rem;
  
  .link {
    color: rgba(255, 255, 255, 0.7);
    text-decoration: none;
    font-size: 0.95rem; // 1.1rem에서 축소
    font-weight: 500;
  }
}

.tong-animation-wrapper {
  position: relative;
  width: 100%;
  height: 30vh; // 높이 살짝 조정
  overflow: hidden;
  margin-top: auto;
}

.bouncing-text {
  position: absolute;
  bottom: -20%; // 하단 잘림을 15%로 증가
  left: 0;
  width: 100%;
  text-align: center;
  transform: translateY(10%); // 전체적으로 더 아래로 이동
  
  .letter-container {
    display: inline-flex;
    justify-content: center;
    width: 100%;
    font-family: 'Chewy', cursive;
  }
  
  .letter {
    display: inline-block;
    font-size: 22vw; // 글자 크기 살짝 증가
    color: #939393;
    animation: puddingBounce 2.5s ease-in-out infinite;
    transform-origin: center bottom;
    font-weight: 400;
    line-height: 0.8;
    margin: 0 -0.8vw; // 글자 간격 조정
    
    &:nth-child(1) { animation-delay: 0.0s; }
    &:nth-child(2) { animation-delay: 0.2s; }
    &:nth-child(3) { animation-delay: 0.4s; }
    &:nth-child(4) { animation-delay: 0.6s; }
  }
}

// 애니메이션 높이 조정
@keyframes puddingBounce {
  0%, 100% {
    transform: scale3d(1, 1, 1) translateY(0);
  }
  15% {
    transform: scale3d(1.4, 0.55, 1) translateY(0);
  }
  25% {
    transform: scale3d(0.8, 1.3, 1) translateY(-30px); // 튀어오르는 높이 조정
  }
  35% {
    transform: scale3d(1.2, 0.8, 1) translateY(0);
  }
  45% {
    transform: scale3d(0.9, 1.1, 1) translateY(-15px);
  }
  55% {
    transform: scale3d(1.05, 0.95, 1) translateY(0);
  }
  65% {
    transform: scale3d(0.98, 1.02, 1) translateY(-8px);
  }
  75% {
    transform: scale3d(1.02, 0.98, 1) translateY(0);
  }
  85% {
    transform: scale3d(1, 1, 1) translateY(-4px);
  }
  95% {
    transform: scale3d(1, 1, 1) translateY(0);
  }
}

@media (max-width: 1200px) {
  .footer-container {
    flex-direction: column;
    align-items: center;
    gap: 2rem;
  }

  .large-logo-section {
    flex: 0 0 150px;
  }

  .bouncing-text .letter {
    font-size: 6rem;
  }
}

@media (max-width: 768px) {
  .footer {
    padding: 2rem 1.5rem;
  }

  .footer-sections {
    grid-template-columns: 1fr;
    gap: 1.5rem;
  }
  
  .company-info {
    text-align: center;
    
    .footer-links {
      justify-content: center;
    }
  }

  .footer-section {
    .section-title {
      font-size: 1.1rem;
    }

    .section-text {
      font-size: 0.85rem; 
    }
  }

  .tong-animation-wrapper {
    height: 18vh;
  }
  
  .bouncing-text {
    bottom: -18%; // 모바일에서는 더 많이 잘림
    
    .letter {
      font-size: 24vw;
    }
  }
}

@media (max-width: 480px) {
  .bouncing-text {
    height: 80px;
    margin-bottom: -10px;
    
    .letter {
      font-size: 4rem;
    }
  }
}
</style>

<script>
export default {
  name: 'Footer'
};
</script>