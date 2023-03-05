package com.msproject.pet.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardListWithReplyCountDto {

    private Long idx;

    private String title;

    private String contents;

    private String author;

    private Long userIdx;
    //private String userIdx;

    private String userId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean deleteYn;

    private Long replyCount;

    private String createdAt1;

    private String updatedAt1;

}
