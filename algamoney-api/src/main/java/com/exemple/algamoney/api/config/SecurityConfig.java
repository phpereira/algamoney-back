package com.exemple.algamoney.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration //Não é necessário
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ROLE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/categorias").permitAll() //Qualquer um pode acessar /categorias sem autenticação
                    .anyRequest().authenticated() //Todos precisam estar autenticados
                .and()
                    .httpBasic() //tipo de autenticação
                .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //não mantem estado de sessão
                .and()
                    .csrf().disable(); //Desabilitado para javascript injection para um serviço web
    }
}
