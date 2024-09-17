package br.com.felipe.utilitario

import br.com.felipe.dados.PlanoAssinaturaEntity
import br.com.felipe.dados.PlanoAvulsoEntity
import br.com.felipe.dados.PlanoEntity
import br.com.felipe.modelo.Plano
import br.com.felipe.modelo.PlanoAssinatura
import br.com.felipe.modelo.PlanoAvulso

fun Plano.toEntity(): PlanoEntity{
    return if (this is PlanoAssinatura) {
        PlanoAssinaturaEntity(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}

fun PlanoEntity.toModel(): Plano{
    return if(this is PlanoAssinaturaEntity) {
        PlanoAssinatura(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao, this.id)
    } else {
        PlanoAvulso(this.tipo, this.id)
    }
}