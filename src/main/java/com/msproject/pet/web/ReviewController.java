package com.msproject.pet.web;

import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.service.ReviewService;

import com.msproject.pet.web.dtos.ReviewDto;
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
public class ReviewController {

    private final ReviewService reviewService;


    @PostMapping("/review/join")
    public ReviewEntity create(@RequestBody ReviewDto reviewDto) throws Exception{

        System.out.println(reviewDto.getScore());
        System.out.println(reviewDto.getPetHospitalNum());
        System.out.println("-----------------------------------------------------------");

        return reviewService.ReviewCreate(reviewDto);

    }


    @GetMapping("/review/list/{id}")
    public Header<List<ReviewDto>> reviewList(@PathVariable Long id,
            @PageableDefault(sort = {"idx"}) Pageable pageable,
            SearchCondition searchCondition)
    {
        return reviewService.getReviewList(pageable, searchCondition, id);
    }

    @GetMapping("/review/avg/{id}")
    public float getReviewAvg(@PathVariable Long id){
        System.out.println(id);
        System.out.println("들어오는지 확인");

        //float avg = reviewService.getReviewAvg(id);
        //avg = Math.round(avg*10) / 10;

        return reviewService.getReviewAvg(id);
    }


    @GetMapping("/review/{id}")
    public ReviewDto getReview(@PathVariable Long id){
        return reviewService.getReview(id);
    }


    @PatchMapping("/review")
    public ReviewEntity update(@RequestBody ReviewDto reviewDto){
        return reviewService.update(reviewDto);
    }


    @DeleteMapping("/review/{id}")
    public void delete(@PathVariable Long id){
        reviewService.delete(id);
    }
}
