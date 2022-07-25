package com.desafio.desafiovsm.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column
    private Long id;

    @Column
    @Size(max = 15, min = 15)
    private String cpf;

    @Column
    @Size(max = 18, min = 18)
    private String cnpj;

    @Column
    private String nome;
    @Column
    private String endereco;

    @Column
    private String bairro;

    @Column
    private String cidade;

    @Column
    @Size(max = 2, min = 2)
    private String uf;

    @Column
    @Email(regexp = "`/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$/`")
    private String email;

    @Column
    @Size(max = 10)
    private String cep;

    @Column
    private String telefone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id) &&
                Objects.equals(cpf, empresa.cpf) &&
                Objects.equals(cnpj, empresa.cnpj) &&
                Objects.equals(endereco, empresa.endereco) &&
                Objects.equals(bairro, empresa.bairro) &&
                Objects.equals(cidade, empresa.cidade) &&
                Objects.equals(uf, empresa.uf) &&
                Objects.equals(email, empresa.email) &&
                Objects.equals(cep, empresa.cep) &&
                Objects.equals(telefone, empresa.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, cnpj, endereco, bairro, cidade, uf, email, cep, telefone);
    }
}
