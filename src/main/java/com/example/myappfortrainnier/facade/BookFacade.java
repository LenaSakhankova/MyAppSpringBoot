package com.example.myappfortrainnier.facade;

import com.example.myappfortrainnier.dto.BookDTO;
import com.example.myappfortrainnier.dto.ReaderDTO;

import java.util.List;
import java.util.Optional;

public interface BookFacade {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    List<BookDTO> getAllBooksInUse();
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(BookDTO bookDTO, Long id);
    void deleteBook(Long id);
    ReaderDTO getOwner(Long bookId);

    void assignBookToReader(Long bookId, Long readerId);

    void releaseBookFromReader(Long bookId);
}
