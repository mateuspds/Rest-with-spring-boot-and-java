package com.example.rest_winth_spring_boot_and_java.controllers;

import com.example.rest_winth_spring_boot_and_java.controllers.docs.PersonControllerDocs;
import com.example.rest_winth_spring_boot_and_java.data.dto.PersonDto;
import com.example.rest_winth_spring_boot_and_java.services.PersonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
@Tag(name = "People", description = "endpoints for managing People")
public class PersonController implements PersonControllerDocs {
    
    @Autowired
    private PersonService service;
    
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Override
    public PersonDto findById(@PathVariable("id") Long id) {
        var person = service.findById(id);
        person.setBirthDay(new Date());
        return person;
    }
    
    
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,})
    @Override
    public List<PersonDto> findAll() {
        return service.findAll();
        
    }
    
    
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public PersonDto create(@RequestBody PersonDto person) {
        return service.create(person);
    }
    
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE,}
    )
    
    @Override
    public PersonDto update(@RequestBody PersonDto person) {
        return service.update(person);
    }
    
    
    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
