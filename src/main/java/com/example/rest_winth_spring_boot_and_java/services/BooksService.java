package com.example.rest_winth_spring_boot_and_java.services;

import com.example.rest_winth_spring_boot_and_java.controllers.BooksController;
import com.example.rest_winth_spring_boot_and_java.data.dto.BooksDto;
import com.example.rest_winth_spring_boot_and_java.exception.ResourceNotFoundException;
import com.example.rest_winth_spring_boot_and_java.exception.hadler.RequiredObjectsNullException;
import com.example.rest_winth_spring_boot_and_java.model.Books;
import com.example.rest_winth_spring_boot_and_java.repository.BooksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.example.rest_winth_spring_boot_and_java.mapper.ObjectMapper.parseListObject;
import static com.example.rest_winth_spring_boot_and_java.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BooksService {
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    BooksRepository repository;
    
    public List<BooksDto> findAll() {
        logger.info("Find all books");
        var books = parseListObject(repository.findAll(), BooksDto.class);
        books.forEach(this::addHateoasLinks);
        return books;
    }
    
    public BooksDto findById(Long id) {
        logger.info("finding one books with id ");
        var entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("books not found!"));
        var dto = parseObject(entity, BooksDto.class);
        addHateoasLinks(dto);
        return dto;
    }
    
    public BooksDto create(BooksDto books) {
        if (books == null) throw new RequiredObjectsNullException("books is null");
        logger.info("creating book!");
        var entity = parseObject(books, Books.class);
        var dto = parseObject(repository.save(entity), BooksDto.class);
        addHateoasLinks(dto);
        return dto;
        
    }
    
    public BooksDto update(BooksDto books) {
        if (books == null) throw new RequiredObjectsNullException("books is null");
        logger.info("Updating one book!");
        Books entity = repository.findById(books.getId()).orElseThrow(() ->
                new ResourceNotFoundException("books not found!"));
        entity.setAuthor(books.getAuthor());
        entity.setPrice(books.getPrice());
        entity.setTitle(books.getTitle());
        entity.setLaunch_date(books.getLaunch_date());
        var dto = parseObject(repository.save(entity), BooksDto.class);
        addHateoasLinks(dto);
        return dto;
    }
    
    public void delete(Long id) {
        logger.info("Deleting one Book!");
        
        Books entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Book delete one not found!"));
        repository.delete(entity);
    }
    
    private void addHateoasLinks(BooksDto dto) {
        dto.add(linkTo(methodOn(BooksController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(BooksController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(BooksController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(BooksController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(BooksController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
}
