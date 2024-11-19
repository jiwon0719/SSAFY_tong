<template>
    <div class="frame-">
        <div>
   <img src="../assets/images/Rectangle41.svg" alt="Rectangle Image" />
</div>
        <div class="group-">
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
                            <svg id="0:5366" class="fluentpeople-community-32-light"></svg>
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
                <svg id="0:5384" class="arcticonslitmatch"></svg><svg id="0:5390" class="uitcalender"></svg><svg id="0:5392" class="fluentchat-32-light"></svg>

            </div>
            <div class="tong">
                TONG
            </div>
        </div>
        <div class="calendarframe">

            <component :is="currentComponent" @change-component="changeComponent"/>

        </div>
        
    </div>
</template>

<style lang="scss">
    .frame- {
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
    .group- {
        position: absolute;
        top: 40px;
        left: 96px;
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
    .calendarframe {
        position: absolute;
        top: 179px;
        left: 29px;
        width: 1389px;
        height: 813px;
        overflow: hidden;
        .text-2024-sep {
            position: absolute;
            top: 24px;
            left: 304px;
            width: 157px;
            height: 64px;
            white-space: nowrap;
            color: #000000;
            font-family: "Bebas Neue";
            font-size: 53px;
            line-height: 64px;
            font-weight: 400;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }
        .caldendar-frame {
            position: absolute;
            top: 134px;
            left: 24px;
            width: 786px;
            height: 595px;
            overflow: hidden;
            .beige-calendar {
                position: absolute;
                top: 17px;
                left: 88px;
                width: 610px;
                height: 531px;
                object-fit: contain;
            }
        }
        .frame--1 {
            position: absolute;
            top: 199px;
            left: 851px;
            width: 521px;
            height: 119px;
            overflow: hidden;
            .rectangle-- {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                border-radius: 12px;
                background: rgba(255, 255, 255, 0.55);
            }
            .group-- {
                position: absolute;
                top: 12px;
                left: 7px;
                width: 414px;
                height: 84px;
                .group---1 {
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
                        color: #B0B0B0;
                        font-family: "Inter";
                        font-size: 10px;
                        line-height: 12px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .dr-james {
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
                        .carboncheckbox {
                            position: absolute;
                            top: 2px;
                            left: 1px;
                            width: 16px;
                            height: 16px;
                        }
                        .text----2l- {
                            position: absolute;
                            top: 3px;
                            left: 26px;
                            width: 111px;
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
                        .text----- {
                            position: absolute;
                            top: 26px;
                            left: 26px;
                            width: 119px;
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
                    object-fit: cover;
                }
            }
            .rectangle-51 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                border-radius: 10px;
                border: 1px solid #0015FF;
            }
        }
        .frame--2 {
            position: absolute;
            top: 352px;
            left: 851px;
            width: 521px;
            height: 119px;
            overflow: hidden;
            .rectangle---1 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                border-radius: 12px;
                background: rgba(255, 255, 255, 0.55);
            }
            .group---2 {
                position: absolute;
                top: 12px;
                left: 7px;
                width: 414px;
                height: 84px;
                .group---3 {
                    position: absolute;
                    top: 1px;
                    left: 35px;
                    width: 379px;
                    height: 83px;
                    .text-2024-10-31-1757 {
                        position: absolute;
                        top: 0px;
                        left: 63px;
                        width: 124px;
                        height: 18px;
                        color: #B0B0B0;
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
                    .quest1-1 {
                        position: absolute;
                        top: 31px;
                        left: 8px;
                        width: 371px;
                        height: 52px;
                        overflow: hidden;
                        .carboncheckbox-1 {
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
                .frame-11 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 30px;
                    height: 30px;
                    border-radius: 30px;
                    object-fit: cover;
                }
            }
            .rectangle-52 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                border-radius: 10px;
                border: 1px solid #FF0000;
            }
        }
        .rectangle-53 {
            position: absolute;
            top: 199px;
            left: 851px;
            width: 521px;
            height: 119px;
            border-radius: 10px;
            border: 1px solid #0015FF;
        }
        .frame--3 {
            position: absolute;
            top: calc(100% - 813px + 633px);
            left: calc(100% - 1389px + 1188px);
            width: 115px;
            height: 76px;
            overflow: hidden;
            .rectangle- {
                position: absolute;
                top: 1px;
                left: 0px;
                width: 113px;
                height: 73px;
                border-radius: 7px;
                background: #E2495B;
            }
            .text- {
                position: absolute;
                top: calc(100% - 76px + 25px);
                left: calc(100% - 115px + 24px);
                width: 68px;
                height: 27px;
                white-space: nowrap;
                color: #FFFFFF;
                font-family: "Jockey One";
                font-size: 19px;
                line-height: 27px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
        }
    }
}
</style>

<script>
    import CalendarDefault from '@/components/CalendarDefault.vue';
    import CalendarReservation from '@/components/CalendarDefaultReservation.vue';
    

export default {
  data() {
    return {
      currentComponent: 'CalendarDefault',
    };
  },
  components: {
    CalendarDefault,
    CalendarReservation,
  },
  methods: {
    changeComponent(componentName) {
        alert(componentName+"으로 이동합니다."); 
      this.currentComponent = componentName;
    },

  },
};
</script>