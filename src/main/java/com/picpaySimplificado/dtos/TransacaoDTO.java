package com.picpaySimplificado.dtos;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal value,Long remetenteId, Long receptorId) {

}
