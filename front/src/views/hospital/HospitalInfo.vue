<template>
  <div class="row mb-3 mt-2" style="width: 100%">

    <div class="col-6">
      <div id="map" class="root_cacao_roughmap" style="width: 27rem; height: 20rem; position: center">
      </div>
    </div>

    <div class="text-left info-pos col-6 mt-3">
      <div class="color49 mt-3" style="font-size: 14px; font-weight: 40; letter-spacing: -0.6px;">
        <div >
           <p class="text-title">주소</p>
        </div>

        <div>
          <p class="text-content">{{ addr }}</p>
        </div>
      </div>
      <div class="color49 mt-3" style="font-size: 14px; font-weight: 40; letter-spacing: -0.6px;">
        <div>
          <p class="text-title">전화번호</p>
        </div>

        <div>
          <p class="text-content">{{number }}</p>
        </div>

      </div>
    </div>

  </div>
</template>

<script>
export default {
  data() {
    return {

      requestBody: this.$route.query,
      idx: this.$route.query.idx,

      map: null,

      addr: '',
      number: '',
      hos_latitude: '',
      hos_longitude: ''

    }
  }
  , created() {
    this.fnGetView(this.settingMap)

  }

    // const script = document.createElement("script")
    // script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=30dca95cc43c45bd292179e1c3fb6fd6&autoload=false"
    //
    // script.addEventListener("load", () => {
    //   kakao.maps.load(this.initMap)
    // })
    // document.head.appendChild(script)
    //

    // if (window.kakao && window.kakao.maps) {
    //
    //   this.initMap();
    //
    // } else {
    //   const script = document.createElement("script");
    //   /* global kakao */
    //   script.onload = () => kakao.maps.load(this.initMap);
    //   script.src = "///dapi.kakao.com/v2/maps/sdk.js?appkey=30dca95cc43c45bd292179e1c3fb6fd6&autoload=false";
    //   document.head.appendChild(script);
    // }

    // const script = document.createElement("script")
    // script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=30dca95cc43c45bd292179e1c3fb6fd6&autoload=false"
    // script.addEventListener("load", () => {
    //   kakao.maps.load(this.initMap)
    // })
    // document.head.appendChild(script)

  ,methods: {
    initMap() {
      console.log(2)
      console.log("경도 : " + this.hos_latitude)
      console.log("위도 : " + this.hos_longitude)

      const map = document.getElementById("map")

      const options = {
        //center: new kakao.maps.LatLng(37.83010,127.51214),
        center: new kakao.maps.LatLng(this.hos_latitude,this.hos_longitude), //경도 위도 이렇게 받으니까 흰색화면 띄어지는거야
        level: 5
      }

      //this.map = new kakao.maps.Map(this.hos_latitude, this.hos_longitude)

      this.map = new kakao.maps.Map(map, options)
      //this.displayMakers(this.hos_latitude,this.hos_longitude)
      this.displayMakers(this.hos_latitude,this.hos_longitude)
     // const marker1 = new kakao.maps.LatLng(37.82618, 127.51352)

     //  const marker1 = new kakao.maps.LatLng(this.hos_latitude,this.hos_longitude)
     //
     //  const marker = new kakao.maps.Marker({
     //    position : marker1
     //  })
     //
     //  marker.setMap(this.map)

    }

    ,displayMakers(latitude , longitude){
      const marker1 = new kakao.maps.LatLng(latitude, longitude)
       const marker = new kakao.maps.Marker({
         position : marker1
       })
      marker.setMap(this.map)
    }

    ,fnGetView() {
      this.$axios.get(this.$serverUrl + '/hospital/' + this.idx, {
        params: this.requestBody
      }).then((res) => {
        this.addr = res.data.hospital_addr
        this.number = res.data.hospital_num

        this.hos_latitude = res.data.hos_latitude
        this.hos_longitude = res.data.hos_longitude

        console.log("!!!!!!!!"+res.data.hos_latitude)
        console.log(res.data.hos_longitude)
        const script = document.createElement("script")
        script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=2eba89360677e7a9e1a8ba734e3502d8&autoload=false"
        script.addEventListener("load", () => {
          kakao.maps.load(this.initMap)
        })
        document.head.appendChild(script)
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
      console.log(1)
    }

    ,fnTest(){

    }
  }
  ,mounted() {
     // this.fnGetView()

    // const script = document.createElement("script")
    // script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=2eba89360677e7a9e1a8ba734e3502d8&autoload=false"
    // script.addEventListener("load", () => {
    //   kakao.maps.load(this.initMap)
    // })
    // document.head.appendChild(script)




  }
}

</script>

<style>
.text-title{
  font-size: 1.8rem;
  font-weight: bold;
  color: black;
}
.text-content{
  font-size: 1.3rem;
  font-weight: bold;
  color: #d3d3d3;
}

</style>