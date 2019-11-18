package com.exemple.algamoney.api.lancamento;

import com.exemple.algamoney.api.lancamento.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
