package com.example.myappfortrainnier.facade;

import com.example.myappfortrainnier.dto.BookDTO;
import com.example.myappfortrainnier.dto.ReaderDTO;

import java.util.List;

public interface ReaderFacade {
    List<ReaderDTO> getAllReaders();
    ReaderDTO getReader(Long id);
    ReaderDTO updateReader(ReaderDTO readerDTO, Long readerId);
    ReaderDTO createReader(ReaderDTO readerDTO);
    void deleteById(Long id);

    List<BookDTO> receiveListOfReaderBooks(Long readerId);
}
