package com.hospital.santajoana.domain.mediator;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospital.santajoana.domain.entity.Fatura;
import com.hospital.santajoana.domain.repository.FaturaRepository;

@Service
public class FaturaMediator extends BaseMediator<Fatura> {
    
    private final FaturaRepository faturaRepository;
    
    public FaturaMediator(FaturaRepository faturaRepository) {
        super(faturaRepository);
        this.faturaRepository = faturaRepository;
    }
    
    public Fatura save(Fatura fatura) {
        return faturaRepository.save(fatura);
    }
    
    public void delete(Fatura entity) {
        faturaRepository.deleteById(entity.getId());
    }

    public Fatura update(Fatura entity) {
        return faturaRepository.update(entity);
    }

}
