package com.msproject.pet.service;

import com.msproject.pet.entity.*;

import com.msproject.pet.model.Header;
import com.msproject.pet.model.Pagination;
import com.msproject.pet.repository.BoardReplyRepository;
import com.msproject.pet.repository.BoardReplyRepositoryCustom;
import com.msproject.pet.web.dtos.BoardReplyDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Slf4j
@RequiredArgsConstructor
@Service
public class BoardReplyService {

    private final BoardReplyRepository boardReplyRepository;

    private final BoardRepository boardRepository;

    private final UserRepository userRepository;

    private final BoardReplyRepositoryCustom boardReplyRepositoryCustom;

    public BoardReply BoardReplyCreate(BoardReplyDto boardReplyDto) throws Exception{

        Optional<BoardEntity> boardEntity = boardRepository.findById(boardReplyDto.getBoardIdx());
        BoardEntity board = boardEntity.orElseThrow();

        Optional<UserEntity> userEntity = userRepository.findById(boardReplyDto.getUserIdx());
        UserEntity user = userEntity.orElseThrow();

        if(boardReplyDto.getParent() != null){
            Optional<BoardReply> tmpBoardReply = boardReplyRepository.findById(boardReplyDto.getParent());
            BoardReply parent = tmpBoardReply.orElseThrow();

            BoardReply boardReply = BoardReply.builder()
                    .boardEntity(board)
                    .userEntity(user)
                    .contents(boardReplyDto.getContents())
                    .parent(parent)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            return boardReplyRepository.save(boardReply);
        }else{

            BoardReply boardReply = BoardReply.builder()
                    .boardEntity(board)
                    .userEntity(user)
                    .contents(boardReplyDto.getContents())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();

            return boardReplyRepository.save(boardReply);
        }
    }

    public Header<List<BoardReplyDto>> getReplyList(Pageable pageable, Long id) {

        List<BoardReplyDto> dtos = new ArrayList<>();
        Page<BoardReply> boardReplies = boardReplyRepositoryCustom.findAllBySearchCondition(pageable, id);

        for (BoardReply entity : boardReplies) {
            BoardReplyDto dto = BoardReplyDto.builder()
                    .replyIdx(entity.getReplyIdx())
                    .boardIdx(entity.getBoardEntity().getIdx())
                    .userIdx(entity.getUserEntity().getIdx()) // 수정 0207
                    .contents(entity.getContents())
                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .updatedAt(entity.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .userName(entity.getUserEntity().getUserName())
                    .userId(entity.getUserEntity().getUserId())
                    .build();
            dtos.add(dto);
        }
        Pagination pagination = new Pagination(
                (int) boardReplies.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );
        return Header.OK(dtos, pagination);
    }

    public BoardReplyDto getReply(Long id) {

        BoardReply entity = boardReplyRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 댓글입니다."));

        return BoardReplyDto.builder()
                .replyIdx(entity.getReplyIdx())
                .boardIdx(entity.getBoardEntity().getIdx())
                .userIdx(entity.getUserEntity().getIdx())
                .contents(entity.getContents())
                .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .updatedAt(entity.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .userName(entity.getUserEntity().getUserName())
                .userId(entity.getUserEntity().getUserId())
                .build();
    }

    public BoardReply update(BoardReplyDto boardReplyDto) {

        BoardReply entity = boardReplyRepository.findById(boardReplyDto.getReplyIdx()).orElseThrow(()-> new RuntimeException("존재하지 않는 리뷰입니다."));

        System.out.println(boardReplyDto.getContents());
        System.out.println(boardReplyDto.getReplyIdx());
        System.out.println(boardReplyDto.getBoardIdx());

        entity.changeReply(boardReplyDto.getContents(),LocalDateTime.now());

        return boardReplyRepository.save(entity);
    }

    public void delete(Long id) {
        BoardReply boardReply = boardReplyRepository.findById(id).orElseThrow(()-> new RuntimeException("존재하지 않는 리뷰입니다."));

        //boardReply.changeDeleteState();
        //boardReply.isDeleteYn();
        //boardReplyRepository.save(boardReply);

        boardReplyRepository.delete(boardReply);

    }

    public Header<List<BoardReplyDto>> getReplyList1(Pageable pageable, Long id) {

        List<BoardReplyDto> dtos = new ArrayList<>();
        Page<BoardReply> boardReplies = boardReplyRepositoryCustom.findAllBySearchCondition1(pageable, id);

        for (BoardReply entity : boardReplies) {
            BoardReplyDto dto = BoardReplyDto.builder()
                    .replyIdx(entity.getReplyIdx())
                    .boardIdx(entity.getBoardEntity().getIdx())
                    .userIdx(entity.getUserEntity().getIdx()) // 수정 0207
                    .contents(entity.getContents())
                    .parent(entity.getParent().getReplyIdx())
                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .updatedAt(entity.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .userName(entity.getUserEntity().getUserName())
                    .userId(entity.getUserEntity().getUserId())
                    .build();
            dtos.add(dto);
        }
        Pagination pagination = new Pagination(
                (int) boardReplies.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );
        return Header.OK(dtos, pagination);
    }

}
