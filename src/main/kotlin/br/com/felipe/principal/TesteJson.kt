package br.com.felipe.principal

import br.com.felipe.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()

    println(listaGamers)
}