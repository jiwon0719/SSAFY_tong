<template>
    
        <div class="frame-31">
            <div class="text-2024-sep">
                2024 SEP
            </div>
            <div class="caldendar-frame">
                
                <component :is="currentComponentdefault"/>

            </div>
        </div>
        <div class="rectangle-46">
        </div>
        <div class="frame-30" @click="goToReservation()">
            <div class="frame-">
                <div class="rectangle-">
                </div>
                <div class="text-">
                    예약하기
                </div>
            </div>
        </div>
        <div class="frame--1">
            <div class="rectangle--">
            </div>
            <div class="group--">
                <div class="group---1">
                    <div class="text-2024-10-31-1756">
                        2024. 10. 31. 17:56
                    </div>
                    <div class="dr-james">
                        DR. James
                    </div>
                    <div class="quest1">
                        <svg id="0:5419" class="carboncheckbox"></svg>
                        <div class="text----2l-">
                            제목 :매일 물 2L 마시기
                        </div>
                        <div class="text-----">
                            상세 내용 : 머시 기머시기
                        </div>
                    </div>
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/10454e45f00c39b63f1796fea149c321.jpg" class="frame-10" />
            </div>
            <div class="rectangle-45">
            </div>
        </div>
    
</template>

<style lang="scss">
    .calendarframe {
    width: 100%;
    height: 813px;
    overflow: hidden;
    .frame-31 {
        position: absolute;
        top: 19px;
        left: 24px;
        width: 786px;
        height: 710px;
        overflow: hidden;
        .text-2024-sep {
            position: absolute;
            top: 0px;
            left: 272px;
            width: 173px;
            height: 74px;
            white-space: nowrap;
            color: #000000;
            font-family: "Jockey One";
            font-size: 53px;
            line-height: 74px;
            font-weight: 400;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }
        .caldendar-frame {
            position: absolute;
            top: 115px;
            left: 0px;
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
    }
    .rectangle-46 {
        position: absolute;
        top: 199px;
        left: 851px;
        width: 521px;
        height: 119px;
        border-radius: 10px;
        border: 1px solid #0015FF;
    }
    .frame-30 {
        position: absolute;
        top: 199px;
        left: 851px;
        width: 521px;
        height: 510px;
        overflow: hidden;
        .frame- {
            position: absolute;
            top: calc(100% - 510px + 434px);
            left: calc(100% - 521px + 337px);
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
        .rectangle-45 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 521px;
            height: 119px;
            border-radius: 10px;
            border: 1px solid #0015FF;
        }
    }
}
</style>

<script>
    import CalendarDefaultCalendar from '@/components/CalendarDefaultCalendar.vue';
    import CalendarDefaultReservation from '@/components/CalendarDefaultReservation.vue';
    

export default {
  data() {
    return {
        currentComponentdefault: 'CalendarDefaultCalendar',
    };
  },
  components: {
    CalendarDefaultCalendar,
    CalendarDefaultReservation,
  },
  methods: {
    changeComponentDefault(componentName) {
        alert(componentName+"으로 이동합니다."); 
      this.currentComponentdefault = componentName;
    },

    goToReservation() {
        this.currentComponentdefault = 'CalendarDefaultReservation';
    },

  },

};

</script>