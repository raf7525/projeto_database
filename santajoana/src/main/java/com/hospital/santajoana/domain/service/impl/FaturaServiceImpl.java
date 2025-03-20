package com.hospital.santajoana.domain.service.impl;

import org.springframework.stereotype.Service;

import com.hospital.santajoana.domain.entity.Fatura;
import com.hospital.santajoana.domain.repository.FaturaRepository;
import com.hospital.santajoana.domain.service.FaturaService;

@Service
public class FaturaServiceImpl extends BaseServiceImpl<Fatura, Integer> implements FaturaService {
    
    private final FaturaRepository faturaRepository;
    
    public FaturaServiceImpl(FaturaRepository faturaRepository) {
        super(faturaRepository);
        this.faturaRepository = faturaRepository;
    }
    
    @Override
    public Fatura save(Fatura fatura) {
        return faturaRepository.save(fatura);
    }
    
    @Override
    public Fatura findById(Integer id) {
        return faturaRepository.findById(id);
    }
    
    @Override
    public void delete(Integer id) {
        faturaRepository.delete(id);
    }
}
