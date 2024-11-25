<template>
  <div class="start-container">
    <section class="slide first-slide">
      <div class="text-content">
        <h1 class="typing-text"><span class="typing-content"></span><span class="cursor"></span></h1>
      </div>
    </section>
    <section class="slide second-slide">
      <img src="@/assets/images/start_img2.png" alt="second slide image" class="second-slide-image">
    </section>
    <section class="slide step-container">
      <div class="step-slide" :class="{ 'active': currentStep === 1, 'prev': currentStep > 1 }">
        <div class="step-content">
          <div class="step-label" :class="{ 'fade-in': currentStep === 1 }">STEP 01</div>
          <div class="text-group">
            <div class="text-main" :class="{ 'slide-in': currentStep === 1 }">안전한 회원 가입</div>
            <div class="text-sub" :class="{ 'slide-in delay-1': currentStep === 1 }">소셜 로그인으로 간편하게</div>
            <div class="text-sub" :class="{ 'slide-in delay-2': currentStep === 1 }">JWT와 안전하게</div>
          </div>
        </div>
      </div>
      <div class="step-slide" :class="{ 'active': currentStep === 2, 'prev': currentStep > 2, 'next': currentStep < 2 }">
        <div class="step-content">
          <div class="step-label" :class="{ 'fade-in': currentStep === 2 }">STEP 02</div>
          <div class="text-group">
            <div class="text-main" :class="{ 'slide-in': currentStep === 2 }">커뮤니티</div>
            <div class="text-sub" :class="{ 'slide-in delay-1': currentStep === 2 }">직접 만드는 자유로운 게시판</div>
            <div class="text-sub" :class="{ 'slide-in delay-2': currentStep === 2 }">인증된 전문가들의 답변</div>
          </div>
        </div>
      </div>
      <div class="step-slide" :class="{ 'active': currentStep === 3, 'prev': currentStep > 3, 'next': currentStep < 3 }">
        <div class="step-content">
          <div class="step-label" :class="{ 'fade-in': currentStep === 3 }">STEP 03</div>
          <div class="text-group">
            <div class="text-main" :class="{ 'slide-in': currentStep === 3 }">전문가 매칭</div>
            <div class="text-sub" :class="{ 'slide-in delay-1': currentStep === 3 }">지도로 찾는 주변의 전문가</div>
            <div class="text-sub" :class="{ 'slide-in delay-2': currentStep === 3 }">내가 보고 고르는 매칭</div>
          </div>
        </div>
      </div>
      <div class="step-slide" :class="{ 'active': currentStep === 4, 'prev': currentStep > 4, 'next': currentStep < 4 }">
        <div class="step-content">
          <div class="step-label" :class="{ 'fade-in': currentStep === 4 }">STEP 04</div>
          <div class="text-group">
            <div class="text-main" :class="{ 'slide-in': currentStep === 4 }">달력을 통한 일정관리</div>
            <div class="text-sub" :class="{ 'slide-in delay-1': currentStep === 4 }">전문가가 내주는 퀘스트</div>
            <div class="text-sub" :class="{ 'slide-in delay-2': currentStep === 4 }">내가 신청하는 예약</div>
          </div>
        </div>
      </div>
      <div class="step-slide" :class="{ 'active': currentStep === 5, 'prev': currentStep > 5, 'next': currentStep < 5 }">
        <div class="step-content">
          <div class="step-label" :class="{ 'fade-in': currentStep === 5 }">STEP 05</div>
          <div class="text-group">
            <div class="text-main gradient-text" :class="{ 'slide-in': currentStep === 5 }">채팅</div>
            <div class="text-sub" :class="{ 'slide-in delay-1': currentStep === 5 }">부담없이 언제라도</div>
            <div class="text-sub" :class="{ 'slide-in delay-2': currentStep === 5 }">사소한 질문이라도</div>
          </div>
        </div>
      </div>
    </section>
    <section class="slide ai-chatbot-slide">
      <div class="model-panels">
        <div class="model-panel" 
             :class="{ 'expanded': selectedPanel === 'llama' }"
             @click="togglePanel('llama')">
          <div class="panel-inner">
            <!-- 기본 패널 내용 -->
            <div class="panel-front">
              <img src="@/assets/images/llama.jpg" alt="Llama" class="model-image">
              <div class="panel-content">
                <h3>Llama 3</h3>
                <p>Meta의 고성능 언어 모델</p>
              </div>
            </div>
            <!-- 확장된 상세 내용 -->
            <div class="panel-details">
              <button class="close-btn" @click.stop="closePanel">×</button>
              <h2>Llama 3</h2>
              <div class="details-content">
                <h3>주요 특징</h3>
                <ul>
                  <li>Meta에서 개발한 최신 언어 모델</li>
                  <li>175B 파라미터 규모의 거대 모델</li>
                  <li>다국어 지원 및 문맥 이해 능력</li>
                  <li>높은 정확도와 자연스러운 대화 가능</li>
                </ul>
                <h3>활용 분야</h3>
                <ul>
                  <li>자연어 처리 및 이해</li>
                  <li>대화형 AI 시스템</li>
                  <li>텍스트 생성 및 분석</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        
        <div class="model-panel"
             :class="{ 'expanded': selectedPanel === 'huggingface' }"
             @click="togglePanel('huggingface')">
          <div class="panel-inner">
            <!-- 기본 패널 내용 -->
            <div class="panel-front">
              <img src="@/assets/images/huggingface.png" alt="Hugging Face" class="model-image">
              <div class="panel-content">
                <h3>Hugging Face</h3>
                <p>최신 AI 모델 플랫폼</p>
              </div>
            </div>
            <!-- 확장된 상세 내용 -->
            <div class="panel-details">
              <button class="close-btn" @click.stop="closePanel">×</button>
              <h2>Hugging Face</h2>
              <div class="details-content">
                <h3>플랫폼 특징</h3>
                <ul>
                  <li>50,000+ 사전 학습 모델 제공</li>
                  <li>커뮤니티 기반 모델 공유</li>
                  <li>손쉬운 모델 배포 및 관리</li>
                  <li>실시간 모델 업데이트</li>
                </ul>
                <h3>지원 기능</h3>
                <ul>
                  <li>모델 학습 및 최적화</li>
                  <li>데이터셋 관리</li>
                  <li>API 서비스 제공</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        
        <div class="model-panel"
             :class="{ 'expanded': selectedPanel === 'maal' }"
             @click="togglePanel('maal')">
          <div class="panel-inner">
            <!-- 기본 패널 내용 -->
            <div class="panel-front">
              <img src="@/assets/images/maal.png" alt="MAAL" class="model-image">
              <div class="panel-content">
                <h3>MAAL</h3>
                <p>마음AI의 다국어 적응형 모델</p>
              </div>
            </div>
            <!-- 확장된 상세 내용 -->
            <div class="panel-details">
              <button class="close-btn" @click.stop="closePanel">×</button>
              <h2>MAAL (Multilingual Adaptive Augmentation Language-model)</h2>
              <div class="details-content">
                <div class="section">
                  <h3>모델 특징</h3>
                  <ul>
                    <li>다국어 기능과 적응형 증강 기술의 혁신적 결합</li>
                    <li>한국어와 영어 이중 언어 지원</li>
                    <li>교차 언어 학습을 통한 명령어 수행 능력 전이</li>
                    <li>8개의 H100-80G GPU로 1일간 학습</li>
                  </ul>
                </div>
                <div class="section">
                  <h3>개발 정보</h3>
                  <ul>
                    <li>개발: maum.ai Brain NLP</li>
                    <li>개발진: 정재윤, 이진주, 이용재, 이동준, 주우성</li>
                    <li>버전: 0.1</li>
                    <li>모델 규모: 8B 파라미터</li>
                  </ul>
                </div>
                <div class="section">
                  <h3>성능 평가</h3>
                  <ul>
                    <li>LogicKor 평가 기준 우수한 성능</li>
                    <li>단일 대화: 5.80점</li>
                    <li>다중 대화: 4.66점</li>
                    <li>평균 점수: 5.23점</li>
                  </ul>
                </div>
                <div class="section">
                  <h3>향후 개발 계획</h3>
                  <ul>
                    <li>한국어 생성 능력 강화</li>
                    <li>한국 문화 지식 확장</li>
                    <li>이미지/비디오 입력 처리 기능 추가</li>
                    <li>지속적인 사전학습 및 개선</li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="ai-content" :class="{ 'blur': selectedPanel !== null }">
        <div class="ai-intro">
          <h2 class="gradient-text">AI 챗봇 통키를 소개합니다</h2>
          <p class="ai-description">Llama3 기반의 인공지능 모델 활용한<br>한국어 언어모델 서비스</p>
          <div class="ai-features">
            <div class="feature">
              <span class="feature-icon">🎯</span>
              <span class="feature-text">개인 맞춤 운동 추천</span>
            </div>
            <div class="feature">
              <span class="feature-icon">📅</span>
              <span class="feature-text">실시간 일정 관리</span>
            </div>
            <div class="feature">
              <span class="feature-icon">💪</span>
              <span class="feature-text">전문적인 운동 조언</span>
            </div>
          </div>
        </div>
        
        <div class="chat-interface show">
          <div class="chat-container">
            <div class="chat-header">
              <div class="tonky-profile">
                <img src="@/assets/images/tonky_orange.png" alt="통키" class="tonky-avatar bounce">
                <span class="status-dot"></span>
              </div>
              <div class="chat-title">통키와 대화하기</div>
            </div>
            
            <div class="chat-messages">
              <div class="message bot-message slide-up">
                <img src="@/assets/images/tonky_orange.png" alt="통키" class="message-avatar">
                <div class="message-content">
                  안녕하세요! 저는 통키예요 😊
                  <div class="typing-indicator">
                    <span></span>
                    <span></span>
                    <span></span>
                  </div>
                </div>
              </div>
              
              <div class="message user-message slide-up delay-1">
                <div class="message-content">
                  통키야, 오늘 운동 일정 알려줘!
                </div>
              </div>
              
              <div class="message bot-message slide-up delay-2">
                <img src="@/assets/images/tonky_orange.png" alt="통키" class="message-avatar">
                <div class="message-content">
                  오늘 PT 일정은 오후 3시입니다.
                  운동 전 준비운동 잊지 마세요! 💪
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <router-link to="/main">
          <button class="main-btn" :class="{ 'hidden': selectedPanel !== null }">Main →</button>
      </router-link>

    </section>
    <!-- Template에 추가할 섹션 -->
    <section class="slide final-slide">
      <div class="ball-container">
        <div class="ball"></div>
      </div>
      <router-link to="/main">
        <button class="final-btn" :class="{ 'show': ballAnimationEnd }">
          시작하기
          <span class="arrow">→</span>
        </button>
      </router-link>
    </section>
  </div>
</template>

<script>
export default {
  name: 'StartView',
  data() {
    return {
      currentStep: 1,
      isAnimating: false,
      wheelAccumulator: 0,
      wheelThreshold: 100,
      selectedPanel: null, 
      ballAnimationEnd: false
    }
  },
  mounted() {
    const textParts = [
      '아직도 직접 찾아다녀?\n 우리 ',
      '통(通)',
      '하면\n다 할 수 있어'
    ];
    this.typeTextWithColor(textParts, '.typing-content', 0, 0, 100);
    
    this.setupWheelListener();

    // 볼 애니메이션이 끝나면 버튼 표시
    const ball = document.querySelector('.ball');
    ball.addEventListener('animationend', () => {
      this.ballAnimationEnd = true;
    });
  },
  methods: {
    typeTextWithColor(textParts, selector, partIndex, charIndex, speed) {
      const element = document.querySelector(selector);
      if (!element) return;

      if (partIndex >= textParts.length) return;

      if (charIndex === 0) {
        if (partIndex === 0) element.innerHTML = '';
      }

      const currentPart = textParts[partIndex];
      const currentText = element.innerHTML;
      
      if (charIndex < currentPart.length) {
        // 현재 파트의 글자를 하나씩 추가
        const newChar = currentPart[charIndex];
        if (partIndex === 1) { // '통(通)' 부분
          element.innerHTML = currentText + `<span style="color: #E2495B ; font-size: 150px ; ">${newChar}</span>`;
        } else {
          element.innerHTML = currentText + newChar;
        }
        
        setTimeout(() => {
          this.typeTextWithColor(textParts, selector, partIndex, charIndex + 1, speed);
        }, speed);
      } else {
        // 다음 파트로 이동
        setTimeout(() => {
          this.typeTextWithColor(textParts, selector, partIndex + 1, 0, speed);
        }, speed);
      }
    },
    setupWheelListener() {
      const stepContainer = document.querySelector('.step-container');
      stepContainer.addEventListener('wheel', this.handleWheel, { passive: false });
    },
    handleWheel(event) {
      event.preventDefault();
      
      if (this.isAnimating) return;
      
      this.wheelAccumulator += event.deltaY;
      
      if (Math.abs(this.wheelAccumulator) >= this.wheelThreshold) {
        if (this.wheelAccumulator > 0) {
          this.nextStep();
        } else {
          this.prevStep();
        }
        this.wheelAccumulator = 0;
      }
    },
    nextStep() {
      if (this.currentStep < 5 && !this.isAnimating) {
        this.isAnimating = true;
        this.currentStep++;
        
        this.resetAnimations();
        
        setTimeout(() => {
          this.isAnimating = false;
        }, 800);
      }
    },
    prevStep() {
      if (this.currentStep > 1 && !this.isAnimating) {
        this.isAnimating = true;
        this.currentStep--;
        
        this.resetAnimations();
        
        setTimeout(() => {
          this.isAnimating = false;
        }, 800);
      }
    },
    resetAnimations() {
      const elements = document.querySelectorAll('.fade-in, .slide-in');
      elements.forEach(element => {
        element.style.animation = 'none';
        element.offsetHeight;
        element.style.animation = '';
      });
    },
    togglePanel(panelName) {
      if (this.selectedPanel === panelName) {
        this.selectedPanel = null;
      } else {
        this.selectedPanel = panelName;
      }
    },
    closePanel() {
      this.selectedPanel = null;
    }
  },
  beforeUnmount() {
    const stepContainer = document.querySelector('.step-container');
    if (stepContainer) {
      stepContainer.removeEventListener('wheel', this.handleWheel);
    }
  }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');

* {
  font-family: 'Noto Sans KR', sans-serif;
}

.start-container {
  width: 100%;
  min-height: 100vh;
}

.slide {
  scroll-snap-align: start;
  min-height: 100vh;
}

.first-slide {
  width: 100%;
  height: 100vh;
  background-image: url('@/assets/images/start_img1.jpg');
  background-size: cover;
  background-position: center;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
}

.first-slide::before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
}

.text-content {
  text-align: left;
  z-index: 1;
  position: relative;
}

.typing-text {
  font-size: 110px;
  color: white;
  white-space: pre-line;
  line-height: 210px;
  overflow: hidden;
}

.cursor {
  border-right: 2px solid white;
  animation: cursor-blink 0.7s infinite;
  margin-left: 2px;
}

@keyframes cursor-blink {
  0%, 100% { border-color: transparent; }
  50% { border-color: white; }
}

.second-slide {
  width: 100%;
  height: auto;
  display: flex;
  align-items: center;
  justify-content: center;
}

.second-slide-image {
  width: 100%;
  height: auto;
  display: block;
}

.step-container {
  position: relative;
  overflow: hidden;
  width: 100%;
  height: 100vh;
  background-color: #f5f5f5;
}

.step-slide {
  position: absolute;
  width: 100%;
  height: 100%;
  transition: transform 0.8s ease-in-out, opacity 0.8s ease-in-out;
  background-size: 55% auto;
  background-position: 85% center;
  background-repeat: no-repeat;
}

.step-slide:nth-child(1) { background-image: url('@/assets/images/step01.png'); }
.step-slide:nth-child(2) { background-image: url('@/assets/images/step02.png'); }
.step-slide:nth-child(3) { background-image: url('@/assets/images/step03.png'); }
.step-slide:nth-child(4) { background-image: url('@/assets/images/step04.png'); }
.step-slide:nth-child(5) { background-image: url('@/assets/images/step05.png'); }

.step-slide {
  transform: translateX(100%);
  opacity: 0;
}

.step-slide.active {
  transform: translateX(0);
  opacity: 1;
}

.step-slide.prev {
  transform: translateX(-100%);
  opacity: 0;
}

.step-slide.next {
  transform: translateX(100%);
  opacity: 0;
}

.step-content {
  position: absolute;
  top: 50%;
  left: 15%;
  transform: translateY(-50%);
  z-index: 2;
}

.step-label {
  color: #EEB5B5;
  font-size: 45px;
  font-weight: 900;
  margin-bottom: 30px;
  opacity: 0;
}

.text-group {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.text-main {
  color: #E2495B;
  margin-top: -80px;
  font-size: 55px;
  font-weight: 600;
  line-height: 150px;
  opacity: 0;
  margin-bottom: 50px;
}

.text-sub {
  color: #999999;
  font-size: 50px;
  margin-top: -17px;
  line-height: 60px;
  font-weight: 500;
  opacity: 0;
}

@keyframes fadeIn {
  from { opacity: 0; }
  to { opacity: 1; }
}

@keyframes slideIn {
  from {
    opacity: 0;
    transform: translateX(-20px);
  }
  to {
    opacity: 1;
    transform: translateX(0);
  }
}

.fade-in {
  animation: none;
  animation: fadeIn 1s ease-in forwards;
}

.slide-in {
  animation: none;
  animation: slideIn 1s ease-out forwards;
}

.delay-1 {
  animation-delay: 0.5s !important;
}

.delay-2 {
  animation-delay: 1s !important;
}

.chat-interface {
  position: absolute;
  right: 10%;
  top: 50%;
  transform: translateY(-50%) translateX(100%);
  width: 400px;
  height: 600px;
  background: rgba(255, 255, 255, 0.95);
  border-radius: 20px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  opacity: 0;
  transition: all 0.8s ease-out;
}

.chat-interface.show {
  transform: translateY(-50%) translateX(0);
  opacity: 1;
}

.chat-container {
  height: 100%;
  display: flex;
  flex-direction: column;
}

.chat-header {
  padding: 20px;
  background: linear-gradient(135deg, #E2495B, #EEB5B5);
  color: white;
  display: flex;
  align-items: center;
  gap: 15px;
}

.tonky-profile {
  position: relative;
}

.tonky-avatar, .message-avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  border: 2px solid white;
  background-color: white;
  padding: 2px;
  object-fit: contain;
}

.status-dot {
  position: absolute;
  bottom: 0;
  right: 0;
  width: 12px;
  height: 12px;
  background-color: #4CAF50;
  border-radius: 50%;
  border: 2px solid white;
  animation: pulse 2s infinite;
}

.chat-messages {
  flex: 1;
  padding: 20px;
  overflow-y: auto;
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.message {
  display: flex;
  align-items: flex-start;
  gap: 10px;
  opacity: 0;
}

.message-avatar {
  width: 30px;
  height: 30px;
  border: 1px solid #E2495B;
}

.message-content {
  padding: 12px 16px;
  border-radius: 18px;
  max-width: 80%;
  font-size: 14px;
  line-height: 1.4;
}

.bot-message .message-content {
  background-color: #f0f0f0;
}

.user-message {
  flex-direction: row-reverse;
}

.user-message .message-content {
  background: linear-gradient(135deg, #E2495B, #EEB5B5);
  color: white;
}

.typing-indicator {
  display: flex;
  gap: 4px;
  padding: 8px 0;
}

.typing-indicator span {
  width: 8px;
  height: 8px;
  background: #999;
  border-radius: 50%;
  animation: typing 1s infinite;
}

.typing-indicator span:nth-child(2) { animation-delay: 0.2s; }
.typing-indicator span:nth-child(3) { animation-delay: 0.4s; }

.gradient-text {
  background: linear-gradient(135deg, #E2495B, #EEB5B5);
  -webkit-background-clip: text;
  background-clip: text;
  -webkit-text-fill-color: transparent;
}

@keyframes slideFromRight {
  from {
    opacity: 0;
    transform: translateX(50px) translateY(-50%);
  }
  to {
    opacity: 1;
    transform: translateX(0) translateY(-50%);
  }
}

@keyframes pulse {
  0% { transform: scale(1); }
  50% { transform: scale(1.2); }
  100% { transform: scale(1); }
}

@keyframes typing {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-5px); }
}

@keyframes bounce {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-5px); }
}

.bounce {
  animation: bounce 2s infinite;
}

.slide-up {
  animation: slideUp 0.5s ease-out forwards;
}

@keyframes slideUp {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

/* 반응형 디자인을 위한 미디어 쿼리 */
@media (max-width: 1200px) {
  .chat-interface {
    right: 5%;
    width: 350px;
    height: 500px;
  }
}

.ai-chatbot-slide {
  background: linear-gradient(135deg, #f8f9fa 0%, #e9ecef 100%);
  position: relative;
  overflow: hidden;
}

.ai-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 1400px;
  margin: 0 auto;
  padding: 0 50px;
  height: 100vh;
}

.ai-intro {
  flex: 1;
  padding-right: 50px;
  opacity: 0;
  transform: translateY(30px);
  animation: fadeInUp 1s ease-out forwards;
}

.ai-intro h2 {
  font-size: 48px;
  margin-bottom: 30px;
  font-weight: 700;
}

.ai-description {
  font-size: 24px;
  color: #666;
  line-height: 1.6;
  margin-bottom: 50px;
}

.ai-features {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.feature {
  display: flex;
  align-items: center;
  gap: 15px;
  padding: 15px 25px;
  background: white;
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.05);
  transform: translateX(-30px);
  opacity: 0;
  animation: slideInFeature 0.5s ease-out forwards;
}

.feature:nth-child(2) {
  animation-delay: 0.2s;
}

.feature:nth-child(3) {
  animation-delay: 0.4s;
}

.feature-icon {
  font-size: 24px;
}

.feature-text {
  font-size: 18px;
  color: #333;
}

@keyframes fadeInUp {
  from {
    opacity: 0;
    transform: translateY(30px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@keyframes slideInFeature {
  from {
    opacity: 0;
    transform: translateX(-30px);
  }
  to {
    opacity: 1;
    transform: translateX(0);
  }
}

/* 반응형 디자인 보완 */
@media (max-width: 1200px) {
  .ai-content {
    flex-direction: column;
    padding: 50px 20px;
  }
  
  .ai-intro {
    padding-right: 0;
    margin-bottom: 50px;
    text-align: center;
  }
  
  .ai-features {
    align-items: center;
  }
  
  .feature {
    width: 100%;
    max-width: 400px;
  }
}

.model-panels {
  position: absolute;
  left: 5%;
  right: 5%;
  top: 10%;
  transform: none;
  display: flex;
  flex-direction: column;
  gap: 20px;
  z-index: 2;
  perspective: 1000px;
}

.model-panel {
  width: 280px;
  position: relative;
  transition: all 0.5s cubic-bezier(0.4, 0, 0.2, 1);
  transform-style: preserve-3d;
  cursor: pointer;
}

.panel-inner {
  position: relative;
  width: 100%;
  height: 100%;
  transform-style: preserve-3d;
  transition: transform 0.6s;
}

.model-panel:not(.expanded):hover .panel-inner {
  transform: translateZ(20px) rotateX(5deg) rotateY(-5deg);
}

.panel-front {
  background: rgba(255, 255, 255, 0.95);
  border-radius: 15px;
  padding: 20px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  transform: translateX(-100%);
  animation: slideInPanel 0.8s ease-out forwards;
  backface-visibility: hidden;
  overflow: hidden;
}

.model-panel.expanded {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  z-index: 1000;
  transform: none !important;
  transform-style: flat;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: flex-start;
  padding: 5vh 2rem;
  overflow-y: auto;
}

.model-panel.expanded .panel-inner {
  width: 80%;
  max-width: 1200px;
  height: 90vh;
  background: white;
  border-radius: 20px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  transform: none !important;
  overflow-y: auto;
  margin-top: 2vh;
}

.model-panel.expanded .panel-details {
  width: 100%;
  height: 100%;
  padding: 3rem;
  opacity: 1;
  visibility: visible;
  overflow-y: auto;
}

.panel-details {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: white;
  padding: 40px;
  opacity: 0;
  visibility: hidden;
  transition: all 0.3s ease;
  overflow-y: auto;
}

.model-panel.expanded .panel-details {
  position: relative;
  opacity: 1;
  visibility: visible;
  width: 100%;
  padding: 60px;
  border-radius: 20px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.details-content {
  margin-top: 40px;
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 40px;
  font-size: 1.1em;
}

.model-panel.expanded h2 {
  font-size: 3em;
  margin-bottom: 30px;
  color: #E2495B;
}

.model-panel.expanded .details-content h3 {
  font-size: 1.8em;
  margin: 20px 0 15px;
}

.model-panel.expanded .details-content li {
  padding: 15px 0;
  font-size: 1.2em;
}

.close-btn {
  position: absolute;
  top: 20px;
  right: 20px;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background: white;
  border: none;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 24px;
  color: #333;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease;
}

.close-btn:hover {
  transform: scale(1.1);
}

/* 반응형 디자인 보완 */
@media (max-width: 1200px) {
  .model-panel.expanded .panel-inner {
    width: 95%;
    height: 95vh;
  }

  .model-panel.expanded .panel-details {
    padding: 40px;
  }

  .details-content {
    grid-template-columns: 1fr;
  }
}

.blur {
  filter: blur(5px);
  pointer-events: none;
  transition: all 0.3s ease;
}

/* 애니메이션 효과 수정 */
@keyframes slideInPanel {
  from {
    opacity: 0;
    transform: translateX(-50px);
  }
  to {
    opacity: 1;
    transform: translateX(0);
  }
}

/* 반응형 디자인 유지 */
@media (max-width: 1400px) {
  .model-panels {
    left: 2%;
    top: 8%;
  }
  
  .model-panel {
    width: 240px;
  }
}

@media (max-width: 1200px) {
  .model-panels {
    display: none;
  }
}

/* 이미지 관련 스타일 수정 */
.model-image {
  width: 100%;
  height: 140px;
  object-fit: cover;
  object-position: center;
  border-radius: 8px;
  margin-bottom: 15px;
  overflow: hidden;
}

.panel-front {
  background: rgba(255, 255, 255, 0.95);
  border-radius: 15px;
  padding: 20px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  transform: translateX(-100%);
  animation: slideInPanel 0.8s ease-out forwards;
  backface-visibility: hidden;
  overflow: hidden;
}

/* 확장된 상태에서의 이미지 스타일 */
.model-panel.expanded .model-image {
  width: auto;
  height: 200px;
  object-fit: contain;
  margin: 0 auto 20px;
  display: block;
}

/* 반응형 디자인 보완 */
@media (max-width: 1200px) {
  .model-panel.expanded .panel-details {
    width: 95%;
    height: 95vh;
    padding: 40px;
  }

  .model-panel.expanded .details-content {
    grid-template-columns: 1fr;
  }
}

/* 패널 확장 시 애니메이션 추가 */
@keyframes expandPanel {
  from {
    transform: scale(0.3);
    opacity: 0;
  }
  to {
    transform: scale(1);
    opacity: 1;
  }
}

.model-panel.expanded .panel-inner {
  animation: expandPanel 0.5s cubic-bezier(0.4, 0, 0.2, 1) forwards;
}

/* 스크롤바 스타일링 */
.model-panel.expanded .panel-inner {
  /* 기존 스타일 유지 */
  scrollbar-width: thin;  /* Firefox를 위한 설정 */
  scrollbar-color:  #777, #777;  /* Firefox를 위한 설정 */
}

/* Webkit (Chrome, Safari, Edge) 브라우저를 위한 스크롤바 스타일링 */
.model-panel.expanded .panel-inner::-webkit-scrollbar {
  width: 6px;  /* 스크롤바 너비 */
}

.model-panel.expanded .panel-inner::-webkit-scrollbar-track {
  background: #f0f0f0;  /* 스크롤바 트랙 배경 */
  border-radius: 10px;
}

.model-panel.expanded .panel-inner::-webkit-scrollbar-thumb {
  background: linear-gradient(135deg,  #777, #777);  /* 그라���이션 적용 */
  border-radius: 10px;
  border: 2px solid transparent;
  background-clip: padding-box;
}

.model-panel.expanded .panel-inner::-webkit-scrollbar-thumb:hover {
  background: linear-gradient(135deg,  #777, #777);  /* 호버 시 더 진한 색상 */
}

/* 패널 디테일 영역의 스크롤바도 동일하게 스타일링 */
.panel-details {
  scrollbar-width: thin;
  scrollbar-color: #777, #777;
}

.panel-details::-webkit-scrollbar {
  width: 6px;
}

.panel-details::-webkit-scrollbar-track {
  background: #f0f0f0;
  border-radius: 10px;
}

.panel-details::-webkit-scrollbar-thumb {
  background: linear-gradient(135deg, #777, #777);
  border-radius: 10px;
  border: 2px solid transparent;
  background-clip: padding-box;
}

.panel-details::-webkit-scrollbar-thumb:hover {
  background: linear-gradient(135deg,#777, #777);
}

/* 메인 버튼 스타일 */
.main-btn.hidden {
  opacity: 0;
  pointer-events: none;
  transform: translateX(-50%) translateY(20px);
}


.main-btn {
  position: absolute;
  left: 50%;            /* 왼쪽에서 50% */
  bottom: 100px;         /* 아래에서 50px */
  transform: translateX(-50%); /* X축으로 버튼 너비의 절반만큼 이동 */
  padding: 20px 80px;
  font-size: 40px;
  font-weight: 600;
  color: white;
  background: linear-gradient(135deg, #E2495B, #EEB5B5);
  border: none;
  border-radius: 30px;
  cursor: pointer;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
  transition: all 0.3s ease;
  z-index: 10;
}

.main-btn:hover {
  transform: translateX(-50%) translateY(-3px); /* 중앙 정렬을 유지하면서 위로 이동 */
  box-shadow: 0 6px 20px rgba(226, 73, 91, 0.2);
}

.main-btn:active {
  transform: translateX(-50%) translateY(0); /* 중앙 정렬을 유지하면서 원위치 */
}



.final-slide {
  background: linear-gradient(135deg, #f8f9fa 0%, #e9ecef 100%);
  position: relative;
  overflow: hidden;
  height: 100vh;
}

.ball-container {
  position: absolute;
  width: 100%;
  height: 100%;
}

.ball {
  width: 60px;
  height: 60px;
  background: linear-gradient(135deg, #E2495B, #EEB5B5);
  border-radius: 50%;
  position: absolute;
  top: -60px;
  left: 10%;
  animation: bounceBall 2s cubic-bezier(0.36, 0, 0.66, 1) forwards;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
}

@keyframes bounceBall {
  0% {
    top: -60px;
    left: 10%;
    transform: scale(1);
  }
  20% {
    top: 30%;
    left: 25%;
    transform: scale(0.8);
  }
  40% {
    top: 10%;
    left: 40%;
    transform: scale(1);
  }
  60% {
    top: 50%;
    left: 55%;
    transform: scale(0.8);
  }
  80% {
    top: 30%;
    left: 70%;
    transform: scale(1);
  }
  100% {
    top: 70%;
    left: 85%;
    transform: scale(0.9);
  }
}

.final-btn {
  position: absolute;
  left: 50%;
  bottom: -100px;  /* 시작할 때는 화면 밖에 위치 */
  transform: translateX(-50%);
  padding: 25px 100px;
  font-size: 44px;
  font-weight: 700;
  color: white;
  background: linear-gradient(135deg, #E2495B, #EEB5B5);
  border: none;
  border-radius: 50px;
  cursor: pointer;
  opacity: 0;
  transition: all 0.8s cubic-bezier(0.4, 0, 0.2, 1);
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
}

.final-btn.show {
  bottom: 100px;
  opacity: 1;
}

.final-btn:hover {
  transform: translateX(-50%) translateY(-5px);
  box-shadow: 0 8px 25px rgba(226, 73, 91, 0.3);
}

.final-btn:active {
  transform: translateX(-50%) translateY(0);
}

.arrow {
  display: inline-block;
  margin-left: 10px;
  transition: transform 0.3s ease;
}

.final-btn:hover .arrow {
  transform: translateX(10px);
}


</style>
