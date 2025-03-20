package com.hospital.santajoana.domain.service.impl;

import org.springframework.stereotype.Service;

import com.hospital.santajoana.domain.entity.Paciente;
import com.hospital.santajoana.domain.repository.PacienteRepository;
import com.hospital.santajoana.domain.service.PacienteService;

@Service
public class PacienteServiceImpl extends BaseServiceImpl<Paciente, Long> implements PacienteService {
    
    private final PacienteRepository pacienteRepository;
    
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        super(pacienteRepository);
        this.pacienteRepository = pacienteRepository;
    }
    
    @Override
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    
    @Override
    public Paciente findById(Long id) {
        return pacienteRepository.findById(id);
    }
    
    @Override
    public void delete(Long id) {
        pacienteRepository.delete(id);
    }
}
