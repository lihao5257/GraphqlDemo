package com.javadoop.graphql.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javadoop.graphql.exception.ResourceNotFoundException;
import com.javadoop.graphql.model.Book;
import com.javadoop.graphql.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Component
public class BookResolver implements GraphQLQueryResolver {

    private final BookRepository bookRepository;

    @Autowired
    public BookResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Connection<Book> books(int first, String after, DataFetchingEnvironment env) {
        List<Book> books = bookRepository.findAll();
        return new SimpleListConnection<>(books).get(env);
    }

    public Book getBook(String isbn) {
        Optional<Book> bookContainer =  bookRepository.findById(isbn);
        if (bookContainer.isPresent()) {
            return bookContainer.get();
        }
        throw new ResourceNotFoundException("There is no book with : " + isbn);
    }

}
