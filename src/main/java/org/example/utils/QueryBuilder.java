package org.example.utils;

import java.util.List;

public class QueryBuilder {

    public static String buildSelectAllQuery(String tableName) {
        return "SELECT * FROM " + tableName;
    }

    public static String buildSelectByIdQuery(String tableName) {
        return "SELECT * FROM " + tableName;
    }

    public static String buildUpdateQuery(String tableName, List<String> fields) {
        StringBuilder query = new StringBuilder("UPDATE ").append(tableName).append(" SET ");

        for (int i = 0; i < fields.size(); i++) {
            query.append(fields.get(i)).append(" = ?");
            if (i < fields.size() - 1) {
                query.append(", ");
            }
        }
        query.append(" WHERE id = ?");
        return query.toString();
    }

    public static String buildDeleteQuery(String tableName) {
        return "DELETE FROM " + tableName + " WHERE id = ?";
    }

    public static String buildInsertQuery(String tableName, List<String> fields) {
        StringBuilder query = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
        query.append(String.join(", ", fields));
        query.append(") VALUES (");
        query.append("?,".repeat(fields.size()));
        query.setLength(query.length() - 1);
        query.append(")");

        return query.toString();
    }
}
