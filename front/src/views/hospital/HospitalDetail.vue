<template>

  <div style="width: 960px; display: inline-block">
    <div class="row p-3">
      <div class="col-12 border-0">
          <div class=" ml-3 col-20 text-left d-flex align-items-center justify-content-between pt-2">
            <div style="font-weight: 300;">
              부천
               >
              중동로
            </div>
          </div>
        <h1 class="name mt-2 my-1 d-flex align-items-center">여기다가 이름</h1>
        <div class="d-flex align-items-start py-2 color49 pb-1">

          <div class="review" style="position: relative; font-size: 1.5rem;letter-spacing: 1px;">

            <span class="mr-1" style="font-weight: 700;">8.7</span>
            | <span class="ml-1">리뷰 (40)</span>

          </div>
        </div>

        <div class="pb-2 pt-2">
          <button type="button" class="btn btn-primary btn-lg">Primary</button>
        </div>

        <div class="text-left ">
          <div class="color49 mt-3" style="font-size: 14px; font-weight: 40; letter-spacing: -0.6px;">
            여기다가 주소를 입력하면 되겠어
          </div>
          <div class="color49 mt-3" style="font-size: 14px; font-weight: 40; letter-spacing: -0.6px;">
            여기다가 전화번호 입력하면 되겠어
          </div>
        </div>


      </div>
    </div>


    <div class="row border-top border-bottom px-3 middle-tab" style="top:72px !important;">
      <div>
        <button class="btn" @click="changeComponent('BoardDetail')">follower
        </button>
        <button class="btn" @click="changeComponent('BoardList')">follow
        </button>
      </div>
      <keep-alive>
        <component v-bind:is="comp"></component>
      </keep-alive>
    </div>


  </div>

</template>

<script>
import BoardDetail from "@/views/board/BoardDetail";
import BoardList from "@/views/board/BoardList";
export default {
  components:{
    BoardDetail,
    BoardList
  },
  data(){
    return {comp:'BoardList'}
  },
  methods:{
    changeComponent: function (componentName){
      this.comp = componentName
      console.log(this.comp)
    }
  }

}

</script>

<style>
  .review{
    left: 0.2rem;
  }
  .name{
    position: relative;
    right: 0.5rem;
    top: 0.2rem;
  }

</style>