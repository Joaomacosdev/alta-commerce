package br.com.altacommerce.service;

import br.com.altacommerce.model.Acesso;
import br.com.altacommerce.repository.AcessoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AcessoServiceTest {
    @Autowired
    private AcessoService acessoService;

    @Autowired
    private AcessoRepository acessoRepository;

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
                Acesso salvo = acessoService.createAcesso(acesso);

                // ASSERT
                assertNotNull(salvo.getId(), "ID não pode ser nulo após salvar");
                assertEquals("ROLE_TESTE", salvo.getDescricao());
                assertTrue(acessoRepository.findById(salvo.getId()).isPresent());
            }
        }
    }
}