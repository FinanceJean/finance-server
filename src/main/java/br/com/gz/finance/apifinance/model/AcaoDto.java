package br.com.gz.finance.apifinance.model;

import br.com.gz.finance.apifinance.config.LocalDateTimeDeserializer;
import br.com.gz.finance.apifinance.config.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcaoDto {

    private String simbolo;
    private BigDecimal preco;
    private BigDecimal percentual;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime ultAltCotacao;
}
