package com.msproject.pet.repository;

import com.msproject.pet.entity.PetHospitalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PetHospitalRepository extends JpaRepository<PetHospitalEntity, Long> {


}
