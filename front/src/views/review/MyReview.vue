<template>
  <div class="mt-5 mb-3 pt-3 ">

<!--    <div class="boarder">-->
<!--      <div class="row px-3">-->

<!--        <div class="col-4 px-3 pt-3 pb-0" style="border-right: solid 1px #e9e9e9; background-color: #f8f8f8">-->
<!--          <div style="letter-spacing: -1.05px; text-align: center; color: #9b9b9b; font-size: 18px" class="mb-2">-->
<!--            평점-->
<!--          </div>-->
<!--        </div>-->

<!--        <div class="col-8 mr-3 ">-->
<!--          <div class="align-items-center justify-content-between d-flex flex-colum">-->
<!--            <div class="row my-1 text-nowrap">-->
<!--              <div class="col-7 p-0">-->
<!--                <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--              </div>-->
<!--            </div>-->
<!--          </div>-->
<!--        </div>-->

<!--      </div>-->
<!--    </div>-->

    <h3 class="fs-1 fw-bold text-center mb-5"> 나의 후기 목록</h3>

    <div class="container">
    <div class="row mt-3 border border-bottom-0" style="text-align: center" v-if="list.length > 0" v-for="(row, idx) in list" :key="idx">

      <div  class="col-5 text-center">
        <h3>{{row.hos_name}}</h3>

        <div class="star-position">
          <div v-if="row.score == 1 && row.approve_yn == 1" class="star-position" >
            <div class="text-center">
              <div class="row  ">
                <div class=" p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>


          <div v-if="row.score == 2 && row.approve_yn == 1">
            <div class="text-center">
              <div class="row  ">
                <div class=" p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>


          <div v-if="row.score == 3 && row.approve_yn == 1">
            <div class="text-center">
              <div class="row  ">
                <div class=" p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>

          <div v-if="row.score == 4 && row.approve_yn == 1">
            <div class="text-center">
              <div class="row  ">
                <div class=" p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">>
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>


          <div v-if="row.score == 5 && row.approve_yn == 1">
            <div class="text-center">
              <div class="row  ">
                <div class=" p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>

          <div v-else-if="row.tmp_score == 1 && row.approve_yn == 0">
            <div class="text-center">
              <div class="row  ">
                <div class=" p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>

          <div v-else-if="row.tmp_score == 2 && row.approve_yn == 0">
            <div class="text-center">
              <div class="row  ">
                <div class=" p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>

          <div v-else-if="row.tmp_score == 3 && row.approve_yn == 0">
            <div class="text-center">
              <div class="row  ">
                <div class=" p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>

          <div v-else-if="row.tmp_score == 4 && row.approve_yn == 0">
            <div class="text-center">
              <div class="row  ">
                <div class=" p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>

          <div v-else-if="row.tmp_score == 5 && row.approve_yn == 0">
            <div class="text-center">
              <div class="row  ">
                <div class=" p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>


      </div>


      </div>
      <div class="col-5 position_re">
        <div  class="mb-0 fw-semibold">
          <p>{{row.created_at}}</p>
        </div>

        <div class="fs-5" style="word-break: break-all">
          <div v-if="row.approve_yn==1" class="col-6 mb-1" style="size:1.5rem; background-color: #4c1192; width: 8rem; border-radius: 15px; color: white"> <i class="ms-1 fa-solid fa-check fa-lg"></i>
            <b>인증 완료</b>
          </div>
          <p>{{row.content}}</p>

        </div>

      </div>

      <div class="col-2 mt-3 text-end">
        <div class="mb-2">
          <button class="btn btn-success" v-on:click="fnDelete(`${row.review_id}`)">삭제</button>
        </div>
        <div class="mb-2">
          <button class="btn btn-success" v-on:click="fnUpdate(`${row.pet_hospital_num}`,`${row.review_id}`)">수정</button>
        </div>
<!--        <div class="col-6 mb-2" style="background-color: #4c1192;  border-radius: 15px; color: white"> <i class="fa-solid fa-check fa-lg"></i>-->
<!--          -->
<!--        </div>-->
      </div>

    </div>

    <div v-else>
<!--      <img :src="imageUrl" alt="My Image">-->
      <div class="text-center">
        <img  class="mt-5" src="../../assets/aaaaaa.png" alt="main3">
        <h3 class="mt-5">작성한 후기가 아직 없습니다.</h3>
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


  <div class="test-position mt-5">
    <div >
      <nav aria-label="Page navigation example" v-if="paging.total_list_cnt > 0">
        <span class="center">
          <ul class="pagination">
            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>

            <!--             <a href="javascript:;" class="page-link" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>-->
            <a href="javascript:;" class="page-link" v-if="paging.start_page > 10"  @click="fnPage(`${paging.start_page-1}`)">&lt;</a>
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

      imageUrl:'https://ibb.co/8zKKPQw',

      idx:this.$store.state.userIdx,
      review_id : '',


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
      this.$axios.get(this.$serverUrl + '/review/user/'+ this.idx, {
        params: this.requestBody,
        headers: {}
      }).then((res) => {

        if (res.data.result_code === "OK") {
          this.list = res.data.data
          this.paging = res.data.pagination
          this.no = this.paging.total_list_cnt - ((this.paging.page - 1) * this.paging.page_size)
        }
        this.review_id = res.data.data.review_id

        console.log("!!!!!!!!!review!!!!!!!!!!" + this.review_id)
        console.log(res.data.data);

      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,fnDelete(n) {
      if (!confirm("삭제하시겠습니까?")) return
      console.log(this.review_id)
      this.$axios.delete(this.$serverUrl + '/review/' + n, {})
          .then(() => {
            alert('삭제되었습니다.')
            this.fnGetList();
          }).catch((err) => {
        console.log(err);
      })
    }
    ,fnUpdate(hos_idx,rev_idx){
      console.log("hos_idx:" + hos_idx)
      console.log("rev_idx:" + rev_idx)

      this.requestBody.hos_idx = hos_idx
      this.requestBody.rev_idx = rev_idx

      this.$router.push({
        path: '/review/update',
        query: this.requestBody
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
.star-position{
  left: 3rem;
  right: 10rem;
}
.position-re{
  position: relative;
  left:50rem;
}
</style>