package com.picpaySimplificado.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="transacao")
@Table(name="transacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Transacao {
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

    }

