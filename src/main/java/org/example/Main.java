package org.example;

import org.example.services.LoanService;
import org.example.utils.QueryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(QueryBuilder.buildSelectAllQuery("usuarios"));
        System.out.println(QueryBuilder.buildSelectByIdQuery("usuarios"));
        System.out.println(QueryBuilder.buildDeleteQuery("usuarios"));
        System.out.println(QueryBuilder.buildInsertQuery("usuarios", List.of("nombre", "apellido","email")));
        System.out.println(QueryBuilder.buildUpdateQuery("usuarios", List.of("nombre", "email")));


        LoanService loanService = LoanService.getInstance();

        loanService.findAll().forEach(System.out::println);
    }
}