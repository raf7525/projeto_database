package com.hospital.santajoana.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.santajoana.domain.entity.Pedido;
import com.hospital.santajoana.domain.entity.Pedido.StatusPedido;
import com.hospital.santajoana.domain.mediator.PedidoMediator;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController extends BaseController<Pedido> {

    private final PedidoMediator pedidoMediator;

    public PedidoController(PedidoMediator pedidoMediator) {
        super(pedidoMediator);
        this.pedidoMediator = pedidoMediator;
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Pedido> updateStatus(@PathVariable Long id, @RequestParam StatusPedido status) {
        try {
            Pedido updatedPedido = pedidoMediator.updateStatus(id, status);
            return ResponseEntity.ok(updatedPedido);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
