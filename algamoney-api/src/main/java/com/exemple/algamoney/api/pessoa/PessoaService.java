package com.exemple.algamoney.api.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    public Pessoa buscarPessoaPeloCodigo(Long codigo) {
       return pessoaRepository.findOne(codigo);
    }
}
