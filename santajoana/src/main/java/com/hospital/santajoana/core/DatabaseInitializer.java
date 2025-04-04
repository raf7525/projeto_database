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
            "DROP TABLE IF EXISTS CAMAREIRA_QUARTO_PERIODO;",
            "DROP TABLE IF EXISTS PEDIDO_REALIZADO;",
            "DROP TABLE IF EXISTS FATURA;",
            "DROP TABLE IF EXISTS PEDIDO;",
            "DROP TABLE IF EXISTS PACIENTE;",
            "DROP TABLE IF EXISTS CAMAREIRA;",
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

            "CREATE TABLE IF NOT EXISTS QUARTO ("
            + "ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "NUMERO INT NOT NULL,"
            + "TIPO ENUM('Enfermaria','Apartamento','UTI','Sala de Exame','Outro') NOT NULL"
            + ");",
            
            "CREATE TABLE IF NOT EXISTS PACIENTE ("
            + "ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "NOME VARCHAR(100) NOT NULL,"
            + "CPF VARCHAR(11) UNIQUE NOT NULL,"
            + "DATA_NASCIMENTO DATE NOT NULL,"
            + "STATUS ENUM('Internado','Alta') NOT NULL,"
            + "FOREIGN KEY (ID_QUARTO) REFERENCES QUARTO (ID_QUARTO)"
            + ");",


            "CREATE TABLE IF NOT EXISTS PEDIDO ("
            + "ID_PEDIDO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "DATA_HORA DATETIME NOT NULL,"
            + "ID_PACIENTE INT,"
            + "ID_QUARTO INT,"
            + "STATUS ENUM('Em andamento','Entregue','Pago') NOT NULL,"
            + "FOREIGN KEY (ID_PACIENTE) REFERENCES PACIENTE (ID_PACIENTE),"
            + "FOREIGN KEY (ID_QUARTO) REFERENCES QUARTO (ID_QUARTO)"
            + ");",

            "CREATE TABLE IF NOT EXISTS PRODUTO ("
            + "ID_PRODUTO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "NOME VARCHAR(100) NOT NULL,"
            + "DESCRICAO TEXT,"
            + "PRECO DECIMAL(10,2) NOT NULL"
            + ");",

            "CREATE TABLE IF NOT EXISTS PEDIDO_REALIZADO ("
            + "ID_ITEM_PEDIDO INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "ID_PEDIDO INT,"
            + "ID_PEDIDO INT,"
            + "QUANTIDADE INT NOT NULL,"
            + "VALOR_UNITARIO DECIMAL(10,2) NOT NULL,"
            + "FOREIGN KEY (ID_PEDIDO) REFERENCES PEDIDO (ID_PEDIDO),"
            + "FOREIGN KEY (ID_PEDIDO) REFERENCES PRODUTO (ID_PRODUTO)"
            + ");",

            "CREATE TABLE IF NOT EXISTS FATURA ("
            + "ID_FATURA INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "ID_PACIENTE INT,"
            + "VALOR_TOTAL DECIMAL(10,2) NOT NULL,"
            + "STATUS_PAGAMENTO ENUM('Pendente','Pago') NOT NULL,"
            + "DATA_PAGAMENTO DATETIME,"
            + "ID_METODO_PAGAMENTO INT,"
            + "FOREIGN KEY (ID_PACIENTE) REFERENCES PACIENTE (ID),"
            + "FOREIGN KEY (ID_METODO_PAGAMENTO) REFERENCES METODO_PAGAMENTO (ID)"
            + ");",

            "CREATE TABLE IF NOT EXISTS CAMAREIRA ("
            + "ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "NOME VARCHAR(100) NOT NULL,"
            + "CARGO VARCHAR(50) NOT NULL,"
            + "SETOR VARCHAR(50) NOT NULL"
            + ");",

            "CREATE TABLE IF NOT EXISTS METODO_PAGAMENTO ("
            + "ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "TIPO ENUM('Cartão de Crédito','Cartão de Débito','Pix') NOT NULL,"
            + "DATA_HORA DATETIME NOT NULL"
            + ");",

            "CREATE TABLE IF NOT EXISTS CAMAREIRA_QUARTO_PACIENTE ("
            +"UNIQUE (ID_CAMAREIRA, ID_PACIENTE, ID_QUARTO, DATA_INICIO)"
            + "ID_CAMAREIRA INT NOT NULL,"
            +"ID_PACIENTE INT,"
            + "ID_QUARTO INT,"
            + "DATA_INICIO DATETIME NOT NULL,"
            + "DATA_FIM DATETIME,"
            + "FOREIGN KEY (ID_CAMAREIRA) REFERENCES CAMAREIRA (ID),"
            + "FOREIGN KEY (ID_QUARTO) REFERENCES QUARTO (ID)"
            + "FOREIGN KEY (ID_PACIENTE) REFERENCES PACIENTE (ID_PACIENTE)"
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
