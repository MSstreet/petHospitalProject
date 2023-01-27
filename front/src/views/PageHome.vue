<!-- PageHome.vue -->
<template>

  <div class="home">
<!--    <img alt="Vue logo" src="../assets/logo.png">-->
    <HelloWorld msg="가 본 사람들의 솔직한 동물병원 후기"/>

    <form action="" method="">

<!--      <div class="mx-quto input-group mt-5">-->
          <div class="mx-auto w-50 p-3 input-group input-group-lg mt-5">


          <input name="" type="text" class="form-control input-sm" placeholder="검색어 입력" aria-label="search" aria-describedby="button-addon2">

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
          서울
        </div>
        <div class="row mt-3 px-3">
          <div class="col-4 p-0">
            <div class="purple-link mb-1">
              강남구
            </div>
            <div class="purple-link mb-1">
              강남구
            </div>
            <div class="purple-link mb-1">
              강남구
            </div>
          </div>
        </div>
      </div>

    </div>

    <div class="row text-left px-3" style="margin-top: 48px;">


    </div>

    <div class="row text-left px-3" style="margin-top: 48px;">


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
  }
}
</script>

<style scoped>
  .home{
    text-align: center;
    margin: 10px;
  }

</style>