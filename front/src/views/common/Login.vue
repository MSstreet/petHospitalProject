<template>
  <section class="bg-light">
    <div class="mt-10">

<!--      <h2>Please Log In</h2>-->

      <div class="container py-4">

<!--        <div class="row align-items-center justify-content-between">-->
<!--          <a class="navbar-brand h1 text-center" href="index.do">-->
<!--            <span class="text-dark h4">도시</span> <span class="text-primary h4">거북</span>-->
<!--          </a>-->
<!--        </div>-->

        <form @submit.prevent="fnLogin">

          <div class="form-group">
            <label for="exampleInputEmail1" class="mb-1">Email</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter email" v-model="user_id">

            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
          </div>


          <div class="form-group">
            <label for="exampleInputPassword1" class="mb-1 mt-4">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"  v-model="user_pw">
          </div>

          <div class="d-grid gap-2">
          <button type="submit" class="btn btn-primary mt-3">Login</button>
          </div>

<!--          <p>-->
<!--            <input class="w3-input" name="uid" placeholder="Enter your ID" v-model="user_id"><br>-->
<!--          </p>-->

<!--          <p>-->
<!--            <input name="password" class="w3-input" placeholder="Enter your password" v-model="user_pw" type="password">-->
<!--          </p>-->

        </form>
      </div>

    </div>
  </section>
</template>

<!--<script>-->
<!--import {mapActions, mapGetters} from 'vuex'   //vuex 추가-->

<!--export default {-->
<!--  data() {-->
<!--    return {-->
<!--      user_id: '',-->
<!--      user_pw: ''-->
<!--    }-->
<!--  },-->
<!--  methods: {-->
<!--    ...mapActions(['login']),     //vuex/actions에 있는 login 함수-->

<!--    async fnLogin() {       //async 함수로 변경-->
<!--      if (this.user_id === '') {-->
<!--        alert('ID를 입력하세요.')-->
<!--        return-->
<!--      }-->

<!--      if (this.user_pw === '') {-->
<!--        alert('비밀번호를 입력하세요.')-->
<!--        return-->
<!--      }-->

<!--      //로그인 API 호출-->
<!--      try {-->
<!--        let loginResult = await this.login({user_id: this.user_id, user_pw: this.user_pw})-->
<!--        if (loginResult) alert('로그인 결과 : ' + loginResult)-->
<!--      } catch (err) {-->
<!--        if (err.message.indexOf('Network Error') > -1) {-->
<!--          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요.')-->
<!--        } else {-->
<!--          alert('로그인 정보를 확인할 수 없습니다.')-->
<!--        }-->
<!--      }-->
<!--    }-->
<!--  },-->


<!--  computed: {-->
<!--    ...mapGetters({-->
<!--      errorState: 'getErrorState'-->
<!--    })-->
<!--  }-->
<!--}-->
<!--</script>-->



<script>
import {mapActions, mapGetters} from 'vuex'   //vuex 추가

export default {

  data() {
    return {
      user_id: '',
      user_pw: ''
    }

  },
  methods: {

    ...mapActions(['login']),     //vuex/actions에 있는 login 함수

    async fnLogin() {       //async 함수로 변경
      if (this.user_id === '') {
        alert('ID를 입력하세요.')
        return
      }

      if (this.user_pw === '') {
        alert('비밀번호를 입력하세요.')
        return
      }

      //로그인 API 호출
      try {
        let loginResult = await this.login({user_id: this.user_id, user_pw: this.user_pw})
        if (loginResult) {
          this.goToPages()
            // alert('로그인 결과 : ' + loginResult)
        }

      } catch (err) {
        if (err.message.indexOf('Network Error') > -1) {
          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요.')
        } else {
          alert('로그인 정보를 확인할 수 없습니다.')
        }
      }
    },
    goToPages() {
      this.$router.push({
        // path: './write',
        name: 'BoardList'
      })
    }
  },

  computed: {
    ...mapGetters({
      errorState: 'getErrorState'
    })
  }
}
</script>


<style>
#loginForm {
  width: 500px;
  margin: auto;

}

.bg-light{
  height: 1053px;
  padding-top:55px;
  padding-bottom:75px;
}

.container.py-4{
  margin: 0 auto;
  width : 503px;
}
</style>