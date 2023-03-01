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
    private float score;

    private String hospitalName;
    private String fileName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ColumnDefault("false")
    private boolean deleteYn;

    @Transient
    private MultipartFile file;

    @ColumnDefault("0")
    private int approveYn;

    public void changeReview(String content, float score,String fileName, LocalDateTime updatedAt){
        this.content = content;
        this.score = score;
        this.fileName = fileName;
        this.updatedAt = updatedAt;
    }

    public void changeDeleteState() {
        this.deleteYn = true;
    }
}
