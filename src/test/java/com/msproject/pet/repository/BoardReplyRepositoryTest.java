package com.msproject.pet.repository;

import com.msproject.pet.entity.BoardEntity;
import com.msproject.pet.entity.BoardReply;
import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.entity.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BoardReplyRepositoryTest {

    @Autowired
    BoardReplyRepository boardReplyRepository;

    @DisplayName("댓글 생성")
    @Test
    public void testInsert(){
        Long board = 1L;
        Long user = 4L;

        BoardEntity boardEntity = BoardEntity.builder()
                .idx(board).build();

        UserEntity userEntity = UserEntity.builder()
                .idx(user).build();

        IntStream.rangeClosed(1,100).forEach(i ->{
            BoardReply boardReply = BoardReply.builder()
                    .boardEntity(boardEntity)
                    .userEntity(userEntity)
                    .contents("test..." + i)
                    .deleteYn(false)
                    .build();

            boardReplyRepository.save(boardReply);
        });
    }
}
