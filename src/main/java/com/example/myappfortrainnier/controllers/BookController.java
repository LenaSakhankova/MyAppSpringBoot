package com.example.myappfortrainnier.controllers;

import com.example.myappfortrainnier.dto.BookDTO;
import com.example.myappfortrainnier.dto.ReaderDTO;
import com.example.myappfortrainnier.facade.BookFacade;
import com.example.myappfortrainnier.facade.ReaderFacade;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookFacade bookFacade;
    private final ReaderFacade readerFacade;

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookFacade.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long id) {
        BookDTO book = bookFacade.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @PostMapping()
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO book,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        BookDTO createdBook = bookFacade.createBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@RequestBody @Valid BookDTO book,
                                              BindingResult bindingResult,
                                              @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        BookDTO updatedBook = bookFacade.updateBook(book, id);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long id) {
        bookFacade.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/release")
    public ResponseEntity<Void> releaseBook(@PathVariable("id") Long id) {
        bookFacade.releaseBookFromReader(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/assign")
    public ResponseEntity<Void> assignBook(@PathVariable("id") Long id,
                                           @RequestBody ReaderDTO reader) {
        bookFacade.assignBookToReader(id, reader.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/inUse")
    public ResponseEntity<List<BookDTO>> getAllBooksInUse() {
        List<BookDTO> booksInUse = bookFacade.getAllBooksInUse();
        return ResponseEntity.ok(booksInUse);
    }
}

//package com.example.myappfortrainnier.controllers;
//
//import com.example.myappfortrainnier.dto.BookDTO;
//import com.example.myappfortrainnier.dto.ReaderDTO;
//import com.example.myappfortrainnier.facade.BookFacade;
//import com.example.myappfortrainnier.facade.ReaderFacade;
//import jakarta.validation.Valid;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Objects;
////@Controller
//@Controller
//@AllArgsConstructor
//@RequestMapping("/books")
//public class BookController {
//
//    private final BookFacade bookFacade;
//    private final ReaderFacade readerFacade;
//
////    @GetMapping("/test/{id}")
////    public BookDTO testBook(@PathVariable("id") Long id){
////        return bookFacade.getBookById(id);
////    }
//
//
//    @GetMapping()
//    public String index(Model model) {
//        model.addAttribute("books", bookFacade.getAllBooks());
//        return "book/index";
//    }
//
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, Model model) {
//
//        BookDTO bookDTO = bookFacade.getBookById(id);
//
//        model.addAttribute("book", bookDTO);
//
//        if(Objects.nonNull(bookDTO.getPersonId())){
//            ReaderDTO readerDTO = readerFacade.getReader(bookDTO.getPersonId());
//            if (Objects.nonNull(readerDTO)) {
//                model.addAttribute("owner", readerDTO);
//            }
//        }else{
//            List<ReaderDTO> people = readerFacade.getAllReaders();
//            model.addAttribute("people", people);
//            model.addAttribute("person", new ReaderDTO());
//        }
//
//
//
//        return "book/show";
//    }
//
//    @GetMapping("/new")
//    public String newBook(@ModelAttribute("book") BookDTO book) {
//        return "book/new";
//    }
//
//    @GetMapping("/create")
//    public String create(@ModelAttribute("book") @Valid BookDTO book, BindingResult bindingResult) {
//        if (bindingResult.hasErrors())
//            return "book/new";
//
//        bookFacade.createBook(book);
//        return "redirect:/books";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("book", bookFacade.getBookById(id));
//        return "book/edit";
//    }
//
//    @PostMapping("/{id}")
//    public String update(@ModelAttribute("book") @Valid BookDTO book, BindingResult bindingResult,
//                         @PathVariable("id") Long id) {
//        if (bindingResult.hasErrors())
//            return "book/edit";
//   //     book.setId(id);
//        bookFacade.updateBook(book, id);
//        return "redirect:/books";
//    }
//
//    @GetMapping("/{id}/delete")
//    public String delete(@PathVariable("id") Long id) {
//        bookFacade.deleteBook(id);
//        return "redirect:/books";
//    }
//
//    @PostMapping("/{id}/release")
//    public String release(@PathVariable("id") Long id) {
//        bookFacade.releaseBookFromReader(id);
//        return "redirect:/books/" + id;
//    }
//
//    @PostMapping("/{id}/assign")
//    public String assign(@PathVariable("id") Long id, @ModelAttribute("person") ReaderDTO reader) {
//        bookFacade.assignBookToReader(id, reader.getId());
//        return "redirect:/books/" + id;
//    }
//
//    @GetMapping("/bookInUse")
//    public String bookInUse(Model model) {
//        model.addAttribute("books", bookFacade.getAllBooksInUse());
//        return "book/bookInUse";
//    }
//}
