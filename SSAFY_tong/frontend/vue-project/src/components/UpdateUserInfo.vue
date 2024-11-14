<template>
    <div>
        <h2> 아직 개발중입니다...</h2>
      <img :src="gifUrl" alt="my-gif" class="gif-image" />
      
    </div>
  </template>
  
  <script>
  import developingGif from '@/assets/images/doggy.webp'; 
  
  export default {
    name: 'MyComponent',
    data() {
      return {
        gifUrl: developingGif // 데이터를 통해 이미지 경로를 할당
      };
    }
  };
  </script>
  
  <style lang="scss">
  .gif-image {
    width: 100%;    /* 화면 너비에 맞게 조정 */
    height: auto;   /* 비율에 맞춰 높이 조정 */
    display: block; /* 블록 요소로 설정 */
    margin: 0 auto; /* 중앙 정렬 */
  }
  </style>
  