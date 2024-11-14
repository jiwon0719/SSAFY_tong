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
import MypageView from '@/views/MypageView.vue'
import MypageDefault from '@/components/MypageDefault.vue'
import ChatList from '@/components/ChatList.vue'
import ChattingRoom from '@/components/ChattingRoom.vue'
import UpdateUserInfo from '@/components/UpdateUserInfo.vue'
import CalendarView from '@/views/CalendarView.vue'
import CalendarDefault from '@/components/CalendarDefault.vue'
import CalendarDefaultReservation from '@/components/CalendarDefaultReservation.vue'
import CalendarDefaultCalendar from '@/components/CalendarDefaultCalendar.vue'
import { compile } from 'vue'
import MatchingView from '@/views/MatchingView.vue'
import MatchingDefault from '@/components/MatchingDefault.vue'
import MatchingExpertDetail from '@/components/MatchingExpertDetail.vue'
import MatchingExpertRegist from '@/components/MatchingExpertRegist.vue'
import MainDefault from '@/components/MainDefault.vue'

const routes = [
  {
    path: '/',
    name: 'start',
    component: StartView  // Start 페이지
  },
  {
    path: '/main',
    name: 'main',
    component: MainView, // Main 페이지

    children: [
      
      {
        path: '/calendar',
        name: 'calendar',
        component : CalendarView,
    
        children : [
          {
            path : '',
            name : 'calendarDefault',
            component : CalendarDefault,
          },
              {
                path : '/calendarDefaultCalendar',
                name : 'calendarDefaultCalendar',
                component : CalendarDefaultCalendar
              },
              {
                path : '/calendarDefaultReservation',
                name : 'calendarDefaultReservation',
                component : CalendarDefaultReservation
              },
          
        ]
      },

      {
        path : '/mypage',
        name : 'mypage',
        component : MypageView,

        children : [
              {
                path : '',
                name : 'mypageDefault',
                component : MypageDefault,
              },
              {
                path : '/chatList',
                name : 'chatList',
                component : ChatList,
              },
              {
                path : '/chattingRoom',
                name : 'chattingRoom',
                component : ChattingRoom,
              },
              {
                path : '/updateUserInfo',
                name : 'updateUserInfo',
                component : UpdateUserInfo,
              },
        ],
      },
      {
        path: '/community',
        name: 'community',
        component: CommunityView,  // community 페이지
    
        children :[
          {
            path: '',
            name: 'communityList',
            component: CommunityList,
          },
          {
            path: '/communityDetail',
            name: 'communityDetail',
            component: CommunityDetail,
          },
          {
            path: '/communityRegist',
            name: 'communityRegist',
            component: CommunityRegist,
          },
          {
            path: '/communityBoardRegist',
            name: 'communityBoardRegist',
            component: CommunityBoardRegist,
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
  {
    path : '/matching',
    name : 'matching',
    component : MatchingView,

    children : [
      {
        path: '/',
        name: 'matchingDefault',
        component : MatchingDefault,
      },
      {
        path: '/matchingExpertDetail',
        name: 'matchingExpertDetail',
        component : MatchingExpertDetail,
      },
      {
        path: '/matchingExpertRegist',
        name: 'matchingExpertRegist',
        component : MatchingExpertRegist,
      },
    ]

    
  },
  

]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
