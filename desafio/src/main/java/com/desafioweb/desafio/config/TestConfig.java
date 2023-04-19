package com.desafioweb.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafioweb.desafio.entities.Empresa;
import com.desafioweb.desafio.entities.Fornecedor;
import com.desafioweb.desafio.entities.enums.FornStatus;
import com.desafioweb.desafio.repositories.EmpresaRepository;
import com.desafioweb.desafio.repositories.FornecedorRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private FornecedorRepository fornRepository;
	
	@Autowired
	private EmpresaRepository emprRepository;

	public void run(String... args) throws Exception {
		
	
		Fornecedor f1 = new Fornecedor("00011111111111", "CARLOS SOUZA", 99999999, null, "fulano@gmail.com", "50000000", "AV MASCARENHAS DE MORAES", 2000, "SALA 1", "RECIFE", "IMBIRIBEIRA", FornStatus.CANCELADO, "PE");
		Fornecedor f2 = new Fornecedor("99911111111111", "SERGIO", 99999999, null, "sergio@gmail.com", "50000000", "AV RECIFE", 100, "APT 903", "RECIFE", "IPSEP", FornStatus.OK, "PE");
		
		fornRepository.saveAll(Arrays.asList(f1, f2));
		
		Empresa e1 = new Empresa("22222222222222", "EMPRESA 1", null, null, null, null, null, null, null);
		Empresa e2 = new Empresa("33333333333333", "EMPRESA2", null, null, null, null, null, null, null);

		emprRepository.saveAll(Arrays.asList(e1, e2));
	}
}
