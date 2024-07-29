package com.temporintech.animalhaven.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI animalAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Animal Haven")
                        .description(
                                "A Animal Haven API fornece um conjunto de serviços para gerenciar abrigos, espécies, animais, médicos veterinários e vacinas. Esta API foi projetada para suportar operações CRUD"
                        )
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Cauâne Temporin")
                                .email("cauanetemporin.ti@gmail.com").url("https://github.com/CauaneTemporin")
                        )
                );
    }
}
