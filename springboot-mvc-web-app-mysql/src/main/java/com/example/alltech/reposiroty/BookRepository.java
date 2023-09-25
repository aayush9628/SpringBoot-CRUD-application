package com.example.alltech.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.alltech.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
}
