package com.picpaySimplificado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity(name = "usu_usuario")
@Table(name="usu_usuario")
@Getter
@Setter
@AllArgsConstructor
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

 public Usuario() {

 }
}
