package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/authors")
public class AuthorController{
    public AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    
    public  ResponseEntity<Object> createAuthor(@RequestBody Author author) {

        Author author2 = authorService.createAuthor(author);
        return ResponseEntity.ok(author2);}
        

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor()
    {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    
    @PutMapping("{id}")
    public ResponseEntity<Object>updateAuthor (@PathVariable("id") int id,@RequestBody Author author)
    {
        authorService.updateAuthor(id,author.getName(),author.getBook());
        return ResponseEntity.ok("Updates Success");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object>deleteAuthor(@PathVariable("id") int id)
    {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Deleted SuccessFully");
    }


    }

    

