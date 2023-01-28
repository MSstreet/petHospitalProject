package com.msproject.pet.service;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.Pagination;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.repository.PetHospitalRepositortCustom;
import com.msproject.pet.repository.PetHospitalRepository;

import com.msproject.pet.web.dtos.PetHospitalDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Slf4j
@Service
public class PetHospitalService {

    private final PetHospitalRepository petHospitalRepository;

    private final PetHospitalRepositortCustom petHospitalRepositortCustom;

    public PetHospitalEntity create(PetHospitalDto petHospitalDto) {

       PetHospitalEntity entity = PetHospitalEntity.builder()
               .sigunName(petHospitalDto.getSigunName())
               .hospitalName(petHospitalDto.getHospitalName())
               .hospitalNum(petHospitalDto.getHospitalNum())
               .hospitalAddr(petHospitalDto.getHospitalAddr())
               .hospitalScore(petHospitalDto.getHospitalScore())
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


    public Header<List<PetHospitalDto>> getHospitalList(Pageable pageable, SearchCondition searchCondition) {
        List<PetHospitalDto> dtos = new ArrayList<>();

        Page<PetHospitalEntity> hospitalEntities = petHospitalRepositortCustom.findAllBySearchCondition(pageable, searchCondition);

        for (PetHospitalEntity entity : hospitalEntities) {

            PetHospitalDto dto = PetHospitalDto.builder()
                    .hospitalId(entity.getHospitalId())
                    .hospitalName(entity.getHospitalName())
                    .sigunName(entity.getSigunName())
                    .hospitalNum(entity.getHospitalNum())
                    .hospitalAddr(entity.getHospitalAddr())
                    .hospitalScore(entity.getHospitalScore())
                    .build();

            dtos.add(dto);
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
//        File stocks = new File(Paths.get("").toAbsolutePath() + "/src/main/java/숙제20211207/Stocks.xml");
//
//        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//        Document doc = dBuilder.parse(stocks);
//        doc.getDocumentElement().normalize();
//        System.out.println("파일출력");
//
//        // 읽어들인 파일 불러오기
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
