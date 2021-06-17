package br.com.gz.finance.apifinance.repository;

import br.com.gz.finance.apifinance.model.Acao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcaoRepository extends JpaRepository<Acao, Long> {

    List<Acao> findTop10BySymbolLike(String query);

    Acao findAcaoBySymbolEquals(String simbolo);
}
