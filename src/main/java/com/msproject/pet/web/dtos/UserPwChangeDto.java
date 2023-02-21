package com.msproject.pet.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPwChangeDto {

    private Long idx;

    private String password;

    private String newPassword;

}