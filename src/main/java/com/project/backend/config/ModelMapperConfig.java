package com.project.backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ModelMapperConfig {
    @Bean
    ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setAmbiguityIgnored(false)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);

        return modelMapper;
    }
}