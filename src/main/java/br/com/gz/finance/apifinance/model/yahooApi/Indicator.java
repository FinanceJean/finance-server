package br.com.gz.finance.apifinance.model.yahooApi;

import lombok.Data;

import java.util.List;

@Data
public class Indicator {

    private List<Quote> quote;
}
