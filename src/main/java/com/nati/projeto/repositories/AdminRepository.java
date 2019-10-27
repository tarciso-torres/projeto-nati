package com.nati.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nati.projeto.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID>{
	
	Admin findByDadosPessoaisMatricula(String name);
	
	Admin findByDadosPessoaisCpf(String cpf);
	
	Admin findByUsuarioEmail(String email);

}
