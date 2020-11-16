package com.javadoop.graphql;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javadoop.graphql.model.Author;
import com.javadoop.graphql.model.Book;
import com.javadoop.graphql.repository.AuthorRepository;
import com.javadoop.graphql.repository.BookRepository;

@SpringBootApplication
public class GraphqlTutorialApplication implements ApplicationRunner{

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    
    public static void main(String[] args) {
        SpringApplication.run(GraphqlTutorialApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
      Book book = new Book("Learning GraphQL: Declarative Data Fetching for Modern Web Apps",
          "123-123123");
      book.setPublishedDate(LocalDate.of(2019, 11, 4));
      Author eve = new Author("Eve Porcello");
      Author alex = new Author("Alex Banks");
      book.addAuthor(eve);
      book.addAuthor(alex);

      authorRepository.saveAll(Arrays.asList(eve, alex));
      bookRepository.save(book);

      Book book1 = new Book("The Road to GraphQL: Your journey to master pragmatic GraphQL in JavaScript with React.js and Node.js",
          "123-321321");
      Author robin = new Author("Robin Wieruch");
      book1.addAuthor(robin);
      book1.setPublishedDate(LocalDate.of(2020, 1, 10));

      authorRepository.save(robin);
      bookRepository.save(book1);
    }

}
