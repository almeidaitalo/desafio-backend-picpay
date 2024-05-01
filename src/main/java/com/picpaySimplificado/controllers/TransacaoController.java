package com.picpaySimplificado.controllers;

import com.picpaySimplificado.dtos.TransacaoDTO;
import com.picpaySimplificado.model.Transacao;
import com.picpaySimplificado.services.TransacaoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoServices transacaoServices;

    @PostMapping
    public ResponseEntity<Transacao> createTransacao(@RequestBody TransacaoDTO transacaoDTO) throws Exception{
        Transacao newTransacacao = this.transacaoServices.createTransacao(transacaoDTO);
        return new ResponseEntity<>(newTransacacao, HttpStatus.OK);


    }


}
