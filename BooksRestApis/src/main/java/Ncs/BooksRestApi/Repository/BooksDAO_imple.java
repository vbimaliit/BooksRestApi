package Ncs.BooksRestApi.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import Ncs.BooksRestApi.Entity.Books;

@Repository
public class BooksDAO_imple implements BooksDAO {
	
	// Using Arraylist to store the books as e don't have to use the persistence layer
	List<Books> bookStorage = new ArrayList<Books>();

	@Override
	
	// Saving the book
	public Books saveBook(Books book) {
	
		bookStorage.add(book);
		return null;
	}

	@Override
	// Returning the list of books
	public List<Books> getAllBooks() {

		return bookStorage;
	}

	@Override
	
	// Using Stream api of Java8 to iterate through the list of books and matching  it with author as required;
	public List<Books> getBookByAuthor(String author) {
		
		List<Books> booksList= bookStorage.stream().filter(obj -> obj.getAuthor().equals(author)).collect(Collectors.toList());
		
		return booksList;
	}

	@Override
	
	// FInding the books on partial
	public List<Books> getBookPartialMatch(String name) {
	
		List<Books> bookList = new ArrayList<Books>();
		
		bookStorage.forEach(obj -> {
			if (obj.getBookTitle().indexOf(name) >= 0) bookList.add(obj);
		});
		
		return bookList;
	}
	
	

}
