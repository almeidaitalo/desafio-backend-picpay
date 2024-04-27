package com.picpaySimplificado.repositories;

import com.picpaySimplificado.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao,Long> {


}
