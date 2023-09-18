package com.graphql.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.example.entity.Book;
import com.graphql.example.entity.BookInput;
import com.graphql.example.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller // GraphQL needs controller annotation
public class BookController {

    private final BookService bookService;
    private final ObjectMapper mapper = new ObjectMapper();

    @MutationMapping("createBook") // mutation is used when you post some data
    // we cannot use Book directly because we have given BookInput type in schema.graphqls file
    public Book create(@Argument BookInput book) throws IOException {
        Book bookEntity = mapper.readValue(mapper.writeValueAsBytes(book), Book.class);
        return bookService.create(bookEntity);
    }

    @QueryMapping("getAllBooks") // here name of query defined in schema.graphqls file
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping("getBook") // name of query defined in schema.graphqls file
    public Book getBook(@Argument Integer bookId) {
        return bookService.getBook(bookId);
    }
}
