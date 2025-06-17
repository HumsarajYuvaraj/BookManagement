package com.example.BookManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookManagement.Model.*;
import com.example.BookManagement.Repositary.*;
import java.util.*;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
@Autowired
private CategoryRepositary cr;
	
public Category findbyid(long id) {
	Category c=cr.findById(id).get();
	return c;
}

public void addcategory(Category category) {
	cr.save(category);
}
public List<Category> listallcategory(){
	return cr.findAll();
	
}

public void deletebyid(long id) {
	cr.deleteById(id);
}
}
