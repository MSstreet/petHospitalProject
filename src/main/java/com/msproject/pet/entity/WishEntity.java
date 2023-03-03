package com.msproject.pet.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class WishEntity {

    @Id
    @Column(name = "wish_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishId;

    @ManyToOne(fetch = FetchType.LAZY)
    private PetHospitalEntity petHospitalEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private UserEntity userEntity;

    //private boolean wishState; //삭제
    private int wishState1;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public void changeWishState(int wishState1){
        this.wishState1 = wishState1;
    }

    public void changeWishState1(){
        this.wishState1 = 0;
    }
}
