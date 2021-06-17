package br.com.gz.finance.apifinance.model.yahooApi;

import lombok.Data;

@Data
public class CurrentTradingPeriod {

    private Pre pre;
    private Regular regular;
    private Post post;
}
