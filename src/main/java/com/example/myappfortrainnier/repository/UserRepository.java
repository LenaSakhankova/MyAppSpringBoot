package com.example.myappfortrainnier.repository;

import com.example.myappfortrainnier.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
        Optional<UserEntity> findByUsername(String userName);
}
