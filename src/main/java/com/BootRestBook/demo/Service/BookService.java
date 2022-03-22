package com.BootRestBook.demo.Service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BootRestBook.demo.Entity.Books;
import com.BootRestBook.demo.dao.BookRepositery;

@Service
public class BookService {

	@Autowired
	private BookRepositery bookRepositery;
	
	//Get All books
	public List<Books> getAllBooks()
	{
		return (List<Books>)this.bookRepositery.findAll();
	}
	
	//Get All Books by ID
	public Books getAllBooksById(int id)
	{
		return this.bookRepositery.findById(id);
	}
	
	//Add Book
	public Books addBook(Books b)
	{
		return this.bookRepositery.save(b);
	}
	
	//Updating a Book
	public Books updateBook(Books book, int bookId)
	{
		book.setId(bookId);
		return this.bookRepositery.save(book);
	}
	
	//delete a Book
	public void deleteBook(int id)
	{
		this.bookRepositery.deleteById(id);
	}
}
