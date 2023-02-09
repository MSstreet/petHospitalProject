// src/vuex/store.js
import {createStore} from "vuex"

import getters from "./getters"
import mutations from "./mutations"
import actions from "./actions";    //추가
import createPersistedState from 'vuex-persistedstate';

export default createStore({
    plugins:[
        createPersistedState()
    ],

    state: {
        user: null,
        isLogin: false,

        userIdx: null
    },
    mutations,
    getters,
    actions     //추가
})