package com.desafio.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.desafio.entities.Empresa;
import com.desafio.desafio.entities.Fornecedor;
import com.desafio.desafio.repositories.EmpresaRepository;
import com.desafio.desafio.repositories.FornecedorRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private EmpresaRepository empresaRepository;
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Override
    public void run(String... args) throws Exception {
        Empresa e1 = new Empresa("11111111111111", "ACCENTURE", null, null, null, null, null, null, null);
        Empresa e2 = new Empresa("22222222222222", "APOSTA LTDA", null, null, null, null, null, null, null);

        empresaRepository.saveAll(Arrays.asList(e1, e2));

        Fornecedor f1 = new Fornecedor("00011111111111", "ROBERTO", null, null, null, null, null, null, null, null, null, null, null);

        fornecedorRepository.saveAll(Arrays.asList(f1));
    }
}
