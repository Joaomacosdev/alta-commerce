package br.com.altacommerce.controller;

import br.com.altacommerce.model.Acesso;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AcessoControllerTest {


    @Autowired
    private AcessoController acessoController;

    @Nested
    class CadastrarAcesso {

        @DisplayName("Então deve executar com sucesso")
        @Nested
        class Sucesso {

            @DisplayName("Dado um acesso com todos os campos")
            @Test
            @Transactional
            void teste1() {

                // ARRANGE
                Acesso acesso = new Acesso();
                acesso.setDescricao("ROLE_TESTE");

                // ACT
                Acesso salvo = acessoController.createAcesso(acesso);

                // ASSERT
                assertNotNull(salvo.getId(), "ID não pode ser nulo após salvar");
                assertEquals("ROLE_TESTE", salvo.getDescricao());
            }
        }
    }

}