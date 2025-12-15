package br.com.altacommerce.model;

import br.com.altacommerce.dto.request.PessoaJuridicaRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa{

    @Column(nullable = false, unique = true)
    private String cnpj;
    @Column(nullable = false)
    private String inscEstadual;
    @Column(nullable = false)
    private String inscMunicipal;
    @Column(nullable = false, unique = true)
    private String nomeFantasia;
    @Column(nullable = false)
    private String razaoSocial;
    private String categoria;


    public PessoaJuridica() {
    }

    public PessoaJuridica(PessoaJuridicaRequestDTO dto) {
        super(dto.nome(), dto.email(), dto.telefone(), dto.enderecoRequestDTOS().stream()
                .map(Endereco::new).toList());
        this.cnpj = dto.cnpj();
        this.inscEstadual = dto.inscEstadual();
        this.inscMunicipal = dto.inscMunicipal();
        this.nomeFantasia = dto.nomeFantasia();
        this.razaoSocial = dto.razaoSocial();
        this.categoria = dto.categoria();
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
