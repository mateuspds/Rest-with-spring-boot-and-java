package com.example.rest_winth_spring_boot_and_java.services.mocks;

import com.example.rest_winth_spring_boot_and_java.data.dto.BooksDto;
import com.example.rest_winth_spring_boot_and_java.model.Books;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockBooks {
    
    public Books mockEntity() {
        return mockEntity(0);
    }
    
    public BooksDto mockDTO() {
        return mockDTO(0);
    }
    
    public List<Books> mockEntityList() {
        List<Books> books = new ArrayList<Books>();
        for (int i = 0; i < 14; i++) {
            books.add(mockEntity(i));
        }
        return books;
    }
    
    public List<BooksDto> mockDTOList() {
        List<BooksDto> books = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            books.add(mockDTO(i));
        }
        return books;
    }
    
    public Books mockEntity(Integer number) {
        Books books = new Books();
        books.setTitle("Address Test" + number);
        books.setAuthor("First Name Test" + number);
        books.setLaunch_date(((number % 2) == 0) ? new Date() : new Date(System.currentTimeMillis()));
        books.setId(number.longValue());
        books.setPrice(2.5 + number);
        return books;
    }
    
    public BooksDto mockDTO(Integer number) {
        BooksDto books = new BooksDto();
        books.setTitle("Title Test" + number);
        books.setAuthor("Author Test" + number);
        books.setPrice(((number % 2) == 0) ? 99.99 : 19.85);
        books.setId(number.longValue());
        books.setLaunch_date(new Date());
        return books;
    }
}
