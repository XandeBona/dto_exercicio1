package com.escola.serie.controllers;

import com.escola.serie.dtos.ProfessorTurmaRequestDTO;
import com.escola.serie.dtos.ProfessorTurmaResponseDTO;
import com.escola.serie.entities.Professor;
import com.escola.serie.entities.ProfessorTurma;
import com.escola.serie.entities.Turma;
import com.escola.serie.repositories.ProfessorRepository;
import com.escola.serie.repositories.ProfessorTurmaRepository;
import com.escola.serie.repositories.TurmaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor-turmas")
public class ProfessorTurmaController {

    private final ProfessorTurmaRepository professorTurmaRepository;
    private final ProfessorRepository professorRepository;
    private final TurmaRepository turmaRepository;

    public ProfessorTurmaController(
            ProfessorTurmaRepository professorTurmaRepository,
            ProfessorRepository professorRepository,
            TurmaRepository turmaRepository
    ) {
        this.professorTurmaRepository = professorTurmaRepository;
        this.professorRepository = professorRepository;
        this.turmaRepository = turmaRepository;
    }

    @GetMapping
    public List<ProfessorTurma> listarProfessorturma() {
        return professorTurmaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProfessorTurmaResponseDTO buscarPorId(@PathVariable Integer id) {
        ProfessorTurma professorTurma = professorTurmaRepository.findById(id).orElseThrow();
        return new ProfessorTurmaResponseDTO(professorTurma);
    }

    @PostMapping
    public ProfessorTurmaResponseDTO adicionarProfessorTurma(@RequestBody ProfessorTurmaRequestDTO request) {
        Professor professor = professorRepository.findById(request.getIdProfessor()).orElseThrow();
        Turma turma = turmaRepository.findById(request.getIdTurma()).orElseThrow();

        ProfessorTurma novo = new ProfessorTurma();
        novo.setProfessor(professor);
        novo.setTurma(turma);

        professorTurmaRepository.save(novo);

        return new ProfessorTurmaResponseDTO(novo);
    }

    @PutMapping("/{id}")
    public ProfessorTurmaResponseDTO atualizarProfessorTurma(@PathVariable Integer id, @RequestBody ProfessorTurmaRequestDTO request) {
        ProfessorTurma professorTurma = professorTurmaRepository.findById(id).orElseThrow();

        Professor professor = professorRepository.findById(request.getIdProfessor()).orElseThrow();
        Turma turma = turmaRepository.findById(request.getIdTurma()).orElseThrow();

        professorTurma.setProfessor(professor);
        professorTurma.setTurma(turma);

        professorTurmaRepository.save(professorTurma);

        return new ProfessorTurmaResponseDTO(professorTurma);
    }

    @DeleteMapping("/{id}")
    public ProfessorTurmaResponseDTO removerProfessorTurma(@PathVariable Integer id) {
        ProfessorTurma professorTurma = professorTurmaRepository.findById(id).orElseThrow();
        professorTurmaRepository.delete(professorTurma);
        return new ProfessorTurmaResponseDTO(professorTurma);
    }
}