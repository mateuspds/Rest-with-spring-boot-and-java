package com.example.rest_winth_spring_boot_and_java.controllers;

import com.example.rest_winth_spring_boot_and_java.data.dto.v2.PersonDtoV2;
import com.example.rest_winth_spring_boot_and_java.data.dto.vi.PersonDto;
import com.example.rest_winth_spring_boot_and_java.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    
    @Autowired
    private PersonService service;
    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDto findById(@PathVariable("id") Long id) {
        return service.findById(id);
        
    }
    
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonDto> findAll() {
        return service.findAll();
        
    }
    
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDto create(@RequestBody PersonDto person) {
        return service.create(person);
    }
    
    @PostMapping(value = "/v2",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDtoV2 create(@RequestBody PersonDtoV2 person) {
        return service.createV2(person);
    }
    
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDto update(@RequestBody PersonDto person) {
        return service.update(person);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
