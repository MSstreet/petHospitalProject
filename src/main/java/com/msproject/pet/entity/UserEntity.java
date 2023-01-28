package com.msproject.pet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="TB_USER")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String userId;
    private String userPw;
    private String userName;


    //////////////////////////////////
    private String phoneNum;

    private String zipCode;

    private String addr;

    private String detailAddr;

    private boolean deleteYn;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public void changePassword(String userPw){
        this.userPw = userPw;
    }

    public void change(String userName){

    }
}
