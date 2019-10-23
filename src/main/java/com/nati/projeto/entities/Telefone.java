package com.nati.projeto.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Telefone {

	@NotBlank(message = "telefone-1") @Size(min = 11, max = 11, message = "telefone-2")
	@Column(name = "celnumero")
	private String celNumero;

	@Size(min = 11, max = 11, message = "telefone-3")
	@Column(name = "resnumero")
	private String resNumero;

	@Size(min = 11, max = 11, message = "telefone-4")
	@Column(name = "comnumero")
	private String comNumero;

}
