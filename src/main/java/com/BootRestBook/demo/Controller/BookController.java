package com.BootRestBook.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BootRestBook.demo.Entity.Books;
import com.BootRestBook.demo.Service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<Books>> getAllBooks()
	{
		List<Books> allBooks = bookService.getAllBooks();
		try {
			if(allBooks.size()<=0 || allBooks==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			else
				return ResponseEntity.of(Optional.of(allBooks));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("books/{id}")
	public ResponseEntity<Books> getBookById(@PathVariable("id") int id)
	{
		Books book = this.bookService.getAllBooksById(id);
		try {
			if(book == null)
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			else
				return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Inserting a Book JSON Object
	@PostMapping("books")
	public ResponseEntity<Books> addBook(@RequestBody Books b)
	{
		try {
			Books book = this.bookService.addBook(b);
			return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Updating a Book
	@PutMapping("/books/{id}")
	public ResponseEntity<Books> updateBook(@RequestBody Books book,@PathVariable("id") int bookId)
	{
		try {
			Books updateBook = this.bookService.updateBook(book, bookId);
			return ResponseEntity.of(Optional.of(updateBook));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	//Delete a Book
	@DeleteMapping("books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id)
	{
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
