package com.javadoop.graphql.ErrorHandler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;

@Component
public class ErrorHandler implements GraphQLErrorHandler{

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> errors) {
        return errors.stream().map(this::getNested).collect(Collectors.toList());
    }

    private GraphQLError getNested(GraphQLError e) {
        if (e instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching dataFetchingEx = (ExceptionWhileDataFetching)e;
            if (dataFetchingEx.getException() instanceof GraphQLError) {
                return (GraphQLError) dataFetchingEx.getException();
            }
        }
        return e;
        
    }

}
