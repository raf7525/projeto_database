package com.hospital.santajoana.domain.service.impl;

import org.springframework.stereotype.Service;

import com.hospital.santajoana.domain.entity.Enfermeiro;
import com.hospital.santajoana.domain.repository.EnfermeiroRepository;
import com.hospital.santajoana.domain.service.EnfermeiroService;

@Service
public class EnfermeiroServiceImpl extends BaseServiceImpl<Enfermeiro, String> implements EnfermeiroService {
    
    private final EnfermeiroRepository enfermeiroRepository;
    
    public EnfermeiroServiceImpl(EnfermeiroRepository enfermeiroRepository) {
        super(enfermeiroRepository);
        this.enfermeiroRepository = enfermeiroRepository;
    }
    
    @Override
    public Enfermeiro save(Enfermeiro enfermeiro) {
        return enfermeiroRepository.save(enfermeiro);
    }
    
    @Override
    public Enfermeiro findById(String cre) {
        return enfermeiroRepository.findById(cre);
    }
    
    @Override
    public void delete(String cre) {
        enfermeiroRepository.delete(cre);
    }
}
