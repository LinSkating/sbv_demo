import { createRouter, createWebHistory } from 'vue-router'
import Login from '@/views/Login/index.vue'
import Home from '@/views/home/index.vue'
import Register from '@/views/register/index.vue'

const routes = [
    { path: '/',         redirect: '/login'  },
    { path: '/login',    component: Login    },
    { path: '/home',     component: Home     },
    { path: '/register', component: Register }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
})

export default router