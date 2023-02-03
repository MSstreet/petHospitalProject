package com.msproject.pet.web;

import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.entity.WishEntity;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.service.WishService;
import com.msproject.pet.web.dtos.ReviewDto;
import com.msproject.pet.web.dtos.WishDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class WishController {

    private final WishService wishService;

    @PostMapping("/wish")
    public WishEntity createWish(@RequestBody WishDto wishDto){

        if(getWish1(wishDto.getUserNum(),wishDto.getPetHospitalNum()) != null){
            return update(wishDto);
        }

        return wishService.wishCreate(wishDto);
    }


//    @GetMapping("/wish/{id}")
//    public WishDto getWish(@PathVariable Long id){
//        return wishService.();
//    }

//    @GetMapping("/wish/list/{uid}/{hid}")
//    public Header<List<ReviewDto>> reviewList(@PathVariable Long uid,
//                                              @PathVariable Long hid,
//                                              @PageableDefault(sort = {"idx"}) Pageable pageable,
//                                              SearchCondition searchCondition)
//    {
//        return wishService.get(pageable, searchCondition, id);
//    }

    @PatchMapping("/wish")
    public WishEntity update(@RequestBody WishDto wishDto){
        return wishService.update(wishDto);
    }


    @DeleteMapping("/wish/{id}")
    public void delete(@PathVariable Long id){
        wishService.delete(id);
    }

//    @GetMapping("/wish/list/{uid}/{hid}")
//    public Header<List<WishDto>> wishList(@PathVariable Long uid,
//                                          @PathVariable Long hid,
//                                              @PageableDefault(sort = {"idx"}) Pageable pageable,
//                                              SearchCondition searchCondition)
//    {
//        return wishService.getWishList(pageable,uid,hid);
//    }

    @GetMapping("/wish/list/{uid}")
    public Header<List<WishDto>> wishList(@PathVariable Long uid,
                                          @PageableDefault(sort = {"idx"}) Pageable pageable)
    {
        return wishService.getWishList(pageable,uid);
    }

    @GetMapping("/wish/{id}")
    public WishDto getWish(@PathVariable Long id){
        return wishService.getWish(id);
    }

    @GetMapping("/wish/one/{uid}/{hid}")
    public WishDto getWish1(@PathVariable Long uid,@PathVariable Long hid){
        return wishService.getWish1(uid,hid);
    }


}
