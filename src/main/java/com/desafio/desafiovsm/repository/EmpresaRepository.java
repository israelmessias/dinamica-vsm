package com.desafio.desafiovsm.repository;

import com.desafio.desafiovsm.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Optional<Empresa> findByCpf(String cpf);

    Optional<Empresa> findByCnpj(String cnpj);
}

