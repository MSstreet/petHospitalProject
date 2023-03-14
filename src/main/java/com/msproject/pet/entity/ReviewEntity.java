package com.msproject.pet.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.sql.ordering.antlr.Factory;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "ReviewEntity", indexes = {
        @Index(name = "idx_review_hospital_id", columnList = "pet_hospital_entity_hospital_id")
})
@Entity
public class ReviewEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_idx")
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    private PetHospitalEntity petHospitalEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    //@OnDelete(action= OnDeleteAction.CASCADE)
    private UserEntity userEntity;
    private String content;

    private int priceScore;

    private int kindnessScore;

    private int effectScore;
    private float score;
    private float tmpScore;

    private String hospitalName;
    private String fileName;

    private String originalFileName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ColumnDefault("false")
    private boolean deleteYn;

    @Transient
    private MultipartFile file;

    @ColumnDefault("false")
    private boolean approveYn;

    public void changeReview(String content, float score,String fileName, LocalDateTime updatedAt,String originalFileName, int priceScore, int kindnessScore, int effectScore){
        this.content = content;
        this.score = 0;
        this.tmpScore = score;
        this.fileName = fileName;
        this.updatedAt = updatedAt;
        this.originalFileName = originalFileName;
        this.approveYn = false;
        this.priceScore = priceScore;
        this.kindnessScore = kindnessScore;
        this.effectScore = effectScore;
    }

    public void changeDeleteState() {

        this.deleteYn = true;
        this.score = 0;
    }
}
