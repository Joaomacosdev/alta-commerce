package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.ItemVendaLojaRequestDTO;
import br.com.altacommerce.dto.request.VdCpLojaRequestDTO;
import br.com.altacommerce.dto.response.VdCpLojaResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.*;
import br.com.altacommerce.repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;

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
        StatusRastreio statusRastreio = criarStatusInicial(vdCpLoja);
        vdCpLoja.setStatusRastreios(Collections.singletonList(statusRastreio));
        vdCpLojaRepository.save(vdCpLoja);
        return new VdCpLojaResponseDTO(vdCpLoja);

    }

    @Transactional(readOnly = true)
    public VdCpLojaResponseDTO getByIdVdCpLoja(Long id){
        VdCpLoja vdCpLoja = vdCpLojaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vd cp loja com ID: " + id + " não encontrado"));

        return new VdCpLojaResponseDTO(vdCpLoja);
    }

    @Transactional(readOnly = true)
    public Page<VdCpLojaResponseDTO> getAllVendaProdutoNome(String nome, Pageable pageable){
        return vdCpLojaRepository.buscarPorNomeProduto(nome, pageable).map(VdCpLojaResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<VdCpLojaResponseDTO> getAllVendaClienteNome(String nome, Pageable pageable){
        return vdCpLojaRepository.buscarPorNomePessoa(nome, pageable).map(VdCpLojaResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<VdCpLojaResponseDTO> getAllVendaClienteCpf(String cpf, Pageable pageable){
        return vdCpLojaRepository.buscarPorCpfPessoa(cpf, pageable).map(VdCpLojaResponseDTO::new);
    }

    @Transactional(readOnly = true)
    public Page<VdCpLojaResponseDTO> getAllVendaDataVenda(  LocalDate inicio,
                                                            LocalDate fim, Pageable pageable){
        return vdCpLojaRepository.findByDataVendaGreaterThanEqualAndDataVendaLessThanEqual(inicio, fim,pageable).map(VdCpLojaResponseDTO::new);
    }

    @Transactional
    public void excluirVenda(Long id) {
        VdCpLoja venda = vdCpLojaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Venda não encontrada"));

        vdCpLojaRepository.delete(venda);
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

    private StatusRastreio criarStatusInicial(VdCpLoja vdCpLoja) {
        StatusRastreio status = new StatusRastreio();
        status.setCentroDistribuicao("Aracaju");
        status.setEstado("SE");
        status.setStatus("ENTREGUE");
        status.setEmpresa(vdCpLoja.getEmpresa());
        status.setVdCpLoja(vdCpLoja);
        return status;
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
