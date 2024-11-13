<template>
  <div class="registframe">
      <div class="frame-">
          <div class="rectangle-">
          </div>
          <div class="text-">
              등록
          </div>
      </div>
      <div class="frame--1" @click="goToDefault">
          <div class="rectangle--1">
          </div>
          <div class="text--1">
              목록으로
          </div>
      </div>
      <div class="frame--2">
          <div class="rectangle--">
          </div>
      </div>
      <div class="text--">
          게시판 등록
      </div>
      <div class="frame--3">
          <div class="text--2">
              작성자
          </div>
          <div class="rectangle--2">
          </div>
          <div class="hjw9265">
              hjw9265
          </div>
      </div>
      <div class="frame--4">
          <div class="text---1">
              설명
          </div>
          <div class="rectangle--3">
          </div>
          <div class="text----">
              게시판에 대해 간략히 설명해주세요.
          </div>
      </div>
      <div class="frame--5">
          <div class="text--3">
              카테고리
          </div>
          <div class="rectangle--4">
          </div>
          <div class="text---2">
              자유 게시판
          </div>
      </div>
  </div>
</template>



<style lang="scss">
  .registframe {
    width: 1083px;
    height: 792px;
    overflow: hidden;
    .frame- {
        position: absolute;
        top: 43px;
        left: 958px;
        width: 101px;
        height: 48px;
        overflow: hidden;
        .rectangle- {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 101px;
            height: 48px;
            border-radius: 12px;
            background: #E2495B;
        }
        .text- {
            position: absolute;
            top: 16px;
            left: 35px;
            width: 29px;
            height: 19px;
            white-space: nowrap;
            color: #FFFFFF;
            font-family: "Jockey One";
            font-size: 16px;
            line-height: 22px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
    }
    .frame--1 {
        position: absolute;
        top: 43px;
        left: 838px;
        width: 101px;
        height: 48px;
        overflow: hidden;
        .rectangle--1 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 101px;
            height: 48px;
            border-radius: 12px;
            background: #E2495B;
        }
        .text--1 {
            position: absolute;
            top: 16px;
            left: 22px;
            width: 57px;
            height: 19px;
            white-space: nowrap;
            color: #FFFFFF;
            font-family: "Jockey One";
            font-size: 16px;
            line-height: 22px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
    }
    .frame--2 {
        position: absolute;
        top: 106px;
        left: 3px;
        width: 1042px;
        height: 404px;
        overflow: hidden;
        .rectangle-- {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 1042px;
            height: 404px;
            background: rgba(217, 217, 217, 0.32);
        }
    }
    .text-- {
        position: absolute;
        top: 13px;
        left: 20px;
        width: 112px;
        height: 29px;
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
    .frame--3 {
        position: absolute;
        top: 181px;
        left: 19px;
        width: 482px;
        height: 34px;
        overflow: hidden;
        .text--2 {
            position: absolute;
            top: 9px;
            left: 0px;
            width: 43px;
            height: 19px;
            white-space: nowrap;
            color: #000000;
            font-family: "Jockey One";
            font-size: 16px;
            line-height: 22px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
        .rectangle--2 {
            position: absolute;
            top: 0px;
            left: 64px;
            width: 418px;
            height: 34px;
            border-radius: 12px;
            background: #D9D9D9;
        }
        .hjw9265 {
            position: absolute;
            top: 7px;
            left: 81px;
            width: 47px;
            height: 22px;
            white-space: nowrap;
            color: rgba(0, 0, 0, 0.43);
            font-family: "Jockey One";
            font-size: 16px;
            line-height: 22px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
    }
    .frame--4 {
        position: absolute;
        top: 238px;
        left: 19px;
        width: 991px;
        height: 196px;
        overflow: hidden;
        .text---1 {
            position: absolute;
            top: 5px;
            left: 0px;
            width: 43px;
            height: 44px;
            white-space: nowrap;
            color: #000000;
            font-family: "Jockey One";
            font-size: 16px;
            line-height: 22px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
        .rectangle--3 {
            position: absolute;
            top: 0px;
            left: 64px;
            width: 927px;
            height: 196px;
            border-radius: 12px;
            background: #D9D9D9;
        }
        .text---- {
            position: absolute;
            top: 16.5px;
            left: 81px;
            width: 221px;
            height: 22px;
            white-space: nowrap;
            color: rgba(0, 0, 0, 0.43);
            font-family: "Jockey One";
            font-size: 16px;
            line-height: 22px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
    }
    .frame--5 {
        position: absolute;
        top: 128px;
        left: 19px;
        width: 482px;
        height: 34px;
        overflow: hidden;
        .text--3 {
            position: absolute;
            top: 9px;
            left: 0px;
            width: 57px;
            height: 19px;
            white-space: nowrap;
            color: #000000;
            font-family: "Jockey One";
            font-size: 16px;
            line-height: 22px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
        .rectangle--4 {
            position: absolute;
            top: 0px;
            left: 64px;
            width: 418px;
            height: 34px;
            border-radius: 12px;
            background: #D9D9D9;
        }
        .text---2 {
            position: absolute;
            top: 7.5px;
            left: 81px;
            width: 73px;
            height: 22px;
            white-space: nowrap;
            color: rgba(0, 0, 0, 0.43);
            font-family: "Jockey One";
            font-size: 16px;
            line-height: 22px;
            font-weight: 400;
            display: flex;
            align-items: center;
        }
    }
}
</style>

<script>
    export default {
        props: {
            isComponentRegist: Boolean, // 부모로부터 받은 isComponentRegist 값
        },
        name: 'CommunityRegist',
        emits: ['changeComponent'],  // changeComponent 이벤트 선언
        methods: {
            goToDefault() {
            // 부모 컴포넌트의 changeComponent 메서드를 호출하여 컴포넌트 전환
            this.$emit('change-component', 'CommunityDefault');
            
            // 또한, 부모에게 isComponentRegist를 false로 설정하라고 알리기 위해 별도의 이벤트를 전달
            this.$emit('set-is-component-regist', false);

            },
  },
    }
</script>

