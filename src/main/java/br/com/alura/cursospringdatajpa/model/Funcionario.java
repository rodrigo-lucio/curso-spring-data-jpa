package br.com.alura.cursospringdatajpa.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "funcionarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Size(min = 11, max = 11)
	private String cpf;
	
	@NotNull
	private Double salario;
	
	@NotNull
	private LocalDate dataContratacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cargo_id")	
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name = "unidade_id")	
	private Unidade unidade;
	
}
