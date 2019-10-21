package com.nati.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nati.projeto.entities.Aluno;
import com.nati.projeto.repositories.AlunoRepository;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> alunos = alunoRepository.findAll();
		return ResponseEntity.ok().body(alunos);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> save(@RequestBody Aluno entity){
		Aluno aluno = alunoRepository.save(entity);
		HttpStatus status = HttpStatus.CREATED;
		return ResponseEntity.status(status).body(aluno);
	}

}
