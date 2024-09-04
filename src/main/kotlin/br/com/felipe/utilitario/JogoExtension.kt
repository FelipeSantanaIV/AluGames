package br.com.felipe.utilitario

import br.com.felipe.modelo.InfoJogoJson
import br.com.felipe.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo{
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}