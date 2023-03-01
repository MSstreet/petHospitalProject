package com.msproject.pet.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByUserId(String userId);

    //Optional<UserEntity> findById(String userId);/////////////

    boolean existsByUserId(String userId);

    //boolean existsById(String userId);//////////////////

    Boolean existsByEmail(String email);

    Optional<UserEntity> findByEmail(String Email);
    Optional<UserEntity> findByUserNameAndEmail(String userName, String Email);

    Boolean existsByUserNameAndEmail(String userName, String Email);
}
