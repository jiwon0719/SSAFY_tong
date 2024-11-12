<template>
    <div class="start-view">
      <!-- 버튼 클릭 시 Main 페이지로 이동 -->
      <Start />
    </div>
  </template>
  
  <script>
  // Start 컴포넌트를 불러옵니다.
  import Start from '../components/Start.vue'
  
  export default {
    name: 'StartView',
    components: {
      Start
    },
  }
  </script>

<style scoped>
.start-view {
  text-align: center;
  padding: 20px;
}

button {
  margin-top: 20px;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
}
</style>
