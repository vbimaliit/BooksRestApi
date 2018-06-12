package Ncs.BooksRestApi.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import Ncs.BooksRestApi.Entity.Books;


public interface bookService {



public Books saveBook(Books book);
	
	public List<Books> getAllBooks() throws Exception;
	
	public List<Books> getBookByAuthor(String author) throws Exception;
	
	public List<Books> getBookPartialMatch(String name) throws Exception;
}
