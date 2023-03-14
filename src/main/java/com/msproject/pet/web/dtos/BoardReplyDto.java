package com.msproject.pet.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardReplyDto {

    private Long replyIdx;

    private Long boardIdx;

    private Long userIdx;

    private String contents;

    private String createdAt;

    private String updatedAt;

    private String userName;

    private boolean deleteYn;

    private String userId;

    private Long parent;
}
