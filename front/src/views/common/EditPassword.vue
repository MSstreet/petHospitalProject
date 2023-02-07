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
          <label class="form-label mt-4" for="inputValid">현재 비밀번호</label>
          <input type="password" class="form-control" id="inputValid">
          <div class="valid-feedback"></div>
        </div>


          <div class="form-group has-success">
            <label class="form-label mt-4" for="inputNewValid">새로운 비밀번호</label>
            <input type="password" class="form-control" id="inputNewValid">
            <div class="valid-feedback"></div>
          </div>

          <div class="form-group has-danger">
            <label class="form-label mt-4" for="inputInvalid">비밀번호 재확인</label>
            <input type="password" class="form-control" id="inputInvalid">
            <div class="invalid-feedback">비밀번호가 일치하지 않습니다</div>
          </div>
      </form>
    </div>
  </section>
</template>

<script>


</script>

<style>


</style>