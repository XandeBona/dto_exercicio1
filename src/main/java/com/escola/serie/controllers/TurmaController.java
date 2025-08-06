package com.escola.serie.controllers;

import com.escola.serie.dtos.TurmaRequestDTO;
import com.escola.serie.dtos.TurmaResponseDTO;
import com.escola.serie.entities.Turma;
import com.escola.serie.repositories.TurmaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
    private final TurmaRepository turmaRepository;

    public TurmaController(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    @GetMapping
    public List<Turma> listarTurmas() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public TurmaResponseDTO buscarTurmaPorId(@PathVariable Integer id) {
        Turma turma = turmaRepository.findById(id).orElseThrow();
        return new TurmaResponseDTO(turma);
    }

    @PostMapping
    public TurmaResponseDTO adicionarTurma(@RequestBody TurmaRequestDTO request) {
        Turma novaTurma = new Turma();
        novaTurma.setNomeTurma(request.getNomeTurma());

        turmaRepository.save(novaTurma);

        return new TurmaResponseDTO(novaTurma);
    }

    @PutMapping("/{id}")
    public TurmaResponseDTO atualizarTurma(@PathVariable Integer id, @RequestBody TurmaRequestDTO request) {
        Turma turmaExistente = turmaRepository.findById(id).orElseThrow();
        turmaExistente.setNomeTurma(request.getNomeTurma());

        turmaRepository.save(turmaExistente);

        return new TurmaResponseDTO(turmaExistente);
    }

    @DeleteMapping("/{id}")
    public TurmaResponseDTO deletarTurma(@PathVariable Integer id) {
        Turma turma = turmaRepository.findById(id).orElseThrow();

        turmaRepository.delete(turma);

        return new TurmaResponseDTO(turma);
    }
}