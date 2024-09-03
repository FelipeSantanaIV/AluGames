package br.com.felipe.utilitario

import br.com.felipe.modelo.Gamer
import br.com.felipe.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}