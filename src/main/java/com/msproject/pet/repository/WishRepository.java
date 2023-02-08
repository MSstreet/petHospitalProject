package com.msproject.pet.repository;

import com.msproject.pet.entity.WishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishRepository extends JpaRepository<WishEntity,Long> {

//    Boolean checkWish(Long , Long );
}
