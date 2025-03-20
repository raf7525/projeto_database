package com.hospital.santajoana.domain.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fatura {
    private Integer idFatura; // Primary Key
    private Integer pacienteId;
    private BigDecimal valorTotal;
    private StatusPagamento statusPagamento; // Default: Pendente
    private LocalDateTime dataPagamento; // Optional when creating a new Fatura
    private Integer idMetodoPagamento; // Foreign Key to MetodoPagamento. Optional when creating a new Fatura
    
    // Enum for status_pagamento
    public enum StatusPagamento {
        Pendente, Pago
    }

    public Fatura(Integer idFatura, Integer pacienteId, BigDecimal valorTotal, StatusPagamento statusPagamento) {
        this.idFatura = idFatura;
        this.pacienteId = pacienteId;
        this.valorTotal = valorTotal;
        this.statusPagamento = statusPagamento;
    }
    
   
}
