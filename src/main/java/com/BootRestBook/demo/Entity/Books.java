package com.BootRestBook.demo.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Book_Id")
	private int id;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author authorName;
	
	@Column(name="Book_Name")
	private String bookName;

	
	
	public Books() {
		super();
	}

	public Books(int id, Author authorName, String bookName) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", authorName=" + authorName + ", bookName=" + bookName + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Author getAuthorName() {
		return authorName;
	}

	public void setAuthorName(Author authorName) {
		this.authorName = authorName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
}
