package br.com.altacommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa{

    private String cnpj;
    private String inscEstadual;
    private String inscMunicipal;
    private String nomeFantasia;
    private String razaoSocial;
    private String categoria;


    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj, String inscEstadual, String inscMunicipal, String nomeFantasia, String razaoSocial, String categoria) {
        this.cnpj = cnpj;
        this.inscEstadual = inscEstadual;
        this.inscMunicipal = inscMunicipal;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.categoria = categoria;
    }

    public String getCnpj() {
        return cnpj;
    }

    public PessoaJuridica setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getInscEstadual() {
        return inscEstadual;
    }

    public PessoaJuridica setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
        return this;
    }

    public String getInscMunicipal() {
        return inscMunicipal;
    }

    public PessoaJuridica setInscMunicipal(String inscMunicipal) {
        this.inscMunicipal = inscMunicipal;
        return this;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public PessoaJuridica setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
        return this;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public PessoaJuridica setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public String getCategoria() {
        return categoria;
    }

    public PessoaJuridica setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }


}
