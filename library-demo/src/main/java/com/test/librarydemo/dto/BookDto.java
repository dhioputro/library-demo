package com.test.librarydemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
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
