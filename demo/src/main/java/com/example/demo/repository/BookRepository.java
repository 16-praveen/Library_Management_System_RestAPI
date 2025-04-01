package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("SELECT a FROM Book a")
    List<Book> findAllBook();

    @Query("SELECT a FROM Book a WHERE a.id = :id")
    Book findBookById(int id);
}
