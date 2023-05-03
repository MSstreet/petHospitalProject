<template>
  <div class="mt-5 mb-5 text-center fs-1 fw-bold mb-2">
    <b style="color: #4c1192;">게시글 작성</b>
  </div>
  <div class="board-detail">


    <div class="board-contents">

      <div class="mb-3">
        <label for="title">제목</label>
        <input type="text" maxlength="200" v-model="title" class="form-control" name="title" id="title" placeholder="제목을 입력해주세요(200자 이내).">
      </div>

      <div class="mb-3">
        <label for="content">내용</label>
        <textarea class="form-control" maxlength="3000" v-model="contents" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요(3000자 이내)"></textarea>

      </div>
    </div>

    <div class="common-buttons">
      <button type="button" class="btn btn-primary " v-on:click="fnSave"><i class="fas fa-edit"></i>저장</button>&nbsp;
      <button type="button" class="btn btn-primary " v-on:click="fnList"><i class="fas fa-edit"></i>목록</button>
    </div>

  </div>
</template>

<script>


export default {
  data() { //변수생성
    return {
      requestBody: this.$route.query,

      idx: this.$route.query.idx,

      user_idx:this.$store.state.userIdx,

      title: '',
      author:'',
      contents: '',
      created_at: '',

      check:false
    }
  },
  mounted() {
    this.fnGetView()
    console.log(this.idx)
  },
  methods: {

    validCheck(){
      if (this.title == '') {
        alert('제목을 입력하세요.')
        this.check = false
        return false
      } else{
        this.check = true
      }

      if (this.contents == '') {
        alert('내용를 입력하세요.')
        this.check = false
        return
      } else{
        this.check = true
      }
    }

    ,fnGetView() {
      if (this.idx !== undefined) {
        this.$axios.get(this.$serverUrl + '/board/' + this.idx, {
          params: this.requestBody
        }).then((res) => {
          this.title = res.data.title
          this.author = res.data.author
          this.contents = res.data.contents
          this.created_at = res.data.created_at

          console.log("확인" + res.data)

        }).catch((err) => {
          console.log(err)
        })
      }
    }

    ,fnList() {
      delete this.requestBody.idx
      this.$router.push({
        path: './list',
        query: this.requestBody
      })
    }

    ,fnView(idx) {
      this.requestBody.idx = idx
      this.$router.push({
        path: './detail',
        query: this.requestBody
      })
    }

    ,fnSave() {
      this.validCheck()
      if(!(this.check)){
        return false
      }
      // this.contents.replace(/\n/g, '\u00A0')

      let apiUrl = this.$serverUrl + '/board'
      this.form = {
        "idx": this.idx,
        "title": this.title,
        "contents": this.contents,
        "author": this.author,
        "user_idx" :this.user_idx
      }

      if (this.idx === undefined) {
        //INSERT
        this.$axios.post(apiUrl, this.form)
            .then((res) => {
              alert('글이 저장되었습니다.')
              this.fnView(res.data.idx)
            }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })
      } else {
        //UPDATE
        this.$axios.patch(apiUrl, this.form)
            .then((res) => {
              alert('글이 저장되었습니다.')
              this.fnView(res.data.idx)
            }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })
      }
    }

  }
}
</script>
<style scoped>

</style>