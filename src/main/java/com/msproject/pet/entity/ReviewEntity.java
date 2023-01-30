package com.msproject.pet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.sql.ordering.antlr.Factory;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "ReviewEntity", indexes = {
        @Index(name = "idx_review_hospital_id", columnList = "pet_hospital_entity_hospital_id")
})
@Entity
public class ReviewEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    private PetHospitalEntity petHospitalEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    private String content;

    private float score;

    private boolean deleteYn;

}
