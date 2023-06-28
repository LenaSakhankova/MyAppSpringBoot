package com.example.myappfortrainnier.service;

import com.example.myappfortrainnier.entity.BookEntity;
import com.example.myappfortrainnier.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final ReaderService readerService;

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookEntity getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not found"));
    }
    public  List<BookEntity> getAllBooksInUse()
    {
        return bookRepository.findByReaderIsNotNull();
    }
    @Transactional
    public void createBook(BookEntity bookEntity) {
        bookRepository.save(bookEntity);
    }

    @Transactional
    public BookEntity updateBook(BookEntity book, Long id) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public void assignBookToReader(Long bookId, Long readerId) {
        BookEntity bookEntity = getBook(bookId);
        bookEntity.setReader(readerService.findById(readerId));
    }

    @Transactional
    public void releaseBookFromReader(Long bookId) {
        BookEntity bookEntity = getBook(bookId);
        bookEntity.setReader(null);
    }
}
