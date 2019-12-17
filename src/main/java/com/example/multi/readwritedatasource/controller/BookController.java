package com.example.multi.readwritedatasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.multi.readwritedatasource.book.Book;
import com.example.multi.readwritedatasource.book.BookService;

@Controller
@RequestMapping("books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
    @RequestMapping(value = "read/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Book getBook(@PathVariable int id) {
        return bookService.findBook(id);
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Void getBook(@RequestParam(name = "author") String author, 
    		@RequestParam(name = "title") String title) {
    	bookService.save(author, title);
    	return null;
    }
}