package com.nati.projeto.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nati.projeto.entities.Coordenador;
import com.nati.projeto.repositories.CoordenadorRepository;

@Service
public class CoordenadorService {

	@Autowired
	private CoordenadorRepository repository;

	public List<Coordenador> findAll() {
		List<Coordenador> coordenadors = repository.findAll();
		return coordenadors;
	}

	public Coordenador findById(UUID id) {
		Optional<Coordenador> coordenador = repository.findById(id);

		return coordenador.get();
	}

	public Coordenador findByCpf(String cpf) {
		Coordenador coordenador = repository.findByDadosPessoaisCpf(cpf);
		return coordenador;
	}

	public Coordenador findByEmail(String email) {
		Coordenador coordenador = repository.findByDadosPessoaisEmail(email);
		return coordenador;
	}

	public Coordenador save(Coordenador entity) {

		return repository.save(entity);
	}

	public void delete(UUID id) {
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		repository.deleteById(id);
	}

	public Coordenador update(UUID id, Coordenador coordenador) {
		Optional<Coordenador> coordenadorSalvo = repository.findById(id);
		if (repository.existsById(id) == false) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(coordenador, coordenadorSalvo.get(), "id");
		return repository.save(coordenadorSalvo.get());
	}

	public Coordenador findByMatricula(String matricula) {
		return repository.findByDadosPessoaisMatricula(matricula);
	}
}
