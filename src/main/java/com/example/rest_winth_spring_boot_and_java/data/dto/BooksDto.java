package com.example.rest_winth_spring_boot_and_java.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class BooksDto extends RepresentationModel<BooksDto> implements Serializable {
    private static final Long serialVersionUID = 1L;
    
    private long id;
    private String author;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date launch_date;
    private String title;
    private Double price;
    
    public BooksDto() {
    }
    
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
    
    public Date getLaunch_date() {
        return launch_date;
    }
    
    public void setLaunch_date(Date launch_date) {
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
        if (!(o instanceof BooksDto booksDto)) return false;
        if (!super.equals(o)) return false;
        return getId() == booksDto.getId() && Objects.equals(getAuthor(),
                booksDto.getAuthor()) && Objects.equals(getLaunch_date(),
                booksDto.getLaunch_date()) && Objects.equals(getTitle(),
                booksDto.getTitle()) && Objects.equals(getPrice(), booksDto.getPrice());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getAuthor(), getLaunch_date(), getTitle(), getPrice());
    }
}
