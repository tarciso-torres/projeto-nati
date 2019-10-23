package com.nati.projeto.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends EntidadeComUUID {

	@NotBlank(message = "professor-1")
	private String nome;
	
	private String matricula;

	@Email(message = "professor-2")
	@NotBlank(message = "professor-3")
	private String email;

	@CPF(message = "professor-4")
	@NotBlank(message = "professor-5")
	@Size(max = 11, min = 11, message = "professor-6")
	private String cpf;

	@NotBlank(message = "professor-7")
	@Column(name = "anoadmissao")
	private String anoAdmissao;

	@NotBlank(message = "professor-8")
	private String sexo;

	@Embedded
	private Telefone telefone;

	@Embedded
	private Endereco endereco;

}
