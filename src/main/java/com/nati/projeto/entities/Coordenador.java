package com.nati.projeto.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_coordenador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coordenador extends EntidadeComUUID {
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@Embedded
	private DadosPessoais dadosPessoais;
	@Embedded
	private Telefone telefone;

	@Embedded
	private Endereco endereco;

}
