package Ncs.BooksRestApi.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Ncs.BooksRestApi.Entity.Books;
import Ncs.BooksRestApi.Service.bookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@CrossOrigin("*")

@Api(description = "Books and author related endpoints")
public class Controller {

	@Autowired
	private bookService bookservice;
	
	@PostMapping("/books")
	@ApiOperation(value = "Saving the book to List")
	public ResponseEntity<String> saveBooks(@RequestBody Books book){

		Books savedBook = bookservice.saveBook(book);
		
       URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{bookTitle}").buildAndExpand(savedBook.getBookTitle()).toUri();
		
       System.out.println(location);
		return ResponseEntity.created(location).build();


	}
	
	@GetMapping("/books")
	@ApiOperation(value = "Return the list of books")
	public List<Books> getAllBooks() throws Exception{
		return bookservice.getAllBooks();
	}
	
	@GetMapping("/author/{author}")
	@ApiOperation(value = "Return the list of books of a authors ")
	public List<Books> getBookByAuthor(@PathVariable String author) throws Exception{
		return bookservice.getBookByAuthor(author);
	}
	
	@GetMapping("/books/{name}")
	@ApiOperation(value = "Return the list with partial matching of book name")
	public List<Books> getBookPartialMatch(@PathVariable String name) throws Exception{
		return bookservice.getBookPartialMatch(name);
	}
}
