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

        ResponseEntity<String> notificacaoResponse = restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", notificacaoRequest, String.class);
        System.out.println("Erro ao enviar a notificação");
        if (!(notificacaoResponse.getStatusCode() == HttpStatus.OK)) {
            throw new Exception(" Serviço de notificação está fora do ar ");
        }

    }
}
