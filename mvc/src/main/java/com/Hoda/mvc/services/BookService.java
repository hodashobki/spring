package com.Hoda.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Hoda.mvc.models.Book;
import com.Hoda.mvc.repository.BookRepository;

@Service
public class BookService {
	 private final BookRepository bookRepository;
	 public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    // returns all the books
	    public List<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
//	    update books
	    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	    	Optional<Book> thisBook = bookRepository.findById(id);
	    	thisBook.get().setTitle(title);
	    	thisBook.get().setDescription(desc);
	    	thisBook.get().setLanguage(lang);
	    	thisBook.get().setNumberOfPages(numOfPages);
	    	
	        return bookRepository.save(thisBook.get());
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
		public void deleteBook(Long id) {
			// TODO Auto-generated method stub
			Optional<Book> opBook = bookRepository.findById(id);
//			opBook.get();
			bookRepository.delete(opBook.get());
//			opBook.deleteById(id);
			
		}
}