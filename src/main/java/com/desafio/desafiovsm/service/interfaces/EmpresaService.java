package com.desafio.desafiovsm.service.interfaces;

import com.desafio.desafiovsm.model.dto.EmpresaDTO;
import com.desafio.desafiovsm.model.entity.Empresa;

import java.util.Optional;

public interface EmpresaService {
    Optional<Empresa> obterPorId(Long id);

    Empresa conveterDto(EmpresaDTO empresaDTO);

    Empresa buscarPorCnpjCpf(Long cpfCnpj);

    Empresa buscarPorCnpjCpf(String cpfCnpj);
}
