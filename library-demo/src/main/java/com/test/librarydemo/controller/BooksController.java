package com.test.librarydemo.controller;

import com.test.librarydemo.dto.BookDto;
import com.test.librarydemo.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    BooksService booksService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return booksService.createBooks(bookDto);
    }

    @GetMapping
    public ArrayList<BookDto> getBooks() {
        return booksService.getBooks();
    }

    @PutMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateBook(@PathVariable String bookId, @RequestBody BookDto bookDto) {
        return booksService.updateBook(bookDto, bookId);
    }

    @PutMapping("/{bookId}/status")
    @ResponseStatus(HttpStatus.OK)
    public BookDto updateStatusBook(@PathVariable String bookId, @RequestBody BookDto bookDto) {
        return booksService.updateStatusBook(bookId, bookDto);
    }

    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable String bookId) {
        return booksService.deleteBook(bookId);
    }

}
