<script setup>
import { ref, onMounted } from 'vue'

const mapContainer = ref(null)

onMounted(() => {
  loadKakaoMap(mapContainer.value)
})

const loadKakaoMap = (container) => {
  const kakaoApiKey = import.meta.env.VITE_KAKAO_MAP_KEY;
  console.log("Kakao API Key:", kakaoApiKey);  // 콘솔에서 확인

  console.log(import.meta.env);  // 전체 환경 변수 객체 출력


  const script = document.createElement('script')
  script.src = `https://dapi.kakao.com/v2/maps/sdk.js?appkey=${kakaoApiKey}&autoload=false`
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
    <div class="frame-">
        <svg id="0:1685" class="rectangle-42"></svg>
        <div class="sidebar">
            <div class="group-bar">
                <div class="sidebar-1">
                </div>
                <div class="icround-grade">
                </div>
            </div>
            <div class="group-">
                <svg id="0:1694" class="pen-"></svg>
                <div class="text---">
                    내 위치로 검색하기
                </div>
                <svg id="0:1696" class="group--1"></svg>
            </div>
            <div class="group--pt">
                <div class="rectangle-">
                </div>
                <div class="pt">
                    PT
                </div>
                <svg id="0:1704" class="material-symbolsexercise-outline"></svg>
            </div>
            <div class="group--">
                <div class="rectangle--1">
                </div>
                <div class="text-">
                    병원
                </div>
                <svg id="0:1709" class="rihospital-line"></svg>
            </div>
            <div class="pt1">
                <div class="rectangle--">
                </div>
                <div class="pt1-1">
                    <div class="group--2">
                        <div class="text----1">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---1">
                        <div class="pt-1">
                            PT
                        </div>
                        <svg id="0:1722" class="line-3"></svg>
                        <div class="text--">
                            김혜준 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/bf67d464ef9ebd626449920c5fb74094.jpg" class="rectangle--2" />
                    <div class="group--3">
                        <svg id="0:1728" class="vector-4"></svg>
                        <div class="text-49">
                            4.9
                        </div>
                    </div>
                </div>
            </div>
            <div class="pt1-2">
                <div class="rectangle---1">
                </div>
                <div class="pt1-3">
                    <div class="group--4">
                        <div class="text----2">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---2">
                        <div class="pt-2">
                            PT
                        </div>
                        <svg id="0:1737" class="line-4"></svg>
                        <div class="text---1">
                            김혜준 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/6862543d9b7771eee819a56ccb2b5bd9.jpg" class="rectangle--3" />
                    <div class="group--5">
                        <svg id="0:1743" class="vector-5"></svg>
                        <div class="text-50">
                            4.9
                        </div>
                    </div>
                </div>
            </div>
            <div class="pt1-4">
                <div class="rectangle---2">
                </div>
                <div class="pt1-5">
                    <div class="group--6">
                        <div class="text----3">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---3">
                        <div class="text--1">
                            소아과
                        </div>
                        <svg id="0:1752" class="line-5"></svg>
                        <div class="text---2">
                            구만석 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/1c8c02b965e9913d0a51fd68106fb78c.jpg" class="rectangle--4" />
                    <div class="group--7">
                        <svg id="0:1758" class="vector-6"></svg>
                        <div class="text-51">
                            4.9
                        </div>
                    </div>
                </div>
            </div>
            <div class="pt1-6">
                <div class="rectangle---3">
                </div>
                <div class="rectangle---4">
                </div>
                <div class="pt1-7">
                    <div class="group--8">
                        <div class="text----4">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---4">
                        <div class="text--2">
                            정형외과
                        </div>
                        <svg id="0:1768" class="line-6"></svg>
                        <div class="text---3">
                            유승홍 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/dd8e514e3827f4c92de288233469584a.jpg" class="rectangle--5" />
                    <div class="group--9">
                        <svg id="0:1774" class="vector-7"></svg>
                        <div class="text-52">
                            4.9
                        </div>
                    </div>
                </div>
            </div>
            <div class="pt1-8">
                <div class="rectangle---5">
                </div>
                <div class="pt1-9">
                    <div class="group--10">
                        <div class="text----5">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---5">
                        <div class="pt-3">
                            PT
                        </div>
                        <svg id="0:1783" class="line-7"></svg>
                        <div class="text---4">
                            김혜준 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/c10c0d645d1d158a8937a29b32c57c52.jpg" class="rectangle--6" />
                    <div class="group--11">
                        <svg id="0:1789" class="vector-8"></svg>
                        <div class="text-53">
                            4.9
                        </div>
                    </div>
                </div>
            </div>
            <div class="pt1-10">
                <div class="rectangle---6">
                </div>
                <div class="pt1-11">
                    <div class="group--12">
                        <div class="text----6">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---6">
                        <div class="pt-4">
                            PT
                        </div>
                        <svg id="0:1800" class="line-8"></svg>
                        <div class="text---5">
                            김혜준 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/cf3d1e111f5fd1d928748430a4ca88cb.jpg" class="rectangle--7" />
                    <div class="group--13">
                        <svg id="0:1806" class="vector-9"></svg>
                        <div class="text-54">
                            4.9
                        </div>
                    </div>
                </div>
            </div>
            <div class="pt1-12">
                <div class="rectangle---7">
                </div>
                <div class="pt1-13">
                    <div class="group--14">
                        <div class="text----7">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---7">
                        <div class="pt-5">
                            PT
                        </div>
                        <svg id="0:1815" class="line-9"></svg>
                        <div class="text---6">
                            김혜준 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/5b7e4a50c70ba9d363f1f7ae5c97d6a7.jpg" class="rectangle--8" />
                    <div class="group--15">
                        <svg id="0:1821" class="vector-10"></svg>
                        <div class="text-55">
                            4.9
                        </div>
                    </div>
                </div>
            </div>
            <div class="pt1-14">
                <div class="rectangle---8">
                </div>
                <div class="pt1-15">
                    <div class="group--16">
                        <div class="text----8">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---8">
                        <div class="text--3">
                            한의사
                        </div>
                        <svg id="0:1830" class="line-10"></svg>
                        <div class="text---7">
                            유승호 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d56daf0628fcabb2304963bb911f09d1.jpg" class="rectangle--9" />
                    <div class="group--17">
                        <svg id="0:1836" class="vector-11"></svg>
                        <div class="text-56">
                            4.9
                        </div>
                    </div>
                </div>
            </div>
            <div class="pt1-16">
                <div class="rectangle---9">
                </div>
                <div class="pt1-17">
                    <div class="group--18">
                        <div class="text----9">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---9">
                        <div class="text--4">
                            정형외과
                        </div>
                        <svg id="0:1845" class="line-11"></svg>
                        <div class="text---8">
                            배항진 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/288eb15d4353edce578874dd7f55a525.jpg" class="rectangle--10" />
                    <div class="group--19">
                        <svg id="0:1851" class="vector-12"></svg>
                        <div class="text-57">
                            4.9
                        </div>
                    </div>
                </div>
            </div>
            <div class="pt1-18">
                <div class="rectangle---10">
                </div>
                <div class="pt1-19">
                    <div class="group--20">
                        <div class="text----10">
                            대전 유성구 싸피동
                        </div>
                    </div>
                    <div class="group---10">
                        <div class="pt-6">
                            PT
                        </div>
                        <svg id="0:1860" class="line-12"></svg>
                        <div class="text---9">
                            김혜준 선생님
                        </div>
                    </div>
                    <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/e532d1fffc6a3ddf437ce844c77c0082.jpg" class="rectangle--11" />
                    <div class="group--21">
                        <svg id="0:1866" class="vector-13"></svg>
                        <div class="text-58">
                            4.9
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="group--22">
            <div class="frame-9">
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/b5adf0d50405e44725dca99054dcbdb2.jpg" class="close-up-portrait-of-female-model-under-blue-light" />
            </div>
            <div class="frame-8">
                <div class="rectangle-38">
                </div>
                <div class="group-20">
                    <div class="group-16">
                        <div class="community">
                            <div class="rectangle-37">
                            </div>
                            <div class="rectangle-39">
                            </div>
                            <div class="rectangle-40">
                            </div>
                            <div class="community-1">
                                Community
                            </div>
                            <svg id="0:1880" class="fluentpeople-community-32-light"></svg>
                        </div>
                        <div class="chat">
                            <div class="rectangle-41">
                            </div>
                            <div class="rectangle-43">
                            </div>
                            <div class="rectangle-44">
                            </div>
                            <div class="chat-1">
                                Chat
                            </div>
                        </div>
                    </div>
                    <div class="group-17">
                        <div class="calender">
                            <div class="rectangle-45">
                            </div>
                            <div class="rectangle-46">
                            </div>
                            <div class="rectangle-47">
                            </div>
                            <div class="calendar">
                                Calendar
                            </div>
                        </div>
                        <div class="match">
                            <div class="rectangle-48">
                            </div>
                            <div class="rectangle-49">
                            </div>
                            <div class="rectangle-50">
                            </div>
                            <div class="matching">
                                Matching
                            </div>
                        </div>
                    </div>
                </div>
                <svg id="0:1898" class="arcticonslitmatch"></svg><svg id="0:1904" class="uitcalender"></svg><svg id="0:1906" class="fluentchat-32-light"></svg>
                <div class="line-13">
                </div>
            </div>
            <div class="tong">
                TONG
            </div>
        </div>
        <div class="group--23">
            <svg id="0:1911" class="rectangle-51"></svg>
            <div class="group-23">
                <div class="text---10">
                    전문가 등록
                </div>
                <svg id="0:1920" class="icon-park-outlineclick"></svg>
            </div>
        </div>
        <div class="kakaomap">
            <div ref="mapContainer" style="width: 100%; height: 100%;">  </div>
        </div>
    </div>
</template>


<style lang="scss">
    .frame- {
    width: 1440px;
    height: 1024px;
    overflow: hidden;
    background: rgba(255, 255, 255, 0);
    .rectangle-42 {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 1440px;
        height: 1024px;
    }
    .sidebar {
        position: absolute;
        top: 213px;
        left: 26px;
        width: 701px;
        height: 787px;
        .group-bar {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 701px;
            height: 787px;
            .sidebar-1 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 701px;
                height: 787px;
                border-radius: 15px;
                background: rgba(255, 255, 255, 0);
            }
            .icround-grade {
                position: absolute;
                top: 193px;
                left: 271.94px;
                width: 18.13px;
                height: 17px;
                overflow: hidden;
            }
        }
        .group- {
            position: absolute;
            top: 13px;
            left: 362px;
            width: 313px;
            height: 50px;
            .pen- {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 313px;
                height: 50px;
            }
            .text--- {
                position: absolute;
                top: 16px;
                left: 127px;
                width: 130px;
                height: 19px;
                color: #000000;
                font-family: "Inter";
                font-size: 16px;
                line-height: 19px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
            .group--1 {
                position: absolute;
                top: 30%;
                left: 84.35%;
                right: 9.9%;
                bottom: 28%;
            }
        }
        .group--pt {
            position: absolute;
            top: 14px;
            left: 273px;
            width: 78px;
            height: 48px;
            .rectangle- {
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
                width: 19px;
                height: 28px;
                color: #FFFFFF;
                white-space: nowrap;
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
        .group-- {
            position: absolute;
            top: 14px;
            left: 185px;
            width: 78px;
            height: 48px;
            .rectangle--1 {
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
                width: 39px;
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
        .pt1 {
            position: absolute;
            top: 144px;
            left: 26px;
            width: 322px;
            height: 119px;
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
                .group--2 {
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
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
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
                    .pt-1 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 20px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-3 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 2px;
                        height: 15px;
                    }
                    .text-- {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 111px;
                        height: 18px;
                        color: #000000;
                        font-family: "Inter";
                        font-size: 16px;
                        line-height: 19px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .rectangle--2 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 98px;
                    border-radius: 5px;
                    object-fit: cover;
                }
                .group--3 {
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
                    }
                    .text-49 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        color: #000000;
                        white-space: nowrap;
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
            top: 398px;
            left: 26px;
            width: 322px;
            height: 119px;
            .rectangle---1 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .pt1-3 {
                position: absolute;
                top: 10px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--4 {
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
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group---2 {
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
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-4 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 2px;
                        height: 15px;
                    }
                    .text---1 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 111px;
                        height: 18px;
                        color: #000000;
                        font-family: "Inter";
                        font-size: 16px;
                        line-height: 19px;
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
                .group--5 {
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
                    }
                    .text-50 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        color: #000000;
                        white-space: nowrap;
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
        .pt1-4 {
            position: absolute;
            top: 525px;
            left: 26px;
            width: 322px;
            height: 119px;
            .rectangle---2 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .pt1-5 {
                position: absolute;
                top: 10px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--6 {
                    position: absolute;
                    top: 22px;
                    left: 117px;
                    width: 93px;
                    height: 23px;
                    .text----3 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 93px;
                        height: 23px;
                        color: #8A8A8A;
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group---3 {
                    position: absolute;
                    top: 1px;
                    left: 115px;
                    width: 141px;
                    height: 18px;
                    .text--1 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 43px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-5 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 2px;
                        height: 15px;
                    }
                    .text---2 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 111px;
                        height: 18px;
                        color: #000000;
                        font-family: "Inter";
                        font-size: 16px;
                        line-height: 19px;
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
                .group--7 {
                    position: absolute;
                    top: 86.97px;
                    left: 268.04px;
                    width: 28.96px;
                    height: 14.03px;
                    .vector-6 {
                        position: absolute;
                        top: -6.92%;
                        left: -0.15%;
                        right: 51.8%;
                        bottom: 7.14%;
                    }
                    .text-51 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        color: #000000;
                        white-space: nowrap;
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
        .pt1-6 {
            position: absolute;
            top: 652px;
            left: 26px;
            width: 322px;
            height: 119px;
            .rectangle---3 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .rectangle---4 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .pt1-7 {
                position: absolute;
                top: 10px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--8 {
                    position: absolute;
                    top: 22px;
                    left: 117px;
                    width: 93px;
                    height: 23px;
                    .text----4 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 93px;
                        height: 23px;
                        color: #8A8A8A;
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group---4 {
                    position: absolute;
                    top: 1px;
                    left: 115px;
                    width: 153px;
                    height: 18px;
                    .text--2 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 55px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-6 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 2px;
                        height: 15px;
                    }
                    .text---3 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 94px;
                        height: 18px;
                        color: #000000;
                        font-family: "Inter";
                        font-size: 16px;
                        line-height: 19px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .rectangle--5 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 98px;
                    border-radius: 5px;
                    object-fit: cover;
                }
                .group--9 {
                    position: absolute;
                    top: 86.97px;
                    left: 268.04px;
                    width: 28.96px;
                    height: 14.03px;
                    .vector-7 {
                        position: absolute;
                        top: -6.92%;
                        left: -0.15%;
                        right: 51.8%;
                        bottom: 7.14%;
                    }
                    .text-52 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        color: #000000;
                        white-space: nowrap;
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
        .pt1-8 {
            position: absolute;
            top: 271px;
            left: 26px;
            width: 322px;
            height: 119px;
            .rectangle---5 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .pt1-9 {
                position: absolute;
                top: 10px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--10 {
                    position: absolute;
                    top: 22px;
                    left: 117px;
                    width: 93px;
                    height: 23px;
                    .text----5 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 93px;
                        height: 23px;
                        color: #8A8A8A;
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group---5 {
                    position: absolute;
                    top: 1px;
                    left: 115px;
                    width: 118px;
                    height: 18px;
                    .pt-3 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 20px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-7 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 2px;
                        height: 15px;
                    }
                    .text---4 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 111px;
                        height: 18px;
                        color: #000000;
                        font-family: "Inter";
                        font-size: 16px;
                        line-height: 19px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .rectangle--6 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 98px;
                    border-radius: 5px;
                    object-fit: cover;
                }
                .group--11 {
                    position: absolute;
                    top: 86.97px;
                    left: 268.04px;
                    width: 28.96px;
                    height: 14.03px;
                    .vector-8 {
                        position: absolute;
                        top: -6.92%;
                        left: -0.15%;
                        right: 51.8%;
                        bottom: 7.14%;
                    }
                    .text-53 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        color: #000000;
                        white-space: nowrap;
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
        .pt1-10 {
            position: absolute;
            top: 144px;
            left: 353px;
            width: 322px;
            height: 119px;
            .rectangle---6 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(248, 248, 248, 0.65);
            }
            .pt1-11 {
                position: absolute;
                top: 10px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--12 {
                    position: absolute;
                    top: 22px;
                    left: 117px;
                    width: 93px;
                    height: 23px;
                    .text----6 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 93px;
                        height: 23px;
                        color: #8A8A8A;
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group---6 {
                    position: absolute;
                    top: 1px;
                    left: 115px;
                    width: 118px;
                    height: 18px;
                    .pt-4 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 20px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-8 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 2px;
                        height: 15px;
                    }
                    .text---5 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 111px;
                        height: 18px;
                        color: #000000;
                        font-family: "Inter";
                        font-size: 16px;
                        line-height: 19px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .rectangle--7 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 98px;
                    border-radius: 5px;
                    object-fit: cover;
                }
                .group--13 {
                    position: absolute;
                    top: 86.97px;
                    left: 268.04px;
                    width: 28.96px;
                    height: 14.03px;
                    .vector-9 {
                        position: absolute;
                        top: -6.92%;
                        left: -0.15%;
                        right: 51.8%;
                        bottom: 7.14%;
                    }
                    .text-54 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        color: #000000;
                        white-space: nowrap;
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
        .pt1-12 {
            position: absolute;
            top: 398px;
            left: 353px;
            width: 322px;
            height: 119px;
            .rectangle---7 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .pt1-13 {
                position: absolute;
                top: 10px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--14 {
                    position: absolute;
                    top: 22px;
                    left: 117px;
                    width: 93px;
                    height: 23px;
                    .text----7 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 93px;
                        height: 23px;
                        color: #8A8A8A;
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group---7 {
                    position: absolute;
                    top: 1px;
                    left: 115px;
                    width: 118px;
                    height: 18px;
                    .pt-5 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 20px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-9 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 2px;
                        height: 15px;
                    }
                    .text---6 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 111px;
                        height: 18px;
                        color: #000000;
                        font-family: "Inter";
                        font-size: 16px;
                        line-height: 19px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .rectangle--8 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 98px;
                    border-radius: 5px;
                    object-fit: cover;
                }
                .group--15 {
                    position: absolute;
                    top: 86.97px;
                    left: 268.04px;
                    width: 28.96px;
                    height: 14.03px;
                    .vector-10 {
                        position: absolute;
                        top: -6.92%;
                        left: -0.15%;
                        right: 51.8%;
                        bottom: 7.14%;
                    }
                    .text-55 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        color: #000000;
                        white-space: nowrap;
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
        .pt1-14 {
            position: absolute;
            top: 525px;
            left: 353px;
            width: 322px;
            height: 119px;
            .rectangle---8 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .pt1-15 {
                position: absolute;
                top: 10px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--16 {
                    position: absolute;
                    top: 22px;
                    left: 117px;
                    width: 93px;
                    height: 23px;
                    .text----8 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 93px;
                        height: 23px;
                        color: #8A8A8A;
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group---8 {
                    position: absolute;
                    top: 1px;
                    left: 115px;
                    width: 139px;
                    height: 18px;
                    .text--3 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 41px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-10 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 2px;
                        height: 15px;
                    }
                    .text---7 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 111px;
                        height: 18px;
                        color: #000000;
                        font-family: "Inter";
                        font-size: 16px;
                        line-height: 19px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .rectangle--9 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 98px;
                    border-radius: 5px;
                    object-fit: cover;
                }
                .group--17 {
                    position: absolute;
                    top: 86.97px;
                    left: 268.04px;
                    width: 28.96px;
                    height: 14.03px;
                    .vector-11 {
                        position: absolute;
                        top: -6.92%;
                        left: -0.15%;
                        right: 51.8%;
                        bottom: 7.14%;
                    }
                    .text-56 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        color: #000000;
                        white-space: nowrap;
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
        .pt1-16 {
            position: absolute;
            top: 652px;
            left: 353px;
            width: 322px;
            height: 119px;
            .rectangle---9 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .pt1-17 {
                position: absolute;
                top: 10px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--18 {
                    position: absolute;
                    top: 22px;
                    left: 117px;
                    width: 93px;
                    height: 23px;
                    .text----9 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 93px;
                        height: 23px;
                        color: #8A8A8A;
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group---9 {
                    position: absolute;
                    top: 1px;
                    left: 115px;
                    width: 153px;
                    height: 18px;
                    .text--4 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 55px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-11 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 2px;
                        height: 15px;
                    }
                    .text---8 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 89px;
                        height: 18px;
                        color: #000000;
                        font-family: "Inter";
                        font-size: 16px;
                        line-height: 19px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .rectangle--10 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 98px;
                    border-radius: 5px;
                    object-fit: cover;
                }
                .group--19 {
                    position: absolute;
                    top: 86.97px;
                    left: 268.04px;
                    width: 28.96px;
                    height: 14.03px;
                    .vector-12 {
                        position: absolute;
                        top: -6.92%;
                        left: -0.15%;
                        right: 51.8%;
                        bottom: 7.14%;
                    }
                    .text-57 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        color: #000000;
                        white-space: nowrap;
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
        .pt1-18 {
            position: absolute;
            top: 271px;
            left: 353px;
            width: 322px;
            height: 119px;
            .rectangle---10 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 322px;
                height: 119px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .pt1-19 {
                position: absolute;
                top: 10px;
                left: 9px;
                width: 297px;
                height: 101px;
                .group--20 {
                    position: absolute;
                    top: 22px;
                    left: 117px;
                    width: 93px;
                    height: 23px;
                    .text----10 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 93px;
                        height: 23px;
                        color: #8A8A8A;
                        font-family: "Bebas Neue";
                        font-size: 12px;
                        line-height: 14px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .group---10 {
                    position: absolute;
                    top: 1px;
                    left: 115px;
                    width: 118px;
                    height: 18px;
                    .pt-6 {
                        position: absolute;
                        top: 0px;
                        left: 98px;
                        width: 20px;
                        height: 18px;
                        color: #B0B0B0;
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .line-12 {
                        position: absolute;
                        top: 1px;
                        left: 93px;
                        width: 2px;
                        height: 15px;
                    }
                    .text---9 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 111px;
                        height: 18px;
                        color: #000000;
                        font-family: "Inter";
                        font-size: 16px;
                        line-height: 19px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
                .rectangle--11 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 98px;
                    border-radius: 5px;
                    object-fit: cover;
                }
                .group--21 {
                    position: absolute;
                    top: 86.97px;
                    left: 268.04px;
                    width: 28.96px;
                    height: 14.03px;
                    .vector-13 {
                        position: absolute;
                        top: -6.92%;
                        left: -0.15%;
                        right: 51.8%;
                        bottom: 7.14%;
                    }
                    .text-58 {
                        position: absolute;
                        top: 0.03px;
                        left: 17.96px;
                        width: 11px;
                        height: 14px;
                        color: #000000;
                        white-space: nowrap;
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
    .group--22 {
        position: absolute;
        top: 44px;
        left: 77px;
        width: 1284px;
        height: 117px;
        .frame-9 {
            position: absolute;
            top: 17px;
            left: 1184px;
            width: 100px;
            height: 100px;
            border-radius: 90px;
            overflow: hidden;
            border: 1px solid #000000;
            .close-up-portrait-of-female-model-under-blue-light {
                position: absolute;
                top: -17px;
                left: -15px;
                width: 139px;
                height: 152px;
                object-fit: contain;
            }
        }
        .frame-8 {
            position: absolute;
            top: 0px;
            left: 354px;
            width: 739px;
            height: 108px;
            overflow: hidden;
            .rectangle-38 {
                position: absolute;
                top: 39px;
                left: 27px;
                width: 97px;
                height: 25px;
                border-radius: 140px;
                background: rgba(255, 255, 255, 0.8);
            }
            .group-20 {
                position: absolute;
                top: 30px;
                left: 13px;
                width: 585px;
                height: 43px;
                .group-16 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 308px;
                    height: 43px;
                    .community {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 165px;
                        height: 43px;
                        .rectangle-37 {
                            position: absolute;
                            top: 0px;
                            left: 0px;
                            width: 165px;
                            height: 43px;
                            border-radius: 140px;
                            background: rgba(226, 73, 91, 0.8);
                        }
                        .rectangle-39 {
                            position: absolute;
                            top: calc(100% - 43px + 5px);
                            left: calc(100% - 165px + 5px);
                            width: 154px;
                            height: 33px;
                            border-radius: 140px;
                            background: rgba(255, 255, 255, 0.8);
                        }
                        .rectangle-40 {
                            position: absolute;
                            top: calc(100% - 43px + 5px);
                            left: calc(100% - 165px + 91px);
                            width: 68px;
                            height: 33px;
                            border-radius: 140px;
                            background: rgba(255, 255, 255, 0.8);
                        }
                        .community-1 {
                            position: absolute;
                            top: 10px;
                            left: 48px;
                            width: 63px;
                            height: 22px;
                            color: #000000;
                            white-space: nowrap;
                            font-family: "Jockey One";
                            font-size: 16px;
                            line-height: 22px;
                            font-weight: 400;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            text-align: center;
                        }
                        .fluentpeople-community-32-light {
                            position: absolute;
                            top: 5px;
                            left: 16px;
                            width: 28px;
                            height: 28px;
                        }
                    }
                    .chat {
                        position: absolute;
                        top: 0px;
                        left: 143px;
                        width: 165px;
                        height: 43px;
                        .rectangle-41 {
                            position: absolute;
                            top: 0px;
                            left: 0px;
                            width: 165px;
                            height: 43px;
                            border-radius: 140px;
                            background: rgba(226, 73, 91, 0.8);
                        }
                        .rectangle-43 {
                            position: absolute;
                            top: calc(100% - 43px + 5px);
                            left: calc(100% - 165px + 5px);
                            width: 154px;
                            height: 33px;
                            border-radius: 140px;
                            background: rgba(255, 255, 255, 0.8);
                        }
                        .rectangle-44 {
                            position: absolute;
                            top: calc(100% - 43px + 5px);
                            left: calc(100% - 165px + 91px);
                            width: 68px;
                            height: 33px;
                            border-radius: 140px;
                            background: rgba(255, 255, 255, 0.8);
                        }
                        .chat-1 {
                            position: absolute;
                            top: 9px;
                            left: 42px;
                            width: 26px;
                            height: 22px;
                            color: #000000;
                            white-space: nowrap;
                            font-family: "Jockey One";
                            font-size: 16px;
                            line-height: 22px;
                            font-weight: 400;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            text-align: center;
                        }
                    }
                }
                .group-17 {
                    position: absolute;
                    top: 0px;
                    left: 277px;
                    width: 308px;
                    height: 43px;
                    .calender {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 165px;
                        height: 43px;
                        .rectangle-45 {
                            position: absolute;
                            top: 0px;
                            left: 0px;
                            width: 165px;
                            height: 43px;
                            border-radius: 140px;
                            background: rgba(226, 73, 91, 0.8);
                        }
                        .rectangle-46 {
                            position: absolute;
                            top: calc(100% - 43px + 5px);
                            left: calc(100% - 165px + 5px);
                            width: 154px;
                            height: 33px;
                            border-radius: 140px;
                            background: rgba(255, 255, 255, 0.8);
                        }
                        .rectangle-47 {
                            position: absolute;
                            top: calc(100% - 43px + 5px);
                            left: calc(100% - 165px + 91px);
                            width: 68px;
                            height: 33px;
                            border-radius: 140px;
                            background: rgba(255, 255, 255, 0.8);
                        }
                        .calendar {
                            position: absolute;
                            top: 10px;
                            left: 39px;
                            width: 49px;
                            height: 22px;
                            color: #000000;
                            white-space: nowrap;
                            font-family: "Jockey One";
                            font-size: 16px;
                            line-height: 22px;
                            font-weight: 400;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            text-align: center;
                        }
                    }
                    .match {
                        position: absolute;
                        top: 0px;
                        left: 143px;
                        width: 165px;
                        height: 43px;
                        .rectangle-48 {
                            position: absolute;
                            top: 0px;
                            left: 0px;
                            width: 165px;
                            height: 43px;
                            border-radius: 140px;
                            background: rgba(226, 73, 91, 0.8);
                        }
                        .rectangle-49 {
                            position: absolute;
                            top: calc(100% - 43px + 5px);
                            left: calc(100% - 165px + 5px);
                            width: 154px;
                            height: 33px;
                            border-radius: 140px;
                            background: rgba(255, 255, 255, 0.8);
                        }
                        .rectangle-50 {
                            position: absolute;
                            top: calc(100% - 43px + 5px);
                            left: calc(100% - 165px + 91px);
                            width: 68px;
                            height: 33px;
                            border-radius: 140px;
                            background: rgba(255, 255, 255, 0.8);
                        }
                        .matching {
                            position: absolute;
                            top: 9px;
                            left: 40.5px;
                            width: 51px;
                            height: 22px;
                            color: #000000;
                            white-space: nowrap;
                            font-family: "Jockey One";
                            font-size: 16px;
                            line-height: 22px;
                            font-weight: 400;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            text-align: center;
                        }
                    }
                }
            }
            .arcticonslitmatch {
                position: absolute;
                top: 39px;
                left: 447px;
                width: 24px;
                height: 24px;
            }
            .uitcalender {
                position: absolute;
                top: 39px;
                left: 303px;
                width: 24px;
                height: 24px;
            }
            .fluentchat-32-light {
                position: absolute;
                top: 39px;
                left: 170px;
                width: 23px;
                height: 23px;
            }
            .line-13 {
                position: absolute;
                top: 100px;
                left: 355px;
                width: 2.83px;
                transform-origin: 0 0;
                transform: rotate(-45deg);
                border: 1px solid #000000;
            }
        }
        .tong {
            position: absolute;
            top: 4px;
            left: 0px;
            width: 118px;
            height: 84px;
            color: #E2495B;
            white-space: nowrap;
            font-family: "Jockey One";
            font-size: 60px;
            line-height: 84px;
            font-weight: 400;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }
    }
    .group--23 {
        position: absolute;
        top: 286px;
        left: 52px;
        width: 648.02px;
        height: 52px;
        .rectangle-51 {
            position: absolute;
            top: -3px;
            left: -3px;
            width: 664px;
            height: 68px;
        }
        .group-23 {
            position: absolute;
            top: 17.55px;
            left: 265px;
            width: 127px;
            height: 17.55px;
            .text---10 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 95px;
                height: 16.2px;
                color: #FFFFFF;
                font-family: "Jockey One";
                font-size: 20px;
                line-height: 24px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
            .icon-park-outlineclick {
                position: absolute;
                top: -0.55px;
                left: 100px;
                width: 27px;
                height: 19px;
            }
        }
    }
    .kakaomap {
        position: absolute;
        top: 227px;
        left: 727px;
        width: 696px;
        height: 749px;
        overflow: hidden;
    }
}
</style>