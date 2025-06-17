package com.example.BookManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookManagement.Model.*;
import com.example.BookManagement.Repositary.*;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthorService {
@Autowired
private AuthorRepositary ar;

public void addauthor(Author author) {
	ar.save(author);
}

public void deletebyid(long id){
	ar.deleteById(id);
}
public List<Author> listallauthor(){
	return ar.findAll();
}

public Author findbyid(long id) {
	Author a=ar.findById(id).get();
	return a;
}
}
