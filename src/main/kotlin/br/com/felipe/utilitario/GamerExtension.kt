package br.com.felipe.utilitario

import br.com.felipe.dados.GamerEntity
import br.com.felipe.modelo.Gamer
import br.com.felipe.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(this.id, this.nome, this.email, this.dataNascimento, this.usuario, this.plano.toEntity())
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}