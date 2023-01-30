import { createRouter, createWebHistory } from 'vue-router'
import PageHome from '@/views/PageHome.vue'
import BoardList from '@/views/board/BoardList.vue'
import BoardDetail from '@/views/board/BoardDetail.vue'
import BoardWrite from '@/views/board/BoardWrite.vue'
import Login from "@/views/common/Login"
import Join from "@/views/common/Join"
import HospitalList from '@/views/hospital/HospitalList'
import MyPage from '@/views/common/MyPage'
import EditPassword from '@/views/common/EditPassword'

import HospitalDetail from '@/views/hospital/HospitalDetail'


// import {store} from "@/vuex/store";

import store from "@/vuex/store";


const requireAuth = () => (from, to, next) => {

    const token = localStorage.getItem('user_token')

    if (token) {
        store.state.isLogin = true
        return next()
    } // isLogin === true면 페이지 이동
    next('/login') // isLogin === false면 다시 로그인 화면으로 이동


}

const requireAuth1 = () => (from, to, next) => {

    const token = localStorage.getItem('user_token')

    if (token) {
        store.state.isLogin = true
        return next()
    }
}

const routes = [
    {
        path: '/',
        name: 'PageHome',
        component: PageHome
     },
    {
        path: '/join',
        name: 'Join',
        component: Join //회원가입 컴포넌트 추가
    },
    {
        path: '/login',
        name: 'Login',
        component: Login  //로그인 컴포넌트 추가
    },
    {
        path: '/mypage',
        name: 'MyPage',
        component: MyPage  //로그인 컴포넌트 추가
    },
    {
        path: '/pw_edit',
        name: 'EditPassword',
        component: EditPassword
    },
    // {
    //     path: '/about',
    //     name: 'About',
    //     // route level code-splitting
    //     // this generates a separate chunk (about.[hash].js) for this route
    //     // which is lazy-loaded when the route is visited.
    //     component: () => import(/* webpackChunkName: "about" */ '../views/PageAbout.vue')
    // },
    {
        path: '/board/list',
        name: 'BoardList',
        component: BoardList,
         beforeEnter: requireAuth1()
    },
    {
        path: '/board/detail',
        name: 'BoardDetail',
        component: BoardDetail,
        beforeEnter: requireAuth1()
    },{
        path: '/board/write',
        name: 'BoardWrite',
        component: BoardWrite,
        beforeEnter: requireAuth()
    },{
        path: '/hospital/list',
        name: 'HospitalList',
        component: HospitalList
    },{
        path: '/hospital/detail',
        name: 'HospitalDetail',
        component: HospitalDetail
    }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router