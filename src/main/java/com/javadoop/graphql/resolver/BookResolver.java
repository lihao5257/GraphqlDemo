package com.javadoop.graphql.resolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javadoop.graphql.model.Book;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class BookResolver implements GraphQLQueryResolver {

    static List<Book> books  = null;
    static {
        books   =new ArrayList<Book>();
        books.add(new Book("Harry Porter 1", "1111"));
        books.add(new Book("Harry Porter 2", "2234"));
        books.add(new Book("Harry Porter 3", "2434324"));
        books.add(new Book("Harry Porter 4", "112343211"));
        books.add(new Book("Harry Porter 5", "5646"));
    }


    public Book getBook(String isbn) {
        return new Book("Learn GraphQL", "309234324");
    }
    
    public List<Book> getAllBooks() {
        return books;
    }
}
