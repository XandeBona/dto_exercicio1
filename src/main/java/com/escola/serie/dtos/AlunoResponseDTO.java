package com.escola.serie.dtos;

import com.escola.serie.entities.Aluno;

public class AlunoResponseDTO {
    private Integer id;
    private String nome;
    private String matricula;
    private TurmaResponseDTO turma;

    public AlunoResponseDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.matricula = aluno.getMatricula();
        this.turma = new TurmaResponseDTO(aluno.getTurma());
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public TurmaResponseDTO getIdTurma() {
        return turma;
    }
}
