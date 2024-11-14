<template>
    <div class="signup">
        <div class="rectangle-21">
        </div>
        <div class="frame-2">
            <div class="rectangle-22">
            </div>
            <router-link to="/main">
                <div class="tong">
                    TONG
                </div>
            </router-link>
            <div class="frame-3">
                <div class="text-">
                    아이디
                </div>
                <div class="id">
                </div>
                <div class="text--1">
                    비밀번호
                </div>
                <div class="password">
                </div>
                <div class="login-btn">
                </div>
                <div class="text--2">
                    로그인
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/c131a7373ebf8184425abc238dab0d0b.png" class="kakao-login-large-narrow-1" />
            </div>
            <div class="frame-5">
                <div class="group-104">
                    <router-link to="/signUp">
                            <div class="text--3">
                                회원가입
                            </div>
                    </router-link>
                    <div class="text--with-kakao">
                        회원가입 with KAKAO
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>


<style lang="scss">
    .signup {
        background-image: url('../assets/images/background.png'); /* 실제 이미지 경로를 넣어주세요 */
  background-size: cover;   /* 배경 이미지를 컨테이너 크기에 맞게 조정 */
  background-position: center; /* 배경 이미지가 중앙에 위치하도록 설정 */
  background-repeat: no-repeat; /* 배경 이미지 반복 방지 */


    position: relative;
    top: 0px;
    left: 0px;
    width: 100%;
    height: 100vh;
    box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
    overflow: hidden;
    .rectangle-21 {
        position: absolute;
        top: 0px;
        left: 0px;
        width: 100%;
        height: 100vh;
        background: linear-gradient(180deg, rgba(47, 47, 47, 0.8) 0%, rgba(78, 78, 78, 0.8) 50%, rgba(149, 149, 149, 0.8) 100%);
    }
    .group {
        position: absolute;
        top: 1.37%;
        left: 0.69%;
        right: -0.14%;
        bottom: 5.47%;
    }
    .group-52 {
        position: absolute;
        top: 1.37%;
        left: 0.69%;
        right: -0.14%;
        bottom: 5.47%;
    }
    .frame-2 {
        position: absolute;
        top: 50%;
        left: 50%;
        width: 807px;
        height: 871px;
        border-radius: 20px;
        overflow: hidden;
        transform: translate(-50%, -50%);  /* 화면 중앙으로 이동 */
        .rectangle-22 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 100%;
            height: 100vh;
            background: linear-gradient(180deg, rgba(197, 197, 197, 0.21) 0%, rgba(197, 197, 197, 0.21) 6%, rgba(113, 113, 113, 0.21) 46%, rgba(95, 95, 95, 0.21) 100%);
        }
        .tong {
            z-index: 2;
            position: absolute;
            top: 12px;
            left: 309.5px;
            width: 190px;
            height: 134px;
            color: #E2495B;
            white-space: nowrap;
            font-family: "Jockey One";
            font-size: 96px;
            line-height: 134px;
            font-weight: 400;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }
        .frame-3 {
            z-index: 1;
            position: absolute;
            top: 121px;
            left: 71px;
            width: 676px;
            height: 558px;
            border-radius: 10px;
            overflow: hidden;
            .id {
                position: absolute;
                top: 85px;
                left: calc(100% - 676px + 106px);
                width: 463px;
                height: 79px;
                border-radius: 10px;
                border: 3px solid #FFFFFF;
            }
            .text- {
                position: absolute;
                top: 58px;
                left: 106px;
                width: 45px;
                height: 22px;
                color: #FFFFFF;
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
            .text--1 {
                position: absolute;
                top: 190px;
                left: 106px;
                width: 57px;
                height: 22px;
                color: #FFFFFF;
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
            .password {
                position: absolute;
                top: 221px;
                left: 106px;
                width: 463px;
                height: 79px;
                box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
                border-radius: 10px;
                border: 3px solid #FFFFFF;
            }
            .login-btn {
                position: absolute;
                top: 325px;
                left: calc(100% - 676px + 107px);
                width: 463px;
                height: 79px;
                box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
                border-radius: 10px;
                background: rgba(226, 73, 91, 0.9);
                border: 1px solid rgba(226, 73, 91, 0);
            }
            .text--2 {
                position: absolute;
                top: 340px;
                left: calc(100% - 676px + 289px);
                width: 99px;
                height: 50px;
                color: #FFFFFF;
                white-space: nowrap;
                font-family: "Jockey One";
                font-size: 36px;
                line-height: 50px;
                font-weight: 400;
                display: flex;
                align-items: center;
                justify-content: center;
                text-align: center;
            }
            .kakao-login-large-narrow-1 {
                position: absolute;
                top: 418px;
                left: 107px;
                width: 463px;
                height: 76px;
                border-radius: 10px;
                object-fit: cover;
            }
        }
        .frame-5 {
            position: absolute;
            left: calc(100% - 807px + 101px);
            bottom: 85px;
            width: 606px;
            height: 82px;
            overflow: hidden;
            .group-104 {
                position: absolute;
                top: 30px;
                left: 195px;
                width: 264px;
                height: 22px;
                .text--3 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 57px;
                    height: 22px;
                    color: #FFFFFF;
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
                .text--4 {
                    position: absolute;
                    top: 0px;
                    left: 0px;
                    width: 57px;
                    height: 22px;
                    color: #FFFFFF;
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
                .text--with-kakao {
                    position: absolute;
                    top: 0px;
                    left: 142px;
                    width: 122px;
                    height: 22px;
                    color: #FFFFFF;
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
}
</style>

<script>
</script>