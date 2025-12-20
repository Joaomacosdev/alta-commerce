package br.com.altacommerce.service;

import br.com.altacommerce.dto.request.EnderecoRequestDTO;
import br.com.altacommerce.dto.request.PessoaJuridicaRequestDTO;
import br.com.altacommerce.dto.response.PessoaJuridicaResponseDTO;
import br.com.altacommerce.infra.exception.NotFoundException;
import br.com.altacommerce.model.Acesso;
import br.com.altacommerce.model.Endereco;
import br.com.altacommerce.model.PessoaJuridica;
import br.com.altacommerce.model.Usuario;
import br.com.altacommerce.model.enums.TipoPessoa;
import br.com.altacommerce.repository.AcessoRepository;
import br.com.altacommerce.repository.PessoaJuridicaRepository;
import br.com.altacommerce.repository.UsuarioRepository;
import br.com.altacommerce.service.validator.pessoaJuridica.ValidatorPessoaJuridica;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PessoaJuridicaService {

    private final PessoaJuridicaRepository pessoaJuridicaRepository;
    private final UsuarioRepository usuarioRepository;
    private final AcessoRepository acessoRepository;
    private final PasswordEncoder passwordEncoder;
    private final List<ValidatorPessoaJuridica> validators;
    private final EnderecoService enderecoService;
    private final EmailService emailService;


    public PessoaJuridicaService(PessoaJuridicaRepository pessoaJuridicaRepository, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, List<ValidatorPessoaJuridica> validators, AcessoRepository acessoRepository, EnderecoService enderecoService, EmailService emailService) {
        this.pessoaJuridicaRepository = pessoaJuridicaRepository;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.validators = validators;
        this.acessoRepository = acessoRepository;
        this.enderecoService = enderecoService;
        this.emailService = emailService;
    }

    @Transactional
    public PessoaJuridicaResponseDTO createPessoaJuridica(PessoaJuridicaRequestDTO dto) {
        validators.forEach(v -> v.validate(dto));

        PessoaJuridica pessoaJuridica = new PessoaJuridica(dto);
        pessoaJuridica.setTipoPessoa(TipoPessoa.JURIDICA);


        if (dto.enderecoRequestDTOS() != null && !dto.enderecoRequestDTOS().isEmpty()) {
            List<Endereco> enderecos = criarEnderecosPessoaJuridica(pessoaJuridica, dto.enderecoRequestDTOS());
            pessoaJuridica.setEnderecos(enderecos);
        }


        pessoaJuridicaRepository.save(pessoaJuridica);

        Usuario usuario = usuarioRepository.findByPessoaId(pessoaJuridica.getId())
                .orElseGet(() -> criarUsuarioParaPessoaJuridica(pessoaJuridica));
        usuarioRepository.save(usuario);


        return new PessoaJuridicaResponseDTO(pessoaJuridica);
    }

    private List<Endereco> criarEnderecosPessoaJuridica(PessoaJuridica pessoa, List<EnderecoRequestDTO > dtos){
        return dtos.stream()
                .map(dto ->
                    enderecoService.criarEnderecoComCep(pessoa, dto)
                ).toList();
    }



    private Usuario criarUsuarioParaPessoaJuridica(PessoaJuridica pessoa) {
        Usuario usuario = new Usuario();
        usuario.setDataAtualSenha(LocalDate.now());
        usuario.setEmpresa(pessoa);
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
