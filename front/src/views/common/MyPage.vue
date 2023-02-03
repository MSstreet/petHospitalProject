<template>

  <section class="bg-light">

    <div class="container py-4">

      <!--      <div class="row align-items-center justify-content-between">-->
      <!--        <a class="navbar-brand h1 text-center" href="index.do">-->
      <!--          <span class="text-dark h4">도시</span> <span class="text-primary h4">거북</span>-->
      <!--        </a>-->
      <!--      </div>-->

      <form @submit.prevent="fnJoin" ref="form">


        <div class="form-group has-success">
          <label class="form-label mt-4" for="inputValid">비밀번호</label>
          <div class="d-grid gap-2">
            <router-link to="/pw_edit" class="btn btn-secondary" role="button">Edit</router-link>
          </div>
        </div>


        <div class="form-group">
          <label for="exampleInputEmail1" class="form-label mt-4">아이디</label>
          <input type="text" class="form-control" id="exampleInputEmail1">
        </div>


        <div class="form-group">
          <label for="exampleInputName" class="form-label mt-4">이름</label>
          <input type="text" class="form-control" id="exampleInputName" >
        </div>

        <div class="form-group">
          <label for="exampleInputNum" class="form-label mt-4">전화번호</label>
          <input type="text" class="form-control" id="exampleInputNum">
        </div>

        <div class="form-group">
          <label for="exampleInputAddr" class="form-label mt-4">주소</label>
          <input type="text" class="form-control mb-4" id="exampleInputAddr" >
        </div>


        <div class="d-grid gap-2">
          <router-link to="/mypage" class="btn btn-success" role="button">Edit My Info</router-link>
        </div>

      </form>
    </div>
  </section>

</template>

<script>






</script>

<style>


</style>