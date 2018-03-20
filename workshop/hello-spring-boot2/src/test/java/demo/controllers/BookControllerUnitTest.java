package demo.controllers;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import demo.exceptions.DataNotFoundException;
import demo.repositories.BookRepository;
import demo.repositories.BookTable;
import domains.Book;

import static org.mockito.BDDMockito.*;
import static org.mockito.MockitoAnnotations.*;

public class BookControllerUnitTest {
    
    private BookController bookController;   
    @Mock
    private BookRepository bookRepository;
    
    @Before
    public void init() {
        initMocks(this);
        bookController = new BookController();
        bookController.setBookRepository(bookRepository);
    }

    @Test
    public void success_case() {
        Book expectedBook = new Book("Mock book");
        // Arrange
        BookTable bookTable = new BookTable(1, "Mock book");
        given(bookRepository.findById(1)).willReturn(Optional.of(bookTable));
        
        // Act
        Book book = bookController.getBookById(1);
        
        // Assert
        assertEquals(expectedBook, book);
    }

}
