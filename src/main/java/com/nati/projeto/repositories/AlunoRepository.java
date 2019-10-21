package com.nati.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nati.projeto.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, UUID>{

}
