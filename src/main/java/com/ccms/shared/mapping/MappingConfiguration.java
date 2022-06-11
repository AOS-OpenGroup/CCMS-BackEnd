package com.ccms.shared.mapping;

import com.ccms.user.mapping.MusicianMapper;
import com.ccms.studio.mapping.StudioMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public StudioMapper studioMapper() {
        return new StudioMapper();
    }
    @Bean
    public MusicianMapper musicianMapper() {
        return new MusicianMapper();
    }
}