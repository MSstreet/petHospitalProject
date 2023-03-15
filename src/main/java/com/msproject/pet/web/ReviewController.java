package com.msproject.pet.web;

import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.exception.InCorrectImageFileException;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.service.ReviewService;

import com.msproject.pet.web.dtos.ReviewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class ReviewController {

    private final ReviewService reviewService;
    private String path = "C:\\upload\\";
    @PostMapping("/review/join")
    public ReviewEntity create(ReviewDto reviewDto) throws Exception{

        isImageFile(reviewDto.getFile());

        String originalFilename = reviewDto.getFile().getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension =  originalFilename.substring(originalFilename.lastIndexOf("."));
        String savedName = uuid + extension;
        reviewDto.setFileName(savedName);
        reviewDto.setOriginalFileName(originalFilename);
        try {
            reviewDto.getFile().transferTo(new File(path + savedName));
            return reviewService.ReviewCreate(reviewDto);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private void isImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        if (!(contentType.startsWith("image"))) {
            throw new InCorrectImageFileException();
        }
    }

    @GetMapping("/review/list/{id}")
    public Header<List<ReviewDto>> reviewList(@PathVariable Long id,
            @PageableDefault(sort = "review_id") Pageable pageable,
            SearchCondition searchCondition)
    {
        return reviewService.getReviewList(pageable, searchCondition, id);
    }

    @GetMapping("/review/user/{id}")
    public Header<List<ReviewDto>> userReviewList(@PathVariable Long id,
                                              @PageableDefault(sort = {"idx"}) Pageable pageable,
                                              SearchCondition searchCondition)
    {
        System.out.println("들어오는지 확인");
        System.out.println(id);
        return reviewService.getUserReviewList(pageable, searchCondition, id);
    }


    @GetMapping("/review/{id}")
    public ReviewDto getReview(@PathVariable Long id){
        return reviewService.getReview(id);
    }

    @PatchMapping("/review")
    public ReviewEntity update(ReviewDto reviewDto){

        reviewService.deleteImage(reviewDto.getReviewId());

        isImageFile(reviewDto.getFile());

        String originalFilename = reviewDto.getFile().getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension =  originalFilename.substring(originalFilename.lastIndexOf("."));
        String savedName = uuid + extension;

        reviewDto.setFileName(savedName);
        reviewDto.setOriginalFileName(originalFilename);
        try {
            reviewDto.getFile().transferTo(new File(path + savedName));
            return reviewService.update(reviewDto);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/review/{id}")
    public void delete(@PathVariable Long id)
    {
        reviewService.deleteImage(id);
        reviewService.delete(id);
    }


    public void deleteImage(Long id){
        reviewService.deleteImage(id);
    }


    @GetMapping("/review/hos/{id}")
    public double GetReviewAvg(@PathVariable Long id){
        return reviewService.GetReviewAvg(id);
    }
}
