package com.msproject.pet.web;

import com.msproject.pet.model.Header;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.service.NoticeBoardService;
import com.msproject.pet.web.dtos.BoardDto;
import com.msproject.pet.web.dtos.NoticeBoardDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    @GetMapping("/notice/list")
    public Header<List<NoticeBoardDto>> boardList(
            @PageableDefault(sort = {"idx"}) Pageable pageable,
            SearchCondition searchCondition)
    {

        return noticeBoardService.getNoticeBoardList(pageable, searchCondition);
    }

    @GetMapping("/notice/{id}")
    public NoticeBoardDto getBoard(@PathVariable Long id) {
        return noticeBoardService.getNoticeBoard(id);
    }

}
