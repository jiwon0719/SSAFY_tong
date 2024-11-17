<template>
    <div class="frame----">
        <div>
   <img src="../assets/images/Rectangle41.svg" alt="Rectangle Image" />
</div>
        <div class="frame--sidebar">
            <div class="sidebar">
            </div>
            
        </div>
        <div class="frame--sidebar-1">
            <div class="frame--sidebar-2">
                <div class="frame-1">
                    <div class="text-----"  >
                        매칭 전문가 채팅 및 알람
                    </div>
                    <div class="text--7" @click="changeComponent('ChatList')">
                        채팅
                    </div>
                    <svg id="10:1825" class="clip-7"></svg>
                </div>
                <div class="frame-2">
                    <div class="text----2">
                        내 전문가 확인
                    </div>
                    <div class="text----3">
                        나의 매칭 전문가
                    </div>
                    <svg id="10:1860" class="clip-8"></svg>
                </div>
                <div class="frame-3">
                    <div class="text----4">
                        비밀번호 변경 등
                    </div>
                    <div class="text---4">
                        회원정보 수정
                    </div>
                    <svg id="10:1870" class="clip-9"></svg>
                </div>
                <div class="line-3">
                </div>
                <div class="line-4">
                </div>
                <div class="line-5">
                </div>
                <div class="line-6">
                </div>
                <div class="text--8">
                    마이페이지
                </div>
            </div>
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
                            <svg id="10:1966" class="fluentpeople-community-32-light"></svg>
                        </div>
                        <div class="chat">
                            <div class="rectangle-41">
                            </div>
                            <div class="rectangle-42">
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
                <svg id="10:1941" class="arcticonslitmatch"></svg><svg id="10:1939" class="uitcalender"></svg><svg id="10:1937" class="fluentchat-32-light"></svg>
            </div>
            <div class="tong">
                TONG
            </div>
        </div>
        <div class="mypagedefault">
            <component :is="currentComponent" @change-component="changeComponent"/>
        </div>
    </div>
</template>

<style lang="scss">
    .frame---- {
    position: absolute;
    top: 2px;
    left: 6px;
    width: 1440px;
    height: 1024px;
    box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
    overflow: hidden;
    background: #FFFFFF;
    .rectangle-43 {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 1440px;
        height: 1024px;
    }
    .frame--sidebar {
        position: absolute;
        top: 208px;
        left: 17px;
        width: 313px;
        height: 792px;
        overflow: hidden;
        .sidebar {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 313px;
            height: 792px;
            border-radius: 15px;
            background: #FAFAFA;
        }
        .group--sidebar {
            position: absolute;
            top: 13px;
            left: 5px;
            width: 303px;
            height: 411px;
            .hot {
                position: absolute;
                top: 57px;
                left: 9px;
                width: 220px;
                height: 140px;
                .group-1 {
                    position: absolute;
                    top: 22px;
                    left: 21px;
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
                    .text- {
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
                    top: 64px;
                    left: 21px;
                    width: 99px;
                    height: 34px;
                    .text-- {
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
                    .text--1 {
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
                    top: 106px;
                    left: 21px;
                    width: 107px;
                    height: 34px;
                    .text---1 {
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
                    .text--2 {
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
                .hot- {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 106px;
                    height: 22px;
                    .fluent-emoji-flatfire {
                        position: absolute;
                        top: 2px;
                        left: 0px;
                        width: 16px;
                        height: 16px;
                    }
                    .hot--1 {
                        position: absolute;
                        top: 0px;
                        left: 19px;
                        width: 87px;
                        height: 22px;
                        color: #9D9D9D;
                        font-family: "Inter";
                        font-size: 14px;
                        line-height: 17px;
                        font-weight: 400;
                        display: flex;
                        align-items: center;
                    }
                }
            }
            .group-4 {
                position: absolute;
                top: 233px;
                left: 12px;
                width: 95px;
                height: 34px;
                .text--- {
                    position: absolute;
                    top: 22px;
                    left: 18px;
                    width: 65px;
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
                .clip-3 {
                    position: absolute;
                    top: 17.65%;
                    left: 0%;
                    right: 89.47%;
                    bottom: 38.24%;
                    width: calc(100% - 0% - 89.47%);
                    height: calc(100% - 17.65% - 38.24%);
                }
            }
            .group-5 {
                position: absolute;
                top: 281px;
                left: 12px;
                width: 122px;
                height: 34px;
                .text----1 {
                    position: absolute;
                    top: 22px;
                    left: 18px;
                    width: 104px;
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
                .text--4 {
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
                .clip-4 {
                    position: absolute;
                    top: 17.65%;
                    left: 0%;
                    right: 91.8%;
                    bottom: 38.24%;
                    width: calc(100% - 0% - 91.8%);
                    height: calc(100% - 17.65% - 38.24%);
                }
            }
            .group-6 {
                position: absolute;
                top: 329px;
                left: 12px;
                width: 95px;
                height: 34px;
                .text---2 {
                    position: absolute;
                    top: 22px;
                    left: 18px;
                    width: 72px;
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
                .text--5 {
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
                .clip-5 {
                    position: absolute;
                    top: 17.65%;
                    left: 0%;
                    right: 89.47%;
                    bottom: 38.24%;
                    width: calc(100% - 0% - 89.47%);
                    height: calc(100% - 17.65% - 38.24%);
                }
            }
            .group-7 {
                position: absolute;
                top: 377px;
                left: 12px;
                width: 117px;
                height: 34px;
                .text-----1 {
                    position: absolute;
                    top: 22px;
                    left: 18px;
                    width: 95px;
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
                .text---3 {
                    position: absolute;
                    top: 0px;
                    left: 16px;
                    width: 101px;
                    height: 27px;
                    color: #000000;
                    font-family: "Inter";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .clip-6 {
                    position: absolute;
                    top: 17.65%;
                    left: 0%;
                    right: 91.45%;
                    bottom: 38.24%;
                    width: calc(100% - 0% - 91.45%);
                    height: calc(100% - 17.65% - 38.24%);
                }
            }
            .line-2 {
                position: absolute;
                top: 215px;
                left: 0px;
                width: 303px;
                border: 1px solid rgba(0, 0, 0, 0.17);
            }
            .line-1 {
                position: absolute;
                top: 38px;
                left: 0px;
                width: 303px;
                border: 1px solid rgba(0, 0, 0, 0.42);
            }
            .text--6 {
                position: absolute;
                top: 0px;
                left: 9px;
                width: 65px;
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
    }
    .frame--sidebar-1 {
        position: absolute;
        top: 208px;
        left: 17px;
        width: 313px;
        height: 792px;
        overflow: hidden;
        .sidebar-1 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 313px;
            height: 792px;
            border-radius: 15px;
            background: #FAFAFA;
        }
        .frame--sidebar-2 {
            position: absolute;
            top: 10.5px;
            left: 5px;
            width: 303px;
            height: 186.5px;
            overflow: hidden;
            .frame-1 {
                position: absolute;
                top: 92.5px;
                left: 12px;
                width: 185px;
                height: 35px;
                overflow: hidden;
                .text----- {
                    position: absolute;
                    top: 21px;
                    left: 18px;
                    width: 91px;
                    height: 14px;
                    white-space: nowrap;
                    color: #000000;
                    font-family: "Jockey One";
                    font-size: 10px;
                    line-height: 14px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text--7 {
                    position: absolute;
                    top: 0px;
                    left: 16px;
                    width: 169px;
                    height: 27px;
                    color: #000000;
                    font-family: "Jockey One";
                    font-size: 16px;
                    line-height: 22px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .clip-7 {
                    position: absolute;
                    top: 17.14%;
                    left: 0%;
                    right: 94.59%;
                    bottom: 40%;
                    width: calc(100% - 0% - 94.59%);
                    height: calc(100% - 17.14% - 40%);
                }
            }
            .frame-2 {
                position: absolute;
                top: 45.5px;
                left: 12px;
                width: 288px;
                height: 35px;
                overflow: hidden;
                .text----2 {
                    position: absolute;
                    top: 21px;
                    left: 18px;
                    width: 54px;
                    height: 14px;
                    white-space: nowrap;
                    color: #000000;
                    font-family: "Jockey One";
                    font-size: 10px;
                    line-height: 14px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text----3 {
                    position: absolute;
                    top: 0px;
                    left: 16px;
                    width: 272px;
                    height: 27px;
                    color: #000000;
                    font-family: "Jockey One";
                    font-size: 16px;
                    line-height: 22px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .clip-8 {
                    position: absolute;
                    top: 17.14%;
                    left: 0%;
                    right: 96.53%;
                    bottom: 40%;
                    width: calc(100% - 0% - 96.53%);
                    height: calc(100% - 17.14% - 40%);
                }
            }
            .frame-3 {
                position: absolute;
                top: 141.5px;
                left: 12px;
                width: 246px;
                height: 35px;
                overflow: hidden;
                .text----4 {
                    position: absolute;
                    top: 21px;
                    left: 18px;
                    width: 63px;
                    height: 14px;
                    white-space: nowrap;
                    color: #000000;
                    font-family: "Jockey One";
                    font-size: 10px;
                    line-height: 14px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---4 {
                    position: absolute;
                    top: 0px;
                    left: 16px;
                    width: 230px;
                    height: 27px;
                    color: #000000;
                    font-family: "Jockey One";
                    font-size: 16px;
                    line-height: 22px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .clip-9 {
                    position: absolute;
                    top: 17.14%;
                    left: 0%;
                    right: 95.93%;
                    bottom: 40%;
                    width: calc(100% - 0% - 95.93%);
                    height: calc(100% - 17.14% - 40%);
                }
            }
            .line-3 {
                position: absolute;
                top: 136.5px;
                left: 0px;
                width: 303px;
                border: 1px solid rgba(0, 0, 0, 0.17);
            }
            .line-4 {
                position: absolute;
                top: 186.5px;
                left: 0px;
                width: 303px;
                border: 1px solid rgba(0, 0, 0, 0.17);
            }
            .line-5 {
                position: absolute;
                top: 87.5px;
                left: 0px;
                width: 303px;
                border: 1px solid rgba(0, 0, 0, 0.17);
            }
            .line-6 {
                position: absolute;
                top: 40.5px;
                left: 0px;
                width: 303px;
                border: 1px solid rgba(0, 0, 0, 0.42);
            }
            .text--8 {
                position: absolute;
                top: 0px;
                left: 4px;
                width: 108px;
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
        }
    }
    .group- {
        position: absolute;
        top: 47px;
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
                        .rectangle-42 {
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
    .mypagedefault {
        position: absolute;
        top: 209px;
        left: 343px;
        width: 1083px;
        height: 792px;
        overflow: hidden;
        .text----5 {
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
                    .text--9 {
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
                    .text--10 {
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
                    .line-7 {
                        position: absolute;
                        top: 1px;
                        left: 108px;
                        width: 15px;
                        height: 15px;
                    }
                    .text---5 {
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
                    .text--11 {
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
                    .text--12 {
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
                    .text--13 {
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
                    .line-8 {
                        position: absolute;
                        top: 1px;
                        left: 108px;
                        width: 15px;
                        height: 15px;
                    }
                    .text---6 {
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
                    .text--14 {
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
                        .text---7 {
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
                .text--15 {
                    position: absolute;
                    top: calc(100% - 26px + 6px);
                    left: calc(100% - 45px + 8px);
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
}
</style>

<script>
import MypageDefault from '@/components/MypageDefault.vue';
import ChatList from '@/components/ChatList.vue';
import ChattingRoom from '@/components/ChattingRoom.vue';

export default {
  data() {
    return {
      // scoreFrame의 초기값을 false로 설정하여 div는 기본적으로 숨겨져 있음
      scoreFrame: false,

      // 초기값으로 MypageDefault 컴포넌트를 설정
      currentComponent: 'MypageDefault',
    };
  },
  components: {
    MypageDefault,  // MypageDefault 컴포넌트를 등록
    ChatList,
    ChattingRoom,
  },
  methods: {
    // 버튼 클릭 시 scoreFrame 값을 toggle하여 보이거나 숨기기
    toggleScoreFrame() {
      this.scoreFrame = !this.scoreFrame;
    },

    changeComponent(componentName) {
        alert(componentName+"으로 이동합니다."); 
      this.currentComponent = componentName;
    },

  },
};
</script>