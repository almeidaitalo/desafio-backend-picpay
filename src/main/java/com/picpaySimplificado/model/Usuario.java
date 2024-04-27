package com.picpaySimplificado.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name ="usu_usuario")
@Table(name="usu_usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String nome;

 private String sobrenome;

 @Column(unique = true)
 private String Cpf;

 @Column(unique = true)
 private String email;

 private String password;

 private BigDecimal saldo;

 @Enumerated(EnumType.STRING)
 private UsuarioTipo usuarioTipo;

 }
