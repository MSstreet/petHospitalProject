package com.msproject.pet.service;

import com.msproject.pet.entity.*;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.Pagination;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.repository.PetHospitalRepository;
import com.msproject.pet.repository.WishRepository;
import com.msproject.pet.repository.WishRepositoryCustom;
import com.msproject.pet.web.dtos.ReviewDto;
import com.msproject.pet.web.dtos.WishDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WishService {

    private final WishRepository wishRepository;

    private final WishRepositoryCustom wishRepositoryCustom;
    private final UserRepository userRepository;

    private final PetHospitalRepository petHospitalRepository;

    private final ModelMapper modelMapper;

    public WishEntity wishCreate(WishDto wishDto){



        Optional<PetHospitalEntity> petHospitalEntity = petHospitalRepository.findById(wishDto.getPetHospitalNum());
        PetHospitalEntity pet = petHospitalEntity.orElseThrow();

        Optional<UserEntity> userEntity = userRepository.findById(wishDto.getUserNum());
        UserEntity user = userEntity.orElseThrow();


        WishEntity wishEntity = WishEntity.builder()
                .petHospitalEntity(pet)
                .userEntity(user)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                //.wishState(wishDto.isWishState())
                .wishState1(wishDto.getWishState1())
                .build();

        return wishRepository.save(wishEntity);
    }


    public WishEntity update(WishDto wishDto) {

        WishEntity entity = wishRepositoryCustom.findOneReview(wishDto.getUserNum(),wishDto.getPetHospitalNum());

        entity.changeWishState(wishDto.getWishState1());
        entity.setUpdatedAt(LocalDateTime.now());
        return wishRepository.save(entity);
    }


    public void delete(Long id) {

        WishEntity entity = wishRepository.findById(id).orElseThrow(()-> new RuntimeException("존재하지 않는 리뷰입니다."));

        wishRepository.delete(entity);

    }


    public Header<List<WishDto>> getWishList(Pageable pageable, Long uid) {

        List<WishDto> dtos = new ArrayList<>();

        Page<WishEntity> wishEntities = wishRepositoryCustom.findAllReview(pageable, uid);

        for (WishEntity entity : wishEntities) {

          WishDto dto = WishDto.builder()
                  .wishId(entity.getWishId())
                  .petHospitalNum(entity.getPetHospitalEntity().getHospitalId())
                  .userNum(entity.getUserEntity().getIdx())
                  //.wishState(entity.isWishState())
                  .wishState1(entity.getWishState1())
                  .hospitalName(entity.getPetHospitalEntity().getHospitalName())
                  .hospitalNum(entity.getPetHospitalEntity().getHospitalNum())
                  .hospitalSigunName(entity.getPetHospitalEntity().getSigunName())
                  .hospitalAddr(entity.getPetHospitalEntity().getHospitalAddr())
                  //.hospitalScore(entity.getPetHospitalEntity().getPetHospitalScore())
                  .build();

            dtos.add(dto);
        }

        Pagination pagination = new Pagination(
                (int) wishEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }

    public WishDto getWish(Long id) {
        WishEntity entity = wishRepository.findById(id).orElseThrow(() -> new RuntimeException("찜 리스트에 존재하지 않는 병원입니다."));

        return WishDto.builder()
                .wishId(entity.getWishId())
                .petHospitalNum(entity.getPetHospitalEntity().getHospitalId())
                .userNum(entity.getUserEntity().getIdx())
                //.wishState(entity.isWishState())
                .wishState1(entity.getWishState1())
                .build();
    }

    public WishDto getWish1(Long uid, Long hid) {
        //WishEntity entity = wishRepository.findById(id).orElseThrow(() -> new RuntimeException("찜 리스트에 존재하지 않는 병원입니다."));

        WishEntity entity = wishRepositoryCustom.findOneReview(uid, hid);

        WishDto wishDto = WishDto.builder()
                .wishId(entity.getWishId())
                .petHospitalNum(entity.getPetHospitalEntity().getHospitalId())
                .userNum(entity.getUserEntity().getIdx())
                //.wishState(entity.isWishState())
                .wishState1(entity.getWishState1())
                .build();

        return wishDto;
    }

    public Boolean checkWish(Long uid, Long hid) {

        if(wishRepositoryCustom.findOneReview(uid,hid) == null){
            return true;
        }else {
            return false;
        }

    }
    public WishEntity changeStateZero(Long wid) {
        WishEntity wishEntity = wishRepository.findById(wid).orElseThrow(()-> new RuntimeException("잘못된 요청입니다."));

        wishEntity.changeWishState1();

        wishRepository.save(wishEntity);

        return wishEntity;
    }
}
