package com.example.multi.readwritedatasource.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Transactional
	public Book save(final String author, final String title) {
		return bookRepository.save(new Book(author, title));
	}

	@Transactional(readOnly = true)
	public Book findBook(final Integer id) {
		return bookRepository.findById(id).orElse(null);
	}
}
