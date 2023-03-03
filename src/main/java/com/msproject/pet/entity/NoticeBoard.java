package com.msproject.pet.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class NoticeBoard {

    @Id
    @Column(name = "notice_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nboardId;

    private String title;

    private String contents;

    @ColumnDefault("true")
    private boolean display_yn;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ColumnDefault("false") //default 0
    private boolean deleteYn;


}
