<!-- PageHome.vue -->
<template>
  <div class="text-center mt-5">
    <i class="fa-regular fa-hospital fa-2xl mb-4"></i>
      <h3 class="fs-1 fw-bold text-center  mb-5"><b style="color: #4c1192">솔직한</b> 동물 병원 후기</h3>
  </div>

      <div >
        <div id="map" class="root_cacao_roughmap" style="width: 50rem; height: 50rem; position: center">

        </div>
      </div>

  <div class="container-fluid mt-3 pt-3" style="text-align: center">
    <!--    <img alt="Vue logo" src="../assets/logo.png">-->

    <div style="width: 960px; display: inline-block">
<!--      <h3 class="fs-1 fw-bold"><b style="color: #4c1192">솔직한</b> 동물 병원 후기</h3>-->
      <form action="" method="">

        <!--      <div class="mx-quto input-group mt-5">-->

        <!--/////////////////////////////////////////////////////////////////////////////////////////////////-->

<!--        <select v-model="search_key">-->
<!--          <option value="">- 선택 -</option>-->
<!--          <option value="author">작성자</option>-->
<!--          <option value="title">제목</option>-->
<!--          <option value="contents">내용</option>-->
<!--        </select>-->

<!--        <input type="text" class="ms-2" v-model="search_value" @keyup.enter="fnPage()">-->
<!--        <button @click="fnPage()" class="ms-2">검색</button>-->

        <!--/////////////////////////////////////////////////////////////////////////////////////////////////-->


        <div class=" mx-auto w-50 p-3 input-group input-group-lg">

          <select v-model="search_key">
            <option value="">- 선택 -</option>
            <option value="author">병원명</option>
            <option value="title">지역명</option>
          </select>

          <input type="text" class="form-control input-sm" placeholder="검색어 입력" aria-label="search"
                 aria-describedby="button-addon2" v-model="search_value" >

          <!--        <div class="col-xs-2">-->
          <!--          <label for="ex1">col-xs-2</label>-->
          <!--          <input class="form-control" id="ex1" type="text">-->
          <!--        </div>-->
          <!--        </mx-auto>-->

          <button class="btn btn-success" id="button-addon2"  @click="fnPage1(`${search_key}`,`${search_value}`)">검색</button>
        </div>


      </form>

      <div class="row text-left px-3" style="margin-top: 48px;">

        <div class="col-4 px-2">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location">
            </i>
            부천시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage(`범안로`)">
                범안로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('중동로')">
                중동로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('역곡로')">
                역곡로
              </div>
            </div>
          </div>
          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('상일로')">
                상일로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('소향로')">
                소향로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('송내대로')">
                송내대로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('부일로')">
                부일로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('원종로')">
                원종로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('상동로')">
                상동로
              </div>
            </div>
          </div>
        </div>

        <div class="col-4 px-2">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location" >
            </i>
            수원시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('권선구')">
                권선구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('영통로')">
                영통구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('장안구')">
                장안구
              </div>
            </div>
          </div>
          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('팔달구')">
                팔달구
              </div>
            </div>

          </div>
        </div>

        <div class="col-4 px-2">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location">
            </i>
            성남시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('수정구')">
                수정구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('분당구')">
                분당구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('중원구')">
                중원구
              </div>
            </div>
          </div>

        </div>

        <div class="col-4 px-2 mt-5">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location" >
            </i>
            용인시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('수지구')">
                수지구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('기훙구')">
                기흥구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('처안구')">
                처안구
              </div>
            </div>
          </div>
        </div>

        <div class="col-4 px-2 mt-5">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location">
            </i>
            시흥시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('수인로')">
                수인로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('배곧로')">
                배곧로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('일곶중앙로')">
                일곶중앙로
              </div>
            </div>
          </div>
          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('수인로')">
                수인로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('승지로')">
                승지로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('은행로')">
                은행로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('함송로')">
                함송로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('정왕대로')">
                정왕대로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('호현로')">
                호현로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('대야로')">
                대야로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('정왕천로')">
                정왕천로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('대은로')">
                대은로
              </div>
            </div>
          </div>
        </div>

        <div class="col-4 px-2 mt-5">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location">
            </i>
            안산시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('단원구')">
                단원구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1" @click="fnPage('상록구')">
                상록구
              </div>
            </div>
          </div>
        </div>
   </div>

      <div class="row text-left px-3" style="margin-top: 48px;">

      </div>
    </div>
  </div>

</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'PageHome',
  components: {
    HelloWorld
  },
  data() {
    return {
      map: null,
      markers: [],

      latitude: 0,
      longitude: 0,

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
  }
  ,created(){
    if (!("geolocation" in navigator)) {
      return;
    }

    // get position
    navigator.geolocation.getCurrentPosition(pos => {
      this.latitude = pos.coords.latitude;
      this.longitude = pos.coords.longitude;


      if (window.kakao && window.kakao.maps) {

        this.initMap();

      } else {
        const script = document.createElement("script");
        /* global kakao */
        script.onload = () => kakao.maps.load(this.initMap);
        script.src = "///dapi.kakao.com/v2/maps/sdk.js?appkey=30dca95cc43c45bd292179e1c3fb6fd6&autoload=false";
        document.head.appendChild(script);
      }

    }, err => {
      alert(err.message);
    })
  }

  ,methods: {
    initMap() {
      const map = document.getElementById("map")
      const options = {
        //center: new kakao.maps.LatLng(37, 131, 16),
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 5
      }
      this.map = new kakao.maps.Map(map, options)
      this.displayMarker([[this.latitude, this.longitude]]);

      // const marker1 = new kakao.maps.LatLng(37, 131)
      // const marker = new kakao.maps.Marker({
      //   position : marker1
      // })
      // marker.setMap(this.map)


    }
    , displayMarker(markerPositions) {
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      const positions = markerPositions.map(
          (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        this.markers = positions.map(
            (position) =>
                new kakao.maps.Marker({
                  map: this.map,
                  position,
                })
        );

        const bounds = positions.reduce(
            (bounds, latlng) => bounds.extend(latlng),
            new kakao.maps.LatLngBounds()
        );

        this.map.setBounds(bounds);
      }
    }
    ,fnGetList() {
      console.log(this.search_key)
      console.log("벨류확인" + this.search_value)

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

        // this.fnView()
        console.log(res.data.data);
        // console.log(res.data.pagination);

      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,fnPage(n) {
      console.log(n)
      this.search_value = n
      console.log(this.search_value)

      this.$router.push({
        path: '/hospital/list1',
        query:{
        //sk : "지역명",
        sv : this.search_value
        }
      })
    }


    // ,fnView() {
    //   //this.requestBody.idx = idx
    //   this.$router.push({
    //     path: '/hospital/list',
    //     query: this.requestBody
    //   })
    // }
    // ,fnPage(n) {
    //   if (this.page !== n) {
    //     this.page = n
    //   }
    //
    //   this.fnGetList()
    // }
    ,fnPage1(n,m) {
      console.log(n)
      this.search_value = n
      this.search_key = m
      console.log(this.search_value)

      this.$router.push({
        path: '/hospital/list',
        query:{
          sk : this.search_value,
          sv : this.search_key
        }
      })
    }

  }
  ,mounted() {
    // const script = document.createElement("script")
    // script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=30dca95cc43c45bd292179e1c3fb6fd6&autoload=false"
    // script.addEventListener("load", () => {
    //   kakao.maps.load(this.initMap)
    // })
    // document.head.appendChild(script)
  }
}


</script>

<style scoped>
.home {
  text-align: center;
  margin: 10px;
}

.root_cacao_roughmap {
  margin: auto !important;
}
</style>