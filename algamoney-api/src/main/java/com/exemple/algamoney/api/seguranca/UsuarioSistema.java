package com.exemple.algamoney.api.seguranca;


import com.exemple.algamoney.api.seguranca.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

class UsuarioSistema extends User {

    private static final long serialVersionUID = 1L;

    private Usuario usuario;

    UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        super(usuario.getEmail(), usuario.getSenha(), authorities);
        this.usuario = usuario;
    }

    Usuario getUsuario() {
        return usuario;
    }

}