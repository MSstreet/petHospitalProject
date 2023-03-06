import { createRouter, createWebHistory } from 'vue-router'
import PageHome from '@/views/PageHome.vue'
import BoardList from '@/views/board/BoardList.vue'
import BoardDetail from '@/views/board/BoardDetail.vue'
import BoardWrite from '@/views/board/BoardWrite.vue'
import BoardUpdate from "@/views/board/BoardUpdate";
import Login from "@/views/common/Login"
import Join from "@/views/common/Join"
import HospitalList from '@/views/hospital/HospitalList'
import HospitalListFromHome from '@/views/hospital/HospitalListFromHome'
import MyPage from '@/views/common/MyPage'
import EditPassword from '@/views/common/EditPassword'
import EditMyInfo from '@/views/common/EditMyInfo'
import IdFind from '@/views/common/IdFind'
import PasswordFind from '@/views/common/PasswordFind'

import HospitalDetail from '@/views/hospital/HospitalDetail'
import ReviewWrite from '@/views/review/ReviewWrite'
import ReviewDetail from '@/views/review/ReviewDetail'
import ReviewUpdate from '@/views/review/ReviewUpdate'

import NoticeBoardList from '@/views/noticeBoard/NoticeBoardList'
import NoticeBoardDetail from "@/views/noticeBoard/NoticeBoardDetail";

import WishList from '@/views/wish/WishList'

import HospitalInfo from '@/views/hospital/HospitalInfo'
import MyReview from '@/views/review/MyReview'

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
    }else{
        alert("로그인 후 이용해주세요")
    }
}

const preventAfterLogging = () => (from, to, next) => {

    const token = localStorage.getItem('user_token')

    if (token && from.path==='/login') {
        next('/mypage')
    }
}

const routes = [
    {
        path: '/',
        name: 'PageHome',
        component: PageHome,

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
    {
        path: '/myinfo_edit',
        name: 'EditMyInfo',
        component: EditMyInfo
    },
    {
        path: '/id-find',
        name: 'IdFind',
        component: IdFind
    },
    {
        path: '/password-find',
        name: 'PasswordFind',
        component: PasswordFind
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
    }
    ,{
        path: '/board/update',
        name: 'BoardUpdate',
        component: BoardUpdate,
        beforeEnter: requireAuth()
    }
    ,{
        path: '/hospital/list',
        name: 'HospitalList',
        component: HospitalList
    },{
        path: '/hospital/list1',
        name: 'HospitalListFromHome',
        component: HospitalListFromHome
    },{
        path: '/hospital/detail',
        name: 'HospitalDetail',
        component: HospitalDetail,
        beforeEnter: requireAuth1()
    },{
        path: '/hospital/info',
        name: 'HospitalInfo',
        component: HospitalInfo
    },{
        path: '/review/write',
        name: 'ReviewWrite',
        component: ReviewWrite
    },{
        path: '/review/detail',
        name: 'ReviewDetail',
        component: ReviewDetail
    },{
        path: '/review/update',
        name: 'ReviewUpdate',
        component: ReviewUpdate
    }
    ,{
        path: '/review/myreview',
        name: 'MyReview',
        component: MyReview
    },{
        path: '/wish/mywish',
        name: 'WishList',
        component: WishList
    },
    {
        path: '/notice/list',
        name: 'NoticeBoardList',
        component: NoticeBoardList,

    },
    {
        path: '/notice/detail',
        name: 'NoticeBoardDetail',
        component: NoticeBoardDetail,
        beforeEnter: requireAuth1()
    },

]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router