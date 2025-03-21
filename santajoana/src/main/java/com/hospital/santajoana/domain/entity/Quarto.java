package com.hospital.santajoana.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quarto {

    private Long id;
    
    private Integer numero;
    
    private String tipo;
    
    public Quarto(Integer numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }
}
