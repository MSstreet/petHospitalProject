<template>
  <div class="row mb-3" style="width: 100%">
    <div class="col-6">
      <div id="map" class="root_cacao_roughmap" style="width: 30rem; height: 25rem; position: center">


      </div>
    </div>
    <div class="text-left info-pos col-6">
      <div class="color49 mt-3" style="font-size: 14px; font-weight: 40; letter-spacing: -0.6px;">
        여기다가 주소를 입력하면 되겠어
      </div>
      <div class="color49 mt-3" style="font-size: 14px; font-weight: 40; letter-spacing: -0.6px;">
        여기다가 전화번호 입력하면 되겠어
      </div>
    </div>

  </div>
</template>

<script>
export default{
  data(){
    return{
      map:null
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

<style>


</style>