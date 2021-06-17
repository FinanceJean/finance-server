package br.com.gz.finance.apifinance.service;

import br.com.gz.finance.apifinance.dto.AtivoUsuarioDto;
import br.com.gz.finance.apifinance.model.Usuario;
import br.com.gz.finance.apifinance.model.modelDto.ChangeSenhaDto;
import br.com.gz.finance.apifinance.model.modelDto.RegisterDto;

import java.util.List;

public interface UsuarioService extends CrudService<Usuario, Long> {

    void saveRegister(RegisterDto registerDto);

    Usuario findUsuarioByUsername(String username);

    boolean usernameExists(String username);

    List<AtivoUsuarioDto> findAtivosUsuario(String username);

    void saveAtivoUsuario(List<AtivoUsuarioDto> ativosUsuario);

    void changeSenha(ChangeSenhaDto changeSenhaDto);
}
