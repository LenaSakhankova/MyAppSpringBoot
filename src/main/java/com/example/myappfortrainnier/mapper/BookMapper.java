package com.example.myappfortrainnier.mapper;

import com.example.myappfortrainnier.dto.BookDTO;
import com.example.myappfortrainnier.entity.BookEntity;
import com.example.myappfortrainnier.entity.ReaderEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BookMapper {
    public BookDTO toBookDTO(BookEntity entity)
    {
        BookDTO dto = new BookDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAuthor(entity.getAuthor());
        dto.setTom(entity.getTom());
        dto.setYear(entity.getYear());

        ReaderEntity readerEntity = entity.getReader();
        if(Objects.nonNull(readerEntity)){
            dto.setPersonId(readerEntity.getId());
        }

        dto.setShortDescription(entity.getShortDescription());
        dto.setStorageLocation(entity.getStorageLocation());

        return dto;
    }

    public BookEntity toBookEntity(BookDTO dto)
    {
        BookEntity entity = new BookEntity();

        entity.setId(dto.getId());
        entity.setAuthor(dto.getAuthor());
        entity.setName(dto.getName());
        entity.setTom(dto.getTom());
        entity.setYear(dto.getYear());
        entity.setShortDescription(dto.getShortDescription());
        entity.setStorageLocation(dto.getStorageLocation());

        return entity;
    }
}
