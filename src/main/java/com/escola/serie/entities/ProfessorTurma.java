package com.escola.serie.entities;

import jakarta.persistence.*;

@Entity
public class ProfessorTurma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "id_professor")
    private Professor professor;
    @ManyToOne()
    @JoinColumn(name = "id_turma")
    private Turma turma;

    public ProfessorTurma() {

    }

    public ProfessorTurma(Integer id, Professor professor, Turma turma) {
        this.id = id;
        this.professor = professor;
        this.turma = turma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
