package br.com.felipe.dados

import br.com.felipe.modelo.Jogo
import java.math.BigDecimal
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
    fun obterConexao(): Connection? {

        val user: String? = System.getenv("DB_USER")
        val password: String? = System.getenv("DB_PASSWORD")

        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}