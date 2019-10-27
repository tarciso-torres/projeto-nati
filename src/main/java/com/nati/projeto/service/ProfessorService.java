package com.nati.projeto.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nati.projeto.entities.Professor;
import com.nati.projeto.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repository;

	public List<Professor> findAll() {
		List<Professor> professors = repository.findAll();
		return professors;
	}

	public Professor findById(UUID id) {
		Optional<Professor> professor = repository.findById(id);

		return professor.get();
	}

	public Professor findByCpf(String cpf) {
		Professor professor = repository.findByDadosPessoaisCpf(cpf);
		return professor;
	}

	public Professor findByEmail(String email) {
		Professor professor = repository.findByUsuarioEmail(email);
		return professor;
	}

	public Professor save(Professor entity) {

		return repository.save(entity);
	}

	public void delete(UUID id) {
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		repository.deleteById(id);
	}

	public Professor update(UUID id, Professor professor) {
		Optional<Professor> professorSalvo = repository.findById(id);
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(professor, professorSalvo.get(), "id");
		return repository.save(professorSalvo.get());
	}

	public Professor findByMatricula(String matricula) {
		return repository.findByDadosPessoaisMatricula(matricula);
	}
}
