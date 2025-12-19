package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.EnderecoRequestDTO;
import br.com.altacommerce.dto.request.PessoaFisicaRequestDTO;
import br.com.altacommerce.dto.response.PessoaFisicaResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.Acesso;
import br.com.altacommerce.model.Endereco;
import br.com.altacommerce.model.PessoaFisica;
import br.com.altacommerce.model.Usuario;
import br.com.altacommerce.model.enums.TipoPessoa;
import br.com.altacommerce.repository.AcessoRepository;
import br.com.altacommerce.repository.PessoaFisicaRepository;
import br.com.altacommerce.repository.UsuarioRepository;
import br.com.altacommerce.service.validator.pessoaFisica.ValidatorPessoaFisica;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PessoaFisicaService {

    private final PessoaFisicaRepository pessoaFisicaRepository;
    private final UsuarioRepository usuarioRepository;
    private final AcessoRepository acessoRepository;
    private final List<ValidatorPessoaFisica> validators;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public PessoaFisicaService(PessoaFisicaRepository pessoaFisicaRepository, UsuarioRepository usuarioRepository, AcessoRepository acessoRepository, List<ValidatorPessoaFisica> validators, PasswordEncoder passwordEncoder, EmailService emailService) {
        this.pessoaFisicaRepository = pessoaFisicaRepository;
        this.usuarioRepository = usuarioRepository;
        this.acessoRepository = acessoRepository;
        this.validators = validators;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    @Transactional
    public PessoaFisicaResponseDTO createPessoaFisica(PessoaFisicaRequestDTO dto) {

        validators.forEach(v -> v.validate(dto));

        PessoaFisica pessoaFisica = new PessoaFisica(dto);
        pessoaFisica.setTipoPessoa(TipoPessoa.FISICA);

        if (dto.enderecoRequestDTOS() != null && !dto.enderecoRequestDTOS().isEmpty()){
            List<Endereco> enderecos = criarEnderecosPessoaFisica(pessoaFisica, dto.enderecoRequestDTOS());
            pessoaFisica.setEnderecos(enderecos);
        }


        pessoaFisicaRepository.save(pessoaFisica);

        Usuario usuario = usuarioRepository.findById(pessoaFisica.getId())
                .orElseGet(() -> criarUsuarioParaPessoaFisica(pessoaFisica));
        usuarioRepository.save(usuario);

        return new PessoaFisicaResponseDTO(pessoaFisica);
    }


    private List<Endereco> criarEnderecosPessoaFisica(PessoaFisica pessoaFisica, List<EnderecoRequestDTO> enderecoDTOS) {
        if (enderecoDTOS == null || enderecoDTOS.isEmpty()) {
            return new ArrayList<>();
        }

        List<Endereco> enderecos = enderecoDTOS.stream()
                .map(dto -> {
                    Endereco endereco = new Endereco(dto);
                    endereco.setPessoa(pessoaFisica);
                    return endereco;
                }).toList();

        return new ArrayList<>(enderecos);
    }

    private Usuario criarUsuarioParaPessoaFisica(PessoaFisica pessoa) {
        Usuario usuario = new Usuario();
        usuario.setPessoa(pessoa);
        usuario.setDataAtualSenha(LocalDate.now());
        usuario.setPessoa(pessoa);
        usuario.setLogin(pessoa.getEmail());

        String senhaGerada = gerarSenhaSegura();
        usuario.setSenha(passwordEncoder.encode(senhaGerada));

        Acesso acessoPadrao = acessoRepository.findByDescricao("ROLE_USER")
                .orElseThrow(() -> new NotFoundException("Acesso padrão ROLE_USER não encontrado"));
        usuario.getAcessos().add(acessoPadrao);


        emailService.enviarEmailVerificacao(usuario, senhaGerada);

        return usuario;

    }

    private String gerarSenhaSegura() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10); // senha de 10 caracteres
    }
}
