package com.hospital.santajoana.domain.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Paciente {

    private Long id_paciente; // Primary Key
    private String nome;
    private String cpf;
    private LocalDate data_nascimento;
    private Long quarto_id; // Foreign Key to Quarto
    private String status; // Internado/Alta

}
