package com.escola.serie.dtos;

public class ProfessorTurmaRequestDTO {
    private Integer idProfessor;
    private Integer idTurma;

    public ProfessorTurmaRequestDTO() {}

    public ProfessorTurmaRequestDTO(Integer idProfessor, Integer idTurma) {
        this.idProfessor = idProfessor;
        this.idTurma = idTurma;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }
}