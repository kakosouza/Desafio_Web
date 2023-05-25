package com.carlos.crudspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.carlos.crudspring.dto.EmpresaDTO;
import com.carlos.crudspring.dto.mapper.EmpresaMapper;
import com.carlos.crudspring.exception.RecordNotFoundException;
import com.carlos.crudspring.repository.EmpresaRepository;
import com.carlos.crudspring.repository.EmpresaRepository1;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
//    private final EmpresaRepository1 empresaRepository1;
    private final EmpresaMapper empresaMapper;

    public EmpresaService(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper
//EmpresaRepository1 empresaRepository1
    ) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
//        this.empresaRepository1 = empresaRepository1;
    }

    public List<EmpresaDTO> list() {
        return empresaRepository.findAll().stream().map(empresaMapper::toDTO)
            .collect(Collectors.toList());
    }

    public EmpresaDTO findById(@PathVariable @NotNull @Positive Long id) {
        return empresaRepository.findById(id).map(empresaMapper::toDTO)
            .orElseThrow(() -> new RecordNotFoundException(id));
    }

//    public EmpresaDTO findByCnpj(@PathVariable @NotNull String cnpj) {
//        return empresaRepository1.findById(cnpj).map(empresaMapper::toDTO)
//            .orElseThrow(() -> new RecordNotFoundException(cnpj));
//    }

    public EmpresaDTO create(@RequestBody @Valid @NotNull EmpresaDTO empresa) {
        return empresaMapper.toDTO(empresaRepository.save(empresaMapper.toEntity(empresa)));
    }

    public EmpresaDTO update(@NotNull @Positive Long id, @Valid @NotNull EmpresaDTO empresa) {
        return empresaRepository.findById(id)
        .map(recordFound -> {
            recordFound.setCnpj(empresa.cnpj());
            recordFound.setNome(empresa.nome());
            recordFound.setCep(empresa.cep());
            recordFound.setLogradouro(empresa.logradouro());
            recordFound.setNumero(empresa.numero());
            recordFound.setComplemento(empresa.complemento());
            recordFound.setBairro(empresa.bairro());
            recordFound.setCidade(empresa.cidade());
            recordFound.setEstado(empresa.estado());
            return empresaMapper.toDTO(empresaRepository.save(recordFound));
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        empresaRepository.delete(empresaRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}