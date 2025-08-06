package com.escola.serie.controllers;

import com.escola.serie.entities.Aluno;
import com.escola.serie.entities.Turma;
import org.springframework.web.bind.annotation.*;
import com.escola.serie.repositories.AlunoRepository;
import com.escola.serie.repositories.TurmaRepository;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public AlunoController(AlunoRepository alunoRepository, TurmaRepository turmaRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    @GetMapping
    public List<Aluno> listarAluno() {
        return alunoRepository.findAll();
    }

    @PostMapping
    public Aluno criarAluno (@RequestBody Aluno aluno, @PathVariable Integer idTurma) {
        Turma turma = turmaRepository.findById(idTurma).orElseThrow();

        aluno.setTurma(turma);

        this.alunoRepository.save(aluno);
        return aluno;
    }
}
