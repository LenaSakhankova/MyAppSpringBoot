package com.example.myappfortrainnier.repository;

import com.example.myappfortrainnier.entity.LibrarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrarianRepository extends JpaRepository<LibrarianEntity, Long> {
}