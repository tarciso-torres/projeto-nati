package com.nati.projeto.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nati.projeto.entities.Aluno;
import com.nati.projeto.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	public List<Aluno> findAll() {
		List<Aluno> alunos = repository.findAll();
		return alunos;
	}

	public Aluno findById(UUID id) {
		Optional<Aluno> aluno = repository.findById(id);

		return aluno.get();
	}

	public Aluno findByCpf(String cpf) {
		Aluno aluno = repository.findByDadosPessoaisCpf(cpf);
		return aluno;
	}

	public Aluno findByEmail(String email) {
		Aluno aluno = repository.findByDadosPessoaisEmail(email);
		return aluno;
	}

	public Aluno save(Aluno entity) {

		return repository.save(entity);
	}

	public void delete(UUID id) {
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		repository.deleteById(id);
	}

	public Aluno update(UUID id, Aluno aluno) {
		Optional<Aluno> alunoSalvo = repository.findById(id);
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(aluno, alunoSalvo.get(), "id");
		return repository.save(alunoSalvo.get());
	}

	public Aluno findByMatricula(String matricula) {
		return repository.findByDadosPessoaisMatricula(matricula);
	}
}
