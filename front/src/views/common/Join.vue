<template>
  <!--  배경색-->

  <div class="bg-light">
    <div class="container py-4 ">

      <h1 class="fs-1 fw-bold text-center mb-3"><b style="color: #4c1192">JOIN</b> </h1>

      <form @submit.prevent="fnJoin" ref="form">

        <div class="form-group">
          <label for="exampleInputId" class="form-label mt-4">아이디</label>
          <input type="text" maxlength="50" class="form-control" id="exampleInputId"  v-model="user_id" @change ="validIdCheck">
          <div id="checkId" class="mt-1"></div>

<!--           <button @click="fnPage()" class="btn btn-success" id="button-addon2">검색</button>-->
        </div>

        <div class="form-group">
          <label for="exampleInputEmail1" class="form-label mt-4">Email</label>
          <input type="text" maxlength="50" class="form-control" id="exampleInputEmail1" v-model="user_email" @change="validEmailCheck">
          <div id="checkEmail" class="mt-1"></div>
        </div>


        <div class="form-group has-success">
          <label class="form-label mt-4" for="inputValid">비밀번호</label>
          <input type="password" maxlength="20" class="form-control" id="inputValid" v-model="user_pw" @change="validPasswordCheck">
          <div id="checkPwd" class="mt-1"></div>
<!--          <div class="valid-feedback"></div>-->
        </div>


        <div class="form-group has-danger" id="inputInvalid">
          <label class="form-label mt-4" for="inputInvalid">비밀번호 재확인</label>
          <input type="password" maxlength="20" class="form-control"  v-model="pwd_check" @change="validSamePasswordCheck">
          <div id="doubleCheckPwd" class="mt-1"></div>
          <!--          <div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>-->
        </div>


        <div class="form-group">
          <label for="exampleInputName" class="form-label mt-4">이름</label>
          <input type="text" maxlength="20" class="form-control" id="exampleInputName" v-model="user_name" @change="validNameCheck">
          <div id="nameCheck" class="mt-1"></div>
        </div>


        <div class="form-group">
          <label for="exampleInputNum" class="form-label mt-4">전화번호</label>
          <input type="text" maxlength="20" class="form-control" id="exampleInputNum" v-model="user_num" @change="validNumCheck">
          <div id="numberCheck" class="mt-1"></div>
        </div>


        <div class="form-group">
          <label for="exampleInputZip" class="form-label mt-4">우편번호</label>
          <input type="text" maxlength="20" v-model="postcode"  class="form-control mb-1" id="exampleInputZip">
          <!--          <div id="addrCheck" class=""></div>-->
        </div>

        <input type="button" class="btn btn-secondary" @click="execDaumPostcode()" value="우편번호 찾기"><br>


        <div class="form-group">
          <label for="exampleInputAddr" class="form-label mt-4">주소</label>
          <input type="text" maxlength="50" class="form-control mb-4" id="exampleInputAddr" v-model="address">
<!--          <div id="addrCheck" class=""></div>-->
        </div>

        <div class="form-group">
          <label for="exampleInputAddr" maxlength="50" class="form-label mt-4">상세주소</label>
          <input type="text" class="form-control mb-4" id="exampleInputAddr" v-model="extra_address">
          <!--          <div id="addrCheck" class=""></div>-->
        </div>

        <div class="d-grid gap-2">
          <button class="btn btn-primary btn-lg" type="submit">가입하기</button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import {mapActions, mapGetters} from 'vuex'   //vuex 추가

export default {
  data() {
    return {
      check : false,

      duplicated_check: false,
      duplicated_id_check: false,
      user_id: '',
      user_pw: '',
      pwd_check: '',
      user_name: '',
      user_num: '',

      user_email:'',

      user_addr: '',

      postcode:'',
      address: '',
      extra_address: ''


    }
  },
  methods: {
    ...mapActions(['join']),     //vuex/actions에 있는 login 함수

    async fnJoin() {       //async 함수로 변경
      console.log("@@@@@@@@@@@@@@@" + this.extra_address)
      this.submitCheck()

      if(!(this.check)){
        return false
      }

      if(!(this.duplicated_check)){
        alert("이미 등록된 Email입니다.")
        return false
      }

      if(!(this.duplicated_id_check)){
        alert("이미 등록된 ID입니다.")
        return false
      }

      try {
        let joinResult = await this.join( {
          user_id: this.user_id,
          user_pw: this.user_pw,
          user_name: this.user_name,
          // user_num: this.user_num,
          // user_addr: this.user_addr

          email:this.user_email,

          phone_num: this.user_num,
          zip_code: this.postcode,
          addr:this.address,
          detail_addr:this.extra_address
        })
        if (joinResult) {
          this.goToPages1()
          alert("가입이 완료되었습니다!")
        }
      }
      catch (err) {
        if (err.message.indexOf('Network Error') > -1) {
          alert('서버에 접속할 수 없습니다. 상태를 확인해주세요.')
        } else {
          alert('실패')
        }
      }
    }

    //ID체크
    ,validIdCheck(){
      const idCheck = new RegExp("^[A-Za-z0-9]{5,20}$")
      if (this.user_id !== '' && !idCheck.test(this.user_id)) {
        alert("ID는 5자 이상 20자리 이하의 영문과 숫자로 입력해주세요")
        document.getElementById('checkId').style.color="red"
        document.getElementById('checkId').innerHTML = " ID는 5자 이상 20자리 이하의 영문과 숫자로 입력해주세요";
        this.check = false
        console.log("!!!!!!!"+this.check)
        return
      }else{
        document.getElementById('checkId').style.color="black"
        document.getElementById('checkId').innerHTML = "";
        this.check = true
        console.log("!!!!!!!"+this.check)
        this.validIdDuplicationCheck()
        return
      }
    }
    //Email 체크
    ,validEmailCheck(){
      const emailCheck = new RegExp("^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
      if (this.user_email !== '' && !emailCheck.test(this.user_email)) {
        //alert('비밀번호 정규식에 맞지 않습니다.\n 최소 8 자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자가 포함되어야 합니다.')
        alert("올바른 이메일 형식이 아닙니다.")
        document.getElementById('checkEmail').style.color="red"
        document.getElementById('checkEmail').innerHTML = " 올바른 이메일 형식이 아닙니다.";
        this.check = false
        return
      }else{
        document.getElementById('checkEmail').style.color="black"
        document.getElementById('checkEmail').innerHTML = "";
        this.check = true

        this.validDuplicationEmailCheck()
        return
      }
    }
    //Email 중복 체크
    ,validDuplicationEmailCheck(){
      let apiUrl = this.$serverUrl + '/user/check/mail?email=' + this.user_email

      this.$axios.get(apiUrl, {
        params:{
          //email:this.user_email
        }
      }).then((res) => {
        //console.log(res.data)
        if(res.data === true){
          alert("이미 등록된 email입니다.")
          document.getElementById('checkEmail').style.color="red"
          document.getElementById('checkEmail').innerHTML = "이미 등록된 email입니다.";
          //this.check = false
          this.duplicated_check = false
          return
        }else{
          document.getElementById('checkEmail').style.color="black"
          document.getElementById('checkEmail').innerHTML = "";
          //this.check = true
          this.duplicated_check = true
        }
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1){
          alert('네크워크가 원활하지 않습니다. \n잠시 후 다시 시도해주세요.')
        }
      })
    }
    //ID 중복 체크
    ,validIdDuplicationCheck(){
      let apiUrl = this.$serverUrl + '/user/check?userId=' + this.user_id

      this.$axios.get(apiUrl, {
        params:{
          user_id:this.user_id
        }
      }).then((res) => {
        //console.log(res.data)
            if(res.data === true){
              document.getElementById('checkId').style.color="red"
              document.getElementById('checkId').innerHTML = "중복된 ID 입니다.";
              alert("중복된 ID 입니다.")
              this.duplicated_id_check = false
              console.log("아이디 중복 확인 :" + this.check)
            }else{
              document.getElementById('checkId').style.color="black"
              document.getElementById('checkId').innerHTML = "";
              this.duplicated_id_check = true
            }
          }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1){
            alert('네크워크가 원활하지 않습니다. \n잠시 후 다시 시도해주세요.')
          }
      })
    }
    //비밀번호 유효성 체크
    ,validPasswordCheck(){
      const pwCheck = new RegExp("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{10,20}$");
      if (this.user_pw !== '' && !pwCheck.test(this.user_pw)) {
        alert('비밀번호 정규식에 맞지 않습니다.\n 10 ~ 20자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자가 포함되어야 합니다.')
        document.getElementById('checkPwd').style.color="red"
        document.getElementById('checkPwd').innerHTML = " 10 ~ 20자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자가 포함되어야 합니다.";
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
      if (this.user_pw !== '' && this.pwd_check !== '' && this.user_pw !== this.pwd_check) {
        alert('비밀번호와 비밀번호 확인이 서로 맞지 않습니다.')
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
    //이름 유효성 검사
    ,validNameCheck(){
      const nameCheck = new RegExp("^[|가-힣]{2,20}");
      if (this.user_name !== '' && !nameCheck.test(this.user_name)) {
        alert('이름은 한글 입력로 최소 2자리 최대 20자리까지 입력 가능합니다.')
        document.getElementById('nameCheck').style.color="red"
        document.getElementById('nameCheck').innerHTML = " 이름은 한글 입력로 최소 2자리 최대 20자리까지 입력 가능합니다.";
        this.check = false
        return
      } else{
        document.getElementById('nameCheck').style.color="black"
        document.getElementById('nameCheck').innerHTML = "";
        this.check = true
        return
      }
    }

    //전화번호 유효성
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
        return
      }
    }
    //서브밋 체크
    ,submitCheck() {
      const idCheck = new RegExp("^[A-Za-z0-9]{5,20}$")
      const pwCheck = new RegExp("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{10,}$");
      const emailCheck = new RegExp("^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
      const numCheck = new RegExp("^(?:(010\\d{4})|(01[1|6|7|8|9]\\d{3,4}))(\\d{4})$")
      const nameCheck = new RegExp("^[|가-힣]{2,20}")

      if (this.user_id !== '' && !idCheck.test(this.user_id)) {
        document.getElementById('checkId').style.color="red"
        document.getElementById('checkId').innerHTML = " ID는 5자 이상 20자리 이하의 영문과 숫자로 입력해주세요";
        alert("ID는 5자 이상 20자리 이하의 영문과 숫자로 입력해주세요")
        this.check = false
        return
      }else{
        document.getElementById('checkId').style.color="black"
        document.getElementById('checkId').innerHTML = "";
        this.check = true
      }

      this.validIdDuplicationCheck()

      if (this.user_pw !== '' && !pwCheck.test(this.user_pw)) {
        alert('비밀번호 정규식에 맞지 않습니다.\n 10~20자, 하나 이상의 대문자, 하나의 소문자, 하나의 숫자 및 하나의 특수 문자가 포함되어야 합니다.')
        this.check = false
        return
      }else{
        this.check = true
      }

      if (this.user_email !== '' && !emailCheck.test(this.user_email)) {
        document.getElementById('checkEmail').style.color="red"
        document.getElementById('checkEmail').innerHTML = " 올바른 이메일 형식이 아닙니다.";
        alert(" 올바른 이메일 형식이 아닙니다.")
        this.check = false
        return
      }else{
        document.getElementById('checkEmail').style.color="black"
        document.getElementById('checkEmail').innerHTML = "";
        this.check = true
       //return
      }

      this.validDuplicationEmailCheck()

      if (this.user_pw !== '' && this.pwd_check !== '' && this.user_pw !== this.pwd_check) {
        alert('비밀번호와 비밀번호 확인이 서로 맞지 않습니다.')
        document.getElementById('checkEmail').style.color="red"
        document.getElementById('checkEmail').innerHTML = " 비밀번호와 비밀번호 확인이 서로 맞지 않습니다.";
        this.check = false
        return
      }else{
        this.check = true
      }

      if (this.user_name !== '' && !nameCheck.test(this.user_name)) {
        document.getElementById('nameCheck').style.color="red"
        document.getElementById('nameCheck').innerHTML = " 이름은 한글 입력로 최소 2자리 최대 20자리까지 입력 가능합니다.";
        alert('이름은 한글 입력로 최소 2자리 최대 20자리까지 입력 가능합니다.')
        this.check = false
        return
      } else{
        document.getElementById('nameCheck').style.color="black"
        document.getElementById('nameCheck').innerHTML = "";
        this.check = true
        //return
      }

      if (this.user_num !== '' && !numCheck.test(this.user_num)) {
        //alert('전화번호를 입력하세요.')
        alert('올바른 전화번호 형식이 아닙니다. 예와 같이 입력해주세요.\u00a0\u00a0\u00a0\u00a0\u00a0 ex)\u00a000011112222')
        document.getElementById('numberCheck').style.color="red"
        document.getElementById('numberCheck').innerHTML = "올바른 전화번호 형식이 아닙니다. 예와 같이 입력해주세요.\u00a0\u00a0\u00a0\u00a0\u00a0 ex)\u00a000011112222 ";
        this.check = false
        return
      } else{
        document.getElementById('numberCheck').style.color="black"
        document.getElementById('numberCheck').innerHTML = "";
        this.check = true
        //return
      }

      if (this.user_id == '') {
        alert('ID를 입력하세요.')
        this.check = false
        return
      } else{
        this.check = true
      }

      if (this.user_email == '') {
        alert('Email을 입력하세요.')
        this.check = false
        return
      } else{
        this.check = true
      }

      if (this.user_pw == '') {
        alert('비밀번호를 입력하세요.')
        this.check = false
        return
      } else{
        this.check = true
      }

      if (this.pwd_check == '') {
        alert('비밀번호 확인을 입력하세요.')
        this.check = false
        return
      } else{
        this.check = true
      }

      if (this.user_name == '') {
        alert('이름을 입력하세요.')
        this.check = false
        return
      } else{
        this.check = true
      }

      if(this.user_num == ''){
        alert('전화번호를 입력하세요')
        this.check = false
        return
      }else{
        this.check = true
      }

      if(this.postcode == ''){
        alert('우편번호를 입력하세요')
        this.check = false
        return
      }else{
        this.check = true
      }

      if(this.address == ''){
        alert('주소를 입력하세요')
        this.check = false
        return
      }else{
        this.check = true
      }

    }

    ,execDaumPostcode() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          if (this.extra_address !== "") {
            this.extra_address = "";
          }

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
    ,goToPages1() {
      this.$router.push({
        // path: './write',
        name: 'Login'
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

<style scoped>

.bg-light {
  height: 1053px;
  padding-top: 55px;
  padding-bottom: 75px;
}

.flex-fill.mx-xl-5.mb-2 {
  margin: 0 auto;
  width: 700px;
  padding-right: 7rem;
  padding-left: 7rem;
}

.container.py-4 {
  margin: 0 auto;
  width: 503px;
  padding-top: 0;
}

.d-grid.gap-2 {
  padding-top: 30px;
}

.bir_yy, .bir_mm, .bir_dd {
  width: 160px;
  display: table-cell;
}

.bir_mm + .bir_dd, .bir_yy + .bir_mm {
  padding-left: 10px;
}
</style>