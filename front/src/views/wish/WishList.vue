<template>

  <div class="container text-center mt-5 mb-5">
    <h3 class="fs-1 fw-bold text-center mb-5"> 나의 찜 목록</h3>
      <div class="container px-4 test-class" v-if="list.length > 0" v-for="(row, idx) in list" :key="idx">
        <div  class="row mt-5">

          <div class="col-12">
            <div class="card mb-3" style="max-width: 450px;">
              <div class="row g-0">

                <div class="col-md-12">
                  <div class="card-body">
                    <h5 class="card-title"><a v-on:click="fnView(`${row.pet_hospital_num}`)">{{ row.hospital_name}}</a></h5>
                    <p class="card-text mb-1">{{ row.hospital_num }}</p>
                    <p class="card-text mb-1">{{ row.hospital_sigun_name }}</p>
                    <p class="card-text mb-1">{{ row.hospital_addr }}</p>
                    <p class="card-text mb-1"><i class="fa-solid fa-star"></i>&nbsp{{ row.hospital_score }}</p>

                    <button type="button" class="mt-0 mb-1 btn btn-success" @click="fnDeleteWish(`${row.wish_id}`)">찜삭제</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
<!--        <div>-->
<!--        <button type="button" class="mt-0 mb-4 btn btn-primary" v-on:click="fnList">목록</button>-->
<!--        </div>-->
      </div>

    <div v-else>
      <div class="text-center">
        <img  class="mt-5" src="../../assets/aaaaaa.png" alt="main3">
        <h3 class="mt-5">찜 목록이 아직 없습니다.</h3>
      </div>
    </div>

    <div class="test-position">
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

  </div>
</template>

<script>
export default {
  data() { //변수생성
    return {
      requestBody: {}, //리스트 페이지 데이터전송
      imageSource:'https://ibb.co/r0GvW3S',
      list: {}, //리스트 데이터\

      user_idx: this.$store.state.userIdx,
      // no: '', //게시판 숫자처리

      wish_idx:'',
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
  }
  ,mounted() {
    this.fnGetList()
  }
  ,methods: {

    fnDeleteWish(wish_idx){

      if (!confirm("삭제하시겠습니까?")) return

      console.log(wish_idx)

      this.$axios.get(this.$serverUrl + "/wish/change/" + wish_idx,{
        //params: this.requestBody,
        //headers: {}
      }).then((res) => {
        console.log(res.data)
        this.wish_state = res.data.wish_state1
        this.fnGetList()
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,fnGetList() {

      this.requestBody = { // 데이터 전송
        sk: this.search_key,
        sv: this.search_value,
        page: this.page,
        size: this.size
      }

      this.$axios.get(this.$serverUrl + "/wish/list/" + this.user_idx, {
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
    }

    ,fnView(idx) {
      this.requestBody.idx = idx
      this.$router.push({
        path: '/hospital/detail',
        query: this.requestBody
      })
    }

    ,fnPage(n) {
      if (this.page !== n) {
        this.page = n
      }
      this.fnGetList()
    }
  }



}
</script>

<style>
.test-class {
  display: inline-block;
  width: 35rem !important;;
}

</style>