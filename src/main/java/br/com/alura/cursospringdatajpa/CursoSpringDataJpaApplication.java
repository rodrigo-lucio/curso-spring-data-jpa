package br.com.alura.cursospringdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.cursospringdatajpa.model.Cargo;
import br.com.alura.cursospringdatajpa.repository.CargoRespository;

@SpringBootApplication
public class CursoSpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private CargoRespository cargoRespository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("Desenvolvedor III");
		cargoRespository.save(cargo);
		
	}

}
