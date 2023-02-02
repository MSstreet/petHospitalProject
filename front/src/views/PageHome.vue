<!-- PageHome.vue -->
<template>
      <div >
        <div id="map" class="root_cacao_roughmap" style="width: 50rem; height: 50rem; position: center">


        </div>
      </div>

  <div class="container-fluid mt-3 pt-5" style="text-align: center">
    <!--    <img alt="Vue logo" src="../assets/logo.png">-->

    <div style="width: 960px; display: inline-block">
      <h3 class="fs-1 fw-bold"><b style="color: #4c1192">솔직한</b> 동물 병원 후기</h3>
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


        <div class="mx-auto w-50 p-3 input-group input-group-lg mt-5">
          <input name="" type="text" class="form-control input-sm" placeholder="검색어 입력" aria-label="search"
                 aria-describedby="button-addon2">

          <!--        <div class="col-xs-2">-->
          <!--          <label for="ex1">col-xs-2</label>-->
          <!--          <input class="form-control" id="ex1" type="text">-->
          <!--        </div>-->
          <!--        </mx-auto>-->
          <button class="btn btn-success" type="submit" id="button-addon2">검색</button>
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
              <div class="purple-link mb-1">
                범안로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                중동로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                역곡로
              </div>
            </div>
          </div>
          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                상일로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                소향로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                송내대로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                부일로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                원종로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                상동로
              </div>
            </div>
          </div>
        </div>

        <div class="col-4 px-2">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location">
            </i>
            수원시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                권선구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                영통구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                장안구
              </div>
            </div>
          </div>
          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
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
              <div class="purple-link mb-1">
                수정구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                분당구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                중원구
              </div>
            </div>
          </div>

        </div>

        <div class="col-4 px-2 mt-5">
          <div class="pb-2" style="font-size: 21px; color:#494949; border-bottom: 2px solid #494949">
            <i style="font-size: 21px;" class="fas fa-location">
            </i>
            용인시
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                수지구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                기흥구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
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
              <div class="purple-link mb-1">
                수인로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                배곧로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                일곶중앙로
              </div>
            </div>
          </div>
          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                수인로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                승지로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                은행로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                함송로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                정왕대로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                호현로
              </div>
            </div>
          </div>

          <div class="row mt-3 px-3">
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                대야로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
                정왕천로
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
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
              <div class="purple-link mb-1">
                단원구
              </div>
            </div>
            <div class="col-4 p-0">
              <div class="purple-link mb-1">
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
      map: null
    }
  },
  methods: {
    initMap() {
      const map = document.getElementById("map")
      const options = {
        center: new kakao.maps.LatLng(37, 131, 16),
        level: 5
      }
      this.map = new kakao.maps.Map(map, options)

      const marker1 = new kakao.maps.LatLng(37, 131)
      const marker = new kakao.maps.Marker({
        position : marker1
      })
      marker.setMap(this.map)
    }
  },
  mounted() {
    const script = document.createElement("script")
    script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=30dca95cc43c45bd292179e1c3fb6fd6&autoload=false"
    script.addEventListener("load", () => {
      kakao.maps.load(this.initMap)
    })
    document.head.appendChild(script)
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