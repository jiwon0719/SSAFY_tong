<template>
    <div>
      <h1>카카오맵 페이지</h1>
      <KakaoMap />  <!-- 카카오맵 컴포넌트 포함 -->
    </div>
  </template>
  
  <script>
  import KakaoMap from '../components/KakaoMap.vue';  // KakaoMap 컴포넌트 import
  
  export default {
    name: 'KakaoMapPage',
    components: {
      KakaoMap,  // 카카오맵 컴포넌트 등록
    }
  }
  </script>
  