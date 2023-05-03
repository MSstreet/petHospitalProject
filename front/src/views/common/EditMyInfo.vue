<template>

  <section class="bg-light">

    <div class=" text-center fs-1 fw-bold mb-2">
      <b style="color: black;">Edit My Info</b>
    </div>

    <div class="container py-4">
        <div class="form-group">
          <label for="exampleInputName" class="form-label mt-4">이름</label>
                    <input type="text" class="form-control" id="exampleInputName"
                           :placeholder="user_name"  v-model="user_name" readonly style="background-color:lightgray">
          <div id="nameCheck" class="mt-1"></div>
        </div>

      <div class="form-group">
        <label for="exampleInputEmail" class="form-label mt-4">EMAIL</label>
        <input type="text" class="form-control" id="exampleInputEmail"
               :placeholder="email"  v-model="email" readonly style="background-color:lightgray">
        <div id="nameCheck" class="mt-1"></div>
      </div>

        <div class="form-group">
          <label for="exampleInputNum" class="form-label mt-4">전화번호</label>
                    <input type="text" class="form-control" id="exampleInputNum"
                    :placeholder="user_num" v-model="user_num"  @change="validNumCheck">
          <div id="numberCheck" class="mt-1"></div>
        </div>

        <div class="form-group">
          <label for="exampleInputZip" class="form-label mt-4">우편번호</label>

          <input type="text" v-model="postcode"  class="form-control mb-1" id="exampleInputZip"
                 :placeholder="postcode">
        </div>

        <input type="button" class="btn btn-secondary" @click="execDaumPostcode()" value="우편번호 찾기"><br>


        <div class="form-group">
          <label for="exampleInputAddr" class="form-label mt-4">주소</label>
          <input type="text" class="form-control mb-4" id="exampleInputAddr"
                 :placeholder="address" v-model="address">
        </div>

        <div class="form-group">
          <label for="exampleInputAddr" class="form-label mt-4">상세주소</label>
          <input type="text" class="form-control mb-4" id="exampleInputAddr" v-model="extra_address">
        </div>

        <div class="d-grid gap-2 mt-5">
          <router-link to="/myinfo_edit" class="btn btn-success" v-on:click="fnUpdate" role="button">저장</router-link>
        </div>
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

      email:'',

      user_name: '',
      user_num: '',

      zip_code: '',
      user_addr: '',
      detail_addr:'',

      postcode:'',
      address: '',
      extra_address: '',
      check:false
    }
  }
  ,mounted() {
    this.fnGetView()
    // console.log(this.$store.state.userIdx)
    // console.log(this.user_idx)
  }
  ,methods:{
    fnGetView() {
      this.$axios.get(this.$serverUrl + '/user/' + this.user_idx, {
        params: this.requestBody
      }).then((res) => {
        this.user_id = res.data.user_id
        this.user_name = res.data.user_name
        this.user_num = res.data.phone_num
        this.postcode = res.data.zip_code
        // this.user_addr = res.data.addr
        // this.detail_addr = res.data.detail_addr
        this.address = res.data.addr
        this.extra_address = res.data.detail_addr
        this.email = res.data.email

        console.log(res.data)

      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.extra_address !== "") {
            this.extra_address = "";
          }
          // console.log("화깅!!!"+data.userSelectedType)
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            this.address = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            this.address = data.jibunAddress;
          }


          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              this.extra_address += data.bname;
            }

            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              this.extra_address +=
                  this.extra_address !== ""
                      ? `, ${data.buildingName}`
                      : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (this.extra_address !== "") {
              this.extra_address = `(${this.extra_address})`;
            }
          } else {
            this.extra_address = "";
          }

          // 우편번호를 입력한다.
          this.postcode = data.zonecode;
        },
      }).open();
    }
    ,fnUpdate() {
      let apiUrl = this.$serverUrl + '/user/'
      this.updateCheck()
      if(!(this.check)){
        return false
      }

      this.form = {
        "user_id": this.user_id,
        "user_name":this.user_name,
        "idx": this.user_idx,
        "phone_num": this.user_num,
        "zip_code": this.postcode,
        "addr": this.address,
        "detail_addr" : this.extra_address,
        "email" : this.email
      }
        //UPDATE
        this.$axios.patch(apiUrl, this.form)
            .then((res) => {
              alert('정보가 수정되었습니다.')
              this.fnView(res.data.idx)
            }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })

    },fnView(idx) {
    this.requestBody.idx = idx
    this.$router.push({
      path: './mypage',
      query: this.requestBody
    })
  }
  ,validNumCheck(){
      const numCheck = new RegExp("^(?:(010\\d{4})|(01[1|6|7|8|9]\\d{3,4}))(\\d{4})$")

      if (this.user_num !== '' && !numCheck.test(this.user_num)) {
        alert('올바른 전화번호 형식이 아닙니다. 예와 같이 입력해주세요.\u00a0\u00a0\u00a0\u00a0\u00a0 ex)\u00a000011112222')
        document.getElementById('numberCheck').style.color="red"
        document.getElementById('numberCheck').innerHTML = "올바른 전화번호 형식이 아닙니다. 예와 같이 입력해주세요.\u00a0\u00a0\u00a0\u00a0\u00a0 ex)\u00a000011112222 ";
        this.check = false
        return
      } else{
        document.getElementById('numberCheck').style.color="black"
        document.getElementById('numberCheck').innerHTML = "";
        this.check = true
      }
    }
    ,updateCheck(){
      const numCheck = new RegExp("^(?:(010\\d{4})|(01[1|6|7|8|9]\\d{3,4}))(\\d{4})$")

      if (this.user_num == '') {
        alert('전화번호를 입력하세요.')
        this.check = false
        return
      } else{
        this.check = true
      }

      if (this.postcode == '') {
        alert('우편번호를 입력하세요.')
        this.check = false
        return
      } else{
        this.check = true
      }

      if (this.address == '') {
        alert('주소를 입력하세요.')
        this.check = false
        return
      } else{
        this.check = true
      }

      if (this.user_num !== '' && !numCheck.test(this.user_num)) {
        alert('올바른 전화번호 형식이 아닙니다. 예와 같이 입력해주세요.\u00a0\u00a0\u00a0\u00a0\u00a0 ex)\u00a000011112222')
        document.getElementById('numberCheck').style.color="red"
        document.getElementById('numberCheck').innerHTML = "올바른 전화번호 형식이 아닙니다. 예와 같이 입력해주세요.\u00a0\u00a0\u00a0\u00a0\u00a0 ex)\u00a000011112222 ";
        this.check = false
        return
      } else{
        document.getElementById('numberCheck').style.color="black"
        document.getElementById('numberCheck').innerHTML = "";
        this.check = true
      }
    }
  }

}

</script>

<style>


</style>