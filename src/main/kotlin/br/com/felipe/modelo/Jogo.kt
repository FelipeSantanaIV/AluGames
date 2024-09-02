package br.com.felipe.modelo

data class Jogo (val titulo:String,
            val capa:String ) {

    var descricao:String? = null

    override fun toString(): String {
        return "Meu jogo: \n" +
                "Titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricacao: $descricao"
    }

}