package com.desafio.desafiovsm.service.impl;

import com.desafio.desafiovsm.error.EmpresaError;
import com.desafio.desafiovsm.model.dto.EmpresaDTO;
import com.desafio.desafiovsm.model.entity.Empresa;
import com.desafio.desafiovsm.repository.EmpresaRepository;
import com.desafio.desafiovsm.service.interfaces.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.StringTokenizer;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    EmpresaRepository repository;

    @Override
    public Optional<Empresa> obterPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Empresa conveterDto(EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setId(empresaDTO.getId());
        empresa.setNome(empresaDTO.getNome());
        empresa.setEmail(empresaDTO.getEmail());
        empresa.setUf(empresaDTO.getUf());
        empresa.setEndereco(empresaDTO.getEndereco());
        empresa.setBairro(empresaDTO.getBairro());
        empresa.setCidade(empresaDTO.getCidade());
        empresa.setCep(empresaDTO.getCep());
        empresa.setTelefone(empresaDTO.getTelefone());

        System.out.println(empresaDTO.getCpf());
        if (empresaDTO.getCpf().toString().length() == 11){
            String cpfFormado = empresaDTO.getCpf().toString().substring(0,3)+"."
                    +empresaDTO.getCpf().toString().substring(3,6)+"."
                    +empresaDTO.getCpf().toString().substring(6,9)+"-"
                    +empresaDTO.getCpf().toString().substring(9,11);

            empresa.setCpf(cpfFormado);
        }else{
             new EmpresaError("CPF inválido");
        }

        if(empresaDTO.getCnpj().toString().length() == 14){
            String cnpjFormado = empresaDTO.getCnpj().toString().substring(0,2)+"."
                    +empresaDTO.getCnpj().toString().substring(2,5)+"."
                    +empresaDTO.getCnpj().toString().substring(5,8)+"/"
                    +empresaDTO.getCnpj().toString().substring(8,12)+"-"
                    +empresaDTO.getCnpj().toString().substring(12,14);

            empresa.setCnpj(cnpjFormado);
        }else{
            new EmpresaError("CNPJ inválido");
        }

        return empresa;
    }

    @Override
    public Empresa buscarPorCnpjCpf(Long cpfCnpj) {
        // TODO Auto-generated method stub
        Optional<Empresa> empresa;
        System.out.println(contarNumeros(cpfCnpj));
        if(contarNumeros(cpfCnpj) == 14){
            System.out.println();
            String cnpjFormado = cpfCnpj.toString().substring(0,2)+"."
                    +cpfCnpj.toString().substring(2,5)+"."
                    +cpfCnpj.toString().substring(5,8)+"/"
                    +cpfCnpj.toString().substring(8,12)+"-"
                    +cpfCnpj.toString().substring(12,14);
            
            empresa = repository.findByCnpj(cnpjFormado);
            return empresa.get();
        }else if(contarNumeros(cpfCnpj) == 11){
            String cpfFormado = cpfCnpj.toString().substring(0,3)+"."
                    +cpfCnpj.toString().substring(3,6)+"."
                    +cpfCnpj.toString().substring(6,9)+"-"
                    +cpfCnpj.toString().substring(9,11);
            empresa = repository.findByCpf(cpfFormado);
            return empresa.get();
        }else{
            throw new EmpresaError("Valor inválido, digite um cpf ou cnpj valido!");
        }
    }

    @Override
    public Empresa buscarPorCnpjCpf(String cpfCnpj) {
        Optional<Empresa> empresa;

        System.out.println(contarLinhas(cpfCnpj));
        if(contarLinhas(cpfCnpj) == 14){

            empresa = repository.findByCpf(cpfCnpj);
            return empresa.get();
        }else if (contarLinhas(cpfCnpj) == 18){
            System.out.println("2");
            empresa = repository.findByCnpj(cpfCnpj);
            return empresa.get();
        }else {
            System.out.println("3");
            throw new EmpresaError("Valor inválido, digite um cpf ou cnpj valido!");
        }
    }

    private Integer contarLinhas(String str){
        Integer count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' ')
                count++;
        }
        return count;
    }

    private Long contarNumeros(Long numeros){
        Long count = 0L;
        for (count = 1L; count == numeros; count++) {
            System.out.println(count);
        }

        return count;
    }

}
