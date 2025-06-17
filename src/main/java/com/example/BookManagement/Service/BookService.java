package com.example.BookManagement.Service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookManagement.Model.*;
import com.example.BookManagement.Repositary.*;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookRepositary br;
	
	public Book findbyid(long id) {
		Book b=br.findById(id).get();
		return b;
		
	}
	public List<Book> listbook() {
		return br.findAll();
	}
	 
	public void deletebyid(long id) {
		br.deleteById(id);
		System.out.println("@@@@@@@@@@@@Deleted Succefully");
		
	}
	
	public void addbook(Book b) {
		br.save(b);
	}
}
