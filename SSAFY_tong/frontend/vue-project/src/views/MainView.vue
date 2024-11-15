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

<script>
import Header from '@/components/Header.vue';
import Footer from '@/components/Footer.vue';

export default {
  name: 'MainLayout',
  components: {
    Header,
    Footer
  },
  computed: {
    showHeader() {
      // 현재 페이지의 `meta` 정보를 기반으로 헤더를 표시할지 결정
      return this.$route.meta.layout !== 'none';
    },
    showFooter() {
      // 현재 페이지의 `meta` 정보를 기반으로 풋터를 표시할지 결정
      return this.$route.meta.layout !== 'none';
    }
  }
};
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
  overflow: hidden; /* 스크롤을 사용하지 않도록 */
  /* min-height: 0; 자식 요소가 넘칠 수 있도록 설정 */

  /* min-height: calc(100vh - 20vh); 100vh에서 헤더와 풋터 높이를 뺀 값으로 설정 */
  
  padding-top: 10vh;
  padding-bottom: 20vh;
}

/* header와 footer의 높이를 고정 */
header, footer {
  height: 60px;
}
</style>
