package com.example.rest_winth_spring_boot_and_java.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Rest API´s RESTful" +
                " from with java, spring boot, kubernetes and docker").version("v1")
                .description("from java, Spring Boot and Kubernetes")
                .termsOfService("https://www.oracle.com/br/java/technologies/javase/jdk-faqs.html")
                .license(new License()
                        .name("Oracle Corporation")
                        .url("https://www.oracle.com/br/java/technologies/javase/jdk-faqs.html"))
        );
    }
}
