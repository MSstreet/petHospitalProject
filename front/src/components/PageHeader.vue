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

    <nav class="navbar navbar-expand-lg bg-body-tertiary"  style="background-color: #F9FFFF;">
      <div class="container-fluid">
        <router-link to="/" class="navbar-brand fw-bold">Home</router-link>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <router-link to="/board/list" class="nav-link" aria-current="page">게시판</router-link>
            </li>

            <li class="nav-item">
              <router-link to="/hospital/list" class="nav-link">동물병원</router-link>
            </li>

            <li class="nav-item">
              <router-link v-if="this.$store.state.isLogin" to="/review/write" class="nav-link">리뷰 작성</router-link>
            </li>

            <li class="nav-item">
              <router-link to="/login"  class="nav-link" v-if="!this.$store.state.isLogin">로그인</router-link>
            </li>

            <li class="nav-item">
              <router-link to="/mypage"  class="nav-link" v-if="this.$store.state.isLogin" >내 정보</router-link>

            </li>

            <li class="nav-item">
              <a v-if="this.$store.state.isLogin" class="nav-link" @click="fnLogout">로그아웃</a>
            </li>

            <li class="nav-item">
              <router-link to="/join" class="nav-link" v-if="!this.$store.state.isLogin">회원가입</router-link>
            </li>
          </ul>

        </div>
      </div>
      <!--      <router-link to="/about">About</router-link> |-->
    </nav>
  </header>
</template>

<script>
export default {
  methods: {
    fnLogout() {
      localStorage.removeItem("user_token")
      localStorage.removeItem("user_role")
      //location.reload()
      //setTimeout(()=>  {this.goToPages1(),1000})
      this.$store.state.isLogin = false
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



</style>