package Ncs.BooksRestApi.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BooksNotFoundException extends Exception {

	public BooksNotFoundException(String message) {
		super(message);
	}
	
	
}
