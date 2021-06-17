package br.com.gz.finance.apifinance.controller;

import br.com.gz.finance.apifinance.dto.AtivoUsuarioDto;
import br.com.gz.finance.apifinance.model.Usuario;
import br.com.gz.finance.apifinance.model.modelDto.ChangeSenhaDto;
import br.com.gz.finance.apifinance.model.modelDto.RegisterDto;
import br.com.gz.finance.apifinance.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("valid-username-exists/{username}")
    public boolean usuarioExists(@PathVariable("username") String username) {
        return usuarioService.usernameExists(username);
    }

    @PostMapping("register")
    public void saveRegister(@RequestBody RegisterDto registerDto) {
        usuarioService.saveRegister(registerDto);
        System.out.println("meuzovo");
    }

    @GetMapping("find-dados-user/{username}")
    public Usuario findDadosUsuario(@PathVariable("username") String username) {
        return usuarioService.findUsuarioByUsername(username);
    }

    @GetMapping("find-dados-gerais-usuario/{username}")
    public Usuario findDadosGeraisUsuario(@PathVariable("username") String username) {
        return usuarioService.findUsuarioByUsername(username);
    }

    @PostMapping("save-dados-gerais")
    public void saveDadosGerais(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
    }

    @GetMapping("find-ativos-usuario/{username}")
    public List<AtivoUsuarioDto> findAtivosUsuario(@PathVariable("username") String username) {
        return usuarioService.findAtivosUsuario(username);
    }

    @PostMapping("save-ativos-usuario")
    public void saveAtivosUsuario(@RequestBody List<AtivoUsuarioDto> ativosUsuario) {
        usuarioService.saveAtivoUsuario(ativosUsuario);
    }

    @PostMapping("change-senha")
    public void changeSenha(@RequestBody ChangeSenhaDto changeSenhaDto) {
        usuarioService.changeSenha(changeSenhaDto);
    }

    @GetMapping("/user-info")
    public Principal principal(Principal principal) {
        return principal;
    }
}
