package com.example.myappfortrainnier.service;


import com.example.myappfortrainnier.entity.LibrarianEntity;
import com.example.myappfortrainnier.repository.LibrarianRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;

    public LibrarianEntity getLibrarianById(Long id) {
        return librarianRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Librarian not found"));
    }

    public List<LibrarianEntity> getAllLibrarians(){return librarianRepository.findAll();}

    @Transactional
    public void saveLibrarian(LibrarianEntity librarian) {
        librarianRepository.save(librarian);
    }

    @Transactional
    public void deleteLibrarian(Long librarianId) {
        librarianRepository.deleteById(librarianId);
    }
}
