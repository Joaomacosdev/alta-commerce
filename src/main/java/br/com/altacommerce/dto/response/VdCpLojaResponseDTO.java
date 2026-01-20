package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.CupomDesconto;
import br.com.altacommerce.model.FormaPagamento;
import br.com.altacommerce.model.NotaFiscalvenda;
import br.com.altacommerce.model.VdCpLoja;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record VdCpLojaResponseDTO(
        Long id,
        BigDecimal valorFrete,
        Integer diasEntrega,
        LocalDate dataVenda,
        LocalDate dataEntrega,
        BigDecimal valorTotal,
        BigDecimal valorDesconto,
        PessoaResponseDTO pessoa,
        FormaPagamentoResponseDTO formaPagamento,
        NotaFiscalVendaResponseDTO notaFiscalVenda,
        CupomDesconto cupomDesconto,
        PessoaJuridicaResponseDTO empresa,
        List<ItemVendaLojaResponseDTO> itens
) {
        public VdCpLojaResponseDTO(VdCpLoja vdCpLoja) {
                this(
                        vdCpLoja.getId(),
                        vdCpLoja.getValorFrete(),
                        vdCpLoja.getDiasEntrega(),
                        vdCpLoja.getDataVenda(),
                        vdCpLoja.getDataEntrega(),
                        vdCpLoja.getValorTotal(),
                        vdCpLoja.getValorDesconto(),
                        new PessoaResponseDTO(vdCpLoja.getPessoa()),
                        new FormaPagamentoResponseDTO(vdCpLoja.getFormaPagamento()),
                        new NotaFiscalVendaResponseDTO(vdCpLoja.getNotaFiscalvenda()),
                        vdCpLoja.getCupomDesconto(),
                        new PessoaJuridicaResponseDTO(vdCpLoja.getEmpresa()),
                        vdCpLoja.getItemVendaLojas()
                                .stream()
                                .map(ItemVendaLojaResponseDTO::new)
                                .toList()                );
        }

}
