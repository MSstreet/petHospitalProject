<template>

<div class="text-center">
  <div style="width: 960px; display: inline-block">
    <div class="row p-3">
      <div class="col-12 border-0">
          <div class=" ml-3 col-20 text-left d-flex align-items-center justify-content-between pt-2">
            <div style="font-weight: 300;">
              {{ addr1[1] }}
               >
              {{ addr1[2] }}
            </div>
          </div>

        <h1 class="name mt-2 my-1 d-flex align-items-center">{{hospital_name }}</h1>

        <div class="d-flex align-items-start py-2 color49 pb-1">
          <div class="review" style="position: relative; font-size: 1.5rem;letter-spacing: 1px;">

            <span class="mr-1" style="font-weight: 700;">{{hospital_score}}</span>
            | <span class="ml-1">리뷰 ({{review_count}})</span>

          </div>
        </div>


        <div class="pb-2 pt-2 btn-pos">
          <a class="btn btn-primary btn-lg" v-on:click="reviewWrite(`${hospital_id}`)"><i class="fas fa-edit"></i> 리뷰 남기기</a>
        </div>


<!--        <div class="text-left info-pos">-->
<!--          <div class="color49 mt-3" style="font-size: 14px; font-weight: 40; letter-spacing: -0.6px;">-->
<!--            여기다가 주소를 입력하면 되겠어-->
<!--          </div>-->
<!--          <div class="color49 mt-3" style="font-size: 14px; font-weight: 40; letter-spacing: -0.6px;">-->
<!--            여기다가 전화번호 입력하면 되겠어-->
<!--          </div>-->
<!--        </div>-->
      </div>
    </div>


    <div class="row border px-3 middle-tab" style="top:72px !important;">

      <div class="position">
        <button class="btn fs-3" @click="changeComponent('HospitalInfo')">병원 정보
        </button>
        <button class="btn fs-3" @click="changeComponent('ReviewDetail')">리뷰
        </button>
      </div>

      <keep-alive>
        <component v-bind:is="comp"></component>
      </keep-alive>
    </div>
  </div>
</div>
</template>

<script>
import ReviewDetail from "@/views/review/ReviewDetail";
import HospitalInfo from "@/views/hospital/HospitalInfo";

export default {
  components:{
    ReviewDetail,
    HospitalInfo
  },
  data(){
    return {
      comp:'HospitalInfo',

      requestBody: this.$route.query,

      idx: this.$route.query.idx,

      addr1:'',
      hospital_id:'',
      hospital_name: '',
      hospital_num: '',
      hospital_addr:'',
      sigun_name: '',
      oper_state: '',
      hospital_score:'',
      review_count:''

    }
  }
  , mounted() {
    this.fnGetView()
    // this.fnGetReviewAvg()
    // console.log("체크!!!!!!!!!" + this.idx)
  },
  methods:{
    changeComponent: function (componentName){
      this.comp = componentName
    }

    ,fnGetReviewAvg(){
      this.$axios.get(this.$serverUrl + '/review/avg/' +this.idx)
          .then((res) => {

            this.hospital_score = res.data

            console.log("확인!!!!!!!"+res.data)
            console.log(this.hospital_score)

      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }

    // fnView(idx) {
    //   this.requestBody.idx = idx
    //   this.$router.push({
    //     path: '/review/detail',
    //     query: this.requestBody
    //   })
    // },

    ,fnGetView() {
      this.$axios.get(this.$serverUrl + '/hospital/' + this.idx, {
        params: this.requestBody
      }).then((res) => {

        this.hospital_id = res.data.hospital_id
        this.hospital_name = res.data.hospital_name
        this.hospital_num = res.data.hospital_num
        this.hospital_addr = res.data.hospital_addr
        this.hospital_score = res.data.hospital_score
        this.sigun_name = res.data.sigun_name
        this.oper_state = res.data.oper_state
        this.review_count = res.data.review_count

        this.addr1 = this.hospital_addr.split(' ',3)

        console.log(this.hospital_name)
        console.log(this.hospital_id )

      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    },fnList() {
      delete this.requestBody.idx

      this.$router.push({
        path: './list',
        query: this.requestBody
      })
    },reviewWrite(idx){
      this.requestBody.idx = idx

      this.$router.push({
        path: '/review/write',
        query: this.requestBody
      })
    }

  }
}

</script>

<style>
  .review{
    left: 0.2rem;
  }
  .name{
    position: relative;
    right: 0.5rem;
    top: 0.2rem;
  }
  .position{
    display: flex;
    flex-direction:row;
    justify-content: space-evenly;
  }
  .btn-pos{
    text-align: left;
  }
  .info-pos{
    text-align: left;
  }

</style>