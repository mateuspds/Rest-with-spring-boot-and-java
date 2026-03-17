package com.example.rest_winth_spring_boot_and_java.controllers;

import com.example.rest_winth_spring_boot_and_java.controllers.docs.BookControllerDocs;
import com.example.rest_winth_spring_boot_and_java.data.dto.BooksDto;
import com.example.rest_winth_spring_boot_and_java.services.BooksService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books/v1")
@Tag(name = "Books", description = "endpoints for managing books")
public class BooksController implements BookControllerDocs {
    
    @Autowired
    private BooksService service;
    
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    @Override
    public BooksDto findById(@PathVariable("id") Long id) {
        var book = service.findById(id);
        return book;
    }
    
    
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,})
    @Override
    public List<BooksDto> findAll() {
        return service.findAll();
        
    }
    
    
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public BooksDto create(@RequestBody BooksDto book) {
        return service.create(book);
    }
    
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,}
    )
    
    @Override
    public BooksDto update(@RequestBody BooksDto book) {
        return service.update(book);
    }
    
    
    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
