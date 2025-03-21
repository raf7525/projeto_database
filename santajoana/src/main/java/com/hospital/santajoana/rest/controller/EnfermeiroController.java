package com.hospital.santajoana.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.santajoana.domain.entity.Enfermeiro;
import com.hospital.santajoana.domain.mediator.EnfermeiroMediator;

@RestController
@RequestMapping("/api/enfermeiros")
public class EnfermeiroController extends BaseController<Enfermeiro> {

    public EnfermeiroController(EnfermeiroMediator enfermeiroMediator) {
        super(enfermeiroMediator);
    }
}
