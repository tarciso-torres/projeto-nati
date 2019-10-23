package com.nati.projeto.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Telefone {

	@NotNull(message = "telefone-1")
	@Column(name = "celnumero")
	private String celNumero;

	@Column(name = "resnumero")
	private String resNumero;

	@Column(name = "comnumero")
	private String comNumero;

}
