package com.example.BookManagement.controller;

import java.util.*;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.BookManagement.Model.*;
import com.example.BookManagement.Service.*;


@Controller
public class AppController {
	
	@Autowired
	private AuthorService as;
	
	@Autowired
	private BookService bs;
	
	@Autowired
	private CategoryService cs;
	
	
	@GetMapping("/")
	public String testHome() {
		return "test";
	}
	
	@GetMapping("/addingcategory")
	public String categorypage(Model model) {
		model.addAttribute("category",new Category());
		return "addingcategory";
	}
	
	@PostMapping("/savingcategory")
	public String savecategory(@ModelAttribute("category") Category category) {
		cs.addcategory(category);
		return "redirect:/addingauthor";
	}
	
	@RequestMapping("/addingauthor")
	public String authorpage(Model model) {
		model.addAttribute("author",new Author());
		return "addingauthor";
	}
	@RequestMapping("/savingauthor")
	public String saveauthor(@ModelAttribute("author") Author author) {
		as.addauthor(author);
		return "redirect:/addingbook";
	}
	
	@GetMapping("/addingbook")
	public String bookpage(Model model) {
		List<Category> categorylist=cs.listallcategory();
		model.addAttribute("categorylist",categorylist);
		List<Book> booklist=bs.listbook();
		List<Author> authorlist=as.listallauthor();
		model.addAttribute("booklist",booklist);
		model.addAttribute("book" ,new Book());
		model.addAttribute("authorlist",authorlist);
		return "addingbook";
		
	}
	
	@PostMapping("/savingbook")
	public String savebook(@ModelAttribute("book") Book book ,@RequestParam Long cid,@RequestParam Long aid) {
		Category cat=cs.findbyid(cid);
		Author aut=as.findbyid(aid);
		book.setCategory(cat);
		book.setAuthor(aut);
		bs.addbook(book);
		return "redirect:/";
	}
	
	@RequestMapping("/listbycategory")
	public String listbycat(Model model) {
		List<Category> category=cs.listallcategory();
		model.addAttribute("category",category);
		return "listbycategory";
	}
	
	
	@RequestMapping("/displaycategorylist")
	public String listbycategoryy(@RequestParam Long catname,Model model) {
		Category resultcategory=cs.findbyid(catname);
		List<Book> allbook=bs.listbook();
		List<Book> newbook=new ArrayList<Book>();
		for(Book b:allbook) {
			if(b.getCategory().getId().equals(resultcategory.getId())) {
				newbook.add(b);
			}
		}
		model.addAttribute("newbook",newbook);
		return "listbycategory";
		
	}
	
	
	@RequestMapping("/editdeletebook")
	public String allitems(Model model) {
		List<Book> booklist=bs.listbook();
		List<Author> authorlist=as.listallauthor();
		List<Category> categorylist=cs.listallcategory();
		model.addAttribute("categorylist",categorylist);
		model.addAttribute("authorlist",authorlist);
		model.addAttribute("booklist",booklist);
		return "/editdeletebook";

	}
	@RequestMapping("/editbook")
	public String editpage(Model model,Long id) {
		List<Category> categorylist=cs.listallcategory();
		List<Author> authorlist=as.listallauthor();
		Book book=bs.findbyid(id);
		model.addAttribute("categorylist",categorylist);
		List<Book> booklist=bs.listbook();
		model.addAttribute("bookid",book);
		model.addAttribute("booklist",booklist);
		model.addAttribute("authorlist",authorlist);
		return "editbook";
		
	}
	
	@RequestMapping("/updatebook")
	public String saveeditbook(@ModelAttribute("book") Book book) {
		bs.addbook(book);
		return "redirect:/editdeletebook";
	}
	
	
	@RequestMapping("/deletebook")
	public String deletebook(Model model,Long id) {
		bs.deletebyid(id);
		return "redirect:/editdeletebook";
	}
	
	@RequestMapping("/fetchbyid")
	public String findbook(Model model) {
		model.addAttribute("book",new Book());
		return "fetchbyid";
		
	}
	@RequestMapping("/findbyid")
	public String foundbook(@ModelAttribute("book") Book book,Model model) {
		Book bookdetails=bs.findbyid(book.getId());
		model.addAttribute("bookdetails",bookdetails);
		return "fetchbyid";

	}
}