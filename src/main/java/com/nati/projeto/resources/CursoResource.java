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

import com.nati.projeto.entities.Curso;
import com.nati.projeto.service.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

	@Autowired
	private CursoService cursoService;

	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		List<Curso> cursos = cursoService.findAll();
		return ResponseEntity.ok().body(cursos);
	}

	@GetMapping("/findByNome/{nome}")
	public ResponseEntity<Curso> findByNome(@PathVariable String nome) {
		Curso curso = cursoService.findByNome(nome);
		return ResponseEntity.ok().body(curso);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> findById(@PathVariable UUID id) {
		Curso curso = cursoService.findById(id);
		return ResponseEntity.ok().body(curso);
	}

	@PostMapping
	public ResponseEntity<Curso> save(@Valid @RequestBody Curso entity) {
		Curso curso = cursoService.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(curso);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Curso> update(@PathVariable UUID id, @Valid @RequestBody Curso curso) {
		Curso cursoAtualizado = cursoService.update(id, curso);
		return ResponseEntity.ok().body(cursoAtualizado);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		cursoService.delete(id);
	}

}
