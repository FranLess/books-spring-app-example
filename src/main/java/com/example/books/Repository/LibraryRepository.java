package com.example.books.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.books.Entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

}
