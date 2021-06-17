package br.com.gz.finance.apifinance.service.impl;

import br.com.gz.finance.apifinance.model.yahooApi.YahooApi;
import br.com.gz.finance.apifinance.model.yahooApiV7.YahooAPI;
import br.com.gz.finance.apifinance.service.YahooFinanceApiService;
import br.com.gz.finance.apifinance.util.CotacaoUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class YahooFinanceApiServiceImpl implements YahooFinanceApiService {

    private static final String URL_BASE_YAHOO_V7 = "https://query1.finance.yahoo.com/v7/finance/quote?lang=pt-BR&region=US&corsDomain=finance.yahoo.com&symbols=%S";

    private static final String URL_BASE_YAHOO_V8 = "https://query1.finance.yahoo.com/v8/finance/chart/%s?region=US&lang=pt-BR&includePrePost=false&interval=15m&range=1d&corsDomain=finance.yahoo.com&.tsrc=finance";

    private static Logger log = Logger.getLogger(YahooFinanceApiServiceImpl.class.getSimpleName());

    @Override
    public YahooApi findCotacaoBySymbol(String symbol) {
        try {
            String url = String.format(URL_BASE_YAHOO_V8, symbol);
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForEntity(new URI(url), YahooApi.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public YahooAPI findCotacaoBySymbolV7(String[] symbols) {
        try {
            log.log(Level.INFO, "<<< Buscando ativos >>>");
            String url = String.format(URL_BASE_YAHOO_V7, CotacaoUtil.parseArrayToString(symbols));
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForEntity(new URI(url), YahooAPI.class).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
