package com.example.rest_winth_spring_boot_and_java.services;

import com.example.rest_winth_spring_boot_and_java.controllers.PersonController;
import com.example.rest_winth_spring_boot_and_java.data.dto.PersonDto;
import com.example.rest_winth_spring_boot_and_java.exception.ResourceNotFoundException;
import static com.example.rest_winth_spring_boot_and_java.mapper.ObjectMapper.parseObject;
import static com.example.rest_winth_spring_boot_and_java.mapper.ObjectMapper.parseListObject;

import com.example.rest_winth_spring_boot_and_java.exception.hadler.RequiredObjectsNullException;
import com.example.rest_winth_spring_boot_and_java.model.Person;
import com.example.rest_winth_spring_boot_and_java.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    PersonRepository repository;
    
    public List<PersonDto> findAll() {
        logger.info("finding all Person!");
        var persons = parseListObject(repository.findAll(), PersonDto.class);
        persons.forEach(this::addHateoasLinks);
        return persons;
    }
    
    public PersonDto findById(Long id) {
        logger.info("finding one person!");
        var entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        var dto =  parseObject(entity, PersonDto.class);
        addHateoasLinks(dto);
        return dto;
    }
    
    public PersonDto create(PersonDto person) {
        if(person == null) throw new RequiredObjectsNullException("Person is null");
        logger.info("creating person!");
        var entity = parseObject(person, Person.class);
        var dto = parseObject(repository.save(entity), PersonDto.class);
        addHateoasLinks(dto);
        return dto;
        
    }
    
    public PersonDto update(PersonDto person) {
        if(person == null) throw new RequiredObjectsNullException("Person is null");
        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Person not found!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var dto = parseObject(repository.save(entity), PersonDto.class);
        addHateoasLinks(dto);
        return dto;
    }
    
    public void delete(Long id) {
        logger.info("Deleting one Person!");
        
        Person entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Person delete one not found!"));
        repository.delete(entity);
    }
    
    private void addHateoasLinks(PersonDto dto) {
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
    }
    
}
