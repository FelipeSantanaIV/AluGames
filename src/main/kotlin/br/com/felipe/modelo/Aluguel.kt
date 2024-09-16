package br.com.felipe.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer:Gamer,
    val jogo:Jogo,
    val periodo: Periodo) {

    val valorDoAlugel = gamer.plano.obterValor(this)
    override fun toString(): String {
        return "Aluguel do ${jogo.titulo} por ${gamer.nome}, pelo valor de R$${"%.2f".format(valorDoAlugel)}"
    }
}
