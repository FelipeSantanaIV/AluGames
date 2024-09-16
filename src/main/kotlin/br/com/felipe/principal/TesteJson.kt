package br.com.felipe.principal

import br.com.felipe.modelo.Periodo
import br.com.felipe.modelo.PlanoAssinatura
import br.com.felipe.servicos.ConsumoApi
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal
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
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3, BigDecimal("0.15"))

    gamerCamila.alugaJogo(jogoResidentEvilVillage, periodo)
    gamerCamila.alugaJogo(jogoSpider, periodo1)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo2)
//    println(gamerCamila.jogoAlugados)

    gamerCamila.recomendar(8)
    gamerCamila.recomendar(10)
    gamerCamila.recomendar(8)
    println(gamerCamila)

    gamerCamila.alugaJogo(jogoResidentEvilVillage, periodo)
    println(gamerCamila.jogoAlugados)

    gamerCamila.recomendarJogo(jogoResidentEvilVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)

    gamerAna.recomendarJogo(jogoResidentEvilVillage, 8)
    gamerAna.recomendarJogo(jogoTheLastOfUs, 9)

    println("Recomendações da Camila: ")
    println(gamerCamila.jogosRecomendados)

    println("------------------------------------------------------------")

    println("Recomendações da Ana: ")
    println(gamerAna.jogosRecomendados)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)
    val jogoDandara = listaJogoJson.get(5)
    val jogoAssassins = listaJogoJson.get(4)
    val jogoCyber = listaJogoJson.get(6)
    val jogoGod = listaJogoJson.get(7)
    val jogoSkyrim = listaJogoJson.get(18)

    gamerCamila.recomendarJogo(jogoResidentVillage, 7)
    gamerCamila.recomendarJogo(jogoTheLastOfUs, 10)
    gamerCamila.recomendarJogo(jogoAssassins, 8)
    gamerCamila.recomendarJogo(jogoCyber, 7)
    gamerCamila.recomendarJogo(jogoGod, 10)
    gamerCamila.recomendarJogo(jogoDandara, 8)
    gamerCamila.recomendarJogo(jogoSkyrim, 8)
    gamerCamila.recomendarJogo(jogoSpider, 6)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializacao = gson.toJson(gamerCamila.jogosRecomendados)
    println(serializacao)

    val arquivo = File("jogosRecomendados-${gamerCamila.nome}.json")
    arquivo.writeText(serializacao)
    println(arquivo.absolutePath)
}