package com.nati.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nati.projeto.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID>{
	
	Aluno findByMatricula(String name);
	
	Aluno findByCpf(String cpf);
	
	Aluno findByEmail(String email);

}
