<!-- PageHeader.vue -->
<template>
  <header>
    <div id="nav">
      <router-link to="/">Home</router-link> |
<!--      <router-link to="/about">About</router-link> |-->
      <router-link to="/board/list">게시판</router-link> |
      <router-link to="/hospital/list">동물병원</router-link> |

      <router-link to="/login" v-if="!this.$store.state.isLogin">로그인 | </router-link>
      <router-link to="/mypage" v-if="this.$store.state.isLogin" >내 정보</router-link> |

      <a v-if="this.$store.state.isLogin" @click="fnLogout">로그아웃</a>

      <router-link to="/join" v-if="!this.$store.state.isLogin">회원가입</router-link>
    </div>
  </header>
</template>

<script>
export default {
  methods: {
    fnLogout() {
      localStorage.removeItem("user_token")
      localStorage.removeItem("user_role")
      location.reload()
      //setTimeout(()=>  {this.goToPages1(),1000})

    },
    goToPages1() {
      this.$router.push({
        // path: './write',
        name: 'PageHome'
      })
    }
  }
}
</script>

<style scoped>

#nav{
  text-align: center;
}

</style>