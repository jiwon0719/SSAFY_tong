<template>
  <div class="layout">
    <!-- 로그인 화면에서는 헤더와 풋터를 숨기기 위해 조건부 렌더링 -->
    <Header v-if="showHeader" />
    <main class="main-content">
      <router-view /> <!-- 여기에 동적으로 페이지 콘텐츠가 렌더링됨 -->
    </main>
    <Footer v-if="showFooter" />
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';

import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

const router = useRouter();
const showHeader = ref(true);  // 헤더 표시 여부
const showFooter = ref(true);  // 풋터 표시 여부

onMounted(() => {
  // 로그인 후 리디렉션 처리
  router.push({ name: 'mainDefault' }).catch((err) => {
    console.error('라우팅 오류:', err);
  });
});
</script>



<style scoped>
.layout {
  display: flex;
  flex-direction: column;
  min-height: 100vh; /* 화면을 꽉 채우기 */
}

.main-content {
  flex-grow: 1;  /* 공간을 다 차지하도록 설정 */
  padding: 20px; /* 여백을 추가 */
  height: calc(100vh - 120px); /* Header(60px) + Footer(60px) = 120px */
  /* overflow: hidden; 스크롤을 사용하지 않도록 */
  /* min-height: 0; 자식 요소가 넘칠 수 있도록 설정 */

  /* min-height: calc(100vh - 20vh); 100vh에서 헤더와 풋터 높이를 뺀 값으로 설정 */
  
  padding-top: 10vh;
  padding-bottom: 100vh;
  position: relative; /* 추가 */
}

/* header와 footer의 높이를 고정 */
header, footer {
  flex: 0 0 60px; /* flex: none으로 고정 높이 설정 */
  /* height: 60px; */
}
</style>