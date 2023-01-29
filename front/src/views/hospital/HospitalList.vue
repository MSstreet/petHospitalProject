<template>
<div class="container center-block">
  <div class="container px-4 test-class" v-for="(row, idx) in list" :key="idx">
    <div  class="row mt-5">

      <div class="col-12">
          <div class="card mb-3" style="max-width: 450px;">
            <div class="row g-0">

<!--              <div class="col-md-4">-->
<!--                <img src="" class="img-fluid rounded-start" alt="">-->
<!--              </div>-->

              <div class="col-md-12">
                <div class="card-body">
                  <h5 class="card-title">{{ row.hospital_id}}</h5>
                  <p class="card-text mb-1">{{ row.hospital_num }}</p>
                  <p class="card-text mb-1">{{ row.hospital_sigun_name }}</p>
                  <p class="card-text mb-1">{{ row.hospital_addr }}</p>
                  <p class="card-text mb-1">{{ row.hospital_score }}</p>
                </div>
              </div>
            </div>
          </div>
        </div>

<!--      <div class="col-6">-->
<!--        <div class="card mb-3" style="max-width: 450px;">-->
<!--          <div class="row g-0">-->

<!--            <div class="col-md-4">-->
<!--              <img src="" class="img-fluid rounded-start" alt="">-->
<!--            </div>-->

<!--            <div class="col-md-8">-->
<!--              <div class="card-body">-->
<!--                <h5 class="card-title">{{ row.hospital_id}}</h5>-->
<!--                <p class="card-text mb-1">{{ row.hospital_num }}</p>-->
<!--                <p class="card-text mb-1">{{ row.hospital_sigun_name }}</p>-->
<!--                <p class="card-text mb-1">{{ row.hospital_addr }}</p>-->
<!--                <p class="card-text mb-1">{{ row.hospital_score }}</p>-->
<!--              </div>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->
<!--      </div>-->
   </div>
  </div>
</div>









<!--    <table class="table table-hover table-striped">-->

<!--      <thead>-->
<!--      <tr>-->
<!--        <th>글번호</th>-->
<!--        <th>제목</th>-->
<!--        <th>작성자</th>-->
<!--        &lt;!&ndash;            <th>조회수</th>&ndash;&gt;-->
<!--        <th>작성일</th>-->
<!--      </tr>-->
<!--      </thead>-->

<!--      <tbody>-->
<!--      <tr v-for="(row, idx) in list" :key="idx">-->

<!--        <td>{{ row.hospital_id }}</td>-->
<!--        <td><a v-on:click="fnView(`${row.idx}`)">{{ row.title }}</a></td>-->
<!--        <td>{{ row.author }}</td>-->
<!--        <td>{{ row.created_at }}</td>-->

<!--      </tr>-->
<!--      </tbody>-->
<!--    </table>-->











  <nav aria-label="Page navigation example" v-if="paging.total_list_cnt > 0">
    <span class="center">
      <ul class="pagination">
        <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>

         <a href="javascript:;" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>

        <template v-for=" (n,index) in paginavigation()">
            <template v-if="paging.page==n">
              <li class="page-item" :key="index"> <a class="page-link"> {{ n }}</a> </li>
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

      this.$axios.get(this.$serverUrl + "/hospital/list", {
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

    // fnView(idx) {
    //   this.requestBody.idx = idx
    //   this.$router.push({
    //     path: './detail',
    //     query: this.requestBody
    //   })
    // },
    //
    // fnWrite() {
    //   this.$router.push({
    //     path: './write'
    //   })
    // },
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
  ul {
    list-style:none;
    margin:0;
    padding:0;
  }

  li {
    margin: 0 0 0 0;
    padding: 0 0 0 0;
    border : 0;
    float: left;
  }

  .test-class {
    display: inline-block;
    width: 35rem !important;;
  }

</style>