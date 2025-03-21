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
    private Long id; // Primary Key
    private Long pacienteId;
    private BigDecimal valorTotal;
    private StatusPagamento statusPagamento; // Default: Pendente
    private LocalDateTime dataPagamento; // Optional when creating a new Fatura
    private Long idMetodoPagamento; // Foreign Key to MetodoPagamento. Optional when creating a new Fatura
    
    // Enum for status_pagamento
    public enum StatusPagamento {
        Pendente, Pago
    }

    public Fatura(Long pacienteId, BigDecimal valorTotal, StatusPagamento statusPagamento) {
        this.pacienteId = pacienteId;
        this.valorTotal = valorTotal;
        this.statusPagamento = statusPagamento;
    }
    
    public Fatura(Long id, Long pacienteId, BigDecimal valorTotal, StatusPagamento statusPagamento) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.valorTotal = valorTotal;
        this.statusPagamento = statusPagamento;
    }
    
   
}
