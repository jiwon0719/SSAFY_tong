<template>
    <div class="commnunity-view">
      <!-- Community 컴포넌트를 불러와서 표시합니다 -->
      <Community />
    </div>
  </template>
  
  <script>
  // Community 컴포넌트를 불러옵니다.
  import Community from '../components/Community.vue'
  
  export default {
    name: 'CommnuiView',
    components: {
      Community
    }
  }
  </script>
  
  <style scoped>
  .commnunity-view {
    padding: 20px;
  }
  </style>
  