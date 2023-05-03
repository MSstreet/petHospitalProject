<!-- PageHome.vue -->
<template>

<section class="bg-light">
  <div class="container text-center mt-5 " >
    <i class="fa-regular fa-hospital fa-2xl mb-4"></i>
    <h3 class=" fs-1 fw-bold text-center  mb-5"><b style="color: #4c1192;">솔직한</b> 동물 병원 후기</h3>

    <div id="mainslider" class="mt-3" >
      <splide :options="options">
<!--        <splide-slide>-->
<!--          <img  src="../assets/home.jpg" alt="main1">-->
<!--        </splide-slide>-->
        <splide-slide>
          <img style="border-radius: 70px" src="../assets/home.jpg" alt="main2">
        </splide-slide>
        <splide-slide>
          <img style="border-radius: 70px" src="../assets/home1.jpg" alt="main3">
        </splide-slide>
        <splide-slide>
          <img style="border-radius: 70px" src="../assets/home2.jpg" alt="main3">
        </splide-slide>
<!--        <splide-slide>-->
<!--          <img  src="../assets/animal5.png" alt="main3">-->
<!--        </splide-slide>-->
      </splide>
    </div>

  </div>

<!--        <div >-->
<!--          <div id="map" class="root_cacao_roughmap" style="width: 50rem; height: 50rem; position: center">-->

<!--          </div>-->
<!--        </div>-->



  <!--  <div >-->
  <!--    <div id="map" class="root_cacao_roughmap" style="width: 50rem; height: 50rem; position: center">-->

  <!--    </div>-->
  <!--  </div>-->

  <div class="container-fluid mt-3 pt-3 bg-light" style="text-align: center">
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
            <option value="author" selected>병원명</option>
<!--            <option value="" >-선택-</option>-->
<!--            <option value="author" >병원명</option>-->
            <option value="title">지역명</option>
          </select>

          <input type="text" maxlength="50" class="form-control input-sm ms-1" placeholder="검색어 입력" aria-label="search"
                 aria-describedby="button-addon2" v-model="search_value" >

          <button class="btn btn-success ms-1" id="button-addon2"  @click="fnPage1(`${search_key}`,`${search_value}`)">검색</button>
        </div>
      </form>

      <div class="row text-left px-3 margin-b" style="margin-top: 48px;">

        <div class="col-4 px-2">
          <div class=" pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location">
            </i>
            부천시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage(`범안로`,'title')">
                범안로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('중동로','title')">
                중동로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('역곡로','title')">
                역곡로
              </div>
            </div>
          </div>
          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('상일로','title')">
                상일로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('소향로','title')">
                소향로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('송내대로','title')">
                송내대로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('부일로','title')">
                부일로
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('상동로','title')">
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
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('권선구','title')">
                권선구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('영통로','title')">
                영통구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('장안구','title')">
                장안구
              </div>
            </div>
          </div>
          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('팔달구','title')">
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
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('수정구','title')">
                수정구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('분당구','title')">
                분당구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('중원구','title')">
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
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('수지구','title')">
                수지구
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
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('수인로','title')">
                수인로
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('승지로','title')">
                승지로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('은행로','title')">
                은행로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('함송로','title')">
                함송로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('정왕대로','title')">
                정왕대로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('호현로','title')">
                호현로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">


            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('대은로','title')">
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
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('단원구','title')">
                단원구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('상록구','title')">
                상록구
              </div>
            </div>
          </div>
        </div>

        <div class="col-4 px-2 mt-5">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location">
            </i>
            고양시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('덕양구','title')">
                덕양구
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('일산동구','title')">
                일산동구
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('일산서구','title')">
                일산서구
              </div>
            </div>
          </div>
        </div>

        <div class="col-4 px-2 mt-5">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location">
            </i>
            광명시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('광덕산로','title')">
                광덕산로
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('하안로','title')">
                하안로
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('디지털로','title')">
                디지털로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('소하로','title')">
                소하로
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('금하로','title')">
                금하로
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('오리로','title')">
                오리로
              </div>
            </div>
          </div>
        </div>



        <div class="col-4 px-2 mt-5">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location">
            </i>
            평택시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('송탄로','title')">
                송탄로
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('평택로','title')">
                평택로
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('탄현로','title')">
                탄현로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('청북읍','title')">
                청북읍
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('중앙로','title')">
                중앙로
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('서정역로','title')">
                서정역로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('송탄로','title')">
                송탄로
              </div>
            </div>

            <div class="col-4 p-0">
              <div class="fw-bold tt purple-link mb-1" @click="fnPage('안중읍','title')">
                안중읍
              </div>
            </div>


          </div>
        </div>
      </div>
      <div class="row text-left px-3" style="margin-top: 48px;">
      </div>
    </div>
  </div>
</section>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import { Splide, SplideSlide } from '@splidejs/vue-splide'
import '@splidejs/splide/dist/css/themes/splide-default.min.css';
export default {
  name: 'PageHome',
  components: {
    HelloWorld,
    Splide,
    SplideSlide
  },
  data() {
    return {
      options: {
        type: 'fade',
        rewind: true,
        perPage: 1,
        autoplay: true,
        pauseOnHover: false,
        arrows: false,
        dots: true,
        animatedDots: true
      }
      ,map: null,
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
      //search_key: this.$route.query.sk ? this.$route.query.sk : '',
      search_key:"author",
      //search_key:this.search_key,
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
    // if (!("geolocation" in navigator)) {
    //   return;
    // }
    // // get position
    // navigator.geolocation.getCurrentPosition(pos => {
    //   this.latitude = pos.coords.latitude;
    //   this.longitude = pos.coords.longitude;
    //   if (window.kakao && window.kakao.maps) {
    //     this.initMap();
    //   } else {
    //     const script = document.createElement("script");
    //     /* global kakao */
    //     script.onload = () => kakao.maps.load(this.initMap);
    //     script.src = "///dapi.kakao.com/v2/maps/sdk.js?appkey=30dca95cc43c45bd292179e1c3fb6fd6&autoload=false";
    //     document.head.appendChild(script);
    //   }
    // }, err => {
    //   alert(err.message);
    // })
  }
  ,methods: {
    // initMap() {
    //   const map = document.getElementById("map")
    //   const options = {
    //     //center: new kakao.maps.LatLng(37, 131, 16),
    //     center: new kakao.maps.LatLng(33.450701, 126.570667),
    //     level: 5
    //   }
    //   this.map = new kakao.maps.Map(map, options)
    //   this.displayMarker([[this.latitude, this.longitude]]);
    //   const marker1 = new kakao.maps.LatLng(37, 131)
    //   const marker = new kakao.maps.Marker({
    //     position : marker1
    //   })
    //   marker.setMap(this.map)
    // }
    // ,displayMarker(markerPositions) {
    //   if (this.markers.length > 0) {
    //     this.markers.forEach((marker) => marker.setMap(null));
    //   }
    //   const positions = markerPositions.map(
    //       (position) => new kakao.maps.LatLng(...position)
    //   );
    //   if (positions.length > 0) {
    //     this.markers = positions.map(
    //         (position) =>
    //             new kakao.maps.Marker({
    //               map: this.map,
    //               position,
    //             })
    //     );
    //     const bounds = positions.reduce(
    //         (bounds, latlng) => bounds.extend(latlng),
    //         new kakao.maps.LatLngBounds()
    //     );
    //     this.map.setBounds(bounds);
    //   }
    // }
    fnGetList() {
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
    ,fnPage(n,m) {
      console.log(n)
      this.search_key = m
      this.search_value = n
      console.log(this.search_value)
      this.$router.push({
        path: '/hospital/list1',
        query:{
          sk : this.search_key,
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
      console.log("@@@@@search_value@@@@@"+m)
      console.log("@@@@@search_key@@@@@"+n)
      this.search_value = m
      this.search_key = n
      console.log("!!!!!!!!!!search_value!!!!!!!!!!!"+this.search_value)
      this.$router.push({
        //path: '/hospital/list',
        path: '/hospital/list1',
        query:{
          sk :this.search_key,
          sv :this.search_value
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
  /*.img-size {*/
  /*  width: 300px;*/
  /*  height: 150px;*/
  /*  object-fit: cover;*/
  /*}*/
}
.test-position{
  display: flex;
  justify-content: center;
  align-items: center;
}
.img-container{
  height: 200px;
  width: 100%;
  /*margin: auto;*/
}
/*img{*/
/*  width: 100%;*/
/*  height: 50%;*/
/*}*/
.margin-b{
  margin-bottom: 7rem;
}
.root_cacao_roughmap {
  margin: auto !important;
}
.container {
  padding-right: 15px;
  padding-left: 15px;
  margin-right: auto;
  margin-left: auto;
}

/*.t{*/
/*  text-color: none;*/
/*}*/

/*.t:hover{*/
/*  text-decoration: underline;*/
/*  text-decoration-thickness: 1px;*/
/*  text-decoration-color: black;*/
/*  color: blue;*/
/*  cursor: pointer*/
/*}*/

.tt:hover{
  text-decoration: underline;
  text-decoration-thickness: 1px;
  text-decoration-color: #ff9900;
  color:#ff9900;
  cursor: pointer
}

</style>