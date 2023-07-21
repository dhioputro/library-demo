package com.test.librarydemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private String launchDate;
    private String pages;
    private Integer status;
    private String borrower;
    private String borrowDate;
    private String returnDate;
}
