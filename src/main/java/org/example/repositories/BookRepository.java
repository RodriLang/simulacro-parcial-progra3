package org.example.repositories;

import org.example.models.entities.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookRepository extends GenericRepository<Book> {

    private static BookRepository instance;

    private BookRepository() {
    }

    public static BookRepository getInstance() {

        if (instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }

    @Override
    protected String getTableName() {
        return "usuarios";
    }

    @Override
    protected List<String> getFields() {
        return List.of("titulo", "autor", "anio_publicacion", "unidades_disponibles");
    }

    @Override
    protected void mapToStatement(PreparedStatement ps, Book entity) throws SQLException {
        ps.setString(1, entity.getTitle());
        ps.setString(2, entity.getAuthor());
        ps.setInt(3, entity.getPublisher());
        ps.setInt(4, entity.getAvailableUnits());
    }

    @Override
    protected Book mapFromResultSet(ResultSet rs) throws SQLException {
        return Book.builder()
                .id(rs.getInt("id"))
                .title(rs.getString("titulo"))
                .author(rs.getString("autor"))
                .publisher(rs.getInt("anio_publicacion"))
                .availableUnits(rs.getInt("unidades_disponibles"))
                .build();
    }

    @Override
    protected int getId(Book entity) {
        return 0;
    }
}
