package com.example.rest_winth_spring_boot_and_java.services;

import com.example.rest_winth_spring_boot_and_java.exception.ResourceNotFoundException;
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
    
    
    public Person findById(Long id) {
        logger.info("finding one person!");
        return repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
    }
    
    public List<Person> findAll() {
        logger.info("finding all persons!");
        return repository.findAll();
        
    }
    
    public Person create(Person person) {
        logger.info("creating person!");
        return repository.save(person);
        
    }
    
    public Person update(Person person) {
        logger.info("Updating one Person!");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }
    
    public void delete(Long id) {
        logger.info("Deleting one Person!");
        
        Person entity = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Person delete one not found!"));
        repository.delete(entity);
    }
}
