package com.carlos.crudspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.carlos.crudspring.dto.EmpresaDTO;
import com.carlos.crudspring.dto.mapper.EmpresaMapper;
import com.carlos.crudspring.exception.RecordNotFoundException;
import com.carlos.crudspring.model.Empresa;
import com.carlos.crudspring.repository.EmpresaRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;

    public EmpresaService(EmpresaRepository empresaRepository, EmpresaMapper empresaMapper) {
        this.empresaRepository = empresaRepository;
        this.empresaMapper = empresaMapper;
    }

    public List<EmpresaDTO> list() {
        return empresaRepository.findAll().stream().map(empresaMapper::toDTO)
            .collect(Collectors.toList());
    }

    public EmpresaDTO findById(@PathVariable @NotNull @Positive Long id) {
        return empresaRepository.findById(id).map(empresaMapper::toDTO)
            .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public EmpresaDTO create(@Valid Empresa empresa) {
        return empresaMapper.toDTO(empresaRepository.save(empresa));
    }

    public EmpresaDTO update(@NotNull @Positive Long id, @Valid Empresa empresa) {
        return empresaRepository.findById(id)
        .map(recordFound -> {
            recordFound.setCnpj(empresa.getCnpj());
            recordFound.setNome(empresa.getNome());
            recordFound.setCep(empresa.getCep());
            recordFound.setLogradouro(empresa.getLogradouro());
            recordFound.setNumero(empresa.getNumero());
            recordFound.setComplemento(empresa.getComplemento());
            recordFound.setBairro(empresa.getBairro());
            recordFound.setCidade(empresa.getCidade());
            recordFound.setEstado(empresa.getEstado());
            return empresaRepository.save(recordFound);
        }).map(empresaMapper::toDTO).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id) {
        empresaRepository.delete(empresaRepository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}