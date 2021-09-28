package br.com.alura.cursospringdatajpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.alura.cursospringdatajpa.model.Unidade;

public interface UnidadeService {

	Unidade salvar(Unidade unidade);
	Page<Unidade> listarPaginado(Pageable pageable, String descricao);
	Unidade buscarPorId(Long id);
	void deletarPorId(Long id);
}