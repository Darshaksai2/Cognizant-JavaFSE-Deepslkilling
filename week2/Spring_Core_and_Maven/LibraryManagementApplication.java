package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Exercise 1, 2, 5, 6, 7 & 8: Main Application Execution and Verification Context
public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean(BookService.class);
        bookService.manageBooks();
    }
}
/*
OUTPUT:
[AOP PRE-LOG] Method execution target initialized.
Executing core business logic inside BookService.
Executing data source query pipeline inside BookRepository.
[AOP POST-LOG] Method execution target finalized.
[AOP PERFORMANCE] void com.library.service.BookService.manageBooks() executed in 4ms

Process finished with exit code 0
*/