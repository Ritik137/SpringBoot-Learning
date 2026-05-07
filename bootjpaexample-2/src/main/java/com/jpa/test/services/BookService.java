package com.jpa.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.dao.BookRepository;
import com.jpa.test.entites.Book;

@Service
public class BookService {

    // Injecting BookRepository object
    @Autowired
    private BookRepository bookRepository;

    
    // ========================= GET METHODS =========================

    // Get all books
    public List<Book> getAllBooks() {

        // findAll() returns all records from database
        List<Book> list = (List<Book>) this.bookRepository.findAll();

        return list;
    }

    
    // Get single book by ID
    public Book getBookById(int id) {

        // findById() returns Optional<Book>
        // .orElse(null) returns null if book not found
        Book book = this.bookRepository.findById(id).orElse(null);

        return book;
    }

    
    // ========================= CREATE METHOD =========================

    // Add new book
    public Book addBook(Book b) {

        // save() inserts data into database
        Book result = bookRepository.save(b);

        return result;
    }

    
    // ========================= DELETE METHOD =========================

    // Delete book by ID
    public void deleteBook(int bid) {

        // deleteById() deletes record from database
        bookRepository.deleteById(bid);
    }

    
    // ========================= UPDATE METHOD =========================

    // Update existing book
    public void updateBook(Book book, int bookId) {

        // First fetch old book data from database
        Book oldBook = bookRepository.findById(bookId).orElse(null);

        // Check if book exists
        if (oldBook != null) {

            // Updating values
            oldBook.setTitle(book.getTitle());
            oldBook.setAuthor(book.getAuthor());

            // Save updated data
            bookRepository.save(oldBook);
        }
    }
}