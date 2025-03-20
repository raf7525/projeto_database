package com.hospital.santajoana.domain.service.impl;

import org.springframework.stereotype.Service;

import com.hospital.santajoana.domain.entity.Quarto;
import com.hospital.santajoana.domain.repository.QuartoRepository;
import com.hospital.santajoana.domain.service.QuartoService;

@Service
public class QuartoServiceImpl extends BaseServiceImpl<Quarto, Long> implements QuartoService {
    
    private final QuartoRepository quartoRepository;
    
    public QuartoServiceImpl(QuartoRepository quartoRepository) {
        super(quartoRepository);
        this.quartoRepository = quartoRepository;
    }
    
    @Override
    public Quarto save(Quarto quarto) {
        return quartoRepository.save(quarto);
    }
    
    @Override
    public Quarto findById(Long id) {
        return quartoRepository.findById(id);
    }
    
    @Override
    public void delete(Long id) {
        quartoRepository.delete(id);
    }
}
