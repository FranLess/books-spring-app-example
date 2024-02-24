package com.example.books.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.books.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
