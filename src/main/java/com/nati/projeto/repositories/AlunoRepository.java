package com.nati.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nati.projeto.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID>{
	
	Aluno findByDadosPessoaisMatricula(String name);
	
	Aluno findByDadosPessoaisCpf(String cpf);
	
	Aluno findByUsuarioEmail(String email);

}
