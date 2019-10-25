package com.nati.projeto.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cadeira")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Cadeira extends EntidadeComUUID{
	
	@NotBlank(message = "cadeira-1")
    private String nome;

	@NotNull(message = "cadeira-2")
    private Integer creditos;

	@NotBlank(message = "cadeira-3")
    private String ementa;

}
