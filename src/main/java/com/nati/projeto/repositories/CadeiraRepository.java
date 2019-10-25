package com.nati.projeto.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nati.projeto.entities.Cadeira;

@Repository
public interface CadeiraRepository extends JpaRepository<Cadeira, UUID>{
	
	Cadeira findByNome(String nome);

}
