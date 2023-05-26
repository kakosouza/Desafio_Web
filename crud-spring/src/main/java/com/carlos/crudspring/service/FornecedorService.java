package com.carlos.crudspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.carlos.crudspring.dto.FornecedorDTO;
import com.carlos.crudspring.dto.mapper.FornecedorMapper;
import com.carlos.crudspring.exception.RecordNotFoundException;
import com.carlos.crudspring.repository.FornecedorRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;
    private final FornecedorMapper fornecedorMapper;

    public FornecedorService(FornecedorRepository fornecedorRepository, FornecedorMapper fornecedorMapper) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecedorMapper = fornecedorMapper;
    }

    public List<FornecedorDTO> list() {
        return fornecedorRepository.findAll().stream().map(fornecedorMapper::toDTO)
            .collect(Collectors.toList());
    }

    public FornecedorDTO findById(@PathVariable @NotNull @Positive Long id) {
        return fornecedorRepository.findById(id).map(fornecedorMapper::toDTO)
            .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public FornecedorDTO create(@RequestBody @Valid @NotNull FornecedorDTO fornecedor) {
        return fornecedorMapper.toDTO(fornecedorRepository.save(fornecedorMapper.toEntity(fornecedor)));
    }

    public FornecedorDTO update(@NotNull @Positive Long id, @Valid @NotNull FornecedorDTO fornecedor) {
        return fornecedorRepository.findById(id)
        .map(recordFound -> {
            recordFound.setChave(fornecedor.chave());
            recordFound.setNome(fornecedor.nome());
            recordFound.setCep(fornecedor.cep());
            recordFound.setLogradouro(fornecedor.logradouro());
            recordFound.setNumero(fornecedor.numero());
            recordFound.setComplemento(fornecedor.complemento());
            recordFound.setBairro(fornecedor.bairro());
            recordFound.setCidade(fornecedor.cidade());
            recordFound.setEstado(fornecedor.estado());
            recordFound.setRg(fornecedor.rg());
            recordFound.setEmail(fornecedor.email());
            recordFound.setDtnascimento(fornecedor.dtnascimento());
            recordFound.setFstatus(fornecedor.fstatus());
            return fornecedorMapper.toDTO(fornecedorRepository.save(recordFound));
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        fornecedorRepository.delete(fornecedorRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}