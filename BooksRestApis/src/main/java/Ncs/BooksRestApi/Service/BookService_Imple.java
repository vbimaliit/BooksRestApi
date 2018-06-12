package Ncs.BooksRestApi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import Ncs.BooksRestApi.Entity.Books;
import Ncs.BooksRestApi.Repository.BooksDAO;

@Service
public class BookService_Imple implements bookService {

	@Autowired
	private BooksDAO bookdao;
	
	
	@Override
	public Books saveBook(Books book) {
		// TODO Auto-generated method stub
		
		bookdao.saveBook(book);
		return book;
	}

	@Override
	public List<Books> getAllBooks() throws Exception {
		// TODO Auto-generated method stub
		
		List<Books> books = bookdao.getAllBooks();
		if(books.size() == 0){
			throw new BooksNotFoundException("DataBase is empty");
		}
		return books;
	}

	@Override
	public List<Books> getBookByAuthor(String author) throws Exception {
		
		List<Books> books = new ArrayList<Books>();
	  books = 	bookdao.getBookByAuthor(author);
	  if( books.size() ==  0){
		  throw new BooksNotFoundException("No book found for author:" + author);
	  }
		
		return books;
	}

	@Override
	public List<Books> getBookPartialMatch(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Books> books = new ArrayList<Books>();
		  books = 	bookdao.getBookPartialMatch(name);
		  if( books.size() ==  0){
			  throw new BooksNotFoundException("No Books found with partial matching" + name);
		  }
			
			return books;
	}

}
