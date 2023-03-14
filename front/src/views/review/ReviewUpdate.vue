<template>
  <div class="wrap mt-5">
    <span><h3>{{hospital_name}} 후기 수정</h3></span>
    <form  enctype="multipart/form-data" method="post" id="revieform" class="reviewform">
      <p class="title_star">수정하실 별점을 선택해주세요.</p>
      <div class="mb-2 row me-3">
        <div class="col-2">
          <div class="ms-3 mt-2 text-center font-weight-bold">가격</div>
        </div>
        <div class="col-10 review_rating">
          <div class="warning_msg">별점을 선택해 주세요.</div>
          <div class="star-rating-1 col-12">
            <input type="radio" id="5-stars-price" name="priceScore" v-model="priceScore" value="5" />
            <label for="5-stars-price" class="star">&#9733;</label>
            <input type="radio" id="4-stars-price" name="priceScore" v-model="priceScore" value="4" />
            <label for="4-stars-price" class="star">&#9733;</label>
            <input type="radio" id="3-stars-price" name="priceScore" v-model="priceScore" value="3" />
            <label for="3-stars-price" class="star">&#9733;</label>
            <input type="radio" id="2-stars-price" name="priceScore" v-model="priceScore" value="2" />
            <label for="2-stars-price" class="star">&#9733;</label>
            <input type="radio" id="1-stars-price" name="priceScore" v-model="priceScore" value="1" />
            <label for="1-stars-price" class="star">&#9733;</label>
          </div>
        </div>
      </div>

      <div class=" row me-3 mb-2">
        <div class="col-2">
          <div class="ms-3 mt-2 text-center font-weight-bold">친절</div>
        </div>
        <div class="col-10 review_rating">
          <div class="warning_msg">별점을 선택해 주세요.</div>
          <div class="star-rating-2 col-12">
            <input type="radio" id="5-stars-kindness" name="kindnessScore" v-model="kindnessScore" value="5" />
            <label for="5-stars-kindness" class="star">&#9733;</label>
            <input type="radio" id="4-stars-kindness" name="kindnessScore" v-model="kindnessScore" value="4" />
            <label for="4-stars-kindness" class="star">&#9733;</label>
            <input type="radio" id="3-stars-kindness" name="kindnessScore" v-model="kindnessScore" value="3" />
            <label for="3-stars-kindness" class="star">&#9733;</label>
            <input type="radio" id="2-stars-kindness" name="kindnessScore" v-model="kindnessScore" value="2" />
            <label for="2-stars-kindness" class="star">&#9733;</label>
            <input type="radio" id="1-stars-kindness" name="kindnessScore" v-model="kindnessScore" value="1" />
            <label for="1-stars-kindness" class="star">&#9733;</label>
          </div>
        </div>
      </div>

      <div class=" row me-3">
        <div class="col-2">
          <div class="ms-3 mt-2 text-center font-weight-bold">효과</div>
        </div>
        <div class="col-10 review_rating">
          <div class="warning_msg">별점을 선택해 주세요.</div>
          <div class="star-rating-3 col-12">
            <input type="radio" id="5-stars-effect" name="effectScore" v-model="effectScore" value="5" />
            <label for="5-stars-effect" class="star">&#9733;</label>
            <input type="radio" id="4-stars-effect" name="effectScore" v-model="effectScore" value="4" />
            <label for="4-stars-effect" class="star">&#9733;</label>
            <input type="radio" id="3-stars-effect" name="effectScore" v-model="effectScore" value="3" />
            <label for="3-stars-effect" class="star">&#9733;</label>
            <input type="radio" id="2-stars-effect" name="effectScore" v-model="effectScore" value="2" />
            <label for="2-stars-effect" class="star">&#9733;</label>
            <input type="radio" id="1-stars-effect" name="effectScore" v-model="effectScore" value="1" />
            <label for="1-stars-effect" class="star">&#9733;</label>
          </div>
        </div>
      </div>

      <div class="review_contents mt-3">
        <div class="warning_msg">5자 이상으로 작성해 주세요.</div>
        <textarea rows="10" class="review_textarea" name="content" v-model="contents" >
        </textarea>
      </div>

      <label className="input-file-button" for="input-file">
        영수증 업로드
      </label>
      <input type="file" name="file" id="input-file" accept="image/*" style="display: none">
      <div>
      기존 파일명 : {{original_file_name}}
      </div>
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

      priceScore:'',
      kindnessScore:'',
      effectScore:'',

      score:'',
      contents:'',
      hospital_name: '',
      file_name:'',
      original_file_name:''
    };
  },
  mounted() {
    this.fnGetView()
    console.log("111@@@"+this.pet_hospital_num)
    console.log("222!!!"+this.review_idx)
  },

  methods:{
    fnUpdate(){
      if (!this.priceScore) {
        alert("평점을 선택해주세요.")
        return false
      }
      if (!this.kindnessScore) {
        alert("평점을 선택해주세요.")
        return false
      }
      if (!this.effectScore) {
        alert("평점을 선택해주세요.")
        return false
      }
      if(!this.contents){
        alert("리뷰 내용을 입력해주세요.")
        return false
      }

      console.log(this.priceScore)
      console.log(this.kindnessScore)
      console.log(this.effectScore)


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
        this.file_name = res.data.file_name
        this.original_file_name = res.data.original_file_name
        console.log(res.data)


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

<style scoped>
.input-file-button{
  padding: 6px 25px;
  background-color:#FF6600;
  border-radius: 4px;
  color: white;
  cursor: pointer;
}

.star-rating-1 {
  border:solid 1px #ccc;
  display:flex;
  flex-direction: row-reverse;
  font-size:1.5em;
  justify-content:space-around;
  padding:0 .2em;
  text-align:center;
  width:5em;
}

.star-rating-1 input {
  display:none;
}

.star-rating-1 label {
  color:#ccc;
  cursor:pointer;
}

.star-rating-1 :checked ~ label {
  color:#f90;
}

.star-rating-1 label:hover,
.star-rating-1 label:hover ~ label {
  color:#fc0;
}

.star-rating-2 {
  border:solid 1px #ccc;
  display:flex;
  flex-direction: row-reverse;
  font-size:1.5em;
  justify-content:space-around;
  padding:0 .2em;
  text-align:center;
  width:5em;
}

.star-rating-2 input {
  display:none;
}

.star-rating-2 label {
  color:#ccc;
  cursor:pointer;
}

.star-rating-2 :checked ~ label {
  color:#f90;
}

.star-rating-2 label:hover,
.star-rating-2 label:hover ~ label {
  color:#fc0;
}

.star-rating-3 {
  border:solid 1px #ccc;
  display:flex;
  flex-direction: row-reverse;
  font-size:1.5em;
  justify-content:space-around;
  padding:0 .2em;
  text-align:center;
  width:5em;
}

.star-rating-3 input {
  display:none;
}

.star-rating-3 label {
  color:#ccc;
  cursor:pointer;
}

.star-rating-3 :checked ~ label {
  color:#f90;
}

.star-rating-3 label:hover,
.star-rating-3 label:hover ~ label {
  color:#fc0;
}
/* explanation */

article {
  background-color:#ffe;
  box-shadow:0 0 1em 1px rgba(0,0,0,.25);
  color:#006;
  font-family:cursive;
  font-style:italic;
  margin:4em;
  max-width:30em;
  padding:2em;
}
.wrap{
  max-width: 480px;
  margin: 0 auto; /* 화면 가운데로 */
  background-color: #fff;
  height: 100%;
  padding: 20px;
  box-sizing: border-box;

}
.reviewform textarea{
  width: 100%;
  padding: 10px;
  box-sizing: border-box;
}
.rating .rate_radio {
  position: relative;
  display: inline-block;
  z-index: 20;
  opacity: 0.001;
  width: 60px;
  height: 60px;
  background-color: #fff;
  cursor: pointer;
  vertical-align: top;
  display: none;
}
.rating .rate_radio + label {
  position: relative;
  display: inline-block;
  margin-left: -4px;
  z-index: 10;
  width: 60px;
  height: 60px;
  background-repeat: no-repeat;
  background-size: 60px 60px;
  cursor: pointer;
  background-color: #f0f0f0;
}
.rating .rate_radio:checked + label {
  background-color: #ff8;
}

.warning_msg {
  display: none;
  position: relative;
  text-align: center;
  background: #ffffff;
  line-height: 26px;
  width: 100%;
  color: red;
  padding: 10px;
  box-sizing: border-box;
  border: 1px solid #e0e0e0;
}


</style>
