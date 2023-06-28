package com.example.myappfortrainnier.facade;

import com.example.myappfortrainnier.dto.LibrarianDTO;
import com.example.myappfortrainnier.entity.LibrarianEntity;
import com.example.myappfortrainnier.mapper.LibrarianMapper;
import com.example.myappfortrainnier.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LibrarianFacadeImpl implements LibrarianFacade {

    private final LibrarianService librarianService;
    private final LibrarianMapper librarianMapper;


    @Autowired
    public LibrarianFacadeImpl(LibrarianService librarianService, LibrarianMapper librarianMapper) {
        this.librarianService = librarianService;
        this.librarianMapper = librarianMapper;
    }
    @Override
    public LibrarianDTO getLibrarianById(Long id) {
        LibrarianEntity librarian = librarianService.getLibrarianById(id);
        return librarianMapper.toDTO(librarian);
    }
    @Override
    public List<LibrarianDTO> getAllLibrarians() {
        List<LibrarianEntity> librarians = librarianService.getAllLibrarians();

        List<LibrarianDTO> librarianDTOS = new ArrayList<>();

        for (int i = 0; i < librarians.size(); i++)
        {
            librarianDTOS.add(librarianMapper.toDTO(librarians.get(i)));
        }

        return librarianDTOS;
    }

    @Override
    public LibrarianDTO createLibrarian(LibrarianDTO librarianDTO) {
        LibrarianEntity librarianEntity = librarianMapper.toEntity(librarianDTO);
        librarianService.saveLibrarian(librarianEntity);
        return librarianMapper.toDTO(librarianEntity);
    }

    @Override
    public LibrarianDTO updateLibrarian(LibrarianDTO librarianDTO, Long librarianId) {
        LibrarianEntity librarian = librarianMapper.toEntity(librarianDTO);
        librarian.setId(librarianId); // Set the ID of the librarian entity
        librarianService.saveLibrarian(librarian);
        return librarianMapper.toDTO(librarian);
    }

    @Override
    public void deleteLibrarian(Long librarianId) {
        librarianService.deleteLibrarian(librarianId);
    }
}