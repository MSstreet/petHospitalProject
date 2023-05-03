<!-- PageHeader.vue -->
<template>


  <header>

<!--    <div id="nav">-->
<!--      <router-link to="/">Home</router-link> |-->
<!--&lt;!&ndash;      <router-link to="/about">About</router-link> |&ndash;&gt;-->
<!--      <router-link to="/board/list">게시판</router-link> |-->
<!--      <router-link to="/hospital/list">동물병원</router-link> |-->

<!--      <router-link to="/login" v-if="!this.$store.state.isLogin">로그인 | </router-link>-->
<!--      <router-link to="/mypage" v-if="this.$store.state.isLogin" >내 정보</router-link>-->

<!--      <a v-if="this.$store.state.isLogin" @click="fnLogout">로그아웃</a>-->

<!--      <router-link to="/join" v-if="!this.$store.state.isLogin">회원가입</router-link>-->
<!--    </div>-->
<div id="topheader">
    <nav class="navbar navbar-expand-lg bg-body-tertiary" style="border-bottom: 1px solid gray">
      <div class="container-fluid">

        <router-link to="/" class="navbar-brand fw-bold text-light fs-2" ><span style="color: gray"><i class="fa-solid fa-shield-cat me-2"></i>AnimalH</span></router-link>
        <button class="navbar-toggler " type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">

            <li class="nav-item ">
              <router-link to="/board/list" class="nav-link text-light  fs-5 fw-bold" aria-current="page"><span style="color: black">게시판</span></router-link>
            </li>

            <li class="nav-item active">
              <router-link to="/hospital/list" class="nav-link text-light fs-5 fw-bold"><span style="color: black">동물병원</span></router-link>
            </li>

            <li class="nav-item ">
              <router-link to="/notice/list" class="nav-link text-light fs-5 fw-bold" aria-current="page"><span style="color: black">공지사항</span></router-link>
            </li>

          </ul>

<!--            <li class="nav-item">-->
<!--              <router-link v-if="this.$store.state.isLogin" to="/review/myreview" class="nav-link text-light fw-bold">나의 리뷰</router-link>-->
<!--            </li>-->

<!--            <li class="nav-item">-->
<!--              <router-link v-if="this.$store.state.isLogin" to="/wish/mywish" class="nav-link text-light fw-bold">찜한 병원</router-link>-->
<!--            </li>-->
<!--         <ul class="mt-2">-->
          <ul class="navbar-nav mb-2 mb-lg-0">
            <li class="nav-item mt-1">
              <router-link to="/login"  class="nav-link text-light fs-3 fw-bold" v-if="!this.$store.state.isLogin"><span style="color: gray">Login </span></router-link>
            </li>

<!--            <li class="nav-item">-->
<!--              <router-link to="/mypage"  class="nav-link text-light fw-bold" v-if="this.$store.state.isLogin" >내 정보</router-link>-->
<!--            </li>-->

<!--            <li class="nav-item">-->
<!--              <a v-if="this.$store.state.isLogin" class="nav-link text-light fw-bold" @click="fnLogout">로그아웃</a>-->
<!--            </li>-->

            <li class="nav-item mt-1 me-3" >
              <router-link to="/join" class="nav-link text-light fs-3 fw-bold" v-if="!this.$store.state.isLogin"><span style="color: gray">Join</span></router-link>
            </li>
          </ul>


          <ul v-if="this.$store.state.isLogin">
            <li class="nav-item dropdown mt-3 me-5" >

              <a class="nav-link text-light fw-bold dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fa-solid fa-user fa-2x"></i>
              </a>

              <ul class="dropdown-menu dropdown-menu-end">
                <li class="dropdown-item">
                  <router-link to="/mypage" class="dropdown-item nav-link text-black fw-bold" v-if="this.$store.state.isLogin" >내 정보</router-link>
                </li>

                <li class="dropdown-item">
                  <router-link v-if="this.$store.state.isLogin" to="/review/myreview" class="nav-link text-black fw-bold">나의 리뷰</router-link>
                </li>

                <li class="dropdown-item">
                  <router-link v-if="this.$store.state.isLogin" to="/wish/mywish" class="nav-link text-black fw-bold">찜한 병원</router-link>
                </li>

                <li class="dropdown-item">
                  <a v-if="this.$store.state.isLogin" class="nav-link text-black fw-bold" @click="fnLogout">로그아웃</a>
                </li>

              </ul>
            </li>

<!--          <ul>-->
<!--            <li class="nav-item dropdown" v-if="this.$store.state.isLogin">-->
<!--              <a class="nav-link  text-light fw-bold me-5" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">-->
<!--                <i class="fa-solid fa-user fa-lg"></i>-->
<!--              </a>-->

<!--              <ul class="dropdown-menu">-->

<!--                <li class="">-->
<!--                  <router-link to="/mypage" class="dropdown-item nav-link text-black fw-bold" v-if="this.$store.state.isLogin" >내 정보&nbsp;&nbsp;</router-link>-->
<!--                </li>-->
<!--                <li class="">-->
<!--                  <router-link v-if="this.$store.state.isLogin" to="/review/myreview" class="dropdown-item nav-link text-black fw-bold">나의 리뷰</router-link>-->
<!--                </li>-->
<!--                <li class="">-->
<!--                  <router-link v-if="this.$store.state.isLogin" to="/wish/mywish" class="dropdown-item nav-link text-black fw-bold">찜한 병원</router-link>-->
<!--                </li>-->
<!--                <li class="nav-item">-->
<!--                  <a v-if="this.$store.state.isLogin" class="nav-link text-black fw-bold" @click="fnLogout">로그아웃</a>-->
<!--                </li>-->
<!--              </ul>-->
<!--            </li>-->
<!--          </ul>-->
<!--          </ul>-->

          </ul>
        </div>
      </div>
      <!--      <router-link to="/about">About</router-link> |-->
    </nav>
</div>
  </header>
</template>

<script>
import {IS_LOGIN} from '@/vuex/mutation_types'
import store from "@/vuex/store";
let setIsLogin = ({commit}, data) => {
  commit(IS_LOGIN, data)
}

export default {
  methods: {
    fnLogout() {
      localStorage.removeItem("user_token")
      localStorage.removeItem("user_role")
      //location.reload()
      //setTimeout(()=>  {this.goToPages1(),1000})
      this.$store.state.isLogin = false
      setIsLogin(store, false)
      this.goToPages1()
    },
    goToPages1() {
      this.$router.push({
        // path: './write',
        name: 'PageHome'
      })
    },
    goToMyPage(){

    }
  }


}


</script>

<style scoped>

#nav{
  text-align: center;
}

.nav-item {
  text-color: none;
}

.nav-item:hover  {
  text-decoration: underline;
  text-decoration-thickness: 2px;
  text-decoration-color: white;

}


</style>