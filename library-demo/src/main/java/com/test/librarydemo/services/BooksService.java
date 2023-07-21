package com.test.librarydemo.services;

import com.test.librarydemo.dto.BookDto;
import com.test.librarydemo.entities.Book;
import com.test.librarydemo.repositories.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BooksService {

    @Autowired
    private final BooksRepository booksRepository;

    public BookDto createBooks(BookDto bookDto) {

        var book = booksRepository.save(
                Book.builder()
                        .bookId(bookDto.getBookId())
                        .title(bookDto.getTitle())
                        .publisher(bookDto.getPublisher())
                        .author(bookDto.getAuthor())
                        .pages(bookDto.getPages())
                        .launchDate(bookDto.getLaunchDate())
                        .status(0)
                        .borrower("-")
                        .borrowDate("-")
                        .returnDate("-")
                        .build()
        );
        return BookDto.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .publisher(book.getPublisher())
                .author(book.getAuthor())
                .pages(book.getPages())
                .launchDate(book.getLaunchDate())
                .status(book.getStatus())
                .borrower(book.getBorrower())
                .borrowDate(book.getBorrowDate())
                .returnDate(book.getReturnDate())
                .build();
    }

    public ArrayList<BookDto> getBooks() {
        ArrayList<BookDto> bookList = new ArrayList<>();
        booksRepository.findAll().forEach(book ->
                bookList.add(BookDto.builder()
                        .bookId(book.getBookId())
                        .title(book.getTitle())
                        .publisher(book.getPublisher())
                        .author(book.getAuthor())
                        .pages(book.getPages())
                        .launchDate(book.getLaunchDate())
                        .status(book.getStatus())
                        .borrower(book.getBorrower())
                        .borrowDate(book.getBorrowDate())
                        .returnDate(book.getReturnDate())
                        .build())
        );
        return bookList;
    }

    public BookDto updateBook(BookDto bookDto, String id) {
        var book = booksRepository.findByBookId(id);
        book.setTitle(bookDto.getTitle());
        book.setPublisher(bookDto.getPublisher());
        book.setAuthor(bookDto.getAuthor());
        book.setPages(bookDto.getPages());
        book.setLaunchDate(bookDto.getLaunchDate());
        return getBookDto(book);
    }

    private BookDto getBookDto(Book book) {
        var updatedBook = booksRepository.save(book);
        return BookDto.builder()
                .bookId(updatedBook.getBookId())
                .title(updatedBook.getTitle())
                .publisher(updatedBook.getPublisher())
                .author(updatedBook.getAuthor())
                .pages(updatedBook.getPages())
                .launchDate(updatedBook.getLaunchDate())
                .status(updatedBook.getStatus())
                .borrower(updatedBook.getBorrower())
                .borrowDate(updatedBook.getBorrowDate())
                .returnDate(updatedBook.getBorrowDate())
                .build();
    }

    public BookDto updateStatusBook(String id, BookDto bookDto) {
        var book = booksRepository.findByBookId(id);
        book.setStatus(bookDto.getStatus());
        book.setBorrower(bookDto.getBorrower());
        book.setBorrowDate(bookDto.getBorrowDate());
        book.setReturnDate(bookDto.getReturnDate());
        return getBookDto(book);
    }

    public String deleteBook(String id) {
        var searchedBook = booksRepository.findByBookId(id);
        booksRepository.delete(searchedBook);
        return "Book Successfully Deleted";
    }

}
