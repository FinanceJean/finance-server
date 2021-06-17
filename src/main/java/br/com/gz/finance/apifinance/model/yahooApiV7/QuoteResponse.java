package br.com.gz.finance.apifinance.model.yahooApiV7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteResponse {

    private List<Result> result;
    private String error;
}
