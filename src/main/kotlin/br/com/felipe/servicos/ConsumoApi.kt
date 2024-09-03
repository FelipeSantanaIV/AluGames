package br.com.felipe.servicos

import br.com.felipe.modelo.InfoApiShark
import br.com.felipe.modelo.InfoJogo
import br.com.felipe.modelo.Jogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

    fun buscaJogo(id: String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request: HttpRequest = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

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
}