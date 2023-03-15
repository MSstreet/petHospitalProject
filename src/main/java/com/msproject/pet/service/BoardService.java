package com.msproject.pet.service;

import com.msproject.pet.entity.*;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.Pagination;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.web.dtos.BoardDto;
import com.msproject.pet.web.dtos.BoardListWithReplyCountDto;
import com.msproject.pet.web.dtos.PetHospitalListReviewCountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardRepositoryCustom boardRepositoryCustom;
    private final UserRepository userRepository;
    /**
     * 게시글 목록 가져오기
     */
//    public List<BoardDto> getBoardList() {
//        List<BoardEntity> boardEntities = boardRepository.findAll();
//        List<BoardDto> dtos = new ArrayList<>();
//
//        for (BoardEntity entity : boardEntities) {
//            BoardDto dto = BoardDto.builder()
//                    .idx(entity.getIdx())
//                    .author(entity.getAuthor())
//                    .title(entity.getTitle())
//                    .contents(entity.getContents())
//                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
//                    .build();
//
//            dtos.add(dto);
//        }
//
//        return dtos;
//    }

//    public Header<List<BoardDto>> getBoardList(Pageable pageable) {
//        List<BoardDto> dtos = new ArrayList<>();
//
//        Page<BoardEntity> boardEntities = boardRepository.findAllByOrderByIdxDesc(pageable);
//        for (BoardEntity entity : boardEntities) {
//            BoardDto dto = BoardDto.builder()
//                    .idx(entity.getIdx())
//                    .author(entity.getAuthor())
//                    .title(entity.getTitle())
//                    .contents(entity.getContents())
//                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
//                    .build();
//
//            dtos.add(dto);
//        }
//
//        Pagination pagination = new Pagination(
//                (int) boardEntities.getTotalElements()
//                , pageable.getPageNumber() + 1
//                , pageable.getPageSize()
//                , 10
//        );
//
//        return Header.OK(dtos, pagination);
//    }

    public Header<List<BoardDto>> getBoardList(Pageable pageable, SearchCondition searchCondition) {

        List<BoardDto> dtos = new ArrayList<>();

        Page<BoardEntity> boardEntities = boardRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (BoardEntity entity : boardEntities) {

            BoardDto dto = BoardDto.builder()
                    .idx(entity.getIdx())
                    .author(entity.getAuthor())
                    .userIdx(entity.getUserEntity().getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .updatedAt(entity.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .userId(entity.getUserEntity().getUserId())
                    .build();

            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) boardEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }

    public Header<List<BoardListWithReplyCountDto>> getBoardListWithReplyCount(Pageable pageable,SearchCondition searchCondition) {

        List<BoardListWithReplyCountDto> dtos = new ArrayList<>();
        Page<BoardListWithReplyCountDto> boardListWithReplyCountDtos = boardRepositoryCustom.findAllBySearchConditionWithReplyCount(pageable,searchCondition);

        for (BoardListWithReplyCountDto entity : boardListWithReplyCountDtos) {
            BoardListWithReplyCountDto dto = BoardListWithReplyCountDto.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .author(entity.getAuthor())
                    .userIdx(entity.getUserIdx())
                    .userId(entity.getUserId())
                    //.hospitalScore(entity.getHospitalScore())
                    .createdAt(entity.getCreatedAt())
                    .updatedAt(entity.getUpdatedAt())
                    .createdAt1(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .updatedAt1(entity.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .replyCount(entity.getReplyCount())
                    .build();

            dtos.add(dto);

        }
        Pagination pagination = new Pagination(
                (int) boardListWithReplyCountDtos.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }

    /**
     * 게시글 가져오기
     */
    public BoardDto getBoard(Long id) {
        BoardEntity entity = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        return BoardDto.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .author(entity.getAuthor())
                .userIdx(entity.getUserEntity().getIdx())
                .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .updatedAt(entity.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .userId(entity.getUserEntity().getUserId())
                .build();
    }

    /**
     * 게시글 등록
     */
    public BoardEntity create(BoardDto boardDto) {

        Optional<UserEntity> user = userRepository.findById(boardDto.getUserIdx());

        UserEntity result = user.orElseThrow();

       BoardEntity entity = BoardEntity.builder()
                .title(boardDto.getTitle())
                .contents(boardDto.getContents())
                .author(boardDto.getAuthor())
                .userEntity(result)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return boardRepository.save(entity);
    }

    /**
     * 게시글 수정
     */
    public BoardEntity update(BoardDto boardDto) {
        BoardEntity entity = boardRepository.findById(boardDto.getIdx()).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        entity.setTitle(boardDto.getTitle());
        entity.setContents(boardDto.getContents());
        entity.setUpdatedAt(LocalDateTime.now());
        return boardRepository.save(entity);
    }

    /**
     * 게시글 삭제
     */
    public void delete(Long id) {
        BoardEntity entity = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        //boardRepository.delete(entity);

        entity.changeState();
        boardRepository.save(entity);
    }
}
