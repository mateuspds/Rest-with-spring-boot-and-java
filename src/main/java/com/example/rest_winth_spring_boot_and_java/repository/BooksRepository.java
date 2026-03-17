package com.example.rest_winth_spring_boot_and_java.repository;

import com.example.rest_winth_spring_boot_and_java.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books, Long> {
}
