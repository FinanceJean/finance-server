package br.com.gz.finance.apifinance.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// TODO: 28/09/2020 será implementado posteriormente

@Data
public class HistoricoAcao {

    private LocalDateTime horario;
    private BigDecimal open;
    private BigDecimal low;
    private Integer volume;
    private BigDecimal high;
    private BigDecimal close;
}
