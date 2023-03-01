package com.msproject.pet.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
    Page<BoardEntity> findAllByOrderByIdxDesc(Pageable pageable);

    List<BoardEntity> findByUserEntity(UserEntity entity);
}
