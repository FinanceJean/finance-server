package br.com.gz.finance.apifinance.model.yahooApi;

import lombok.Data;

import java.util.List;

@Data
public class Chart {

    private List<Result> result;
    private String error;
}
