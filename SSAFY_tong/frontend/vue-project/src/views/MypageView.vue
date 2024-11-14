<template>
    <div class="mypage-view">
      <Mypage />
    </div>
  </template>
  
  <script>
  // Community 컴포넌트를 불러옵니다.
  import Mypage from '@/components/Mypage.vue'
  
  export default {
    name: 'MypageView',
    components: {
      Mypage
    }
  }
  </script>
  
  <style scoped>
  
  </style>
  