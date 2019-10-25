package com.nati.projeto.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nati.projeto.entities.Cadeira;
import com.nati.projeto.repositories.CadeiraRepository;

@Service
public class CadeiraService {

	@Autowired
	private CadeiraRepository repository;

	public List<Cadeira> findAll() {
		List<Cadeira> cadeiras = repository.findAll();
		return cadeiras;
	}

	public Cadeira findById(UUID id) {
		Optional<Cadeira> cadeira = repository.findById(id);

		return cadeira.get();
	}

	public Cadeira findByNome(String nome) {
		Cadeira cadeiras = repository.findByNome(nome);
		return cadeiras;
	}

	public Cadeira save(Cadeira entity) {

		return repository.save(entity);
	}

	public void delete(UUID id) {
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		repository.deleteById(id);
	}

	public Cadeira update(UUID id, Cadeira cadeira) {
		Optional<Cadeira> cadeiraSalvo = repository.findById(id);
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(cadeira, cadeiraSalvo.get(), "id");
		return repository.save(cadeiraSalvo.get());
	}
}
