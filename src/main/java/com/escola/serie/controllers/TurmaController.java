package com.escola.serie.controllers;

import com.escola.serie.entities.Turma;
import com.escola.serie.repositories.TurmaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    private final TurmaRepository turmaRespository;

    public TurmaController(TurmaRepository turmaRespository) {
        this.turmaRespository = turmaRespository;
    }

    @GetMapping
    public List<Turma> listarTurmas() {
        return turmaRespository.findAll();
    }
}
