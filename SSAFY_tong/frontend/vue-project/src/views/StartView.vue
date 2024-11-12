<template>
    <div class="start-view">
      <h1>Welcome to Start Page</h1>
      <!-- 버튼 클릭 시 Main 페이지로 이동 -->
      <Start />
      <button @click="goToMainPage">Go to Main Page</button>
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
    methods: {
      goToMainPage() {
        // Vue Router를 사용하여 Main 페이지로 이동
        this.$router.push({ name: 'main' })
      }
    }
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
