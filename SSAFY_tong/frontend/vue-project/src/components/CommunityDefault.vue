<template>
        <div class="group--">
            <div class="rectangle-">
            </div>
            <div class="text--">
                게시물 작성
            </div>
        </div>
        <div class="group-10">
            <div class="rectangle--">
            </div>
            <div class="text-10-">
                10개씩 보기
            </div>
            <svg id="0:526" class="material-symbolsarrow-drop-down-rounded"></svg>
        </div>
        
        <!-- <div class="group-">
            <div class="group---1">
                <div class="group--1">
                    <svg id="0:531" class="message-circle"></svg>
                    <div class="text-3">
                        3
                    </div>
                </div>
                <div class="group--2">
                    <div class="text-21">
                        21
                    </div>
                    <svg id="0:538" class="eye"></svg>
                </div>
            </div>
            <div class="group---2">
                <div class="text---">
                    주말에 열심히 해올게...
                </div>
                <div class="text---1">
                    너무 힘들다...
                </div>
            </div>
            <div class="group---3">
                <div class="text-2024-10-31-1756">
                    2024. 10. 31. 17:56
                </div>
                <svg id="0:550" class="line-3"></svg>
                <div class="hjw9265">
                    hjw9265
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d3aabe67f3d3c56a96de8dd0a3500b42.png" class="writer-" />
            </div>
            <div class="rectangle---1">
            </div>
        </div> -->
        <div class="group--3" @click="goToDetail">
            <div class="group---4">
                <div class="group--4">
                    <svg id="0:583" class="message-circle-1"></svg>
                    <div class="text-4">
                        3
                    </div>
                </div>
                <div class="group--5">
                    <div class="text-22">
                        21
                    </div>
                    <svg id="0:588" class="eye-1"></svg>
                </div>
            </div>
                <div class="group---5">
                    <div class="text----1">
                        주말에 열심히 해올게...
                    </div>
                    <div class="text---2">
                        너무 힘들다...
                    </div>
                </div>
            <div class="group---6">
                <div class="text-2024-10-31-1757">
                    2024. 10. 31. 17:56
                </div>
                <svg id="0:596" class="line-4"></svg>
                <div class="hjw9265-1">
                    hjw9265
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d3aabe67f3d3c56a96de8dd0a3500b42.png" class="writer--1" />
            </div>
                <div class="rectangle---2">
                </div>
        </div>
        <!-- <div class="group--6">
            <div class="group---7">
                <div class="group--7">
                    <svg id="0:603" class="message-circle-2"></svg>
                    <div class="text-5">
                        3
                    </div>
                </div>
                <div class="group--8">
                    <div class="text-23">
                        21
                    </div>
                    <svg id="0:608" class="eye-2"></svg>
                </div>
            </div>
            <div class="group---8">
                <div class="text----2">
                    주말에 열심히 해올게...
                </div>
                <div class="text---3">
                    너무 힘들다...
                </div>
            </div>
            <div class="group---9">
                <div class="text-2024-10-31-1758">
                    2024. 10. 31. 17:56
                </div>
                <svg id="0:616" class="line-5"></svg>
                <div class="hjw9265-2">
                    hjw9265
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d3aabe67f3d3c56a96de8dd0a3500b42.png" class="writer--2" />
            </div>
            <div class="rectangle---3">
            </div>
        </div> -->
        <!-- <div class="group--9">
            <div class="group---10">
                <div class="group--10">
                    <svg id="0:623" class="message-circle-3"></svg>
                    <div class="text-6">
                        3
                    </div>
                </div>
                <div class="group--11">
                    <div class="text-24">
                        21
                    </div>
                    <svg id="0:628" class="eye-3"></svg>
                </div>
            </div>
            <div class="group---11">
                <div class="text----3">
                    주말에 열심히 해올게...
                </div>
                <div class="text---4">
                    너무 힘들다...
                </div>
            </div>
            <div class="group---12">
                <div class="text-2024-10-31-1759">
                    2024. 10. 31. 17:56
                </div>
                <svg id="0:636" class="line-6"></svg>
                <div class="hjw9265-3">
                    hjw9265
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d3aabe67f3d3c56a96de8dd0a3500b42.png" class="writer--3" />
            </div>
            <div class="rectangle---4">
            </div>
        </div>
        <div class="group--12">
            <div class="group---13">
                <div class="group--13">
                    <svg id="0:643" class="message-circle-4"></svg>
                    <div class="text-7">
                        3
                    </div>
                </div>
                <div class="group--14">
                    <div class="text-25">
                        21
                    </div>
                    <svg id="0:648" class="eye-4"></svg>
                </div>
            </div>
            <div class="group---14">
                <div class="text----4">
                    주말에 열심히 해올게...
                </div>
                <div class="text---5">
                    너무 힘들다...
                </div>
            </div>
            <div class="group---15">
                <div class="text-2024-10-31-1760">
                    2024. 10. 31. 17:56
                </div>
                <svg id="0:656" class="line-7"></svg>
                <div class="hjw9265-4">
                    hjw9265
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d3aabe67f3d3c56a96de8dd0a3500b42.png" class="writer--4" />
            </div>
            <div class="rectangle---5">
            </div>
        </div>
        <div class="group--15">
            <div class="group---16">
                <div class="group--16">
                    <svg id="0:663" class="message-circle-5"></svg>
                    <div class="text-8">
                        3
                    </div>
                </div>
                <div class="group--17">
                    <div class="text-26">
                        21
                    </div>
                    <svg id="0:668" class="eye-5"></svg>
                </div>
            </div>
            <div class="group---17">
                <div class="text----5">
                    주말에 열심히 해올게...
                </div>
                <div class="text---6">
                    너무 힘들다...
                </div>
            </div>
            <div class="group---18">
                <div class="text-2024-10-31-1761">
                    2024. 10. 31. 17:56
                </div>
                <svg id="0:676" class="line-8"></svg>
                <div class="hjw9265-5">
                    hjw9265
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d3aabe67f3d3c56a96de8dd0a3500b42.png" class="writer--5" />
            </div>
            <div class="rectangle---6">
            </div>
        </div>
        <div class="group--18">
            <div class="group---19">
                <div class="group--19">
                    <svg id="0:683" class="message-circle-6"></svg>
                    <div class="text-9">
                        3
                    </div>
                </div>
                <div class="group--20">
                    <div class="text-27">
                        21
                    </div>
                    <svg id="0:688" class="eye-6"></svg>
                </div>
            </div>
            <div class="group---20">
                <div class="text----6">
                    주말에 열심히 해올게...
                </div>
                <div class="text---7">
                    너무 힘들다...
                </div>
            </div>
            <div class="group---21">
                <div class="text-2024-10-31-1762">
                    2024. 10. 31. 17:56
                </div>
                <svg id="0:696" class="line-9"></svg>
                <div class="hjw9265-6">
                    hjw9265
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d3aabe67f3d3c56a96de8dd0a3500b42.png" class="writer--6" />
            </div>
            <div class="rectangle---7">
            </div>
        </div>
        <div class="group--21">
            <div class="group---22">
                <div class="group--22">
                    <svg id="0:703" class="message-circle-7"></svg>
                    <div class="text-10">
                        3
                    </div>
                </div>
                <div class="group--23">
                    <div class="text-28">
                        21
                    </div>
                    <svg id="0:708" class="eye-7"></svg>
                </div>
            </div>
            <div class="group---23">
                <div class="text----7">
                    주말에 열심히 해올게...
                </div>
                <div class="text---8">
                    너무 힘들다...
                </div>
            </div>
            <div class="group---24">
                <div class="text-2024-10-31-1763">
                    2024. 10. 31. 17:56
                </div>
                <svg id="0:716" class="line-10"></svg>
                <div class="hjw9265-7">
                    hjw9265
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d3aabe67f3d3c56a96de8dd0a3500b42.png" class="writer--7" />
            </div>
            <div class="rectangle---8">
            </div>
        </div>
        <div class="group--24">
            <div class="group---25">
                <div class="group--25">
                    <svg id="0:723" class="message-circle-8"></svg>
                    <div class="text-11">
                        3
                    </div>
                </div>
                <div class="group--26">
                    <div class="text-29">
                        21
                    </div>
                    <svg id="0:728" class="eye-8"></svg>
                </div>
            </div>
            <div class="group---26">
                <div class="text----8">
                    주말에 열심히 해올게...
                </div>
                <div class="text---9">
                    너무 힘들다...
                </div>
            </div>
            <div class="group---27">
                <div class="text-2024-10-31-1764">
                    2024. 10. 31. 17:56
                </div>
                <svg id="0:736" class="line-11"></svg>
                <div class="hjw9265-8">
                    hjw9265
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d3aabe67f3d3c56a96de8dd0a3500b42.png" class="writer--8" />
            </div>
            <div class="rectangle---9">
            </div>
        </div> -->
        <div class="text---10">
            자유 게시판
        </div>
        <div class="group--bottom-">
            <div class="text-1-2-3-4-5-6-7">
                1 2 3 4 5 6 7
            </div>
            <svg id="0:855" class="material-symbolsarrow-back-2-outline-rounded"></svg><svg id="0:857" class="material-symbolsarrow-back-2-outline-rounded-1"></svg>
        </div>
        <div class="searchframe">
            <div class="group--27">
                <svg id="0:512" class="pen-"></svg>
                <div class="text----9">
                    제목, 내용으로 검색
                </div>
                <svg id="0:516" class="vector-30"></svg><svg id="0:517" class="vector-31"></svg>
            </div>
        </div>
        <div class="group--28" @click="goToDetail">
            <div class="group---28">
                <div class="group--29">
                    <svg id="8:1477" class="message-circle-9"></svg>
                    <div class="text-12">
                        3
                    </div>
                </div>
                <div class="group--30">
                    <div class="text-30">
                        21
                    </div>
                    <svg id="8:1485" class="eye-9"></svg>
                </div>
            </div>
            <div class="group---29">
                <div class="text----10">
                    주말에 열심히 해올게...
                </div>
                <div class="text---11">
                    너무 힘들다...
                </div>
            </div>
            <div class="group---30">
                <div class="text-2024-10-31-1765">
                    2024. 10. 31. 17:56
                </div>
                <svg id="8:1468" class="line-12"></svg>
                <div class="hjw9265-9">
                    hjw9265
                </div>
                <img src="https://image-resource.creatie.ai/142625939968981/142625939968983/d3aabe67f3d3c56a96de8dd0a3500b42.png" class="writer--9" />
            </div>
            <div class="rectangle---10">
            </div>
        </div>
    
</template>

<style lang="scss">
    .communitymainframe {
    width: 1083px;
    height: 792px;
    overflow: hidden;
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
    .group- {
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
            top: 29px;
            left: 42px;
            width: 306px;
            height: 54px;
            .text--- {
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
    .group--3 {
        position: absolute;
        top: 228px;
        left: 15px;
        width: 521px;
        height: 119px;
        .group---4 {
            position: absolute;
            top: 89px;
            left: 424px;
            width: 82px;
            height: 24px;
            .group--4 {
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
            .group--5 {
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
    .group--6 {
        position: absolute;
        top: 228px;
        left: 539px;
        width: 521px;
        height: 119px;
        .group---7 {
            position: absolute;
            top: 89px;
            left: 424px;
            width: 82px;
            height: 24px;
            .group--7 {
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
            .group--8 {
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
    .group--9 {
        position: absolute;
        top: 350px;
        left: 15px;
        width: 521px;
        height: 119px;
        .group---10 {
            position: absolute;
            top: 89px;
            left: 424px;
            width: 82px;
            height: 24px;
            .group--10 {
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
            .group--11 {
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
    .group--12 {
        position: absolute;
        top: 350px;
        left: 539px;
        width: 521px;
        height: 119px;
        .group---13 {
            position: absolute;
            top: 89px;
            left: 424px;
            width: 82px;
            height: 24px;
            .group--13 {
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
            .group--14 {
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
    .group--15 {
        position: absolute;
        top: 472px;
        left: 16px;
        width: 521px;
        height: 119px;
        .group---16 {
            position: absolute;
            top: 89px;
            left: 424px;
            width: 82px;
            height: 24px;
            .group--16 {
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
            .group--17 {
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
    .group--18 {
        position: absolute;
        top: 472px;
        left: 540px;
        width: 521px;
        height: 119px;
        .group---19 {
            position: absolute;
            top: 89px;
            left: 424px;
            width: 82px;
            height: 24px;
            .group--19 {
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
            .group--20 {
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
    .group--21 {
        position: absolute;
        top: 594px;
        left: 16px;
        width: 521px;
        height: 119px;
        .group---22 {
            position: absolute;
            top: 89px;
            left: 424px;
            width: 82px;
            height: 24px;
            .group--22 {
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
            .group--23 {
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
    .group--24 {
        position: absolute;
        top: 594px;
        left: 540px;
        width: 521px;
        height: 119px;
        .group---25 {
            position: absolute;
            top: 89px;
            left: 424px;
            width: 82px;
            height: 24px;
            .group--25 {
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
            .group--26 {
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
    .text---10 {
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
    .searchframe {
        position: absolute;
        top: calc(100% - 792px + 43px);
        left: calc(100% - 1083px + 539px);
        width: 300px;
        height: 50px;
        overflow: hidden;
        .group--27 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 300px;
            height: 50px;
            .pen- {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 300px;
                height: 50px;
            }
            .text----9 {
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
            .vector-30 {
                position: absolute;
                top: 28%;
                left: 87.33%;
                right: 6.67%;
                bottom: 36%;
                width: calc(100% - 87.67% - 7%);
                height: calc(100% - 30% - 38%);
            }
            .vector-31 {
                position: absolute;
                top: 56%;
                left: 92%;
                right: 5.67%;
                bottom: 30%;
                width: calc(100% - 92.33% - 6.22%);
                height: calc(100% - 58% - 33.3%);
            }
        }
    }
    .group--28 {
        position: absolute;
        top: 106px;
        left: 542px;
        width: 518px;
        height: 119px;
        .group---28 {
            position: absolute;
            top: 89px;
            left: 421.56px;
            width: 81.53px;
            height: 24px;
            .group--29 {
                position: absolute;
                top: 0px;
                left: 50.71px;
                width: 30.82px;
                height: 24px;
                .message-circle-9 {
                    position: absolute;
                    top: 0px;
                    left: -0.27px;
                    width: 23.86px;
                    height: 24px;
                }
                .text-12 {
                    position: absolute;
                    top: 5px;
                    left: 20.88px;
                    width: 9.94px;
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
            .group--30 {
                position: absolute;
                top: 5px;
                left: 0px;
                width: 38.78px;
                height: 18px;
                .text-30 {
                    position: absolute;
                    top: 0px;
                    left: 22.87px;
                    width: 15.91px;
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
                    left: -0.56px;
                    width: 19.88px;
                    height: 18px;
                }
            }
        }
        .group---29 {
            position: absolute;
            top: 29px;
            left: 41.76px;
            width: 304.24px;
            height: 54px;
            .text----10 {
                position: absolute;
                top: 21px;
                left: 0px;
                width: 304.24px;
                height: 33px;
                color: rgba(0, 0, 0, 0.33);
                font-family: "Bebas Neue";
                font-size: 16px;
                line-height: 19px;
                font-weight: 400;
                display: flex;
                align-items: center;
            }
            .text---11 {
                position: absolute;
                top: 0px;
                left: 0px;
                width: 183.93px;
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
            left: 5.97px;
            width: 221.72px;
            height: 37px;
            .text-2024-10-31-1765 {
                position: absolute;
                top: 9px;
                left: 98.43px;
                width: 123.29px;
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
                left: 88.03px;
                width: 15px;
                height: 15px;
            }
            .hjw9265-9 {
                position: absolute;
                top: 9px;
                left: 35.79px;
                width: 60.65px;
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
                width: 40.76px;
                height: 37px;
                object-fit: cover;
            }
        }
        .rectangle---10 {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 518px;
            height: 119px;
            background: rgba(217, 217, 217, 0.32);
        }
    }
}
</style>

<script>
export default {
  name: 'CommunityDefault',
  methods: {
    goToDetail() {
      // 부모 컴포넌트의 changeComponent 메서드를 호출하여 컴포넌트 전환
      this.$emit('change-component', 'CommunityDetail');
    },

    goToRegist() {
      // 부모 컴포넌트의 changeComponent 메서드를 호출하여 컴포넌트 전환
      this.$emit('change-component', 'CommunityRegist');
    },

  },
};
</script>