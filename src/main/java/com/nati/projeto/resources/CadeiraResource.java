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

import com.nati.projeto.entities.Cadeira;
import com.nati.projeto.service.CadeiraService;

@RestController
@RequestMapping(value = "/cadeiras")
public class CadeiraResource {

	@Autowired
	private CadeiraService cadeiraService;

	@GetMapping
	public ResponseEntity<List<Cadeira>> findAll() {
		List<Cadeira> cadeiras = cadeiraService.findAll();
		return ResponseEntity.ok().body(cadeiras);
	}

	@GetMapping("/findByNome/{nome}")
	public ResponseEntity<Cadeira> findByNome(@PathVariable String nome) {
		Cadeira cadeira = cadeiraService.findByNome(nome);
		return ResponseEntity.ok().body(cadeira);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cadeira> findById(@PathVariable UUID id) {
		Cadeira cadeira = cadeiraService.findById(id);
		return ResponseEntity.ok().body(cadeira);
	}

	@PostMapping
	public ResponseEntity<Cadeira> save(@Valid @RequestBody Cadeira entity) {
		Cadeira cadeira = cadeiraService.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(cadeira);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cadeira> update(@PathVariable UUID id, @Valid @RequestBody Cadeira cadeira) {
		Cadeira cadeiraAtualizado = cadeiraService.update(id, cadeira);
		return ResponseEntity.ok().body(cadeiraAtualizado);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		cadeiraService.delete(id);
	}

}
