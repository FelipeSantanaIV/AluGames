package br.com.felipe.principal

import br.com.felipe.modelo.Jogo
import br.com.felipe.servicos.ConsumoApi
import java.util.Scanner

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar: ")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()

    val infoJogo = buscaApi.buscaJogo(busca)



    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(
            infoJogo.info.title,
            infoJogo.info.thumb
        )

        println(meuJogo)
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("s", true)) {
            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }

        println("Descrição atual: ${meuJogo?.descricao}")
        println(meuJogo)
    }
}