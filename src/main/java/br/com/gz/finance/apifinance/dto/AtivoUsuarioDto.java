package br.com.gz.finance.apifinance.dto;

import br.com.gz.finance.apifinance.model.Acao;
import lombok.Data;

@Data
public class AtivoUsuarioDto {

    private Long idUsuario;
    private String username;
    private Acao acao;

    public AtivoUsuarioDto converterToDto(Long idUsuario, String username, Acao acao) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.acao = acao;
        return this;
    }
}
