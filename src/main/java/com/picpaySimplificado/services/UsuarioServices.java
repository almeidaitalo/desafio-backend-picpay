package com.picpaySimplificado.services;

import com.picpaySimplificado.dtos.UsuarioDTO;
import com.picpaySimplificado.model.Usuario;
import com.picpaySimplificado.model.UsuarioTipo;
import com.picpaySimplificado.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepository repository;

    public void validarTransacao(Usuario remetente, BigDecimal value) throws Exception {
        if (remetente.getUsuarioTipo() == UsuarioTipo.logistas) {
            throw new Exception("Usuario do tipo Logista não está autorizado a realizar transação ");
        }
        if (remetente.getSaldo().compareTo(value) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }

    public Usuario findUsuarioById(Long id) throws Exception {
        return this.repository.findUsuarioByid(id).orElseThrow(() -> new Exception("Usuario não encontrado!"));
    }

    public Usuario createUsuario(UsuarioDTO data) {
        Usuario newUsuario = new Usuario(data);
        this.salveUsuario(newUsuario);
        return newUsuario;
    }
    public List<Usuario> getAllUsuario(){
      return this.repository.findAll();
    }
    public void salveUsuario(Usuario usuario) {
        this.repository.save(usuario);
    }
}
