package com.msproject.pet.entity;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.sql.ordering.antlr.Factory;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="userEntity")
//    private UserEntity userEntity;

//    private Long userIdx;

    private String content;

    private float score;

    private boolean deleteYn;

    public void changeReview(String content, float score){
        this.content = content;
        this.score = score;
    }

}
