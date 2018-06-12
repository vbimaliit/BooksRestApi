package Ncs.BooksRestApi.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import Ncs.BooksRestApi.Entity.Books;


public interface BooksDAO {

	public Books saveBook(Books book);
	
	public List<Books> getAllBooks();
	
	public List<Books> getBookByAuthor(String author);
	
	public List<Books> getBookPartialMatch(String name);
	
}
