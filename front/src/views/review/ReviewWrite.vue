<template>
  <div class="board-detail">

    <div class="star-rating">
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

    <div class="board-contents">
      <textarea id="" cols="30" rows="10" v-model="contents" class="" style="resize: none;">

      </textarea>
    </div>


    <div class="common-buttons">
      <button type="button" class="w3-button w3-round w3-blue-gray" v-on:click="fnSave">저장</button>&nbsp;
<!--      <button type="button" class="w3-button w3-round w3-gray" v-on:click="fnList">목록</button>-->
    </div>


  </div>
</template>

<script>
export default {
  data() {
    return {
      requestBody: this.$route.query,
      pet_hospital_num: this.$route.query.idx,
      score: 0,
      contents:''
    };
  },
  mounted() {
    //this.GetView()
    console.log(this.idx)
    console.log("check!!!!!" + this.pet_hospital_num)
  },

  methods:{
    fnSave() {
      let apiUrl = this.$serverUrl + '/review/join'

      this.form = {
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
</style>