<template>
  <!--  배경색-->


  <section class="bg-light">

    <div class="container py-4">

<!--      <div class="row align-items-center justify-content-between">-->
<!--        <a class="navbar-brand h1 text-center" href="index.do">-->
<!--          <span class="text-dark h4">도시</span> <span class="text-primary h4">거북</span>-->
<!--        </a>-->
<!--      </div>-->

      <form @submit.prevent="fnJoin" ref="form">


        <div class="form-group">
          <label for="exampleInputEmail1" class="form-label mt-4">아이디</label>
          <input type="text" class="form-control" id="exampleInputEmail1" v-model="user_id">
        </div>

        <div class="form-group has-success">
          <label class="form-label mt-4" for="inputValid">비밀번호</label>
          <input type="password" class="form-control is-valid" id="inputValid" v-model="user_pw">
          <div class="valid-feedback"></div>
        </div>

        <div class="form-group has-danger">
          <label class="form-label mt-4" for="inputInvalid">비밀번호 재확인</label>
          <input type="password" class="form-control is-invalid" id="inputInvalid" v-model="pwd_check">
          <div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>
        </div>

        <div class="form-group">
          <label for="exampleInputName" class="form-label mt-4">이름</label>
          <input type="text" class="form-control" id="exampleInputName" v-model="user_name">
        </div>

        <div class="form-group">
          <label for="exampleInputNum" class="form-label mt-4">전화번호</label>
          <input type="text" class="form-control" id="exampleInputNum" v-model="user_num">
        </div>

        <div class="form-group">
          <label for="exampleInputAddr" class="form-label mt-4">주소</label>
          <input type="text" class="form-control mb-4" id="exampleInputAddr" v-model="user_addr">
        </div>


        <div class="d-grid gap-2">
          <button class="btn btn-primary btn-lg" type="submit">가입하기</button>
        </div>
      </form>
    </div>
  </section>
</template>

<script>
import {mapActions, mapGetters} from 'vuex'   //vuex 추가

export default {
  data() {
    return {
      user_id: '',
      user_pw: '',
      pwd_check: '',
      user_name: '',
      user_num:'',
      user_addr:''

    }
  },

  methods: {
    ...mapActions(['join']),     //vuex/actions에 있는 login 함수

    async fnJoin() {       //async 함수로 변경
      if (this.user_id === '') {
        alert('ID를 입력하세요.')
        return
      }

      if (this.user_pw === '') {
        alert('비밀번호를 입력하세요.')
        return
      }

      if (this.pwd_check != this.user_pw) {
        alert('비밀번호가 일치하지 않습니다.')
        return
      }

      if (this.user_name === '') {
        alert('이름을 입력하세요.')
        return
      }

      if (this.user_num === '') {
        alert('번호를 입력하세요.')
        return
      }

      if (this.user_addr === '') {
        alert('주소를 입력하세요.')
        return
      }

      try {
        let joinResult = await this.join({user_id: this.user_id, user_pw: this.user_pw, user_name: this.user_name, user_num: this.user_num, user_addr: this.user_addr})
        if (joinResult) {
          this.goToPages1()
        }
      } catch (err) {
        if (err.message.indexOf('Network Error') > -1) {
          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요.')
        } else {
          alert('실패')
        }
      }
    },

    goToPages1() {
      this.$router.push({
        // path: './write',
        name: 'Login'
      })
    }
  }
  ,

  computed: {
    ...mapGetters({
      errorState: 'getErrorState'
    })
  }
}

</script>

<style scoped>

  .bg-light{
    height: 1053px;
    padding-top:55px;
    padding-bottom:75px;
  }

  .flex-fill.mx-xl-5.mb-2{
    margin: 0 auto;
    width : 700px;
    padding-right: 7rem;
    padding-left: 7rem;
  }

  .container.py-4{
    margin: 0 auto;
    width : 503px;
    padding-top: 0;
  }

  .d-grid.gap-2{
    padding-top: 30px;
  }

  .bir_yy,.bir_mm,.bir_dd{
    width:160px;
    display:table-cell;
  }
  .bir_mm+.bir_dd, .bir_yy+.bir_mm{
    padding-left:10px;
  }
</style>