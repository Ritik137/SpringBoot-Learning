package controllers;
import entities.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	 private BookRepository repo;
	
	@GetMapping("/books")
	public List<entities.Book> getAllBooks(){
		return repo.findAll();
	}
	
	@PostMapping("/post-books")
	public Book add(@RequestBody Book b) {
		return repo.save(b);
	}
	
}
