<template>
  <section class="bg-light">

    <div class="container py-4">

      <h3 class="fs-2 fw-bold text-center mb-3">Change password</h3>

        <div class="form-group has-success">
          <label class="form-label mt-4" for="inputValid">현재 비밀번호</label>
          <input type="password" class="form-control" id="inputValid" maxlength="20" v-model="password" >

        </div>

          <div class="form-group has-success">
            <label class="form-label mt-4" for="inputNewValid">새로운 비밀번호</label>
            <input type="password" class="form-control" id="inputNewValid" maxlength="20" v-model="new_password" @change="validPasswordCheck">
            <div id="checkPwd" class="mt-1"></div>
          </div>

          <div class="form-group has-danger">
            <label class="form-label mt-4" for="inputInvalid">비밀번호 재확인</label>
            <input type="password" class="form-control" id="inputInvalid" maxlength="20" v-model="new_check" @change="validSamePasswordCheck">
            <div id="doubleCheckPwd" class="mt-1"></div>
          </div>

      <div>
        <a class="btn btn-success float-end me-2 mt-3" v-on:click="fnUpdate"><i class="fas fa-edit"></i> Confirm</a>
      </div>

    </div>
  </section>
</template>

<script>
import {mapGetters} from "vuex";

export default {
  computed: {
    ...mapGetters({
      // userIdx : "getIsUserIdx"
    })
  }
  ,data() {
    return {
      requestBody: this.$route.query,

      user_idx: this.$store.state.userIdx,

      password:'',
      new_password:'',
      new_check:'',

      check:''
    }
  }
  ,methods:{
    fnUpdate() {
      let apiUrl = this.$serverUrl + '/user/change-pw'

      this.updateCheck()
      if(!(this.check)){
        return false
      }

      this.form = {
        "idx": this.user_idx,
        "password":this.password,
        "new_password":this.new_password,
      }
      //UPDATE
      this.$axios.patch(apiUrl, this.form)
          .then((res) => {
            //this.fnView(res.data.idx)
            if(res.data == true){
              alert('정보가 수정되었습니다.')
              this.fnView()
            }else{
              alert('현재 비밀번호를 잘못입력하셨습니다.')
            }

          }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,validPasswordCheck(){
      const pwCheck = new RegExp("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{10,}$");
      if (this.new_password !== '' && !pwCheck.test(this.new_password)) {
        alert("10~ 20, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자가 포함되어야 합니다.")
        this.check = false
        return
      }else{
        document.getElementById('checkPwd').style.color="black"
        document.getElementById('checkPwd').innerHTML = "";
        this.check = true
        return
      }
    }
    //비밀번호 확인 체크
    ,validSamePasswordCheck(){
      if (this.new_password !== '' && this.new_check !== '' && this.new_password !== this.new_check) {
        alert("비밀번호와 비밀번호 확인이 서로 맞지 않습니다.")
        this.check = false
        return
      }else{
        this.check = true
        return
      }
    }
    ,updateCheck(){
      const pwCheck = new RegExp("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{10,}$");

      if (this.new_password !== '' && !pwCheck.test(this.new_password)) {
        alert(" 10~20자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자가 포함되어야 합니다.")
        this.check = false
        return
      }else{
        document.getElementById('checkPwd').style.color="black"
        document.getElementById('checkPwd').innerHTML = "";
        this.check = true
      }

      if (this.new_password !== '' && this.new_check !== '' && this.new_password !== this.new_check) {
        alert("비밀번호와 비밀번호 확인이 서로 맞지 않습니다.")
        this.check = false
        return
      }else{
        document.getElementById('doubleCheckPwd').style.color="black"
        document.getElementById('doubleCheckPwd').innerHTML = "";
        this.check = true

      }
    }
    ,fnView() {
      this.$router.push({
        path: './mypage',
        query: this.requestBody
      })
    }
  }
}
</script>

<style>

</style>