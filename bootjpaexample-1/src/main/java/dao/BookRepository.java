package dao;

import org.springframework.data.jpa.repository.JpaRepository;   
import entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
