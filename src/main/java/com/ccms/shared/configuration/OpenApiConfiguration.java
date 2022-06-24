package com.ccms.shared.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenApi(
            @Value("@project.description@") String applicationDescription,
            @Value("@project.version@") String applicationVersion){
        return new OpenAPI()
                .info(new Info()
                        .title("OPENGROUP CCMS API")
                        .version(applicationVersion)
                        .description(applicationDescription)
                        .termsOfService("https://opengroup-ccms.com/tos")
                        .license(new License().name("Apache 2.0 License").url("https://opengroup-ccms.com/license"))
                        .contact(new Contact()
                                .url("https://opengroup.studio")
                                .name("OPENGROUP.studio")));
    }
}
