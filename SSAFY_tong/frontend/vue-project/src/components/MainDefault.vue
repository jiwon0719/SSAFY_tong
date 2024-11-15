<template>
    <div class="main-container">
      <div class="quadrant quadrant-1">날씨</div>
      <div class="quadrant quadrant-2">예약내역</div>
      <div class="quadrant quadrant-3">게시판</div>
      <div class="quadrant quadrant-4">..</div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'MainDefault',
  };
  </script>
  
  <style scoped lang="scss">
  /* 부모 요소 설정 */
  html, body {
    height: 100%; /* 부모 요소가 화면을 꽉 채우도록 설정 */
    margin: 0; /* 기본 여백 제거 */
  }
  
  .main-container {
    display: grid;
    grid-template-columns: 1fr 1fr; /* 2개의 열로 나누기 */
    grid-template-rows: 1fr 1fr; /* 2개의 행으로 나누기 */
    gap: 20px; /* 각 사분면 사이의 간격 */
    height: 100vh; /* 화면을 꽉 채우도록 설정 */
    width: 100%; /* 부모 요소의 너비에 맞게 설정 */
    padding: 30px; /* 경계와의 간격 */
    box-sizing: border-box; /* padding이 크기 계산에 포함되도록 설정 */
  
    /* 각 사분면 스타일 */
    .quadrant {
      display: flex;
      justify-content: center;
      align-items: center;
      border: 1px solid #ccc; /* 테두리 */
      border-radius: 10px; /* 둥근 모서리 */
      background-color: #f4f4f4; /* 배경 색상 */
      font-size: 24px; /* 텍스트 크기 */
      font-weight: bold;
      color: #333;
    }
  
    /* 각 사분면에 다른 색상 적용 */
    .quadrant-1 {
      background-color: #ffcccb; /* 제1사분면 색상 */
    }
    .quadrant-2 {
      background-color: #cce7ff; /* 제2사분면 색상 */
    }
    .quadrant-3 {
      background-color: #d1ffcc; /* 제3사분면 색상 */
    }
    .quadrant-4 {
      background-color: #fff5b0; /* 제4사분면 색상 */
    }
  }
  
  /* 작은 화면에서 사분면이 세로로 배치되도록 반응형 처리 */
  @media screen and (max-width: 768px) {
    .main-container {
      grid-template-columns: 1fr; /* 1열로 변경 */
      grid-template-rows: repeat(4, 1fr); /* 4개의 행으로 변경 */
    }
  }
  </style>
  