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

import br.com.alura.cursospringdatajpa.model.Unidade;
import br.com.alura.cursospringdatajpa.service.UnidadeService;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

	@Autowired
	private UnidadeService service;
	
	@GetMapping
	private ResponseEntity<Page<Unidade>> listar(Pageable pageable, 
			@RequestParam(required = false) String descricao) {
		Page<Unidade> unidades = service.listarPaginado(pageable, descricao);
		return ResponseEntity.ok(unidades);
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Unidade> buscarPorId(@PathVariable Long id) {
		Unidade unidade = service.buscarPorId(id);
		return ResponseEntity.ok(unidade);
	}
	
	@PostMapping
	private ResponseEntity<Unidade> cadastrar(@RequestBody @Valid Unidade unidade) {
		Unidade unidadeCriado = service.salvar(unidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(unidadeCriado);
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Unidade> atualizar(@PathVariable Long id, @RequestBody @Valid Unidade unidade){
		Unidade unidadeBuild = Unidade.builder()
								.id(id)
								.descricao(unidade.getDescricao())
								.endereco(unidade.getEndereco())
								.build();
		Unidade unidadeAtualizado = service.salvar(unidadeBuild);
		return ResponseEntity.status(HttpStatus.OK).body(unidadeAtualizado);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void deletar(@PathVariable Long id) {
		service.deletarPorId(id);
	}
	
}
