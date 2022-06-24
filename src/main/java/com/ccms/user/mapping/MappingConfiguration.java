package com.ccms.user.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("musicianMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public MusicianMapper musicianMapper(){
        return new MusicianMapper();
    }
}
