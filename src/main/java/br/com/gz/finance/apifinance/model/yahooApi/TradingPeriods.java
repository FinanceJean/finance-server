package br.com.gz.finance.apifinance.model.yahooApi;

import lombok.Data;

@Data
public class TradingPeriods {

    private String timezone;
    private Integer start;
    private Integer end;
    private Integer gmtoffset;
}
