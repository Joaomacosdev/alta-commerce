package br.com.altacommerce.dto.request;

import br.com.altacommerce.model.enums.TipoUnidade;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public record ProdutoRequestDTO(
        @NotNull(message = "O tipo da unidade é obrigatório")
        TipoUnidade tipoUnidade,
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @NotBlank(message = "A descrição é obrigatória")
        @Size( min = 10,max = 2000, message = "A descrição deve ter no mínimo 10 caracteres")
        String descricao,
        @NotNull(message = "O peso é obrigatório")
        @Positive(message = "O peso deve ser maior que zero")
        Double peso,
        @NotNull(message = "A largura é obrigatória")
        @Positive(message = "A largura deve ser maior que zero")
        Double largura,
        @NotNull(message = "A altura é obrigatória")
        @Positive(message = "A altura deve ser maior que zero")
        Double altura,
        @NotNull(message = "A profundidade é obrigatória")
        @Positive(message = "A profundidade deve ser maior que zero")
        Double profundidade,
        @NotNull(message = "O valor de venda é obrigatório")
        @DecimalMin(value = "0.01", message = "O valor de venda deve ser maior que zero")
        BigDecimal valorVenda,
        @NotNull(message = "A quantidade em estoque é obrigatória")
        @Min(value = 0, message = "A quantidade em estoque não pode ser negativa")
        Integer qtdEstoque,
        @Min(value = 0, message = "A quantidade de alerta não pode ser negativa")
        Integer qtdAlertaEstoque,
        @Size(max = 255, message = "O link do YouTube deve ter no máximo 255 caracteres")
        String linkyoutube,
        Boolean alertaQtdEstoque,

        Boolean ativo,

        @NotNull(message = "As imagens são obrigatórias")
        @Size(min = 3, max = 6, message = "O produto deve ter entre 3 e 6 imagens")
        @Valid
        List<ImagemProdutoRequestDTO> imagens,

        @NotNull(message = "A empresa é obrigatória")
        Long empresaId,
        @NotNull(message = "A Categoria do produto é obrigatória")
        Long categoriaProdutoId,
        @NotNull(message = "A Marca do produto é obrigatória")
        Long marcaProdutoId,
        @NotNull(message = "A Nota do produto é obrigatória")
        Long notaItemProduto
) {
}
