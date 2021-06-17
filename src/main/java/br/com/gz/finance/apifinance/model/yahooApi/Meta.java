package br.com.gz.finance.apifinance.model.yahooApi;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
public class Meta {

    private String currency;
    private String symbol;
    private String exchangeName;
    private String instrumentType;
    private Integer firstTradeDate;
    private Integer regularMarketTime;
    private Integer gmtoffset;
    private String timezone;
    private String exchangeTimezoneName;
    private BigDecimal regularMarketPrice;
    private BigDecimal chartPreviousClose;
    private BigDecimal previousClose;
    private Integer scale;
    private Integer priceHint;
    private CurrentTradingPeriod currentTradingPeriod;
    private List<List<TradingPeriods>> tradingPeriods;
    private String dataGranularity;
    private String range;
    private List<String> validRanges;
}
