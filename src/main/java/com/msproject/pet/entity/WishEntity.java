package com.msproject.pet.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class WishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishId;

    @ManyToOne(fetch = FetchType.LAZY)
    private PetHospitalEntity petHospitalEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;

    private boolean wishState;

    private int wishState1;

    public void changeWishState(int wishState1){
        this.wishState1 = wishState1;
    }
}
