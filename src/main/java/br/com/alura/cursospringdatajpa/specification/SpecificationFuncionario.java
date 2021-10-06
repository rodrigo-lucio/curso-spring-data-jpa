package br.com.alura.cursospringdatajpa.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.cursospringdatajpa.model.Funcionario;

public class SpecificationFuncionario {

	public static Specification<Funcionario> nome(String nome) {
		return (root, criteriaQuery, criteriaBuilder) -> 
			criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
	
}
