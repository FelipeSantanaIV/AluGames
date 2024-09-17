package br.com.felipe.utilitario

import br.com.felipe.dados.JogoEntity
import br.com.felipe.modelo.InfoJogoJson
import br.com.felipe.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo{
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}

fun Jogo.toEntity(): JogoEntity {
    return JogoEntity(this.titulo, this.capa, this.preco, this.descricao, this.id)
}

fun JogoEntity.toModel(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao, this.id)
}