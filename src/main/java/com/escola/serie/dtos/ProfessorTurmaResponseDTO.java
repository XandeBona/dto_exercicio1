package com.escola.serie.dtos;

import com.escola.serie.entities.ProfessorTurma;

public class ProfessorTurmaResponseDTO {
    private Integer id;
    private String nomeProfessor;
    private String nomeTurma;

    public ProfessorTurmaResponseDTO(ProfessorTurma entity) {
        this.id = entity.getId();
        this.nomeProfessor = entity.getProfessor().getNome();
        this.nomeTurma = entity.getTurma().getNomeTurma();
    }

    public Integer getId() {
        return id;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }
}
