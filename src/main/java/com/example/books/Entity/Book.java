package com.example.books.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public record Book(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id,
        String title,
        int yearPublished,
        String isbn,
        int quantity,

        @OneToMany(mappedBy = "book") List<Loan> loans,

        @ManyToMany(mappedBy = "books") List<Library> libraries){
            
        }
