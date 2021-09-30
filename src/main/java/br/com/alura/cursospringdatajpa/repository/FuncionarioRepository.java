package br.com.alura.cursospringdatajpa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.cursospringdatajpa.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	Page<Funcionario> findByNomeContainingIgnoreCase(Pageable pageable, String nome);
	
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario and f.dataContratacao = :dataContratacao")
	List<Funcionario> findNomeDataContratacaoSalarioMaior(String nome, Double salario, LocalDate dataContratacao);
}
