package com.picpaySimplificado.model;

import com.picpaySimplificado.dtos.UsuarioDTO;
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
 private String cpf;

 @Column(unique = true)
 private String email;

 private String password;

 private BigDecimal saldo;

 @Enumerated(EnumType.STRING)
 private UsuarioTipo usuarioTipo;

 public Usuario (UsuarioDTO data){
   this.nome = data.nome();
   this.sobrenome = data.sobrenome();
   this.saldo =  data.saldo();
   this.usuarioTipo = data.usuarioTipo();
   this.password = data.password();
   this.cpf = data.cpf();
   this.email = data.email();

 }

 }
