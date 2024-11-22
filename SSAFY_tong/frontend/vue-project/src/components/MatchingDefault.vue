<template>
  <div class="matching-container">
    <div class="expert-section">
      <div class="search-bar">
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
            :data-expert-id="expert.expertId"
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
import { ref, onMounted, onBeforeUnmount, computed } from 'vue'
import { useRouter } from 'vue-router'
import { useExpertStore } from '@/stores/expert'
import { useUserStore } from '@/stores/user'
import { storeToRefs } from 'pinia'
import defaultProfileImg from '@/assets/images/기본프로필.jpg'

export default {
    name: 'MatchingDefault',
    
    setup() {
      // 전문가 등록 페이지 이동
        const router = useRouter();
        const navigateToExpertForm = () => {
            router.push({
                name: 'matchingExpertRegist'
            }).catch(err => {
                if (err.name !== 'NavigationDuplicated') {
                    throw err;
                }
            });
        };

        const mapContainer = ref(null)
        const mapInstance = ref(null)

        // expertId를 key로 사용하는 Map 객체들. 
        // Map을 사용하여 O(1) 시간 복잡도로 접근 가능
        const markers = ref(new Map())  // 마커 저장 Map
        const infowindows = ref(new Map()) // 전보창 Map
        const visibleMarkers = ref(new Set()) // 현재 지도 영역에 보이는 마커의 expertId를 저장
        
        const expertStore = useExpertStore()
        const userStore = useUserStore()
        const { experts, loading } = storeToRefs(expertStore)
        const { userType } = storeToRefs(userStore)
        
        let activeInfoWindow = null // 현재 활성화된 정보창 추적

        // 현재 지도에 보이는 전문가 목록만 필터링하는 computed 속성
        const visibleExperts = computed(() => {
            if (!experts.value) return [];
            // 1. 마커가 생성되어 있고(markers에 존재)
            // 2. 현재 지도 영역에 보이는(visibleMarkers에 존재) 전문가만 반환
            return experts.value.filter(expert => 
                markers.value.has(expert.expertId) && 
                visibleMarkers.value.has(expert.expertId)
            );
        });

        // 지도 영역 변경 이벤트 핸들러(변경될떄마다 수행)
        const handleBoundsChanged = () => {
            if (!mapInstance.value) return;
            
            const bounds = mapInstance.value.getBounds();
            visibleMarkers.value.clear();

            // markers Map을 순회하면서 보이는 마커 확인
            markers.value.forEach((marker, expertId) => {
                const position = marker.getPosition();
                if (bounds.contain(position)) {
                    visibleMarkers.value.add(expertId);
                }
            });
        };

        // 카카오맵 초기화
        const initializeMap = () => {
            if (!mapContainer.value) return;
            
            const options = {
                center: new window.kakao.maps.LatLng(36.355339, 127.297577),
                level: 3
            }
            
            mapInstance.value = new window.kakao.maps.Map(mapContainer.value, options)
            window.kakao.maps.event.addListener(mapInstance.value, 'bounds_changed', handleBoundsChanged);
        }

         // 단일 전문가의 마커를 생성하는 Promise 함수
        const createExpertMarker = (expert) => {
          // Promise를 반환하여 비동기 처리를 가능하게 함
            return new Promise((resolve) => {
                if (!expert.address) {
                    resolve();
                    return;
                }

                const geocoder = new window.kakao.maps.services.Geocoder();
                
                // 주소 -> 좌표 변환(비동기 처리)
                geocoder.addressSearch(expert.address, (result, status) => {
                    if (status === window.kakao.maps.services.Status.OK) {
                        const coords = new window.kakao.maps.LatLng(result[0].y, result[0].x);

                        // 마커 DOM 요소 생성
                        const markerContainer = document.createElement('div');
                        markerContainer.className = 'marker-container';
                        markerContainer.innerHTML = `
                            <div class="marker-image-container">
                                <img src="${expert.userProfileImgPath || defaultProfileImg}" 
                                    class="marker-image" 
                                    alt="${expert.name}">
                            </div>
                            <div class="marker-pointer"></div>
                        `;

                        // 인포윈도우 DOM 요소 생성
                        const infoContainer = document.createElement('div');
                        infoContainer.className = 'marker-info';
                        infoContainer.style.cssText = 'display: none;';
                        infoContainer.innerHTML = `
                            <div class="expert-name">${expert.name} 선생님</div>
                            <div class="expert-type">${expert.grade || '전문가'}</div>
                            <div class="rating">
                                ${expert.totalScoreCnt > 0 
                                    ? `★ ${(expert.totalScore / expert.totalScoreCnt).toFixed(1)} (${expert.totalScoreCnt}개)`
                                    : '신규'}
                            </div>
                        `;

                        // 마커와 인포윈도우 오버레이 생성
                        const markerOverlay = new window.kakao.maps.CustomOverlay({
                            position: coords,
                            content: markerContainer,
                            yAnchor: 1.0,
                            zIndex: 1
                        });

                        const infoOverlay = new window.kakao.maps.CustomOverlay({
                            position: coords,
                            content: infoContainer,
                            yAnchor: 2.3,
                            zIndex: 2
                        });

                        // 마커 이벤트 핸들러
                        const showInfo = () => {
                            if (activeInfoWindow) {
                                activeInfoWindow.getContent().style.display = 'none';
                            }
                            infoOverlay.setMap(mapInstance.value);
                            infoContainer.style.display = 'block';
                            activeInfoWindow = infoOverlay;

                            highlightExpertCard(expert.expertId);
                        };

                        const hideInfo = () => {
                            if (activeInfoWindow === infoOverlay) {
                                infoContainer.style.display = 'none';
                                activeInfoWindow = null;
                            }
                            removeExpertCardHighlight(expert.expertId);
                        };

                        // 이벤트 리스너 등록
                        markerContainer.addEventListener('mouseover', showInfo);
                        markerContainer.addEventListener('mouseout', hideInfo);
                        markerContainer.addEventListener('click', () => scrollToExpertCard(expert.expertId));

                        // 오버레이를 지도에 표시
                        markerOverlay.setMap(mapInstance.value);
                        infoOverlay.setMap(mapInstance.value);

                        // Map에 마커와 인포윈도우 저장
                        markers.value.set(expert.expertId, markerOverlay);
                        infowindows.value.set(expert.expertId, infoOverlay);
                    }
                    resolve();
                });
            });
        };

        // 모든 전문가의 마커를 생성하는 함수
        const addExpertMarkers = async (experts) => {
            if (!experts || experts.length === 0) return;

            // 기존 마커와 인포윈도우 제거
            markers.value.forEach(marker => marker.setMap(null));
            infowindows.value.forEach(info => info.setMap(null));
            markers.value.clear();
            infowindows.value.clear();

            // Promise.all을 사용하여 모든 마커 생성을 동시에 처리
            // 각 createExpertMarker가 반환하는 Promise를 배열로 모아서 한번에 처리
            await Promise.all(experts.map(expert => createExpertMarker(expert)));
            
            // 모든 마커가 생성된 후 보이는 마커 업데이트
            handleBoundsChanged();
        };

        // UI 헬퍼 함수들
        const highlightExpertCard = (expertId) => {
            const expertCard = document.querySelector(`[data-expert-id="${expertId}"]`);
            if (expertCard) {
                document.querySelectorAll('.expert-card').forEach(card => {
                    card.classList.remove('active');
                });
                expertCard.classList.add('active');
            }
        };

        const removeExpertCardHighlight = (expertId) => {
            const expertCard = document.querySelector(`[data-expert-id="${expertId}"]`);
            if (expertCard) {
                expertCard.classList.remove('active');
            }
        };

        const scrollToExpertCard = (expertId) => {
            const expertCard = document.querySelector(`[data-expert-id="${expertId}"]`);
            if (expertCard) {
                const container = document.querySelector('.expert-list-container');
                const scrollTop = expertCard.offsetTop - container.offsetHeight * 0.2;
                
                container.scrollTo({
                    top: scrollTop,
                    behavior: 'smooth'
                });

                highlightExpertCard(expertId);
                setTimeout(() => removeExpertCardHighlight(expertId), 1000);
            }
        };

        // 카카오맵 로드
        const loadKakaoMap = () => {
            return new Promise((resolve, reject) => {
                const script = document.createElement('script');
                const { VITE_KAKAO_MAP_KEY } = import.meta.env;
                
                if (!VITE_KAKAO_MAP_KEY) {
                    reject(new Error('API 키 누락'));
                    return;
                }

                script.src = `https://dapi.kakao.com/v2/maps/sdk.js?appkey=${VITE_KAKAO_MAP_KEY}&libraries=services&autoload=false`;
                document.head.appendChild(script);
                
                script.onload = () => {
                    window.kakao.maps.load(() => {
                        initializeMap();
                        resolve();
                    });
                };
                
                script.onerror = () => {
                    reject(new Error('스크립트 로딩 실패'));
                };
            });
        };

        onMounted(async () => {
          // 전문가 데이터 로드  
          await expertStore.fetchExperts();
          // 카카오맵 로드
          await loadKakaoMap();
          // 전문가 데이터가 있으면 마커 생성
          if (experts.value?.length > 0) {
            await addExpertMarkers(experts.value);
          }
        });

        onBeforeUnmount(() => {
            if (mapInstance.value) {
                window.kakao.maps.event.removeListener(mapInstance.value, 'bounds_changed', handleBoundsChanged);
                markers.value.forEach(marker => marker.setMap(null));
                infowindows.value.forEach(info => info.setMap(null));
                mapInstance.value = null;
            }
        });

        return {
            mapContainer,
            experts: visibleExperts, // 보이는 전문가만 반환
            loading,
            userType, 
            navigateToExpertForm
        };
    }
}
</script>



<style lang="scss">
// 폰트 관련 CSS
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');
.v-date-picker,
.v-list-item,
.v-date-picker-header,
.v-date-picker-table {
  font-family: 'Noto Sans KR', sans-serif;
}

.v-date-picker {
  width: 100%;
}

:deep(.custom-calendar) {
  .v-date-picker-header {
    padding: 4px 8px;
  }
  
  .v-date-picker-header__value {
    color: #E2495B;
  }

  .v-btn--active {
    background-color: #E2495B !important;
    color: white !important;
  }

  .v-btn:not(.v-btn--active) {
    color: #666;
  }

  .v-date-picker-table {
    height: auto;
  }
}

.v-list-item {
  border: 1px solid #eee;
  border-radius: 8px;
  margin-bottom: 8px;
}


// 매칭 관련
.matching-container {
  display: flex;
  // height: calc(100vh - 64px); // Adjust based on your header height
  height: 100vh;
  width: 100%;
  overflow: hidden;

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
      height: 100%; // 높이 설정
      overflow-y: auto; // 스크롤 가능하도록 설정

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
  padding: 20px; // Add padding around the map
  background: #f9f9f9; // Optional: light background
    

    #kakao-map {
      width: 100%;
    height: 80%;
    position: relative; // Change from absolute to relative
    border-radius: 12px; // Add rounded corners
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1); // Add subtle shadow
    margin: 20px 0; // Add margin to top and bottom
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
  border: 1px solid transparent;
  cursor: pointer;
  // 전환 시간을 0.4초로 늘림
  transition: all 0.4s ease-in-out;

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
    transition: transform 0.4s ease;
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
      transition: color 0.4s ease;
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
    transition: color 0.4s ease;
  }
}

.expert-card.active {
  background: rgba(226, 73, 91, 0.1);
  border-color: #E2495B;
    // active 상태 전환도 동일하게 0.4초
  transition: all 0.4s ease-in-out;
}

// 마커 관련 스타일
.marker-info {
    background: white;
    padding: 12px;
    border-radius: 8px;
    border: 1px solid #E2495B;
    box-shadow: 0 2px 6px rgba(226, 73, 91, 0.2);
    min-width: 150px;
    text-align: center;
    pointer-events: none;
    display: none; // 초기 상태 숨김
    // position: absolute; // 위치 고정
    // transform: translate(-50%, -100%); // 중앙 정렬
    z-index: 2;
}

.marker-container {
    position: relative;
    width: 46px;
    height: 56px;
    cursor: pointer;
    z-index: 1;
}

.marker-image-container {
    width: 46px;
    height: 46px;
    background-color: #E2495B;
    border-radius: 50%;
    box-shadow: 0 2px 6px rgba(226, 73, 91, 0.3);
    position: absolute;
    top: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 2px;
}

.marker-image {
    width: 42px;
    height: 42px;
    border-radius: 50%;
    border: 2px solid white;
    object-fit: cover;
}

.marker-pointer {
    position: absolute;
    bottom: 0;
    left: 50%;
    transform: translateX(-50%);
    width: 0;
    height: 0;
    border-left: 8px solid transparent;
    border-right: 8px solid transparent;
    border-top: 10px solid #E2495B;
    filter: drop-shadow(0 2px 2px rgba(226, 73, 91, 0.3));
}

.marker-info .expert-name {
    font-size: 14px;
    font-weight: 500;
    color: #000;
    margin-bottom: 4px;
}

.marker-info .expert-type {
    font-size: 12px;
    color: #8A8A8A;
    margin-bottom: 4px;
}

.marker-info .rating {
    font-size: 12px;
    color: #E2495B;
}

.expert-card.active {
    background: rgba(226, 73, 91, 0.1);
    border: 1px solid #E2495B;
    transition: all 0.3s ease;
}

// 맵 컨테이너 스타일
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
</style>