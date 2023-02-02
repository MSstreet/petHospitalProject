package com.msproject.pet.repository;

import com.msproject.pet.entity.ReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    @Query("select r from ReviewEntity r where r.petHospitalEntity.hospitalId =:hospital_id")
    Page<ReviewEntity> listOfReview(@Param("hospital_id") Long hospital_id, Pageable pageable);

}
