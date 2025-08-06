package com.escola.serie.dtos;

import com.escola.serie.entities.Turma;

public class TurmaResponseDTO {
    private Integer id;
    private String nomeTurma;

    public TurmaResponseDTO() {}

    public TurmaResponseDTO(Turma turma) {
        this.id = turma.getId();
        this.nomeTurma = turma.getNomeTurma();
    }

    public Integer getId() {
        return id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }
}
