package br.com.felipe.principal

import br.com.felipe.dados.Banco
import br.com.felipe.dados.JogosDAO
import br.com.felipe.modelo.Jogo
import java.math.BigDecimal

fun main(){
    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogoDAO = JogosDAO()
    jogoDAO.adicionarJogo(jogo)

    val listaJogos: List<Jogo> = jogoDAO.getJogos()
    println(listaJogos)

}