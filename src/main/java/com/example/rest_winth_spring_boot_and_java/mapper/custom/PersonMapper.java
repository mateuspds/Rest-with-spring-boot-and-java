package com.example.rest_winth_spring_boot_and_java.mapper.custom;

import com.example.rest_winth_spring_boot_and_java.data.dto.v2.PersonDtoV2;
import com.example.rest_winth_spring_boot_and_java.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {
    public PersonDtoV2 convertEntityToDto(Person person) {
        PersonDtoV2 personDto = new PersonDtoV2();
        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setAddress(person.getAddress());
        personDto.setGender(person.getGender());
        personDto.setBirthDay(new Date());
        return personDto;
    }
    
    public Person convertDTOtoEntity(PersonDtoV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        // entity.setBirthDay(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}
