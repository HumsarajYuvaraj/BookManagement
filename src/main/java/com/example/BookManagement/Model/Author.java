package com.example.BookManagement.Model;

import java.util.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
public class Author {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String biography;

    @OneToMany
    private List<Book> books;

	public Author(Long id, String name, String biography) {
		super();
		this.id = id;
		this.name = name;
		this.biography = biography;
	}

	public Author() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", biography=" + biography + "]";
	}
    
    
}


