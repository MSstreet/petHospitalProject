<template>

  <section class="bg-light">

    <div class="container py-4">

      <div class="form-group">
        <label for="exampleInputName" class="form-label mt-4">이름</label>
        <input type="text" class="form-control" id="exampleInputName"
                 v-model="user_name">
        <div id="nameCheck" class="mt-1"></div>
      </div>

      <div class="form-group">
        <label for="exampleInputEmail" class="form-label mt-4">EMAIL</label>
        <input type="text" class="form-control" id="exampleInputEmail"
               v-model="email">
        <div id="nameCheck" class="mt-1"></div>
      </div>


      <div class="d-grid gap-2 mt-5">
        <button class="btn btn-success" v-on:click="fnFind"> 찾기</button>
      </div>

    </div>
  </section>

</template>

<script>
import {mapGetters} from "vuex";
import store from "@/vuex/store";

export default {
  created() {

  }
  ,computed: {
    ...mapGetters({
      // userIdx : "getIsUserIdx"
    })
  }
  ,data() {
    return {
      requestBody: this.$route.query,

      user_idx: this.$store.state.userIdx,

      email:'',
      user_name: ''

    }
  }
  ,mounted() {
    //his.fnGetView()
    // console.log(this.$store.state.userIdx)
    // console.log(this.user_idx)
  }
  ,methods:{
    fnFind(){
      let apiUrl = this.$serverUrl + '/user/find'

      console.log(this.email)
      console.log(this.user_name)

      this.form = {
        "user_name": this.user_name,
        "email":this.email,

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
  }

}




</script>

<style>


</style>