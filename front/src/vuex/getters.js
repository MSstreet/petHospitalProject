// src/vuex/getters.js
export default {
    getUserId: state => state.userId,
    getErrorState: state => state.errorState,
    getIsAuth: state => state.isAuth,
    getIsUserIdx: state => state.userIdx,

    loggedIn(state) {
        return !!state.user
    }
}