package br.com.felipe.principal

import br.com.felipe.dados.AluguelDAO
import br.com.felipe.dados.Banco
import br.com.felipe.dados.GamersDAO
import br.com.felipe.dados.JogosDAO
import br.com.felipe.modelo.Periodo

fun main(){
    val manager = Banco.getEntityManager()
    val jogoDAO = JogosDAO(manager)
    val gamerDAO = GamersDAO(manager)
    val aluguelDAO = AluguelDAO(manager)

    val gamer = gamerDAO.recuperarPeloId(1)
    val jogo = jogoDAO.recuperarPeloId(3)
    val aluguel = gamer.alugaJogo(jogo, Periodo())

    aluguelDAO.adicionar(aluguel)

    val listaAluguel = aluguelDAO.getLista()
    println(listaAluguel)

    manager.close()
}