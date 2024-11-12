<template>
    <div class="main-view">
      <!-- Main 컴포넌트를 불러와서 표시합니다 -->
      <Main />
    </div>
  </template>
  
  <script>
  // Main 컴포넌트를 불러옵니다.
  import Main from '../components/Main.vue'
  
  export default {
    name: 'MainView',
    components: {
      Main
    }
  }
  </script>
  
  <style scoped>
  .main-view {
    padding: 20px;
  }
  </style>
  