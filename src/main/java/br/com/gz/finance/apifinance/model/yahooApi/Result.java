package br.com.gz.finance.apifinance.model.yahooApi;

import lombok.Data;

import java.util.List;

@Data
public class Result {

    private Meta meta;
    private List<Integer> timestamp;
    private Indicator indicators;
}
