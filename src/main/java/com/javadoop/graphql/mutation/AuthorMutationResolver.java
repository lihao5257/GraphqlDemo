package com.javadoop.graphql.mutation;

import com.javadoop.graphql.model.Author;
import com.javadoop.graphql.model.AuthorWrapper;
import com.javadoop.graphql.repository.AuthorRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

    private final AuthorRepository repository;

    @Autowired
    public AuthorMutationResolver(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author createAuthor(AuthorWrapper wrapper) {
        Author author = new Author(wrapper.getName());
        return repository.save(author);
    }
}
