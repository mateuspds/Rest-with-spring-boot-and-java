package com.example.rest_winth_spring_boot_and_java.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping("/test")
    public String getLog(){
        logger.info("test log info");
        logger.debug("test log debug");
        logger.warn("test log warn");
        logger.error("test log error");
        return "test log";
    }
}
