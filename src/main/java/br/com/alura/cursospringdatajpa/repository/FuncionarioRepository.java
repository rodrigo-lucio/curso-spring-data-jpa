package br.com.alura.cursospringdatajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.cursospringdatajpa.model.Cargo;
import br.com.alura.cursospringdatajpa.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Page<Funcionario> findByNomeContainingIgnoreCase(Pageable pageable, String nome);
	
}
