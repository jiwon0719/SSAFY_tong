<template>
    <div class="signIn-view">
      <SignIn />
    </div>
  </template>
  
  <script>
  // SignIn 컴포넌트를 불러옵니다.
  import SignIn from '../components/SignIn.vue'
  
  export default {
    name: 'SignInView',
    components: {
      SignIn
    }
  }
  </script>
  
  <style scoped>
  .signIn-view {
    padding: 20px;
  }
  </style>
  