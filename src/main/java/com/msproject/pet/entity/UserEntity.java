package com.msproject.pet.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Table(name="TB_USER")
@Entity
public class UserEntity extends BaseEntity{

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

    @ColumnDefault("false") //default 0
    private boolean deleteYn;

    public void changePassword(String userPw){
        this.userPw = userPw;
    }

    public void change(String userName, String phoneNum, String zipCode, String addr, String detailAddr,String email){
        this.userName =userName;
        this.phoneNum = phoneNum;
        this.zipCode = zipCode;
        this.addr = addr;
        this.detailAddr = detailAddr;
        this.email = email;
        //this.updatedAt = updatedAt;
    }

    public void changePw(String userPw){
        this.userPw = userPw;
    }

    public void changeState(){
        this.deleteYn = true;
    }
}
