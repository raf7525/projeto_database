package com.hospital.santajoana.domain.mediator;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospital.santajoana.domain.entity.Paciente;
import com.hospital.santajoana.domain.repository.PacienteRepository;

@Service
public class PacienteMediator extends BaseMediator<Paciente>  {
    
    private final PacienteRepository pacienteRepository;
    
    public PacienteMediator(PacienteRepository pacienteRepository) {
        super(pacienteRepository);
        this.pacienteRepository = pacienteRepository;
    }
    
    public Paciente save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }
    
    public void delete(Paciente entity) {
        pacienteRepository.deleteById(entity.getId());
    }

    public Paciente update(Paciente paciente) {
        return pacienteRepository.update(paciente);
    }

}
