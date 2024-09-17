package br.com.felipe.dados

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "gamers")
class GamerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    val nome: String = "Nome do gamer",
    val email: String = "email@email.com",
    val dataNascimento: String? = null,
    val usuario:String? = null
) {
}