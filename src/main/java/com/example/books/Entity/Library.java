package com.example.books.Entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "library")
    private List<Loan> loans;

    @ManyToMany
    @JoinTable(name = "library_books", joinColumns = @JoinColumn(name = "library_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

    public Library(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Loan> getLoans() {
        return this.loans;
    }

    public List<Book> getBooks() {
        return this.books;
    }

}
