package com.rocket.healingpets.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(version="v1")
)

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi chatOpenApi(){
        String[] paths = {"/api/v1/**","/auth/**","/test/**"};
        return GroupedOpenApi.builder()
                .group("api-v1")
                .pathsToMatch(paths)
                .build();
    }
}
