package com.javadoop.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javadoop.graphql.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
