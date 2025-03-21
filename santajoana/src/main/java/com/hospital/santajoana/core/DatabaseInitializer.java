package com.hospital.santajoana.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DatabaseInitializer {

    @Autowired
    private final JdbcTemplate jdbcTemplate;
    
    @Value("${database.recreate-tables:false}")
    private boolean recreateTables;

    public void dropTables() {
        String[] dropStatements = {
            "DROP TABLE IF EXISTS ENFERMEIRO_QUARTO_PERIODO;",
            "DROP TABLE IF EXISTS PEDIDO_REALIZADO;",
            "DROP TABLE IF EXISTS FATURA;",
            "DROP TABLE IF EXISTS PEDIDO;",
            "DROP TABLE IF EXISTS PACIENTE;",
            "DROP TABLE IF EXISTS ENFERMEIRO;",
            "DROP TABLE IF EXISTS QUARTO;",
            "DROP TABLE IF EXISTS PRODUTO;",
            "DROP TABLE IF EXISTS METODO_PAGAMENTO;"
        };

        for (String sql : dropStatements) {
            jdbcTemplate.execute(sql);
        }
    }

    public void createTables() {
        String[] sqlStatements = {
            "CREATE TABLE IF NOT EXISTS PACIENTE ("
            + "ID_PACIENTE INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "NOME VARCHAR(100) NOT NULL,"
            + "CPF VARCHAR(11) UNIQUE NOT NULL,"
            + "DATA_NASCIMENTO DATE NOT NULL,"
            + "quartoId INT,"
            + "STATUS ENUM('Internado','Alta') NOT NULL,"
            + "FOREIGN KEY (quartoId) REFERENCES QUARTO (ID_QUARTO)"
            + ");",

            "CREATE TABLE IF NOT EXISTS QUARTO ("
            + "ID_QUARTO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "NUMERO INT NOT NULL,"
            + "TIPO ENUM('Enfermaria','Apartamento','UTI','Sala de Exame','Outro') NOT NULL"
            + ");",

            "CREATE TABLE IF NOT EXISTS PEDIDO ("
            + "ID_PEDIDO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "DATA_HORA DATETIME NOT NULL,"
            + "PACIENTE_ID INT,"
            + "quartoId INT,"
            + "STATUS ENUM('Em andamento','Entregue','Pago') NOT NULL,"
            + "FOREIGN KEY (PACIENTE_ID) REFERENCES PACIENTE (ID_PACIENTE),"
            + "FOREIGN KEY (quartoId) REFERENCES QUARTO (ID_QUARTO)"
            + ");",

            "CREATE TABLE IF NOT EXISTS PRODUTO ("
            + "ID_PRODUTO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "NOME VARCHAR(100) NOT NULL,"
            + "DESCRICAO TEXT,"
            + "PRECO DECIMAL(10,2) NOT NULL"
            + ");",

            "CREATE TABLE IF NOT EXISTS PEDIDO_REALIZADO ("
            + "ID_ITEM_PEDIDO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "PEDIDO_ID INT,"
            + "PRODUTO_ID INT,"
            + "QUANTIDADE INT NOT NULL,"
            + "VALOR_UNITARIO DECIMAL(10,2) NOT NULL,"
            + "FOREIGN KEY (PEDIDO_ID) REFERENCES PEDIDO (ID_PEDIDO),"
            + "FOREIGN KEY (PRODUTO_ID) REFERENCES PRODUTO (ID_PRODUTO)"
            + ");",

            "CREATE TABLE IF NOT EXISTS FATURA ("
            + "ID_FATURA INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "PACIENTE_ID INT,"
            + "VALOR_TOTAL DECIMAL(10,2) NOT NULL,"
            + "STATUS_PAGAMENTO ENUM('Pendente','Pago') NOT NULL,"
            + "DATA_PAGAMENTO DATETIME,"
            + "ID_METODO_PAGAMENTO INT,"
            + "FOREIGN KEY (PACIENTE_ID) REFERENCES PACIENTE (ID_PACIENTE),"
            + "FOREIGN KEY (ID_METODO_PAGAMENTO) REFERENCES METODO_PAGAMENTO (ID_METODO_PAGAMENTO)"
            + ");",

            "CREATE TABLE IF NOT EXISTS ENFERMEIRO ("
            + "ID_ENFERMEIRO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "CRE VARCHAR(10) NOT NULL UNIQUE,"
            + "NOME VARCHAR(100) NOT NULL,"
            + "CARGO VARCHAR(50) NOT NULL,"
            + "SETOR VARCHAR(50) NOT NULL"
            + ");",

            "CREATE TABLE IF NOT EXISTS METODO_PAGAMENTO ("
            + "ID_METODO_PAGAMENTO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "TIPO ENUM('Cartão de Crédito','Cartão de Débito','Pix') NOT NULL,"
            + "DATA_HORA DATETIME NOT NULL"
            + ");",

            "CREATE TABLE IF NOT EXISTS ENFERMEIRO_QUARTO_PERIODO ("
            + "ID_ENFERMEIRO_QUARTO_PERIODO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "ENFERMEIRO_CRE VARCHAR(10),"
            + "quartoId INT,"
            + "DATA_INICIO DATETIME NOT NULL,"
            + "DATA_FIM DATETIME,"
            + "FOREIGN KEY (ENFERMEIRO_CRE) REFERENCES ENFERMEIRO (CRE),"
            + "FOREIGN KEY (quartoId) REFERENCES QUARTO (ID_QUARTO)"
            + ");"
        };

        for (String sql : sqlStatements) {
            jdbcTemplate.execute(sql);
        }
    }

    @PostConstruct
    public void init() {
        if (recreateTables) {
            dropTables();
        }
        createTables();
    }
}
