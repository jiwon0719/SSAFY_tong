import { createRouter, createWebHistory } from 'vue-router'
import StartView from '../views/StartView.vue'
import MainView from '../views/MainView.vue'
import SignUpView from '@/views/SignUpView.vue'
import SignInView from '@/views/SignInView.vue'
import CommunityView from '@/views/CommunityView.vue'
import CommunityDetail from '@/components/CommunityDetail.vue'
import CommunityDefault from '@/components/CommunityDefault.vue'
import CommunityRegist from '@/components/CommunityRegist.vue'

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
  },
  {
    path: '/signUp',
    name: 'signUp',
    component: SignUpView  // signUp 페이지
  }, 
  {
    path: '/signIn',
    name: 'signIn',
    component: SignInView  // signIn 페이지
  }, 
  {
    path: '/community',
    name: 'community',
    component: CommunityView,  // community 페이지

    children :[
      {
        path: '',
        name: 'communityDefault',
        component: CommunityDefault,
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
    ]
  }, 
  
  

]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
