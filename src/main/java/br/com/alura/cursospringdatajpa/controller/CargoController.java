package br.com.alura.cursospringdatajpa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.cursospringdatajpa.model.Cargo;
import br.com.alura.cursospringdatajpa.service.CargoService;

@RestController
@RequestMapping("/cargo")
public class CargoController {

	@Autowired
	private CargoService service;
	
	@PostMapping
	private ResponseEntity<Cargo> criarCargo(@RequestBody @Valid Cargo cargo) {
		Cargo cargoCriado = service.criarCargo(cargo);
		return ResponseEntity.status(HttpStatus.CREATED).body(cargoCriado);
	}
	

}
