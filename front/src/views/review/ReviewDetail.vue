<template>
  <div class="mt-5 mb-3 pt-3 ">

    <div class="boarder">

      <div class="row px-3">

        <div class="col-4 px-3 pt-3 pb-0" style="border-right: solid 1px #e9e9e9; background-color: #f8f8f8">
          <div style="letter-spacing: -1.05px; text-align: center; color: #9b9b9b; font-size: 18px" class="mb-2">
            평점
          </div>
        </div>

          <div class="col-8 mr-3 ">
            <div class="align-items-center justify-content-between d-flex flex-colum">
              <div class="row my-1 text-nowrap">
                 <div class="col-7 p-0">
                   <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                   <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                   <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                   <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                   <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                 </div>
                </div>
              </div>
            </div>
        </div>

      </div>

      <div class="row mt-5 " v-for="(row, idx) in list" :key="idx">

        <div class="col-4 text-center">
            <h3>{{row.user_num}}</h3>

        </div>

        <div class="col-7 position_re">

          <div>
            <p>날짜</p>

          </div>

          <div>
            <p>{{row.content}}</p>

          </div>


        </div>
      </div>
<!--    <div class="position-re">-->
<!--      <div >-->
<!--        <nav aria-label="Page navigation example" v-if="paging.total_list_cnt > 0">-->
<!--        <span class="center">-->
<!--          <ul class="pagination">-->
<!--            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>-->

<!--            &lt;!&ndash;             <a href="javascript:;" class="page-link" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>&ndash;&gt;-->
<!--            <a href="javascript:;" class="page-link"  @click="fnPage(`${paging.start_page-1}`)">&lt;</a>-->
<!--            <template v-for=" (n,index) in paginavigation()">-->
<!--                <template v-if="paging.page==n">-->
<!--                  <li class="page-item" :key="index"> <a class="page-link"> {{ n }}</a> </li>-->
<!--                </template>-->

<!--                <template v-else>-->
<!--                   <li class="page-item"> <a class="page-link" href="javascript:;" @click="fnPage(`${n}`)" :key="index"> {{ n }} </a> </li>-->
<!--                </template>-->
<!--            </template>-->

<!--             <a href="javascript:;" class="page-link" v-if="paging.total_page_cnt > paging.end_page"-->
<!--                @click="fnPage(`${paging.end_page+1}`)">&gt;</a>-->
<!--            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(`${paging.total_page_cnt}`)">&gt;&gt;</a></li>-->
<!--          </ul>-->
<!--        </span>-->
<!--        </nav>-->
<!--      </div>-->
<!--    </div>-->
  </div>


  <div class="position-re">
    <div >
      <nav aria-label="Page navigation example" v-if="paging.total_list_cnt > 0">
        <span class="center">
          <ul class="pagination">
            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>

            <!--             <a href="javascript:;" class="page-link" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>-->
            <a href="javascript:;" class="page-link"  @click="fnPage(`${paging.start_page-1}`)">&lt;</a>
            <template v-for=" (n,index) in paginavigation()">
                <template v-if="paging.page==n">
                  <li class="page-item" :key="index"> <a class="page-link"> {{ n }}</a> </li>
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
<!--  <div style="position: center">-->
<!--    <div >-->
<!--      <nav aria-label="Page navigation example" v-if="paging.total_list_cnt > 0">-->
<!--        <span class="center">-->
<!--          <ul class="pagination">-->
<!--            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>-->

<!--            &lt;!&ndash;             <a href="javascript:;" class="page-link" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>&ndash;&gt;-->
<!--            <a href="javascript:;" class="page-link"  @click="fnPage(`${paging.start_page-1}`)">&lt;</a>-->
<!--            <template v-for=" (n,index) in paginavigation()">-->
<!--                <template v-if="paging.page==n">-->
<!--                  <li class="page-item" :key="index"> <a class="page-link"> {{ n }}</a> </li>-->
<!--                </template>-->

<!--                <template v-else>-->
<!--                   <li class="page-item"> <a class="page-link" href="javascript:;" @click="fnPage(`${n}`)" :key="index"> {{ n }} </a> </li>-->
<!--                </template>-->
<!--            </template>-->

<!--             <a href="javascript:;" class="page-link" v-if="paging.total_page_cnt > paging.end_page"-->
<!--                @click="fnPage(`${paging.end_page+1}`)">&gt;</a>-->
<!--            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(`${paging.total_page_cnt}`)">&gt;&gt;</a></li>-->
<!--          </ul>-->
<!--        </span>-->
<!--      </nav>-->
<!--    </div>-->
<!--  </div>-->


</template>

<script>


export default {
  data() { //변수생성
    return {

      idx:this.$route.query.idx,

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
    console.log("확인" + this.idx)
  },
  methods: {
    fnPage(n) {
      if (this.page !== n) {
        this.page = n
      }

      this.fnGetList()
    },
    fnGetList() {
      this.requestBody = { // 데이터 전송
        // sk: this.search_key,
        // sv: this.search_value,
        page: this.page,
        size: this.size

      }

      this.$axios.get(this.$serverUrl + '/review/list/'+ this.idx, {
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
    }
}
}


</script>

<style>
 .position_re{
   text-align: left;
 }
 .star-pos{
   text-align: center !important;
 }

 .position-re{
   position: relative;
   left:15rem;
 }
</style>