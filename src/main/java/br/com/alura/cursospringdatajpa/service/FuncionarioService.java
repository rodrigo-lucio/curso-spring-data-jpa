package br.com.alura.cursospringdatajpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.alura.cursospringdatajpa.model.Funcionario;

public interface FuncionarioService {

	Funcionario salvar(Funcionario funcionario);
	Page<Funcionario> listarPaginado(Pageable pageable, String descricao);
	Funcionario buscarPorId(Long id);
	void deletarPorId(Long id);
}