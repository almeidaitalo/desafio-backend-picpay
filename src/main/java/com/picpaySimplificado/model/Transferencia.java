package com.picpaySimplificado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity(name="transferencia")
@Table(name="transferencia")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name="remetente_id")
    private Usuario remetente;
    @ManyToOne
    @JoinColumn(name="recptor_id")
    private Usuario recptor;

    private LocalDateTime timestamp;
    public Transferencia() {

    }
}
