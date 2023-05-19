package com.carlos.crudspring.dto.mapper;

import org.springframework.stereotype.Component;

import com.carlos.crudspring.dto.FornecedorDTO;
import com.carlos.crudspring.model.Fornecedor;

@Component
public class FornecedorMapper {
    
    public FornecedorDTO toDTO(Fornecedor fornecedor) {
        if (fornecedor == null) {
            return null;
        }

        return new FornecedorDTO(fornecedor.getId(), fornecedor.getChave(), fornecedor.getNome(),
        fornecedor.getCep(), fornecedor.getLogradouro(), fornecedor.getNumero(), fornecedor.getComplemento(),
        fornecedor.getCidade(), fornecedor.getBairro(), fornecedor.getEstado(), fornecedor.getDtnascimento(),
        fornecedor.getEmail(), fornecedor.getRg(), fornecedor.getFstatus());
    }

    public Fornecedor toEntity(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = new Fornecedor();

        if (fornecedorDTO == null) {
            return null;
        }
        
        if (fornecedorDTO.id() != null) {
            fornecedor.setId(fornecedorDTO.id());
        }
        fornecedor.setChave(fornecedorDTO.chave());
        fornecedor.setNome(fornecedorDTO.nome());
        fornecedor.setCep(fornecedorDTO.cep());
        fornecedor.setLogradouro(fornecedorDTO.logradouro());
        fornecedor.setNumero(fornecedorDTO.numero());
        fornecedor.setBairro(fornecedorDTO.bairro());
        fornecedor.setCidade(fornecedorDTO.cidade());
        fornecedor.setEstado(fornecedorDTO.estado());
        fornecedor.setComplemento(fornecedorDTO.complemento());
        fornecedor.setDtnascimento(fornecedorDTO.dtnascimento());
        fornecedor.setEmail(fornecedorDTO.email());
        fornecedor.setRg(fornecedorDTO.rg());
        fornecedor.setFstatus(fornecedorDTO.fstatus());
        return fornecedor;
    }
}
