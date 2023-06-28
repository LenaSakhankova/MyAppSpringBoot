package com.example.myappfortrainnier.facade;

import com.example.myappfortrainnier.dto.BookDTO;
import com.example.myappfortrainnier.dto.ReaderDTO;
import com.example.myappfortrainnier.entity.BookEntity;
import com.example.myappfortrainnier.entity.ReaderEntity;
import com.example.myappfortrainnier.mapper.BookMapper;
import com.example.myappfortrainnier.mapper.ReaderMapper;
import com.example.myappfortrainnier.service.BookService;
import com.example.myappfortrainnier.service.ReaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class BookFacadeImpl implements BookFacade{
    private final BookService bookService;
    private final BookMapper bookMapper;
    public final ReaderMapper readerMapper;

    private final ReaderService readerService;

    @Override
    public List<BookDTO> getAllBooks()
    {
        return bookService.getAllBooks().stream()
                .map(bookEntity -> bookMapper.toBookDTO(bookEntity))
                .collect(Collectors.toList());
    }
    @Override
    public BookDTO getBookById(Long id) {

        return bookMapper.toBookDTO(bookService.getBook(id));
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        BookEntity bookEntity = bookMapper.toBookEntity(bookDTO);
        bookService.createBook(bookEntity);
        return bookMapper.toBookDTO(bookEntity);
    }
    @Override
    public BookDTO updateBook(BookDTO bookDTO, Long id) {
        BookEntity bookEntity = bookMapper.toBookEntity(bookDTO);
        if (bookDTO.getPersonId() != null) {
            bookEntity.setReader(readerService.findById(bookDTO.getPersonId()));
        }
        BookEntity updatedBook = bookService.updateBook(bookEntity, id);
        return bookMapper.toBookDTO(updatedBook);
    }

    @Override
    public List<BookDTO> getAllBooksInUse(){
         return bookService.getAllBooksInUse().stream()
                 .map(bookEntity -> bookMapper.toBookDTO(bookEntity))
                 .collect(Collectors.toList());
    };

    @Override
    public void deleteBook(Long id) {
        bookService.deleteBook(id);
    }

    @Override
    public ReaderDTO getOwner(Long bookId){

       ReaderEntity readerEntity = bookService.getBook(bookId).getReader();

       if(Objects.nonNull(readerEntity)){
           return readerMapper.toReaderDTO(readerEntity);
       }else {
          return new ReaderDTO();
        }

    }

    @Override
    public void assignBookToReader(Long bookId, Long readerId) {
        bookService.assignBookToReader(bookId, readerId);
    }

    @Override
    public void releaseBookFromReader(Long bookId) {
        bookService.releaseBookFromReader(bookId);
    }
}
