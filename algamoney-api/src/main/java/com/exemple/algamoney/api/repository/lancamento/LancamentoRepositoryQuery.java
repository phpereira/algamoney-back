package com.exemple.algamoney.api.repository.lancamento;

import com.exemple.algamoney.api.model.Lancamento;
import com.exemple.algamoney.api.repository.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {

    public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);

}
