package com.jumbotail.shipping.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI shippingApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Shipping Charge API")
                        .description("API for calculating shipping charges using Haversine formula and strategy pattern")
                        .version("1.0"));
    }
}