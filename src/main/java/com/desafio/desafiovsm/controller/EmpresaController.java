package com.desafio.desafiovsm.controller;

import com.desafio.desafiovsm.model.dto.EmpresaDTO;
import com.desafio.desafiovsm.model.entity.Empresa;
import com.desafio.desafiovsm.repository.EmpresaRepository;
import com.desafio.desafiovsm.service.impl.EmpresaServiceImpl;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/buscar/int")
    public ResponseEntity buscarEmpresaPorInteiro(@RequestBody Long cpfCnpj){
        try {
            Empresa empresa =   service.buscarPorCnpjCpf(cpfCnpj);
            return new ResponseEntity(empresa, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar/str")
    public ResponseEntity buscarEmpresaPorString(@RequestParam(value = "cpfCnpj", required = false) String cpfCnpj){
        try {
            Empresa empresa =   service.buscarPorCnpjCpf(cpfCnpj);
            return  ResponseEntity.ok(empresa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
