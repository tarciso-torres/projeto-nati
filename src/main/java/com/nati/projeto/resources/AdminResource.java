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

import com.nati.projeto.entities.Admin;
import com.nati.projeto.service.AdminService;

@RestController
@RequestMapping(value = "/admins")
public class AdminResource {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public ResponseEntity<List<Admin>> findAll(){
		List<Admin> admins = adminService.findAll();
		return ResponseEntity.ok().body(admins);
	}
	
	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<Admin> findByEmail(@PathVariable String email){
		Admin admin = adminService.findByEmail(email);
		return ResponseEntity.ok().body(admin);
	}
	
	@GetMapping("/findByCpf/{cpf}")
	public ResponseEntity<Admin> findByCpf(@PathVariable String cpf){
		Admin admin = adminService.findByCpf(cpf);
		return ResponseEntity.ok().body(admin);
	}
	
	@GetMapping(value = "/findByMatricula/{matricula}")
	public ResponseEntity<Admin> findByMatricula(@PathVariable String matricula){
		Admin admin = adminService.findByMatricula(matricula);
		return ResponseEntity.ok().body(admin);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Admin> findById(@PathVariable UUID id) {
		Admin admin = adminService.findById(id);
		return ResponseEntity.ok().body(admin);
	}
	
	@PostMapping
	public ResponseEntity<Admin> save(@Valid @RequestBody Admin entity){
		Admin admin = adminService.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(admin);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Admin> update(@PathVariable UUID id, @Valid @RequestBody Admin admin){
		Admin adminAtualizado = adminService.update(id, admin);
		return ResponseEntity.ok().body(adminAtualizado);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable UUID id) {
		adminService.delete(id);
	}

}
