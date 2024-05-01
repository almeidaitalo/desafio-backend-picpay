package com.picpaySimplificado.dtos;

import com.picpaySimplificado.model.UsuarioTipo;

import java.math.BigDecimal;

public record UsuarioDTO(String nome, String sobrenome, String cpf, BigDecimal saldo, String email, String password, UsuarioTipo usuarioTipo) {
}
