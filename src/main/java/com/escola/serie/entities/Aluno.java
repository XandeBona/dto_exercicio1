package com.escola.serie.entities;

import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String matricula;
    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    public Aluno() {
    }

    public Aluno(Integer id, String nome, String matricula, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.turma = turma;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}

