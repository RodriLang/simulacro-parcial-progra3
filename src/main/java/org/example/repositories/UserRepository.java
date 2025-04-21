package org.example.repositories;

import org.example.models.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepository extends GenericRepository<User> {

    private static UserRepository instance;

    private UserRepository() {
    }

    public static UserRepository getInstance() {

        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }


    @Override
    protected String getTableName() {
        return "usuarios";
    }

    @Override
    protected List<String> getFields() {
        return List.of("nombre", "email");
    }

    @Override
    protected void mapToStatement(PreparedStatement ps, User entity) throws SQLException {
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getEmail());
    }

    @Override
    protected User mapFromResultSet(ResultSet rs) throws SQLException {
        return User.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("nombre"))
                .email(rs.getString("email"))
                .build();
    }

    @Override
    protected int getId(User entity) {
        return entity.getId();
    }
}
