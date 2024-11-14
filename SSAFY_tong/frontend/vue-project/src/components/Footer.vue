<template>
    <div class="footer">
      <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/e444649ac77c0d7952f2c62fdd0aaaf2.png" class="rectangle-3dicons" />
      <div class="footer-content">
        <div class="footertext">
          <div class="text-ssafy-tong">
            (주)SSAFY_TONG
          </div>
          <div class="text-address">
            대전시 유성구 대전 유성구 동서대로 98-39 교육동 2층
          </div>
          <div class="text-address-eng">
            2nd Floor, Education Building, 98-39 Dongseo-daero, Yuseong-gu, Daejeon, South Korea.
          </div>
          <div class="text-business-number">
            사업자 번호 : 추가 예정..
          </div>
          <div class="email-hjw">
            hjw9265@naver.com
          </div>
          <div class="email-tmdgh">
            tmdgh0124@naver.com
          </div>
          <div class="text-copyright">
            본 사이트의 컨텐츠는 저작권법의 보호를 받는 바 무단 전재, 복사, 배포 등을 금합니다.
          </div>
          <div class="copyright">
            Copyright © 2024~ TONG. All Rights Reserved.
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <style lang="scss">
  .footer {
    width: 100%; /* 화면 너비의 100% */
    height: 20vh; /* 화면 높이에 비례하여 높이를 20%로 설정 */
    background: #272629;
    display: flex;
    justify-content: flex-start; /* 아이콘을 왼쪽으로 고정 */
    align-items: center; /* 수직 중앙 정렬 */
    position: relative; /* 내부 요소들을 절대 위치로 배치할 수 있게 함 */
    padding: 2vh 0; /* 상하 여백 설정 */
  }
  
  .footer-content {
    display: flex;
    justify-content: flex-start; /* 왼쪽 정렬 */
    align-items: center; /* 수직 중앙 정렬 */
    width: 100%; /* 전체 너비 */
    max-width: 1800px;
    position: relative; /* 자식 요소들의 위치를 상대적으로 설정 */
  }
  
  .footertext {
    width: 100%; /* 텍스트 영역의 너비는 100% */
    color: white;
    font-family: "Jockey One";
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 1vh; /* 항목 간의 간격을 화면 높이에 비례해서 설정 */
    text-align: center; /* 텍스트 중앙 정렬 */
    position: absolute; /* 부모인 .footer 기준으로 절대 위치 */
    top: 50%; /* 부모 높이의 50% */
    left: 50%; /* 부모 너비의 50% */
    transform: translate(-50%, -50%); /* 정확한 중앙 위치 */
  }
  
  .text-ssafy-tong,
  .text-address,
  .text-address-eng,
  .text-business-number,
  .email-hjw,
  .email-tmdgh,
  .text-copyright,
  .copyright {
    font-size: 14px; /* 모든 텍스트의 글꼴 크기를 12px로 고정 */
    font-weight: 400;
    line-height: 16px; /* 줄 간격 설정 */
  }
  
  .rectangle-3dicons {
    width: 7vw; /* 아이콘의 크기를 화면 너비의 7%로 설정 */
    height: auto;
    transform: rotate(-49deg); /* 아이콘 회전 */
    object-fit: cover;
    margin-right: 2vw; /* 아이콘과 텍스트 간에 여백 추가 */
    margin-left: 5%;
  }
  </style>
  
  <script>
  export default {
    name: 'Footer',
  };
  </script>
  