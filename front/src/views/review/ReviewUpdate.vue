<template>

  <div class="wrap mt-5">
    <span><h3>{{hospital_name}} 후기 수정</h3></span>
    <form  enctype="multipart/form-data" method="post" id="revieform" class="reviewform">

      <p class="title_star">수정하실 별점을선택해주세요.</p>

      <div class="review_rating">
        <div class="warning_msg">별점을 선택해 주세요.</div>
        <div class="star-rating col-6">

          <input type="radio" id="5-stars" name="score" value="5" v-model="score"/>
          <label for="5-stars" class="star">&#9733;</label>

          <input type="radio" id="4-stars" name="score" value="4" v-model="score"  />
          <label for="4-stars" class="star">&#9733;</label>

          <input type="radio" id="3-stars" name="score" value="3" v-model="score"/>
          <label for="3-stars" class="star">&#9733;</label>

          <input type="radio" id="2-stars" name="score" value="2" v-model="score" />
          <label for="2-stars" class="star">&#9733;</label>

          <input type="radio" id="1-star" name="score" value="1" v-model="score"/>
          <label for="1-stars" class="star">&#9733;</label>
        </div>
      </div>

      <!--      <input type="text" name="content">-->
      <div class="review_contents mt-3">
        <div class="warning_msg">5자 이상으로 작성해 주세요.</div>
        <textarea rows="10" class="review_textarea" name="content" v-model="contents" ></textarea>
      </div>

      <h4>파일 업로드</h4>
      <input type="file" name="file" accept="image/*">

      <div class="common-buttons">
        <button type="button" class="btn btn-primary" @click="fnUpdate()">저장</button>
      </div>
    </form>
  </div>


</template>

<script>
export default {
  data() {
    return {
      requestBody: this.$route.query,
      pet_hospital_num: this.$route.query.hos_idx,
      review_idx:this.$route.query.rev_idx,
      user_idx: this.$store.state.userIdx,

      score:'',
      contents:'',
      hospital_name: '',

    };
  },
  mounted() {
    this.fnGetView()
    console.log("111@@@"+this.pet_hospital_num)
    console.log("222!!!"+this.review_idx)
  },

  methods:{
    fnUpdate(){
      if (!this.score) {
        alert("평점을 선택해주세요.")
        return false
      }
      if(!this.contents){
        alert("리뷰 내용을 입력해주세요.")
        return false
      }
      const formData = new FormData(document.getElementById("revieform"))
      formData.append('petHospitalNum',this.pet_hospital_num)
      formData.append('userNum',this.user_idx)
      formData.append('reviewId',this.review_idx)
      let apiUrl = this.$serverUrl + '/review'
      if (this.idx === undefined) {
        //INSERT
        this.$axios.patch(apiUrl, formData)
            .then((res) => {
              if(res.data.errorCode == 401){
                alert("올바른 이미지 파일을 등록해주세요.")
                return false
              }
              alert('글이 저장되었습니다.')
              this.fnView(this.pet_hospital_num)
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
   ,fnView(idx) {
      this.requestBody.idx = idx
      this.$router.push({
        path: '/hospital/detail',
        query: this.requestBody
      })
    }
    ,fnGetView() {
      this.$axios.get(this.$serverUrl + '/review/' + this.review_idx, {
        params: this.requestBody
      }).then((res) => {

        this.hospital_name = res.data.pet_hospital_name
        this.score = res.data.score
        this.contents = res.data.content

        console.log(this.hospital_name)
        console.log(this.score )
        console.log(this.contents )

      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
  }

};

</script>

<style>


</style>
