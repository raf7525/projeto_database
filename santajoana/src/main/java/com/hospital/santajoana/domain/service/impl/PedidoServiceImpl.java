package com.hospital.santajoana.domain.service.impl;

import org.springframework.stereotype.Service;

import com.hospital.santajoana.domain.entity.Pedido;
import com.hospital.santajoana.domain.repository.PedidoRepository;
import com.hospital.santajoana.domain.service.PedidoService;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Integer> implements PedidoService {
    
    private final PedidoRepository pedidoRepository;
    
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        super(pedidoRepository);
        this.pedidoRepository = pedidoRepository;
    }
    
    @Override
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    
    @Override
    public Pedido findById(Integer id) {
        return pedidoRepository.findById(id);
    }
    
    @Override
    public void delete(Integer id) {
        pedidoRepository.delete(id);
    }
}
