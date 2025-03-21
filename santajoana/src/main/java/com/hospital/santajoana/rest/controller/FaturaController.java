package com.hospital.santajoana.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.santajoana.domain.entity.Fatura;
import com.hospital.santajoana.domain.mediator.FaturaMediator;

@RestController
@RequestMapping("/api/faturas")
public class FaturaController extends BaseController<Fatura> {

    public FaturaController(FaturaMediator faturaMediator) {
        super(faturaMediator);
    }
}
