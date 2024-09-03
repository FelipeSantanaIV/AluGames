package br.com.felipe.servicos

import br.com.felipe.modelo.*
import br.com.felipe.utilitario.criaGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    private fun consomeDados(endereco:String): String{
        val client: HttpClient = HttpClient.newHttpClient()
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun buscaJogo(id: String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = consomeDados(endereco)

        val gson = Gson()

        val resultado = runCatching {
            gson.fromJson(json, InfoJogo::class.java)
        }

        return resultado.getOrElse {
            println("Jogo inexistente ou erro ao processar a resposta. Tente outro id.")
            InfoJogo(
               info = InfoApiShark(
                   title = "Jogo não encontrado",
                   thumb = ""
               )
            )
        }

    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consomeDados(endereco)

        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>(){}.type
        val listaGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map { infoGamerJson -> infoGamerJson.criaGamer() }

        return listaGamerConvertida

    }
}