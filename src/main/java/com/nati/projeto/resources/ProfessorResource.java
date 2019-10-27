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

import com.nati.projeto.entities.Professor;
import com.nati.projeto.service.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping
	public ResponseEntity<List<Professor>> findAll(){
		List<Professor> professors = professorService.findAll();
		return ResponseEntity.ok().body(professors);
	}
	
	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<Professor> findByUsuario(@PathVariable String email){
		Professor professor = professorService.findByEmail(email);
		return ResponseEntity.ok().body(professor);
	}
	
	@GetMapping("/findByCpf/{cpf}")
	public ResponseEntity<Professor> findByCpf(@PathVariable String cpf){
		Professor professor = professorService.findByCpf(cpf);
		return ResponseEntity.ok().body(professor);
	}
	
	@GetMapping(value = "/findByMatricula/{matricula}")
	public ResponseEntity<Professor> findByMatricula(@PathVariable String matricula){
		Professor professor = professorService.findByMatricula(matricula);
		return ResponseEntity.ok().body(professor);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Professor> findById(@PathVariable UUID id) {
		Professor professor = professorService.findById(id);
		return ResponseEntity.ok().body(professor);
	}
	
	@PostMapping
	public ResponseEntity<Professor> save(@Valid @RequestBody Professor entity){
		Professor professor = professorService.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(professor);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Professor> update(@PathVariable UUID id, @Valid @RequestBody Professor professor){
		Professor professorAtualizado = professorService.update(id, professor);
		return ResponseEntity.ok().body(professorAtualizado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		professorService.delete(id);
	}

}
