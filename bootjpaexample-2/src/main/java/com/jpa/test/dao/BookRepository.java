package com.jpa.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entites.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}