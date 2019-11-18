package com.exemple.algamoney.api.pessoa;

import com.exemple.algamoney.api.pessoa.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Page<Pessoa> findByNomeContaining(String nome, Pageable pageable);
}
