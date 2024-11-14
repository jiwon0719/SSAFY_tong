<template>
  <div class="start-view">

    
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
  display: flex;
  justify-content: center;  /* 수평 중앙 정렬 */
  align-items: center;      /* 수직 중앙 정렬 */
  height: 100vh;            /* 화면 전체 높이 */
  padding: 0;               /* 불필요한 패딩 제거 */
  margin: 0;                /* 불필요한 마진 제거 */
}

button {
  margin-top: 20px;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
}
</style>
