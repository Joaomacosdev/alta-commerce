package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.CategoriaProdutoRequestDTO;
import br.com.altacommerce.dto.response.CategoriaProdutoResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.CategoriaProduto;
import br.com.altacommerce.model.PessoaJuridica;
import br.com.altacommerce.repository.CategoriaProdutoRepository;
import br.com.altacommerce.repository.PessoaJuridicaRepository;
import br.com.altacommerce.service.validator.categoriaProduto.ValidatorCategoriaProduto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaProdutoService {

    private final CategoriaProdutoRepository categoriaRepository;
    private final PessoaJuridicaRepository pessoaJuridicaRepository;
    private final List<ValidatorCategoriaProduto> validators;

    public CategoriaProdutoService(CategoriaProdutoRepository categoriaRepository, PessoaJuridicaRepository pessoaJuridicaRepository, List<ValidatorCategoriaProduto> validators) {
        this.categoriaRepository = categoriaRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.validators = validators;
    }

    @Transactional
    public CategoriaProdutoResponseDTO creteCategoriaProduto(CategoriaProdutoRequestDTO dto){

        validators.forEach(v -> v.validate(dto));

        PessoaJuridica empresa = pessoaJuridicaRepository.findById(dto.empresaId())
                .orElseThrow(() -> new NotFoundException("Empresa não encontrada"));

        CategoriaProduto categoriaProduto = new CategoriaProduto(dto);
        categoriaProduto.setEmpresa(empresa);

        categoriaRepository.save(categoriaProduto);

        return new CategoriaProdutoResponseDTO(categoriaProduto);
    }
}
