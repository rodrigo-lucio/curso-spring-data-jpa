package br.com.alura.cursospringdatajpa.service.impl;

import static org.apache.logging.log4j.util.Strings.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.cursospringdatajpa.model.Funcionario;
import br.com.alura.cursospringdatajpa.repository.FuncionarioRepository;
import br.com.alura.cursospringdatajpa.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public Funcionario salvar(Funcionario Funcionario) {
		return repository.save(Funcionario);
	}	
	
	public Page<Funcionario> listarPaginado(Pageable pageable, String nome) {
		if (isEmpty(nome)) {
			return repository.findAll(pageable);
		}
		Page<Funcionario> funcionarios = repository.findByNomeContainingIgnoreCase(pageable, nome);
		return funcionarios;
	}

	public Funcionario buscarPorId(Long id) {
		return repository.findById(id)
					     .orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public void deletarPorId(Long id) {
		repository.deleteById(id);
	}
	
}
