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

import com.nati.projeto.entities.Coordenador;
import com.nati.projeto.service.CoordenadorService;

@RestController
@RequestMapping(value = "/coordenadores")
public class CoordenadorResource {
	
	@Autowired
	private CoordenadorService coordenadorService;
	
	@GetMapping
	public ResponseEntity<List<Coordenador>> findAll(){
		List<Coordenador> coordenadors = coordenadorService.findAll();
		return ResponseEntity.ok().body(coordenadors);
	}
	
	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<Coordenador> findByNome(@PathVariable String email){
		Coordenador coordenador = coordenadorService.findByEmail(email);
		return ResponseEntity.ok().body(coordenador);
	}
	
	@GetMapping("/findByCpf/{cpf}")
	public ResponseEntity<Coordenador> findByCpf(@PathVariable String cpf){
		Coordenador coordenador = coordenadorService.findByCpf(cpf);
		return ResponseEntity.ok().body(coordenador);
	}
	
	@GetMapping(value = "/findByMatricula/{matricula}")
	public ResponseEntity<Coordenador> findByMatricula(@PathVariable String matricula){
		Coordenador coordenador = coordenadorService.findByMatricula(matricula);
		return ResponseEntity.ok().body(coordenador);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Coordenador> findById(@PathVariable UUID id) {
		Coordenador coordenador = coordenadorService.findById(id);
		return ResponseEntity.ok().body(coordenador);
	}
	
	@PostMapping
	public ResponseEntity<Coordenador> save(@Valid @RequestBody Coordenador entity){
		Coordenador coordenador = coordenadorService.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(coordenador);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Coordenador> update(@PathVariable UUID id, @Valid @RequestBody Coordenador coordenador){
		Coordenador coordenadorAtualizado = coordenadorService.update(id, coordenador);
		return ResponseEntity.ok().body(coordenadorAtualizado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		coordenadorService.delete(id);
	}

}
