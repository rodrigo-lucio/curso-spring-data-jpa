package br.com.alura.cursospringdatajpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.alura.cursospringdatajpa.model.Funcionario;
import br.com.alura.cursospringdatajpa.model.FuncionarioProjecao;
import br.com.alura.cursospringdatajpa.specification.SpecificationFuncionario;

public interface FuncionarioService {

	Funcionario salvar(Funcionario funcionario);
	Page<Funcionario> listarPaginado(Pageable pageable, String descricao);
	Funcionario buscarPorId(Long id);
	void deletarPorId(Long id);
	List<FuncionarioProjecao> buscarPorProjecao();
	Page<Funcionario> listarPaginadoSpecification(Pageable pageable, String descricao);
}