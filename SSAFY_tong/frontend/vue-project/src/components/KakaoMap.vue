<script setup>
import { ref, onMounted } from 'vue'
const { VITE_KAKAO_MAP_KEY } = import.meta.env

const mapContainer = ref(null)

onMounted(() => {
  loadKakaoMap(mapContainer.value)
})

const loadKakaoMap = (container) => {
  const script = document.createElement('script')
  script.src = `https://dapi.kakao.com/v2/maps/sdk.js?appkey=0e4d5f62669f86228a4f4cd5a2de285f&autoload=false`
  document.head.appendChild(script)

  script.onload = () => {
    window.kakao.maps.load(() => {
      const options = {
        center: new window.kakao.maps.LatLng(36.355339, 127.297577), // 지도 중심 좌표
        level: 3, // 지도 확대 레벨
        maxLevel: 5, // 지도 축소 제한 레벨
      }

      const mapInstance = new window.kakao.maps.Map(container, options) // 지도 생성
    })
  }
}
</script>

<template>
  <div ref="mapContainer" style="width: 100%; height: 70vh"></div>
</template>

<style scoped>
</style>