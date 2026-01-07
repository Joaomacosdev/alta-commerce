package br.com.altacommerce.dto.response;

import br.com.altacommerce.model.NotaFiscalCompra;

import java.math.BigDecimal;
import java.time.LocalDate;

public record NotaFiscalCompraResponseDTO(
        Long id,
        String serieNota,
        String descricaoObs,
        BigDecimal valorTotal,
        BigDecimal valorDesconto,
        BigDecimal valorIcms,
        BigDecimal valorFinal,
        LocalDate dataCompra,
        PessoaResponseDTO pessoa,
        ContaPagarResponseDTO contaPagar,
        PessoaJuridicaResponseDTO empresa
) {
    public NotaFiscalCompraResponseDTO(NotaFiscalCompra notaFiscalCompra) {
        this(
                notaFiscalCompra.getId(),
                notaFiscalCompra.getSerieNota(),
                notaFiscalCompra.getDescricaoObs(),
                notaFiscalCompra.getValorTotal(),
                notaFiscalCompra.getValorDesconto(),
                notaFiscalCompra.getValorIcms(),
                notaFiscalCompra.getValorFinal(),
                notaFiscalCompra.getDataCompra(),
                new PessoaResponseDTO(notaFiscalCompra.getPessoa()),
                new ContaPagarResponseDTO(notaFiscalCompra.getContaPagar()),
                new PessoaJuridicaResponseDTO(notaFiscalCompra.getEmpresa())
        );
    }
}
