<template>
  <div class="mt-5 mb-3 pt-3 ">

    <div class="boarder">


      <div class="row px-3">

        <div class="col-12 px-3 pt-3 pb-0 mb-3" style="text-align: center; border-right: solid 1px #e9e9e9; background-color: #f8f8f8">
          <div style="letter-spacing: -1.05px; text-align: center; color: #9b9b9b; font-size: 18px" class="mb-2">
            평점
          </div>
       <span v-if="hos_score < 1.5">
          <i class="fa-solid fa-star fa-lg"></i>
          <i class="fa-regular fa-star fa-lg"></i>
          <i class="fa-regular fa-star fa-lg"></i>
          <i class="fa-regular fa-star fa-lg"></i>
          <i class="fa-regular fa-star fa-lg"></i>
      </span>

          <span v-if="(hos_score >= 1.5 && hos_score < 2)">
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star-half-stroke fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
          </span>

          <span v-if="(hos_score >= 2 && hos_score < 2.5)">
               <i class="fa-solid fa-star fa-lg"></i>
               <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
          </span>

          <span v-if="(hos_score >= 2.5 && hos_score < 3)">
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star-half-stroke fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>

          </span>

          <span v-if="(hos_score >= 3 && hos_score < 3.5)">
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
          </span>

          <span v-if="(hos_score >= 3.5 && hos_score < 4)">
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star-half-stroke fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
          </span>

          <span v-if="(hos_score >= 4 && hos_score < 4.5)">
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-regular fa-star fa-lg"></i>
          </span>

          <span v-if="(hos_score >= 4.5 && hos_score < 5)">
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star-half-stroke fa-lg"></i>
          </span>

          <span v-if="(hos_score >= 4.8 && hos_score <= 5)">
            <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
              <i class="fa-solid fa-star fa-lg"></i>
             <i class="fa-solid fa-star fa-lg"></i>
         </span>




        </div>


        <div v-if="hos_score < 1.5">
          <div class="col-6 mr-3">
            <div class="align-items-center justify-content-between  flex-colum">
              <div class="row my-1 ">
                 <div class=" p-0">
<!--                   <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle star-size" >-->
<!--                   <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                   <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                   <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                   <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                   <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                   <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                   <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                   <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                   <i class="fa-solid fa-star-half-stroke"></i>-->
                 </div>
                </div>
              </div>
            </div>
        </div>

        <div v-if="(hos_score >= 1.5 && hos_score < 2)">
          <div class="col-6 mr-3">
            <div class="align-items-center justify-content-between  flex-colum">
              <div class="row my-1 ">
                <div class=" p-0">
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle star-size" >-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
                </div>
              </div>
            </div>
          </div>
        </div>

        <div v-if="(hos_score >= 2 && hos_score < 2.5)">
          <div class="col-6 mr-3">
            <div class="align-items-center justify-content-between  flex-colum">
              <div class="row my-1 ">
                <div class=" p-0">
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle " >-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
                </div>
              </div>
            </div>
          </div>
        </div>

        <div v-if="(hos_score >= 2.5 && hos_score < 3)">
          <div class="col-6 mr-3">
            <div class="align-items-center justify-content-between  flex-colum">
              <div class="row my-1 ">
                <div class=" p-0">
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle star-size" >-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
                </div>
              </div>
            </div>
          </div>
        </div>

        <div v-if="(hos_score >= 3 && hos_score < 3.5)">
          <div class="col-6 mr-3">
            <div class="align-items-center justify-content-between  flex-colum">
              <div class="row my-1 ">
                <div class=" p-0">
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle star-size" >-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
                </div>
              </div>
            </div>
          </div>
        </div>

        <div v-if="(hos_score >= 3.5 && hos_score < 4)">
          <div class="col-6 mr-3">
            <div class="align-items-center justify-content-between  flex-colum">
              <div class="row my-1 ">
                <div class=" p-0">
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle star-size" >-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Half-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
                </div>
              </div>
            </div>
          </div>
        </div>

        <div v-if="(hos_score >= 4 && hos_score < 4.5)">
          <div class="col-6 mr-3">
            <div class="align-items-center justify-content-between  flex-colum">
              <div class="row my-1 ">
                <div class=" p-0">
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle star-size" >-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
                </div>
              </div>
            </div>
          </div>
        </div>

        <div v-if="(hos_score >= 4.5 && hos_score < 5)">
          <div class="col-6 mr-3">
            <div class="align-items-center justify-content-between  flex-colum">
              <div class="row my-1 ">
                <div class=" p-0">
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle star-size" >-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
                </div>
              </div>
            </div>
          </div>
        </div>

        <div v-if="(hos_score >= 4.8 && hos_score <= 5)">
          <div class="col-6 mr-3">
            <div class="align-items-center justify-content-between  flex-colum">
              <div class="row my-1 ">
                <div class=" p-0">
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle star-size" >-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
<!--                  <i class="fa-solid fa-star-half-stroke"></i>-->
                </div>
              </div>
            </div>
          </div>
        </div>

        </div>
    </div>



    <div class="row mt-5 " v-for="(row, idx) in list" :key="idx">
        <div class="col-5 text-center ">
            <h3>{{row.user_id}}</h3>
          <div v-if="row.score == 1" class="test-position">
            <div class="align-items-center justify-content-between d-flex flex-colum">
              <div class="row my-1 text-nowrap">
                <div class="col-7 p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>

          <div v-if="row.score == 2" class="test-position">
            <div class="align-items-center justify-content-between d-flex flex-colum">
              <div class="row my-1 text-nowrap">
                <div class="col-7 p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>

          <div v-if="row.score == 3" class="test-position">
            <div class="align-items-center justify-content-between d-flex flex-colum">
              <div class="row my-1 text-nowrap">
                <div class="col-7 p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>

          <div v-if="row.score == 4" class="test-position">
            <div class="align-items-center justify-content-between d-flex flex-colum">
              <div class="row my-1 text-nowrap">
                <div class="col-7 p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Empty-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>

          <div v-if="row.score == 5" class="test-position">
            <div class="align-items-center justify-content-between d-flex flex-colum">
              <div class="row my-1 text-nowrap">
                <div class="col-7 p-0">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                  <img src="https://d23zwvh2kbhdec.cloudfront.net/static_22_11_25/img/mdd_event/Star-Full-icon.svg" alt="Responsive image" class="star-image-middle">
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-7 position_re ">
          <div class="fw-semibold">
            <p>{{row.created_at}}</p>
          </div>
          <div class="fs-5 " style="word-break: break-all">
            <p>{{row.content}}</p>
          </div>
          <div class="text-end mb-5">
            <button class="me-2 mb-5 btn btn-success" v-on:click="fnDelete(`${row.review_id}`)">삭제</button>
            <button class="mb-5 btn btn-success" v-on:click="fnUpdate(`${this.idx}`,`${row.review_id}`)">수정</button>
          </div>
        </div>
<!--      <div class="row">-->
<!--        <div class="col-2 mt-4 text-end" v-if="log_id == row.user_num">-->
<!--          <button class="btn btn-success" v-on:click="fnDelete(`${row.review_id}`)">삭제</button>-->
<!--        </div>-->
<!--        <div class="col-2 mt-4 text-end" v-if="log_id == row.user_num">-->
<!--          <button class="btn btn-success" v-on:click="fnDelete(`${row.review_id}`)">삭제</button>-->
<!--        </div>-->
<!--      </div>-->
      </div>

<!--    <div class="position-re">-->
<!--      <div >-->
<!--        <nav aria-label="Page navigation example" v-if="paging.total_list_cnt > 0">-->
<!--        <span class="center">-->
<!--          <ul class="pagination">-->
<!--            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>-->

<!--            &lt;!&ndash;             <a href="javascript:;" class="page-link" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>&ndash;&gt;-->
<!--            <a href="javascript:;" class="page-link"  @click="fnPage(`${paging.start_page-1}`)">&lt;</a>-->
<!--            <template v-for=" (n,index) in paginavigation()">-->
<!--                <template v-if="paging.page==n">-->
<!--                  <li class="page-item" :key="index"> <a class="page-link"> {{ n }}</a> </li>-->
<!--                </template>-->

<!--                <template v-else>-->
<!--                   <li class="page-item"> <a class="page-link" href="javascript:;" @click="fnPage(`${n}`)" :key="index"> {{ n }} </a> </li>-->
<!--                </template>-->
<!--            </template>-->

<!--             <a href="javascript:;" class="page-link" v-if="paging.total_page_cnt > paging.end_page"-->
<!--                @click="fnPage(`${paging.end_page+1}`)">&gt;</a>-->
<!--            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(`${paging.total_page_cnt}`)">&gt;&gt;</a></li>-->
<!--          </ul>-->
<!--        </span>-->
<!--        </nav>-->
<!--      </div>-->
<!--    </div>-->
  </div>


  <div class="test-position">
    <div >
      <nav aria-label="Page navigation example" v-if="paging.total_list_cnt > 0">
        <span class="center">
          <ul class="pagination">
            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>

            <!--             <a href="javascript:;" class="page-link" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>-->
            <a href="javascript:;" class="page-link" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>
            <template v-for=" (n,index) in paginavigation()">
                <template v-if="paging.page==n">
                  <div v-if="n == 2">
                  </div>
                  <li class="page-item active" :key="index"> <a class="page-link"> {{ n }}</a> </li>
                </template>

                <template v-else>
                   <li class="page-item"> <a class="page-link" href="javascript:;" @click="fnPage(`${n}`)" :key="index"> {{ n }} </a> </li>
                </template>
            </template>

             <a href="javascript:;" class="page-link" v-if="paging.total_page_cnt > paging.end_page"
                @click="fnPage(`${paging.end_page+1}`)">&gt;</a>
            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(`${paging.total_page_cnt}`)">&gt;&gt;</a></li>
          </ul>
        </span>
      </nav>
    </div>


  </div>

<!--  <div style="position: center">-->
<!--    <div >-->
<!--      <nav aria-label="Page navigation example" v-if="paging.total_list_cnt > 0">-->
<!--        <span class="center">-->
<!--          <ul class="pagination">-->
<!--            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a></li>-->

<!--            &lt;!&ndash;             <a href="javascript:;" class="page-link" v-if="paging.start_page > 10" @click="fnPage(`${paging.start_page-1}`)">&lt;</a>&ndash;&gt;-->
<!--            <a href="javascript:;" class="page-link"  @click="fnPage(`${paging.start_page-1}`)">&lt;</a>-->
<!--            <template v-for=" (n,index) in paginavigation()">-->
<!--                <template v-if="paging.page==n">-->
<!--                  <li class="page-item" :key="index"> <a class="page-link"> {{ n }}</a> </li>-->
<!--                </template>-->

<!--                <template v-else>-->
<!--                   <li class="page-item"> <a class="page-link" href="javascript:;" @click="fnPage(`${n}`)" :key="index"> {{ n }} </a> </li>-->
<!--                </template>-->
<!--            </template>-->

<!--             <a href="javascript:;" class="page-link" v-if="paging.total_page_cnt > paging.end_page"-->
<!--                @click="fnPage(`${paging.end_page+1}`)">&gt;</a>-->
<!--            <li class="page-item"><a class="page-link" href="javascript:;" @click="fnPage(`${paging.total_page_cnt}`)">&gt;&gt;</a></li>-->
<!--          </ul>-->
<!--        </span>-->
<!--      </nav>-->
<!--    </div>-->
<!--  </div>-->


</template>

<script>


export default {
  data() { //변수생성
    return {

      idx:this.$route.query.idx,

      hos_score:'',

      log_id: this.$store.state.userIdx,

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

      page:1,
      //page: this.$route.query.page ? this.$route.query.page : 1,
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
  },
  mounted() {
    this.fnGetList()
    this.fnGetReviewScore()
    console.log(this.list)
  },
  methods: {
    fnPage(n) {
      if (this.page !== n) {
        this.page = n
      }

      this.fnGetList()
    }
    ,fnGetList() {
      this.requestBody = { // 데이터 전송
        // sk: this.search_key,
        // sv: this.search_value,
        page: this.page,
        size: this.size
      }

      this.$axios.get(this.$serverUrl + '/review/list/'+ this.idx, {
        params: this.requestBody,
        headers: {}
      }).then((res) => {

        if (res.data.result_code === "OK") {
          this.list = res.data.data
          this.paging = res.data.pagination
          this.no = this.paging.total_list_cnt - ((this.paging.page - 1) * this.paging.page_size)
        }

        console.log(res.data.pagination);
        //console.log(res.data.data);


      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,fnGetReviewScore() {
      this.$axios.get(this.$serverUrl + '/review/hos/'+ this.idx, {
        headers: {}
      }).then((res) => {
        console.log("!!!!!!!" + res.data);
        this.hos_score = res.data;
      }).catch((err) => {
        if (err.message.indexOf('Network Error') > -1) {
          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
        }
      })
    }
    ,fnDelete(idx){
      console.log(idx)

      if (!confirm("삭제하시겠습니까?")) return

      this.$axios.delete(this.$serverUrl + '/review/' + idx, {})
          .then(() => {
            alert('삭제되었습니다.')

            this.fnGetList()
            location.reload()

          }).catch((err) => {
        console.log(err);
      })
    }

    ,fnUpdate(hos_idx,rev_idx){
      console.log("hos_idx:" + hos_idx)
      console.log("rev_idx:" + rev_idx)

      this.requestBody.hos_idx = hos_idx
      this.requestBody.rev_idx = rev_idx

      this.$router.push({
        path: '/review/update',
        query: this.requestBody
      })
    }

    ,fnDetail() {
      this.requestBody.idx = this.idx

      this.$router.push({
        path: '/hospital/detail',
        query: this.requestBody
      })
    }
}
}


</script>

<style>
.star-size{
  size:0.8rem
}

 .position_re{
   text-align: left;
 }
 .star-pos{
   text-align: center !important;
 }

 .position-re{
   position: relative;
   left:15rem;
 }
</style>