package com.nati.projeto.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_aluno")
@Data
public class Aluno extends EntidadeComUUID{
	
	private String nome;
	private String matricula;
	private String email;

}
