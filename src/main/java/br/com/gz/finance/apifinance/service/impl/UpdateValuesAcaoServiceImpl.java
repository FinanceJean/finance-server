package br.com.gz.finance.apifinance.service.impl;

import static br.com.gz.finance.apifinance.util.Utils.getLocalDateTime;

import br.com.gz.finance.apifinance.model.Acao;
import br.com.gz.finance.apifinance.model.yahooApiV7.Result;
import br.com.gz.finance.apifinance.model.yahooApiV7.YahooAPI;
import br.com.gz.finance.apifinance.service.AcaoService;
import br.com.gz.finance.apifinance.service.UpdateValuesAcaoService;
import br.com.gz.finance.apifinance.service.YahooFinanceApiService;
import br.com.gz.finance.apifinance.util.CotacaoUtil;
import br.com.gz.finance.apifinance.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UpdateValuesAcaoServiceImpl implements UpdateValuesAcaoService {

    @Autowired
    private YahooFinanceApiService yahooFinanceApiService;

    @Autowired
    private AcaoService acaoService;

    private static Logger log = Logger.getLogger(UpdateValuesAcaoServiceImpl.class.getSimpleName());

    @Override
    public void updateValuesInBd(String[] ativosToUpdate) {
        log.log(Level.INFO, "<<< Iniciando atualização dos ativos ".concat(getLocalDateTime()).concat(" >>>"));
        YahooAPI cotacoes = yahooFinanceApiService.findCotacaoBySymbolV7(ativosToUpdate);

        if (Objects.nonNull(cotacoes) && Objects.nonNull(cotacoes.getQuoteResponse())) {
            cotacoes.getQuoteResponse().getResult().forEach(result -> parseYahooApiToBd(result));
        }

        log.log(Level.INFO, "<<< Ativos atualizados ".concat(getLocalDateTime()).concat(" >>>"));
    }

    @Transactional
    public void parseYahooApiToBd(Result result) {
        if (Objects.isNull(result))
            return;

        log.log(Level.INFO, "<<< Salvando ativo ".concat(result.getSymbol()).concat(" >>>"));

        Acao acao = acaoService.findAcaoBySymbol(CotacaoUtil.removeSAInSymbol(result.getSymbol()));
        if (Objects.isNull(acao)) {
            acao = new Acao();
            acao.setLongName(result.getLongName());
            acao.setSymbol(CotacaoUtil.removeSAInSymbol(CotacaoUtil.removeSAInSymbol(result.getSymbol())));
            acao.setFirstTradeDate(DateUtil.transformMillisToLocalDateTime(result.getFirstTradeDateMilliseconds()));
        }

        acao.setRegularMarketPrice(result.getRegularMarketPrice());
        acao.setRegularMarketPreviousClose(result.getRegularMarketPreviousClose());
        acao.setRegularMarketChange(result.getRegularMarketChange());
        acao.setRegularMarketChangePercent(result.getRegularMarketChangePercent());
        acao.setRegularMarketTime(DateUtil.transformLongToLocalDateTime(result.getRegularMarketTime()));
        acao.setUltAltSync(LocalDateTime.now());
        acaoService.save(acao);
    }
}
