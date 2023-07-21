package com.test.librarydemo.repositories;

import com.test.librarydemo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {
    Book findByBookId(String bookId);
}
