<template>
    <div class="signUp-view">
      <SignUp />
    </div>
  </template>
  
  <script>
  // SignUp 컴포넌트를 불러옵니다.
  import SignUp from '../components/SignUp.vue'
  
  export default {
    name: 'SignUpView',
    components: {
      SignUp
    }
  }
  </script>
  
  <style scoped>
 .signUp-view {
  background-image: url('../assets/images/background.png'); /* 배경 이미지 */
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center; /* 배경 이미지가 중앙에 배치되도록 */
}
  
  </style>
  