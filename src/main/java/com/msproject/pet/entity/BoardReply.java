package com.msproject.pet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BoardReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    private BoardEntity boardEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    private String contents;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ColumnDefault("false")
    private boolean deleteYn;

    public void changeReply(String contents, LocalDateTime now) {
        this.contents = contents;
        this.updatedAt = now;
    }

    public void changeDeleteState() {
        this.deleteYn = true;
    }
}
