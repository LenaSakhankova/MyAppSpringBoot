package com.example.myappfortrainnier.facade;

import com.example.myappfortrainnier.dto.LibrarianDTO;
import java.util.List;

public interface LibrarianFacade {

    LibrarianDTO getLibrarianById(Long id);
    List<LibrarianDTO> getAllLibrarians();

    LibrarianDTO createLibrarian(LibrarianDTO librarianDTO);
    LibrarianDTO updateLibrarian(LibrarianDTO librarianDTO, Long librarianId);

    void deleteLibrarian(Long librarianId);
}