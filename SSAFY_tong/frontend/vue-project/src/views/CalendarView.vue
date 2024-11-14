<template>
  <div class="frame-">
    <div class="calendarframe">
      <router-view></router-view>
    </div>
  </div>
</template>

<style lang="scss">
.frame- {
  position: relative;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center; /* 수평 중앙 정렬 */
  align-items: center; /* 수직 중앙 정렬 */
  background: #FFFFFF;
}

.calendarframe {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 1057px;
  height: 871px;
  border-radius: 20px;
  overflow: hidden;
  transform: translate(-50%, -50%); /* 화면 중앙으로 이동 */
      flex-grow: 1;
      .text-2024-sep {
          position: absolute;
          top: 24px;
          left: 304px;
          width: 157px;
          height: 64px;
          white-space: nowrap;
          color: #000000;
          font-family: "Bebas Neue";
          font-size: 53px;
          line-height: 64px;
          font-weight: 400;
          display: flex;
          align-items: center;
          justify-content: center;
          text-align: center;
      }
      .caldendar-frame {
          position: absolute;
          top: 134px;
          left: 24px;
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
          .rectangle-51 {
              position: absolute;
              top: 0px;
              left: 0px;
              width: 521px;
              height: 119px;
              border-radius: 10px;
              border: 1px solid #0015FF;
          }
      }
      .frame--2 {
          position: absolute;
          top: 352px;
          left: 851px;
          width: 521px;
          height: 119px;
          overflow: hidden;
          .rectangle---1 {
              position: absolute;
              top: 0px;
              left: 0px;
              width: 521px;
              height: 119px;
              border-radius: 12px;
              background: rgba(255, 255, 255, 0.55);
          }
          .group---2 {
              position: absolute;
              top: 12px;
              left: 7px;
              width: 414px;
              height: 84px;
              .group---3 {
                  position: absolute;
                  top: 1px;
                  left: 35px;
                  width: 379px;
                  height: 83px;
                  .text-2024-10-31-1757 {
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
                  .quest1-1 {
                      position: absolute;
                      top: 31px;
                      left: 8px;
                      width: 371px;
                      height: 52px;
                      overflow: hidden;
                      .carboncheckbox-1 {
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
              .frame-11 {
                  position: absolute;
                  top: 0px;
                  left: 0px;
                  width: 30px;
                  height: 30px;
                  border-radius: 30px;
                  object-fit: cover;
              }
          }
          .rectangle-52 {
              position: absolute;
              top: 0px;
              left: 0px;
              width: 521px;
              height: 119px;
              border-radius: 10px;
              border: 1px solid #FF0000;
          }
      }
      .rectangle-53 {
          position: absolute;
          top: 199px;
          left: 851px;
          width: 521px;
          height: 119px;
          border-radius: 10px;
          border: 1px solid #0015FF;
      }
      .frame--3 {
          position: absolute;
          top: calc(100% - 813px + 633px);
          left: calc(100% - 1389px + 1188px);
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
</style>

<script>
</script>