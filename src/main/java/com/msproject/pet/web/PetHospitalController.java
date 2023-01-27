package com.msproject.pet.web;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.service.PetHospitalService;
import com.msproject.pet.web.dtos.PetHospitalDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/pet-hospitals")
@RestController
public class PetHospitalController {

    private final PetHospitalService petHospitalService;

//    @PostMapping("")
//    public PetHospitalEntity create(PetHospitalDto petHospitalDto){
//
//    }


}
