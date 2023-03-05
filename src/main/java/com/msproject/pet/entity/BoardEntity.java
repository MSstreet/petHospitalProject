package com.msproject.pet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="BOARD")
@Entity
public class BoardEntity {

    @Id
    @Column(name = "board_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;

    private String contents;

    private String author; // 삭제해도 됨

    @ManyToOne(fetch = FetchType.LAZY)
    //@OnDelete(action= OnDeleteAction.CASCADE)
    private UserEntity userEntity;

//    @Column(name = "created_at")
//    @CreatedDate
//    private String createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));

//    @Column(name = "updated_at")
//    @CreatedDate
//    private String updatedAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ColumnDefault("false")
    private boolean deleteYn;

    public void changeState(){
        this.deleteYn = true;
    }

    public void changeDeleteState() {
        this.deleteYn = true;
    }
}
