package com.escola.serie.controllers;

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
    public Professor criarProfessor(@RequestBody Professor professor) {
        this.professorRepository.save(professor);
        return professor;
    }

    @PutMapping("/{idProfessor}")
    public Professor editarProfessor(@PathVariable Integer idProfessor, @RequestBody Professor professor) {
        Professor editar = this.professorRepository.findById(idProfessor).get();

        editar.setNome(professor.getNome());
        editar.setDisciplina(professor.getDisciplina());
        editar.setDataNascimento(professor.getDataNascimento());

        this.professorRepository.save(editar);

        return editar;
    }

    @DeleteMapping("/{idProfessor}")
    public Professor removerProfessor(@PathVariable Integer idProfessor) {
        Professor professor = this.professorRepository.findById(idProfessor).get();

        this.professorRepository.deleteById(idProfessor);

        return professor;
    }
}
