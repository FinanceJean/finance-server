package br.com.gz.finance.apifinance.service.impl;

import br.com.gz.finance.apifinance.ennumeration.Plano;
import br.com.gz.finance.apifinance.model.Financeiro;
import br.com.gz.finance.apifinance.repository.FinanceiroRepository;
import br.com.gz.finance.apifinance.service .FinanceiroService;
import br.com.gz.finance.apifinance.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class FinanceiroServiceImpl extends CrudServiceImpl<Financeiro, Long>
        implements FinanceiroService {

    private final FinanceiroRepository financeiroRepository;
    private final PagamentoService pagamentoService;

    @Autowired
    public FinanceiroServiceImpl(FinanceiroRepository financeiroRepository,
                                 PagamentoService pagamentoService) {
        this.financeiroRepository = financeiroRepository;
        this.pagamentoService = pagamentoService;
    }

    @Override
    protected JpaRepository<Financeiro, Long> getRepository() {
        return financeiroRepository;
    }

    @Override
    public Financeiro createFinanceiroUsuario(Plano plano) {
        Financeiro financeiro = new Financeiro();
        financeiro.setPlanoAtual(plano);
        financeiro.setPagamentoList(Arrays.asList(pagamentoService.createPagamentoInicialUsuario(financeiro)));
        return financeiro;
    }
}
