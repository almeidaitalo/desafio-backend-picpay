package com.picpaySimplificado.controllers;

import com.picpaySimplificado.dtos.UsuarioDTO;
import com.picpaySimplificado.model.Usuario;
import com.picpaySimplificado.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/user")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(UsuarioDTO usuarioDTO){
       Usuario newUsuario = usuarioServices.createUsuario(usuarioDTO);
       return new ResponseEntity<>(newUsuario, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario(){
        List<Usuario> usuario = this.usuarioServices.getAllUsuario();
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

}
