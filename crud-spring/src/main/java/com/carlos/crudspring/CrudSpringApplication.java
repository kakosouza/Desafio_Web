package com.carlos.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.carlos.crudspring.model.Empresa;
import com.carlos.crudspring.repository.EmpresaRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(EmpresaRepository empresaRepository) {
		return args -> {
			empresaRepository.deleteAll();

			Empresa e = new Empresa();
			e.setCnpj("11111111111111");
			e.setNome("PEDRO");

			empresaRepository.save(e);
		};
	}
}
