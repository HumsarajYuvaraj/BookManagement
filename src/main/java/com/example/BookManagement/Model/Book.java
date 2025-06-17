package com.example.BookManagement.Model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Entity
public class Book {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private double price;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Category category;

	public Book(Long id, String title, String isbn, double price) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.price = price;
	}

	
	public Book() {
		super();
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", price=" + price + "]";
	}
    
    
    
}


