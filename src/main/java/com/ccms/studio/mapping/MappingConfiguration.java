package com.ccms.studio.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("studioMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public StudioMapper studioMapper(){
        return new StudioMapper();
    }
}
