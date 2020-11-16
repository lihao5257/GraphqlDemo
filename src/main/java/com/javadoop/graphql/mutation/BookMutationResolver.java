package com.javadoop.graphql.mutation;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javadoop.graphql.model.Author;
import com.javadoop.graphql.model.Book;
import com.javadoop.graphql.model.BookWrapper;
import com.javadoop.graphql.repository.AuthorRepository;
import com.javadoop.graphql.repository.BookRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookMutationResolver(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book createBook(BookWrapper bookWrapper) {
        Book book = new Book(bookWrapper.getTitle(), bookWrapper.getIsbn());
        book.setPublishedDate(bookWrapper.getPublishedDate());
        return bookRepository.save(book);
    }

    public Book addAuthor(Long authorId, String isbn) {
        Optional<Author> author = authorRepository.findById(authorId);
        Optional<Book> book = bookRepository.findById(isbn);
        if (author.isPresent() && book.isPresent()) {
            Set<Author> authors = new HashSet<>();
            authors.add(author.get());
            book.get().setAuthors(authors);
            bookRepository.save(book.get());
            return book.get();
        }
        throw new GraphQLException("couldn't add author");
    }

}
