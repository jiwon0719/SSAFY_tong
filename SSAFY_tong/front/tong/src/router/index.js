import { createRouter, createWebHistory } from 'vue-router'
import BoardIndex from '@/views/Board/BoardIndex.vue'
import BoardList from '@/components/Board/BoardList.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/board',
      name: 'board',
      component: BoardIndex,
    },
    {
      path: '/board/list',
      name: 'boardList',
      component: BoardList,
    },
  ],
})

export default router
