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
        <button v-if="userType === 'E'" class="btn btn-outline" @click="navigateToExpertForm()">
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
                <!-- 평균 평점 표시 -->
                <span>{{ expert.totalScoreCnt > 0 ? `${(expert.totalScore / expert.totalScoreCnt).toFixed(1)} (${expert.totalScoreCnt}개)` : '신규' }}</span>
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

<script>
import { ref, onMounted, onBeforeUnmount } from 'vue'
import { useExpertStore } from '@/stores/expert'
import { useUserStore } from '@/stores/user';
import { storeToRefs } from 'pinia'
import defaultProfileImg from '@/assets/images/기본프로필.jpg';

export default {
    name: 'MatchingDefault',
    
    setup() {
        const mapContainer = ref(null)
        const mapInstance = ref(null)
        const expertStore = useExpertStore()
        const userStore = useUserStore()
        const { experts, loading } = storeToRefs(expertStore)
        const { userType } = storeToRefs(userStore)

        // 별점 계산 함수
        const calculateRating = (expert) => {
            if (!expert?.totalScoreCnt || expert.totalScoreCnt === 0) return '신규'
            return (expert.totalScore / expert.totalScoreCnt).toFixed(1)
        }

        // 카카오맵 초기화
        const initializeMap = () => {
            if (!mapContainer.value) {
                // console.error('mapContainer가 없습니다.');
                return
            }
            // console.log('카카오맵 초기화 중...');
            
            const options = {
                center: new window.kakao.maps.LatLng(36.355339, 127.297577),
                level: 3
            }
            
            // 지도 인스턴스 생성
            mapInstance.value = new window.kakao.maps.Map(mapContainer.value, options)
            // console.log('지도 인스턴스 생성 완료');
        }


        // 전문가 마커 생성
        const addExpertMarkers = (experts) => {
            if (!experts || experts.length === 0) return
            const geocoder = new kakao.maps.services.Geocoder()
            
            experts.forEach((expert) => {
                if (!expert.address) return // 주소가 없는 경우 건너뜀
                
                console.log(expert.address)
                geocoder.addressSearch(expert.address, (result, status) => {
                    if (status === kakao.maps.services.Status.OK) {
                        const coords = new kakao.maps.LatLng(result[0].y, result[0].x)

                // 전문가 프로필 이미지를 포함한 HTML 마커 콘텐츠 생성
                const content = document.createElement('div');
                const img = document.createElement('img');
                
                // 이미지 스타일 설정
                img.src = expert.userProfileImgPath || defaultProfileImg;
                img.style.width = '40px';
                img.style.height = '40px';
                img.style.borderRadius = '50%';
                img.style.border = '2px solid #E2495B';
                img.style.objectFit = 'cover';
                
                // div 스타일 설정
                content.appendChild(img);
                content.style.padding = '3px';
                content.style.backgroundColor = 'white';
                content.style.borderRadius = '50%';
                content.style.boxShadow = '0 2px 6px rgba(0,0,0,0.3)';
                
                // CustomOverlay를 사용하여 마커 생성
                const customOverlay = new kakao.maps.CustomOverlay({
                    position: coords,
                    content: content,
                    map: mapInstance.value,
                    zIndex: 1
                });

                // 이름을 보여주는 인포윈도우 생성
                const infowindow = new kakao.maps.InfoWindow({
                    content: `<div style="padding:5px;font-size:12px;text-align:center;">${expert.name || '전문가'}</div>`,
                    zIndex: 2
                });

                // 마커에 마우스오버 이벤트 추가
                kakao.maps.event.addListener(customOverlay, 'mouseover', function() {
                    infowindow.open(mapInstance.value, customOverlay);
                });

                // 마커에 마우스아웃 이벤트 추가
                kakao.maps.event.addListener(customOverlay, 'mouseout', function() {
                    infowindow.close();
                });
            } else {
                console.error(`주소 변환 실패: ${expert.address}`)
            }
                })
            })
        }




        // 카카오맵 스크립트 로드
        const loadKakaoMap = () => {
          return new Promise((resolve, reject) => {
            const script = document.createElement('script');
            const { VITE_KAKAO_MAP_KEY } = import.meta.env;
            
            if (!VITE_KAKAO_MAP_KEY) {
                console.error('카카오맵 API 키가 설정되지 않았습니다.');
                reject(new Error('API 키 누락'));
                return;
            }
            // console.log('카카오맵 스크립트 로드 중...');
            // console.log(`카카오맵 URL: https://dapi.kakao.com/v2/maps/sdk.js?appkey=${VITE_KAKAO_MAP_KEY}&autoload=false`);

            script.src = `https://dapi.kakao.com/v2/maps/sdk.js?appkey=${VITE_KAKAO_MAP_KEY}&libraries=services&autoload=false`; // 지도 생성 및 마커 라이브러리 추가
            document.head.appendChild(script);
            
            script.onload = () => {
                // console.log('카카오맵 스크립트 로딩 완료');
                window.kakao.maps.load(() => {
                    initializeMap()
                    resolve(); // 지도 초기화 완료 시 resolve 호출
                    // console.log("onload 완료")
                })
            }
            
            script.onerror = () => {
                console.error('카카오맵 스크립트 로딩 실패');
                reject(new Error('스크립트 로딩 실패'));
            };
          });
        };

        onMounted(async () => {
            console.log('전문가 데이터 로딩 시작...');
            await expertStore.fetchExperts()
            console.log('전문가 데이터 로딩 완료');
            loadKakaoMap()

            // 전문가 데이터 로드 후 마커 추가
            if (experts.value && experts.value.length > 0) {
                addExpertMarkers(experts.value);
            }
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
            calculateRating, 
            userType, 
            addExpertMarkers
        }
    },
    
    methods: {
        navigateToExpertForm() {
            // console.log('전문가 등록 폼으로 이동');
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