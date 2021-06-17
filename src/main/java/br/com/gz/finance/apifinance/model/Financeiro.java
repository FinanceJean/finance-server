package br.com.gz.finance.apifinance.model;

import br.com.gz.finance.apifinance.ennumeration.Plano;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "FINANCEIRO")
public class Financeiro {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "PLANOATUAL")
    private Plano planoAtual;

    @OneToMany(mappedBy = "financeiro",
            cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Pagamento> pagamentoList;

    @OneToOne(mappedBy = "financeiro")
    @JsonBackReference
    private Usuario usuario;
}
