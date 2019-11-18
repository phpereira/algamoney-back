package com.exemple.algamoney.api.lancamento;

import com.exemple.algamoney.api.lancamento.Lancamento;
import com.exemple.algamoney.api.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
}

