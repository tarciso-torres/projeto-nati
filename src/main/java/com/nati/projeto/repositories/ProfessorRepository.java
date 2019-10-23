package com.nati.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nati.projeto.entities.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, UUID>{
	
	Professor findByMatricula(String name);
	
	Professor findByCpf(String cpf);
	
	Professor findByEmail(String email);

}
