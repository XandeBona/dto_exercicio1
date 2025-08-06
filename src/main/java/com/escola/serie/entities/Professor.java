package com.escola.serie.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Date dataNascimento;
    private String disciplina;
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProfessorTurma> professorTurmas = new ArrayList<>();

    public Professor() {

    }

    public Professor(Integer id, String nome, Date dataNascimento, String disciplina, List<ProfessorTurma> professorTurmas) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.disciplina = disciplina;
        this.professorTurmas = professorTurmas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<ProfessorTurma> getProfessorTurmas() {
        return professorTurmas;
    }

    public void setProfessorTurmas(List<ProfessorTurma> professorTurmas) {
        this.professorTurmas = professorTurmas;
    }
}

