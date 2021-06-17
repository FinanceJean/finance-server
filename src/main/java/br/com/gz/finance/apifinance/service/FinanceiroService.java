package br.com.gz.finance.apifinance.service;

import br.com.gz.finance.apifinance.ennumeration.Plano;
import br.com.gz.finance.apifinance.model.Financeiro;

public interface FinanceiroService extends CrudService<Financeiro, Long> {

    Financeiro createFinanceiroUsuario(Plano plano);
}
