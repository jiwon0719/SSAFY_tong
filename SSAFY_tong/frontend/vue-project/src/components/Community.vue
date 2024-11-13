<template>
    <div class="frame--">
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
                            <svg id="0:884" class="fluentpeople-community-32-light"></svg>
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
                <svg id="0:902" class="arcticonslitmatch"></svg><svg id="0:908" class="uitcalender"></svg><svg id="0:910" class="fluentchat-32-light"></svg>
            </div>
            <div class="tong">
                TONG
            </div>
        </div>
        <div class="communitymainframe">
            <component :is="currentComponent" @change-component="changeComponent" />
        </div>
        <div class="asideframe">
            <div class="group--sidebar">
                <div class="sidebar">
                </div>
                <div class="group--sidebar-1">
                    <div class="hot">
                        <div class="group-1">
                            <div class="text----">
                                보디빌딩, 웨이트등 운동좋아하시는분들 오세용
                            </div>
                            <div class="text-">
                                헬스방
                            </div>
                            <svg id="0:749" class="clip"></svg>
                        </div>
                        <div class="group-2">
                            <div class="text---12">
                                아무말 대잔치
                            </div>
                            <div class="text--1">
                                자유게시판
                            </div>
                            <svg id="0:756" class="clip-1"></svg>
                        </div>
                        <div class="group-3">
                            <div class="text---13">
                                운동하면서 친해지실분
                            </div>
                            <div class="text--2">
                                친구만들기
                            </div>
                            <svg id="0:761" class="clip-2"></svg>
                        </div>
                        <div class="hot-">
                            <svg id="0:764" class="fluent-emoji-flatfire"></svg>
                            <div class="hot--1">
                                HOT 게시판
                            </div>
                        </div>
                    </div>
                    <div class="group-4">
                        <div class="text----11">
                            운동 꿀팁 전해요
                        </div>
                        <div class="text--3">
                            정보게시판
                        </div>
                        <svg id="0:778" class="clip-3"></svg>
                    </div>
                    <div class="group-5">
                        <div class="text----12">
                            우리동네 넘버원 헬스장은?
                        </div>
                        <div class="text--4">
                            홍보게시판
                        </div>
                        <svg id="0:783" class="clip-4"></svg>
                    </div>
                    <div class="group-6">
                        <div class="text---14">
                            뇌근육도 근육이다
                        </div>
                        <div class="text--5">
                            퀴즈게시판
                        </div>
                        <svg id="0:788" class="clip-5"></svg>
                    </div>
                    <div class="group-7">
                        <div class="text-----1">
                            극복하기 위한 여럿의 힘!
                        </div>
                        <div class="text---15">
                            우울증 게시판
                        </div>
                        <svg id="0:793" class="clip-6"></svg>
                    </div>
                    <div class="line-2">
                    </div>
                    <div class="line-1">
                    </div>
                    <div class="text--6">
                        게시판
                    </div>
                </div>
            </div>
            <div class="group--sidebar-2">
                <div class="sidebar-1">
                </div>
                <div class="group--sidebar-3">
                    <div class="hot-1">
                        <div class="group-8">
                            <div class="text-----2">
                                보디빌딩, 웨이트등 운동좋아하시는분들 오세용
                            </div>
                            <div class="text--7">
                                헬스방
                            </div>
                            <svg id="0:811" class="clip-7"></svg>
                        </div>
                        <div class="group-9">
                            <div class="text---16">
                                아무말 대잔치
                            </div>
                            <div class="text--8">
                                자유게시판
                            </div>
                            <svg id="0:816" class="clip-8"></svg>
                        </div>
                        <div class="group-11">
                            <div class="text---17">
                                운동하면서 친해지실분
                            </div>
                            <div class="text--9">
                                친구만들기
                            </div>
                            <svg id="0:821" class="clip-9"></svg>
                        </div>
                        <div class="hot--2">
                            <svg id="0:824" class="fluent-emoji-flatfire-1"></svg>
                            <div class="hot--3">
                                HOT 게시판
                            </div>
                        </div>
                    </div>
                    <div class="group-13">
                        <div class="text----13">
                            운동 꿀팁 전해요
                        </div>
                        <div class="text--10">
                            정보게시판
                        </div>
                        <svg id="0:832" class="clip-10"></svg>
                    </div>
                    <div class="group-14">
                        <div class="text----14">
                            우리동네 넘버원 헬스장은?
                        </div>
                        <div class="text--11">
                            홍보게시판
                        </div>
                        <svg id="0:837" class="clip-11"></svg>
                    </div>
                    <div class="group-15">
                        <div class="text---18">
                            뇌근육도 근육이다
                        </div>
                        <div class="text--12">
                            퀴즈게시판
                        </div>
                        <svg id="0:842" class="clip-12"></svg>
                    </div>
                    <div class="group-18">
                        <div class="text-----3">
                            극복하기 위한 여럿의 힘!
                        </div>
                        <div class="text---19">
                            우울증 게시판
                        </div>
                        <svg id="0:847" class="clip-13"></svg>
                    </div>
                    <div class="line-13">
                    </div>
                    <div class="line-14">
                    </div>
                    <div class="text--13">
                        게시판
                    </div>
                </div>
            </div>
            <div class="group---31" v-if="!isComponentRegist" @click="changeComponent('CommunityRegist')">
                <div class="rectangle--1">
                </div>
                <div class="text---20">
                    게시판 등록
                </div>
            </div>
        </div>
    </div>
</template>

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
    .rectangle-42 {
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
    .communitymainframe {
        position: absolute;
        top: 208px;
        left: 343px;
        width: 1083px;
        height: 792px;
        overflow: hidden;
        .group--1 {
            position: absolute;
            top: 43px;
            left: 539px;
            width: 300px;
            height: 50px;
            .pen- {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 300px;
                height: 50px;
            }
            .text--- {
                position: absolute;
                top: 16px;
                left: 118px;
                width: 125px;
                height: 19px;
                white-space: nowrap;
                color: #000000;
                font-family: "Inter";
                font-size: 16px;
                line-height: 19px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
            .vector-8 {
                position: absolute;
                top: 28%;
                left: 87.33%;
                right: 6.67%;
                bottom: 36%;
                width: calc(100% - 87.67% - 7%);
                height: calc(100% - 30% - 38%);
            }
            .vector-9 {
                position: absolute;
                top: 56%;
                left: 92%;
                right: 5.67%;
                bottom: 30%;
                width: calc(100% - 92.33% - 6.22%);
                height: calc(100% - 58% - 33.3%);
            }
        }
        .group-- {
            position: absolute;
            top: 43px;
            left: 958px;
            width: 101px;
            height: 48px;
            .rectangle- {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 101px;
                height: 48px;
                border-radius: 12px;
                background: #E2495B;
            }
            .text-- {
                position: absolute;
                top: 16px;
                left: 13px;
                width: 73px;
                height: 19px;
                white-space: nowrap;
                color: #FFFFFF;
                font-family: "Bebas Neue";
                font-size: 16px;
                line-height: 19px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
        }
        .group-10 {
            position: absolute;
            top: 43px;
            left: 848px;
            width: 101px;
            height: 48px;
            .rectangle-- {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 101px;
                height: 48px;
                border-radius: 12px;
                background: #E2495B;
            }
            .text-10- {
                position: absolute;
                top: 16px;
                left: 6px;
                width: 71px;
                height: 19px;
                white-space: nowrap;
                color: #FFFFFF;
                font-family: "Bebas Neue";
                font-size: 16px;
                line-height: 19px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
            .material-symbolsarrow-drop-down-rounded {
                position: absolute;
                top: 13px;
                left: 73px;
                width: 24px;
                height: 24px;
            }
        }
        .group--2 {
            position: absolute;
            top: 106px;
            left: 15px;
            width: 521px;
            height: 119px;
            .group---1 {
                position: absolute;
                top: 89px;
                left: 424px;
                width: 82px;
                height: 24px;
                .group--3 {
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
                .group--4 {
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
                top: 29px;
                left: 42px;
                width: 306px;
                height: 54px;
                .text----1 {
                    position: absolute;
                    top: 21px;
                    left: 0px;
                    width: 306px;
                    height: 33px;
                    color: rgba(0, 0, 0, 0.33);
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---1 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 185px;
                    height: 33px;
                    color: #000000;
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
            .group---3 {
                position: absolute;
                top: 2px;
                left: 6px;
                width: 223px;
                height: 37px;
                .text-2024-10-31-1756 {
                    position: absolute;
                    top: 9px;
                    left: 99px;
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
                .line-3 {
                    position: absolute;
                    top: 10px;
                    left: 89px;
                    width: 15px;
                    height: 15px;
                }
                .hjw9265 {
                    position: absolute;
                    top: 9px;
                    left: 36px;
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
                .writer- {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 41px;
                    height: 37px;
                    object-fit: cover;
                }
            }
            .rectangle---1 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                background: rgba(217, 217, 217, 0.32);
            }
        }
        .group--5 {
            position: absolute;
            top: 106px;
            left: 539px;
            width: 521px;
            height: 119px;
            .group---4 {
                position: absolute;
                top: 89px;
                left: 424px;
                width: 82px;
                height: 24px;
                .group--6 {
                    position: absolute;
                    top: 0px;
                    left: 51px;
                    width: 31px;
                    height: 24px;
                    .message-circle-1 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 24px;
                        height: 24px;
                    }
                    .text-4 {
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
                .group--7 {
                    position: absolute;
                    top: 5px;
                    left: 0px;
                    width: 39px;
                    height: 18px;
                    .text-22 {
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
                    .eye-1 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 20px;
                        height: 18px;
                    }
                }
            }
            .group---5 {
                position: absolute;
                top: 29px;
                left: 42px;
                width: 306px;
                height: 54px;
                .text----2 {
                    position: absolute;
                    top: 21px;
                    left: 0px;
                    width: 306px;
                    height: 33px;
                    color: rgba(0, 0, 0, 0.33);
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---2 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 185px;
                    height: 33px;
                    color: #000000;
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
            .group---6 {
                position: absolute;
                top: 2px;
                left: 6px;
                width: 223px;
                height: 37px;
                .text-2024-10-31-1757 {
                    position: absolute;
                    top: 9px;
                    left: 99px;
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
                .line-4 {
                    position: absolute;
                    top: 10px;
                    left: 89px;
                    width: 15px;
                    height: 15px;
                }
                .hjw9265-1 {
                    position: absolute;
                    top: 9px;
                    left: 36px;
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
                .writer--1 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 41px;
                    height: 37px;
                    object-fit: cover;
                }
            }
            .rectangle---2 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                background: rgba(217, 217, 217, 0.32);
            }
        }
        .group--8 {
            position: absolute;
            top: 228px;
            left: 15px;
            width: 521px;
            height: 119px;
            .group---7 {
                position: absolute;
                top: 89px;
                left: 424px;
                width: 82px;
                height: 24px;
                .group--9 {
                    position: absolute;
                    top: 0px;
                    left: 51px;
                    width: 31px;
                    height: 24px;
                    .message-circle-2 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 24px;
                        height: 24px;
                    }
                    .text-5 {
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
                .group--10 {
                    position: absolute;
                    top: 5px;
                    left: 0px;
                    width: 39px;
                    height: 18px;
                    .text-23 {
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
                    .eye-2 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 20px;
                        height: 18px;
                    }
                }
            }
            .group---8 {
                position: absolute;
                top: 29px;
                left: 42px;
                width: 306px;
                height: 54px;
                .text----3 {
                    position: absolute;
                    top: 21px;
                    left: 0px;
                    width: 306px;
                    height: 33px;
                    color: rgba(0, 0, 0, 0.33);
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---3 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 185px;
                    height: 33px;
                    color: #000000;
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
            .group---9 {
                position: absolute;
                top: 2px;
                left: 6px;
                width: 223px;
                height: 37px;
                .text-2024-10-31-1758 {
                    position: absolute;
                    top: 9px;
                    left: 99px;
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
                .line-5 {
                    position: absolute;
                    top: 10px;
                    left: 89px;
                    width: 15px;
                    height: 15px;
                }
                .hjw9265-2 {
                    position: absolute;
                    top: 9px;
                    left: 36px;
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
                .writer--2 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 41px;
                    height: 37px;
                    object-fit: cover;
                }
            }
            .rectangle---3 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                background: rgba(217, 217, 217, 0.32);
            }
        }
        .group--11 {
            position: absolute;
            top: 228px;
            left: 539px;
            width: 521px;
            height: 119px;
            .group---10 {
                position: absolute;
                top: 89px;
                left: 424px;
                width: 82px;
                height: 24px;
                .group--12 {
                    position: absolute;
                    top: 0px;
                    left: 51px;
                    width: 31px;
                    height: 24px;
                    .message-circle-3 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 24px;
                        height: 24px;
                    }
                    .text-6 {
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
                .group--13 {
                    position: absolute;
                    top: 5px;
                    left: 0px;
                    width: 39px;
                    height: 18px;
                    .text-24 {
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
                    .eye-3 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 20px;
                        height: 18px;
                    }
                }
            }
            .group---11 {
                position: absolute;
                top: 29px;
                left: 42px;
                width: 306px;
                height: 54px;
                .text----4 {
                    position: absolute;
                    top: 21px;
                    left: 0px;
                    width: 306px;
                    height: 33px;
                    color: rgba(0, 0, 0, 0.33);
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---4 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 185px;
                    height: 33px;
                    color: #000000;
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
            .group---12 {
                position: absolute;
                top: 2px;
                left: 6px;
                width: 223px;
                height: 37px;
                .text-2024-10-31-1759 {
                    position: absolute;
                    top: 9px;
                    left: 99px;
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
                .line-6 {
                    position: absolute;
                    top: 10px;
                    left: 89px;
                    width: 15px;
                    height: 15px;
                }
                .hjw9265-3 {
                    position: absolute;
                    top: 9px;
                    left: 36px;
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
                .writer--3 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 41px;
                    height: 37px;
                    object-fit: cover;
                }
            }
            .rectangle---4 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                background: rgba(217, 217, 217, 0.32);
            }
        }
        .group--14 {
            position: absolute;
            top: 350px;
            left: 15px;
            width: 521px;
            height: 119px;
            .group---13 {
                position: absolute;
                top: 89px;
                left: 424px;
                width: 82px;
                height: 24px;
                .group--15 {
                    position: absolute;
                    top: 0px;
                    left: 51px;
                    width: 31px;
                    height: 24px;
                    .message-circle-4 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 24px;
                        height: 24px;
                    }
                    .text-7 {
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
                .group--16 {
                    position: absolute;
                    top: 5px;
                    left: 0px;
                    width: 39px;
                    height: 18px;
                    .text-25 {
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
                    .eye-4 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 20px;
                        height: 18px;
                    }
                }
            }
            .group---14 {
                position: absolute;
                top: 29px;
                left: 42px;
                width: 306px;
                height: 54px;
                .text----5 {
                    position: absolute;
                    top: 21px;
                    left: 0px;
                    width: 306px;
                    height: 33px;
                    color: rgba(0, 0, 0, 0.33);
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---5 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 185px;
                    height: 33px;
                    color: #000000;
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
            .group---15 {
                position: absolute;
                top: 2px;
                left: 6px;
                width: 223px;
                height: 37px;
                .text-2024-10-31-1760 {
                    position: absolute;
                    top: 9px;
                    left: 99px;
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
                .line-7 {
                    position: absolute;
                    top: 10px;
                    left: 89px;
                    width: 15px;
                    height: 15px;
                }
                .hjw9265-4 {
                    position: absolute;
                    top: 9px;
                    left: 36px;
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
                .writer--4 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 41px;
                    height: 37px;
                    object-fit: cover;
                }
            }
            .rectangle---5 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                background: rgba(217, 217, 217, 0.32);
            }
        }
        .group--17 {
            position: absolute;
            top: 350px;
            left: 539px;
            width: 521px;
            height: 119px;
            .group---16 {
                position: absolute;
                top: 89px;
                left: 424px;
                width: 82px;
                height: 24px;
                .group--18 {
                    position: absolute;
                    top: 0px;
                    left: 51px;
                    width: 31px;
                    height: 24px;
                    .message-circle-5 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 24px;
                        height: 24px;
                    }
                    .text-8 {
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
                .group--19 {
                    position: absolute;
                    top: 5px;
                    left: 0px;
                    width: 39px;
                    height: 18px;
                    .text-26 {
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
                    .eye-5 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 20px;
                        height: 18px;
                    }
                }
            }
            .group---17 {
                position: absolute;
                top: 29px;
                left: 42px;
                width: 306px;
                height: 54px;
                .text----6 {
                    position: absolute;
                    top: 21px;
                    left: 0px;
                    width: 306px;
                    height: 33px;
                    color: rgba(0, 0, 0, 0.33);
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---6 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 185px;
                    height: 33px;
                    color: #000000;
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
            .group---18 {
                position: absolute;
                top: 2px;
                left: 6px;
                width: 223px;
                height: 37px;
                .text-2024-10-31-1761 {
                    position: absolute;
                    top: 9px;
                    left: 99px;
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
                .line-8 {
                    position: absolute;
                    top: 10px;
                    left: 89px;
                    width: 15px;
                    height: 15px;
                }
                .hjw9265-5 {
                    position: absolute;
                    top: 9px;
                    left: 36px;
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
                .writer--5 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 41px;
                    height: 37px;
                    object-fit: cover;
                }
            }
            .rectangle---6 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                background: rgba(217, 217, 217, 0.32);
            }
        }
        .group--20 {
            position: absolute;
            top: 472px;
            left: 16px;
            width: 521px;
            height: 119px;
            .group---19 {
                position: absolute;
                top: 89px;
                left: 424px;
                width: 82px;
                height: 24px;
                .group--21 {
                    position: absolute;
                    top: 0px;
                    left: 51px;
                    width: 31px;
                    height: 24px;
                    .message-circle-6 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 24px;
                        height: 24px;
                    }
                    .text-9 {
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
                .group--22 {
                    position: absolute;
                    top: 5px;
                    left: 0px;
                    width: 39px;
                    height: 18px;
                    .text-27 {
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
                    .eye-6 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 20px;
                        height: 18px;
                    }
                }
            }
            .group---20 {
                position: absolute;
                top: 29px;
                left: 42px;
                width: 306px;
                height: 54px;
                .text----7 {
                    position: absolute;
                    top: 21px;
                    left: 0px;
                    width: 306px;
                    height: 33px;
                    color: rgba(0, 0, 0, 0.33);
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---7 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 185px;
                    height: 33px;
                    color: #000000;
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
            .group---21 {
                position: absolute;
                top: 2px;
                left: 6px;
                width: 223px;
                height: 37px;
                .text-2024-10-31-1762 {
                    position: absolute;
                    top: 9px;
                    left: 99px;
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
                .line-9 {
                    position: absolute;
                    top: 10px;
                    left: 89px;
                    width: 15px;
                    height: 15px;
                }
                .hjw9265-6 {
                    position: absolute;
                    top: 9px;
                    left: 36px;
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
                .writer--6 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 41px;
                    height: 37px;
                    object-fit: cover;
                }
            }
            .rectangle---7 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                background: rgba(217, 217, 217, 0.32);
            }
        }
        .group--23 {
            position: absolute;
            top: 472px;
            left: 540px;
            width: 521px;
            height: 119px;
            .group---22 {
                position: absolute;
                top: 89px;
                left: 424px;
                width: 82px;
                height: 24px;
                .group--24 {
                    position: absolute;
                    top: 0px;
                    left: 51px;
                    width: 31px;
                    height: 24px;
                    .message-circle-7 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 24px;
                        height: 24px;
                    }
                    .text-10 {
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
                .group--25 {
                    position: absolute;
                    top: 5px;
                    left: 0px;
                    width: 39px;
                    height: 18px;
                    .text-28 {
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
                    .eye-7 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 20px;
                        height: 18px;
                    }
                }
            }
            .group---23 {
                position: absolute;
                top: 29px;
                left: 42px;
                width: 306px;
                height: 54px;
                .text----8 {
                    position: absolute;
                    top: 21px;
                    left: 0px;
                    width: 306px;
                    height: 33px;
                    color: rgba(0, 0, 0, 0.33);
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---8 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 185px;
                    height: 33px;
                    color: #000000;
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
            .group---24 {
                position: absolute;
                top: 2px;
                left: 6px;
                width: 223px;
                height: 37px;
                .text-2024-10-31-1763 {
                    position: absolute;
                    top: 9px;
                    left: 99px;
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
                .line-10 {
                    position: absolute;
                    top: 10px;
                    left: 89px;
                    width: 15px;
                    height: 15px;
                }
                .hjw9265-7 {
                    position: absolute;
                    top: 9px;
                    left: 36px;
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
                .writer--7 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 41px;
                    height: 37px;
                    object-fit: cover;
                }
            }
            .rectangle---8 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                background: rgba(217, 217, 217, 0.32);
            }
        }
        .group--26 {
            position: absolute;
            top: 594px;
            left: 16px;
            width: 521px;
            height: 119px;
            .group---25 {
                position: absolute;
                top: 89px;
                left: 424px;
                width: 82px;
                height: 24px;
                .group--27 {
                    position: absolute;
                    top: 0px;
                    left: 51px;
                    width: 31px;
                    height: 24px;
                    .message-circle-8 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 24px;
                        height: 24px;
                    }
                    .text-11 {
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
                .group--28 {
                    position: absolute;
                    top: 5px;
                    left: 0px;
                    width: 39px;
                    height: 18px;
                    .text-29 {
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
                    .eye-8 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 20px;
                        height: 18px;
                    }
                }
            }
            .group---26 {
                position: absolute;
                top: 29px;
                left: 42px;
                width: 306px;
                height: 54px;
                .text----9 {
                    position: absolute;
                    top: 21px;
                    left: 0px;
                    width: 306px;
                    height: 33px;
                    color: rgba(0, 0, 0, 0.33);
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---9 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 185px;
                    height: 33px;
                    color: #000000;
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
            .group---27 {
                position: absolute;
                top: 2px;
                left: 6px;
                width: 223px;
                height: 37px;
                .text-2024-10-31-1764 {
                    position: absolute;
                    top: 9px;
                    left: 99px;
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
                .line-11 {
                    position: absolute;
                    top: 10px;
                    left: 89px;
                    width: 15px;
                    height: 15px;
                }
                .hjw9265-8 {
                    position: absolute;
                    top: 9px;
                    left: 36px;
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
                .writer--8 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 41px;
                    height: 37px;
                    object-fit: cover;
                }
            }
            .rectangle---9 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                background: rgba(217, 217, 217, 0.32);
            }
        }
        .group--29 {
            position: absolute;
            top: 594px;
            left: 540px;
            width: 521px;
            height: 119px;
            .group---28 {
                position: absolute;
                top: 89px;
                left: 424px;
                width: 82px;
                height: 24px;
                .group--30 {
                    position: absolute;
                    top: 0px;
                    left: 51px;
                    width: 31px;
                    height: 24px;
                    .message-circle-9 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 24px;
                        height: 24px;
                    }
                    .text-12 {
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
                .group--31 {
                    position: absolute;
                    top: 5px;
                    left: 0px;
                    width: 39px;
                    height: 18px;
                    .text-30 {
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
                    .eye-9 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 20px;
                        height: 18px;
                    }
                }
            }
            .group---29 {
                position: absolute;
                top: 29px;
                left: 42px;
                width: 306px;
                height: 54px;
                .text----10 {
                    position: absolute;
                    top: 21px;
                    left: 0px;
                    width: 306px;
                    height: 33px;
                    color: rgba(0, 0, 0, 0.33);
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
                .text---10 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 185px;
                    height: 33px;
                    color: #000000;
                    font-family: "Bebas Neue";
                    font-size: 16px;
                    line-height: 19px;
                    font-weight: 400;
                    display: flex;
                    align-items: center;
                }
            }
            .group---30 {
                position: absolute;
                top: 2px;
                left: 6px;
                width: 223px;
                height: 37px;
                .text-2024-10-31-1765 {
                    position: absolute;
                    top: 9px;
                    left: 99px;
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
                .line-12 {
                    position: absolute;
                    top: 10px;
                    left: 89px;
                    width: 15px;
                    height: 15px;
                }
                .hjw9265-9 {
                    position: absolute;
                    top: 9px;
                    left: 36px;
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
                .writer--9 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 41px;
                    height: 37px;
                    object-fit: cover;
                }
            }
            .rectangle---10 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 521px;
                height: 119px;
                background: rgba(217, 217, 217, 0.32);
            }
        }
        .text---11 {
            position: absolute;
            top: 13px;
            left: 12px;
            width: 112px;
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
        .group--bottom- {
            position: absolute;
            top: 758px;
            left: 437px;
            width: 198px;
            height: 25px;
            .text-1-2-3-4-5-6-7 {
                position: absolute;
                top: 3px;
                left: 34px;
                width: 133px;
                height: 19px;
                white-space: nowrap;
                color: #000000;
                font-family: "Inter";
                font-size: 16px;
                line-height: 19px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
            .material-symbolsarrow-back-2-outline-rounded {
                position: absolute;
                top: 1px;
                left: 0px;
                width: 24px;
                height: 24px;
            }
            .material-symbolsarrow-back-2-outline-rounded-1 {
                position: absolute;
                top: 0px;
                left: 174px;
                width: 24px;
                height: 24px;
            }
        }
    }
    .asideframe {
        position: absolute;
        top: 208px;
        left: 17px;
        width: 313px;
        height: 792px;
        overflow: hidden;
        .group--sidebar {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 313px;
            height: 792px;
            .sidebar {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 313px;
                height: 792px;
                border-radius: 15px;
                background: #FAFAFA;
            }
            .group--sidebar-1 {
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
                        .text---12 {
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
                        .text---13 {
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
                    .text----11 {
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
                    .text----12 {
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
                    .text---14 {
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
                    .text---15 {
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
        .group--sidebar-2 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 313px;
            height: 792px;
            .sidebar-1 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 313px;
                height: 792px;
                border-radius: 15px;
                background: #FAFAFA;
            }
            .group--sidebar-3 {
                position: absolute;
                top: 13px;
                left: 5px;
                width: 303px;
                height: 411px;
                .hot-1 {
                    position: absolute;
                    top: 57px;
                    left: 9px;
                    width: 220px;
                    height: 140px;
                    .group-8 {
                        position: absolute;
                        top: 22px;
                        left: 21px;
                        width: 199px;
                        height: 34px;
                        .text-----2 {
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
                        .text--7 {
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
                        .clip-7 {
                            position: absolute;
                            top: 17.65%;
                            left: 0%;
                            right: 94.97%;
                            bottom: 38.24%;
                            width: calc(100% - 0% - 94.97%);
                            height: calc(100% - 17.65% - 38.24%);
                        }
                    }
                    .group-9 {
                        position: absolute;
                        top: 64px;
                        left: 21px;
                        width: 99px;
                        height: 34px;
                        .text---16 {
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
                        .text--8 {
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
                        .clip-8 {
                            position: absolute;
                            top: 17.65%;
                            left: 0%;
                            right: 89.9%;
                            bottom: 38.24%;
                            width: calc(100% - 0% - 89.9%);
                            height: calc(100% - 17.65% - 38.24%);
                        }
                    }
                    .group-11 {
                        position: absolute;
                        top: 106px;
                        left: 21px;
                        width: 107px;
                        height: 34px;
                        .text---17 {
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
                        .text--9 {
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
                        .clip-9 {
                            position: absolute;
                            top: 17.65%;
                            left: 0%;
                            right: 90.65%;
                            bottom: 38.24%;
                            width: calc(100% - 0% - 90.65%);
                            height: calc(100% - 17.65% - 38.24%);
                        }
                    }
                    .hot--2 {
                        position: absolute;
                        top: 0px;
                        left: 0px;
                        width: 106px;
                        height: 22px;
                        .fluent-emoji-flatfire-1 {
                            position: absolute;
                            top: 2px;
                            left: 0px;
                            width: 16px;
                            height: 16px;
                        }
                        .hot--3 {
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
                .group-13 {
                    position: absolute;
                    top: 233px;
                    left: 12px;
                    width: 95px;
                    height: 34px;
                    .text----13 {
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
                    .text--10 {
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
                    .clip-10 {
                        position: absolute;
                        top: 17.65%;
                        left: 0%;
                        right: 89.47%;
                        bottom: 38.24%;
                        width: calc(100% - 0% - 89.47%);
                        height: calc(100% - 17.65% - 38.24%);
                    }
                }
                .group-14 {
                    position: absolute;
                    top: 281px;
                    left: 12px;
                    width: 122px;
                    height: 34px;
                    .text----14 {
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
                    .text--11 {
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
                    .clip-11 {
                        position: absolute;
                        top: 17.65%;
                        left: 0%;
                        right: 91.8%;
                        bottom: 38.24%;
                        width: calc(100% - 0% - 91.8%);
                        height: calc(100% - 17.65% - 38.24%);
                    }
                }
                .group-15 {
                    position: absolute;
                    top: 329px;
                    left: 12px;
                    width: 95px;
                    height: 34px;
                    .text---18 {
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
                    .text--12 {
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
                    .clip-12 {
                        position: absolute;
                        top: 17.65%;
                        left: 0%;
                        right: 89.47%;
                        bottom: 38.24%;
                        width: calc(100% - 0% - 89.47%);
                        height: calc(100% - 17.65% - 38.24%);
                    }
                }
                .group-18 {
                    position: absolute;
                    top: 377px;
                    left: 12px;
                    width: 117px;
                    height: 34px;
                    .text-----3 {
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
                    .text---19 {
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
                    .clip-13 {
                        position: absolute;
                        top: 17.65%;
                        left: 0%;
                        right: 91.45%;
                        bottom: 38.24%;
                        width: calc(100% - 0% - 91.45%);
                        height: calc(100% - 17.65% - 38.24%);
                    }
                }
                .line-13 {
                    position: absolute;
                    top: 215px;
                    left: 0px;
                    width: 303px;
                    border: 1px solid rgba(0, 0, 0, 0.17);
                }
                .line-14 {
                    position: absolute;
                    top: 38px;
                    left: 0px;
                    width: 303px;
                    border: 1px solid rgba(0, 0, 0, 0.42);
                }
                .text--13 {
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
        .group---31 {
            position: absolute;
            top: 4px;
            left: 223px;
            width: 86px;
            height: 42px;
            .rectangle--1 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 86px;
                height: 42px;
                border-radius: 12px;
                background: #E2495B;
            }
            .text---20 {
                position: absolute;
                top: 14px;
                left: 13.07px;
                width: 62.16px;
                height: 16.63px;
                color: #FFFFFF;
                font-family: "Bebas Neue";
                font-size: 13px;
                line-height: 16px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
        }
    }
}
</style>


<script>
    
    import CommunityDefault from '@/components/CommunityDefault.vue';
    import CommunityDetail from './CommunityDetail.vue';
    import CommunityRegist from './CommunityRegist.vue';
    

    export default {

        name: 'Community',  // 컴포넌트 이름
        components : {
            CommunityDefault,
            CommunityDetail,
            CommunityRegist,
        },
        data() {
            return {
            // 디폴트로 보여지는 컴포넌트
            currentComponent: 'CommunityDefault', 
            };
        },
        methods: {
            changeComponent(componentName) {
              this.currentComponent = componentName; // 동적으로 컴포넌트를 변경
            },
        }
    }

</script>