package com.hospital.santajoana.domain.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseRepository<T> {

    protected final JdbcTemplate jdbcTemplate;
    private final String tableName;
    private final RowMapper<T> rowMapper; // RowMapper é uma interface que mapeia uma linha de um ResultSet para um objeto

    public T save(String insertSql, Object... params) {//object... params é um array de objetos
        jdbcTemplate.update(insertSql, params); // ex de insertSql: "INSERT INTO table_name (column1, column2, column3) VALUES (?, ?, ?)"
        return findById("id", jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class));
    }

    public List<T> findAll() {
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.query(sql, rowMapper);
    }

    public T findById(String idColumn, Object idValue) {
        String sql = "SELECT * FROM " + tableName + " WHERE " + idColumn + " = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, idValue);
    }

    public void delete(String idColumn, Object idValue) {
        String sql = "DELETE FROM " + tableName + " WHERE " + idColumn + " = ?";
        jdbcTemplate.update(sql, idValue);
    }
}
