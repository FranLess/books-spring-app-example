package com.example.books.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.books.Entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

}
