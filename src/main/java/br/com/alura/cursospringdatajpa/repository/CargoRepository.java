package br.com.alura.cursospringdatajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.cursospringdatajpa.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

	Page<Cargo> findByDescricaoContainingIgnoreCase(Pageable pageable, String nome);
}
