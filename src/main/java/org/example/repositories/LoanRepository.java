package org.example.repositories;

import org.example.exceptions.BookNotFoudException;
import org.example.exceptions.UserNotFoudException;
import org.example.models.entities.Loan;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoanRepository extends GenericRepository<Loan> {

    private static LoanRepository instance;

    private LoanRepository() {
    }

    public static LoanRepository getInstance() {

        if (instance == null) {
            instance = new LoanRepository();
        }
        return instance;
    }

    @Override
    protected String getTableName() {
        return "prestamos";
    }

    @Override
    protected List<String> getFields() {
        return List.of("libro_id", "usuario_id", "fecha_prestamo", "fecha_devolucion");
    }

    @Override
    protected void mapToStatement(PreparedStatement ps, Loan entity) throws SQLException {
        ps.setLong(1, entity.getBook().getId());
        ps.setLong(2, entity.getUser().getId());
        ps.setDate(3, Date.valueOf(entity.getLoanDate()));
        ps.setDate(4, Date.valueOf(entity.getReturnDate()));
    }

    @Override
    protected Loan mapFromResultSet(ResultSet rs) throws SQLException {
        int libroId = rs.getInt("libro_id");
        int usuarioId = rs.getInt("usuario_id");
        return Loan.builder()
                .id(rs.getInt("id"))
                .book(BookRepository.getInstance().findById(libroId)
                        .orElseThrow(() -> new BookNotFoudException(libroId)))
                .user(UserRepository.getInstance().findById(usuarioId)
                        .orElseThrow(() -> new UserNotFoudException(usuarioId)))
                .loanDate(rs.getDate("fecha_prestamo").toLocalDate())
                .returnDate(rs.getDate("fecha_devolucion").toLocalDate())
                .build();
    }

    @Override
    protected int getId(Loan entity) {
        return entity.getId();
    }
}
