package com.example.books.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.books.Entity.Book;
import com.example.books.Repository.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent())
            return ResponseEntity.ok(book.get());
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll(Pageable pageable) {
        Page<Book> page = bookRepository.findAll(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                pageable.getSortOr(Sort.by(Sort.Direction.ASC, "amount"))));

        return ResponseEntity.ok(page.getContent());
    }

    @PostMapping
    private ResponseEntity<Void> createBook(@RequestBody Book book, UriComponentsBuilder ucb) {
        Book savedBook = bookRepository.save(book);
        URI locationOfNewCashCard = ucb.path("api/books/{id}")
                .buildAndExpand(savedBook.id())
                .toUri();
        return ResponseEntity.created(locationOfNewCashCard).build();
    }

    @PutMapping("/{requestedId}")
    private ResponseEntity<Void> putBook(@PathVariable Long requestedId, @RequestBody Book bookUpdate) {
        Optional<Book> book = bookRepository.findById(requestedId);
        if (book.isPresent()) {
            Book updatedBook = new Book(requestedId, bookUpdate.title(), bookUpdate.yearPublished(), bookUpdate.isbn(),
                    bookUpdate.quantity(), null, null);
            bookRepository.save(updatedBook);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
