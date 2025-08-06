package com.escola.serie.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeTurma;
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Aluno> alunos = new ArrayList<>();
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProfessorTurma> professorTurmas = new ArrayList<>();

    public Turma() {

    }

    public Turma(Integer id, String nomeTurma, List<Aluno> alunos, List<ProfessorTurma> professorTurmas) {
        this.id = id;
        this.nomeTurma = nomeTurma;
        this.alunos = alunos;
        this.professorTurmas = professorTurmas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<ProfessorTurma> getProfessorTurmas() {
        return professorTurmas;
    }

    public void setProfessorTurmas(List<ProfessorTurma> professorTurmas) {
        this.professorTurmas = professorTurmas;
    }
}
