package com.pizzeria.api_pizzeria.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Pizzería")
                        .description("Documentación centralizada de la API para el sistema de gestión de la Pizzería")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Desarrollo Backend Pizzería")
                                .email("dev@pizzeria.com"))
                        .license(new License()
                                .name("Licencia Interna")
                                .url("https://tupizzeria.com/license")))
                .servers(List.of(
                        new Server().url("/").description("Servidor Dinámico (Local / Render)")
                ));
    }
}