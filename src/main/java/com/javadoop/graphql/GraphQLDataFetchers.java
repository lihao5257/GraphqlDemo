package com.javadoop.graphql;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;

import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> books   = Arrays.asList(
        ImmutableMap.of("id", "book-1",
            "name", "Harry Potter and the Philosopher's Stone",
            "pageCount", "223",
            "authorId", "author-1"),
        ImmutableMap.of("id", "book-2",
            "name", "Moby Dick",
            "pageCount", "635",
            "authorId", "author-2"),
        ImmutableMap.of("id", "book-3",
            "name", "Interview with the vampire",
            "pageCount", "371",
            "authorId", "author-3"),
        ImmutableMap.of("id", "book-3",
            "name", "Interview with the vampire",
            "pageCount", "371",
            "authorId", "author-3"),
        ImmutableMap.of("id", "book-4",
            "name", "Permanet Record",
            "pageCount", "567",
            "authorId", "author-4"),
        ImmutableMap.of("id", "book-5",
            "name", "Harry Porter 1",
            "pageCount", "900",
            "authorId", "author-5"),
        ImmutableMap.of("id", "book-6",
            "name", "Harry Porter 2",
            "pageCount", "1021",
            "authorId", "author-5"),
        ImmutableMap.of("id", "book-7",
            "name", "Harry Porter 3",
            "pageCount", "1231",
            "authorId", "author-5"),
        ImmutableMap.of("id", "book-8",
            "name", "Harry Porter 4",
            "pageCount", "877",
            "authorId", "author-5"),
        ImmutableMap.of("id", "book-9",
            "name", "Harry Porter 5",
            "pageCount", "1200",
            "authorId", "author-5"));

    private static List<Map<String, String>> authors = Arrays.asList(
        ImmutableMap.of("id", "author-1",
            "firstName", "Joanne",
            "lastName", "Rowling"),
        ImmutableMap.of("id", "author-2",
            "firstName", "Herman",
            "lastName", "Melville"),
        ImmutableMap.of("id", "author-3",
            "firstName", "Anne",
            "lastName", "Rice"),
        ImmutableMap.of("id", "author-4",
            "firstName", "Edward",
            "lastName", "SnowDen"),
        ImmutableMap.of("id", "author-5",
            "firstName", "JK",
            "lastName", "Roally"));

    public DataFetcher<Object> getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return books
                .stream()
                .filter(book -> book.get("id").equals(bookId))
                .findFirst()
                .orElse(null);
        };
    }

    public DataFetcher<Object> getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");
            return authors
                .stream()
                .filter(author -> author.get("id").equals(authorId))
                .findFirst()
                .orElse(null);
        };
    }

    public DataFetcher<Object> getAllBooksDataFetcher() {
        return dataFetchingEnvironment -> {
            return books;
        };
    }
}
