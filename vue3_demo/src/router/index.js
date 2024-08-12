import {createRouter, createWebHistory} from 'vue-router'
import Login from '@/views/Login/index.vue'
import Home from '@/views/home/index.vue'
import Register from '@/views/register/index.vue'
import Me from '@/views/home/aboutMe/lifeSpeech.vue'
import Picture from '@/views/home/aboutMe/favoritePicture.vue'
import ForgetPassword from '@/views/forgetPassword/index.vue'
import stepOne from '@/views/forgetPassword/step/step1.vue'
import stepTwo from '@/views/forgetPassword/step/step2.vue'
import stepThree from '@/views/forgetPassword/step/step3.vue'
import TimeTravel from "@/views/home/timeCapsule/timeTravel.vue";
import DropDriftBottle from "@/views/home/timeCapsule/dropDriftBottle.vue";

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
            },
            {
                path: 'timeTravel',
                component: TimeTravel
            },
            {
                path: 'dropDriftBottle',
                component: DropDriftBottle
            }
        ]
    },
    {
        path: '/register',
        component: Register
    },
    {
        path: '/forgetPassword',
        component: ForgetPassword,
        children: [
            {
                path: 'stepOne',
                component: stepOne
            },
            {
                path: 'stepTwo',
                component: stepTwo
            },
            {
                path: 'stepThree',
                component: stepThree
            }
        ]
    }
]

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes
})

export default router
