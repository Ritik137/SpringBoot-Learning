package com.jpa.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.entites.Book;
import com.jpa.test.services.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    
    // ================= GET ALL BOOKS =================
    
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {

        try {

            List<Book> list = this.bookService.getAllBooks();

            if(list.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return ResponseEntity.ok(list);

        } catch(Exception e) {

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // ================= GET SINGLE BOOK =================

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

        try {

            Book book = this.bookService.getBookById(id);

            if(book == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            return ResponseEntity.ok(book);

        } catch(Exception e) {

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // ================= CREATE BOOK =================

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {

        try {

            Book b = this.bookService.addBook(book);

            return ResponseEntity.status(HttpStatus.CREATED).body(b);

        } catch(Exception e) {

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // ================= UPDATE BOOK =================

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(
            @RequestBody Book book,
            @PathVariable("bookId") int bookId) {

        try {

            this.bookService.updateBook(book, bookId);

            return ResponseEntity.ok(book);

        } catch(Exception e) {

            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}