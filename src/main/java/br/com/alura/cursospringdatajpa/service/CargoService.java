package br.com.alura.cursospringdatajpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.cursospringdatajpa.model.Cargo;
import br.com.alura.cursospringdatajpa.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;
	
	public Cargo criarCargo(Cargo cargo) {
		return repository.save(cargo);
	}	
	
}
