<template>
  <div class="container" ref="container" @click="handleClick"></div>
</template>

<script setup>
import { onMounted, ref, reactive, computed, onUnmounted, watch } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import * as THREE from 'three'
import { FBXLoader } from 'three/examples/jsm/loaders/FBXLoader'
import gsap from 'gsap'

const router = useRouter()
const route = useRoute()
const container = ref(null)
const scene = new THREE.Scene()
const camera = new THREE.PerspectiveCamera()
const renderer = new THREE.WebGLRenderer()
let horse = null
let mixer = null  // 애니메이션 믹서 추가
const isHovered = ref(false)

// 회전 상태 관리
const rotation = reactive({
  targetX: 0,
  targetY: 0,
  currentX: 0,
  currentY: 0
})

// 걷기 애니메이션 상태 수정
const walkAnimation = reactive({
  time: 0,
  speed: 0.0125,
  legAmplitude: 0.3,
  armAmplitude: 0.2,
  active: false
})

// 점프 애니메이션 상태 추가
const jumpAnimation = reactive({
  active: false,
  time: 0,
  duration: 1.0,  // 점프 전체 시간 (초)
  height: 2,      // 최대 점프 높이
  startY: -1,     // 시작 높이 (현재 position.y 값)
  onComplete: null  // 애니메이션 완료 후 실행할 콜백 추가
})

// 본 참조 저장용 객체
const bones = {
  leftThigh: null,
  rightThigh: null,
  leftCalf: null,
  rightCalf: null,
  leftFoot: null,
  rightFoot: null,
  leftUpperarm: null,
  rightUpperarm: null,
  leftForearm: null,
  rightForearm: null,
  spine: null
}

// MypageView 체크
const isMypageView = computed(() => route.path.includes('/mypage/aichat'))

// props 추가
const props = defineProps({
  isLoading: {
    type: Boolean,
    default: false
  }
})

// watch 수정
watch(() => props.isLoading, (newValue) => {
  console.log('Loading state changed:', newValue, 'Horse:', horse, 'Bones:', bones) // 디버깅 강화
  
  if (!horse || !bones.spine) return // 모델이 로드되지 않았으면 리턴

  if (newValue) {
    console.log('Transitioning to thinking pose') // 디버깅
    // 로딩 시작 - 걷기 애니메이션 즉시 중지
    walkAnimation.active = false
    rotation.targetX = 0
    rotation.targetY = 0
    rotation.currentX = 0
    rotation.currentY = 0
  } else {
    console.log('Transitioning back to walking') // 디버깅
    // 로딩 종료 - 원래 상태로 복귀
    walkAnimation.active = true
  }
})

onMounted(() => {
  // Camera 설정
  if (isMypageView.value) {
    // MypageView에서의 설정
    camera.fov = 60
    camera.aspect = 1
    camera.near = 0.1
    camera.far = 1000
    camera.position.z = 10  // 더 가깝게
    camera.position.y = 2  // 더 낮게
    camera.lookAt(0, -1, 0)
  } else {
    // MainDefault에서의 기존 설정 유지
    camera.fov = 75
    camera.aspect = 1
    camera.near = 0.1
    camera.far = 1000
    camera.position.z = 12
    camera.position.y = 2
    camera.lookAt(0, -0.5, 0)
  }
  camera.updateProjectionMatrix()
  
  // Renderer 설정
  const containerWidth = isMypageView.value ? 1000 : 600
  const containerHeight = isMypageView.value ? 1000 : 600
  renderer.setSize(containerWidth, containerHeight)
  renderer.setClearColor(0x000000, 0)
  renderer.setPixelRatio(window.devicePixelRatio)
  renderer.alpha = true
  container.value.appendChild(renderer.domElement)
  
  // TextureLoader 설정
  const textureLoader = new THREE.TextureLoader()
  const baseColorTexture = textureLoader.load('/Horse_BaseColor.png')
  
  // FBX 로딩
  const fbxLoader = new FBXLoader()
  fbxLoader.load('/Horse.fbx', (object) => {
    horse = object
    
    if (isMypageView.value) {
      // MypageView에서의 설정
      object.scale.set(0.06, 0.06, 0.06)  // 더 크게
      object.position.y = -6  // 위치 조정
    } else {
      // MainDefault에서의 기존 설정
      object.scale.set(0.08, 0.08, 0.08)
      object.position.y = -5
    }
    object.rotation.y = 0
    
    // 본 찾기 로직 수정
    object.traverse((child) => {
      if (child.isMesh) {
        // 재질 설정
        child.material = new THREE.MeshStandardMaterial({
          map: baseColorTexture,
          roughness: 0.5,
          metalness: 0.0
        })
      }
      
      // 본 이름으로 정확히 찾기
      if (child.type === 'Bone') {
        switch(child.name) {
          case 'CharacterLThigh': bones.leftThigh = child; break;
          case 'CharacterRThigh': bones.rightThigh = child; break;
          case 'CharacterLCalf': bones.leftCalf = child; break;
          case 'CharacterRCalf': bones.rightCalf = child; break;
          case 'CharacterLUpperarm': bones.leftUpperarm = child; break;
          case 'CharacterRUpperarm': bones.rightUpperarm = child; break;
          case 'CharacterLForearm': bones.leftForearm = child; break;
          case 'CharacterRForearm': bones.rightForearm = child; break;
          case 'CharacterSpine1': bones.spine = child; break;
        }
      }
    })
    
    // 본 구조 확인
    walkAnimation.active = true  // 애니메이션 활성화
    
    scene.add(object)
  }, 
  // 로딩 진행률
  (xhr) => {
    console.log((xhr.loaded / xhr.total * 100) + '% loaded')
  },
  // 에러 처리
  (error) => {
    console.error('FBX 로딩 에러:', error)
  })
  
  // 조명 설정 개선
  const ambientLight = new THREE.AmbientLight(0xffffff, 0.8)
  scene.add(ambientLight)
  
  const directionalLight = new THREE.DirectionalLight(0xffffff, 1.0)
  directionalLight.position.set(1, 1, 1)
  scene.add(directionalLight)
  
  // 애니메이션 루프
  const clock = new THREE.Clock()
  
  function animate() {
    // 4프레임당 1번만 실행되도록 수정
    if (window.frameCount === undefined) {
      window.frameCount = 0;
    }
    window.frameCount++;
    
    if (window.frameCount % 4 === 0) {  // 4프레임마다 한 번만 실행
      if (horse) {
        if (walkAnimation.active) {
          // 마우스 회전 로직
          rotation.currentX += (rotation.targetX - rotation.currentX) * 0.05 * 4  // 4배 보정
          rotation.currentY += (rotation.targetY - rotation.currentY) * 0.05 * 4  // 4배 보정
          
          horse.rotation.x = rotation.currentX
          horse.rotation.y = rotation.currentY
          
          // 걷기 애니메이션
          walkAnimation.time += walkAnimation.speed * 4  // 4배 보정
          
          // 다리 움직임
          if (bones.leftThigh) {
            const leftLegRotation = Math.sin(walkAnimation.time) * walkAnimation.legAmplitude
            bones.leftThigh.rotation.x = leftLegRotation
            
            if (bones.leftCalf) {
              bones.leftCalf.rotation.x = Math.sin(walkAnimation.time + Math.PI/4) * walkAnimation.legAmplitude * 0.5
            }
          }
          
          if (bones.rightThigh) {
            bones.rightThigh.rotation.x = Math.sin(walkAnimation.time + Math.PI) * walkAnimation.legAmplitude
            if (bones.rightCalf) {
              bones.rightCalf.rotation.x = Math.sin(walkAnimation.time + Math.PI + Math.PI/4) * walkAnimation.legAmplitude * 0.5
            }
          }
          
          // 팔 움직임
          if (bones.leftUpperarm) {
            bones.leftUpperarm.rotation.x = Math.sin(walkAnimation.time + Math.PI) * walkAnimation.armAmplitude
            if (bones.leftForearm) {
              bones.leftForearm.rotation.x = Math.sin(walkAnimation.time + Math.PI + Math.PI/4) * walkAnimation.armAmplitude * 0.5
            }
          }
          
          if (bones.rightUpperarm) {
            bones.rightUpperarm.rotation.x = Math.sin(walkAnimation.time) * walkAnimation.armAmplitude
            if (bones.rightForearm) {
              bones.rightForearm.rotation.x = Math.sin(walkAnimation.time + Math.PI/4) * walkAnimation.armAmplitude * 0.5
            }
          }
          
          // 몸체 움직임
          if (bones.spine) {
            bones.spine.rotation.x = Math.sin(walkAnimation.time * 2) * 0.05
          }
        }
        
        // 점프 애니메이션
        if (jumpAnimation.active) {
          jumpAnimation.time += 0.016 * 4  // 4배 보정
          
          // 사인 곡선을 사용한 부드러운 점프
          const progress = jumpAnimation.time / jumpAnimation.duration
          
          if (progress <= 1) {
            // 포물선 형태의 점프 (sin 곡선 사용)
            const jumpHeight = Math.sin(progress * Math.PI) * jumpAnimation.height
            horse.position.y = jumpAnimation.startY + jumpHeight
            
            // 점프할 때 약간 앞으로 기울이기
            const tiltAngle = Math.sin(progress * Math.PI * 2) * 0.2
            horse.rotation.x = rotation.currentX + tiltAngle
            
            // 다리 움직임 추가
            if (bones.leftThigh && bones.rightThigh) {
              // 점프 시작시 다리 접기
              const legAngle = Math.sin(progress * Math.PI) * 0.5
              bones.leftThigh.rotation.x = -legAngle
              bones.rightThigh.rotation.x = -legAngle
              bones.leftCalf.rotation.x = legAngle
              bones.rightCalf.rotation.x = legAngle
            }
          } else {
            // 점프 종료
            jumpAnimation.active = false
            horse.position.y = jumpAnimation.startY
            // 다리 원위치
            if (bones.leftThigh && bones.rightThigh) {
              bones.leftThigh.rotation.x = 0
              bones.rightThigh.rotation.x = 0
              bones.leftCalf.rotation.x = 0
              bones.rightCalf.rotation.x = 0
            }
            
            // 애니메이션 완료 후 콜백 실행
            if (jumpAnimation.onComplete) {
              jumpAnimation.onComplete()
              jumpAnimation.onComplete = null
            }
          }
        }
      }
      
      renderer.render(scene, camera)
    }
    
    requestAnimationFrame(animate)
  }
  
  animate()

  // window에 마우스 이벤트 리스너 추가
  window.addEventListener('mousemove', handleGlobalMouseMove)
  window.addEventListener('mouseout', handleMouseLeave)
})

// handleGlobalMouseMove 수정
const handleGlobalMouseMove = (e) => {
  if (!horse || !walkAnimation.active) return // walking 중에는 마우스 추적 비활성화
  
  const centerX = window.innerWidth / 2
  const centerY = window.innerHeight / 2
  
  rotation.targetY = ((e.clientX - centerX) / (window.innerWidth / 2)) * (Math.PI / 2)
  rotation.targetX = ((e.clientY - centerY) / (window.innerHeight / 2)) * (Math.PI / 4)
}

// 컴포넌트 언마운트 시 이벤트 리스너 제거
onUnmounted(() => {
  window.removeEventListener('mousemove', handleGlobalMouseMove)
  window.removeEventListener('mouseout', handleMouseLeave)
})

// 기존의 handleMouseMove, handleMouseEnter는 제거하고
// handleMouseLeave만 유지
const handleMouseLeave = () => {
  // 화면 밖으로 나갔을 때 원래 위치로 복귀
  rotation.targetX = 0
  rotation.targetY = 0
}

// 클릭 핸들러 추가
const handleClick = () => {
  if (!jumpAnimation.active) {
    jumpAnimation.active = true
    jumpAnimation.time = 0
    jumpAnimation.startY = horse.position.y
    
    // 점프 완료 후 실행될 콜백 설정
    jumpAnimation.onComplete = () => {
      // 약간의 지연 후 라우팅 실행
      setTimeout(() => {
        router.push('/main/mypage/aichat')
      }, 100)
    }
  }
}
</script>

<style scoped>
.container {
  width: 600px;
  height: 600px;
  perspective: 1000px;
  background: transparent;
  margin: 0 auto;
}

/* MypageView에서 사용될 때의 스타일 */
:deep(.chat-layout) .container {
  width: 100%;
  height: 100;
  margin: 0;
}

canvas {
  width: 100% !important;
  height: 100% !important;
  background: transparent;
}
</style>


