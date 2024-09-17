package br.com.felipe.dados

import br.com.felipe.modelo.Jogo
import br.com.felipe.utilitario.toEntity
import br.com.felipe.utilitario.toModel
import javax.persistence.EntityManager

class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    override fun toEntity(objeto: Jogo): JogoEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: JogoEntity): Jogo {
        return entity.toModel()
    }



}