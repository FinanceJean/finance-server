package br.com.gz.finance.apifinance.service;

import br.com.gz.finance.apifinance.model.yahooApi.Result;
import br.com.gz.finance.apifinance.model.yahooApi.YahooApi;
import br.com.gz.finance.apifinance.model.yahooApiV7.QuoteResponse;
import br.com.gz.finance.apifinance.model.yahooApiV7.YahooAPI;

public interface YahooFinanceApiService {

    @Deprecated
    YahooApi findCotacaoBySymbol(String symbol);

    YahooAPI findCotacaoBySymbolV7(String[] symbols);
}
