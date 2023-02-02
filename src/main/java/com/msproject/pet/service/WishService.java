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

        //WishEntity wishEntity = modelMapper.map(wishDto, WishEntity.class);


        Optional<PetHospitalEntity> petHospitalEntity = petHospitalRepository.findById(wishDto.getUserNum());

        PetHospitalEntity pet = petHospitalEntity.orElseThrow();


        Optional<UserEntity> userEntity = userRepository.findById(wishDto.getUserNum());

        UserEntity user = userEntity.orElseThrow();

        //wishEntity.setUserEntity(user);

        WishEntity wishEntity = WishEntity.builder()
                .petHospitalEntity(pet)
                .userEntity(user)
                .wishState(wishDto.isWishState()).build();

        return wishRepository.save(wishEntity);
    }


    public WishEntity update(WishDto wishDto) {

        WishEntity entity = wishRepository.findById(wishDto.getWishId()).orElseThrow(()-> new RuntimeException("존재하지 않는 리뷰입니다."));

        entity.changeWishState(wishDto.isWishState());

        return wishRepository.save(entity);
    }


    public void delete(Long id) {
        WishEntity entity = wishRepository.findById(id).orElseThrow(()-> new RuntimeException("존재하지 않는 리뷰입니다."));

        wishRepository.delete(entity);
    }



    public Header<List<WishDto>> getWishList(Pageable pageable, Long uid, Long hid) {

        List<WishDto> dtos = new ArrayList<>();

        Page<WishEntity> wishEntities = wishRepositoryCustom.findAllReview(pageable, uid,hid);

        for (WishEntity entity : wishEntities) {

          WishDto dto = WishDto.builder()
                  .wishId(entity.getWishId())
                  .petHospitalNum(entity.getPetHospitalEntity().getHospitalId())
                  .userNum(entity.getUserEntity().getIdx())
                  .wishState(entity.isWishState())
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
}
