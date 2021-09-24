package br.com.alura.cursospringdatajpa.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.alura.cursospringdatajpa.model.Cargo;

public interface CargoService {

	Cargo salvar(Cargo cargo);
	Page<Cargo> listarPaginado(Pageable pageable, String descricao);
	Cargo buscarPorId(Long id);
	void deletarPorId(Long id);
}