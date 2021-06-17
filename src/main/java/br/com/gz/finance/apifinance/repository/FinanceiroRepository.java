package br.com.gz.finance.apifinance.repository;

import br.com.gz.finance.apifinance.model.Financeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceiroRepository extends JpaRepository<Financeiro, Long> {
}
