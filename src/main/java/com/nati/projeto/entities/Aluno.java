package com.nati.projeto.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@NotBlank(message = "aluno-1")
	@Column(name = "semestreadmissao")
	private String semestreAdmissao;
	
	@NotNull(message =  "aluno-2")
	private AlunoStatus status;
	
	@Embedded
	private DadosPessoais dadosPessoais;
	
	@Embedded
	private Telefone telefone;
	
	@Embedded
	private Endereco endereco;

}
