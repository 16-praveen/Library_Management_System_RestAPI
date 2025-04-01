package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

 @Service
public class AuthorService {
    final AuthorRepository authorRepository;
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    // Method to get an author by ID
    public Author getAuthor(int id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id " + id));
    }        
    
public Author updateAuthor(int id,String name,String book)
    {
    Author author=authorRepository.findById(id).orElseThrow(()->new RuntimeException("author not found"+id));
    if (name!=null) {
        author.setName(name);
    }
    if (book!=null) {
        author.setBook(book);
    }
    return authorRepository.save(author);
    }
public void deleteAuthor(int id)
   {
    if(!authorRepository.existsById(id))
    {
        throw new RuntimeException("user not found"+id);
    }
    authorRepository.deleteById(id);
   }
    
}
