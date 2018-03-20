package demo.controllers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

import demo.repositories.BookRepository;
import demo.repositories.BookTable;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private BookRepository bookRepository;
    
    @Test
    public void GetBookById() throws Exception {
        // Arrange
        BookTable bookTable = new BookTable(1, "Dummy book");
        given(bookRepository.findById(1)).willReturn(Optional.of(bookTable));
        
        // Act and Assert
        mockMvc.perform(get("/book/1"))
        .andExpect(jsonPath("$.name").value("Dummy book"))
        .andExpect(status().is(200));
    }
    
    @Test
    public void GetBookById2() throws Exception {
        mockMvc.perform(get("/book/10"))
        .andExpect(jsonPath("$.name").value("New book"))
        .andExpect(status().is(200));
    }

}
