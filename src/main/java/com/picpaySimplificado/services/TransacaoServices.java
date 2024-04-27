package com.picpaySimplificado.services;


import com.picpaySimplificado.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoServices {
   @Autowired
   private UsuarioServices usuarioServices;

   @Autowired
   private TransacaoRepository repository;
   
}
