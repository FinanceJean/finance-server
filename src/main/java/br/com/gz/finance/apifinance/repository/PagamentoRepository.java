package br.com.gz.finance.apifinance.repository;

import br.com.gz.finance.apifinance.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
