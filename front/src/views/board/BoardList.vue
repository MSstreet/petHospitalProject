<template>

  <div class="container-fluid px-4">

    <div >
      <h1  class="mt-5 mb-5 fs-1 fw-bold" style="text-align: center" @click="fnReload">자유게시판</h1>
    </div>



<!--    <div class="board-list">-->
    <div class="card mb-4 text-center">
      <div class="card-header">

<!--        <select v-model="search_key">-->
<!--          <option value="">- 선택 -</option>-->
<!--          <option value="author">작성자</option>-->
<!--          <option value="title">제목</option>-->
<!--          <option value="contents">내용</option>-->
<!--        </select>-->

<!--        <input type=" text" maxlength="50" class="ms-2" v-model="search_value" @keyup.enter="fnPage()">-->

<!--        <button @click="fnPage()" class="btn btn-success ms-2">검색</button>-->


        <div class="input-group input-group-sm search-pos" >
          <select v-model="search_key">
            <option value="title">제목</option>
            <option value="contents">내용</option>
          </select>

          <input type="text" maxlength="50"  placeholder="검색어 입력" aria-label="search"
                 aria-describedby="button-addon2" class="ms-1" v-model="search_value" @keyup.enter="fnPage()">
          <button @click="fnPage()" class="btn btn-success ms-1" id="button-addon2">검색</button>

        </div>

      </div>

      <div>
        <a class="btn btn-primary float-end me-2 mt-2" v-on:click="fnWrite"><i class="fas fa-edit"></i>  글 작성</a>
      </div>


      <div class="card-body">
        <div class="mb-3 test-position" v-if="list.length==0">
          <h3>조회하신 글을 찾을 수 없습니다.</h3>
        </div>

        <table v-if="list.length != 0" class="table table-hover table-striped">
          <thead>
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
<!--            <th>조회수</th>-->
            <th>작성일</th>
            <th>수정일</th>
          </tr>
          </thead>

          <tbody>



          <tr v-for="(row, idx) in list" :key="idx">

            <td>{{ row.idx }}</td>
            <td><a v-on:click="fnView(`${row.idx}`,`${row.user_idx}`)">{{ row.title }}</a></td>
            <td>{{ row.user_id }}</td>
            <td>{{ row.created_at }}</td>
            <td>{{ row.updated_at }}</td>
          </tr>
          </tbody>
        </table>

      </div>

<!--      <div>-->
<!--        <a class="btn btn-primary float-end me-3 mb-3" v-on:click="fnWrite"><i class="fas fa-edit"></i>  글 작성</a>-->
<!--      </div>-->

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

<!--      <div class="common-buttons">-->
<!--        <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnWrite">등록</button>-->
<!--      </div>-->


<!--      <table class="w3-table-all">-->
<!--        <thead>-->
<!--        <tr>-->
<!--          <th>No</th>-->
<!--          <th>제목</th>-->
<!--          <th>작성자</th>-->
<!--          <th>등록일시</th>-->
<!--        </tr>-->
<!--        </thead>-->
<!--        -->
<!--        <tbody>-->
<!--        <tr v-for="(row, idx) in list" :key="idx">-->
<!--          <td>{{ row.idx }}</td>-->
<!--          <td><a v-on:click="fnView(`${row.idx}`)">{{ row.title }}</a></td>-->
<!--          <td>{{ row.author }}</td>-->
<!--          <td>{{ row.created_at }}</td>-->
<!--        </tr>-->
<!--        </tbody>-->
<!--      </table>-->

<!--  <div class="">-->
<!--    <nav aria-label="Page navigation example" v-if="paging.total_list_cnt> 0">-->
<!--    <span class="center">-->
<!--      <ul class="pagination">-->

<!--        <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>-->

<!--         <a href="javascript:;" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>-->

<!--        <template v-for=" (n,index) in paginavigation()">-->
<!--            <template v-if="paging.page==n">-->
<!--              <li class="page-item" :key="index"> <a class="page-link"> {{ n }}</a> </li>-->
<!--            </template>-->

<!--            <template v-else>-->
<!--               <li class="page-item"> <a class="page-link" href="javascript:;" @click="fnPage(`${n}`)" :key="index"> {{ n }} </a> </li>-->
<!--            </template>-->
<!--        </template>-->

<!--         <a href="javascript:;" v-if="paging.total_page_cnt > paging.end_page"-->

<!--            @click="fnPage(`${paging.end_page+1}`)">&gt;</a>-->

<!--        <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(`${paging.total_page_cnt}`)">&gt;&gt;</a></li>-->
<!--      </ul>-->
<!--    </span>-->
<!--    </nav>-->
<!--  </div>-->



      <!--//////////////////////////////////////////////////////////////-->
<!--      <div class="pagination w3-bar w3-padding-16 w3-small" v-if="paging.total_list_cnt > 0">-->
<!--        <span class="pg">-->


<!--        <a href="javascript:;" @click="fnPage(1)" class="first w3-button w3-bar-item w3-border">&lt;&lt;</a>-->

<!--        <a href="javascript:;" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)"-->
<!--           class="prev w3-button w3-bar-item w3-border">&lt;</a>-->




<!--          <template v-for=" (n,index) in paginavigation()">-->
<!--            <template v-if="paging.page==n">-->

<!--                <strong class="w3-button w3-bar-item w3-border w3-green" :key="index">{{ n }}</strong>-->
<!--            </template>-->

<!--            <template v-else>-->
<!--                <a class="w3-button w3-bar-item w3-border" href="javascript:;" @click="fnPage(`${n}`)" :key="index">{{ n }}</a>-->
<!--            </template>-->
<!--        </template>-->
<!--          -->
<!--          <a href="javascript:;" v-if="paging.total_page_cnt > paging.end_page"-->
<!--           @click="fnPage(`${paging.end_page+1}`)" class="next w3-button w3-bar-item w3-border">&gt;</a>-->

<!--        <a href="javascript:;" @click="fnPage(`${paging.total_page_cnt}`)" class="last w3-button w3-bar-item w3-border">&gt;&gt;</a>-->
<!--        </span>-->
<!--      </div>-->


<!--      <div>-->
<!--        <select v-model="search_key">-->
<!--          <option value="">- 선택 -</option>-->
<!--          <option value="author">작성자</option>-->
<!--          <option value="title">제목</option>-->
<!--          <option value="contents">내용</option>-->
<!--        </select>-->

<!--        <input type="text" v-model="search_value" @keyup.enter="fnPage()">-->

<!--        <button @click="fnPage()">검색</button>-->
<!--      </div>-->


    </div>
<!--  </div>-->
</template>

<!--<script>-->
<!--export default {-->
<!--  data() { //변수생성-->
<!--    return {-->
<!--      requestBody: {}, //리스트 페이지 데이터전송-->
<!--      list: {}, //리스트 데이터-->
<!--      no: '', //게시판 숫자처리-->
<!--      paging: {-->
<!--        block: 0,-->
<!--        end_page: 0,-->
<!--        next_block: 0,-->
<!--        page: 0,-->
<!--        page_size: 0,-->
<!--        prev_block: 0,-->
<!--        start_index: 0,-->
<!--        start_page: 0,-->
<!--        total_block_cnt: 0,-->
<!--        total_list_cnt: 0,-->
<!--        total_page_cnt: 0,-->
<!--      }, //페이징 데이터-->
<!--      page: this.$route.query.page ? this.$route.query.page : 1,-->
<!--      size: this.$route.query.size ? this.$route.query.size : 10,-->
<!--      keyword: this.$route.query.keyword,-->
<!--      paginavigation: function () { //페이징 처리 for문 커스텀-->
<!--        let pageNumber = [] //;-->
<!--        let start_page = this.paging.start_page;-->
<!--        let end_page = this.paging.end_page;-->
<!--        for (let i = start_page; i <= end_page; i++) pageNumber.push(i);-->
<!--        return pageNumber;-->
<!--      }-->
<!--    }-->
<!--  },-->
<!--  mounted() {-->
<!--    this.fnGetList()-->
<!--  },-->
<!--  methods: {-->
<!--    fnGetList() {-->
<!--      this.requestBody = { // 데이터 전송-->
<!--        keyword: this.keyword,-->
<!--        page: this.page,-->
<!--        size: this.size-->
<!--      }-->

<!--      this.$axios.get(this.$serverUrl + "/board/list", {-->
<!--        params: this.requestBody,-->
<!--        headers: {}-->
<!--      }).then((res) => {-->

<!--        this.list = res.data  //서버에서 데이터를 목록으로 보내므로 바로 할당하여 사용할 수 있다.-->

<!--      }).catch((err) => {-->
<!--        if (err.message.indexOf('Network Error') > -1) {-->
<!--          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')-->
<!--        }-->
<!--      })-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

<!--<script>-->
<!--export default {-->
<!--  data() { //변수생성-->
<!--    return {-->
<!--      requestBody: {}, //리스트 페이지 데이터전송-->
<!--      list: {}, //리스트 데이터-->
<!--      no: '', //게시판 숫자처리-->
<!--      paging: {-->
<!--        block: 0,-->
<!--        end_page: 0,-->
<!--        next_block: 0,-->
<!--        page: 0,-->
<!--        page_size: 0,-->
<!--        prev_block: 0,-->
<!--        start_index: 0,-->
<!--        start_page: 0,-->
<!--        total_block_cnt: 0,-->
<!--        total_list_cnt: 0,-->
<!--        total_page_cnt: 0,-->
<!--      }, //페이징 데이터-->
<!--      page: this.$route.query.page ? this.$route.query.page : 1,-->
<!--      size: this.$route.query.size ? this.$route.query.size : 10,-->
<!--      keyword: this.$route.query.keyword,-->
<!--      paginavigation: function () { //페이징 처리 for문 커스텀-->
<!--        let pageNumber = [] //;-->
<!--        let start_page = this.paging.start_page;-->
<!--        let end_page = this.paging.end_page;-->
<!--        for (let i = start_page; i <= end_page; i++) pageNumber.push(i);-->
<!--        return pageNumber;-->
<!--      }-->
<!--    }-->
<!--  },-->
<!--  mounted() {-->
<!--    this.fnGetList()-->
<!--  },-->
<!--  methods: {-->
<!--    fnGetList() {-->
<!--      this.requestBody = { // 데이터 전송-->
<!--        keyword: this.keyword,-->
<!--        page: this.page,-->
<!--        size: this.size-->
<!--      }-->

<!--      this.$axios.get(this.$serverUrl + "/board/list", {-->
<!--        params: this.requestBody,-->
<!--        headers: {}-->
<!--      }).then((res) => {-->

<!--        if (res.data.result_code === "OK") {-->
<!--          this.list = res.data.data-->
<!--          this.paging = res.data.pagination-->
<!--          this.no = this.paging.total_list_cnt - ((this.paging.page - 1) * this.paging.page_size)-->
<!--        }-->

<!--        //this.list = res.data  //서버에서 데이터를 목록으로 보내므로 바로 할당하여 사용할 수 있다.-->

<!--      }).catch((err) => {-->
<!--        if (err.message.indexOf('Network Error') > -1) {-->
<!--          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')-->
<!--        }-->
<!--      })-->
<!--    },-->
<!--    fnView(idx) {-->
<!--      this.requestBody.idx = idx-->
<!--      this.$router.push({-->
<!--        path: './detail',-->
<!--        query: this.requestBody-->
<!--      })-->
<!--    },-->
<!--    fnWrite() {-->
<!--      this.$router.push({-->
<!--        path: './write'-->
<!--      })-->
<!--    },-->
<!--    fnPage(n) {-->
<!--      if (this.page !== n) {-->
<!--        this.page = n-->
<!--        this.fnGetList()-->
<!--      }-->
<!--    }-->
<!--  }-->
<!--}-->
<!--</script>-->

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

      this.$axios.get(this.$serverUrl + "/board/list", {
        params: this.requestBody,
        headers: {}
      }).then((res) => {

        if (res.data.result_code === "OK") {
          this.list = res.data.data
          this.paging = res.data.pagination
          this.no = this.paging.total_list_cnt - ((this.paging.page - 1) * this.paging.page_size)
        }

        console.log(res.data.data);
        // console.log(res.data.pagination);

      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },

    fnView(idx,user_idx) {
      this.requestBody.idx = idx
      this.requestBody.userIdx = user_idx
      this.$router.push({
        path: './detail',
        query: this.requestBody
      })
    }
    ,fnReload(){
      location.reload();
    }


    ,fnWrite() {
      this.$router.push({
        path: './write'
      })
    },

    fnPage(n) {
      if (this.page !== n) {
        this.page = n
      }

      this.fnGetList()
    }
  }
}
</script>

<style>
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
</style>

