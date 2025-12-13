package br.com.altacommerce.util;

public class SqlErrorSanitizer {

    private SqlErrorSanitizer() {
    }

    public static String sanitize(String message) {

        if (message == null) return "Erro desconhecido na consulta SQL";

        String lower = message.toLowerCase();

        // Casos PostgreSQL: tabela ou coluna inexistente
        if (message.contains("does not exist")) {
            return "Alguma coluna ou tabela informada na consulta não existe. Detalhes: " + message;
        }

        if (lower.contains("syntax error")) {
            return "Há um erro de sintaxe na consulta SQL. Detalhes: " + message;
        }

        if (lower.contains("invalid input syntax")) {
            return "Valor informado possui um tipo inválido para o banco de dados. Detalhes: " + message;
        }

        // Esconde partes sensíveis do SQL
        if (lower.contains("select") || lower.contains("insert") || lower.contains("update")) {
            return "A consulta SQL gerada é inválida ou contém erros de sintaxe.";
        }

        // Padrão
        return message;
    }
}