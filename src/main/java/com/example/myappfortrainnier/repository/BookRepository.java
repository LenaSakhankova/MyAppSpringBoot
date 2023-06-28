package com.example.myappfortrainnier.repository;

import com.example.myappfortrainnier.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByReaderIsNotNull();
}
