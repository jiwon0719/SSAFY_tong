<template>
    <div class="matchingframe">
        <div class="expert">
            <div class="button">
                <div class="frame-">
                    <div class="text---">
                        내 위치로 검색하기
                    </div>
                    <svg id="0:1696" class="group-"></svg>
                    <div class="rectangle-">
                    </div>
                </div>
                <div class="frame--pt">
                    <div class="rectangle--1">
                    </div>
                    <div class="pt">
                        PT
                    </div>
                    <svg id="0:1704" class="material-symbolsexercise-outline"></svg>
                </div>
                <div class="frame--">
                    <div class="rectangle--2">
                    </div>
                    <div class="text-">
                        병원
                    </div>
                    <svg id="0:1709" class="rihospital-line"></svg>
                </div>
            </div>
            <div class="pt1">
                <div class="rectangle--">
                </div>
                
                <router-link to="/matchingExpertDetail" >
                <div class="pt1-1">
                    <div class="group--1">
                        <div class="text----1">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group--">
                        <div class="pt-1">
                            PT
                        </div>
                        <svg id="0:1722" class="line-3"></svg>
                        <div class="text-xx-">
                            김XX 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/bf67d464ef9ebd626449920c5fb74094.jpg" class="rectangle--3" />
                    <div class="group--2">
                        <svg id="0:1728" class="vector-4"></svg>
                        <div class="text-49">
                            4.9
                        </div>
                    </div>
                </div>
                </router-link>
            </div>
            <div class="pt1-2">
                <div class="rectangle---1">
                </div>
                <router-link to="/matchingExpertDetail" >
                <div class="pt1-3">
                    <div class="group--3">
                        <div class="text----2">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---1">
                        <div class="pt-2">
                            PT
                        </div>
                        <svg id="0:1800" class="line-4"></svg>
                        <div class="text-xx--1">
                            김XX 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/cf3d1e111f5fd1d928748430a4ca88cb.jpg" class="rectangle--4" />
                    <div class="group--4">
                        <svg id="0:1806" class="vector-5"></svg>
                        <div class="text-50">
                            4.9
                        </div>
                    </div>
                </div>
                </router-link>
            </div>
        </div>
        <div class="kakaomap">
            <div ref="mapContainer" style="width: 100%; height: 100%"></div>
        </div>
    </div>
</template>


<style lang="scss">
    .matchingframe {
        width: 100%;
        height: 100vh;
        display: flex;
        flex-direction: row;
    .expert {
        width: 30%;  /* 또는 원하는 너비 */
        height: 100%;
        overflow-y: auto;  /* 내용이 많을 경우 스크롤 */
        padding: 20px;
        .button {
            position: absolute;
            top: 13px;
            left: 185px;
            width: 495px;
            height: 54px;
            overflow: hidden;
            .frame- {
                position: absolute;
                top: 0px;
                left: 177px;
                width: 313px;
                height: 50px;
                overflow: hidden;
                .text--- {
                    position: absolute;
                    top: 16px;
                    left: 127px;
                    width: 162px;
                    height: 19px;
                    color: #000000;
                    font-family: "Inter";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .group- {
                    position: absolute;
                    top: 30%;
                    left: 87.22%;
                    right: 7.03%;
                    bottom: 28%;
                    width: calc(100% - 87.6% - 7.43%);
                    height: calc(100% - 32% - 31.3%);
                }
                .rectangle- {
                    position: absolute;
                    top: 2px;
                    left: 0px;
                    width: 313px;
                    height: 48px;
                    border-radius: 12px;
                    border: 2px solid #E2495B;
                }
            }
            .frame--pt {
                position: absolute;
                top: 1px;
                left: 88px;
                width: 78px;
                height: 48px;
                overflow: hidden;
                .rectangle--1 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 78px;
                    height: 48px;
                    border-radius: 12px;
                    background: #E2495B;
                }
                .pt {
                    position: absolute;
                    top: 9px;
                    left: 38px;
                    width: 40px;
                    height: 28px;
                    color: #FFFFFF;
                    font-family: "Jockey One";
                    font-size: 20px;
                    line-height: 28px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .material-symbolsexercise-outline {
                    position: absolute;
                    top: 12px;
                    left: 7px;
                    width: 24px;
                    height: 24px;
                }
            }
            .frame-- {
                position: absolute;
                top: 1px;
                left: 0px;
                width: 78px;
                height: 48px;
                overflow: hidden;
                .rectangle--2 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 78px;
                    height: 48px;
                    border-radius: 12px;
                    background: #E2495B;
                }
                .text- {
                    position: absolute;
                    top: 9px;
                    left: 32px;
                    width: 63px;
                    height: 28px;
                    color: #FFFFFF;
                    font-family: "Jockey One";
                    font-size: 20px;
                    line-height: 28px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .rihospital-line {
                    position: absolute;
                    top: 12px;
                    left: 6px;
                    width: 24px;
                    height: 24px;
                }
            }
        }
        .pt1 {
            position: absolute;
            top: 144px;
            left: 26px;
            width: 322px;
            height: 119px;
            overflow: hidden;
            .rectangle-- {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .pt1-1 {
                position: absolute;
                top: 14px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--1 {
                    position: absolute;
                    top: 22px;
                    left: 117px;
                    width: 93px;
                    height: 23px;
                    .text----1 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 93px;
                        height: 23px;
                        color: #8A8A8A;
                        font-family: "Jockey One";
                        font-size: 12px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group-- {
                    position: absolute;
                    top: 1px;
                    left: 115px;
                    width: 118px;
                    height: 18px;
                    .pt-1 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 20px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Jockey One";
                        font-size: 14px;
                        line-height: 20px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-3 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 15px;
                        height: 15px;
                    }
                    .text-xx- {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 111px;
                        height: 18px;
                        color: #000000;
                        font-family: "Jockey One";
                        font-size: 16px;
                        line-height: 22px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .rectangle--3 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 98px;
                    border-radius: 5px;
                    object-fit: cover;
                }
                .group--2 {
                    position: absolute;
                    top: 86.97px;
                    left: 268.04px;
                    width: 28.96px;
                    height: 14.03px;
                    .vector-4 {
                        position: absolute;
                        top: -6.92%;
                        left: -0.15%;
                        right: 51.8%;
                        bottom: 7.14%;
                        width: calc(100% - 0% - 51.93%);
                        height: calc(100% - 0% - 10.76%);
                    }
                    .text-49 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        white-space: nowrap;
                        color: #000000;
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
            }
        }
        .pt1-2 {
            position: absolute;
            top: 144px;
            left: 353px;
            width: 322px;
            height: 119px;
            overflow: hidden;
            .rectangle---1 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(248, 248, 248, 0.65);
            }
            .pt1-3 {
                position: absolute;
                top: 10px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--3 {
                    position: absolute;
                    top: 22px;
                    left: 117px;
                    width: 93px;
                    height: 23px;
                    .text----2 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 93px;
                        height: 23px;
                        color: #8A8A8A;
                        font-family: "Jockey One";
                        font-size: 12px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group---1 {
                    position: absolute;
                    top: 1px;
                    left: 115px;
                    width: 118px;
                    height: 18px;
                    .pt-2 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 20px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Jockey One";
                        font-size: 14px;
                        line-height: 20px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-4 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 15px;
                        height: 15px;
                    }
                    .text-xx--1 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 111px;
                        height: 18px;
                        color: #000000;
                        font-family: "Jockey One";
                        font-size: 16px;
                        line-height: 22px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .rectangle--4 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 98px;
                    border-radius: 5px;
                    object-fit: cover;
                }
                .group--4 {
                    position: absolute;
                    top: 86.97px;
                    left: 268.04px;
                    width: 28.96px;
                    height: 14.03px;
                    .vector-5 {
                        position: absolute;
                        top: -6.92%;
                        left: -0.15%;
                        right: 51.8%;
                        bottom: 7.14%;
                        width: calc(100% - 0% - 51.93%);
                        height: calc(100% - 0% - 10.76%);
                    }
                    .text-50 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        white-space: nowrap;
                        color: #000000;
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
            }
        }
    }
    .kakaomap {
        width: 70%;  /* 또는 원하는 너비 */
        height: 100%;
    }
}
</style>


<script>
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
</script>