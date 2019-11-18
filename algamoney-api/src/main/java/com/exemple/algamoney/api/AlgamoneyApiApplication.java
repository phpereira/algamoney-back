package com.exemple.algamoney.api;

import com.exemple.algamoney.api.comum.AlgamoneyApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AlgamoneyApiProperty.class)
public class AlgamoneyApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlgamoneyApiApplication.class, args);
    }
}
