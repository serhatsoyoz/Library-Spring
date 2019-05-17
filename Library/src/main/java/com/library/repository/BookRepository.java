package com.library.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.library.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
}
