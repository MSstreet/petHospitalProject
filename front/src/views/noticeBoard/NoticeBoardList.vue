<template>

  <div class="container-fluid px-4">

    <div >
      <h1  class="tt mt-5 mb-5 fs-1 fw-bold" style="text-align: center" @click="fnReload()">공지사항</h1>
    </div>

    <div class="card mb-4 text-center">
      <div class="card-header">

        <div class="input-group input-group-sm search-pos" >
          <select style="height: 2rem" v-model="search_key">
<!--            <option value="">- 선택 -</option>-->
            <option value="title" selected>제목</option>
            <option value="contents">내용</option>
          </select>
          <input style="border-width: 1px; height: 2rem" type="text" maxlength="50"  placeholder="검색어 입력" aria-label="search"
                 aria-describedby="button-addon2" class="ms-1" v-model="search_value" @keyup.enter="fnPage()">
          <button @click="fnPage()" class="btn btn-success ms-1" id="button-addon2">검색</button>
        </div>
      </div>

      <div class="card-body">


          <div class="mt-3 test-position" v-if="list.length==0">
            <h3>조회하신 글을 찾을 수 없습니다.</h3>
          </div>

        <table v-if="list.length!=0" class="table table-hover table-striped">
          <thead>
          <tr>
            <th>제목</th>
<!--            <th>내용</th>-->
            <th>작성일</th>
            <th>수정일</th>
          </tr>
          </thead>
          <tbody>

          <tr class="t1" v-for="(row, idx) in list" :key="idx">

            <td class="t"><a v-on:click="fnView(`${row.notice_board_idx}`)">{{ row.title }}</a></td>
<!--            <td>{{ row.contents }}</td>-->
            <td  width="20%" >{{ row.created_at }}</td>
            <td width="20%" >{{ row.updated_at }}</td>

          </tr>
          </tbody>
        </table>

      </div>

      <div class="test-position">
        <nav aria-label="Page navigation example" v-if="paging.total_list_cnt> 0">
    <span class="center">
      <ul class="pagination">

        <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>

         <a href="javascript:;" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>

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

         <a href="javascript:;" v-if="paging.total_page_cnt > paging.end_page"

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
      requestBody: {}, //리스트 페이지 데이터전송

      list: {}, //리스트 데이터
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

      page: this.$route.query.page ? this.$route.query.page : 1,
      size: this.$route.query.size ? this.$route.query.size : 10,

      //search_key: this.$route.query.sk ? this.$route.query.sk : '',
      search_key:"title",
      search_value: this.$route.query.sv ? this.$route.query.sv : '',

      paginavigation: function () { //페이징 처리 for문 커스텀
        let pageNumber = [] //;
        let start_page = this.paging.start_page;
        let end_page = this.paging.end_page;
        for (let i = start_page; i <= end_page; i++) pageNumber.push(i);
        return pageNumber;
      }
    }
  },
  mounted() {
    this.fnGetList()

  },
  methods: {
    fnGetList() {
      this.requestBody = { // 데이터 전송
        sk: this.search_key,
        sv: this.search_value,
        page: this.page,
        size: this.size
      }

      this.$axios.get(this.$serverUrl + "/notice/list", {
        params: this.requestBody,
        headers: {}
      }).then((res) => {

        if (res.data.result_code === "OK") {
          this.list = res.data.data
          this.paging = res.data.pagination
          this.no = this.paging.total_list_cnt - ((this.paging.page - 1) * this.paging.page_size)
        }
        console.log(res.data.data);

      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },

    fnView(idx) {
      this.requestBody.idx = idx
      //this.requestBody.userIdx = user_idx
      this.$router.push({
        path: './detail',
        query: this.requestBody
      })
    }
    ,fnPage(n) {
      if (this.page !== n) {
        this.page = n
      }

      this.fnGetList()
    }
    ,fnReload(){
      location.reload()
    }
  }
}
</script>

<style scoped>
.position-page2{
  position: relative;
  left:49rem;
}

.search-pos{
  display: flex;
  justify-content: center;
  align-items: center;
}

.test-position{
  display: flex;
  justify-content: center;
  align-items: center;
}

.t{
  text-color: none;
}

.t:hover{
  text-decoration: underline;
  text-decoration-thickness: 1px;
  text-decoration-color: black;

}

.t1:hover{
  /*background-color: blanchedalmond;*/
  background-color: beige;
}

.tt:hover{
  /*text-decoration: underline;*/
  /*text-decoration-thickness: 1px;*/
  /*text-decoration-color: #ff9900;*/
  /*color:#ff9900;*/
  /*color:blue;*/
  cursor: pointer
}
</style>

