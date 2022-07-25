package com.desafio.desafiovsm.controller;

import com.desafio.desafiovsm.model.dto.EmpresaDTO;
import com.desafio.desafiovsm.model.entity.Empresa;
import com.desafio.desafiovsm.repository.EmpresaRepository;
import com.desafio.desafiovsm.service.impl.EmpresaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaServiceImpl service;
    @Autowired
    private EmpresaRepository repository;

    @PostMapping
    public ResponseEntity salvarEmpresa(@RequestBody EmpresaDTO dto){
        Empresa empresa = service.conveterDto(dto);
        Empresa empresaSalva = repository.save(empresa);
        return new ResponseEntity(empresaSalva, HttpStatus.CREATED);
    }
}
