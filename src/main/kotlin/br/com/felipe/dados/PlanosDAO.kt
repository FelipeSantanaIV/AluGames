package br.com.felipe.dados

import br.com.felipe.modelo.Plano
import br.com.felipe.modelo.PlanoAssinatura
import br.com.felipe.modelo.PlanoAvulso
import br.com.felipe.utilitario.toEntity
import br.com.felipe.utilitario.toModel
import javax.persistence.EntityManager

class PlanosDAO(manager: EntityManager): DAO<Plano, PlanoEntity>(manager, PlanoEntity::class.java) {

    override fun toEntity(plano: Plano): PlanoEntity {
        return plano.toEntity()
    }

    override fun toModel(entity: PlanoEntity): Plano {
        return entity.toModel()
    }
}