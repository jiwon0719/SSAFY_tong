<template>
    <div class="chatlist">
        <div class="text--">
            채팅 리스트
        </div>
        <router-link to="/chattingRoom">

            <div class="pt1-1">
                <div class="rectangle---1">
                </div>
                <div class="text---1">
                    김혜준 트레이너
                </div>
                <div class="text----">
                    지원님~ 오늘 운동은 잘하셨나요??
                </div>
                <svg id="0:2520" class="pen-"></svg>
            </div>
        </router-link>
        <router-link to="/chattingRoom">
            <div class="pt1-2" >
                <div class="rectangle---2">
                </div>
                <div class="text---2">
                    유승호 선생님
                </div>
                <div class="text---3">
                    매칭이 수락되었습니다.
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d56daf0628fcabb2304963bb911f09d1.jpg" class="rectangle-" />
            </div>
        </router-link>
    </div>
</template>

<style lang='scss'>
.chatlist {
    width: 1083px;
    height: 792px;
    overflow: hidden;
    .text-- {
        position: absolute;
        top: 13px;
        left: 20px;
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
    .pt1 {
        position: absolute;
        top: 43px;
        left: 4px;
        width: 1054px;
        height: 96px;
        overflow: hidden;
        .rectangle-- {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 1054px;
            height: 96px;
            border-radius: 5px;
            background: rgba(217, 217, 217, 0.32);
        }
        .text- {
            position: absolute;
            top: 21px;
            left: 105.93px;
            width: 117.07px;
            height: 27px;
            color: #000000;
            font-family: "Inter";
            font-size: 16px;
            line-height: 19px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
        .text--- {
            position: absolute;
            top: 47px;
            left: 106px;
            width: 519px;
            height: 27px;
            color: #877F7F;
            font-family: "Inter";
            font-size: 16px;
            line-height: 19px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
        .pen-3dicons {
            position: absolute;
            top: 14px;
            left: 18px;
            width: 68px;
            height: 67px;
        }
    }
    .pt1-1 {
        position: absolute;
        top: 148px;
        left: 3px;
        width: 1054px;
        height: 96px;
        overflow: hidden;
        .rectangle---1 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 1054px;
            height: 96px;
            border-radius: 5px;
            background: rgba(217, 217, 217, 0.32);
        }
        .text---1 {
            position: absolute;
            top: 21px;
            left: 105.93px;
            width: 117.07px;
            height: 27px;
            color: #000000;
            font-family: "Inter";
            font-size: 16px;
            line-height: 19px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
        .text---- {
            position: absolute;
            top: 47px;
            left: 106px;
            width: 519px;
            height: 27px;
            color: #877F7F;
            font-family: "Inter";
            font-size: 16px;
            line-height: 19px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
        .pen- {
            position: absolute;
            top: 15px;
            left: 19px;
            width: 68px;
            height: 67px;
        }
    }
    .pt1-2 {
        position: absolute;
        top: 253px;
        left: 3px;
        width: 1054px;
        height: 96px;
        overflow: hidden;
        .rectangle---2 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 1054px;
            height: 96px;
            border-radius: 5px;
            background: rgba(217, 217, 217, 0.32);
        }
        .text---2 {
            position: absolute;
            top: 21px;
            left: 105.93px;
            width: 117.07px;
            height: 27px;
            color: #000000;
            font-family: "Inter";
            font-size: 16px;
            line-height: 19px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
        .text---3 {
            position: absolute;
            top: 47px;
            left: 106px;
            width: 519px;
            height: 27px;
            color: #877F7F;
            font-family: "Inter";
            font-size: 16px;
            line-height: 19px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
        .rectangle- {
            position: absolute;
            top: 16px;
            left: 19px;
            width: 68px;
            height: 66px;
            border-radius: 80px;
            object-fit: cover;
        }
    }
}
</style>

<script>
export default {
  name: 'ChatList',
  emits: ['changeComponent'],  // changeComponent 이벤트 선언
  methods: {
    goToChattingRoom() {
      this.$emit('change-component', 'ChattingRoom');
    },
  },
};





</script>