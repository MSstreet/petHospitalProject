package com.msproject.pet.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserHistoryDto {

    private Long idx;

    private String userId;
    private String userPw;
    private String userName;

    private String phoneNum;

    private String zipCode;

    private String addr;

    private String detailAddr;

    private String email; // 0208

    private String created;

    private String updated;

    private boolean deleteYn;
}
