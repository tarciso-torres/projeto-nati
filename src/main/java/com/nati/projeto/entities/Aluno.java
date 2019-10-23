package com.nati.projeto.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.nati.projeto.entities.enums.AlunoStatus;

import lombok.Data;

@Entity
@Table(name = "tb_aluno")
@Data()
public class Aluno extends EntidadeComUUID{
	
	@NotBlank(message = "aluno-1")
	private String nome;
	private String matricula;
	
	@Email(message = "aluno-2") @NotBlank(message = "aluno-3")
	private String email;
	
	@CPF(message = "aluno-4") @NotBlank(message = "aluno-5")
	private String cpf;
	
	@NotBlank(message = "aluno-6")
	@Column(name = "anoadmissao")
	private String anoAdmissao;
	
	@NotBlank(message = "aluno-7")
	@Column(name = "semestreadmissao")
	private String semestreAdmissao;
	
	@NotBlank(message = "aluno-8")
	private String sexo;
	
	@NotNull(message =  "aluno-9")
	private AlunoStatus status;
	
	@Embedded
	
	private Telefone telefone;
	
	@Embedded
	private Endereco endereco;

}
