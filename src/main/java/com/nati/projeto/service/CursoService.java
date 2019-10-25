package com.nati.projeto.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nati.projeto.entities.Curso;
import com.nati.projeto.repositories.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repository;

	public List<Curso> findAll() {
		List<Curso> cursos = repository.findAll();
		return cursos;
	}

	public Curso findById(UUID id) {
		Optional<Curso> curso = repository.findById(id);

		return curso.get();
	}

	public Curso findByNome(String nome) {
		Curso cursos = repository.findByNome(nome);
		return cursos;
	}

	public Curso save(Curso entity) {

		return repository.save(entity);
	}

	public void delete(UUID id) {
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		repository.deleteById(id);
	}

	public Curso update(UUID id, Curso curso) {
		Optional<Curso> cursoSalvo = repository.findById(id);
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(curso, cursoSalvo.get(), "id");
		return repository.save(cursoSalvo.get());
	}
}
