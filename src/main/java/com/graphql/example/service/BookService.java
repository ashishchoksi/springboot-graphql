package com.graphql.example.service;

import com.graphql.example.entity.Book;
import com.graphql.example.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // create
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    // get all
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(int id) {
        return bookRepository.findById(id).orElse(null);
    }

}
