package com.nati.projeto.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends EntidadeComUUID{
	
	@Email(message = "usuario-1") @NotBlank(message = "usuario-2")
	private String email;
	
	@NotBlank(message = "usuario-3")
	private String senha;

}
