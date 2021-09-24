package br.com.alura.cursospringdatajpa.service.impl;

import static org.apache.logging.log4j.util.Strings.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.cursospringdatajpa.model.Cargo;
import br.com.alura.cursospringdatajpa.repository.CargoRepository;
import br.com.alura.cursospringdatajpa.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoRepository repository;
	
	public Cargo salvar(Cargo cargo) {
		return repository.save(cargo);
	}	
	
	public Page<Cargo> listarPaginado(Pageable pageable, String descricao) {
		if (isEmpty(descricao)) {
			return repository.findAll(pageable);
		}
		Page<Cargo> cargos = repository.findByDescricaoContainingIgnoreCase(pageable, descricao);
		return cargos;
	}

	public Cargo buscarPorId(Long id) {
		return repository.findById(id)
					     .orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	public void deletarPorId(Long id) {
		repository.deleteById(id);
	}
	
}
