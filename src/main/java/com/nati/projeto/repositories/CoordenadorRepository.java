package com.nati.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nati.projeto.entities.Coordenador;

@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, UUID>{
	
	Coordenador findByDadosPessoaisMatricula(String matricula);
	
	Coordenador findByDadosPessoaisCpf(String cpf);
	
	Coordenador findByUsuarioEmail(String email);

}
