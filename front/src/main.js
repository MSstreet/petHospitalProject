import './assets/common.css'

import Vue from 'vue'
import { createApp } from 'vue'
import App from './App.vue'
import VueSplide from '@splidejs/vue-splide'

import router from './router'
import axios from './utils/axios'
import store from './vuex/store'  //1. store 추가


import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

// const key = 4e9386c7cfa4631f95ba0a7f63036ba2;



const app = createApp(App)
app.config.globalProperties.$axios = axios;  //전역변수로 설정 컴포넌트에서 this.$axios 호출할 수 있음
app.config.globalProperties.$serverUrl = '//localhost:8081' //api server
app.config.globalProperties.$store = store
app
    .use(router)
    .use(store)   //2. store 등록
    .use(VueSplide)
    .mount('#app')