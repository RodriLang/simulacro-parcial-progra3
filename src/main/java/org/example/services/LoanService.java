package org.example.services;

import org.example.exceptions.BookNotFoudException;
import org.example.exceptions.DatabaseException;
import org.example.models.entities.Loan;
import org.example.repositories.LoanRepository;

import java.sql.SQLException;
import java.util.List;

public class LoanService implements IService<Loan> {

    private static LoanService instance;
    private final LoanRepository loanRepository;

    private LoanService() {
        this.loanRepository = LoanRepository.getInstance();
    }


    public static LoanService getInstance() {
        if (instance == null) {
            instance = new LoanService();
        }
        return instance;
    }


    @Override
    public void save(Loan loan) {
        try {
            loanRepository.save(loan);
        } catch (SQLException e) {
            throw new DatabaseException("Error al guardar prestamo. No se pudo acceder a la base de datos. ", e);
        }
    }

    @Override
    public List<Loan> findAll() {
        List<Loan> loan;
        try {
            loan = loanRepository.findAll();
        } catch (SQLException e) {
            throw new DatabaseException("Error al buscar prestamo. No se pudo acceder a la base de datos. ", e);
        }
        return loan;
    }

    @Override
    public Loan findById(Integer id) {
        try {
            return loanRepository.findById(id).orElseThrow(() -> new BookNotFoudException(id));
        } catch (SQLException e) {
            throw new DatabaseException("Error al buscar prestamo por id. No se pudo acceder a la base de datos. ", e);
        }
    }

    @Override
    public void delete(Loan loan) {

        try {
            loanRepository.delete(loan);
        } catch (SQLException e) {
            throw new DatabaseException("Error al eliminar prestamo. No se pudo acceder a la base de datos. ", e);
        }
    }
}
