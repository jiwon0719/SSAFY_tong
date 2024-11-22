import { createRouter, createWebHistory } from 'vue-router'
import StartView from '../views/StartView.vue'
import MainView from '../views/MainView.vue'
import SignUpView from '@/views/SignUpView.vue'
import SignInView from '@/views/SignInView.vue'
import CommunityView from '@/views/CommunityView.vue'
import CommunityDetail from '@/components/CommunityDetail.vue'
import CommunityList from '@/components/CommunityList.vue'
import CommunityRegist from '@/components/CommunityRegist.vue'
import CommunityBoardRegist from '@/components/CommunityBoardRegist.vue'
import CommunityBoardEdit from '@/components/CommunityBoardEdit.vue'
import MypageView from '@/views/MypageView.vue'
import MypageDefault from '@/components/MypageDefault.vue'
import MypageDefaultExpert from '@/components/MypageDefaultExpert.vue'
import ChatList from '@/components/ChatList.vue'
import ChattingRoom from '@/components/ChattingRoom.vue'
import UpdateUserInfo from '@/components/UpdateUserInfo.vue'
import CalendarView from '@/views/CalendarView.vue'
import CalendarExpertView from '@/views/CalendarExpertView.vue'
import CalendarDefault from '@/components/tmp/CalendarDefault.vue'
import CalendarDefaultReservation from '@/components/tmp/CalendarDefaultReservation.vue'
import CalendarDefaultCalendar from '@/components/tmp/CalendarDefaultCalendar.vue'
import MatchingView from '@/views/MatchingView.vue'
import MatchingDefault from '@/components/MatchingDefault.vue'
import MatchingExpertDetail from '@/components/MatchingExpertDetail.vue'
import MatchingExpertRegist from '@/components/MatchingExpertRegist.vue'
import MainDefault from '@/components/MainDefault.vue'

import ChatRoomList from '@/components/ChatRoomList.vue'
import Chat from '@/components/Chat.vue';
import ChatRoom from '@/components/ChatRoom.vue';

import { useUserStore } from '@/stores/user'

const routes = [
  {
    path: '/',
    name: 'start',
    component: StartView  // Start 페이지
  },
  //  ai 챗봇 채팅방
  { 
    path: '/AiChatRoom',
    name: 'AiChatRoom',
    component: ChatRoom,
  },
  {
    path: '/main',
    name: 'main',
    component: MainView, // Main 페이지
    children: [
      {
        path: '',
        name: 'mainDefault',
        component: MainDefault,
      },
      {
        path: '/calendar',
        name: 'calendar',
        component: CalendarView,
        children: [
          {
            path: '',
            name: 'calendarDefault',
            component: CalendarDefault,
          },
          {
            path: 'calendarDefaultCalendar',  // 상대 경로로 수정
            name: 'calendarDefaultCalendar',
            component: CalendarDefaultCalendar,
          },
          {
            path: 'calendarDefaultReservation',  // 상대 경로로 수정
            name: 'calendarDefaultReservation',
            component: CalendarDefaultReservation,
          },
        ]
      },
      {
        path: '/calendar/expert',
        name: 'calendarExpert',
        component: CalendarExpertView,
      },
      {
        path: '/mypage',
        name: 'mypage',
        component: MypageView,
        meta: { requiresAuth: true }, 
        children: [
          {
            path: '',
            name: 'mypageDefault',
            component: MypageDefault,
          },
          {
            path: 'expert',
            name: 'mypageDefaultExpert',
            component: MypageDefaultExpert,
          },
          {
            path: '/chat',
            name: 'chatRooms',
            component: ChatRoomList, // 채팅방 목록
          },
          {
            path: '/chat/:roomId',
            name: 'chatRoom',
            component: Chat,        // ChatRoom을 Chat으로 수정
            props: route => ({
              roomId: route.params.roomId,
              roomName: route.query.roomName,
              username: localStorage.getItem('username') || '게스트'
            })
          },
          {
            path: 'chattingRoom',
            name: 'chattingRoom',
            component: ChattingRoom,
          },
          {
            path: 'updateUserInfo',
            name: 'updateUserInfo',
            component: UpdateUserInfo,
          },
        ],
      },
      {
        path: '/community',
        name: 'community',
        component: CommunityView,  // community 페이지

        children: [
          {
            path: 'regist',
            name: 'communityRegist',
            component: CommunityRegist,
          },
          {
            path: 'board-regist',
            name: 'communityBoardRegist',
            component: CommunityBoardRegist,
          },
          {
            path: ':categoryId',
            name: 'communityList',
            component: CommunityList,
          },
          {
            path: ':categoryId/:boardId',
            name: 'communityDetail',
            component: CommunityDetail,
          },
          {
            path: ':categoryId/edit/:boardId', 
            name: 'communityBoardEdit',
            component: CommunityBoardEdit, 
          }, 
        ]
      },
      {
        path: '/matching',
        name: 'matching',
        component: MatchingView,

        children: [
          {
            path: '',
            name: 'matchingDefault',
            component: MatchingDefault,
          },
          {
            path: 'detail/:expertId',
            name: 'matchingExpertDetail',
            component: MatchingExpertDetail,
          },
          {
            path: 'regist',
            name: 'matchingExpertRegist',
            component: MatchingExpertRegist,
          },
        ]
      },
    ],
  },
  {
    path: '/signUp',
    name: 'signUp',
    component: SignUpView,  // signUp 페이지
    meta: { layout: 'none' }  // 헤더와 풋터가 필요 없는 페이지
  },
  {
    path: '/signIn',
    name: 'signIn',
    component: SignInView,  // signIn 페이지
    meta: { layout: 'none' }  // 헤더와 풋터가 필요 없는 페이지
  },
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition;
    } else {
      return { top: 0 }; // 기본적으로 최상단으로 이동
    }
  }
  
});


// 페이지 이동 후 항상 상단으로 스크롤 이동
router.afterEach(() => {
  window.scrollTo(0, 0); // 페이지 이동 후 항상 최상단으로 스크롤
});

router.beforeEach(async (to, from, next) => {
  if (to.path.startsWith('/community/') && to.params.id) {
    try {
      const boardId = to.params.id;
      await boardStore.getBoardDetail(boardId);
      next();
    } catch (error) {
      console.error("게시글 상세 조회 실패:", error);
      next(false);
    }
  } else {
    next();
  }
});

export default router
