<template>

  <section class="bg-light">

    <div class="container py-4">


      <!--      <div class="row align-items-center justify-content-between">-->
      <!--        <a class="navbar-brand h1 text-center" href="index.do">-->
      <!--          <span class="text-dark h4">도시</span> <span class="text-primary h4">거북</span>-->
      <!--        </a>-->
      <!--      </div>-->

      <form @submit.prevent="fnJoin" ref="form">

        <div class="form-group has-success">

          <label class="form-label mt-4" for="inputValid">비밀번호</label>
          <div class="d-grid gap-2">
            <router-link to="/pw_edit" class="btn btn-secondary" role="button">Edit</router-link>
          </div>
        </div>


        <div class="form-group">
          <label for="exampleInputId" class="form-label mt-4">아이디</label>
         <span type="text" class="form-control" id="exampleInputId">{{user_id}}</span>
<!--          <input type="text" class="form-control" id="exampleInputEmail1">-->
        </div>


        <div class="form-group">
          <label for="exampleInputName" class="form-label mt-4">이름</label>
          <span type="text" class="form-control" id="exampleInputName">{{user_name}}</span>
          <!--          <input type="text" class="form-control" id="exampleInputName" >-->
        </div>

        <div class="form-group">
          <label for="exampleInputEmail" class="form-label mt-4">EMAIL</label>
          <span type="text" class="form-control" id="exampleInputEmail">{{email}}</span>
          <!--          <input type="text" class="form-control" id="exampleInputName" >-->
        </div>

        <div class="form-group">
          <label for="exampleInputNum" class="form-label mt-4">전화번호</label>
          <span type="text" class="form-control" id="exampleInputEmail1">{{user_num}}</span>
          <!--          <input type="text" class="form-control" id="exampleInputNum">-->
        </div>

        <div class="form-group">
          <label for="exampleInputZip" class="form-label mt-4">우편번호</label>
          <span type="text" class="form-control" id="exampleInputZip">{{zip_code}}</span>
          <!--          <input type="text" class="form-control mb-4" id="exampleInputAddr" >-->
        </div>

        <div class="form-group">
          <label for="exampleInputAddr" class="form-label mt-4">주소</label>
          <span type="text" class="form-control" id="exampleInputEmail1">{{user_addr}}</span>
<!--          <input type="text" class="form-control mb-4" id="exampleInputAddr" >-->
        </div>

        <div class="form-group" v-if="detail_addr !== null">
          <label for="exampleInputDetailAddr" class="form-label mt-4">상세주소</label>
          <span type="text" class="form-control" id="exampleInputDetailAddr" >{{detail_addr}}</span>
          <!--          <input type="text" class="form-control mb-4" id="exampleInputAddr" >-->
        </div>


        <div class="d-grid gap-2">
          <router-link to="/myinfo_edit" class="btn btn-success" role="button">Edit My Info</router-link>
        </div>
        <div class="mt-2 text-end" @click="fnBeforeDelete">
          회원탈퇴
        </div>

      </form>
    </div>
  </section>

</template>

<script>
import {mapGetters} from "vuex";
import store from "@/vuex/store";


export default {
  created() {

  },
  computed: {
    ...mapGetters({
      // userIdx : "getIsUserIdx"
    })
  },
  data() {
    return {
      requestBody: this.$route.query,

       user_idx: this.$store.state.userIdx,

      user_id: '',
      user_name: '',
      user_num: '',
      zip_code: '',
      user_addr: '',
      detail_addr:'',
      email:''
    }
  }
  ,mounted() {
    this.fnGetView()
    console.log(this.$store.state.userIdx)
    console.log(this.user_idx)
  }
  ,methods:{
    fnBeforeDelete(){
      
    }

    ,fnDelete(){

    }

    ,fnGetView() {
      this.$axios.get(this.$serverUrl + '/user/' + this.user_idx, {
        params: this.requestBody
      }).then((res) => {
        this.user_id = res.data.user_id
        this.user_name = res.data.user_name
        this.user_num = res.data.phone_num
        this.zip_code = res.data.zip_code
        this.user_addr = res.data.addr
        this.detail_addr = res.data.detail_addr
        this.email = res.data.email

        console.log(res.data)

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