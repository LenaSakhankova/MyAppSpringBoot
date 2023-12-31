package com.example.myappfortrainnier.repository;

import com.example.myappfortrainnier.entity.ReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<ReaderEntity, Long> {

}
