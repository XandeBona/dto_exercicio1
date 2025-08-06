package com.escola.serie.dtos;

import com.escola.serie.entities.Professor;

import java.util.Date;

public class ProfessorResponseDTO {
    private Integer id;
    private String nome;
    private Date dataNascimento;

    public ProfessorResponseDTO(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.dataNascimento = professor.getDataNascimento();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
}

