package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    
    @Query("SELECT a FROM Author a")
    List<Author> findAllAuthors();
    

    @Query("SELECT a.name FROM Author a WHERE a.book = :book")
    String findByBook(@Param("book")String book);

    
    
}
