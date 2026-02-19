package com.example.rest_winth_spring_boot_and_java.unitetests.mapper;

import com.example.rest_winth_spring_boot_and_java.data.dto.vi.PersonDto;
import com.example.rest_winth_spring_boot_and_java.model.Person;
import com.example.rest_winth_spring_boot_and_java.unitetests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.rest_winth_spring_boot_and_java.mapper.ObjectMapper.parseListObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import static com.example.rest_winth_spring_boot_and_java.mapper.ObjectMapper.parseObject;

public class ObjectMapperTests {
    
    MockPerson inputObject;
    
    @BeforeEach
    public void setUp() {
        inputObject = new MockPerson();
    }
    
    @Test
    public void parseEntityToDTOTest() {
        PersonDto output = parseObject(inputObject.mockEntity(), PersonDto.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }
    
    @Test
    public void parseEntityListToDTOListTest() {
        List<PersonDto> outputList = parseListObject(inputObject.mockEntityList(), PersonDto.class);
        PersonDto outputZero = outputList.getFirst();
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        
        PersonDto outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        
        PersonDto outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }
    
    @Test
    public void parseDTOToEntityTest() {
        Person output = parseObject(inputObject.mockDTO(), Person.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Test0", output.getFirstName());
        assertEquals("Last Name Test0", output.getLastName());
        assertEquals("Address Test0", output.getAddress());
        assertEquals("Male", output.getGender());
    }
    
    @Test
    public void parserDTOListToEntityListTest() {
        List<Person> outputList = parseListObject(inputObject.mockDTOList(), Person.class);
        Person outputZero = outputList.getFirst();
        
        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Test0", outputZero.getFirstName());
        assertEquals("Last Name Test0", outputZero.getLastName());
        assertEquals("Address Test0", outputZero.getAddress());
        assertEquals("Male", outputZero.getGender());
        
        Person outputSeven = outputList.get(7);
        
        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Test7", outputSeven.getFirstName());
        assertEquals("Last Name Test7", outputSeven.getLastName());
        assertEquals("Address Test7", outputSeven.getAddress());
        assertEquals("Female", outputSeven.getGender());
        
        Person outputTwelve = outputList.get(12);
        
        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Test12", outputTwelve.getFirstName());
        assertEquals("Last Name Test12", outputTwelve.getLastName());
        assertEquals("Address Test12", outputTwelve.getAddress());
        assertEquals("Male", outputTwelve.getGender());
    }
    
}
