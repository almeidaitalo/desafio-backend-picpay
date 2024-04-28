package com.picpaySimplificado.services;


import com.picpaySimplificado.dtos.TransacaoDTO;
import com.picpaySimplificado.model.Transacao;
import com.picpaySimplificado.model.Usuario;
import com.picpaySimplificado.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransacaoServices {
   @Autowired
   private UsuarioServices usuarioServices;
   private RestTemplate restTemplate;
   @Autowired
   private TransacaoRepository repository;

   public void createTransacao(TransacaoDTO transacaoDTO) throws Exception {
       Usuario remetente = this.usuarioServices.findUsuarioById(transacaoDTO.remetenteId());
       Usuario receptor = this.usuarioServices.findUsuarioById(transacaoDTO.receptorId());
       usuarioServices.validarTransacao(remetente, transacaoDTO.value());

       boolean isAuthorized = this.authorozeTransaction(remetente, transacaoDTO.value());
       if(!isAuthorized){
           throw new Exception("Transação não autorizada");
       }
       Transacao transacao = new Transacao();
       transacao.setValor(transacaoDTO.value());
       transacao.setRemetente(remetente);
       transacao.setRecptor(receptor);
       transacao.setTimestamp(LocalDateTime.now());

       remetente.setSaldo(remetente.getSaldo().subtract(transacaoDTO.value()));
       receptor.setSaldo(receptor.getSaldo().add(transacaoDTO.value()));

       this.repository.save(transacao);
       this.usuarioServices.salveUsuario(remetente);
       this.usuarioServices.salveUsuario(receptor);
   }
   public boolean authorozeTransaction(Usuario remetente, BigDecimal value){
   ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);

         if(authorizationResponse.getStatusCode() == HttpStatus.OK ) {
             String message = (String) authorizationResponse.getBody().get("message");
              return "Autorizado".equalsIgnoreCase(message);
         } else return false;

   }
}
