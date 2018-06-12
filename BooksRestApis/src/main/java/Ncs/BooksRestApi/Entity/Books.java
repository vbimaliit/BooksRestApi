package Ncs.BooksRestApi.Entity;

import org.springframework.stereotype.Component;


public class Books {
	
	private String isbn;
	private String bookTitle;
	private String author ;
	private String publisher;
	
	
	//default constructor
	public Books(){
		
	}

	// parameterized constructor




	public String getBookTitle() {
		return bookTitle;
	}

	public Books(String isbn, String bookTitle, String author, String publisher) {
		
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
	
		this.isbn = isbn;
	}

	public void setBookTitle(String bookTitle) {
		
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Books [isbn=" + isbn + ", bookTitle=" + bookTitle + ", author=" + author + ", publisher=" + publisher
				+ "]";
	}

	
	
	
	
	
	
	

}
