<template>

  <div class="board-detail">
    <div class=" text-center fs-1 fw-bold mt-5 mb-2">
      <b style="color: black;">공지사항</b>
    </div>

    <div class="board-contents">

      <h3 class=" mt-5" id="title">{{ title }}</h3>
      <span>{{ created_at }}</span>

    </div>

    <div class="board-contents pt-5 pb-5" >
      <div v-html="contents"></div>
    </div>

    <div class="common-buttons pt-5">

<!--      <button type="button" class="btn btn-primary" v-if="logged_idx == writer_idx" v-on:click="fnUpdate">수정</button>&nbsp;-->
<!--      <button type="button" class="btn btn-primary" v-if="logged_idx == writer_idx" v-on:click="fnDelete">삭제</button>&nbsp;-->

      <button type="button" class="btn btn-primary" v-on:click="fnList">목록</button>
    </div>


  </div>
</template>

<script>
export default {
  data() { //변수생성
    return {
      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      logged_idx: this.$store.state.userIdx,
      writer_idx:this.$route.query.userIdx,

      title: '',
      //author: '',
      contents: '',
      created_at: ''
    }
  }
  ,mounted() {
    this.fnGetView()
    console.log(this.logged_idx)
    console.log(this.writer_idx)
  }
  ,methods: {
    fnGetView() {
      this.$axios.get(this.$serverUrl + '/notice/' + this.idx, {
        params: this.requestBody
      }).then((res) => {
        this.title = res.data.title
        //this.author = res.data.author
        this.contents = res.data.contents.replace(/\n/g, '<br/>')
        this.created_at = res.data.created_at
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,fnList() {
      delete this.requestBody.idx

      this.$router.push({
        path: './list',
        query: this.requestBody
      })
    }
  }
}
</script>
<style scoped>


</style>