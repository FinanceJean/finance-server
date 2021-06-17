package br.com.gz.finance.apifinance.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "KEY")
@AllArgsConstructor
@NoArgsConstructor
public class Key {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KEY")
    private String key;

    @Column(name = "DTCRIACAO")
    private LocalDateTime dtCriacao;

    @Column(name = "DTVALIDADE")
    private LocalDateTime dtValidade;

    @Column(name = "IPADDRESS")
    private String ipAddress;

    @Column(name = "MACADDRESS")
    private String macAddress;

    @OneToOne(mappedBy = "key")
    @JsonBackReference
    private Usuario usuario;
}
