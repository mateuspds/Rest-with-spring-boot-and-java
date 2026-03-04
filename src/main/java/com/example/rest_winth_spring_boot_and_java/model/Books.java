package com.example.rest_winth_spring_boot_and_java.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

public class Books {
    private static final Long serialVersionUID = 1L;
    
    private String author;
    private String launch_date;
    private String title;
    private Double price;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getLaunch_date() {
        return launch_date;
    }
    
    public void setLaunch_date(String launch_date) {
        this.launch_date = launch_date;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Books books)) return false;
        return getId() == books.getId() && Objects.equals(getAuthor(), books.getAuthor()) &&
                Objects.equals(getLaunch_date(), books.getLaunch_date()) && Objects.equals(getTitle(),
                books.getTitle()) && Objects.equals(getPrice(), books.getPrice());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getLaunch_date(), getTitle(), getPrice(), getId());
    }
}
