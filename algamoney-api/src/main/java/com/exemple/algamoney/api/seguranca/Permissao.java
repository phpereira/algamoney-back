package com.exemple.algamoney.api.seguranca;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "permissao")
class Permissao {

    @Id
    private Long codigo;
    private String descricao;

    Long getCodigo() {
        return codigo;
    }

    void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    String getDescricao() {
        return descricao;
    }

    void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permissao)) return false;
        Permissao permissao = (Permissao) o;
        return getCodigo().equals(permissao.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo());
    }
}
