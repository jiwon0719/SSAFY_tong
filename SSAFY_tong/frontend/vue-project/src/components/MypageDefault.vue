<template>
    
        <div class="text---">
            나의 매칭 전문가
        </div>
        
        <div class="expert-1">
            <div class="rectangle---1">
            </div>
            <div class="pt1-1">
                <div class="frame--2">
                    <div class="text--3">
                        매칭됨
                    </div>
                    <div class="text--2024-11-04---1">
                        [ 2024. 11. 04. 토~ ]
                    </div>
                </div>
                <div class="frame---1">
                    <div class="text--4">
                        정형외과
                    </div>
                    <svg id="10:4491" class="line-4"></svg>
                    <div class="text---1">
                        유승홍 선생님
                    </div>
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/dd8e514e3827f4c92de288233469584a.jpg" class="rectangle--2" />
                <div class="frame--3" @click='toggleScoreFrame'>
                    <div class="rectangle--3">
                    </div>
                    <div class="text--5">
                        점수주기
                    </div>
                </div>
            </div>
        </div>
        <div class="score" v-show="scoreFrame" >
            <div class="pt1-2">
                <div class="rectangle---2">
                </div>
                <div class="pt1-3">
                    <div class="group--">
                        <div class="text---2">
                            유승홍 선생님
                        </div>
                    </div>
                </div>
            </div>
            <div class="group-28">
                <svg id="10:1668" class="group-27"></svg>
                <div class="text-5">
                    / 5
                </div>
            </div>
            <div class="frame--4" @click='toggleScoreFrame'>
                <div class="rectangle--4">
                </div>
                <div class="text--6">
                    점수주기
                </div>
            </div>
        </div>

</template>

<style lang='scss'>
    .mypagedefault {
    width: 1083px;
    height: 792px;
    overflow: hidden;
    .text--- {
        position: absolute;
        top: 13px;
        left: 20px;
        width: 158px;
        height: 34px;
        white-space: nowrap;
        color: #000000;
        font-family: "Jockey One";
        font-size: 24px;
        line-height: 34px;
        font-weight: 400;
        display: flex;
        align-items: center;
        justify-content: center;
        text-align: center;
    }
    .expert {
        position: absolute;
        top: 56px;
        left: 10px;
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
        .pt1 {
            position: absolute;
            top: 10px;
            left: 9px;
            width: 375px;
            height: 98px;
            overflow: hidden;
            .frame- {
                position: absolute;
                top: 22px;
                left: 117px;
                width: 161px;
                height: 41px;
                overflow: hidden;
                .text- {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 60.59px;
                    height: 23px;
                    color: #8A8A8A;
                    font-family: "Jockey One";
                    font-size: 12px;
                    line-height: 17px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text--2024-11-04-- {
                    position: absolute;
                    top: 18px;
                    left: 0px;
                    width: 161px;
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
            .frame-- {
                position: absolute;
                top: 1px;
                left: 115px;
                width: 260px;
                height: 18px;
                overflow: hidden;
                .text--1 {
                    position: absolute;
                    top: 0px;
                    left: 113.75px;
                    width: 146.25px;
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
                    left: 108px;
                    width: 15px;
                    height: 15px;
                }
                .text-- {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 177.59px;
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
            .rectangle- {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 106px;
                height: 98px;
                border-radius: 5px;
                object-fit: cover;
            }
            .frame--1 {
                position: absolute;
                top: calc(100% - 98px + 72px);
                left: calc(100% - 375px + 251px);
                width: 54px;
                height: 26px;
                overflow: hidden;
                .rectangle--1 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 54px;
                    height: 26px;
                    border-radius: 7px;
                    background: #E2495B;
                }
                .text--2 {
                    position: absolute;
                    top: calc(100% - 26px + 6px);
                    left: calc(100% - 54px + 8px);
                    width: 35px;
                    height: 14px;
                    white-space: nowrap;
                    color: #FFFFFF;
                    font-family: "Jockey One";
                    font-size: 10px;
                    line-height: 14px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
        }
    }
    .expert-1 {
        position: absolute;
        top: 201px;
        left: 10px;
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
            background: rgba(217, 217, 217, 0.32);
        }
        .pt1-1 {
            position: absolute;
            top: 10px;
            left: 9px;
            width: 375px;
            height: 98px;
            overflow: hidden;
            .frame--2 {
                position: absolute;
                top: 22px;
                left: 117px;
                width: 161px;
                height: 41px;
                overflow: hidden;
                .text--3 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 60.59px;
                    height: 23px;
                    color: #8A8A8A;
                    font-family: "Jockey One";
                    font-size: 12px;
                    line-height: 17px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text--2024-11-04---1 {
                    position: absolute;
                    top: 18px;
                    left: 0px;
                    width: 161px;
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
            .frame---1 {
                position: absolute;
                top: 1px;
                left: 115px;
                width: 260px;
                height: 18px;
                overflow: hidden;
                .text--4 {
                    position: absolute;
                    top: 0px;
                    left: 113.75px;
                    width: 146.25px;
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
                    left: 108px;
                    width: 15px;
                    height: 15px;
                }
                .text---1 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 177.59px;
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
            .rectangle--2 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 106px;
                height: 98px;
                border-radius: 5px;
                object-fit: cover;
            }
            .frame--3 {
                position: absolute;
                top: calc(100% - 98px + 72px);
                left: calc(100% - 375px + 251px);
                width: 54px;
                height: 26px;
                overflow: hidden;
                .rectangle--3 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 54px;
                    height: 26px;
                    border-radius: 7px;
                    background: #E2495B;
                }
                .text--5 {
                    position: absolute;
                    top: calc(100% - 26px + 6px);
                    left: calc(100% - 54px + 8px);
                    width: 35px;
                    height: 14px;
                    white-space: nowrap;
                    color: #FFFFFF;
                    font-family: "Jockey One";
                    font-size: 10px;
                    line-height: 14px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
        }
    }
    .score {
        position: absolute;
        top: 56px;
        left: 356px;
        width: 699px;
        height: 255px;
        overflow: hidden;
        .pt1-2 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 699px;
            height: 255px;
            .rectangle---2 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 699px;
                height: 255px;
                border-radius: 5px;
                background: rgba(217, 217, 217, 0.32);
            }
            .pt1-3 {
                position: absolute;
                top: 11px;
                left: 279px;
                width: 160px;
                height: 18px;
                .group-- {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 160px;
                    height: 18px;
                    .text---2 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 160px;
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
            }
        }
        .group-28 {
            position: absolute;
            top: 107px;
            left: 177px;
            width: 346px;
            height: 38px;
            .group-27 {
                position: absolute;
                top: 0%;
                left: 0%;
                right: 19.94%;
                bottom: 15.79%;
                width: calc(100% - 0% - 19.94%);
                height: calc(100% - 0% - 15.79%);
            }
            .text-5 {
                position: absolute;
                top: 2px;
                left: 288px;
                width: 58px;
                height: 36px;
                color: #FFFFFF;
                font-family: "Jockey One";
                font-size: 40px;
                line-height: 56px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
        }
        .frame--4 {
            position: absolute;
            top: calc(100% - 255px + 225px);
            left: calc(100% - 699px + 641px);
            width: 54px;
            height: 26px;
            overflow: hidden;
            .rectangle--4 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 54px;
                height: 26px;
                border-radius: 7px;
                background: #E2495B;
            }
            .text--6 {
                position: absolute;
                top: calc(100% - 26px + 6px);
                left: calc(100% - 54px + 8px);
                width: 35px;
                height: 14px;
                white-space: nowrap;
                color: #FFFFFF;
                font-family: "Jockey One";
                font-size: 10px;
                line-height: 14px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
        }
    }
}
</style>

<script>

export default {
  data() {
    return {
      // scoreFrame의 초기값을 false로 설정하여 div는 기본적으로 숨겨져 있음
      scoreFrame: false,

    };
  },
  methods: {
    // 버튼 클릭 시 scoreFrame 값을 toggle하여 보이거나 숨기기
    toggleScoreFrame() {
      this.scoreFrame = !this.scoreFrame;
    },
  },
};

</script>