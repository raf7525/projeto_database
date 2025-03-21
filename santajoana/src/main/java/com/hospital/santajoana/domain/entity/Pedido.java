package com.hospital.santajoana.domain.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    
    private Long id;
    private LocalDateTime dataHora;
    private Long pacienteId;
    private Long quartoId;
    private StatusPedido status;
    
    public Pedido(LocalDateTime dataHora, Long pacienteId, Long quartoId, StatusPedido status) {
        this.dataHora = dataHora;
        this.pacienteId = pacienteId;
        this.quartoId = quartoId;
        this.status = status;
    }

    @Getter
    public enum StatusPedido {
        EM_ANDAMENTO("Em andamento"),
        ENTREGUE("Entregue"),
        PAGO("Pago");
        
        private String descricao;
        
        StatusPedido(String descricao) {
            this.descricao = descricao;
        }
    
    }
}
