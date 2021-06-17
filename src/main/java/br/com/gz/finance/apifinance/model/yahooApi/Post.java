package br.com.gz.finance.apifinance.model.yahooApi;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Post {

    private String timezone;
    private Integer start;
    private Integer end;
    private Integer gmtoffset;
}
