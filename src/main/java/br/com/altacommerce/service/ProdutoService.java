package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.ProdutoRequestDTO;
import br.com.altacommerce.dto.response.ProdutoResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.*;
import br.com.altacommerce.repository.*;
import br.com.altacommerce.service.validator.produto.ValidatorProduto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final PessoaJuridicaRepository pessoaJuridicaRepository;
    private final CategoriaProdutoRepository categoriaProdutoRepository;
    private final MarcaProdutoRepository marcaProdutoRepository;
    private final NotaItemProdutoRepository notaItemProdutoRepository;
    private final List<ValidatorProduto> validators;
    private final EmailService emailService;
    private final UploadService uploadService;

    public ProdutoService(ProdutoRepository produtoRepository, PessoaJuridicaRepository pessoaJuridicaRepository, CategoriaProdutoRepository categoriaProdutoRepository, MarcaProdutoRepository marcaProdutoRepository, NotaItemProdutoRepository notaItemProdutoRepository, List<ValidatorProduto> validators, EmailService emailService, UploadService uploadService) {
        this.produtoRepository = produtoRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.categoriaProdutoRepository = categoriaProdutoRepository;
        this.marcaProdutoRepository = marcaProdutoRepository;
        this.notaItemProdutoRepository = notaItemProdutoRepository;
        this.validators = validators;
        this.emailService = emailService;
        this.uploadService = uploadService;
    }

    @Transactional
    public ProdutoResponseDTO createProduto(ProdutoRequestDTO dto) {
        validators.forEach(v -> v.validate(dto));
        Produto produto = montarProduto(dto);
        produtoRepository.save(produto);
        return new ProdutoResponseDTO(produto);
    }

    @Transactional(readOnly = true)
    public ProdutoResponseDTO getByProdutoId(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new NotFoundException("Produto com id: " + id + " não encontrado"));
        return new ProdutoResponseDTO(produto);
    }

    @Transactional(readOnly = true)
    public Page<ProdutoResponseDTO> getAllProdutoNome(String nome, Pageable pageable) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome, pageable).map(ProdutoResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<ProdutoResponseDTO> getAllProdutoDescricao(String descricao, Pageable pageable) {
        return produtoRepository.findByDescricaoContainingIgnoreCase(descricao, pageable).map(ProdutoResponseDTO::new);
    }

    @Transactional
    public void deleteProduto(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Produto com id: " + id + " não encontrado"));
        produtoRepository.delete(produto);
    }

    @Transactional
    public void baixarEstoque(Long produtoId, Integer quantidade) {

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        produto.setQtdEstoque(produto.getQtdEstoque() - quantidade);

        produtoRepository.save(produto);

        verificarAlertaEstoque(produto);
    }


    //-------------------------------------------------------//

    private Produto montarProduto(ProdutoRequestDTO dto) {
        Produto produto = new Produto(dto);

        produto.setEmpresa(buscarEmpresa(dto.empresaId()));
        produto.setCategoriaProduto(buscarCategoria(dto.categoriaProdutoId()));
        produto.setMarcaProduto(buscarMarca(dto.marcaProdutoId()));

        List<ImagemProduto> imagens = dto.imagens().stream().map(dtoImg  -> {
            ImagemProduto imagem = new ImagemProduto();


            imagem.setImagemOriginal(dtoImg.imagemOriginal());
            imagem.setImagemMiniatura(
                    uploadService.gerarMiniaturaBase64(dtoImg.imagemOriginal())
            );

            imagem.setProduto(produto);
            imagem.setEmpresa(buscarEmpresa(dto.empresaId()));

            return imagem;

        }).toList();

        produto.setImagemProdutos(imagens);


        return produto;
    }


    private PessoaJuridica buscarEmpresa(Long id) {
        return pessoaJuridicaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Empresa com id " + id + " não existe"));
    }

    private CategoriaProduto buscarCategoria(Long id) {
        return categoriaProdutoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria com id " + id + " não existe"));
    }

    private MarcaProduto buscarMarca(Long id) {
        return marcaProdutoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Marca produto com id " + id + " não existe"));
    }

    private NotaItemProduto buscarNotaItem(Long id) {
        return notaItemProdutoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nota do produto com id " + id + " não existe"));
    }

    private void verificarAlertaEstoque(Produto produto) {

        if (Boolean.TRUE.equals(produto.getAlertaQtdEstoque())
                && produto.getQtdEstoque() <= produto.getQtdAlertaEstoque()
                && Boolean.FALSE.equals(produto.getAlertaEstoqueEnviado())) {

            emailService.enviarEmailAlertaEstoque(produto);
            produto.setAlertaEstoqueEnviado(true);
        }

    }



}
