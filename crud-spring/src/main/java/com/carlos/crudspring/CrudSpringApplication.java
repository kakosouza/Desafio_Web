package com.carlos.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.carlos.crudspring.model.Empresa;
import com.carlos.crudspring.model.Fornecedor;
import com.carlos.crudspring.repository.EmpresaRepository;
import com.carlos.crudspring.repository.FornecedorRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

//	@Bean 	//O Spring vai gerenciar tudo
/* 	CommandLineRunner initDataBase(EmpresaRepository empresaRepository) {
		return args -> {
			empresaRepository.deleteAll();

			Empresa e = new Empresa();
			e.setCnpj("11111111111111");
			e.setNome("ACCENTURE");

			empresaRepository.save(e);

		};
	}*/

//	@Bean 	//O Spring vai gerenciar tudo
/*	CommandLineRunner initDataBase(FornecedorRepository fornecedorRepository) {
		return args -> {
			fornecedorRepository.deleteAll();

			Fornecedor e = new Fornecedor();
			e.setChave("00022222222222");
			e.setNome("PEDRO SILVA");

			fornecedorRepository.save(e);

		};
	}*/
}