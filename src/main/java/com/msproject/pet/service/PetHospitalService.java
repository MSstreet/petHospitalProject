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

//        PetHospitalEntity entity = PetHospitalEntity.builder()
//                .sigunName(petHospitalDto.getSigunName())
//                .hospitalName(petHospitalDto.getHospitalName())
//                .hospitalNum(petHospitalDto.getHospitalNum())
//                .hospitalAddr(petHospitalDto.getHospitalAddr())
//                .build();

        return petHospitalRepository.save(entity);
    }

    public PetHospitalEntity update(PetHospitalDto petHospitalDto) {

        PetHospitalEntity entity = petHospitalRepository.findById(petHospitalDto.getHospitalId()).orElseThrow(()-> new RuntimeException("???????????? ?????? ?????????????????????."));

        entity.change(petHospitalDto.getHospitalName(), petHospitalDto.getHospitalNum(), petHospitalDto.getHospitalAddr(), petHospitalDto.getSigunName());

        return petHospitalRepository.save(entity);
    }

    public void delete(Long id) {
        PetHospitalEntity entity = petHospitalRepository.findById(id).orElseThrow(()-> new RuntimeException("???????????? ?????? ?????????????????????."));

        petHospitalRepository.delete(entity);
    }


    public PetHospitalDto getPetHospital(Long id) {
        PetHospitalEntity entity = petHospitalRepository.findById(id).orElseThrow(() -> new RuntimeException("???????????? ?????? ?????????????????????."));

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

        System.out.println("0??????????!"+petHospitalListReviewCountDto.getHospitalScore());


        Optional<PetHospitalEntity> petHospitalEntity = petHospitalRepository.findById(id);

        PetHospitalEntity result = petHospitalEntity.orElseThrow();

        List<ReviewEntity> reviewEntities = reviewRepository.findByPetHospitalEntity(result);
//
//        float sum = 0;
//        System.out.println("????????????!!!!!!!!!!!!" + reviewEntities.size());


//        for(int i = 0; i < reviewEntities.size(); i ++){
//            sum = reviewEntities.get(i).getScore();
//            System.out.println(sum);
//        }

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
//            if(dto.getOperState().equals("??????")) {
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

//        System.out.println(hospitalEntities.getTotalElements());

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

            if(dto.getOperState().equals("??????")) {
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
//            if(dto.getOperState().equals("??????")) {
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

//    public void SavePetHospital() throws Exception {
//
//        File stocks = new File(Paths.get("").toAbsolutePath() + "/src/main/java/??????20211207/Stocks.xml");
//
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//        Document doc = dBuilder.parse(stocks);
//        doc.getDocumentElement().normalize();
//        System.out.println("????????????");
//
//        // ???????????? ?????? ????????????
//        NodeList nodes = doc.getElementsByTagName("stock");
//
//        for (int k = 0; k < nodes.getLength(); k++) {
//            Node node = nodes.item(k);
//
//            if (node.getNodeType() == Node.ELEMENT_NODE) {
//                Element element = (Element) node;
//                System.out.println("Stock Symbol: " + getValue("symbol", element));
//                System.out.println("Stock Price: " + getValue("price", element));
//                System.out.println("Stock Quantity: " + getValue("quantity", element));
//
//            }
//        }
//    }

}
