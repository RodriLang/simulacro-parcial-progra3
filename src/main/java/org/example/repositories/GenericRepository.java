package org.example.repositories;

import org.example.conection.DatabaseConnection;
import org.example.utils.QueryBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Es una clase abstracta que encapsula las el acceso a la base de datos para todas las entidades
public abstract class GenericRepository<T> implements IRepository<T> {

    //Estos métodos se sobreescriben en las clases que la extiendan
    //implementando la logica de cada entidad
    protected abstract String getTableName();
    protected abstract List<String> getFields();
    protected abstract void mapToStatement(PreparedStatement ps, T entity) throws SQLException;
    protected abstract T mapFromResultSet(ResultSet rs) throws SQLException;
    protected abstract int getId(T entity);






    @Override
    public void save(T entity) throws SQLException {
        String sql = QueryBuilder.buildInsertQuery(getTableName(), getFields());
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            mapToStatement(ps, entity);
            ps.executeUpdate();
        }
    }

    @Override
    public void update(T entity) throws SQLException {
        String sql = QueryBuilder.buildUpdateQuery(getTableName(), getFields());
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            mapToStatement(ps, entity);
            ps.setInt(getFields().size() + 1, getId(entity));
            ps.executeUpdate();
        }
    }

    @Override
    public Optional<T> findById(int id) throws SQLException {
        String sql = QueryBuilder.buildSelectByIdQuery(getTableName());
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapFromResultSet(rs));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<T> findAll() throws SQLException {
        List<T> result = new ArrayList<>();
        String sql = QueryBuilder.buildSelectAllQuery(getTableName());
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(mapFromResultSet(rs));
                }
            }
        }
        return result;
    }

    @Override
    public void delete(T entity) throws SQLException {
        String sql = QueryBuilder.buildDeleteQuery(getTableName());
        try (PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, getId(entity));
            ps.executeUpdate();
        }
    }
}
