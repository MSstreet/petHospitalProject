package com.msproject.pet.service;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.Pagination;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.repository.PetHospitalRepositoryCustom;
import com.msproject.pet.repository.PetHospitalRepository;

import com.msproject.pet.repository.ReviewRepository;
import com.msproject.pet.repository.ReviewRepositoryCustom;
import com.msproject.pet.web.dtos.PetHospitalDto;
import com.msproject.pet.web.dtos.PetHospitalListReviewCountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@Service
public class PetHospitalService {

    private final PetHospitalRepository petHospitalRepository;

    private final ReviewRepository reviewRepository;
    private final PetHospitalRepositoryCustom petHospitalRepositoryCustom;

    private final ReviewRepositoryCustom reviewRepositoryCustom;


    public PetHospitalEntity create(PetHospitalDto petHospitalDto) {

       PetHospitalEntity entity = PetHospitalEntity.builder()
               .sigunName(petHospitalDto.getSigunName())
               .hospitalName(petHospitalDto.getHospitalName())
               .hospitalNum(petHospitalDto.getHospitalNum())
               .hospitalAddr(petHospitalDto.getHospitalAddr())
               //.petHospitalScore(petHospitalDto.getHospitalScore())
               .build();

        return petHospitalRepository.save(entity);
    }

    public PetHospitalEntity update(PetHospitalDto petHospitalDto) {

        PetHospitalEntity entity = petHospitalRepository.findById(petHospitalDto.getHospitalId()).orElseThrow(()-> new RuntimeException("존재하지 않는 동물병원입니다."));

        entity.change(petHospitalDto.getHospitalName(), petHospitalDto.getHospitalNum(), petHospitalDto.getHospitalAddr(), petHospitalDto.getSigunName());

        return petHospitalRepository.save(entity);
    }

    public void delete(Long id) {
        PetHospitalEntity entity = petHospitalRepository.findById(id).orElseThrow(()-> new RuntimeException("존재하지 않는 동물병원입니다."));

        petHospitalRepository.delete(entity);
    }


    public PetHospitalDto getPetHospital(Long id) {
        PetHospitalEntity entity = petHospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 동물병원입니다."));

        return PetHospitalDto.builder()
                .hospitalId(entity.getHospitalId())
                .sigunName(entity.getSigunName())
                .hospitalName(entity.getHospitalName())
                .hospitalNum(entity.getHospitalNum())
                .hospitalAddr(entity.getHospitalAddr())
                .build();
    }

    public PetHospitalListReviewCountDto getPetHospitalWithReviewCount(Long id) {

        PetHospitalListReviewCountDto petHospitalListReviewCountDto = petHospitalRepositoryCustom.findWithReviewCountById(id);
        Optional<PetHospitalEntity> petHospitalEntity = petHospitalRepository.findById(id);

        PetHospitalEntity result = petHospitalEntity.orElseThrow();
        List<ReviewEntity> reviewEntities = reviewRepository.findByPetHospitalEntity(result);

        if (reviewEntities.size() == 0) {
            petHospitalListReviewCountDto.setHospitalScore(0);
        } else {
            //float avg = reviewRepository.getReviewAvg(petHospitalListReviewCountDto.getHospitalId());

            double avg = reviewRepositoryCustom.getReviewAvg(petHospitalListReviewCountDto.getHospitalId());
            DecimalFormat df = new DecimalFormat("0.0");
            avg = Double.parseDouble(df.format(avg));
            //avg = Math.round(avg * 100) / 100;
            petHospitalListReviewCountDto.setHospitalScore(avg);
        }

        return petHospitalListReviewCountDto;
    }

    public Header<List<PetHospitalListReviewCountDto>> getHospitalListWithReviewCount(Pageable pageable, SearchCondition searchCondition) {

        List<PetHospitalListReviewCountDto> dtos = new ArrayList<>();
        Page<PetHospitalListReviewCountDto> hospitalEntities = petHospitalRepositoryCustom.findAllBySearchConditionWithReviewCount(pageable, searchCondition);

        System.out.println(hospitalEntities.getTotalElements());


        for (PetHospitalListReviewCountDto entity : hospitalEntities) {
            PetHospitalListReviewCountDto dto = PetHospitalListReviewCountDto.builder()
                    .hospitalId(entity.getHospitalId())
                    .hospitalName(entity.getHospitalName())
                    .sigunName(entity.getSigunName())
                    .hospitalNum(entity.getHospitalNum())
                    .hospitalAddr(entity.getHospitalAddr())
                    //.hospitalScore(entity.getHospitalScore())
                    .operState(entity.getOperState())
                    .reviewCount(entity.getReviewCount())
                    .build();
//            if(dto.getOperState().equals("정상")) {
                //System.out.println(entity.getOperState());
            if(dto.getReviewCount() != 0){
               // float avg = reviewRepository.getReviewAvg(dto.getHospitalId());
               double avg = reviewRepositoryCustom.getReviewAvg(dto.getHospitalId());
                DecimalFormat df = new DecimalFormat("0.0");
                avg = Double.parseDouble(df.format(avg));
                dto.setHospitalScore(avg);
            }
                dtos.add(dto);
            //}
        }

        Pagination pagination = new Pagination(
                (int) hospitalEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );
        return Header.OK(dtos, pagination);
    }

    public Header<List<PetHospitalDto>> getHospitalList(Pageable pageable, SearchCondition searchCondition) {
        List<PetHospitalDto> dtos = new ArrayList<>();

        Page<PetHospitalEntity> hospitalEntities = petHospitalRepositoryCustom.findAllBySearchCondition(pageable, searchCondition);

        for (PetHospitalEntity entity : hospitalEntities) {

            PetHospitalDto dto = PetHospitalDto.builder()
                    .hospitalId(entity.getHospitalId())
                    .hospitalName(entity.getHospitalName())
                    .sigunName(entity.getSigunName())
                    .hospitalNum(entity.getHospitalNum())
                    .hospitalAddr(entity.getHospitalAddr())
                    //.hospitalScore(entity.getPetHospitalScore())
                    .operState(entity.getOperState())
                    .build();

            if(dto.getOperState().equals("정상")) {
//                System.out.println(oper);
                dtos.add(dto);
            }
        }

        Pagination pagination = new Pagination(
                (int) hospitalEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }

    public Header<List<PetHospitalListReviewCountDto>> getHospitalListWithReviewCount1(Pageable pageable, SearchCondition searchCondition) {

        List<PetHospitalListReviewCountDto> dtos = new ArrayList<>();
        Page<PetHospitalListReviewCountDto> hospitalEntities = petHospitalRepositoryCustom.findAllBySearchConditionWithReviewCount1(pageable, searchCondition);

        System.out.println(hospitalEntities.getTotalElements());

        for (PetHospitalListReviewCountDto entity : hospitalEntities) {
            PetHospitalListReviewCountDto dto = PetHospitalListReviewCountDto.builder()
                    .hospitalId(entity.getHospitalId())
                    .hospitalName(entity.getHospitalName())
                    .sigunName(entity.getSigunName())
                    .hospitalNum(entity.getHospitalNum())
                    .hospitalAddr(entity.getHospitalAddr())
                    .hospitalScore(entity.getHospitalScore())
                    .operState(entity.getOperState())
                    .reviewCount(entity.getReviewCount())
                    .build();
//            if(dto.getOperState().equals("정상")) {
            System.out.println(entity.getOperState());
            dtos.add(dto);
            //}
        }
        Pagination pagination = new Pagination(
                (int) hospitalEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }
}
