import br.com.felipe.modelo.Gamer

fun main(){
    val gamer1 = Gamer("Felipe", "feliope@email.com")
    println(gamer1)

    val gamer2 = Gamer("Thuyanne", "thuyanne@email.com",
        "19/19/19", "thuy2404")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "Zeru"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
    gamer1.usuario = "Haha"
    println(gamer1)
}