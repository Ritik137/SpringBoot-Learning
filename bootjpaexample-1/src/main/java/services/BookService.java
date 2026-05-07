package services;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Component;

import entities.Book;

@Component
public class BookService { 
	
	private static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(12, "java Complete Reference", "XYZ"));
		list.add(new Book(36, "Head first to java", "ABC"));
		list.add(new Book(1234, "Thing in java", "LMN"));
	}
}
