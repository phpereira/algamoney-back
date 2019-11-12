package com.exemple.algamoney.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager; //Gerencia a autenticação

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                        //usuário do cliente
                        .withClient("angular")
                        //senha do cliente
                        .secret("@ngul@r0")
                        //escopo de leitura e escrita
                        .scopes("read", "write")
                        //password flow
                        .authorizedGrantTypes("password", "refresh_token")
                        //tempo de uso do token
                        .accessTokenValiditySeconds(1800)
                        //tempo de uso do refresh token (24horas)
                        .refreshTokenValiditySeconds(3600*24)
                .and()
                        //usuário do cliente
                        .withClient("mobile")
                        //senha do cliente
                        .secret("m0b1l30")
                        //escopo de leitura e escrita
                        .scopes("read")
                        //password flow
                        .authorizedGrantTypes("password", "refresh_token")
                        //tempo de uso do token
                        .accessTokenValiditySeconds(1800)
                        //tempo de uso do refresh token (24horas)
                        .refreshTokenValiditySeconds(3600*24);

    }


    //configuração de endpoint
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore()) //onde está armazenado o token
                .accessTokenConverter(accessTokenConverter())
                .reuseRefreshTokens(false) //sempre que pedir que um novo access token via refresh token, um novo refresh token será enviado, com o intuito dele não se deslogar.
                .authenticationManager(authenticationManager); //quem vai validar o usuário e senha
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("algaworks");
        return accessTokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());


        // return new InMemoryTokenStore(); //token armazenado em memomry
    }


}
