package br.com.gz.finance.apifinance.service.impl;

import br.com.gz.finance.apifinance.ennumeration.Plano;
import br.com.gz.finance.apifinance.model.Financeiro;
import br.com.gz.finance.apifinance.model.Pagamento;
import br.com.gz.finance.apifinance.model.Usuario;
import br.com.gz.finance.apifinance.repository.PagamentoRepository;
import br.com.gz.finance.apifinance.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PagamentoServiceImpl extends CrudServiceImpl<Pagamento, Long>
    implements PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoServiceImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    protected JpaRepository<Pagamento, Long> getRepository() {
        return pagamentoRepository;
    }

    @Override
    public Pagamento createPagamentoInicialUsuario(Financeiro financeiro) {
        Pagamento pagamento = new Pagamento();
        pagamento.setDtSolicitacao(LocalDateTime.now());
        pagamento.setPlano(financeiro.getPlanoAtual());
        pagamento.setFinanceiro(financeiro);
        return pagamento;
    }
}
