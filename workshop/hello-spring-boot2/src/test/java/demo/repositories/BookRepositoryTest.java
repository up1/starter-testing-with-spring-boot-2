package demo.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
    
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void success() {
        // Arrange
        BookTable dummyBook = new BookTable(1, "Dummy book");
        bookRepository.save(dummyBook);
        // Act
        Optional<BookTable> actualBook = bookRepository.findById(1);
        // Assert
        assertTrue(actualBook.isPresent());
        assertEquals("Dummy book", actualBook.get().getName());
    }

}
