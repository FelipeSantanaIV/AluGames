package br.com.felipe.utilitario

import br.com.felipe.modelo.InfoJogoJson
import br.com.felipe.modelo.Jogo
import java.math.BigDecimal

fun InfoJogoJson.criaJogo(): Jogo{
    return Jogo(this.titulo, this.capa, BigDecimal(this.preco), this.descricao)
}