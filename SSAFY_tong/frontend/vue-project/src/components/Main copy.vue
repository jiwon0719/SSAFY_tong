<template>
    <div class="frame--">
        <div>
            <img src="../assets/images/Rectangle41.svg" alt="Rectangle Image" />
        </div>
        
            <component :is="currentComponent" class="mainframe"></component>
        
        <div class="group--3">
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
                            <button @click="goToCommunityPage" style="all: unset;">
                                <div class="community-1">
                                    Community
                                </div>
                            </button>
                            <svg id="0:5589" class="fluentpeople-community-32-light"></svg>
                        </div>
                        <div class="chat">
                            <div class="rectangle-42">
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
                <svg id="0:5607" class="arcticonslitmatch"></svg><svg id="0:5613" class="uitcalender"></svg><svg id="0:5615" class="fluentchat-32-light"></svg>
            </div>
            <div class="tong">
                TONG
            </div>
        </div>
        <div class="login">
            <svg id="0:5647" class="mdiuser-outline"></svg>
            <button @click="goTosignInPage" style="all: unset;">

                <div class="login-1">
                    LOGIN
                </div>
            </button>
        </div>
    </div>
</template>



  <script>
    import mainDefault from '@/components/MainDefault.vue';
    

    export default {

        name: 'Main',  // 컴포넌트 이름
        components : {
            mainDefault,
            
        },
        data() {
            return {
            // 디폴트로 보여지는 컴포넌트
            currentComponent: 'mainDefault', 
            };
        },
        methods: {
            goTosignInPage() {
            // 버튼 클릭 시 이동할 페이지를 설정하거나 다른 로직을 추가
            alert('로그인 페이지로 이동합니다!');
            // 예: Vue Router를 사용하여 페이지 이동
            this.$router.push({ name: 'signIn' });
            },

            goToCommunityPage() {
                alert("커뮤니티 페이지로 이동합니다.");
                this.$router.push({name: 'community'});
            },

            changeComponent(componentName) {
              this.currentComponent = componentName; // 동적으로 컴포넌트를 변경
            },
        }
    }



  </script>
  


<style lang="scss">
.frame-- {
    position: absolute;
    top: 2px;
    left: 6px;
    width: 1440px;
    height: 1024px;
    box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
    overflow: hidden;
    background: #FFFFFF;
    .rectangle-41 {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 1440px;
        height: 1024px;
    }
    .mainframe {
        position: absolute;
        top: 186px;
        left: 25px;
        width: 1387px;
        height: 794px;
        overflow: hidden;
        .weather {
            position: absolute;
            top: 38px;
            left: 32px;
            width: 631px;
            height: 319px;
            border-radius: 10px;
            overflow: hidden;
            background: url(https://image-resource.creatie.ai/142625939968981/142625939968983/9b58e45f93b221be42eb2e7df53337f9.jpg);
            object-fit: cover;
            background-size: cover;
            .text- {
                position: absolute;
                top: 12px;
                left: 16px;
                width: 44px;
                height: 29px;
                white-space: nowrap;
                color: #000000;
                font-family: "Bebas Neue";
                font-size: 24px;
                line-height: 29px;
                font-weight: 400;
                display: flex;
                align-items: center;
                justify-content: center;
                text-align: center;
            }
        }
        .booking {
            position: absolute;
            top: 38px;
            left: 720px;
            width: 631px;
            height: 319px;
            border-radius: 10px;
            overflow: hidden;
            background: #FFFFFF;
            border: 1px solid #FFFFFF;
            .text-- {
                position: absolute;
                top: 11px;
                left: 12px;
                width: 90px;
                height: 29px;
                white-space: nowrap;
                color: #000000;
                font-family: "Bebas Neue";
                font-size: 24px;
                line-height: 29px;
                font-weight: 400;
                display: flex;
                align-items: center;
                justify-content: center;
                text-align: center;
            }
            .booking-board {
                position: absolute;
                top: 63px;
                left: 31px;
                width: 570px;
                height: 234px;
                overflow: hidden;
                background: #FFFFFF;
                .group- {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 521px;
                    height: 119px;
                    .rectangle-- {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 521px;
                        height: 119px;
                        border-radius: 12px;
                        background: rgba(128, 128, 128, 0.55);
                    }
                    .group-- {
                        position: absolute;
                        top: 12px;
                        left: 7px;
                        width: 499px;
                        height: 103px;
                        .group---1 {
                            position: absolute;
                            top: 79px;
                            left: 417px;
                            width: 82px;
                            height: 24px;
                            .group--1 {
                                position: absolute;
                                top: 0px;
                                left: 51px;
                                width: 31px;
                                height: 24px;
                                .message-circle {
                                    position: absolute;
                                    top: 0px;
                                    left: 0px;
                                    width: 24px;
                                    height: 24px;
                                }
                                .text-3 {
                                    position: absolute;
                                    top: 5px;
                                    left: 21px;
                                    width: 10px;
                                    height: 18px;
                                    white-space: nowrap;
                                    color: #000000;
                                    font-family: "Inter";
                                    font-size: 15px;
                                    line-height: 18px;
                                    font-weight: 400;
                                    display: flex;
                                    align-items: center;
                                }
                            }
                            .group--2 {
                                position: absolute;
                                top: 5px;
                                left: 0px;
                                width: 39px;
                                height: 18px;
                                .text-21 {
                                    position: absolute;
                                    top: 0px;
                                    left: 23px;
                                    width: 16px;
                                    height: 18px;
                                    white-space: nowrap;
                                    color: #000000;
                                    font-family: "Inter";
                                    font-size: 15px;
                                    line-height: 18px;
                                    font-weight: 400;
                                    display: flex;
                                    align-items: center;
                                }
                                .eye {
                                    position: absolute;
                                    top: 0px;
                                    left: 0px;
                                    width: 20px;
                                    height: 18px;
                                }
                            }
                        }
                        .group---2 {
                            position: absolute;
                            top: 1px;
                            left: 35px;
                            width: 379px;
                            height: 83px;
                            .text-2024-10-31-1756 {
                                position: absolute;
                                top: 0px;
                                left: 63px;
                                width: 124px;
                                height: 18px;
                                color: rgba(128, 128, 128, 0.55);
                                font-family: "Inter";
                                font-size: 10px;
                                line-height: 12px;
                                font-weight: 400;
                                display: flex;
                                align-items: center;
                            }
                            .tr-daniel {
                                position: absolute;
                                top: 0px;
                                left: 0px;
                                width: 61px;
                                height: 18px;
                                color: #000000;
                                font-family: "Inter";
                                font-size: 12px;
                                line-height: 15px;
                                font-weight: 400;
                                display: flex;
                                align-items: center;
                            }
                            .quest1 {
                                position: absolute;
                                top: 31px;
                                left: 8px;
                                width: 371px;
                                height: 52px;
                                overflow: hidden;
                                background: rgba(128, 128, 128, 0.55);
                                .carboncheckbox {
                                    position: absolute;
                                    top: 2px;
                                    left: 1px;
                                    width: 16px;
                                    height: 16px;
                                }
                                .text---1630 {
                                    position: absolute;
                                    top: 3px;
                                    left: 26px;
                                    width: 79px;
                                    height: 15px;
                                    white-space: nowrap;
                                    color: #000000;
                                    font-family: "Inter";
                                    font-size: 12px;
                                    line-height: 15px;
                                    font-weight: 400;
                                    display: flex;
                                    align-items: center;
                                }
                                .text {
                                    position: absolute;
                                    top: 26px;
                                    left: 26px;
                                    width: 1px;
                                    height: 15px;
                                    white-space: nowrap;
                                    color: #000000;
                                    font-family: "Inter";
                                    font-size: 12px;
                                    line-height: 15px;
                                    font-weight: 400;
                                    display: flex;
                                    align-items: center;
                                }
                            }
                        }
                        .frame-10 {
                            position: absolute;
                            top: 0px;
                            left: 0px;
                            width: 30px;
                            height: 30px;
                            border-radius: 30px;
                            overflow: hidden;
                            background: rgba(0, 0, 0, 0.55);
                        }
                    }
                }
            }
        }
        .hotboard {
            position: absolute;
            top: 440px;
            left: 32px;
            width: 631px;
            height: 319px;
            border-radius: 10px;
            overflow: hidden;
            background: #FFFFFF;
            border: 1px solid #FFFFFF;
            .booking-board-1 {
                position: absolute;
                top: 63px;
                left: 31px;
                width: 570px;
                height: 234px;
                overflow: hidden;
                background: #FFFFFF;
                .hot {
                    position: absolute;
                    top: 22px;
                    left: 21px;
                    width: 199px;
                    height: 156px;
                    .group-1 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 199px;
                        height: 34px;
                        .text---- {
                            position: absolute;
                            top: 22px;
                            left: 18px;
                            width: 181px;
                            height: 12px;
                            white-space: nowrap;
                            color: #000000;
                            font-family: "Inter";
                            font-size: 10px;
                            line-height: 12px;
                            font-weight: 400;
                            display: flex;
                            align-items: center;
                        }
                        .text--1 {
                            position: absolute;
                            top: 0px;
                            left: 16px;
                            width: 51px;
                            height: 27px;
                            color: #000000;
                            font-family: "Inter";
                            font-size: 16px;
                            line-height: 19px;
                            font-weight: 400;
                            display: flex;
                            align-items: center;
                        }
                        .clip {
                            position: absolute;
                            top: 17.65%;
                            left: 0%;
                            right: 94.97%;
                            bottom: 38.24%;
                            width: calc(100% - 0% - 94.97%);
                            height: calc(100% - 17.65% - 38.24%);
                        }
                    }
                    .group-2 {
                        position: absolute;
                        top: 61px;
                        left: 0px;
                        width: 99px;
                        height: 34px;
                        .text---1 {
                            position: absolute;
                            top: 22px;
                            left: 18px;
                            width: 55px;
                            height: 12px;
                            white-space: nowrap;
                            color: #000000;
                            font-family: "Inter";
                            font-size: 10px;
                            line-height: 12px;
                            font-weight: 400;
                            display: flex;
                            align-items: center;
                        }
                        .text--2 {
                            position: absolute;
                            top: 0px;
                            left: 16px;
                            width: 83px;
                            height: 27px;
                            color: #000000;
                            font-family: "Inter";
                            font-size: 16px;
                            line-height: 19px;
                            font-weight: 400;
                            display: flex;
                            align-items: center;
                        }
                        .clip-1 {
                            position: absolute;
                            top: 17.65%;
                            left: 0%;
                            right: 89.9%;
                            bottom: 38.24%;
                            width: calc(100% - 0% - 89.9%);
                            height: calc(100% - 17.65% - 38.24%);
                        }
                    }
                    .group-3 {
                        position: absolute;
                        top: 122px;
                        left: 0px;
                        width: 107px;
                        height: 34px;
                        .text---2 {
                            position: absolute;
                            top: 22px;
                            left: 18px;
                            width: 89px;
                            height: 12px;
                            white-space: nowrap;
                            color: #000000;
                            font-family: "Inter";
                            font-size: 10px;
                            line-height: 12px;
                            font-weight: 400;
                            display: flex;
                            align-items: center;
                        }
                        .text--3 {
                            position: absolute;
                            top: 0px;
                            left: 16px;
                            width: 79px;
                            height: 27px;
                            color: #000000;
                            font-family: "Inter";
                            font-size: 16px;
                            line-height: 19px;
                            font-weight: 400;
                            display: flex;
                            align-items: center;
                        }
                        .clip-2 {
                            position: absolute;
                            top: 17.65%;
                            left: 0%;
                            right: 90.65%;
                            bottom: 38.24%;
                            width: calc(100% - 0% - 90.65%);
                            height: calc(100% - 17.65% - 38.24%);
                        }
                    }
                }
            }
            .hot- {
                position: absolute;
                top: 20px;
                left: 13px;
                width: 173.45px;
                height: 36px;
                .fluent-emoji-flatfire {
                    position: absolute;
                    top: 3px;
                    left: 0px;
                    width: 26.18px;
                    height: 26.18px;
                }
                .hot--1 {
                    position: absolute;
                    top: 0px;
                    left: 31.09px;
                    width: 142.36px;
                    height: 36px;
                    color: #9D9D9D;
                    font-family: "Inter";
                    font-size: 24px;
                    line-height: 29px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
        }
        .extra {
            position: absolute;
            top: 440px;
            left: 720px;
            width: 631px;
            height: 319px;
            border-radius: 10px;
            overflow: hidden;
            background: #FFFFFF;
            border: 1px solid #FFFFFF;
        }
    }
    .group--3 {
        position: absolute;
        top: 40px;
        left: 96px;
        width: 1093px;
        height: 108px;
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
                            white-space: nowrap;
                            color: #000000;
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
                        .rectangle-42 {
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
                            white-space: nowrap;
                            color: #000000;
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
                            white-space: nowrap;
                            color: #000000;
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
                            white-space: nowrap;
                            color: #000000;
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
            .line-6 {
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
            white-space: nowrap;
            color: #E2495B;
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
    .login {
        position: absolute;
        top: 71px;
        left: 1208px;
        width: 155px;
        height: 42px;
        border-radius: 10px;
        overflow: hidden;
        background: #DC606F;
        .mdiuser-outline {
            position: absolute;
            top: 9px;
            left: 7px;
            width: 24px;
            height: 24px;
        }
        .login-1 {
            position: absolute;
            top: 11px;
            left: 48px;
            width: 60px;
            height: 20px;
            color: #FFFFFF;
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
</style>