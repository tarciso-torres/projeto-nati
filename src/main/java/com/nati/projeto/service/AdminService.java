package com.nati.projeto.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nati.projeto.entities.Admin;
import com.nati.projeto.repositories.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public List<Admin> findAll() {
		List<Admin> admins = repository.findAll();
		return admins;
	}

	public Admin findById(UUID id) {
		Optional<Admin> admin = repository.findById(id);

		return admin.get();
	}

	public Admin findByCpf(String cpf) {
		Admin admin = repository.findByDadosPessoaisCpf(cpf);
		return admin;
	}

	public Admin findByEmail(String email) {
		Admin admin = repository.findByUsuarioEmail(email);
		return admin;
	}

	public Admin save(Admin entity) {

		return repository.save(entity);
	}

	public void delete(UUID id) {
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		repository.deleteById(id);
	}

	public Admin update(UUID id, Admin admin) {
		Optional<Admin> adminSalvo = repository.findById(id);
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(admin, adminSalvo.get(), "id");
		return repository.save(adminSalvo.get());
	}

	public Admin findByMatricula(String matricula) {
		return repository.findByDadosPessoaisMatricula(matricula);
	}
}
