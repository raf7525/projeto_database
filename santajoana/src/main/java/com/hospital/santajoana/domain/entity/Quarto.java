package com.hospital.santajoana.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quarto {

    private Long idQuarto;
    
    private String numero;
    
    private String tipo;
    
}
