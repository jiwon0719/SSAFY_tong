<template>
  <div class="layout">
    <Header v-if="showHeader" />
    <main class="main-content">
      <router-view />
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
const showHeader = ref(true);
const showFooter = ref(true);

onMounted(() => {
  router.push({ name: 'mainDefault' }).catch((err) => {
    console.error('라우팅 오류:', err);
  });
});
</script>

<style scoped>
.layout {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.main-content {
  flex: 1;
  width: 100%;
  margin-top: 100px; /* 헤더 높이만큼 여백 */
  margin-bottom: 20vh; /* Footer 높이만큼 여백 */
  padding: 20px;
  position: relative; /* 자식 요소들의 위치 기준점 */
}

/* header와 footer는 자신의 컴포넌트에서 높이 정의 */
</style>