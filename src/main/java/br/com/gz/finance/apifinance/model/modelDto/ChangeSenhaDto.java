package br.com.gz.finance.apifinance.model.modelDto;

import lombok.Data;

@Data
public class ChangeSenhaDto {

    private String username;
    private String senhaAtual;
    private String novaSenha;
    private String confirmacaoNovaSenha;
}
