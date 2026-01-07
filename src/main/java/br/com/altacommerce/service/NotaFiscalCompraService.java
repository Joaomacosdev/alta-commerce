package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.NotaFiscalCompraRequestDTO;
import br.com.altacommerce.dto.response.NotaFiscalCompraResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.*;
import br.com.altacommerce.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class NotaFiscalCompraService {

    private final NotaFiscalCompraRepository notaFiscalCompraRepository;
    private final PessoaRepository pessoaRepository;
    private final ContaPagarRepository contaPagarRepository;
    private final PessoaJuridicaRepository pessoaJuridicaRepository;
    private final ProdutoRepository produtoRepository;

    public NotaFiscalCompraService(NotaFiscalCompraRepository notaFiscalCompraRepository, PessoaRepository pessoaRepository, ContaPagarRepository contaPagarRepository, PessoaJuridicaRepository pessoaJuridicaRepository, ProdutoRepository produtoRepository) {
        this.notaFiscalCompraRepository = notaFiscalCompraRepository;
        this.pessoaRepository = pessoaRepository;
        this.contaPagarRepository = contaPagarRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public NotaFiscalCompraResponseDTO createNotaFiscalCompra(NotaFiscalCompraRequestDTO dto){
        NotaFiscalCompra notaFiscalCompra = montarNotaFiscalCompra(dto);
        notaFiscalCompraRepository.save(notaFiscalCompra);
        return new NotaFiscalCompraResponseDTO(notaFiscalCompra);
    }

    @Transactional(readOnly = true)
    public Page<NotaFiscalCompraResponseDTO> getAllNotaFiscalCompraDescricao(String descricao, Pageable pageable) {
        return notaFiscalCompraRepository.findByDescricaoObsContainingIgnoreCase(descricao, pageable).map(NotaFiscalCompraResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public NotaFiscalCompraResponseDTO getNotaFiscalCompraById(Long id) {
       NotaFiscalCompra notaFiscalCompra = notaFiscalCompraRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa com id: " + id + " não encontrada"));
        return new NotaFiscalCompraResponseDTO(notaFiscalCompra);
    }

    @Transactional(readOnly = true)
    public Page<NotaFiscalCompraResponseDTO> getContaPagarByPessoa(Long pessoaId, Pageable pageable) {
        pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new NotFoundException("Pessoa com id: " + pessoaId + " não encontrada"));
        return notaFiscalCompraRepository.findByPessoaId(pessoaId, pageable).map(NotaFiscalCompraResponseDTO::new);
    }

    @Transactional
    public void deleteNotaFiscalCompra(Long id) {
        NotaFiscalCompra notaFiscalCompra = notaFiscalCompraRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Nota Fiscal de compra com ID: " + id + " não encotrado"));
        notaFiscalCompraRepository.delete(notaFiscalCompra);

    }


    //-----------------------------------------------------------//

    private NotaFiscalCompra montarNotaFiscalCompra(NotaFiscalCompraRequestDTO dto){
        NotaFiscalCompra notaFiscalCompra = new NotaFiscalCompra(dto);
        notaFiscalCompra.setPessoa(buscarPessoaId(dto.pessoaId()));
        notaFiscalCompra.setContaPagar(buscarContaPagarId(dto.contaPagarId()));
        notaFiscalCompra.setEmpresa(buscarEmpresaId(dto.empresaId()));
        notaFiscalCompra.setDataCompra(LocalDate.now());

        for (var itemDto : dto.itens()) {

            Produto produto = produtoRepository.findById(itemDto.produtoId())
                    .orElseThrow(() -> new NotFoundException(
                            "Produto com ID: " + itemDto.produtoId() + " não encontrado"));

            NotaItemProduto item = new NotaItemProduto();
            item.setProduto(produto);
            item.setQuantidade(itemDto.quantidade());
            item.setEmpresa(notaFiscalCompra.getEmpresa());

            notaFiscalCompra.adicionarItem(item);
        }

        notaFiscalCompra.calcularValorFinal();

        return notaFiscalCompra;
    }

    private Pessoa buscarPessoaId(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa com ID: " + id + " não encontrado"));
    }

    private ContaPagar buscarContaPagarId(Long id){
        return contaPagarRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Conta a pagar com ID: " + id + " não encontrado"));
    }

    private PessoaJuridica buscarEmpresaId(Long id){
        return pessoaJuridicaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Empresa com ID: " + id + " não encontrado"));
    }




}
