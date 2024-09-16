package br.com.felipe.modelo

import com.google.gson.annotations.Expose
import java.math.BigDecimal

data class Jogo (@Expose val titulo:String,
            @Expose val capa:String ): Recomendavel {

    var descricao:String? = null
    var preco = BigDecimal("0.0")
    private val listaNotas = mutableListOf<Int>()
    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }


    constructor(titulo: String, capa: String, preco:BigDecimal, descricao:String) :
            this(titulo, capa){
                this.preco = preco
                this.descricao = descricao
            }
    override fun toString(): String {
        return "Meu jogo: \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Preço: ${"%.2f".format(preco)} \n" +
                "Descricacao: $descricao\n" +
                "Reputação: $media"

    }

}