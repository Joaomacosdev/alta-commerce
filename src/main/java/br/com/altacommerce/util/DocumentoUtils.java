package br.com.altacommerce.util;

public final class DocumentoUtils {

    private DocumentoUtils() {}

    public static String somenteNumeros(String valor) {
        if (valor == null) return null;
        return valor.replaceAll("\\D", "");
    }
}
