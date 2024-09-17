package br.com.felipe.dados

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object Banco {
//    fun obterConexao(): Connection? {
//
//        val user: String? = System.getenv("DB_USER")
//        val password: String? = System.getenv("DB_PASSWORD")
//
//        return try {
//            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", user, password)
//        } catch (e: SQLException) {
//            e.printStackTrace()
//            null
//        }
//    }

    fun getEntityManager(): EntityManager{
        val factory: EntityManagerFactory = Persistence.createEntityManagerFactory("alugames", mapOf(
            "javax.persistence.jdbc.user" to System.getenv("DB_USER"),
            "javax.persistence.jdbc.password" to System.getenv("DB_PASSWORD")
        ))
        return factory.createEntityManager()
    }
}