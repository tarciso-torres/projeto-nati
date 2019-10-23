package com.nati.projeto.resources;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nati.projeto.entities.Aluno;
import com.nati.projeto.service.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		List<Aluno> alunos = alunoService.findAll();
		return ResponseEntity.ok().body(alunos);
	}
	
	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<Aluno> findByNome(@PathVariable String email){
		Aluno aluno = alunoService.findByEmail(email);
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping("/findByCpf/{cpf}")
	public ResponseEntity<Aluno> findByCpf(@PathVariable String cpf){
		Aluno aluno = alunoService.findByCpf(cpf);
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping(value = "/findByMatricula/{matricula}")
	public ResponseEntity<Aluno> findByMatricula(@PathVariable String matricula){
		Aluno aluno = alunoService.findByMatricula(matricula);
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable UUID id) {
		Aluno aluno = alunoService.findById(id);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> save(@Valid @RequestBody Aluno entity){
		Aluno aluno = alunoService.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> update(@PathVariable UUID id, @Valid @RequestBody Aluno aluno){
		Aluno alunoAtualizado = alunoService.update(id, aluno);
		return ResponseEntity.ok().body(alunoAtualizado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		alunoService.delete(id);
	}

}
