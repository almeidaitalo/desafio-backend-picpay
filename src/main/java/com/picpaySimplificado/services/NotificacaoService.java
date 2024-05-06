package com.picpaySimplificado.services;

import com.picpaySimplificado.dtos.NotificacaoDTO;
import com.picpaySimplificado.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoService {
    @Autowired
    private RestTemplate restTemplate;

    public void remetNoficacao(Usuario usuario, String message) throws Exception {
        String email = usuario.getEmail();
        NotificacaoDTO notificacaoRequest = new NotificacaoDTO(email, message);

        System.out.println("Notificação enviada para o usuario");
        }

    }
