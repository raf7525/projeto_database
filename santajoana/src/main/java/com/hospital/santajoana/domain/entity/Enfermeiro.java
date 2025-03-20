package com.hospital.santajoana.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enfermeiro {
    
    private String cre;// Primary Key
    
    private String nome;
    private String cargo;
    private String setor;
}
