package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/book")
public class BookController {
    public BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }
    @PostMapping
    public  ResponseEntity<Object> createBook(@RequestBody Book book) {

        Book book2 = bookService.createBook(book);
        return ResponseEntity.ok(book2);
    }    
    @GetMapping
    public ResponseEntity<List<Book>> getAllBook()
    {
        return ResponseEntity.ok(bookService.getAllBook());
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> getBook(@PathVariable("id") int id) {
    Book book = bookService.getBook(id);
    if (book == null) {
        return ResponseEntity.status(404).body("Book not found with ID: " + id);
    }
    return ResponseEntity.ok(book);
   }
    // @GetMapping("{id}")
    // public ResponseEntity<Object>getbook(@PathVariable("id") int id)
    // {
    //     Book book= bookService.getBook(id);
    //     return ResponseEntity.status(200).body(book);
    // }
    @GetMapping("paginate")
    public Page<Book>getAllPage(Pageable pg)
    {
        return bookService.getAllPage(pg);
    }
    @PutMapping("{id}")
    public ResponseEntity<Object>updateBook (@PathVariable("id") int id,@RequestBody Book book)
    {
        bookService.updateBook(id,book.getTitle(),book.getAuthor(),book.getAvailable());
        return ResponseEntity.ok("Updates Success");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object>deleteBook(@PathVariable("id") int id)
    {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Deleted SuccessFully");
    }
}


    

    


