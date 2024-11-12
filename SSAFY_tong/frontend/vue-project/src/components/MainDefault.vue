<template>
    <div class="mainframe">
        <div class="weather">
            <div class="text-">
                날씨
            </div>
        </div>
        <div class="booking">
            <div class="text--">
                예약 내역
            </div>
            <div class="booking-board">
                <div class="group-">
                    <div class="rectangle--">
                    </div>
                    <div class="group--">
                        <div class="group---1">
                            <div class="group--1">
                                <svg id="0:5629" class="message-circle"></svg>
                                <div class="text-3">
                                    3
                                </div>
                            </div>
                            <div class="group--2">
                                <div class="text-21">
                                    21
                                </div>
                                <svg id="0:5634" class="eye"></svg>
                            </div>
                        </div>
                        <div class="group---2">
                            <div class="text-2024-10-31-1756">
                                2024. 10. 31. 17:56
                            </div>
                            <div class="tr-daniel">
                                Tr. Daniel
                            </div>
                            <div class="quest1">
                                <svg id="0:5641" class="carboncheckbox"></svg>
                                <div class="text---1630">
                                    예약시간 : 16:30
                                </div>
                                <div class="text">
                                </div>
                            </div>
                        </div>
                        <div class="frame-10">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="hotboard">
            <div class="booking-board-1">
                <div class="hot">
                    <div class="group-1">
                        <div class="text----">
                            보디빌딩, 웨이트등 운동좋아하시는분들 오세용
                        </div>
                        <div class="text--1">
                            헬스방
                        </div>
                        <svg id="0:5656" class="clip"></svg>
                    </div>
                    <div class="group-2">
                        <div class="text---1">
                            아무말 대잔치
                        </div>
                        <div class="text--2">
                            자유게시판
                        </div>
                        <svg id="0:5661" class="clip-1"></svg>
                    </div>
                    <div class="group-3">
                        <div class="text---2">
                            운동하면서 친해지실분
                        </div>
                        <div class="text--3">
                            친구만들기
                        </div>
                        <svg id="0:5666" class="clip-2"></svg>
                    </div>
                </div>
            </div>
            <div class="hot-">
                <svg id="0:5669" class="fluent-emoji-flatfire"></svg>
                <div class="hot--1">
                    HOT 게시판
                </div>
            </div>
        </div>
        <div class="extra">
        </div>
    </div>
</template>

<style lang="scss">
    .mainframe {
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
</style>

<script></script>