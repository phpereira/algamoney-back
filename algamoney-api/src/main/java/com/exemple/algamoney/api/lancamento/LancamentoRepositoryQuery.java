package com.exemple.algamoney.api.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

interface LancamentoRepositoryQuery {

    Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
    Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);

}
