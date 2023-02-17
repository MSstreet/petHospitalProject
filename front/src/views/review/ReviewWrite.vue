<template>

  <div class="wrap mt-5">
    <span><h3>{{hospital_name}} 후기</h3></span>
    <form name="reviewform" class="reviewform">

      <p class="title_star">별점과 리뷰를 남겨주세요.</p>

      <div class="review_rating">
        <div class="warning_msg">별점을 선택해 주세요.</div>
          <div class="star-rating col-6">
            <input type="radio" id="5-stars" name="rating" v-model="score" value="5" />
            <label for="5-stars" class="star">&#9733;</label>

            <input type="radio" id="4-stars" name="rating" v-model="score" value="4" />
            <label for="4-stars" class="star">&#9733;</label>

            <input type="radio" id="3-stars" name="rating" v-model="score" value="3" />
            <label for="3-stars" class="star">&#9733;</label>

            <input type="radio" id="2-stars" name="rating" v-model="score" value="2" />
            <label for="2-stars" class="star">&#9733;</label>

            <input type="radio" id="1-star" name="rating" v-model="score" value="1" />
            <label for="1-star" class="star">&#9733;</label>
          </div>
      </div>

      <div class="review_contents mt-3">
        <div class="warning_msg">5자 이상으로 작성해 주세요.</div>
        <textarea rows="10" class="review_textarea" v-model="contents"></textarea>
      </div>

      <div class="common-buttons">
              <button type="button" class="btn btn-primary" v-on:click="fnSave">저장</button>
      </div>

    </form>
  </div>

<!--  <div class="board-detail mt-5">-->
<!--  <div class="row">-->
<!--    <div class="mb-2 mt-3 col-6">-->
<!--      <h3 class="name mt-2 my-1 d-flex align-items-center font-weight-bold">{{hospital_name}}</h3>-->
<!--    </div>-->

<!--    <div class="star-rating col-6">-->
<!--      <input type="radio" id="5-stars" name="rating" v-model="score" value="5" />-->
<!--      <label for="5-stars" class="star">&#9733;</label>-->

<!--      <input type="radio" id="4-stars" name="rating" v-model="score" value="4" />-->
<!--      <label for="4-stars" class="star">&#9733;</label>-->

<!--      <input type="radio" id="3-stars" name="rating" v-model="score" value="3" />-->
<!--      <label for="3-stars" class="star">&#9733;</label>-->

<!--      <input type="radio" id="2-stars" name="rating" v-model="score" value="2" />-->
<!--      <label for="2-stars" class="star">&#9733;</label>-->

<!--      <input type="radio" id="1-star" name="rating" v-model="score" value="1" />-->
<!--      <label for="1-star" class="star">&#9733;</label>-->
<!--    </div>-->
<!--  </div>-->
<!--    <div class="form-control">-->
<!--      <textarea id="" cols="30" rows="10" v-model="contents" cstyle="resize: none;">-->
<!--      </textarea>-->
<!--    </div>-->

<!--    <div class="common-buttons">-->
<!--      <button type="button" class="btn btn-primary" v-on:click="fnSave">저장</button>&nbsp;-->
<!--&lt;!&ndash;      <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>&ndash;&gt;-->
<!--    </div>-->
<!--  </div>-->

</template>

<script>
export default {
  data() {
    return {
      requestBody: this.$route.query,
      pet_hospital_num: this.$route.query.idx,

      user_idx: this.$store.state.userIdx,
      score: 0,
      contents:'',

      addr1:'',
      hospital_id:'',
      hospital_name: '',
      hospital_num: '',
      hospital_addr:'',
      sigun_name: '',
      oper_state: '',
      hospital_score:'',
      review_count:''
    };
  },
  mounted() {
    //this.GetView()
    // console.log(this.idx)
    console.log("check체크!!!!!" + this.user_idx)
    console.log("check체크!!!!!" + this.user_idx)
    console.log(this.requestBody)
    this.fnGetView()
  },

  methods:{
    fnSave() {
      let apiUrl = this.$serverUrl + '/review/join'

      this.form = {
        "user_num" : this.user_idx,
        "pet_hospital_num": this.pet_hospital_num,
        "content": this.contents,
        "score": this.score
      }

      if (this.idx === undefined) {
        //INSERT
        this.$axios.post(apiUrl, this.form)
            .then((res) => {
              alert('글이 저장되었습니다.')
              this.fnView(res.data.pet_hospital_entity.hospital_id)
              //console.log("확인!!!"+res.data.pet_hospital_entity.hospital_id)
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
    }, fnView(idx) {
      this.requestBody.idx = idx
      this.$router.push({
        path: '/hospital/detail',
        query: this.requestBody
      })
    }
    ,fnGetView() {
      this.$axios.get(this.$serverUrl + '/hospital/' + this.pet_hospital_num, {
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
    }
  }

};


</script>

<style>

.star-rating {
  border:solid 1px #ccc;
  display:flex;
  flex-direction: row-reverse;
  font-size:1.5em;
  justify-content:space-around;
  padding:0 .2em;
  text-align:center;
  width:5em;
}

.star-rating input {
  display:none;
}

.star-rating label {
  color:#ccc;
  cursor:pointer;
}

.star-rating :checked ~ label {
  color:#f90;
}

.star-rating label:hover,
.star-rating label:hover ~ label {
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
/*.position{*/
/*  position: center;*/
/*}*/
</style>