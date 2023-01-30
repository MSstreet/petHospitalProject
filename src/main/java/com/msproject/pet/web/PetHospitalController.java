package com.msproject.pet.web;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.service.PetHospitalService;
import com.msproject.pet.web.dtos.PetHospitalDto;
import com.msproject.pet.web.dtos.PetHospitalListReviewCountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@RestController
public class PetHospitalController {

    private final PetHospitalService petHospitalService;

    @PostMapping("/hospitals/join")
    public PetHospitalEntity create(@RequestBody PetHospitalDto petHospitalDto) throws Exception{
        return petHospitalService.create(petHospitalDto);
    }

    @GetMapping("/hospital/list")
    public Header<List<PetHospitalListReviewCountDto>> hospitalList(
            @PageableDefault(sort = {"idx"}) Pageable pageable,
            SearchCondition searchCondition)
    {
        return petHospitalService.getHospitalListWithReviewCount(pageable, searchCondition);
    }


//    @GetMapping("/hospital/list")
//    public Header<List<PetHospitalDto>> hospitalList(
//            @PageableDefault(sort = {"idx"}) Pageable pageable,
//            SearchCondition searchCondition)
//    {
//        return petHospitalService.getHospitalList(pageable, searchCondition);
//    }

    @GetMapping("/hospital/{id}")
    public PetHospitalDto getPetHospital(@PathVariable Long id){
        return petHospitalService.getPetHospital(id);
    }

    @PatchMapping("/hospital")
    public PetHospitalEntity update(@RequestBody PetHospitalDto petHospitalDto){
        return petHospitalService.update(petHospitalDto);
    }

    @DeleteMapping("/hospital/{id}")
    public void delete(@PathVariable Long id){
        petHospitalService.delete(id);
    }
}
