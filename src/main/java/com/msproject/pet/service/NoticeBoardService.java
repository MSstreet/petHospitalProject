package com.msproject.pet.service;

import com.msproject.pet.entity.BoardEntity;
import com.msproject.pet.entity.NoticeBoard;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.Pagination;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.repository.NoticeBoardRepository;
import com.msproject.pet.repository.NoticeBoardRepositoryCustom;
import com.msproject.pet.web.dtos.BoardDto;
import com.msproject.pet.web.dtos.NoticeBoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoticeBoardService {


    private final NoticeBoardRepository noticeBoardRepository;

    private final NoticeBoardRepositoryCustom noticeBoardRepositoryCustom;
    public Header<List<NoticeBoardDto>> getNoticeBoardList(Pageable pageable, SearchCondition searchCondition) {

        List<NoticeBoardDto> dtos = new ArrayList<>();

        Page<NoticeBoard> boardEntities = noticeBoardRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);
        for (NoticeBoard entity : boardEntities) {

            NoticeBoardDto dto = NoticeBoardDto.builder()
                    .noticeBoardIdx(entity.getNboardId())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .updatedAt(entity.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
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

    public NoticeBoardDto getNoticeBoard(Long id) {

        NoticeBoard entity = noticeBoardRepository.findById(id).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        return NoticeBoardDto.builder()
                .noticeBoardIdx(entity.getNboardId())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .build();
    }
}
