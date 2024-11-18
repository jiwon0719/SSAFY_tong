<template>
  <div class="matching-container">
    <div class="expert-section">
      <div class="search-bar">
        <button class="btn btn-primary">
          <i class="ri-hospital-line"></i>
          <span>병원</span>
        </button>
        <button class="btn btn-primary">
          <i class="material-symbols-exercise-outline"></i>
          <span>PT</span>
        </button>
        <button class="btn btn-outline">
          <span>내 위치로 검색하기</span>
        </button>
        <button class="btn btn-outline" @click="navigateToExpertForm()">
          <span>전문가 등록하기</span>
        </button>
      </div>

      <div class="expert-list-container">
        <h2 class="section-title">전문가 목록</h2>
        <div class="expert-list" v-if="!loading">
          <router-link 
            v-for="expert in experts" 
            :key="expert.expertId"
            :to="`/matching/detail/${expert.expertId}`" 
            class="expert-card"
          >
            <img 
              :src="expert.userProfileImgPath || 'src/assets/images/기본프로필.jpg'" 
              :alt="`${expert.name} 프로필`" 
              class="expert-image"
            />
            <div class="expert-info">
              <div class="expert-header">
                <span class="expert-name">{{ expert.name }} 선생님</span>
                <span class="expert-type">{{ expert.grade }}</span>
              </div>
              <div class="expert-location">{{ expert.location }}</div>
              <div class="expert-rating">
                <i class="star-icon"></i>
                <span>{{ calculateRating(expert) }}</span>
              </div>
            </div>
          </router-link>
        </div>
        <div v-else class="loading-message">
          전문가 목록을 불러오는 중...
        </div>
      </div>
    </div>

    <div class="map-section">
      <div id="kakao-map" ref="mapContainer"></div>
    </div>
  </div>
</template>


<!-- 기존 스크립트 -->
<!-- <script>
import { ref, onMounted, onBeforeUnmount } from 'vue'

export default {
  name: 'MatchingDefault',
  emits: ['changeComponent'],  // changeComponent 이벤트 선언
  methods: {
    goToExpertRegist() {
      this.$emit('change-component', 'MatchingExpertRegist');
    },
    goToExpertDetail() {
      this.$emit('change-component', 'MatchingExpertDetail');
    }
  },

  setup() {
    const mapContainer = ref(null);
    const mapInstance = ref(null); // 카카오 맵 인스턴스를 저장할 ref

    const { VITE_KAKAO_MAP_KEY } = import.meta.env;

    // 카카오 맵 로딩
    const loadKakaoMap = (container) => {
      const script = document.createElement('script');
      script.src = `https://dapi.kakao.com/v2/maps/sdk.js?appkey=${VITE_KAKAO_MAP_KEY}&autoload=false`;
      document.head.appendChild(script);

      script.onload = () => {
        window.kakao.maps.load(() => {
          const options = {
            center: new window.kakao.maps.LatLng(36.355339, 127.297577), // 지도 중심 좌표
            level: 3, // 지도 확대 레벨
            maxLevel: 5, // 지도 축소 제한 레벨
          };

          // 지도 인스턴스를 생성
          mapInstance.value = new window.kakao.maps.Map(container, options);
        });
      };
    };

    // onMounted: 맵을 로드
    onMounted(() => {
      if (mapContainer.value) {
        loadKakaoMap(mapContainer.value);
      }
    });

    // onBeforeUnmount: 맵 인스턴스를 정리 (optional)
    onBeforeUnmount(() => {
      if (mapInstance.value) {
        window.kakao.maps.event.removeListener(mapInstance.value, 'click');
        // 다른 카카오 맵 이벤트나 리소스도 정리할 수 있음
      }
    });

    return {
      mapContainer,
    };
  },
};
</script> -->


<script>
import { ref, onMounted, onBeforeUnmount } from 'vue'
import { useExpertStore } from '@/stores/expert'
import { storeToRefs } from 'pinia'

export default {
    name: 'MatchingDefault',
    
    setup() {
        const mapContainer = ref(null)
        const mapInstance = ref(null)
        const expertStore = useExpertStore()
        const { experts, loading } = storeToRefs(expertStore)
        
        // 별점 계산 함수
        const calculateRating = (expert) => {
            if (!expert?.totalScoreCnt || expert.totalScoreCnt === 0) return '신규'
            return (expert.totalScore / expert.totalScoreCnt).toFixed(1)
        }

        // 카카오맵 초기화
        const initializeMap = () => {
            if (!mapContainer.value) {
                console.error('mapContainer가 없습니다.');
                return
            }
            console.log('카카오맵 초기화 중...');
            
            const options = {
                center: new window.kakao.maps.LatLng(36.355339, 127.297577),
                level: 3
            }
            
            // 지도 인스턴스 생성
            mapInstance.value = new window.kakao.maps.Map(mapContainer.value, options)
            console.log('지도 인스턴스 생성 완료');
            
            // 전문가 마커 추가
            if (experts.value?.length) {
                console.log('전문가 마커 추가 시작...');
                experts.value.forEach(expert => {
                    if (expert.latitude && expert.longitude) {
                        const markerPosition = new window.kakao.maps.LatLng(
                            expert.latitude, 
                            expert.longitude
                        )
                        
                        const marker = new window.kakao.maps.Marker({
                            position: markerPosition,
                            map: mapInstance.value
                        })
                        console.log(`마커 추가: ${expert.name} - ${expert.latitude}, ${expert.longitude}`);
                        
                        // 인포윈도우 생성
                        const infowindow = new window.kakao.maps.InfoWindow({
                            content: `
                                <div style="padding:5px;">
                                    <strong>${expert.name} 선생님</strong><br/>
                                    ${expert.grade}<br/>
                                    ${expert.location}
                                </div>
                            `
                        })
                        
                        // 마커 클릭 이벤트
                        window.kakao.maps.event.addListener(marker, 'click', () => {
                            infowindow.open(mapInstance.value, marker)
                        })
                    }
                })
            } else {
                console.warn('전문가 정보가 없습니다.');
            }
        }

        // 카카오맵 스크립트 로드
        const loadKakaoMap = () => {
            const script = document.createElement('script')
            const { VITE_KAKAO_MAP_KEY } = import.meta.env;
            
            if (!VITE_KAKAO_MAP_KEY) {
                console.error('카카오맵 API 키가 설정되지 않았습니다.');
                return;
            }
            
            console.log('카카오맵 스크립트 로드 중...');
            console.log(`카카오맵 URL: https://dapi.kakao.com/v2/maps/sdk.js?appkey=${VITE_KAKAO_MAP_KEY}&autoload=false`);

            script.src = `https://dapi.kakao.com/v2/maps/sdk.js?appkey=${VITE_KAKAO_MAP_KEY}&autoload=false`;
            script.async = true
            document.head.appendChild(script);
            
            script.onload = () => {
                console.log('카카오맵 스크립트 로딩 완료');
                window.kakao.maps.load(() => {
                    initializeMap()
                })
            }
            
            script.onerror = () => {
                console.error('카카오맵 스크립트 로딩 실패');
            }
        }

        onMounted(async () => {
            console.log('전문가 데이터 로딩 시작...');
            await expertStore.fetchExperts()
            console.log('전문가 데이터 로딩 완료');
            loadKakaoMap()
        })

        onBeforeUnmount(() => {
            if (mapInstance.value) {
                mapInstance.value = null
                console.log('맵 인스턴스 정리됨');
            }
        })

        return {
            mapContainer,
            experts,
            loading,
            calculateRating
        }
    },
    
    methods: {
        navigateToExpertForm() {
            console.log('전문가 등록 폼으로 이동');
            this.$router.push('/matching/regist')
        }
    }
}
</script>



<style lang="scss">
.matching-container {
  display: flex;
  height: 100%;
  width: 100%;

  .expert-section {
    width: 30%;
    height: 100%;
    border-right: 1px solid #eee;
    background: #fff;
    
    .search-bar {
      padding: 20px;
      display: flex;
      flex-wrap: wrap;
      gap: 10px;
      border-bottom: 1px solid #eee;
    }

    .expert-list-container {
      padding: 20px;

      .section-title {
        margin-bottom: 20px;
        font-size: 18px;
        font-weight: 600;
      }

      .expert-list {
        display: flex;
        flex-direction: column;
        gap: 16px;
      }
    }
  }

  .map-section {
    flex: 1;
    height: 100%;
    position: relative;
    

    #kakao-map {
      width: 100%;
      height: 80%;
      position: absolute;
      top: 0;
      left: 0;
    }
  }
}

.btn {
  display: flex;
  align-items: center;
  gap: 8px;
  padding: 8px 16px;
  border-radius: 12px;
  font-size: 16px;
  cursor: pointer;
  border: none;

  &-primary {
    background: #E2495B;
    color: white;
  }

  &-outline {
    border: 2px solid #E2495B;
    background: transparent;
    color: #000;
  }
}

.expert-card {
  display: flex;
  padding: 14px;
  background: rgba(217, 217, 217, 0.32);
  border-radius: 5px;
  text-decoration: none;
  color: inherit;
  transition: all 0.3s ease;
  border: 1px solid transparent;
  cursor: pointer;

  &:hover {
    background: rgba(217, 217, 217, 0.5);
    border-color: #E2495B;
    transform: translateY(-2px);
    box-shadow: 0 4px 12px rgba(226, 73, 91, 0.1);

    .expert-image {
      transform: scale(1.02);
    }

    .expert-name {
      color: #E2495B;
    }

    .expert-rating {
      color: #E2495B;
    }
  }

  .expert-image {
    width: 106px;
    height: 98px;
    border-radius: 5px;
    object-fit: cover;
    transition: transform 0.3s ease;
  }

  .expert-info {
    margin-left: 12px;
    flex: 1;
  }

  .expert-header {
    display: flex;
    align-items: center;
    gap: 8px;

    .expert-name {
      font-size: 16px;
      font-weight: 400;
      color: #000;
      transition: color 0.3s ease;
    }

    .expert-type {
      font-size: 14px;
      color: #B0B0B0;
    }
  }

  .expert-location {
    margin-top: 8px;
    font-size: 12px;
    color: #8A8A8A;
  }

  .expert-rating {
    display: flex;
    align-items: center;
    gap: 4px;
    margin-top: 8px;
    font-size: 12px;
    transition: color 0.3s ease;
  }
}

.expert-card.active {
  background: rgba(226, 73, 91, 0.1);
  border-color: #E2495B;
}
</style>