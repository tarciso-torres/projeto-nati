package com.nati.projeto.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Endereco {
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	
	@Size(min = 8, max = 8, message = "endereco-1")
	private String cep;
	private String cidade;
	
	@Size(min = 2, max = 2, message = "endereco-2")
	private String estado;

}
