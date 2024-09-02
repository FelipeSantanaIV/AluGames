package br.com.felipe

data class Jogo (val titulo:String,
            val capa:String ) {

    val descricacao = ""

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricacao: $descricacao"
    }

}