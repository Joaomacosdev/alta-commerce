package br.com.altacommerce.model.enums;

public enum TipoUnidade {
    UNIDADE("UN", "Unidade"),
    PECA("PC", "Peça"),

    CAIXA("CX", "Caixa"),
    PACOTE("PCT", "Pacote"),
    FARDO("FD", "Fardo"),
    KIT("KT", "Kit"),

    QUILOGRAMA("KG", "Quilograma"),
    GRAMA("G", "Grama"),

    LITRO("L", "Litro"),
    MILILITRO("ML", "Mililitro"),

    METRO("M", "Metro"),
    METRO_QUADRADO("M2", "Metro Quadrado"),

    PALETE("PAL", "Palete");

    private final String codigo;
    private final String descricao;

    TipoUnidade(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
