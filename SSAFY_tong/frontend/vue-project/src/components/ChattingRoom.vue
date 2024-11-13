<template>
    <div class="chattingroom">
        <div class="text--">채팅 리스트</div>
        
        <!-- 채팅 내용 전체 영역 -->
        <div class="pt1">
            <div class="rectangle--">
                
                <!-- 발신자 메시지 (통통이) -->
                <div class="message-container sender">
                    <div class="message-bubble">
                        안녕 나는 통통이!! 힘들땐 언제든 연락해
                    </div>
                </div>

                <!-- 수신자 메시지 (지원이) -->
                <div class="message-container receiver">
                    <div class="message-bubble">
                        안녕 반가웡 나는 지원이야
                    </div>
                </div>

                <!-- 발신자 추가 메시지 -->
                <div class="message-container sender">
                    <div class="message-bubble">
                        오늘 하루는 어땠어?
                    </div>
                </div>
            </div>
        </div>

        <!-- 입력창 영역 -->
        <div class="rectangle-35"></div>
        <div class="frame--3">
            <div class="rectangle-"></div>
            <div class="text--1">전송</div>
        </div>
    </div>
</template>


<style lang="scss">
.chattingroom {
    width: 1083px;
    height: 792px;
    overflow: hidden;

    .text-- {
        position: absolute;
        top: 10.5px;
        left: 20px;
        width: 112px;
        height: 34px;
        color: #000000;
        font-family: "Jockey One";
        font-size: 24px;
        line-height: 34px;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .pt1 {
        position: absolute;
        top: 44px;
        left: 6px;
        width: 1054px;
        height: 741px;
        overflow-y: auto;
        
        .rectangle-- {
            position: relative;
            width: 100%;
            height: auto;
            border-radius: 5px;
            background: rgba(217, 217, 217, 0.32);
            padding: 20px;
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .message-container {
            display: flex;
            align-items: flex-end;
            max-width: 80%;
            
            &.sender {
                justify-content: flex-start;
            }

            &.receiver {
                justify-content: flex-end;
            }
        }

        .message-bubble {
            padding: 10px 15px;
            border-radius: 15px;
            background: #d9d9d9;
            color: #000000;
            font-family: "Jockey One";
            font-size: 16px;
            line-height: 22px;
            word-break: break-word;
            max-width: 100%;
        }

        .sender .message-bubble {
            background-color: #f1f1f1;
        }

        .receiver .message-bubble {
            background-color: #e2495b;
            color: #ffffff;
        }
    }

    .rectangle-35 {
        position: absolute;
        top: 697px;
        left: 31px;
        width: 861px;
        height: 67px;
        border-radius: 5px;
        background: #f1f1f1;
    }

    .frame--3 {
        position: absolute;
        top: 703px;
        left: 919px;
        width: 101px;
        height: 48px;
        
        .rectangle- {
            width: 100%;
            height: 100%;
            border-radius: 12px;
            background: #e2495b;
        }

        .text--1 {
            position: absolute;
            top: 14.5px;
            left: 36px;
            color: #ffffff;
            font-family: "Jockey One";
            font-size: 16px;
            display: flex;
            align-items: center;
        }
    }
}

</style>

<script></script>