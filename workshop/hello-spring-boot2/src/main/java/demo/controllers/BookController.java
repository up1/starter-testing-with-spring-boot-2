package demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.repositories.BookRepository;
import demo.repositories.BookTable;
import domains.Book;

@RestController
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;
    
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id) {
        if(id == 10) {
            return new Book("New book");
        }
        
        Optional<BookTable> book = bookRepository.findById(id);
        return new Book(book.get().getName());
    }

}
