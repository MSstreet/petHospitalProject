package com.msproject.pet.web;

import com.msproject.pet.entity.BoardReply;
import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.service.BoardReplyService;

import com.msproject.pet.web.dtos.BoardReplyDto;
import com.msproject.pet.web.dtos.ReviewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class BoardReplyController {

    private final BoardReplyService boardReplyService;


    @PostMapping("/reply/join")
    public BoardReply create (@RequestBody BoardReplyDto boardReplyDto) throws Exception{

        System.out.println(boardReplyDto.getUserIdx());
        System.out.println(boardReplyDto.getBoardIdx());
        System.out.println(boardReplyDto.getContents());

        return boardReplyService.BoardReplyCreate(boardReplyDto);
    }

    @GetMapping("/reply/list/{id}")
    public Header<List<BoardReplyDto>> reviewList(@PathVariable Long id,
                                              @PageableDefault(sort = "reply_idx") Pageable pageable)
    {
        return boardReplyService.getReplyList(pageable, id);
    }

    @GetMapping("/reply/list1/{id}")
    public Header<List<BoardReplyDto>> reviewList1(@PathVariable Long id,
                                                  @PageableDefault(sort = "reply_idx") Pageable pageable)
    {
        return boardReplyService.getReplyList1(pageable, id);
    }

    @GetMapping("/reply/{id}")
    public BoardReplyDto getReply(@PathVariable Long id){
        return boardReplyService.getReply(id);
    }

    @PatchMapping("/reply")
    public BoardReply update(@RequestBody BoardReplyDto boardReplyDto) {
        System.out.println("들어오는지 확인해보기");
        System.out.println(boardReplyDto.getReplyIdx());
        return boardReplyService.update(boardReplyDto);
    }

    @DeleteMapping("reply/{id}")
    public void delete(@PathVariable Long id){
        boardReplyService.delete(id);
    }
}
