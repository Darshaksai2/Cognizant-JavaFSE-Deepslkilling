package com.library.repository;

import org.springframework.stereotype.Repository;

// Exercise 1 & 6: BookRepository Class
@Repository
public class BookRepository {
    public void executeQuery() {
        System.out.println("Executing data source query pipeline inside BookRepository.");
    }
}
/*
OUTPUT:
(This class does not contain a main method. It is managed and executed via BookService.)
*/