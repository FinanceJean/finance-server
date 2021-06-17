package br.com.gz.finance.apifinance.service;

import br.com.gz.finance.apifinance.model.Acao;
import br.com.gz.finance.apifinance.model.AcaoDto;

import java.util.List;

public interface AcaoService extends CrudService<Acao, Long> {

    Acao findAcaoBySymbol(String symbol);

    List<Acao> complete(String query);

    List<AcaoDto> findAllAcaoByUsuario(String username);
}
