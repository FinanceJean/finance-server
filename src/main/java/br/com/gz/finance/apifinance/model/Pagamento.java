package br.com.gz.finance.apifinance.model;

import br.com.gz.finance.apifinance.config.LocalDateTimeDeserializer;
import br.com.gz.finance.apifinance.config.LocalDateTimeSerializer;
import br.com.gz.finance.apifinance.ennumeration.Plano;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "PAGAMENTO")
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "PLANO", nullable = false)
    private Plano plano;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "DTSOLICITACAO")
    private LocalDateTime dtSolicitacao;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "DTPAGAMENTO")
    private LocalDateTime dtPagamento;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "financeiro_id", referencedColumnName = "id")
    private Financeiro financeiro;
}
