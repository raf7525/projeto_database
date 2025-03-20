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
    
    private Integer idPedido;
    private LocalDateTime dataHora;
    private Integer pacienteId;
    private Integer quartoId;
    private StatusPedido status;
    
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
