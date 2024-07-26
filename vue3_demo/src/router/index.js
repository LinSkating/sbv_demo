import {createRouter, createWebHistory} from 'vue-router'
import Login from '@/views/Login/index.vue'
import Home from '@/views/home/index.vue'
import Register from '@/views/register/index.vue'
import Me from '@/views/home/aboutMe/lifeSpeech.vue'
import Picture from '@/views/home/aboutMe/favoritePicture.vue'

const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        path: '/login',
        component: Login
    },
    {
        path: '/home',
        component: Home,
        children: [
            {
                // 注意多级路由不用写‘ / ’
                // ‘ / ’表示根路由
                path: 'aboutMe',
                component: Me
            },
            {
                path: 'favPicture',
                component: Picture
            }
        ]
    },
    {
        path: '/register',
        component: Register
    },
]

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
})

export default router
