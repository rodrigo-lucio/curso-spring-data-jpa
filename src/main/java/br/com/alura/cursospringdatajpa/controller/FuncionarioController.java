package br.com.alura.cursospringdatajpa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.cursospringdatajpa.model.Funcionario;
import br.com.alura.cursospringdatajpa.model.FuncionarioProjecao;
import br.com.alura.cursospringdatajpa.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	private ResponseEntity<Page<Funcionario>> listar(Pageable pageable, 
			@RequestParam(required = false) String nome) {
		Page<Funcionario> funcionarios = service.listarPaginado(pageable, nome);
		return ResponseEntity.ok(funcionarios);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
		Funcionario funcionario = service.buscarPorId(id);
		return ResponseEntity.ok(funcionario);
	}
	
	@GetMapping("/projecao")
	private ResponseEntity<List<FuncionarioProjecao>> listarProjecao() {
		List<FuncionarioProjecao> funcionarios = service.buscarPorProjecao();
		return ResponseEntity.ok(funcionarios);
	}
	
	@GetMapping("/specification")
	private ResponseEntity<Page<Funcionario>> listarSpecification(Pageable pageable, 
			@RequestParam String nome) {
		Page<Funcionario> funcionarios = service.listarPaginadoSpecification(pageable, nome);
		return ResponseEntity.ok(funcionarios);
	}
	
	@PostMapping
	private ResponseEntity<Funcionario> cadastrar(@RequestBody @Valid Funcionario Funcionario) {
		Funcionario funcionarioCriado = service.salvar(Funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioCriado);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody @Valid Funcionario Funcionario){
		Funcionario funcionarioBuild = Funcionario.builder()
								.id(id)
								.nome(Funcionario.getNome())
								.cpf(Funcionario.getCpf())
								.salario(Funcionario.getSalario())
								.dataContratacao(Funcionario.getDataContratacao())
								.unidade(Funcionario.getUnidade())
								.cargo(Funcionario.getCargo())
								.build();
		Funcionario funcionarioAtualizado = service.salvar(funcionarioBuild);
		return ResponseEntity.status(HttpStatus.OK).body(funcionarioAtualizado);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void deletar(@PathVariable Long id) {
		service.deletarPorId(id);
	}
	
}
