package com.exemple.algamoney.api.seguranca;

import com.exemple.algamoney.api.seguranca.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}
