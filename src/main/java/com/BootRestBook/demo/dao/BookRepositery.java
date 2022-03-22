package com.BootRestBook.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.BootRestBook.demo.Entity.Books;

public interface BookRepositery extends CrudRepository<Books, Integer>{

	public Books findById(int id);
}
