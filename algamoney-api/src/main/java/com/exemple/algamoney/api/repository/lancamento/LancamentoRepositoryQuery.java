package com.exemple.algamoney.api.repository.lancamento;

import com.exemple.algamoney.api.model.Lancamento;
import com.exemple.algamoney.api.repository.filter.LancamentoFilter;

import java.util.List;

public interface LancamentoRepositoryQuery {

    public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);

}
