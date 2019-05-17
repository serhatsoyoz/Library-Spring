package com.library.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.model.Book;
import com.library.model.BookType;
import com.library.repository.BookRepository;
import com.library.repository.BookTypeRepository;

@Service
public class LibraryService {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookTypeRepository bookTypeRepository;
	
	public Collection<Book> findAllBooks() {
		List<Book> bookList = new ArrayList<Book>();
		
		for (Book book : bookRepository.findAll())
			bookList.add(book);
		
		return bookList;
	}
	
	public Collection<BookType> findAllBookTypes() {
		List<BookType> bookTypeList = new ArrayList<BookType>();
		
		for (BookType bookType : bookTypeRepository.findAll())
			bookTypeList.add(bookType);
		
		return bookTypeList;
	}
	
	public Book findBook(long id) {
		Optional<Book> book = bookRepository.findById(id);
		
		return book.orElse(new Book());
	}
	
	public BookType findBookType(long id) {
		Optional<BookType> bookType = bookTypeRepository.findById(id);
		
		return bookType.orElse(new BookType());
	}
	
	public void saveBook(Book book) {
		bookRepository.save(book);
	}
	
	public void saveBookType(BookType bookType) {
		bookTypeRepository.save(bookType);
	}
	
	public void deleteBookById(long id) {
		bookRepository.deleteById(id);
	}
	
	public void deleteBookTypeById(long id) {
		bookTypeRepository.deleteById(id);
	}
}
