package com.example.rest_winth_spring_boot_and_java.services;

import com.example.rest_winth_spring_boot_and_java.data.dto.v2.PersonDtoV2;
import com.example.rest_winth_spring_boot_and_java.data.dto.vi.PersonDto;
import com.example.rest_winth_spring_boot_and_java.exception.ResourceNotFoundException;
import com.example.rest_winth_spring_boot_and_java.mapper.ObjectMapper;
import static com.example.rest_winth_spring_boot_and_java.mapper.ObjectMapper.parseObject;

import com.example.rest_winth_spring_boot_and_java.mapper.custom.PersonMapper;
import com.example.rest_winth_spring_boot_and_java.model.Person;
import com.example.rest_winth_spring_boot_and_java.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {
    
    private final AtomicLong counter = new AtomicLong();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PersonRepository repository;
    
    @Autowired
    PersonMapper converter;
    
    public PersonDto findById(Long id) {
        logger.info("finding one person!");
        var entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        return parseObject(entity, PersonDto.class);
    }
    
    public List<PersonDto> findAll() {
        logger.info("finding all Person!");
        return  ObjectMapper.parseListObject(repository.findAll(),PersonDto.class);
        
    }
    
    public PersonDto create(PersonDto person) {
        logger.info("creating person!");
        var entity = parseObject(person, Person.class);
        return  parseObject(repository.save(entity), PersonDto.class);
        
    }
    
    public PersonDtoV2 createV2(PersonDtoV2 person) {
        logger.info("creating person v2!");
        var entity = converter.convertDTOtoEntity(person);
        return converter.convertEntityToDto(repository.save(entity));
        
    }
    
    public PersonDto update(PersonDto person) {
        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Person not found!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return parseObject(repository.save(entity), PersonDto.class);
    }
    
    public void delete(Long id) {
        logger.info("Deleting one Person!");
        
        Person entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Person delete one not found!"));
        repository.delete(entity);
    }
}
