package com.msproject.pet.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WishDto {

    private Long wishId;

    private Long petHospitalNum;

    private Long userNum;

    private boolean wishState;
}
