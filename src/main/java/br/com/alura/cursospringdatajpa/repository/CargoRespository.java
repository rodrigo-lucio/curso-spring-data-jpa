package br.com.alura.cursospringdatajpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.cursospringdatajpa.model.Cargo;

@Repository
public interface CargoRespository extends CrudRepository<Cargo, Integer> {

}
