package com.msproject.pet.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeBoardDto {

    private Long noticeBoardIdx;

    private String title;

    private String contents;

    private boolean displayYn;

    private String createdAt;

    private String updatedAt;

    private boolean deleteYn;

}
