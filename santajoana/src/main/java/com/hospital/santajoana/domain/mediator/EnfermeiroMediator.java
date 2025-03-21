package com.hospital.santajoana.domain.mediator;

import org.springframework.stereotype.Service;

import com.hospital.santajoana.domain.entity.Enfermeiro;
import com.hospital.santajoana.domain.repository.EnfermeiroRepository;

@Service
public class EnfermeiroMediator extends BaseMediator<Enfermeiro> {
    
    private final EnfermeiroRepository enfermeiroRepository;
    
    public EnfermeiroMediator(EnfermeiroRepository enfermeiroRepository) {
        super(enfermeiroRepository);
        this.enfermeiroRepository = enfermeiroRepository;
    }
    
    public Enfermeiro save(Enfermeiro enfermeiro) {
        return enfermeiroRepository.save(enfermeiro);
    }

    public void delete(Enfermeiro entity) {
        enfermeiroRepository.deleteById(entity.getId());
    }

    public Enfermeiro update(Enfermeiro enfermeiro) {
        return enfermeiroRepository.update(enfermeiro);
    }
    
}
