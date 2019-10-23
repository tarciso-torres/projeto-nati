package com.nati.projeto.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.nati.projeto.entities.enums.AlunoStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_aluno")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Aluno extends EntidadeComUUID{
	
	@NotBlank(message = "aluno-1")
	private String nome;
	private String matricula;
	
	@Email(message = "aluno-2") @NotBlank(message = "aluno-3")
	private String email;
	
	@CPF(message = "aluno-4") @NotBlank(message = "aluno-5") @Size(max = 11, min = 11, message = "aluno-6")
	private String cpf;
	
	@NotBlank(message = "aluno-7")
	@Column(name = "anoadmissao")
	private String anoAdmissao;
	
	@NotBlank(message = "aluno-8")
	@Column(name = "semestreadmissao")
	private String semestreAdmissao;
	
	@NotBlank(message = "aluno-9")
	private String sexo;
	
	@NotNull(message =  "aluno-10")
	private AlunoStatus status;
	
	@Embedded
	private Telefone telefone;
	
	@Embedded
	private Endereco endereco;

}
