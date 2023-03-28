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
                      <h4 class="text-black font-weight-bolder text-center mt-2 mb-0">댓글 수정</h4>
                    </div>
                  </div>

                  <div class="card-body text-center">
                    <div class="mb-2 form-group">
                      <label class="mb-1 fw-semibold" for="comment">Comment</label>
                      <textarea v-model="update_coments" class="form-control" id="comment" rows="3"></textarea>
                    </div>

                    <div>
                      <input type="hidden" v-model="m_reply_idx">
                    </div>

                    <div class="row text-center test-position">
                      <button type="button" class="me-1 text-center col-5 btn btn-secondary bg-gradient-primary my-4 mb-2" id="m_reply_idx"
                              data-bs-dismiss="modal" @click="fnComentUpdate()">확인</button>
                      <button type="button" class=" col-5 btn btn-secondary bg-gradient-primary my-4 mb-2" data-bs-dismiss="modal">닫기</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div id="findPw1" class="modal fade" ref="myModal" tabindex="-1" role="dialog">
      <div class="modal-dialog modal-dialog-centered modal-login">
        <div class="modal-content">
          <div class="modal-body">
            <div class="container my-auto">
              <div class="row">
                <div class="card z-index-0 fadeIn3 fadeInBottom">
                  <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
                    <div class="bg-gradient-primary shadow-primary border-radius-lg py-3 pe-1">
                      <h4 class="text-black font-weight-bolder text-center mt-2 mb-0">댓글에 답글</h4>
                    </div>
                  </div>

                  <div class="card-body text-center">
                    <div class="mb-2 form-group">
                      <label class="mb-1 fw-semibold" for="comment">Comment</label>
                      <textarea v-model="coments" class="form-control" id="comment" rows="3"></textarea>
                    </div>

                    <div>
                      <input type="hidden" v-model="m_reply_idx">
                    </div>

                    <div class="row text-center test-position">
                      <button type="button" class="me-1 text-center col-5 btn btn-secondary bg-gradient-primary my-4 mb-2" id="m_reply_idx"
                              data-bs-dismiss="modal" @click="fnSave()">확인</button>
                      <button type="button" class="col-5 btn btn-secondary bg-gradient-primary my-4 mb-2" data-bs-dismiss="modal">닫기</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  <div class="mt-5 text-center fs-1 fw-bold mb-2">
    <b style="color: #4c1192;">게시글 조회</b>
  </div>

  <div class="board-detail">
    <div class="board-contents">
      <div class="common-buttons pt-3 mb-3">
        <button type="button" class="btn btn-primary" v-if="logged_idx == writer_idx" v-on:click="fnUpdate">수정</button>&nbsp;
        <button type="button" class="btn btn-primary" v-if="logged_idx == writer_idx" v-on:click="fnDelete">삭제</button>&nbsp;
        <button type="button" class="btn btn-primary" data-bs-target="#findPw" v-on:click="fnList">목록</button>
      </div>

      <div class="border">
        <h3 class="my-3 ms-2" id="title">{{ title }}</h3>
         <div class="ms-2" style="font-weight: bold">작성자 : {{ writer_id }}</div>
        <span class="my-3 ms-2 mb-2" style="font-weight: bold">작성일 : {{ created_at }}</span>
      </div>
    </div>

    <div  class="board-contents pt-5 pb-5" >
     <div v-html="contents" ></div>
    </div>

      <div class="ms-1 row justify-content-center mt-5">
            <div class="card-body">
              <button type="submit" class="mb-2 float-end btn btn-success" @click="fnSave">저장</button>
                <div class="mb-2 form-group">
                  <label class="mb-1 fw-semibold" for="comment">Comment</label>
                  <textarea v-model="coments" maxlength="500" class="form-control" id="comment" rows="3"></textarea>
                </div>
            </div>
      </div>

    <label v-if="list.length != 0" class="mt-3 mb-2 ms-2 fw-semibold" for="comment">Comment List&nbsp({{paging.total_list_cnt}})</label>
      <div class="row" v-for="(row, idx) in list" :key="idx">
        <div class="col-12 mt-3 mb-2">
            <div class="ms-3  " style="word-break: break-all">
              <div class="row fs-5 mb-1">
                <div style="font-size: smaller;" class="fw-semibold">{{row.user_id}}</div>
                <div style="font-size: small;" class="fw-semibold">{{row.created_at}}</div>
              </div>

              <div>
                <button style="font-size: smaller;" class=" float-end btn btn-link" v-if="logged_idx == row.user_idx" v-on:click="fnComentDelete(`${row.reply_idx}`)">삭제</button>
                <button style="font-size: smaller;" class=" btn btn-link float-end"  data-bs-toggle="modal" data-bs-target="#findPw" v-if="logged_idx == row.user_idx" @click="testUpdate(`${row.reply_idx}`)">수정</button>
                <button style="font-size: smaller;" class="btn btn-link float-end" data-bs-toggle="modal" data-bs-target="#findPw1" @click="testUpdate(`${row.reply_idx}`)">답글</button>
              </div>

              <div>
                <div v-html="row.contents"></div>
              </div>
            </div>
        </div>

        <div class="row" v-for="(row1, idx1) in list1" :key="idx1">
          <div class="col-12">
            <div class="ms-5" style="word-break: break-all">
              <div class="row mb-1">
                <div v-if="row1.parent == row.reply_idx" style="font-size: medium ;" class="fw-semibold">{{row1.user_id}}</div>
                <div v-if="row1.parent == row.reply_idx" style="font-size: smaller ;" class="fw-semibold">{{row1.created_at}}</div>

                <div v-if="row1.parent == row.reply_idx" class="row">

                  <div class="col-11 ">
                    <div v-html="row1.contents"></div>
                  </div>

                  <div class="col-1" v-if="row1.parent == row.reply_idx">
                    <li class="nav-item dropdown">
                      <a class="nav-link" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        ***
                       </a>
                      <ul class="dropdown-menu dropdown-menu-end">
                        <li ><a data-bs-toggle="modal" data-bs-target="#findPw" @click="testUpdate(`${row1.reply_idx}`)" class=" dropdown-item" >수정&nbsp&nbsp<i class="fa-solid fa-pen"></i></a>
                        </li>

                        <li>
                          <a v-on:click="fnComentDelete(`${row1.reply_idx}`)" class=" dropdown-item" >삭제&nbsp&nbsp<i class="fa-solid fa-trash"></i></a>
                        </li>
                      </ul>
                    </li>
                  </div>
                </div>

              </div>

            </div>
          </div>
        </div>

      </div>

    <div class="test-position">
      <div >
        <nav aria-label="Page navigation example" v-if="paging.total_list_cnt > 0">
        <span class="center">
          <ul class="pagination">
            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>

            <a href="javascript:;" class="page-link" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>

            <template v-for=" (n,index) in paginavigation()">
                <template v-if="paging.page==n">
                  <div v-if="n == 2">
                  </div>
                  <li class="page-item active" :key="index"> <a class="page-link"> {{ n }}</a> </li>
                </template>

                <template v-else>
                   <li class="page-item"> <a class="page-link" href="javascript:;" @click="fnPage(`${n}`)" :key="index"> {{ n }} </a> </li>
                </template>
            </template>

             <a href="javascript:;" class="page-link" v-if="paging.total_page_cnt > paging.end_page"
                @click="fnPage(`${paging.end_page+1}`)">&gt;</a>
            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(`${paging.total_page_cnt}`)">&gt;&gt;</a></li>
          </ul>
        </span>
        </nav>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() { //변수생성
    return {
      showReply:false,

      requestBody: this.$route.query,
      idx: this.$route.query.idx,
      logged_idx: this.$store.state.userIdx,
      writer_idx:this.$route.query.userIdx,
      writer_id:this.$route.query.userId,

      title: '',
      author: '',
      contents: '',
      created_at: '',
      /////replyData
      coments:'',

      c_created_at:'',
      user_name:'',
      update_coments:'',
      reply_idx:'',

      m_reply_idx:'',

      list: {}, //리스트 데이터
      list1: {},
      no: '', //게시판 숫자처리
      paging: {
        block: 0,
        end_page: 0,
        next_block: 0,
        page: 0,
        page_size: 0,
        prev_block: 0,
        start_index: 0,
        start_page: 0,
        total_block_cnt: 0,
        total_list_cnt: 0,
        total_page_cnt: 0,
      }, //페이징 데이터
      page: 1,
      //page: this.$route.query.page ? this.$route.query.page : 1,
      size: this.$route.query.size ? this.$route.query.size : 10,
      search_key: this.$route.query.sk ? this.$route.query.sk : '',
      search_value: this.$route.query.sv ? this.$route.query.sv : '',

      paginavigation: function () { //페이징 처리 for문 커스텀
        let pageNumber = [] //;
        let start_page = this.paging.start_page;
        let end_page = this.paging.end_page;
        for (let i = start_page; i <= end_page; i++) pageNumber.push(i);
        return pageNumber;
      }
    }
  }
  ,mounted() {
    this.fnGetView()
    this.fnGetComent()
    this.fnGetComent1()
    console.log("글 번호>> : " + this.idx)
    console.log(this.logged_idx)
    console.log(this.writer_id)
  }
  ,methods: {
    fnGetView() {
      this.$axios.get(this.$serverUrl + '/board/' + this.idx, {
        params: this.requestBody
      }).then((res) => {
        this.title = res.data.title
        this.author = res.data.author
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
    ,fnUpdate() {
      this.requestBody.idx = this.idx
      this.$router.push({
        path: './update',
        query: this.requestBody
      })
    }
    ,fnDelete() {
      if (!confirm("삭제하시겠습니까?")) return

      this.$axios.delete(this.$serverUrl + '/board/' + this.idx, {})
          .then(() => {
            alert('삭제되었습니다.')
            this.fnList();
          }).catch((err) => {
        console.log(err);
      })
    }
    ,fnSave(){
      const input = document.getElementById("m_reply_idx").value
      this.reply_idx = input

      if(this.coments == ''){
        alert("댓글을 입력해주세요")
        return false
      }
      console.log("!!!!!!"+this.idx)
      console.log("@@@@@"+this.reply_idx)

      let apiUrl = this.$serverUrl + '/reply/join'
      this.form = {
        "parent" : this.reply_idx,
        "board_idx": this.idx,
        "user_idx": this.logged_idx,
        "contents": this.coments.replace(/\n/g, '<br/>')
      }
        //INSERT
        this.$axios.post(apiUrl, this.form)
            .then((res) => {
              alert('댓글이 저장되었습니다.')
              location.reload()
            }).catch((err) => {
          if (err.message.indexOf('Network Error') > -1) {
            alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
          }
        })

    }
    ,fnGetComent(){
      this.requestBody = { // 데이터 전송
        // sk: this.search_key,
        // sv: this.search_value,
        page: this.page,
        size: this.size
      }

      this.$axios.get(this.$serverUrl + '/reply/list/' + this.idx, {
        params: this.requestBody,
        headers: {}
      }).then((res) => {
        if (res.data.result_code === "OK") {
          this.list = res.data.data
          this.paging = res.data.pagination
          this.no = this.paging.total_list_cnt - ((this.paging.page - 1) * this.paging.page_size)
        }
        console.log(this.paging)
        console.log(this.list)
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,fnGetComent1(){
      this.requestBody = { // 데이터 전송
        // sk: this.search_key,
        // sv: this.search_value,
        page: this.page,
        size: this.size
      }
      this.$axios.get(this.$serverUrl + '/reply/list1/' + this.idx, {
        params: this.requestBody,
        headers: {}
      }).then((res) => {
        if (res.data.result_code === "OK") {
          this.list1 = res.data.data
        }
        console.log(res.data.data)
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,fnPage(n) {
      if (this.page !== n) {
        this.page = n
      }
      this.fnGetComent()
    }
    ,fnComentUpdate(){
      const input = document.getElementById("m_reply_idx").value

      this.reply_idx = input
      console.log("확인한다규~" +  this.reply_idx)
      console.log("확인한다규~" +  this.update_coments)

      let apiUrl = this.$serverUrl + '/reply'
      this.form = {
        "reply_idx":this.reply_idx,
        "board_idx": this.idx,
        "user_idx": this.logged_idx,
        "contents": this.update_coments
      }
      //INSERT
      this.$axios.patch(apiUrl, this.form)
          .then((res) => {
            alert('댓글이 저장되었습니다.')
            this.fnGetComent()
            this.fnGetComent1()
            this.update_coments = ''
          }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,fnComentDelete(idx){
      console.log(idx)
      if (!confirm("삭제하시겠습니까?")) return
      this.$axios.delete(this.$serverUrl + '/reply/' + idx, {})
          .then(() => {
            alert('삭제되었습니다.')
            this.fnGetComent()
            location.reload()
          }).catch((err) => {
        console.log(err);
      })
    }
    ,testUpdate(idx){
      console.log(idx)
      document.getElementById("m_reply_idx").value = idx
    }
  }
}
</script>

<style scoped>
.test-position{
  display: flex;
  justify-content: center;
  align-items: center;
}
li{
  list-style: none;
}
.align-end{
  align-self: flex-end;
}
.container{
  display: flex;
  flex-direction: column;
}
.test{
  display: none;
}
.child:hover + test{
  display: block;
}

</style>