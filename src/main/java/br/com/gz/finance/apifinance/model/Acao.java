package br.com.gz.finance.apifinance.model;

import br.com.gz.finance.apifinance.config.LocalDateTimeDeserializer;
import br.com.gz.finance.apifinance.config.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idAcao")
@Table(name = "ACAO")
public class Acao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SYMBOL", length = 10)
    private String symbol;

    @Column(name = "LONGNAME")
    private String longName;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "FIRSTTRADEDATE")
    private LocalDateTime firstTradeDate;

    @Column(name = "REGULARMARKETPREVIOUSCLOSE")
    private BigDecimal regularMarketPreviousClose;

    @Column(name = "REGULARMARKETCHANGEPERCENT")
    private BigDecimal regularMarketChangePercent;

    @Column(name = "REGULARMARKETCHANGE")
    private BigDecimal regularMarketChange;

    @Column(name = "REGULARMARKETPRICE")
    private BigDecimal regularMarketPrice;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "REGULARMARKETTIME")
    private LocalDateTime regularMarketTime;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Column(name = "ULTALTSYNC")
    private LocalDateTime ultAltSync;
}
