package br.com.altacommerce.infra.exception.handle;

import br.com.altacommerce.infra.exception.BusinessException;
import br.com.altacommerce.infra.exception.ExceptionResponse;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.util.SqlErrorSanitizer;
import jakarta.persistence.PersistenceException;
import org.hibernate.HibernateException;
import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.time.Instant;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomEntityResponseHandle {

    /*==============================================================
     | 500 – INTERNAL SERVER ERROR (QUALQUER ERRO NÃO TRATADO)
     ==============================================================*/
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAllExceptions(
            Exception ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    /*==============================================================
     | 400 – BAD REQUEST (ERROS DE VALIDAÇÃO)
     ==============================================================*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(
            MethodArgumentNotValidException ex) {

        String errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                "Erro de validação",
                errors
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /*==============================================================
     | 401 – UNAUTHORIZED (ERROS DE LOGIN / CREDENCIAIS)
     ==============================================================*/
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleBadCredentials(
            Exception ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                "Usuário inexistente ou senha inválida!",
                request.getDescription(false)
        );

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    /*==============================================================
     | 404 – NOT FOUND
     ==============================================================*/
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFound(
            NotFoundException ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /*==============================================================
     | 409 – CONFLICT (REGRAS DE NEGÓCIO / DUPLICIDADE)
     ==============================================================*/
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> handleBusiness(
            BusinessException ex) {

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                ex.getMessage(),
                "Operação não pôde ser concluída devido a conflito"
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> handleDataIntegrityViolation(
            DataIntegrityViolationException ex) {

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                "Violação de integridade no banco de dados",
                "Verifique se os dados enviados já existem ou estão sendo utilizados"
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    /*==============================================================
     | 400–500 – ERROS SQL/JDBC/HIBERNATE
     ==============================================================*/

    // Hibernate genérico
    @ExceptionHandler(HibernateException.class)
    public ResponseEntity<ExceptionResponse> handleHibernateException(
            HibernateException ex) {

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                "Erro interno ao executar operação no banco via Hibernate",
                ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    // JPA Persistence
    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<ExceptionResponse> handlePersistence(
            PersistenceException ex) {

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                "Erro de persistência no banco de dados",
                ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // JDBC genérico
    @ExceptionHandler(GenericJDBCException.class)
    public ResponseEntity<ExceptionResponse> handleGenericJdbc(
            GenericJDBCException ex) {

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                "Erro ao executar consulta no banco de dados (JDBC)",
                ex.getSQLException().getMessage()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // SQL Exception geral
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ExceptionResponse> handleSqlException(
            SQLException ex) {

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                "Erro ao acessar o banco de dados",
                "Falha ao executar operação no banco de dados"
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    // Spring — SQL inválido
    @ExceptionHandler(BadSqlGrammarException.class)
    public ResponseEntity<ExceptionResponse> handleBadSql(
            BadSqlGrammarException ex) {

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                "Erro interno ao processar a consulta SQL",
                "A operação não pôde ser concluída por erro de sintaxe ou consulta inválida"
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Hibernate — SQL inválido
    @ExceptionHandler(SQLGrammarException.class)
    public ResponseEntity<ExceptionResponse> handleHibernateSqlGrammar(
            SQLGrammarException ex) {

        String rawMessage = ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage();
        String details = SqlErrorSanitizer.sanitize(rawMessage);

        ExceptionResponse response = new ExceptionResponse(
                Instant.now(),
                "Erro de sintaxe SQL detectado",
                details
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
