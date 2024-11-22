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
  position: relative;
}

.main-content {
  flex: 1 0 auto;
  width: 100%;
  padding-top: 100px; /* 헤더 높이만큼만 패딩 지정 */
  /* margin-bottom: 300px; */
  background-color: #f8f9fa; /* 추가된 부분 */
}

/* Header 스타일 */
:deep(header) {
  position: fixed;
  top: 0;
  width: 100%;
  z-index: 100;
  height: 60px;
}

/* Footer 스타일 */
:deep(footer) {
  flex-shrink: 0;
  width: 100%;
}
</style>