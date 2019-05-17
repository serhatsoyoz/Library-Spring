package com.library.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.library.model.BookType;

@Repository
public interface BookTypeRepository extends CrudRepository<BookType, Long> {

}
