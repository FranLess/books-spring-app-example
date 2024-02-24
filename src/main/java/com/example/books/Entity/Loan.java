package com.example.books.Entity;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    private Date borrowDate;
    private Date returnDate;
    private boolean returned = false;

    public Loan(User user, Book book, Date borrowDate, Date returnDate) {
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return this.id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getBorrowDate() {
        return this.borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return this.returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return this.returned;
    }

    public boolean getReturned() {
        return this.returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public Library getLibrary() {
        return this.library;
    }


}
