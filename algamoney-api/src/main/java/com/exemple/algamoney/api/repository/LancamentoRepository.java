package com.exemple.algamoney.api.repository;

import com.exemple.algamoney.api.model.Lancamento;
import com.exemple.algamoney.api.repository.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}

