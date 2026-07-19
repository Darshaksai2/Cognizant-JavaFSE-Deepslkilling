package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Exercise 1, 2, 6 & 7: BookService with Constructor and Setter Dependency Injection
@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService() {}

    // Exercise 7: Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Exercise 2 & 7: Setter Injection
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void manageBooks() {
        System.out.println("Executing core business logic inside BookService.");
        bookRepository.executeQuery();
    }
}
/*
OUTPUT:
(This class does not contain a main method. It is injected and called by LibraryManagementApplication.)
*/