package br.com.alura.cursospringdatajpa.controller;

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

import br.com.alura.cursospringdatajpa.model.Cargo;
import br.com.alura.cursospringdatajpa.repository.CargoRepository;
import br.com.alura.cursospringdatajpa.service.CargoService;
import br.com.alura.cursospringdatajpa.service.impl.CargoServiceImpl;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	@Autowired
	private CargoService service;
	
	@GetMapping
	private ResponseEntity<Page<Cargo>> listar(Pageable pageable, 
			@RequestParam(required = false) String descricao) {
		Page<Cargo> cargos = service.listarPaginado(pageable, descricao);
		return ResponseEntity.ok(cargos);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Cargo> buscarPorId(@PathVariable Long id) {
		Cargo cargo = service.buscarPorId(id);
		return ResponseEntity.ok(cargo);
	}
	
	@PostMapping
	private ResponseEntity<Cargo> cadastrar(@RequestBody @Valid Cargo cargo) {
		Cargo cargoCriado = service.salvar(cargo);
		return ResponseEntity.status(HttpStatus.CREATED).body(cargoCriado);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Cargo> atualizar(@PathVariable Long id, @RequestBody @Valid Cargo cargo){
		Cargo cargoBuild = Cargo.builder()
								.id(id)
								.descricao(cargo.getDescricao())
								.build();
		Cargo cargoAtualizado = service.salvar(cargoBuild);
		return ResponseEntity.status(HttpStatus.OK).body(cargoAtualizado);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void deletar(@PathVariable Long id) {
		service.deletarPorId(id);
	}
	
}
