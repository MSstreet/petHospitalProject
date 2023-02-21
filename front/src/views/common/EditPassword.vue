<template>
  <section class="bg-light">

    <div class="container py-4">

        <div class="form-group has-success">
          <label class="form-label mt-4" for="inputValid">현재 비밀번호</label>
          <input type="password" class="form-control" id="inputValid" v-model="password" >
<!--          <div class="valid-feedback"></div>-->
        </div>

          <div class="form-group has-success">
            <label class="form-label mt-4" for="inputNewValid">새로운 비밀번호</label>
            <input type="password" class="form-control" id="inputNewValid" v-model="new_password" @change="validPasswordCheck">
            <div id="checkPwd" class="mt-1"></div>
          </div>

          <div class="form-group has-danger">
            <label class="form-label mt-4" for="inputInvalid">비밀번호 재확인</label>
            <input type="password" class="form-control" id="inputInvalid" v-model="new_check" @change="validSamePasswordCheck">
            <div id="doubleCheckPwd" class="mt-1"></div>
          </div>

<!--      <div class="d-grid gap-2 mt-5">-->
<!--        <router-link to="/mypage" class="btn btn-success" v-on:click="fnUpdate" role="button">저장</router-link>-->
<!--      </div>-->

      <div>
        <a class="btn btn-success float-end me-2 mt-2" v-on:click="fnUpdate"><i class="fas fa-edit"></i>  글 작성</a>
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
      new_check:''

    }
  }
  ,methods:{
    fnUpdate() {
      let apiUrl = this.$serverUrl + '/user/change-pw'

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
      const pwCheck = new RegExp("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
      if (this.new_password !== '' && !pwCheck.test(this.new_password)) {
        //alert('비밀번호 정규식에 맞지 않습니다.\n 최소 8 자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자가 포함되어야 합니다.')
        document.getElementById('checkPwd').style.color="red"
        document.getElementById('checkPwd').innerHTML = " 최소 8 자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자가 포함되어야 합니다.";
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

      console.log("!!!"+this.password)
      console.log("@@@"+this.new_check)
      if (this.new_password !== '' && this.new_check !== '' && this.new_password !== this.new_check) {
        //alert('비밀번호와 비밀번호 확인이 서로 맞지 않습니다.')
        document.getElementById('doubleCheckPwd').style.color="red"
        document.getElementById('doubleCheckPwd').innerHTML = " 비밀번호와 비밀번호 확인이 서로 맞지 않습니다.";
        this.check = false
        return
      }else{
        document.getElementById('doubleCheckPwd').style.color="black"
        document.getElementById('doubleCheckPwd').innerHTML = "";
        this.check = true
        return
      }
    }
    ,fnView() {
      this.$router.push({
        path: './mypage',
        query: this.requestBody
      })
    }
    // ,CheckPassword(){
    //   let apiUrl = this.$serverUrl + '/user/check?userId=' + this.user_id
    //
    //   this.$axios.get(apiUrl, {
    //     params:{
    //       user_id:this.user_id
    //     }
    //   }).then((res) => {
    //     //console.log(res.data)
    //     if(res.data === true){
    //       document.getElementById('checkId').style.color="red"
    //       document.getElementById('checkId').innerHTML = "중복된 ID 입니다.";
    //       this.duplicated_id_check = false
    //       console.log("아이디 중복 확인 :" + this.check)
    //     }else{
    //       document.getElementById('checkId').style.color="black"
    //       document.getElementById('checkId').innerHTML = "";
    //       this.duplicated_id_check = true
    //     }
    //   }).catch((err) => {
    //     if (err.message.indexOf('Network Error') > -1){
    //       alert('네크워크가 원활하지 않습니다. \n잠시 후 다시 시도해주세요.')
    //     }
    //   })
    // }
  }
}
</script>

<style>

</style>