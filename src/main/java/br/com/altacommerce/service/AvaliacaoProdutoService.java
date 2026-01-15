package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.AvaliacaoProdutoRequestDTO;
import br.com.altacommerce.dto.response.AvaliacaoProdutoResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.AvaliacaoProduto;
import br.com.altacommerce.model.Pessoa;
import br.com.altacommerce.model.PessoaJuridica;
import br.com.altacommerce.model.Produto;
import br.com.altacommerce.repository.AvaliacaoProdutoRepository;
import br.com.altacommerce.repository.PessoaJuridicaRepository;
import br.com.altacommerce.repository.PessoaRepository;
import br.com.altacommerce.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AvaliacaoProdutoService {

    private final AvaliacaoProdutoRepository avaliacaoProdutoRepository;
    private final PessoaRepository pessoaRepository;
    private final ProdutoRepository produtoRepository;
    private final PessoaJuridicaRepository pessoaJuridicaRepository;

    public AvaliacaoProdutoService(AvaliacaoProdutoRepository avaliacaoProdutoRepository, PessoaRepository pessoaRepository, ProdutoRepository produtoRepository, PessoaJuridicaRepository pessoaJuridicaRepository) {
        this.avaliacaoProdutoRepository = avaliacaoProdutoRepository;
        this.pessoaRepository = pessoaRepository;
        this.produtoRepository = produtoRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
    }

    @Transactional
    public AvaliacaoProdutoResponseDTO createAvaliacaoProduto(AvaliacaoProdutoRequestDTO dto) {
        AvaliacaoProduto avaliacaoProduto = montarAvaliacaoProduto(dto);
        avaliacaoProdutoRepository.save(avaliacaoProduto);
        return new AvaliacaoProdutoResponseDTO(avaliacaoProduto);
    }

    @Transactional(readOnly = true)
    public AvaliacaoProdutoResponseDTO getByIdAvalicaoProduto(Long id){
        AvaliacaoProduto avaliacaoProduto = avaliacaoProdutoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Avaliação do produto com ID: " + id + " não encontrado"));
        return new AvaliacaoProdutoResponseDTO(avaliacaoProduto);
    }

    @Transactional(readOnly = true)
    public Page<AvaliacaoProdutoResponseDTO> getAllAvalaicaoProdutoNota(Integer nota, Pageable pageable){
        return avaliacaoProdutoRepository.findByNota(nota, pageable).map(AvaliacaoProdutoResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<AvaliacaoProdutoResponseDTO> getAllAvalaicaoProdutoDescricao(String descricao, Pageable pageable){
        return avaliacaoProdutoRepository.findByDescricaoContainingIgnoreCase(descricao, pageable).map(AvaliacaoProdutoResponseDTO::new);
    }

    @Transactional
    public void deleteAvaliacaoProduto(Long id){
        AvaliacaoProduto avaliacaoProduto = avaliacaoProdutoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Avaliação do produto com ID: " + id + " não encontrado"));
        avaliacaoProdutoRepository.delete(avaliacaoProduto);
    }

    private AvaliacaoProduto montarAvaliacaoProduto(AvaliacaoProdutoRequestDTO dto) {
        AvaliacaoProduto avaliacaoProduto = new AvaliacaoProduto(dto);
        avaliacaoProduto.setPessoa(buscarPessoa(dto.pessoaId()));
        avaliacaoProduto.setProduto(buscarProduto(dto.produtoId()));
        avaliacaoProduto.setEmpresa(buscarEmpresa(dto.empresaId()));

        return avaliacaoProduto;
    }

    private Pessoa buscarPessoa(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa com ID: " + id + " não encontrado"));
    }

    private Produto buscarProduto(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto com ID: " + id + " não encontrado"));
    }

    private PessoaJuridica buscarEmpresa(Long id) {
        return pessoaJuridicaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Empresa com ID: " + id + " não encontrado"));
    }
}
