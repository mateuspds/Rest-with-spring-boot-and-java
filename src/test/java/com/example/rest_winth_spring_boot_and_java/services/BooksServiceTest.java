package com.example.rest_winth_spring_boot_and_java.services;

import com.example.rest_winth_spring_boot_and_java.data.dto.BooksDto;
import com.example.rest_winth_spring_boot_and_java.model.Books;
import com.example.rest_winth_spring_boot_and_java.services.mocks.MockBooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class BooksServiceTest {
    MockBooks input;
    
    @BeforeEach
    void setUp() {
        input = new MockBooks();
    }
    
    @Test
    void mockEntity() {
        
        Books book = input.mockEntity(1);
        
        assertNotNull(book);
        assertEquals(1L, book.getId());
        assertEquals("Address Test1", book.getTitle());
        assertEquals("First Name Test1", book.getAuthor());
        assertEquals(3.5, book.getPrice());
        assertNotNull(book.getLaunch_date());
    }
    
    @Test
    void mockDTO() {
        
        BooksDto book = input.mockDTO(1);
        
        assertNotNull(book);
        assertEquals(1L, book.getId());
        assertEquals("Title Test1", book.getTitle());
        assertEquals("Author Test1", book.getAuthor());
        assertEquals(19.85, book.getPrice());
        assertNotNull(book.getLaunch_date());
    }
    
    @Test
    void mockEntityList() {
        
        List<Books> list = input.mockEntityList();
        
        assertNotNull(list);
        assertEquals(14, list.size());
        
        Books bookOne = list.get(1);
        
        assertNotNull(bookOne);
        assertEquals(1L, bookOne.getId());
        assertEquals("Address Test1", bookOne.getTitle());
        assertEquals("First Name Test1", bookOne.getAuthor());
        assertEquals(3.5, bookOne.getPrice());
    }
    
    @Test
    void mockDTOList() {
        
        List<BooksDto> list = input.mockDTOList();
        
        assertNotNull(list);
        assertEquals(14, list.size());
        
        BooksDto bookOne = list.get(1);
        
        assertNotNull(bookOne);
        assertEquals(1L, bookOne.getId());
        assertEquals("Title Test1", bookOne.getTitle());
        assertEquals("Author Test1", bookOne.getAuthor());
        assertEquals(19.85, bookOne.getPrice());
    }
    
}
