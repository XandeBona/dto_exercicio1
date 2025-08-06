package com.escola.serie.repositories;

import com.escola.serie.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByTurmaId(Integer idTurma);
}
