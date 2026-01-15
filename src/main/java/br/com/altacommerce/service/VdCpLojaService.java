package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.ItemVendaLojaRequestDTO;
import br.com.altacommerce.dto.request.VdCpLojaRequestDTO;
import br.com.altacommerce.dto.response.VdCpLojaResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.*;
import br.com.altacommerce.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class VdCpLojaService {

    private final VdCpLojaRepository vdCpLojaRepository;
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
    private final PessoaJuridicaRepository pessoaJuridicaRepository;
    private final FormaPagamentoRepository formaPagamentoRepository;
    private final ProdutoRepository produtoRepository;

    public VdCpLojaService(VdCpLojaRepository vdCpLojaRepository, PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository, PessoaJuridicaRepository pessoaJuridicaRepository, FormaPagamentoRepository formaPagamentoRepository, ProdutoRepository produtoRepository) {
        this.vdCpLojaRepository = vdCpLojaRepository;
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.formaPagamentoRepository = formaPagamentoRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public VdCpLojaResponseDTO createVdCpLoja(VdCpLojaRequestDTO dto){

        VdCpLoja vdCpLoja = montarVdCpLoja(dto);
        NotaFiscalvenda notaFiscalvenda = montarNotaFiscalVenda(dto, vdCpLoja);
        vdCpLoja.setNotaFiscalvenda(notaFiscalvenda);

        vdCpLojaRepository.save(vdCpLoja);
        return new VdCpLojaResponseDTO(vdCpLoja);

    }

    @Transactional(readOnly = true)
    public VdCpLojaResponseDTO getByIdVdCpLoja(Long id){
        VdCpLoja vdCpLoja = vdCpLojaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vd cp loja com ID: " + id + " não encontrado"));

        return new VdCpLojaResponseDTO(vdCpLoja);
    }

    private VdCpLoja montarVdCpLoja(VdCpLojaRequestDTO dto){
        VdCpLoja vdCpLoja = new VdCpLoja(dto);
        vdCpLoja.setDataVenda(LocalDate.now());
        vdCpLoja.setPessoa(buscarPessoa(dto.pessoaId()));
        vdCpLoja.setEnderecoEntrega(buscarEndereco(dto.enderecoEntregaId()));
        vdCpLoja.setEndercoCobranca(buscarEndereco(dto.enderecoCobrancaId()));
        vdCpLoja.setFormaPagamento(buscarFormaPagamento(dto.formaPagamentoId()));
        vdCpLoja.setEmpresa(buscarEmpresa(dto.empresaId()));

        for (ItemVendaLojaRequestDTO itemDTO : dto.itens()){
            ItemVendaLoja itemVendaLoja = new ItemVendaLoja();
            itemVendaLoja.setQuantidade(itemDTO.quantidade());
            itemVendaLoja.setProduto(buscarProduto(itemDTO.produtoId()));
            itemVendaLoja.setVdCpLoja(vdCpLoja);
            itemVendaLoja.setEmpresa(vdCpLoja.getEmpresa());

            vdCpLoja.adicionarItem(itemVendaLoja);
        }


        return vdCpLoja;
    }

    private NotaFiscalvenda montarNotaFiscalVenda(VdCpLojaRequestDTO dto, VdCpLoja vdCpLoja){
        NotaFiscalvenda notaFiscal = new NotaFiscalvenda();

        notaFiscal.setNumero(dto.notaFiscalVenda().numero());
        notaFiscal.setSerie(dto.notaFiscalVenda().serie());
        notaFiscal.setTipo(dto.notaFiscalVenda().tipo());
        notaFiscal.setXml(dto.notaFiscalVenda().xml());
        notaFiscal.setPdf(dto.notaFiscalVenda().pdf());
        notaFiscal.setEmpresa(buscarEmpresa(dto.empresaId()));


        notaFiscal.setVdCpLoja(vdCpLoja);

        return notaFiscal;
    }


    private Pessoa buscarPessoa(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pessoa com ID: " + id + " não encontrado"));
    }

    private Endereco buscarEndereco(Long id){
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Endereco com ID: " + id + " não encontrado"));
    }

    private PessoaJuridica buscarEmpresa(Long id){
        return pessoaJuridicaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Empresa com ID: " + id + " não encontrado"));
    }

    private FormaPagamento buscarFormaPagamento(Long id){
        return formaPagamentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Forma Pagamento com ID: " + id + " não encontrado"));
    }

    private Produto buscarProduto(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto com ID: " + id + " não encontrado"));
    }


}
