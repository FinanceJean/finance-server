package br.com.gz.finance.apifinance.service;

import br.com.gz.finance.apifinance.ennumeration.Plano;
import br.com.gz.finance.apifinance.model.Financeiro;
import br.com.gz.finance.apifinance.model.Pagamento;
import br.com.gz.finance.apifinance.model.Usuario;

public interface PagamentoService extends CrudService<Pagamento, Long> {

    Pagamento createPagamentoInicialUsuario(Financeiro financeiro);
}
