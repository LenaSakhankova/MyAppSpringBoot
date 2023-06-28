package com.example.myappfortrainnier.controllers;

import com.example.myappfortrainnier.dto.ReaderDTO;
import com.example.myappfortrainnier.facade.ReaderFacade;
import com.example.myappfortrainnier.valid.ReaderValidation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@AllArgsConstructor
public class ReaderController {
    private final ReaderFacade readerFacade;
    private final ReaderValidation readerValidation;

    @GetMapping()
    public ResponseEntity<List<ReaderDTO>> getAllReaders() {
        List<ReaderDTO> readers = readerFacade.getAllReaders();
        return ResponseEntity.ok(readers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReaderDTO> getReaderById(@PathVariable("id") Long id) {
        ReaderDTO reader = readerFacade.getReader(id);
        return ResponseEntity.ok(reader);
    }

    @PostMapping("/create")
    public ResponseEntity<ReaderDTO> createReader(@RequestBody @Valid ReaderDTO reader,
                                                  BindingResult bindingResult) {
        readerValidation.validate(reader, bindingResult);

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        ReaderDTO createdReader = readerFacade.createReader(reader);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReader);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReaderDTO> updateReader(@RequestBody @Valid ReaderDTO reader,
                                                  BindingResult bindingResult,
                                                  @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        ReaderDTO updatedReader = readerFacade.updateReader(reader, id);
        return ResponseEntity.ok(updatedReader);
    }

    @GetMapping("/{id}/delete")
    public ResponseEntity<Void> deleteReader(@PathVariable("id") Long id) {
        readerFacade.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}