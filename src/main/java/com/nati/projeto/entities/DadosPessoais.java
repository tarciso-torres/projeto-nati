package com.nati.projeto.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DadosPessoais {

	@NotBlank(message = "dadosPessoais-1")
	private String nome;

	private String matricula;

	@CPF(message = "dadosPessoais-2")
	@NotBlank(message = "dadosPessoais-3")
	@Size(max = 11, min = 11, message = "dadosPessoais-4")
	private String cpf;

	@NotBlank(message = "dadosPessoais-5")
	@Column(name = "anoadmissao")
	private String anoAdmissao;

	@NotNull(message = "dadosPessoais-6")
	@Size(max = 1, min = 1, message = "dadosPessoais-7")
	private String sexo;

}
