package com.escola.serie.controllers;

import com.escola.serie.dtos.ProfessorRequestDTO;
import com.escola.serie.dtos.ProfessorResponseDTO;
import com.escola.serie.entities.Professor;
import com.escola.serie.repositories.ProfessorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorRepository professorRepository;

    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @GetMapping
    public List<Professor> listarProfessor() {
        return professorRepository.findAll();
    }

    @PostMapping
    public ProfessorResponseDTO adicionarProfessor(@RequestBody ProfessorRequestDTO request) {
        Professor professor = new Professor();

        professor.setNome(request.getNome());
        professor.setDataNascimento(request.getDataNascimento());

        professorRepository.save(professor);

        return new ProfessorResponseDTO(professor);
    }

    @PutMapping("/{idProfessor}")
    public ProfessorResponseDTO editarProfessor(@PathVariable Integer idProfessor, @RequestBody ProfessorRequestDTO request) {
        Professor professor = professorRepository.findById(idProfessor).orElseThrow();

        professor.setNome(request.getNome());
        professor.setDataNascimento(request.getDataNascimento());

        professorRepository.save(professor);

        return new ProfessorResponseDTO(professor);
    }

    @DeleteMapping("/{idProfessor}")
    public ProfessorResponseDTO removerProfessor(@PathVariable Integer idProfessor) {
        Professor professor = professorRepository.findById(idProfessor).orElseThrow();

        professorRepository.delete(professor);

        return new ProfessorResponseDTO(professor);
    }
}
