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
            </div>
            <div class="tong">
                TONG
            </div>
        </div>
        <div class="matchingframe">

            <component :is="currentComponent" @change-component="changeComponent"/>
            

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
    .group- {
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
    .matchingframe {
        position: absolute;
        top: 179px;
        left: 29px;
        width: 1389px;
        height: 813px;
        overflow: auto;
        .sidebar {
            position: absolute;
            top: 42px;
            left: 0px;
            width: 701px;
            height: 787px;
            overflow: hidden;
            .frame-bar {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 701px;
                height: 787px;
                overflow: hidden;
                .sidebar-1 {
                    position: absolute;
                    top: 0px;
                    left: -1px;
                    width: 701px;
                    height: 787px;
                    border-radius: 15px;
                    background: rgba(255, 255, 255, 0);
                }
                .frame--pt {
                    position: absolute;
                    top: 77px;
                    left: 30px;
                    width: 650px;
                    height: 48px;
                    overflow: hidden;
                    .rectangle- {
                        position: absolute;
                        top: 0px;
                        left: calc(100% - 650px + 0px);
                        width: 650px;
                        height: 48px;
                        border-radius: 12px;
                        background: #E2495B;
                    }
                    .text-- {
                        position: absolute;
                        top: 9px;
                        left: calc(100% - 650px + 279px);
                        width: 92px;
                        height: 28px;
                        white-space: nowrap;
                        color: #FFFFFF;
                        font-family: "Jockey One";
                        font-size: 20px;
                        line-height: 28px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                    .icon-park-outlineclick {
                        position: absolute;
                        top: 14px;
                        left: 379px;
                        width: 27px;
                        height: 17.55px;
                    }
                }
            }
            .frame--1 {
                position: absolute;
                top: 13px;
                left: 362px;
                width: 313px;
                height: 50px;
                overflow: hidden;
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
                .group--1 {
                    position: absolute;
                    top: 30%;
                    left: 87.22%;
                    right: 7.03%;
                    bottom: 28%;
                    width: calc(100% - 87.6% - 7.43%);
                    height: calc(100% - 32% - 31.3%);
                }
            }
            .frame--pt-1 {
                position: absolute;
                top: 14px;
                left: 273px;
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
                top: 14px;
                left: 185px;
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
                            width: 15px;
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
                    .group--3 {
                        position: absolute;
                        top: 86.97px;
                        left: 268.04px;
                        width: 28.96px;
                        height: 14.03px;
                        .vector-15 {
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
                top: 398px;
                left: 26px;
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
                            width: 15px;
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
                    .group--5 {
                        position: absolute;
                        top: 86.97px;
                        left: 268.04px;
                        width: 28.96px;
                        height: 14.03px;
                        .vector-16 {
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
            .pt1-4 {
                position: absolute;
                top: 525px;
                left: 26px;
                width: 322px;
                height: 119px;
                overflow: hidden;
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
                    .group---2 {
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
                            width: 15px;
                            height: 15px;
                        }
                        .text---3 {
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
                    .rectangle--5 {
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
                        .vector-17 {
                            position: absolute;
                            top: -6.92%;
                            left: -0.15%;
                            right: 51.8%;
                            bottom: 7.14%;
                            width: calc(100% - 0% - 51.93%);
                            height: calc(100% - 0% - 10.76%);
                        }
                        .text-51 {
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
            .pt1-6 {
                position: absolute;
                top: 652px;
                left: 26px;
                width: 322px;
                height: 119px;
                overflow: hidden;
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
                    .group---3 {
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
                        .line-7 {
                            position: absolute;
                            top: 1px;
                            left: 93px;
                            width: 15px;
                            height: 15px;
                        }
                        .text---4 {
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
                    .rectangle--6 {
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
                        .vector-18 {
                            position: absolute;
                            top: -6.92%;
                            left: -0.15%;
                            right: 51.8%;
                            bottom: 7.14%;
                            width: calc(100% - 0% - 51.93%);
                            height: calc(100% - 0% - 10.76%);
                        }
                        .text-52 {
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
            .pt1-8 {
                position: absolute;
                top: 271px;
                left: 26px;
                width: 322px;
                height: 119px;
                overflow: hidden;
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
                    .group---4 {
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
                        .line-8 {
                            position: absolute;
                            top: 1px;
                            left: 93px;
                            width: 15px;
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
                    .group--11 {
                        position: absolute;
                        top: 86.97px;
                        left: 268.04px;
                        width: 28.96px;
                        height: 14.03px;
                        .vector-19 {
                            position: absolute;
                            top: -6.92%;
                            left: -0.15%;
                            right: 51.8%;
                            bottom: 7.14%;
                            width: calc(100% - 0% - 51.93%);
                            height: calc(100% - 0% - 10.76%);
                        }
                        .text-53 {
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
            .pt1-10 {
                position: absolute;
                top: 144px;
                left: 353px;
                width: 322px;
                height: 119px;
                overflow: hidden;
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
                            font-family: "Jockey One";
                            font-size: 12px;
                            line-height: 17px;
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
                        .pt-4 {
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
                        .line-9 {
                            position: absolute;
                            top: 1px;
                            left: 93px;
                            width: 15px;
                            height: 15px;
                        }
                        .text---6 {
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
                    .rectangle--8 {
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
                        .vector-20 {
                            position: absolute;
                            top: -6.92%;
                            left: -0.15%;
                            right: 51.8%;
                            bottom: 7.14%;
                            width: calc(100% - 0% - 51.93%);
                            height: calc(100% - 0% - 10.76%);
                        }
                        .text-54 {
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
            .pt1-12 {
                position: absolute;
                top: 398px;
                left: 353px;
                width: 322px;
                height: 119px;
                overflow: hidden;
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
                    .group---6 {
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
                        .line-10 {
                            position: absolute;
                            top: 1px;
                            left: 93px;
                            width: 15px;
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
                    .group--15 {
                        position: absolute;
                        top: 86.97px;
                        left: 268.04px;
                        width: 28.96px;
                        height: 14.03px;
                        .vector-21 {
                            position: absolute;
                            top: -6.92%;
                            left: -0.15%;
                            right: 51.8%;
                            bottom: 7.14%;
                            width: calc(100% - 0% - 51.93%);
                            height: calc(100% - 0% - 10.76%);
                        }
                        .text-55 {
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
            .pt1-14 {
                position: absolute;
                top: 525px;
                left: 353px;
                width: 322px;
                height: 119px;
                overflow: hidden;
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
                    .group---7 {
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
                        .line-11 {
                            position: absolute;
                            top: 1px;
                            left: 93px;
                            width: 15px;
                            height: 15px;
                        }
                        .text---8 {
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
                    .rectangle--10 {
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
                        .vector-22 {
                            position: absolute;
                            top: -6.92%;
                            left: -0.15%;
                            right: 51.8%;
                            bottom: 7.14%;
                            width: calc(100% - 0% - 51.93%);
                            height: calc(100% - 0% - 10.76%);
                        }
                        .text-56 {
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
            .pt1-16 {
                position: absolute;
                top: 652px;
                left: 353px;
                width: 322px;
                height: 119px;
                overflow: hidden;
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
                    .group---8 {
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
                        .line-12 {
                            position: absolute;
                            top: 1px;
                            left: 93px;
                            width: 15px;
                            height: 15px;
                        }
                        .text---9 {
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
                    .rectangle--11 {
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
                        .vector-23 {
                            position: absolute;
                            top: -6.92%;
                            left: -0.15%;
                            right: 51.8%;
                            bottom: 7.14%;
                            width: calc(100% - 0% - 51.93%);
                            height: calc(100% - 0% - 10.76%);
                        }
                        .text-57 {
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
            .pt1-18 {
                position: absolute;
                top: 271px;
                left: 353px;
                width: 322px;
                height: 119px;
                overflow: hidden;
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
                    .group---9 {
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
                        .line-13 {
                            position: absolute;
                            top: 1px;
                            left: 93px;
                            width: 15px;
                            height: 15px;
                        }
                        .text---10 {
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
                    .rectangle--12 {
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
                        .vector-24 {
                            position: absolute;
                            top: -6.92%;
                            left: -0.15%;
                            right: 51.8%;
                            bottom: 7.14%;
                            width: calc(100% - 0% - 51.93%);
                            height: calc(100% - 0% - 10.76%);
                        }
                        .text-58 {
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
            position: absolute;
            top: 56px;
            left: 701px;
            width: 696px;
            height: 749px;
            overflow: hidden;
        }
    }
}
</style>

<script>
    import MatchingDefault from '@/components/MatchingDefault.vue';
    import MatchingExpertDetail from '@/components/MatchingExpertDetail.vue';
    import MatchingExpertRegist from '@/components/MatchingExpertRegist.vue';
    

export default {
  data() {
    return {
      currentComponent: 'MatchingDefault',
    };
  },
  components: {
    MatchingDefault,
    MatchingExpertDetail,
    MatchingExpertRegist,
  },
  methods: {
    changeComponent(componentName) {
        alert(componentName+"으로 이동합니다."); 
      this.currentComponent = componentName;
    },

  },
};

</script>