package com.nati.projeto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.nati.projeto.entities.enums.AreaDoConhecimento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_curso")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Curso extends EntidadeComUUID{
	
	private String nome;
	
	private String descricao;
	
	@Column(name = "areadoconhecimento")
	private AreaDoConhecimento areaConhecimento;

}
