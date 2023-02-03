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
export default{
  data(){
    return{

      requestBody: this.$route.query,
      idx:this.$route.query.idx,

      map:null,

      addr:'',
      number:''
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
    },
    fnGetView() {
      this.$axios.get(this.$serverUrl + '/hospital/' + this.idx, {
        params: this.requestBody
      }).then((res) => {
        this.addr = res.data.hospital_addr
        this.number = res.data.hospital_num
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
  },
  mounted() {
    const script = document.createElement("script")
    script.src = "//dapi.kakao.com/v2/maps/sdk.js?appkey=30dca95cc43c45bd292179e1c3fb6fd6&autoload=false"
    script.addEventListener("load", () => {
      kakao.maps.load(this.initMap)
    })
    document.head.appendChild(script)

    this.fnGetView()

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