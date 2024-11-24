<template>
  <div class="container" ref="containerRef">
    <div class="grape-container" :style="transformStyle">
      <svg viewBox="0 0 200 240" width="300" height="300">
        <defs>
          <!-- 포도 그라데이션 -->
          <radialGradient id="grapeGradient">
            <stop offset="0%" stop-color="#9F7AEA"/>
            <stop offset="100%" stop-color="#7C3AED"/>
          </radialGradient>
          <!-- 잎사귀 그라데이션 -->
          <linearGradient id="leafGradient">
            <stop offset="0%" stop-color="#4ADE80"/>
            <stop offset="100%" stop-color="#22C55E"/>
          </linearGradient>

          <radialGradient id="glowGradient">
            <stop offset="0%" stop-color="rgba(159, 122, 234, 0.3)"/>
            <stop offset="70%" stop-color="rgba(159, 122, 234, 0.1)"/>
            <stop offset="100%" stop-color="rgba(159, 122, 234, 0)"/>
          </radialGradient>
        </defs>

        <g :style="popoutStyle.glow">
          <circle cx="100" cy="130" r="80" fill="url(#glowGradient)">
            <animate
              attributeName="r"
              values="80;85;80"
              dur="3s"
              repeatCount="indefinite"
            />
          </circle>
        </g>
        
        <!-- Animated Leaves -->
        <g :style="popoutStyle.leaves">
          <path d="M90 40 C60 20, 120 20, 100 50" fill="url(#leafGradient)">
            <animateTransform
              attributeName="transform"
              type="rotate"
              values="-2 100 50; 2 100 50; -2 100 50"
              dur="3s"
              repeatCount="indefinite"
            />
          </path>
          <path d="M110 35 C140 15, 160 45, 120 55" fill="url(#leafGradient)">
            <animateTransform
              attributeName="transform"
              type="rotate"
              values="2 120 55; -2 120 55; 2 120 55"
              dur="3.5s"
              repeatCount="indefinite"
            />
          </path>
        </g>

        <!-- Grape cluster with pulse animation -->
        <g :style="popoutStyle.grapes">
          <circle cx="60" cy="100" r="30" fill="url(#grapeGradient)">
            <animate
              attributeName="r"
              values="30;31;30"
              dur="2s"
              repeatCount="indefinite"
            />
          </circle>
          <circle cx="100" cy="100" r="30" fill="url(#grapeGradient)">
            <animate
              attributeName="r"
              values="30;31;30"
              dur="2.3s"
              repeatCount="indefinite"
            />
          </circle>
          <circle cx="140" cy="100" r="30" fill="url(#grapeGradient)">
            <animate
              attributeName="r"
              values="30;31;30"
              dur="1.7s"
              repeatCount="indefinite"
            />
          </circle>
          <circle cx="80" cy="140" r="25" fill="url(#grapeGradient)">
            <animate
              attributeName="r"
              values="25;26;25"
              dur="2.1s"
              repeatCount="indefinite"
            />
          </circle>
          <circle cx="120" cy="140" r="25" fill="url(#grapeGradient)">
            <animate
              attributeName="r"
              values="25;26;25"
              dur="1.9s"
              repeatCount="indefinite"
            />
          </circle>
          <circle cx="100" cy="170" r="20" fill="url(#grapeGradient)">
            <animate
              attributeName="r"
              values="20;21;20"
              dur="2.2s"
              repeatCount="indefinite"
            />
          </circle>
        </g>

        <!-- Eyes -->
        <g class="eyes" :style="popoutStyle.eyes">
          <!-- Left eye -->
          <circle cx="80" cy="120" r="12" fill="white"/>
          <circle 
            :cx="80 + leftEyePosition.x" 
            :cy="120 + leftEyePosition.y" 
            r="6" 
            fill="black"
          />
          <circle 
            :cx="78 + leftEyePosition.x" 
            :cy="118 + leftEyePosition.y" 
            r="2" 
            fill="white"
          />

          <!-- Right eye -->
          <circle cx="120" cy="120" r="12" fill="white"/>
          <circle 
            :cx="120 + rightEyePosition.x" 
            :cy="120 + rightEyePosition.y" 
            r="6" 
            fill="black"
          />
          <circle 
            :cx="118 + rightEyePosition.x" 
            :cy="118 + rightEyePosition.y" 
            r="2" 
            fill="white"
          />
        </g>

        <!-- Cheeks with fade animation -->
        <g :style="popoutStyle.cheeks">
          <circle cx="70" cy="135" r="8" fill="#FCA5A5">
            <animate
              attributeName="opacity"
              values="0.4;0.6;0.4"
              dur="2s"
              repeatCount="indefinite"
            />
          </circle>
          <circle cx="130" cy="135" r="8" fill="#FCA5A5">
            <animate
              attributeName="opacity"
              values="0.4;0.6;0.4"
              dur="2s"
              repeatCount="indefinite"
            />
          </circle>
        </g>

        <!-- Mouth -->
        <circle cx="100" cy="144" r="7" fill="#FF9999"/>
      </svg>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive, onMounted, onUnmounted, computed } from 'vue'

const containerRef = ref(null)
const leftEyePosition = reactive({ x: 0, y: 0 })
const rightEyePosition = reactive({ x: 0, y: 0 })

// 3D 변환을 위한 상태 추가
const rotation = reactive({ x: 0, y: 0 })
const isHovered = ref(false)

// 3D 변환 스타일 계산
const transformStyle = computed(() => ({
  transform: `rotateY(${rotation.y}deg) rotateX(${rotation.x}deg)`,
  transition: isHovered.value ? 'none' : 'all 0.5s ease'
}))

// 팝아웃 효과를 위한 스타일
const popoutStyle = reactive({
  glow: { transform: 'translateZ(0px)' },
  leaves: { transform: 'translateZ(0px)' },
  grapes: { transform: 'translateZ(0px)' },
  eyes: { transform: 'translateZ(0px)' },
  cheeks: { transform: 'translateZ(0px)' }
})

const handleMouseMove = (e) => {
  if (!containerRef.value) return

  const rect = containerRef.value.getBoundingClientRect()
  const centerX = rect.left + rect.width / 2
  const centerY = rect.top + rect.height / 2

  // 눈 움직임 계산
  const angle = Math.atan2(e.clientY - centerY, e.clientX - centerX)
  const distance = 4
  const moveX = Math.cos(angle) * distance
  const moveY = Math.sin(angle) * distance

  leftEyePosition.x = moveX
  leftEyePosition.y = moveY
  rightEyePosition.x = moveX
  rightEyePosition.y = moveY

  // 3D 회전 계산
  rotation.y = (e.clientX - centerX) / 20
  rotation.x = -(e.clientY - centerY) / 20
}

const handleMouseEnter = () => {
  isHovered.value = true
  // 요소들 팝아웃 효과
  popoutStyle.glow.transform = 'translateZ(50px)'
  popoutStyle.leaves.transform = 'translateZ(100px)'
  popoutStyle.grapes.transform = 'translateZ(75px)'
  popoutStyle.eyes.transform = 'translateZ(90px)'
  popoutStyle.cheeks.transform = 'translateZ(60px)'
}

const handleMouseLeave = () => {
  isHovered.value = false
  rotation.x = 0
  rotation.y = 0
  // 요소들 원위치
  Object.keys(popoutStyle).forEach(key => {
    popoutStyle[key].transform = 'translateZ(0px)'
  })
}

onMounted(() => {
  window.addEventListener('mousemove', handleMouseMove)
  containerRef.value?.addEventListener('mouseenter', handleMouseEnter)
  containerRef.value?.addEventListener('mouseleave', handleMouseLeave)
})

onUnmounted(() => {
  window.removeEventListener('mousemove', handleMouseMove)
  containerRef.value?.removeEventListener('mouseenter', handleMouseEnter)
  containerRef.value?.removeEventListener('mouseleave', handleMouseLeave)
})
</script>

<style scoped>
.container {
  perspective: 1000px;
  padding: 2rem;
}

.grape-container {
  transform-style: preserve-3d;
  will-change: transform;
}

.eyes circle {
  transition: transform 0.2s ease;
}

/* 모든 SVG 그룹에 트랜지션 효과 추가 */
g {
  transition: transform 0.3s ease-out;
}
</style>