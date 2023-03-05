package com.msproject.pet.repository;

import com.msproject.pet.entity.BoardReply;
import com.msproject.pet.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardReplyRepository extends JpaRepository<BoardReply,Long> {

    List<BoardReply> findByUserEntity(UserEntity entity);
}
