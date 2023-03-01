package com.msproject.pet.repository;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    @Query("select r from ReviewEntity r where r.petHospitalEntity.hospitalId =:hospital_id")
    Page<ReviewEntity> listOfReview(@Param("hospital_id") Long hospital_id, Pageable pageable);

    @Query("select avg(r.score) from ReviewEntity r where r.petHospitalEntity.hospitalId =:hospital_id")
    float getReviewAvg(@Param("hospital_id") Long hospital_id);

    List<ReviewEntity> findByPetHospitalEntity(PetHospitalEntity petHospitalEntity);

    List<ReviewEntity> findByUserEntity(UserEntity userEntity);
}
