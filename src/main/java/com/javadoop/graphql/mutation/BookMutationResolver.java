package com.javadoop.graphql.mutation;

import org.springframework.stereotype.Component;

import com.javadoop.graphql.model.Book;
import com.javadoop.graphql.model.BookWrapper;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class BookMutationResolver implements GraphQLMutationResolver{

    public Book createBook(BookWrapper wrapper) {
        return new Book(wrapper.getTitle(), wrapper.getIsbn());
    }
}
