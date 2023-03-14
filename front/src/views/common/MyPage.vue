<template>

  <div id="findPw" class="modal fade" ref="myModal" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog-centered modal-login">
      <div class="modal-content">
        <div class="modal-body">
          <div class="container my-auto">
            <div class="row">
              <div class="card z-index-0 fadeIn3 fadeInBottom">
                <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                  <div class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1">
                    <h4 class="text-black font-weight-bolder text-center mt-2 mb-0">회원 탈퇴</h4>
                  </div>
                </div>
                <div class="card-body text-center">
                  <p >정말로 탈퇴하실건가요?.</p>
                  <!--                  <div class="input-group input-group-outline my-3">-->
                  <!--&lt;!&ndash;                    <label class="form-label">이름</label>&ndash;&gt;-->
                  <!--                    <input type="text" id="userName" name="userName" class="form-control" placeholder="이름" v-model="user_name" required>-->
                  <!--                  </div>-->
                  <div class="row text-center">
                    <button type="button" class="btn btn-secondary bg-gradient-primary my-4 mb-2"
                            data-bs-dismiss="modal" id="checkEmail" @click="fnDelete">확인</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
<!--                    <button type="button" class="btn btn-secondary" @click="closeModal">닫기</button>-->
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

    <div class=" text-center fs-1 fw-bold mb-2">
      <b style="color: black;">My Info</b>
    </div>

    <div class="container py-4">


      <!--      <div class="row align-items-center justify-content-between">-->
      <!--        <a class="navbar-brand h1 text-center" href="index.do">-->
      <!--          <span class="text-dark h4">도시</span> <span class="text-primary h4">거북</span>-->
      <!--        </a>-->
      <!--      </div>-->

      <form @submit.prevent="fnJoin" ref="form">

<!--        <div class="form-group has-success">-->

<!--          <label class="form-label mt-4" for="inputValid">비밀번호</label>-->
<!--          <div class="d-grid gap-2">-->
<!--            <router-link to="/pw_edit" class="btn btn-secondary" role="button">Edit</router-link>-->
<!--          </div>-->
<!--        </div>-->


        <div class="form-group">
          <label for="exampleInputId" class="form-label mt-4">아이디</label>
         <span type="text" class="form-control" id="exampleInputId">{{user_id}}</span>
<!--          <input type="text" class="form-control" id="exampleInputEmail1">-->
        </div>

        <div class="form-group has-success">

          <label class="form-label mt-4" for="inputValid">비밀번호</label>
          <div class="d-grid gap-2">
            <router-link to="/pw_edit" class="btn btn-secondary" role="button">Edit</router-link>
          </div>
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

        <div class="form-group mb-3">
          <label for="exampleInputAddr" class="form-label mt-4" >주소</label>
          <span type="text" class="form-control" id="exampleInputEmail1">{{user_addr}}</span>
<!--          <input type="text" class="form-control mb-4" id="exampleInputAddr" >-->
        </div>

        <div class="form-group" v-if="detail_addr !== ''">
          <label for="exampleInputDetailAddr" class="form-label mt-4">상세주소</label>
          <span type="text" class="form-control" id="exampleInputDetailAddr" >{{detail_addr}}</span>
          <!--          <input type="text" class="form-control mb-4" id="exampleInputAddr" >-->
        </div>


        <div class="d-grid gap-2">
          <router-link to="/myinfo_edit" class="btn btn-success" role="button">Edit My Info</router-link>
        </div>
        <div class="mt-2 text-end">
            <span type="button" class="btn btn-link a" data-bs-toggle="modal"
                  data-bs-target="#findPw">회원 탈퇴</span>
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
      showModal: false,
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
    closeModal() {
      this.$refs.myModal.classList.remove('show');
      //this.$refs.myModal.hide();
      this.showModal = false;
      location.reload()
    }

    ,fnDelete(){

      console.log("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
      this.$axios.delete(this.$serverUrl + '/user/' + this.user_idx, {})
          .then(() => {
            alert('회원탈퇴 되었습니다.')

            this.fnView();
            localStorage.removeItem("user_token")
            localStorage.removeItem("user_role")
            this.$store.state.isLogin = false
            setIsLogin(store, false)
          }).catch((err) => {
        console.log(err);
      })
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

    ,fnView(){
      this.$router.push({
        name: 'PageHome',
      })
    }

  }

}

</script>

<style>


</style>