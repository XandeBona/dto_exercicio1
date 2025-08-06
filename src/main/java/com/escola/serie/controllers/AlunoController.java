package com.escola.serie.controllers;

import com.escola.serie.dtos.AlunoRequestDTO;
import com.escola.serie.dtos.AlunoResponseDTO;
import com.escola.serie.entities.Aluno;
import com.escola.serie.entities.Professor;
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

    @GetMapping("/{idAluno}")
    public AlunoResponseDTO buscarAlunoPorId(@PathVariable Integer idAluno) {
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();

        return new AlunoResponseDTO(aluno);
    }

    @PostMapping
    public AlunoResponseDTO adicionarAluno(@RequestBody AlunoRequestDTO request) {

        Turma turma = turmaRepository.findById(request.getIdTurma()).orElseThrow();

        Aluno novoAluno = new Aluno();
        novoAluno.setNome(request.getNome());
        novoAluno.setMatricula(request.getMatricula());
        novoAluno.setTurma(turma);

        alunoRepository.save(novoAluno);

        return new AlunoResponseDTO(novoAluno);
    }

    @PutMapping("/{idAluno}")
    public AlunoResponseDTO atualizarAluno(@PathVariable Integer idAluno, @RequestBody AlunoRequestDTO request) {
        Aluno editaAluno = alunoRepository.findById(idAluno).orElseThrow();

        Turma turma = turmaRepository.findById(request.getIdTurma()).orElseThrow();

        editaAluno.setNome(request.getNome());
        editaAluno.setMatricula(request.getMatricula());
        editaAluno.setTurma(turma);

        alunoRepository.save(editaAluno);

        return new AlunoResponseDTO(editaAluno);
    }

    @DeleteMapping("/{idAluno}")
    public AlunoResponseDTO removerAluno(@PathVariable Integer idAluno) {
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();

        alunoRepository.deleteById(idAluno);

        return new AlunoResponseDTO(aluno);
    }
}
