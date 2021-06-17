package br.com.gz.finance.apifinance.model.modelDto;

import br.com.gz.finance.apifinance.ennumeration.Plano;
import lombok.Data;

@Data
public class RegisterDto {

    private String nome;
    private String email;
    private String dtNascimento;
    private Plano plano;
    private String login;
    private String senha;
}
