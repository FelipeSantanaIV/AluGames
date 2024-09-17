package br.com.felipe.principal

import br.com.felipe.dados.Banco
import br.com.felipe.dados.GamersDAO
import br.com.felipe.dados.PlanosDAO
import br.com.felipe.modelo.Gamer

fun main(){
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Banco.getEntityManager()
    val gamerDAO = GamersDAO(manager)
    val planosDAO = PlanosDAO(manager)
    gamer.plano = planosDAO.recuperarPeloId(3)

    gamerDAO.adicionar(gamer)

    val listaGamersBanco = gamerDAO.getLista()
    println(listaGamersBanco)

    manager.close()
}