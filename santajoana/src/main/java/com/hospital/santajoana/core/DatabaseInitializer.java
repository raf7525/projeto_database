package com.hospital.santajoana.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS paciente ("
                   + "id BIGINT PRIMARY KEY AUTO_INCREMENT, "
                   + "nome VARCHAR(255) NOT NULL, "
                   + "idade INT"
                   + ");";

        jdbcTemplate.execute(sql); // Executa o SQL para criar a tabela se ela não existir
    }

    @PostConstruct//Anotação que indica que o método deve ser executado após a injeção de dependências
    public void init() {
        createTableIfNotExists();
    }
}
