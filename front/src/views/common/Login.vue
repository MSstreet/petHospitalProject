
<template>

  <div id="findId" class="modal fade">
    <div class="modal-dialog modal-dialog-centered modal-login">
      <div class="modal-content">
        <div class="modal-body">
          <div class="container my-auto">
            <div class="row">
              <div class="card z-index-0 fadeIn3 fadeInBottom">
                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                  <div class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1">
                    <h4 class="text-black font-weight-bolder text-center mt-2 mb-0">ID 찾기</h4>
                  </div>
                </div>
                <div class="card-body">
                    <p>가입 시 입력한 이름과 Email을 입력해주세요.</p>

                  <div class="input-group input-group-outline my-3">
<!--                    <label class="form-label">이름</label>-->
                    <input type="text" maxlength="50" id="userName" name="userName" class="form-control" placeholder="이름" v-model="user_name" required>
                  </div>

                  <div class="input-group input-group-outline my-3">
<!--                      <label class="form-label">Email</label>-->
                      <input type="email" maxlength="50" id="userEmail" name="memberEmail" class="form-control" placeholder="Email" v-model="user_email" required>
                    </div>
                    <div class="text-center">
                      <button type="button" class="btn btn-primary bg-gradient-primary w-100 my-4 mb-2"
                              id="checkEmail" @click="fnFind">확인</button>
                    </div>

                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <div id="findPw" class="modal fade">
    <div class="modal-dialog modal-dialog-centered modal-login">
      <div class="modal-content">
        <div class="modal-body">
          <div class="container my-auto">
            <div class="row">
              <div class="card z-index-0 fadeIn3 fadeInBottom">
                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                  <div class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1">
                    <h4 class="text-black font-weight-bolder text-center mt-2 mb-0">비밀번호 찾기</h4>
                  </div>
                </div>
                <div class="card-body">
                  <p>입력한 이메일로 임시 비밀번호가 전송됩니다.</p>

                  <!--                  <div class="input-group input-group-outline my-3">-->
                  <!--&lt;!&ndash;                    <label class="form-label">이름</label>&ndash;&gt;-->
                  <!--                    <input type="text" id="userName" name="userName" class="form-control" placeholder="이름" v-model="user_name" required>-->
                  <!--                  </div>-->
                  <div class="input-group input-group-outline my-3">
                    <!--                      <label class="form-label">Email</label>-->
                    <input type="email" maxlength="50" id="userEmail" name="memberEmail" class="form-control" placeholder="Email" v-model="user_email" required>
                  </div>
                  <div class="text-center">
                    <button type="button" class="btn btn-primary bg-gradient-primary w-100 my-4 mb-2"
                            id="checkEmail" @click="checkEmail">비밀번호 발송</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <section class="bg-light">
    <div class="mt-10">

<!--      <h2>Please Log In</h2>-->

      <div class="container py-4">

<!--        <div class="row align-items-center justify-content-between">-->
<!--          <a class="navbar-brand h1 text-center" href="index.do">-->
<!--            <span class="text-dark h4">도시</span> <span class="text-primary h4">거북</span>-->
<!--          </a>-->
<!--        </div>-->
        <h1 class="fs-1 fw-bold text-center mb-5"><b style="color: #4c1192">LOGIN</b> </h1>

        <form @submit.prevent="fnLogin">

          <div class="form-group">
            <label for="exampleInputEmail1" class="mb-1">ID</label>
            <input type="text" maxlength="50" class="form-control" id="exampleInputEmail1" placeholder="Enter Id" v-model="user_id">

            <small id="emailHelp" class="form-text text-muted">We'll never share your id with anyone else.</small>
          </div>

          <div class="form-group">
            <label for="exampleInputPassword1" class="mb-1 mt-4">Password</label>
            <input type="password" maxlength="50" class="form-control" id="exampleInputPassword1" placeholder="Password" autocomplete="on" v-model="user_pw">
          </div>

        <div class="row">
          <div class="d-grid gap-2 mt-2 col-6">
          <button type="submit" class="btn btn-primary mt-3 fw-bold">Login</button>
          </div>

          <div class="d-grid gap-2 mt-2 col-6">
            <router-link to="/join" type="button" class="btn btn-success mt-3 fw-bold">Join</router-link>
<!--            <button type="submit" class="btn btn-success mt-3">Join</button>-->
          </div>

<!--          <div>-->
<!--            <a href="/oauth2/authorization/kakao">KAKAO</a>-->
<!--          </div>-->

          <div class="mt-2 ">
            <span type="button" class="btn btn-link a" data-bs-toggle="modal"
                  data-bs-target="#findId">ID를 잊으셨나요?</span>
<!--            <span><router-link class="a" to="/id-find">ID를 잊으셨나요?&nbsp&nbsp&nbsp</router-link></span>-->
           <span type="button" class="btn btn-link a" data-bs-toggle="modal"
                 data-bs-target="#findPw">비밀번호를 잊으셨나요?</span>
          </div>

<!--          <button type="button" class="btn btn-link" data-bs-toggle="modal"-->
<!--                  data-bs-target="#findPw">비밀번호를 잊으셨나요?</button>-->
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
      user_pw: '',
      user_name:'',
      user_email: '',
    }

  }
  ,mounted() {
    // console.log("확인!!!!!!!" + user_idx)
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

        console.log("확인" + loginResult)

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
    }
    ,goToPages() {
      this.$router.push({
        // path: './write',
        name: 'PageHome'
      })
    }
    ,checkEmail(){
      console.log("!!!!!!!!!!!!!!!!")

      let apiUrl = this.$serverUrl + '/user/find/pw?userEmail=' + this.user_email

      this.$axios.post(apiUrl, {
        params: {
          user_email: this.user_email
        }
      }).then((res)=> {
               console.log(res.data)
              if(res.data == '') {
                alert('일치하는 정보가 없습니다.')
              }else{
                alert("회원님의 Email로 임시 비밀번호를 전송하였습니다.")
              }

            }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })

      // this.form = {
      //   // "user_name": this.user_name,
      //   "email":this.email,
      // }
      // this.$axios.post(apiUrl, this.form)
      //     .then((res) => {
      //        console.log(res.data)
      //       if(res.data == '') {
      //         alert('일치하는 정보가 없습니다.')
      //       }else{
      //         alert("회원님의 Email로 임시 비밀번호를 전송하였습니다.")
      //       }
      //
      //     }).catch((err) => {
      //   if (err.message.indexOf('Network Error') > -1) {
      //     alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
      //   }
      // })
    }
    , fnFind(){
      let apiUrl = this.$serverUrl + '/user/find'

      console.log(this.email)
      console.log(this.user_name)

      this.form = {
        "user_name": this.user_name,
        "email":this.user_email,

      }
      //UPDATE
      this.$axios.post(apiUrl, this.form)
          .then((res) => {
            // alert('아이디 찾았다.')
            //this.fnView(res.data.idx)
            console.log(res.data)
            if(res.data == '') {
              alert('일치하는 정보가 없습니다.')
              console.log('일치하는 정보가 없습니다.')
            }else{
              alert("회원님의 ID : " + res.data)
            }

          }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })

    }

  },


  computed: {
    ...mapGetters({
      errorState: 'getErrorState',
    })
  }
}
</script>


<style>
#loginForm {
  width: 500px;
  margin: auto;

}
.a{
  text-decoration-line:none;
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