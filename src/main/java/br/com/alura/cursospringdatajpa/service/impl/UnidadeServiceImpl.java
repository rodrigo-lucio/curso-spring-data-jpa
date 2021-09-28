package br.com.alura.cursospringdatajpa.service.impl;

import static org.apache.logging.log4j.util.Strings.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.cursospringdatajpa.model.Unidade;
import br.com.alura.cursospringdatajpa.repository.UnidadeRepository;
import br.com.alura.cursospringdatajpa.service.UnidadeService;

@Service
public class UnidadeServiceImpl implements UnidadeService {

	@Autowired
	private UnidadeRepository repository;
	
	public Unidade salvar(Unidade unidade) {
		return repository.save(unidade);
	}	
	
	public Page<Unidade> listarPaginado(Pageable pageable, String descricao) {
		if (isEmpty(descricao)) {
			return repository.findAll(pageable);
		}
		Page<Unidade> unidades = repository.findByDescricaoContainingIgnoreCase(pageable, descricao);
		return unidades;
	}

	public Unidade buscarPorId(Long id) {
		return repository.findById(id)
					     .orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public void deletarPorId(Long id) {
		repository.deleteById(id);
	}
	
}
