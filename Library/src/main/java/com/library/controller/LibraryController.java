package com.library.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.model.Book;
import com.library.model.BookType;
import com.library.service.LibraryService;

@Controller
public class LibraryController {
	@Autowired
	private LibraryService libraryService;
	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public String get(HttpServletRequest request) {
		request.setAttribute("status", "showbooktypes");
		request.setAttribute("bookTypes", libraryService.findAllBookTypes());
		return "index";
	}
	
	@RequestMapping(path="/show/booktypes", method = RequestMethod.GET)
	public String getBookTypes(HttpServletRequest request) {
		request.setAttribute("status", "showbooktypes");
		request.setAttribute("bookTypes", libraryService.findAllBookTypes());
		return "index";
	}
	
	@RequestMapping(path="/show/books", method = RequestMethod.GET)
	public String getBooks(HttpServletRequest request) {
		request.setAttribute("status", "showbooks");
		request.setAttribute("books", libraryService.findAllBooks());
		return "index";
	}
	
	@RequestMapping(path="/edit/booktype", method = RequestMethod.GET)
	public String editBookType(@RequestParam long id, HttpServletRequest request) {
		request.setAttribute("status", "editbooktype");
		request.setAttribute("bookType", libraryService.findBookType(id));
		return "index";
	}
	
	@RequestMapping(path="/edit/book", method = RequestMethod.GET)
	public String editBook(@RequestParam long id, HttpServletRequest request) {
		request.setAttribute("status", "editbook");
		request.setAttribute("book", libraryService.findBook(id));
		request.setAttribute("bookTypes", libraryService.findAllBookTypes());
		return "index";
	}
	
	@RequestMapping(path="/new/booktype", method = RequestMethod.GET)
	public String newBookType(HttpServletRequest request) {
		request.setAttribute("status", "newbooktype");
		return "index";
	}
	
	@RequestMapping(path="/new/book", method = RequestMethod.GET)
	public String newBook(HttpServletRequest request) {
		request.setAttribute("status", "newbook");
		request.setAttribute("bookTypes", libraryService.findAllBookTypes());
		return "index";
	}
	
	@RequestMapping(path="/del/booktype", method = RequestMethod.GET)
	public String delBookType(@RequestParam long id, HttpServletRequest request) {
		libraryService.deleteBookTypeById(id);
		request.setAttribute("status", "showbooktypes");
		request.setAttribute("bookTypes", libraryService.findAllBookTypes());
		return "index";
	}
	
	@RequestMapping(path="/del/book", method = RequestMethod.GET)
	public String delBook(@RequestParam long id, HttpServletRequest request) {
		libraryService.deleteBookById(id);
		request.setAttribute("status", "showbooks");
		request.setAttribute("books", libraryService.findAllBooks());
		return "index";
	}
	
	@RequestMapping(path="/save/booktype", method = RequestMethod.POST)
	public void saveBookType(@ModelAttribute BookType bookType, HttpServletRequest request, HttpServletResponse response) throws IOException {
		libraryService.saveBookType(bookType);
		request.setAttribute("bookTypes", libraryService.findAllBookTypes());
		request.setAttribute("status", "showbooktypes");
		response.sendRedirect("/show/booktypes");
	}
	
	@RequestMapping(path="/save/book", method = RequestMethod.POST)
	public void saveBook(@ModelAttribute Book book, HttpServletRequest request, HttpServletResponse response) throws IOException {
		libraryService.saveBook(book);
		request.setAttribute("status", "showbooks");
		request.setAttribute("books", libraryService.findAllBooks());
		response.sendRedirect("/show/books");
	}
}
