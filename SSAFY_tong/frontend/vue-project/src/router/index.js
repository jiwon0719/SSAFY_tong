import { createRouter, createWebHistory } from 'vue-router'
import StartView from '../views/StartView.vue'
import MainView from '../views/MainView.vue'
import SignUpView from '@/views/SignUpView.vue'
import SignInView from '@/views/SignInView.vue'
import Community from '@/components/Community.vue'


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

    children : [
      {
        path: "/community",
        name: 'community',
        component: Community,
      },


    ]
  
  },
  {
    path: '/signUp',
    name: 'signUp',
    component: SignUpView  // Main 페이지
  }, 
  {
    path: '/signIn',
    name: 'signIn',
    component: SignInView  // Main 페이지
  }, 
  

]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router
