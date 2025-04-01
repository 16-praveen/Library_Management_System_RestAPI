package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
    final BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    
    public List<Book> getAllBook() {
        return bookRepository.findAllBook(); 
    }
    
    public Book getBook(int id) {
        return bookRepository.findBookById(id);
    }
    // public List<Book> getAllBook()
    // {
    //     return bookRepository.findAll();
    // }
    // public Book getBook(int id)
    // {
    //     return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("book not found"+id));
    // }
    public Page<Book> getAllPage(Pageable pg)
    {
        return bookRepository.findAll(pg);
    }
    public Book updateBook(int id,String title,String author,String available)
    {
     Book book=bookRepository.findById(id).orElseThrow(()->new RuntimeException("book not found"+id));
     if (title!=null) {
         book.setTitle(title);
     }
     if (author!=null) {
         book.setAuthor(author);
     }
     if (available!=null) {
        book.setAvailable(available);
     }
     return bookRepository.save(book);
    }
    public void deleteBook(int id)
   {
    if(!bookRepository.existsById(id))
    {
        throw new RuntimeException("book not found"+id);
    }
    bookRepository.deleteById(id);
    }
}
