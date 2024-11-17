<template>
    <div class="header">
        <router-link to="/main">
            <div class="tong">
                TONG
            </div>
        </router-link>    

        <!-- 로그인 버튼을 router-link로 감싸서 로그인 페이지로 이동 -->
    <router-link to="/signIn" class="login">
      <svg id="12:2570" class="mdiuser-outline"></svg>
      <div class="login-1">LOGIN</div>
    </router-link>

        <div class="menu">
            <div class="rectangle-38">
            </div>
            <div class="frame-20">

                <div class="community">
                    <div class="rectangle-37">
                    </div>
                    <div class="rectangle-39">
                    </div>
                    <div class="rectangle-40">
                    </div>
                    <router-link to="/community" class="community">
                        <div class="community-1">
                            Community
                        </div>
                    </router-link>
                        <svg id="12:2587" class="fluentpeople-community-32-light"></svg>
                    </div>
                    <div class="chat">
                    <div class="rectangle-41">
                    </div>
                    <div class="rectangle-42">
                    </div>
                    <div class="rectangle-43">
                    </div>
                    <router-link to="/chatList" class="chagList">
                        <div class="chat-1">
                            Chat
                        </div>
                    </router-link>
                    <svg id="12:2614" class="fluentchat-32-light"></svg>
                </div>
                <div class="calender">
                    <div class="rectangle-44">
                    </div>
                    <div class="rectangle-45">
                    </div>
                    <div class="rectangle-46">
                    </div>
                    <router-link to="/calendar" >
                        <div class="calendar">
                            Calendar
                        </div>
                    </router-link>
                    <svg id="12:2573" class="uitcalender"></svg>
                </div>
                <div class="match">
                    <div class="rectangle-47">
                    </div>
                    <div class="rectangle-48">
                    </div>
                    <div class="rectangle-49">
                    </div>
                    <router-link to="/matching" >
                        <div class="matching">
                            Matching
                        </div>
                    </router-link>
                    <svg id="12:2617" class="arcticonslitmatch"></svg>
                </div>
            </div>
        </div>
    
    </div>
</template>

<style lang="scss">
.header {
    position: fixed; /* absolute에서 fixed로 변경 */
    top: 0;
    left: 0;
    width: 100%;
    height: 10vh;
    background: #fff; /* 배경색 추가 */
    z-index: 1000; /* 다른 요소들 위에 표시되도록 */
    .tong {
        position: absolute;
        top: 4px;
        left: 83px;
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
        cursor: pointer;
        transition: transform 0.3s ease;

        &:hover {
            transform: scale(1.05);
        }
    }
    .login {
        position: absolute;
        top: 31px;
        left: 90%;
        width: 155px;
        height: 42px;
        border-radius: 10px;
        overflow: hidden;
        background: #DC606F;


        &:hover {
            background: #E2495B;
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        
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
    /* menu 부분의 position 설정 수정 */
    .menu {
        position: absolute; /* relative에서 absolute로 변경 */
        right: 200px; /* left 값 대신 right 값으로 변경 */
        top: 0;
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
        .frame-20 {
            position: absolute;
            top: 30px;
            left: 13px;
            width: 585px;
            height: 43px;
            overflow: hidden;
            .community {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 165px;
                height: 43px;
                overflow: hidden;
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
                overflow: hidden;
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
                .rectangle-43 {
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
                .fluentchat-32-light {
                    position: absolute;
                    top: 9px;
                    left: 14px;
                    width: 23px;
                    height: 23px;
                }
            }
            .calender {
                position: absolute;
                top: 0px;
                left: 277px;
                width: 165px;
                height: 43px;
                overflow: hidden;
                .rectangle-44 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 165px;
                    height: 43px;
                    border-radius: 140px;
                    background: rgba(226, 73, 91, 0.8);
                }
                .rectangle-45 {
                    position: absolute;
                    top: calc(100% - 43px + 5px);
                    left: calc(100% - 165px + 5px);
                    width: 154px;
                    height: 33px;
                    border-radius: 140px;
                    background: rgba(255, 255, 255, 0.8);
                }
                .rectangle-46 {
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
                .uitcalender {
                    position: absolute;
                    top: 9px;
                    left: 13px;
                    width: 24px;
                    height: 24px;
                }
            }
            .match {
                position: absolute;
                top: 0px;
                left: 420px;
                width: 165px;
                height: 43px;
                overflow: hidden;
                .rectangle-47 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 165px;
                    height: 43px;
                    border-radius: 140px;
                    background: rgba(226, 73, 91, 0.8);
                }
                .rectangle-48 {
                    position: absolute;
                    top: calc(100% - 43px + 5px);
                    left: calc(100% - 165px + 5px);
                    width: 154px;
                    height: 33px;
                    border-radius: 140px;
                    background: rgba(255, 255, 255, 0.8);
                }
                .rectangle-49 {
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
                .arcticonslitmatch {
                    position: absolute;
                    top: 9px;
                    left: 14px;
                    width: 24px;
                    height: 24px;
                }
            }
        }
    }
}
</style>

<script></script>