package com.nati.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nati.projeto.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, UUID>{
	
	Curso findByNome(String nome);
}
