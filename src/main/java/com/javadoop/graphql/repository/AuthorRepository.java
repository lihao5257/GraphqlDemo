package com.javadoop.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javadoop.graphql.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
