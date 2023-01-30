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
