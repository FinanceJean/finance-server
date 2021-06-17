package br.com.gz.finance.apifinance.model.yahooApiV7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private String symbol;
    private String longName;
    private BigDecimal regularMarketPrice;
    private BigDecimal regularMarketChangePercent;
    private BigDecimal regularMarketChange;
    private BigDecimal regularMarketPreviousClose;
    private Long regularMarketTime;
    private Long firstTradeDateMilliseconds;
}
