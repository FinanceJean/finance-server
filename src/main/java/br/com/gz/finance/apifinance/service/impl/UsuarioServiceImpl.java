package br.com.gz.finance.apifinance.service.impl;

import br.com.gz.finance.apifinance.dto.AtivoUsuarioDto;
import br.com.gz.finance.apifinance.model.Acao;
import br.com.gz.finance.apifinance.model.Usuario;
import br.com.gz.finance.apifinance.model.modelDto.ChangeSenhaDto;
import br.com.gz.finance.apifinance.model.modelDto.RegisterDto;
import br.com.gz.finance.apifinance.repository.UsuarioRepository;
import br.com.gz.finance.apifinance.service.FinanceiroService;
import br.com.gz.finance.apifinance.service.UsuarioService;
import br.com.gz.finance.apifinance.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl extends CrudServiceImpl<Usuario, Long>
        implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final FinanceiroService financeiroService;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              FinanceiroService financeiroService) {
        this.usuarioRepository = usuarioRepository;
        this.financeiroService = financeiroService;
    }

    @Override
    protected JpaRepository<Usuario, Long> getRepository() {
        return usuarioRepository;
    }

    @Override
    public void saveRegister(RegisterDto registerDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(registerDto.getNome());
        usuario.setDtNascimento(DateUtil.parseStringToLocalDate(registerDto.getDtNascimento()));
        usuario.setEmail(registerDto.getEmail());
        usuario.setUsername(registerDto.getLogin());
        usuario.setPassword(new BCryptPasswordEncoder().encode(registerDto.getSenha()));
        usuario.setFinanceiro(financeiroService.createFinanceiroUsuario(registerDto.getPlano()));
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findUsuarioByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public boolean usernameExists(String username) {
        if (usuarioRepository.findByUsername(username) != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<AtivoUsuarioDto> findAtivosUsuario(String username) {
        Usuario u = usuarioRepository.findByUsername(username);
        return u.getAcoes().stream().map(acao -> new AtivoUsuarioDto().converterToDto(u.getId(), u.getUsername(), acao))
                .collect(Collectors.toList());
    }

    @Override
    public void saveAtivoUsuario(List<AtivoUsuarioDto> ativosUsuario) {
        if (ativosUsuario != null && ativosUsuario.size() > 0) {
            Usuario user;
            if (ativosUsuario.get(0).getIdUsuario() != null) {
                user = usuarioRepository.findById(ativosUsuario.get(0).getIdUsuario()).get();
            } else {
                user = usuarioRepository.findByUsername(ativosUsuario.get(0).getUsername());
            }
            List<Acao> a = removeAtivosExistentes(user.getAcoes(), ativosUsuario);
            user.setAcoes(a);
            usuarioRepository.save(user);
        }
    }

    @Override
    public void changeSenha(ChangeSenhaDto changeSenhaDto) {
        Usuario user = usuarioRepository.findByUsername(changeSenhaDto.getUsername());
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (bCryptPasswordEncoder.matches(changeSenhaDto.getSenhaAtual(), user.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(changeSenhaDto.getNovaSenha()));
            usuarioRepository.save(user);
        } else {
            throw new RuntimeException("A senha atual está incorreta");
        }
    }

    private List<Acao> removeAtivosExistentes(List<Acao> old, List<AtivoUsuarioDto> neww) {
        List<Acao> novasAcoes = new ArrayList<>();
        for (AtivoUsuarioDto ativoUsuarioDto : neww) {
            novasAcoes.add(ativoUsuarioDto.getAcao());
        }
        return novasAcoes;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario username = usuarioRepository.findByUsername(s);
        if (username == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return new User(username.getUsername(), username.getPassword(), Collections.emptyList());
    }
}
