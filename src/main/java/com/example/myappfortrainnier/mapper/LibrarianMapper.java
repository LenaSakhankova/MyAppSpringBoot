package com.example.myappfortrainnier.mapper;


import com.example.myappfortrainnier.dto.LibrarianDTO;
import com.example.myappfortrainnier.entity.LibrarianEntity;
import org.springframework.stereotype.Component;

@Component
public class LibrarianMapper {

    public LibrarianDTO toDTO(LibrarianEntity librarian) {
        LibrarianDTO dto = new LibrarianDTO();

        dto.setId(librarian.getId());
        dto.setFIO(librarian.getFIO());
        dto.setPhoneNumber(librarian.getPhoneNumber());
        dto.setYearOfBirth(librarian.getYearOfBirth());

        return dto;
    }

    public LibrarianEntity toEntity(LibrarianDTO dto) {
        LibrarianEntity librarian = new LibrarianEntity();

        librarian.setId(dto.getId());
        librarian.setFIO(dto.getFIO());
        librarian.setPhoneNumber(dto.getPhoneNumber());
        librarian.setYearOfBirth(dto.getYearOfBirth());

        return librarian;
    }
}
