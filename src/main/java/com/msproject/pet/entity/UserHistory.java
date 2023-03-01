package com.msproject.pet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name="TB_USER")
@Entity
public class UserHistory extends BaseEntity {

    @Id
    @Column(name = "user_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String userId;
    private String userPw;
    private String userName;

    private String phoneNum;

    private String zipCode;

    private String addr;

    private String detailAddr;

    private String email; // 0208

    private String created;

    private String updated;

    @ColumnDefault("false") //default 0
    private boolean deleteYn;
}
