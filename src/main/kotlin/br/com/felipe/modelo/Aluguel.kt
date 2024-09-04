package br.com.felipe.modelo

data class Aluguel(
    val gamer:Gamer,
    val jogo:Jogo) {


    override fun toString(): String {
        return "Aluguel do $jogo por $gamer"
    }
}
