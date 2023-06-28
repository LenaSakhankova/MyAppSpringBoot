package com.example.myappfortrainnier.controllers;

import com.example.myappfortrainnier.dto.LibrarianDTO;
import com.example.myappfortrainnier.facade.LibrarianFacade;
import com.example.myappfortrainnier.valid.LibrarianValidation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/librarians")
@AllArgsConstructor
public class LibrarianController {

    private final LibrarianFacade librarianFacade;
    private final LibrarianValidation librarianValidation;

    @GetMapping("/{id}")
    public ResponseEntity<LibrarianDTO> getLibrarianById(@PathVariable Long id) {
        LibrarianDTO librarianDTO = librarianFacade.getLibrarianById(id);
        return ResponseEntity.ok(librarianDTO);
    }

    @GetMapping()
    public ResponseEntity<List<LibrarianDTO>> getAllLibrarians() {
        List<LibrarianDTO> librarianDTOList = librarianFacade.getAllLibrarians();
        return ResponseEntity.ok(librarianDTOList);
    }

    @PostMapping()
    public ResponseEntity<LibrarianDTO> createLibrarian(@RequestBody @Valid LibrarianDTO librarian,
                                                        BindingResult bindingResult) {
        librarianValidation.validate(librarian, bindingResult);

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        LibrarianDTO createdLibrarian = librarianFacade.createLibrarian(librarian);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLibrarian);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibrarianDTO> updateLibrarian(@RequestBody @Valid LibrarianDTO librarianDTO,
                                                        BindingResult bindingResult,
                                                        @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        LibrarianDTO updatedLibrarian = librarianFacade.updateLibrarian(librarianDTO, id);
        return ResponseEntity.ok(updatedLibrarian);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrarian(@PathVariable("id") Long id) {
        librarianFacade.deleteLibrarian(id);
        return ResponseEntity.noContent().build();
    }
}