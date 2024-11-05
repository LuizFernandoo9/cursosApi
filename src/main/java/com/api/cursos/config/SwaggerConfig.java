package com.api.cursos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi(){
        
        return new OpenAPI().info(new Info()
        .title("API de cursos")
        .description("API para gestão de cursos")
        .version("1"));
    }
}