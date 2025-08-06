package com.escola.serie.dtos;

public class TurmaRequestDTO {
    private String nomeTurma;

    public TurmaRequestDTO() {}

    public TurmaRequestDTO(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
}
