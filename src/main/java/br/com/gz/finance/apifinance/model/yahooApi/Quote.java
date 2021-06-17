package br.com.gz.finance.apifinance.model.yahooApi;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Quote {

    List<BigDecimal> high;
    List<BigDecimal> open;
    List<BigDecimal> low;
    List<BigDecimal> volume;
    List<BigDecimal> close;
}
