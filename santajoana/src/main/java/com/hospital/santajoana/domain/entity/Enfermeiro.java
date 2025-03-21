package com.hospital.santajoana.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enfermeiro {
    
    private Long id; // Primary Key
    private String cre;
    private String nome;
    private String cargo;
    private String setor;

    public Enfermeiro(String cre, String nome, String cargo, String setor) {
        this.cre = cre;
        this.nome = nome;
        this.cargo = cargo;
        this.setor = setor;
    }
}


