package br.com.felipe.principal

import br.com.felipe.modelo.Periodo
import br.com.felipe.modelo.PlanoAssinatura
import br.com.felipe.servicos.ConsumoApi
import java.time.LocalDate

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogoJson = consumo.buscaJogosJson()

//    println(listaGamers)
//    println(listaJogoJson)

    val gamerAna = listaGamers.get(1)
    val jogoResidentEvilVillage = listaJogoJson.get(10)
    val jogoSpider = listaJogoJson.get(13)
    val jogoTheLastOfUs = listaJogoJson.get(2)

//    println(gamerAna)
//    println(jogoResidentEvilVillage)


    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))
    val periodo4 = Periodo(LocalDate.of(2024,8,2), LocalDate.of(2024,8,15))

    gamerAna.alugaJogo(jogoResidentEvilVillage, periodo)
    gamerAna.alugaJogo(jogoSpider, periodo1)
    gamerAna.alugaJogo(jogoTheLastOfUs, periodo2)
    gamerAna.alugaJogo(jogoSpider, periodo4)

    println(gamerAna.jogoAlugados)
//    println(gamerAna.jogosDoMes(9))

    val gamerCamila  = listaGamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, 0.15)

    gamerCamila.alugaJogo(jogoResidentEvilVillage, periodo)
    gamerCamila.alugaJogo(jogoSpider, periodo1)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo2)
    println(gamerCamila.jogoAlugados)

    gamerCamila.recomendar(0)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    println(gamerCamila)

    gamerCamila.alugaJogo(jogoResidentEvilVillage, periodo)
    println(gamerCamila.jogoAlugados)
}