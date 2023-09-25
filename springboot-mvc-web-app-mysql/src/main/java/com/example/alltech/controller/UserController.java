package com.example.alltech.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.alltech.entity.Book;
import com.example.alltech.entity.User;
import com.example.alltech.reposiroty.BookRepository;
import com.example.alltech.reposiroty.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user, Model model) {
		if(user.getUserid() == null || user.getUserid().isEmpty() || user.getPassword() == null || user.getPassword().isEmpty()) {
			model.addAttribute("message", "UserId or Password is empty");
			return "home";
		} 
		Optional<User> usr = userRepo.findByUseridAndPassword(user.getUserid(), user.getPassword());
		if(usr.isPresent()) {
			return "redirect:/books";
		} else {
			model.addAttribute("message", "UserId or Password is wrong!");
			return "home";
		}
	}
	
	@RequestMapping("/register")
	public String register(@ModelAttribute("user") User user, Model model) {
		Optional<User> usr = userRepo.findByUseridAndPassword(user.getUserid(), user.getPassword());
		if(usr.isPresent()) {
			model.addAttribute("message","User already exists, please log in");
			return "redirect:/home";
		} else {
			return "register";
//			model.addAttribute("message","User registered, please go to home page to log in");
		}
	}
	
	@PostMapping("/saveUser")
	public String createUser(@ModelAttribute("user") User theUser) {
		userRepo.save(theUser);
		return "redirect:/home";

	}
	
	@RequestMapping("/books")
	public String books(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "books";
	}

	@GetMapping("/addBook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	@PostMapping("/saveBook")
	public String createBook(@ModelAttribute("book") Book theBook) {
		bookRepo.save(theBook);
		return "redirect:/books";
	}
	
	@RequestMapping(value = "/update/{id}")
	public String updateBook(@PathVariable int id, Model model) {
		Book book = bookRepo.findById(id).orElse(null);
		model.addAttribute("id", book.getId());
		model.addAttribute("oldname", book.getName());
		model.addAttribute("oldPrice", book.getPrice());
		model.addAttribute("book", book);
		return "update";
	}
//	
	@RequestMapping(value = "/delete/{id}")
	public String deleteBook(@PathVariable int id, Model model) {
		bookRepo.deleteById(id);
		return "redirect:/books";
	}

}
